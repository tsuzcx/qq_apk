package com.tencent.mobileqq.qqfloatingwindow;

import com.tencent.mobileqq.statistics.ReportController;

public class FloatingScreenReporter
{
  private static int a;
  private static long b;
  
  public static int a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if ((paramInt != 1000) && (paramInt != 1004) && (paramInt != 1020))
        {
          if (paramInt != 3000) {
            return paramInt;
          }
          return 4;
        }
        return 3;
      }
      return 2;
    }
    return 1;
  }
  
  public static void a()
  {
    b = System.currentTimeMillis();
  }
  
  public static void b()
  {
    ReportController.b(null, "dc00898", "", "", "0X800A494", "0X800A494", 0, 0, "", "", "", "");
  }
  
  public static void b(int paramInt)
  {
    ReportController.b(null, "dc00898", "", "", "0X800A496", "0X800A496", paramInt, 0, String.valueOf(paramInt), "", "", "");
  }
  
  public static void c()
  {
    ReportController.b(null, "dc00898", "", "", "0X800A495", "0X800A495", 0, 0, "", "", "", "");
  }
  
  public static void c(int paramInt)
  {
    a = paramInt;
    ReportController.b(null, "dc00898", "", "", "0X800A20B", "0X800A20B", paramInt, 0, String.valueOf(paramInt), "", "", "");
  }
  
  public static void d()
  {
    ReportController.b(null, "dc00898", "", "", "0X800A20C", "0X800A20C", 0, 0, "", "", "", "");
    e(1);
  }
  
  public static void d(int paramInt)
  {
    ReportController.b(null, "dc00898", "", "", "0X800A87C", "0X800A87C", a, 0, String.valueOf(paramInt / 1000), "", "", "");
  }
  
  public static void e()
  {
    ReportController.b(null, "dc00898", "", "", "0X800A20D", "0X800A20D", 0, 0, "", "", "", "");
    e(2);
    a();
  }
  
  public static void e(int paramInt)
  {
    if (b == 0L) {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = b;
    b = 0L;
    ReportController.b(null, "dc00898", "", "", "0X800A87D", "0X800A87D", paramInt, 0, String.valueOf((l1 - l2) / 1000L), "", "", "");
  }
  
  public static void f()
  {
    ReportController.b(null, "dc00898", "", "", "0X800A20E", "0X800A20E", 0, 0, "", "", "", "");
    f(2);
    a();
  }
  
  public static void f(int paramInt)
  {
    if (b == 0L) {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = b;
    b = 0L;
    ReportController.b(null, "dc00898", "", "", "0X800A87E", "0X800A87E", paramInt, 0, String.valueOf((l1 - l2) / 1000L), "", "", "");
  }
  
  public static void g()
  {
    ReportController.b(null, "dc00898", "", "", "0X800A20F", "0X800A20F", 0, 0, "", "", "", "");
    f(1);
  }
  
  public static void h()
  {
    ReportController.b(null, "dc00898", "", "", "0X800A210", "0X800A210", 0, 0, "", "", "", "");
  }
  
  public static void i()
  {
    ReportController.b(null, "dc00898", "", "", "0X800A87F", "0X800A87F", a, 0, "", "", "", "");
  }
  
  public static void j()
  {
    ReportController.b(null, "dc00898", "", "", "0X800A880", "0X800A880", a, 0, "", "", "", "");
  }
  
  public static void k()
  {
    ReportController.b(null, "dc00898", "", "", "0X800A881", "0X800A881", a, 0, "", "", "", "");
    f(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqfloatingwindow.FloatingScreenReporter
 * JD-Core Version:    0.7.0.1
 */