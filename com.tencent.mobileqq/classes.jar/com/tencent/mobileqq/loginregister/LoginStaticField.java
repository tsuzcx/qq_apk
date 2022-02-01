package com.tencent.mobileqq.loginregister;

public class LoginStaticField
{
  public static int a;
  public static long b;
  public static LoginSuccDialogMessage c;
  
  public static int a()
  {
    return a;
  }
  
  public static void a(int paramInt)
  {
    a = paramInt;
  }
  
  public static void a(LoginSuccDialogMessage paramLoginSuccDialogMessage)
  {
    c = paramLoginSuccDialogMessage;
  }
  
  public static LoginSuccDialogMessage b()
  {
    return c;
  }
  
  public static void c()
  {
    c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.LoginStaticField
 * JD-Core Version:    0.7.0.1
 */