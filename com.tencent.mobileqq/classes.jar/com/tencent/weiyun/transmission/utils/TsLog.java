package com.tencent.weiyun.transmission.utils;

import android.util.Log;
import com.tencent.weiyun.utils.ILog;

public final class TsLog
{
  private static final String GLOBAL_TAG = "Weiyun_Transport";
  private static ILog sLog;
  
  public static void d(String paramString)
  {
    d("Weiyun_Transport", paramString, null);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    d(paramString1, paramString2, null);
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (2 >= getLogLevel())
    {
      ILog localILog = sLog;
      if (localILog != null)
      {
        localILog.d(paramString1, paramString2, paramThrowable);
        return;
      }
      Log.d(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void d(String paramString, Throwable paramThrowable)
  {
    d("Weiyun_Transport", paramString, paramThrowable);
  }
  
  public static void e(String paramString)
  {
    e("Weiyun_Transport", paramString, null);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    e(paramString1, paramString2, null);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (5 >= getLogLevel())
    {
      ILog localILog = sLog;
      if (localILog != null)
      {
        localILog.e(paramString1, paramString2, paramThrowable);
        return;
      }
      Log.e(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void e(String paramString, Throwable paramThrowable)
  {
    e("Weiyun_Transport", paramString, paramThrowable);
  }
  
  private static int getLogLevel()
  {
    ILog localILog = sLog;
    if (localILog != null) {
      return localILog.getLogLevel();
    }
    return 1;
  }
  
  public static void i(String paramString)
  {
    i("Weiyun_Transport", paramString, null);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    i(paramString1, paramString2, null);
  }
  
  public static void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (3 >= getLogLevel())
    {
      ILog localILog = sLog;
      if (localILog != null)
      {
        localILog.i(paramString1, paramString2, paramThrowable);
        return;
      }
      Log.i(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void i(String paramString, Throwable paramThrowable)
  {
    i("Weiyun_Transport", paramString, paramThrowable);
  }
  
  public static void setLog(ILog paramILog)
  {
    sLog = paramILog;
  }
  
  public static void v(String paramString)
  {
    v("Weiyun_Transport", paramString, null);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    v(paramString1, paramString2, null);
  }
  
  public static void v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (1 >= getLogLevel())
    {
      ILog localILog = sLog;
      if (localILog != null)
      {
        localILog.v(paramString1, paramString2, paramThrowable);
        return;
      }
      Log.v(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void v(String paramString, Throwable paramThrowable)
  {
    v("Weiyun_Transport", paramString, paramThrowable);
  }
  
  public static void w(String paramString)
  {
    w("Weiyun_Transport", paramString, null);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    w(paramString1, paramString2, null);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (4 >= getLogLevel())
    {
      ILog localILog = sLog;
      if (localILog != null)
      {
        localILog.w(paramString1, paramString2, paramThrowable);
        return;
      }
      Log.w(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void w(String paramString, Throwable paramThrowable)
  {
    w("Weiyun_Transport", paramString, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.weiyun.transmission.utils.TsLog
 * JD-Core Version:    0.7.0.1
 */