package com.tencent.weiyun.utils;

import android.util.Log;

public class WyLog
{
  private static final String GLOBAL_TAG = "Weiyun_Cmd";
  private static ILog sLog;
  
  public static void d(String paramString)
  {
    d("Weiyun_Cmd", paramString, null);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    d(paramString1, paramString2, null);
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (2 >= getLogLevel())
    {
      if (sLog != null) {
        sLog.d(paramString1, paramString2, paramThrowable);
      }
    }
    else {
      return;
    }
    Log.d(paramString1, paramString2, paramThrowable);
  }
  
  public static void d(String paramString, Throwable paramThrowable)
  {
    d("Weiyun_Cmd", paramString, paramThrowable);
  }
  
  public static void e(String paramString)
  {
    e("Weiyun_Cmd", paramString, null);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    e(paramString1, paramString2, null);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (5 >= getLogLevel())
    {
      if (sLog != null) {
        sLog.e(paramString1, paramString2, paramThrowable);
      }
    }
    else {
      return;
    }
    Log.e(paramString1, paramString2, paramThrowable);
  }
  
  public static void e(String paramString, Throwable paramThrowable)
  {
    e("Weiyun_Cmd", paramString, paramThrowable);
  }
  
  private static int getLogLevel()
  {
    if (sLog != null) {
      return sLog.getLogLevel();
    }
    return 1;
  }
  
  public static void i(String paramString)
  {
    i("Weiyun_Cmd", paramString, null);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    i(paramString1, paramString2, null);
  }
  
  public static void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (3 >= getLogLevel())
    {
      if (sLog != null) {
        sLog.i(paramString1, paramString2, paramThrowable);
      }
    }
    else {
      return;
    }
    Log.i(paramString1, paramString2, paramThrowable);
  }
  
  public static void i(String paramString, Throwable paramThrowable)
  {
    i("Weiyun_Cmd", paramString, paramThrowable);
  }
  
  public static void setLog(ILog paramILog)
  {
    sLog = paramILog;
  }
  
  public static void v(String paramString)
  {
    v("Weiyun_Cmd", paramString, null);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    v(paramString1, paramString2, null);
  }
  
  public static void v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (1 >= getLogLevel())
    {
      if (sLog != null) {
        sLog.v(paramString1, paramString2, paramThrowable);
      }
    }
    else {
      return;
    }
    Log.v(paramString1, paramString2, paramThrowable);
  }
  
  public static void v(String paramString, Throwable paramThrowable)
  {
    v("Weiyun_Cmd", paramString, paramThrowable);
  }
  
  public static void w(String paramString)
  {
    w("Weiyun_Cmd", paramString, null);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    w(paramString1, paramString2, null);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (4 >= getLogLevel())
    {
      if (sLog != null) {
        sLog.w(paramString1, paramString2, paramThrowable);
      }
    }
    else {
      return;
    }
    Log.w(paramString1, paramString2, paramThrowable);
  }
  
  public static void w(String paramString, Throwable paramThrowable)
  {
    w("Weiyun_Cmd", paramString, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.weiyun.utils.WyLog
 * JD-Core Version:    0.7.0.1
 */