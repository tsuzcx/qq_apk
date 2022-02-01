package com.tencent.mobileqq.triton.internal.engine.init;

import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Ljava/util/concurrent/Executor;", "invoke"}, k=3, mv={1, 1, 16})
final class EngineContextImpl$gameThreadExecutor$2
  extends Lambda
  implements Function0<Executor>
{
  EngineContextImpl$gameThreadExecutor$2(EngineContextImpl paramEngineContextImpl)
  {
    super(0);
  }
  
  @NotNull
  public final Executor invoke()
  {
    return (Executor)new EngineContextImpl.gameThreadExecutor.2.1(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.engine.init.EngineContextImpl.gameThreadExecutor.2
 * JD-Core Version:    0.7.0.1
 */