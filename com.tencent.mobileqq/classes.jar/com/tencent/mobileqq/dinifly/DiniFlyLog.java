package com.tencent.mobileqq.dinifly;

import android.util.Log;

public class DiniFlyLog
{
  public static final int CLR = 2;
  public static boolean DEBUG = false;
  public static final int DEV = 4;
  public static final int USR = 1;
  private static IDiniFlyQLog mLog;
  
  public static void d(String paramString1, int paramInt, String paramString2)
  {
    d(paramString1, paramInt, paramString2, null);
  }
  
  public static void d(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    if (mLog != null) {
      mLog.trace(3, paramString1, paramInt, paramString2, paramThrowable);
    }
    while (!DEBUG) {
      return;
    }
    Log.d(paramString1, paramString2, paramThrowable);
  }
  
  public static void e(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    if (mLog != null) {
      mLog.trace(6, paramString1, paramInt, paramString2, paramThrowable);
    }
    while (!DEBUG) {
      return;
    }
    Log.e(paramString1, paramString2, paramThrowable);
  }
  
  public static void i(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    if (mLog != null) {
      mLog.trace(4, paramString1, paramInt, paramString2, paramThrowable);
    }
    while (!DEBUG) {
      return;
    }
    Log.i(paramString1, paramString2, paramThrowable);
  }
  
  public static void setLog(IDiniFlyQLog paramIDiniFlyQLog)
  {
    mLog = paramIDiniFlyQLog;
  }
  
  public static void w(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    if (mLog != null) {
      mLog.trace(5, paramString1, paramInt, paramString2, paramThrowable);
    }
    while (!DEBUG) {
      return;
    }
    Log.w(paramString1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.DiniFlyLog
 * JD-Core Version:    0.7.0.1
 */