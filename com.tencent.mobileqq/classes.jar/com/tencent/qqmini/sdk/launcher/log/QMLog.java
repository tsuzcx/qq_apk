package com.tencent.qqmini.sdk.launcher.log;

import com.tencent.qqmini.sdk.annotation.MiniKeep;

@MiniKeep
public class QMLog
{
  public static final String TAG_DOWNLOAD = "downloader";
  public static final String TAG_DOWNLOAD_RESULT = "downloader_result";
  private static Log sLog;
  
  public static void d(String paramString1, String paramString2)
  {
    d(paramString1, paramString2, null);
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (sLog != null)
    {
      sLog.d(getLogTag(paramString1), paramString2, paramThrowable);
      return;
    }
    android.util.Log.d(getLogTag(paramString1), paramString2, paramThrowable);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    e(paramString1, paramString2, null);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (sLog != null)
    {
      sLog.e(getLogTag(paramString1), paramString2, paramThrowable);
      return;
    }
    android.util.Log.e(getLogTag(paramString1), paramString2, paramThrowable);
  }
  
  public static Log getLog()
  {
    return sLog;
  }
  
  public static int getLogLevel()
  {
    if (sLog != null) {
      return sLog.getLogLevel();
    }
    return 3;
  }
  
  private static String getLogTag(String paramString)
  {
    return "[MiniSDK]" + paramString;
  }
  
  public static void i(String paramString1, String paramString2)
  {
    i(paramString1, paramString2, null);
  }
  
  public static void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (sLog != null)
    {
      sLog.i(getLogTag(paramString1), paramString2, paramThrowable);
      return;
    }
    android.util.Log.i(getLogTag(paramString1), paramString2, paramThrowable);
  }
  
  public static boolean isColorLevel()
  {
    return true;
  }
  
  public static boolean isDebugEnabled()
  {
    return 2 >= getLogLevel();
  }
  
  public static boolean isErrorEnabled()
  {
    return 5 >= getLogLevel();
  }
  
  public static boolean isInfoEnabled()
  {
    return 3 >= getLogLevel();
  }
  
  public static boolean isWarningEnabled()
  {
    return 4 >= getLogLevel();
  }
  
  public static void setLog(Log paramLog)
  {
    if (paramLog != null) {
      sLog = paramLog;
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    w(paramString1, paramString2, null);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (sLog != null)
    {
      sLog.w(getLogTag(paramString1), paramString2, paramThrowable);
      return;
    }
    android.util.Log.w(getLogTag(paramString1), paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.log.QMLog
 * JD-Core Version:    0.7.0.1
 */