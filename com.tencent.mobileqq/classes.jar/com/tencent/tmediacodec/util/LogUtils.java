package com.tencent.tmediacodec.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

public final class LogUtils
{
  private static String GLOBAL_TAG;
  private static String TAG = "LogUtils";
  private static boolean mLogEnable = true;
  private static int mLogLevel;
  private static ILogProxy mLogProxy = new LogUtils.1();
  
  static
  {
    GLOBAL_TAG = "TMediaCodec";
    mLogLevel = 2;
  }
  
  public static void d(@NonNull String paramString1, @NonNull String paramString2)
  {
    if (isEnableLog(3)) {
      mLogProxy.d(GLOBAL_TAG + "." + paramString1, paramString2);
    }
  }
  
  public static void e(@NonNull String paramString1, @NonNull String paramString2)
  {
    if (isEnableLog(6)) {
      mLogProxy.e(GLOBAL_TAG + "." + paramString1, paramString2, null);
    }
  }
  
  public static void e(@NonNull String paramString1, @NonNull String paramString2, @Nullable Throwable paramThrowable)
  {
    if (isEnableLog(6)) {
      mLogProxy.e(GLOBAL_TAG + "." + paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void i(@NonNull String paramString1, @NonNull String paramString2)
  {
    if (isEnableLog(4)) {
      mLogProxy.i(GLOBAL_TAG + "." + paramString1, paramString2);
    }
  }
  
  public static boolean isEnableLog(int paramInt)
  {
    return (mLogEnable) && (paramInt >= mLogLevel);
  }
  
  public static boolean isLogEnable()
  {
    return mLogEnable;
  }
  
  public static void setLogEnable(boolean paramBoolean)
  {
    mLogEnable = paramBoolean;
  }
  
  public static void setLogLevel(int paramInt)
  {
    mLogLevel = paramInt;
    Log.i(GLOBAL_TAG + ".LogUtils", "set LogLevel:" + paramInt);
  }
  
  public static void setLogProxy(@NonNull ILogProxy paramILogProxy)
  {
    mLogProxy = paramILogProxy;
  }
  
  public static void v(@NonNull String paramString1, @NonNull String paramString2)
  {
    if (isEnableLog(2)) {
      mLogProxy.v(GLOBAL_TAG + "." + paramString1, paramString2);
    }
  }
  
  public static void w(@NonNull String paramString1, @NonNull String paramString2)
  {
    if (isEnableLog(5)) {
      mLogProxy.w(GLOBAL_TAG + "." + paramString1, paramString2, null);
    }
  }
  
  public static void w(@NonNull String paramString1, @NonNull String paramString2, @Nullable Throwable paramThrowable)
  {
    if (isEnableLog(5)) {
      mLogProxy.w(GLOBAL_TAG + "." + paramString1, paramString2, paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.util.LogUtils
 * JD-Core Version:    0.7.0.1
 */