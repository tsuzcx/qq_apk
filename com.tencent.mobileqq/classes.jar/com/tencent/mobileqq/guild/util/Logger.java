package com.tencent.mobileqq.guild.util;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/guild/util/Logger;", "", "()V", "logger", "Lcom/tencent/mobileqq/guild/util/Logger$ILog;", "getLogger", "()Lcom/tencent/mobileqq/guild/util/Logger$ILog;", "setLogger", "(Lcom/tencent/mobileqq/guild/util/Logger$ILog;)V", "color", "", "tag", "", "block", "Lkotlin/Function0;", "d", "dev", "e", "throwable", "", "ILog", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class Logger
{
  public static final Logger a = new Logger();
  @NotNull
  private static Logger.ILog b = (Logger.ILog)new Logger.logger.1();
  
  @NotNull
  public final Logger.ILog a()
  {
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.Logger
 * JD-Core Version:    0.7.0.1
 */