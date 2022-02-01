package com.vivo.push.util;

import android.content.Context;

public final class o
{
  public static final n a = new m();
  private static boolean b;
  private static boolean c;
  
  static
  {
    b();
  }
  
  public static int a(String paramString1, String paramString2)
  {
    return a.a(paramString1, paramString2);
  }
  
  public static int a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return a.a(paramString1, paramString2, paramThrowable);
  }
  
  public static int a(String paramString, Throwable paramThrowable)
  {
    return a.a(paramString, paramThrowable);
  }
  
  public static String a(Throwable paramThrowable)
  {
    return a.a(paramThrowable);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    a.a(paramContext, paramString);
  }
  
  public static void a(boolean paramBoolean)
  {
    b();
    c = paramBoolean;
  }
  
  public static boolean a()
  {
    return b;
  }
  
  public static int b(String paramString1, String paramString2)
  {
    return a.b(paramString1, paramString2);
  }
  
  public static int b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return a.b(paramString1, paramString2, paramThrowable);
  }
  
  private static void b()
  {
    b = z.b("persist.sys.log.ctrl", "no").equals("yes");
  }
  
  public static void b(Context paramContext, String paramString)
  {
    a.b(paramContext, paramString);
  }
  
  public static int c(String paramString1, String paramString2)
  {
    return a.c(paramString1, paramString2);
  }
  
  public static void c(Context paramContext, String paramString)
  {
    a.c(paramContext, paramString);
  }
  
  public static int d(String paramString1, String paramString2)
  {
    return a.d(paramString1, paramString2);
  }
  
  public static int e(String paramString1, String paramString2)
  {
    return a.e(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.util.o
 * JD-Core Version:    0.7.0.1
 */