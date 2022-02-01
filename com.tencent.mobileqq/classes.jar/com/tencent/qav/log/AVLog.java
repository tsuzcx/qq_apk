package com.tencent.qav.log;

public class AVLog
{
  private static AVLogBase a = new AVLogBase();
  
  public static void a(AVLogBase paramAVLogBase)
  {
    if (paramAVLogBase != null)
    {
      a = paramAVLogBase;
      return;
    }
    a = new AVLogBase();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a.a(paramString1, paramString2);
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a.a(paramString1, paramString2, paramThrowable);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    a.b(paramString1, paramString2);
  }
  
  public static void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a.b(paramString1, paramString2, paramThrowable);
  }
  
  public static void c(String paramString1, String paramString2)
  {
    a.c(paramString1, paramString2);
  }
  
  public static void c(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a.c(paramString1, paramString2, paramThrowable);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    a.d(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qav.log.AVLog
 * JD-Core Version:    0.7.0.1
 */