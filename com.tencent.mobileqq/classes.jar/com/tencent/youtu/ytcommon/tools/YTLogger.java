package com.tencent.youtu.ytcommon.tools;

import android.util.Log;

public class YTLogger
{
  private static YTLogger.IFaceLiveLogger iFaceLiveLogger;
  private static boolean sEnableLog = false;
  private static boolean sEnableNativeLog = false;
  
  public static void d(String paramString1, String paramString2)
  {
    if (!sEnableLog) {
      return;
    }
    if (iFaceLiveLogger != null)
    {
      iFaceLiveLogger.d(paramString1, paramString2);
      return;
    }
    Log.d(paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (iFaceLiveLogger != null)
    {
      iFaceLiveLogger.e(paramString1, paramString2);
      return;
    }
    Log.e(paramString1, paramString2);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (!sEnableLog) {
      return;
    }
    if (iFaceLiveLogger != null)
    {
      iFaceLiveLogger.i(paramString1, paramString2);
      return;
    }
    Log.i(paramString1, paramString2);
  }
  
  public static boolean isEnableLog()
  {
    return sEnableLog;
  }
  
  public static boolean isEnableNativeLog()
  {
    return sEnableNativeLog;
  }
  
  public static void setIsEnabledLog(boolean paramBoolean)
  {
    sEnableLog = paramBoolean;
  }
  
  public static void setIsEnabledNativeLog(boolean paramBoolean)
  {
    sEnableNativeLog = paramBoolean;
  }
  
  public static void setLog(YTLogger.IFaceLiveLogger paramIFaceLiveLogger)
  {
    iFaceLiveLogger = paramIFaceLiveLogger;
  }
  
  public static void v(String paramString1, String paramString2)
  {
    if (!sEnableLog) {
      return;
    }
    if (iFaceLiveLogger != null)
    {
      iFaceLiveLogger.v(paramString1, paramString2);
      return;
    }
    Log.v(paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if (!sEnableLog) {
      return;
    }
    if (iFaceLiveLogger != null)
    {
      iFaceLiveLogger.w(paramString1, paramString2);
      return;
    }
    Log.w(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.youtu.ytcommon.tools.YTLogger
 * JD-Core Version:    0.7.0.1
 */