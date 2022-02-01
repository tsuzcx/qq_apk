package com.tencent.youtu.sdkkitframework.common;

import android.util.Log;

public final class YtLogger
{
  public static final int DEBUG_LEVEL = 4;
  public static final int ERROR_LEVEL = 0;
  public static final int INFO_LEVEL = 2;
  public static final int VERB_LEVEL = 5;
  public static final int WARN_LEVEL = 1;
  private static int currentLogLevel = 0;
  
  public static void d(String paramString, Object paramObject)
  {
    if (currentLogLevel >= 4) {
      showLog(paramString, "[YoutuLog]-[DEBUG]-" + paramObject);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (currentLogLevel >= 0) {
      showLog(paramString1, "[YoutuLog]-[ERROR]-" + paramString2);
    }
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (currentLogLevel >= 2) {
      showLog(paramString1, "[YoutuLog]-[INFO]-" + paramString2);
    }
  }
  
  public static void setLogLevel(int paramInt)
  {
    currentLogLevel = Math.min(paramInt, Math.max(paramInt, 0));
  }
  
  private static void showLog(String paramString1, String paramString2)
  {
    Log.d(paramString1, paramString2);
  }
  
  public static void v(String paramString, Object paramObject)
  {
    if (currentLogLevel >= 5) {
      showLog(paramString, "[YoutuLog]-[VERB]-" + paramObject);
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if (currentLogLevel >= 1) {
      showLog(paramString1, "[YoutuLog]-[WARN]-" + paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.common.YtLogger
 * JD-Core Version:    0.7.0.1
 */