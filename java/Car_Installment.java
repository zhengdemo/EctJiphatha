import java.util.Scanner;

public class Car_Installment {
    Scanner sc = new Scanner(System.in);
    double carprice = 0, dp = 0,downpay = 0, inperm = 0,intrate = 0, finance = 0, net = 0, intamo = 0, moninstall = 0;
    int month = 0;
    boolean working = true;
    public double getprice(){
        System.out.print("Enter car price : ");
        double price = sc.nextDouble();
        return price;
    }
    public double getDownPayment(){
        System.out.print("Enter down payment(%) : ");
        double dp = sc.nextDouble();
        return dp;
    }
    public double getInterestRate(){
        System.out.print("Enter interest rate(%) per year : ");
        double inr = sc.nextDouble();
        return inr;
    }
    public int getMonth(){
        System.out.print("Enter month : ");
        int mon = sc.nextInt();
        return mon;
    }
    public void showInstallment(){
        dp = carprice * (downpay/100);
        finance = carprice - dp;
        inperm = intrate/12;
        intamo = finance * (inperm/100)*month;
        net = finance + intamo;
        System.out.printf("Price car : %,.2f", carprice);
        System.out.printf("\nAmount down payment(%,.2f%%) : %,.2f\n", downpay, dp);
        System.out.printf("Amount finance : %,.2f\n", finance);
        System.out.printf("Amount interest(%,.2f%%) : %,.2f\n", intrate, intamo);
        System.out.printf("Amount net finance : %,.2f\n", net);
        System.out.printf("Amount installment(per month) : %.2f\n", net / month);
    }
    public void clearData(){
        carprice = 0; dp = 0;downpay = 0; inperm = 0;intrate = 0; finance = 0; net = 0; intamo = 0; moninstall = 0; month = 0;
    }
    public void start(){
        while(working){
            System.out.println(">>>   Main Menu   <<<");
            System.out.println("=====================");
            System.out.println("0. Exit Program");
            System.out.printf("1. Input Car Price (%,.2f)\n", carprice);
            System.out.printf("2. Input Down Payment (%,.2f%%)\n", downpay);
            System.out.printf("3. Input Interest Rate [Per Year] (%,.2f%%)\n", intrate);
            System.out.printf("4. Input Month Number (%d)\n", month);
            System.out.printf("5. Display Installment\n");
            System.out.printf("6. Clear All Data\n");
            System.out.print("Select choice : ");
            int cm = sc.nextInt();
            switch (cm) {
                case 0:
                    working = false;
                    break;
                case 1 :
                    carprice = getprice();
                    break;
                case 2 :
                    downpay = getDownPayment();
                    break;
                case 3 :
                    intrate = getInterestRate();
                    break;
                case 4 :
                    month = getMonth();
                    break;
                case 5 :
                    showInstallment();
                    break;
                case 6 :
                    clearData();
                    break;
                default:
                    break;
            }
        }
    }
    
    public static void main(String[] args) {
        Car_Installment car = new Car_Installment();
        car.start();
    }
}
