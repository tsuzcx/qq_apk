package com.tencent.xaction.log;

import android.util.Log;

public class QLog
{
  public static boolean a = false;
  private static IQLog b;
  
  public static void a(IQLog paramIQLog)
  {
    b = paramIQLog;
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    d(paramString1, paramInt, paramString2, null);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    IQLog localIQLog = b;
    if (localIQLog != null)
    {
      localIQLog.a(6, paramString1, paramInt, paramString2, paramThrowable);
      return;
    }
    if (a) {
      Log.e(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void b(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    IQLog localIQLog = b;
    if (localIQLog != null)
    {
      localIQLog.a(5, paramString1, paramInt, paramString2, paramThrowable);
      return;
    }
    if (a) {
      Log.w(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void c(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    IQLog localIQLog = b;
    if (localIQLog != null)
    {
      localIQLog.a(4, paramString1, paramInt, paramString2, paramThrowable);
      return;
    }
    if (a) {
      Log.i(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void d(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    IQLog localIQLog = b;
    if (localIQLog != null)
    {
      localIQLog.a(3, paramString1, paramInt, paramString2, paramThrowable);
      return;
    }
    if (a) {
      Log.d(paramString1, paramString2, paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.log.QLog
 * JD-Core Version:    0.7.0.1
 */