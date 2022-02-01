package com.tencent.mobileqq.qqexpand.utils;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/qqexpand/utils/LogUtils$logger$1", "Lcom/tencent/mobileqq/qqexpand/utils/ILog;", "d", "", "tag", "", "level", "", "msg", "e", "tr", "", "qqexpand-api_release"}, k=1, mv={1, 1, 16})
public final class LogUtils$logger$1
  implements ILog
{
  public void a(@NotNull String paramString1, int paramInt, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "msg");
    QLog.d(paramString1, paramInt, paramString2);
  }
  
  public void a(@NotNull String paramString1, int paramInt, @NotNull String paramString2, @Nullable Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "msg");
    QLog.e(paramString1, paramInt, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.LogUtils.logger.1
 * JD-Core Version:    0.7.0.1
 */