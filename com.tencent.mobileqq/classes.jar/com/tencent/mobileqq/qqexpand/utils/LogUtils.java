package com.tencent.mobileqq.qqexpand.utils;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/utils/LogUtils;", "", "()V", "logger", "Lcom/tencent/mobileqq/qqexpand/utils/ILog;", "getLogger", "()Lcom/tencent/mobileqq/qqexpand/utils/ILog;", "setLogger", "(Lcom/tencent/mobileqq/qqexpand/utils/ILog;)V", "color", "", "tag", "", "block", "Lkotlin/Function0;", "d", "dev", "e", "throwable", "", "qqexpand-api_release"}, k=1, mv={1, 1, 16})
public final class LogUtils
{
  public static final LogUtils a = new LogUtils();
  @NotNull
  private static ILog b = (ILog)new LogUtils.logger.1();
  
  @NotNull
  public final ILog a()
  {
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.LogUtils
 * JD-Core Version:    0.7.0.1
 */