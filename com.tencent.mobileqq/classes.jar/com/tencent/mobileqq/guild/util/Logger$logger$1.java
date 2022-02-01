package com.tencent.mobileqq.guild.util;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/guild/util/Logger$logger$1", "Lcom/tencent/mobileqq/guild/util/Logger$ILog;", "d", "", "tag", "", "level", "", "msg", "e", "tr", "", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class Logger$logger$1
  implements Logger.ILog
{
  public void a(@NotNull String paramString1, int paramInt, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "msg");
    QLog.d(paramString1, paramInt, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.Logger.logger.1
 * JD-Core Version:    0.7.0.1
 */