package com.tencent.tmediacodec.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

public final class LogUtils
{
  private static String GLOBAL_TAG = "TMediaCodec";
  private static String TAG = "LogUtils";
  private static boolean mLogEnable = true;
  private static int mLogLevel = 2;
  private static ILogProxy mLogProxy = new LogUtils.1();
  
  public static void d(@NonNull String paramString1, @NonNull String paramString2)
  {
    if (isEnableLog(3))
    {
      ILogProxy localILogProxy = mLogProxy;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(GLOBAL_TAG);
      localStringBuilder.append(".");
      localStringBuilder.append(paramString1);
      localILogProxy.d(localStringBuilder.toString(), paramString2);
    }
  }
  
  public static void e(@NonNull String paramString1, @NonNull String paramString2)
  {
    if (isEnableLog(6))
    {
      ILogProxy localILogProxy = mLogProxy;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(GLOBAL_TAG);
      localStringBuilder.append(".");
      localStringBuilder.append(paramString1);
      localILogProxy.e(localStringBuilder.toString(), paramString2, null);
    }
  }
  
  public static void e(@NonNull String paramString1, @NonNull String paramString2, @Nullable Throwable paramThrowable)
  {
    if (isEnableLog(6))
    {
      ILogProxy localILogProxy = mLogProxy;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(GLOBAL_TAG);
      localStringBuilder.append(".");
      localStringBuilder.append(paramString1);
      localILogProxy.e(localStringBuilder.toString(), paramString2, paramThrowable);
    }
  }
  
  public static void i(@NonNull String paramString1, @NonNull String paramString2)
  {
    if (isEnableLog(4))
    {
      ILogProxy localILogProxy = mLogProxy;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(GLOBAL_TAG);
      localStringBuilder.append(".");
      localStringBuilder.append(paramString1);
      localILogProxy.i(localStringBuilder.toString(), paramString2);
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(GLOBAL_TAG);
    ((StringBuilder)localObject).append(".LogUtils");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("set LogLevel:");
    localStringBuilder.append(paramInt);
    Log.i((String)localObject, localStringBuilder.toString());
  }
  
  public static void setLogProxy(@NonNull ILogProxy paramILogProxy)
  {
    mLogProxy = paramILogProxy;
  }
  
  public static void v(@NonNull String paramString1, @NonNull String paramString2)
  {
    if (isEnableLog(2))
    {
      ILogProxy localILogProxy = mLogProxy;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(GLOBAL_TAG);
      localStringBuilder.append(".");
      localStringBuilder.append(paramString1);
      localILogProxy.v(localStringBuilder.toString(), paramString2);
    }
  }
  
  public static void w(@NonNull String paramString1, @NonNull String paramString2)
  {
    if (isEnableLog(5))
    {
      ILogProxy localILogProxy = mLogProxy;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(GLOBAL_TAG);
      localStringBuilder.append(".");
      localStringBuilder.append(paramString1);
      localILogProxy.w(localStringBuilder.toString(), paramString2, null);
    }
  }
  
  public static void w(@NonNull String paramString1, @NonNull String paramString2, @Nullable Throwable paramThrowable)
  {
    if (isEnableLog(5))
    {
      ILogProxy localILogProxy = mLogProxy;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(GLOBAL_TAG);
      localStringBuilder.append(".");
      localStringBuilder.append(paramString1);
      localILogProxy.w(localStringBuilder.toString(), paramString2, paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmediacodec.util.LogUtils
 * JD-Core Version:    0.7.0.1
 */