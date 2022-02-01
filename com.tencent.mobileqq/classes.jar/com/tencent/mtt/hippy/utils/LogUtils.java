package com.tencent.mtt.hippy.utils;

import android.util.Log;

public class LogUtils
{
  private static boolean DEBUG_ENABLE = false;
  
  public static int d(String paramString1, String paramString2)
  {
    if (DEBUG_ENABLE) {
      return Log.d(paramString1, paramString2);
    }
    return 0;
  }
  
  public static int d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (DEBUG_ENABLE) {
      return Log.d(paramString1, paramString2, paramThrowable);
    }
    return 0;
  }
  
  public static int e(String paramString1, String paramString2)
  {
    return Log.e(paramString1, paramString2);
  }
  
  public static int e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return Log.e(paramString1, paramString2, paramThrowable);
  }
  
  public static void enableDebugLog(boolean paramBoolean)
  {
    DEBUG_ENABLE = paramBoolean;
  }
  
  public static int i(String paramString1, String paramString2)
  {
    if (DEBUG_ENABLE) {
      return Log.i(paramString1, paramString2);
    }
    return 0;
  }
  
  public static int l(String paramString1, String paramString2)
  {
    if (DEBUG_ENABLE)
    {
      int i = 3800;
      int j = 0;
      if (j < paramString2.length())
      {
        String str;
        if (paramString2.length() < i)
        {
          i = paramString2.length();
          str = paramString2.substring(j, i);
        }
        for (j = i;; j = i)
        {
          Log.i(paramString1, str);
          i = j + 3800;
          break;
          str = paramString2.substring(j, i);
        }
      }
    }
    return 0;
  }
  
  public static int v(String paramString1, String paramString2)
  {
    if (DEBUG_ENABLE) {
      return Log.v(paramString1, paramString2);
    }
    return 0;
  }
  
  public static int w(String paramString1, String paramString2)
  {
    if (DEBUG_ENABLE) {
      return Log.w(paramString1, paramString2);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.utils.LogUtils
 * JD-Core Version:    0.7.0.1
 */