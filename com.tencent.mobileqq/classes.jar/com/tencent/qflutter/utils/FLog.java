package com.tencent.qflutter.utils;

public class FLog
{
  public static final String TAG = "QFlutter";
  public static FLog.Log sLog = new FLogDefaultImpl();
  
  public static void d(String paramString1, String paramString2)
  {
    sLog.d(paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    sLog.e(paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    sLog.e(paramString1, paramString2, paramThrowable);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    sLog.i(paramString1, paramString2);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    sLog.v(paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    sLog.w(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qflutter.utils.FLog
 * JD-Core Version:    0.7.0.1
 */