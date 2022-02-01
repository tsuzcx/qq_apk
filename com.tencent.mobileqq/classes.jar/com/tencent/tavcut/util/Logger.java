package com.tencent.tavcut.util;

import android.util.Log;

public class Logger
{
  private static final boolean ENABLE_LOG = true;
  private static final String TAG = Logger.class.getSimpleName();
  
  public static void d(String paramString1, String paramString2)
  {
    Log.d(paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    Log.e(paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.e(TAG, paramThrowable.toString(), paramThrowable);
  }
  
  public static void e(Throwable paramThrowable)
  {
    e(TAG, paramThrowable.toString(), paramThrowable);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    Log.w(paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    Log.w(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.util.Logger
 * JD-Core Version:    0.7.0.1
 */