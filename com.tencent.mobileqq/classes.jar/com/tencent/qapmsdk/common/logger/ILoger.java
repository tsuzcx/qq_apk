package com.tencent.qapmsdk.common.logger;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/logger/ILoger;", "", "d", "", "args", "", "", "([Ljava/lang/String;)V", "e", "i", "v", "w", "common_release"}, k=1, mv={1, 1, 15})
public abstract interface ILoger
{
  public abstract void d(@NotNull String... paramVarArgs);
  
  public abstract void e(@NotNull String... paramVarArgs);
  
  public abstract void i(@NotNull String... paramVarArgs);
  
  public abstract void v(@NotNull String... paramVarArgs);
  
  public abstract void w(@NotNull String... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.common.logger.ILoger
 * JD-Core Version:    0.7.0.1
 */