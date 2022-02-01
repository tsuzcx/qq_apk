package com.tencent.ytcommon.auth;

import android.util.Log;

public final class YTLog
{
  public static void d(String paramString, Object paramObject)
  {
    if (!Config.DEBUG) {
      return;
    }
    Log.d(paramString, String.valueOf(paramObject));
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (!Config.DEBUG) {
      return;
    }
    Log.d(paramString1, paramString2, paramThrowable);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (Config.DEBUG) {
      Log.e(paramString1, paramString2);
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if (Config.DEBUG) {
      Log.e(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.ytcommon.auth.YTLog
 * JD-Core Version:    0.7.0.1
 */