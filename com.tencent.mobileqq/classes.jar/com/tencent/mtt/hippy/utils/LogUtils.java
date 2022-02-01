package com.tencent.mtt.hippy.utils;

import android.util.Log;

public class LogUtils
{
  private static boolean DEBUG_ENABLE = false;
  
  public static void d(String paramString1, String paramString2)
  {
    if (DEBUG_ENABLE) {
      Log.d(paramString1, paramString2);
    }
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (DEBUG_ENABLE) {
      Log.d(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    Log.e(paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.e(paramString1, paramString2, paramThrowable);
  }
  
  public static void enableDebugLog(boolean paramBoolean)
  {
    DEBUG_ENABLE = paramBoolean;
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (DEBUG_ENABLE) {
      Log.i(paramString1, paramString2);
    }
  }
  
  public static void l(String paramString1, String paramString2)
  {
    if (!DEBUG_ENABLE) {
      return;
    }
    int k = 0;
    int i = 3800;
    while (k < paramString2.length())
    {
      int j = i;
      if (paramString2.length() < i) {
        j = paramString2.length();
      }
      Log.i(paramString1, paramString2.substring(k, j));
      i = j + 3800;
      k = j;
    }
  }
  
  public static void v(String paramString1, String paramString2)
  {
    if (DEBUG_ENABLE) {
      Log.v(paramString1, paramString2);
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if (DEBUG_ENABLE) {
      Log.w(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.utils.LogUtils
 * JD-Core Version:    0.7.0.1
 */