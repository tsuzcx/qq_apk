package com.tencent.pts.utils;

import android.util.Log;

public class PTSLog
{
  private static boolean sDoNotLog = false;
  private static PTSLogger sPTSLogger;
  
  public static void d(String paramString1, String paramString2)
  {
    if (sDoNotLog) {
      return;
    }
    PTSLogger localPTSLogger = sPTSLogger;
    if (localPTSLogger != null)
    {
      localPTSLogger.d(paramString1, paramString2);
      return;
    }
    Log.d(paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (sDoNotLog) {
      return;
    }
    PTSLogger localPTSLogger = sPTSLogger;
    if (localPTSLogger != null)
    {
      localPTSLogger.e(paramString1, paramString2);
      return;
    }
    Log.e(paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (sDoNotLog) {
      return;
    }
    PTSLogger localPTSLogger = sPTSLogger;
    if (localPTSLogger != null)
    {
      localPTSLogger.e(paramString1, paramString2, paramThrowable);
      return;
    }
    Log.e(paramString1, paramString2, paramThrowable);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (sDoNotLog) {
      return;
    }
    PTSLogger localPTSLogger = sPTSLogger;
    if (localPTSLogger != null)
    {
      localPTSLogger.i(paramString1, paramString2);
      return;
    }
    Log.i(paramString1, paramString2);
  }
  
  public static boolean isColorLevel()
  {
    PTSLogger localPTSLogger = sPTSLogger;
    if (localPTSLogger != null) {
      return localPTSLogger.isColorLevel();
    }
    return false;
  }
  
  public static boolean isDebug()
  {
    PTSLogger localPTSLogger = sPTSLogger;
    if (localPTSLogger != null) {
      return localPTSLogger.isDebug();
    }
    return false;
  }
  
  public static void registerLogger(PTSLogger paramPTSLogger)
  {
    sPTSLogger = paramPTSLogger;
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if (sDoNotLog) {
      return;
    }
    PTSLogger localPTSLogger = sPTSLogger;
    if (localPTSLogger != null)
    {
      localPTSLogger.w(paramString1, paramString2);
      return;
    }
    Log.w(paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (sDoNotLog) {
      return;
    }
    PTSLogger localPTSLogger = sPTSLogger;
    if (localPTSLogger != null)
    {
      localPTSLogger.w(paramString1, paramString2, paramThrowable);
      return;
    }
    Log.w(paramString1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pts.utils.PTSLog
 * JD-Core Version:    0.7.0.1
 */