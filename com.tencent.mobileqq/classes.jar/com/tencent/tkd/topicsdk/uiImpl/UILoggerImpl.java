package com.tencent.tkd.topicsdk.uiImpl;

import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.weibo.framework.ILogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/uiImpl/UILoggerImpl;", "Lcom/tencent/tkd/weibo/framework/ILogger;", "()V", "d", "", "tag", "", "msg", "throwable", "", "e", "i", "w", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class UILoggerImpl
  implements ILogger
{
  public void a(@NotNull String paramString1, @NotNull String paramString2, @Nullable Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "msg");
    TLog.c(paramString1, paramString2, paramThrowable);
  }
  
  public void b(@NotNull String paramString1, @NotNull String paramString2, @Nullable Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "msg");
    TLog.a(paramString1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.uiImpl.UILoggerImpl
 * JD-Core Version:    0.7.0.1
 */