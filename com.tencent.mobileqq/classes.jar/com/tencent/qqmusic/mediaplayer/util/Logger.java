package com.tencent.qqmusic.mediaplayer.util;

import com.tencent.qqmusic.mediaplayer.ILog;

public class Logger
{
  private static ILog mILog = new Logger.1();
  
  public static void d(String paramString1, String paramString2)
  {
    ILog localILog = mILog;
    if (localILog != null) {
      localILog.d(paramString1, paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    ILog localILog = mILog;
    if (localILog != null) {
      localILog.e(paramString1, paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    ILog localILog = mILog;
    if (localILog != null) {
      localILog.e(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    ILog localILog = mILog;
    if (localILog != null) {
      localILog.e(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void e(String paramString, Throwable paramThrowable)
  {
    ILog localILog = mILog;
    if (localILog != null) {
      localILog.e(paramString, paramThrowable);
    }
  }
  
  public static void i(String paramString1, String paramString2)
  {
    ILog localILog = mILog;
    if (localILog != null) {
      localILog.i(paramString1, paramString2);
    }
  }
  
  public static void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    ILog localILog = mILog;
    if (localILog != null) {
      localILog.i(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void setLog(ILog paramILog)
  {
    mILog = paramILog;
  }
  
  public static void w(String paramString1, String paramString2)
  {
    ILog localILog = mILog;
    if (localILog != null) {
      localILog.w(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.util.Logger
 * JD-Core Version:    0.7.0.1
 */