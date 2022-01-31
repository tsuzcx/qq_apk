package com.tencent.tmediacodec.util;

import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tmediacodec/util/LogUtils$ANDROID_LOG$1", "Lcom/tencent/tmediacodec/util/ILogProxy;", "d", "", "tag", "", "msg", "e", "tr", "", "i", "v", "w", "tmediacodec_lib_debug"}, k=1, mv={1, 1, 15})
public final class LogUtils$ANDROID_LOG$1
  implements ILogProxy
{
  public void d(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "msg");
    Log.d(paramString1, paramString2);
  }
  
  public void e(@NotNull String paramString1, @NotNull String paramString2, @Nullable Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "msg");
    Log.e(paramString1, paramString2, paramThrowable);
  }
  
  public void i(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "msg");
    Log.i(paramString1, paramString2);
  }
  
  public void v(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "msg");
    Log.v(paramString1, paramString2);
  }
  
  public void w(@NotNull String paramString1, @NotNull String paramString2, @Nullable Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "msg");
    Log.w(paramString1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.util.LogUtils.ANDROID_LOG.1
 * JD-Core Version:    0.7.0.1
 */