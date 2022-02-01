package com.tencent.rmonitor.common.logger;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/common/logger/ILogProxy;", "", "doLog", "", "state", "Lcom/tencent/rmonitor/common/logger/LogState;", "args", "", "", "(Lcom/tencent/rmonitor/common/logger/LogState;[Ljava/lang/String;)V", "flush", "logInfo", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public abstract interface ILogProxy
{
  public abstract void a(@NotNull LogState paramLogState, @NotNull String... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.logger.ILogProxy
 * JD-Core Version:    0.7.0.1
 */