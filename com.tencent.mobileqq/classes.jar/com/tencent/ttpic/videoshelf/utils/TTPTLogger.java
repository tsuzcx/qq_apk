package com.tencent.ttpic.videoshelf.utils;

import android.util.Log;

public class TTPTLogger
{
  private static boolean sNotShowAndroidLog = true;
  private static ITTPTLogger sTTPTLogger;
  
  public static void e(String paramString1, String paramString2)
  {
    ITTPTLogger localITTPTLogger = sTTPTLogger;
    if (localITTPTLogger != null) {
      localITTPTLogger.e(paramString1, paramString2);
    }
    if (sNotShowAndroidLog) {
      Log.e(paramString1, paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    ITTPTLogger localITTPTLogger = sTTPTLogger;
    if (localITTPTLogger != null) {
      localITTPTLogger.e(paramString1, paramString2, paramThrowable);
    }
    if (sNotShowAndroidLog) {
      Log.e(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void e(String paramString, Throwable paramThrowable)
  {
    ITTPTLogger localITTPTLogger = sTTPTLogger;
    if (localITTPTLogger != null) {
      localITTPTLogger.e(paramString, paramThrowable);
    }
    if ((paramThrowable != null) && (sNotShowAndroidLog)) {
      Log.e(paramString, paramThrowable.getMessage());
    }
  }
  
  public static void i(String paramString1, String paramString2)
  {
    ITTPTLogger localITTPTLogger = sTTPTLogger;
    if (localITTPTLogger != null) {
      localITTPTLogger.i(paramString1, paramString2);
    }
    if (sNotShowAndroidLog) {
      Log.i(paramString1, paramString2);
    }
  }
  
  public static void setLogger(ITTPTLogger paramITTPTLogger)
  {
    sTTPTLogger = paramITTPTLogger;
  }
  
  public static void setShowAndroidLog(boolean paramBoolean)
  {
    sNotShowAndroidLog = paramBoolean;
  }
  
  public static void w(String paramString1, String paramString2)
  {
    ITTPTLogger localITTPTLogger = sTTPTLogger;
    if (localITTPTLogger != null) {
      localITTPTLogger.w(paramString1, paramString2);
    }
    if (sNotShowAndroidLog) {
      Log.w(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.utils.TTPTLogger
 * JD-Core Version:    0.7.0.1
 */