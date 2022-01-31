package com.tencent.tmediacodec.util;

import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tmediacodec/util/LogUtils;", "", "()V", "ANDROID_LOG", "com/tencent/tmediacodec/util/LogUtils$ANDROID_LOG$1", "Lcom/tencent/tmediacodec/util/LogUtils$ANDROID_LOG$1;", "TAG", "", "mLogEnable", "", "mLogLevel", "", "mLogProxy", "Lcom/tencent/tmediacodec/util/ILogProxy;", "d", "", "tag", "msg", "e", "tr", "", "i", "isEnableLog", "level", "setLogEnable", "logEnable", "setLogLevel", "setLogProxy", "logProxy", "v", "w", "tmediacodec_lib_debug"}, k=1, mv={1, 1, 15})
public final class LogUtils
{
  private static final LogUtils.ANDROID_LOG.1 ANDROID_LOG = new LogUtils.ANDROID_LOG.1();
  public static final LogUtils INSTANCE = new LogUtils();
  private static final String TAG = "LogUtils";
  private static boolean mLogEnable;
  private static int mLogLevel = 3;
  private static ILogProxy mLogProxy = (ILogProxy)ANDROID_LOG;
  
  static
  {
    mLogEnable = true;
  }
  
  public final void d(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "msg");
    if (isEnableLog(3)) {
      mLogProxy.d(paramString1, paramString2);
    }
  }
  
  public final void e(@NotNull String paramString1, @NotNull String paramString2, @Nullable Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "msg");
    if (isEnableLog(6)) {
      mLogProxy.e(paramString1, paramString2, paramThrowable);
    }
  }
  
  public final void i(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "msg");
    if (isEnableLog(4)) {
      mLogProxy.i(paramString1, paramString2);
    }
  }
  
  public final boolean isEnableLog(int paramInt)
  {
    return (mLogEnable) && (paramInt >= mLogLevel);
  }
  
  public final void setLogEnable(boolean paramBoolean)
  {
    mLogEnable = paramBoolean;
  }
  
  public final void setLogLevel(int paramInt)
  {
    mLogLevel = paramInt;
    Log.i("LogUtils", "set LogLevel:" + paramInt);
  }
  
  public final void setLogProxy(@NotNull ILogProxy paramILogProxy)
  {
    Intrinsics.checkParameterIsNotNull(paramILogProxy, "logProxy");
    mLogProxy = paramILogProxy;
  }
  
  public final void v(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "msg");
    if (isEnableLog(2)) {
      mLogProxy.v(paramString1, paramString2);
    }
  }
  
  public final void w(@NotNull String paramString1, @NotNull String paramString2, @Nullable Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "msg");
    if (isEnableLog(5)) {
      mLogProxy.w(paramString1, paramString2, paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tmediacodec.util.LogUtils
 * JD-Core Version:    0.7.0.1
 */