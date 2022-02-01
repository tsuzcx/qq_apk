package com.tencent.tav.decoder.logger;

import android.util.Log;

public class Logger
{
  private static boolean DEBUG = false;
  public static boolean LOG_VERBOSE = false;
  public static final int MAX_LOG_LENGTH = 4096;
  private static ILog logger;
  
  public static void d(String paramString1, String paramString2)
  {
    if (logger != null) {
      logger.d(paramString1, paramString2);
    }
    while (!DEBUG) {
      return;
    }
    Log.d(paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (logger != null) {
      logger.e(paramString1, paramString2);
    }
    while (!DEBUG) {
      return;
    }
    Log.e(paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (logger != null) {
      logger.e(paramString1, paramString2, paramThrowable);
    }
    while (!DEBUG) {
      return;
    }
    Log.e(paramString1, paramString2, paramThrowable);
  }
  
  public static void e(String paramString, Throwable paramThrowable)
  {
    if (logger != null) {
      logger.e(paramString, paramThrowable);
    }
    while (!DEBUG) {
      return;
    }
    Log.e(paramString, paramThrowable.getMessage() + "", paramThrowable);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (logger != null) {
      logger.i(paramString1, paramString2, paramVarArgs);
    }
    while (!DEBUG) {
      return;
    }
    Log.i(paramString1, String.format(paramString2, paramVarArgs));
  }
  
  public static void longlogd(String paramString1, String paramString2)
  {
    int j = 0;
    int m = paramString2.length();
    int i = 4096;
    int k = 0;
    while (j < 100) {
      if (m > i)
      {
        d(paramString1 + j, paramString2.substring(k, i));
        j += 1;
        k = i;
        i += 4096;
      }
      else
      {
        d(paramString1, paramString2.substring(k, m));
      }
    }
  }
  
  public static void setLogAble(boolean paramBoolean)
  {
    DEBUG = paramBoolean;
  }
  
  public static void setLogger(ILog paramILog)
  {
    logger = paramILog;
  }
  
  public static void v(String paramString1, String paramString2)
  {
    if (logger != null) {
      logger.v(paramString1, paramString2);
    }
    while (!DEBUG) {
      return;
    }
    Log.v(paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if (logger != null) {
      logger.w(paramString1, paramString2);
    }
    while (!DEBUG) {
      return;
    }
    Log.w(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.decoder.logger.Logger
 * JD-Core Version:    0.7.0.1
 */