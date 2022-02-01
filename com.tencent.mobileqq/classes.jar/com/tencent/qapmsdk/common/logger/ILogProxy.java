package com.tencent.qapmsdk.common.logger;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/logger/ILogProxy;", "", "doLog", "", "state", "Lcom/tencent/qapmsdk/common/logger/LogState;", "args", "", "", "(Lcom/tencent/qapmsdk/common/logger/LogState;[Ljava/lang/String;)V", "flush", "logInfo", "common_release"}, k=1, mv={1, 1, 15})
public abstract interface ILogProxy
{
  public abstract void doLog(@NotNull LogState paramLogState, @NotNull String... paramVarArgs);
  
  public abstract void flush(@NotNull String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.common.logger.ILogProxy
 * JD-Core Version:    0.7.0.1
 */