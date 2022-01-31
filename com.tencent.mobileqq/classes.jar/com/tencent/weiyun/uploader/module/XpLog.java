package com.tencent.weiyun.uploader.module;

import android.util.Log;
import com.tencent.weiyun.utils.ILog;

public class XpLog
{
  private static final String GLOBAL_TAG = "xp-uploader";
  private static ILog sLog;
  
  public static void d(String paramString)
  {
    d("xp-uploader", paramString, null);
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
    d("xp-uploader", paramString, paramThrowable);
  }
  
  public static void e(String paramString)
  {
    e("xp-uploader", paramString, null);
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
    e("xp-uploader", paramString, paramThrowable);
  }
  
  public static int getLogLevel()
  {
    if (sLog != null) {
      return sLog.getLogLevel();
    }
    return 1;
  }
  
  public static void i(String paramString)
  {
    i("xp-uploader", paramString, null);
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
    i("xp-uploader", paramString, paramThrowable);
  }
  
  public static void setLog(ILog paramILog)
  {
    sLog = paramILog;
  }
  
  public static void v(String paramString)
  {
    v("xp-uploader", paramString, null);
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
    v("xp-uploader", paramString, paramThrowable);
  }
  
  public static void w(String paramString)
  {
    w("xp-uploader", paramString, null);
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
    w("xp-uploader", paramString, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.weiyun.uploader.module.XpLog
 * JD-Core Version:    0.7.0.1
 */