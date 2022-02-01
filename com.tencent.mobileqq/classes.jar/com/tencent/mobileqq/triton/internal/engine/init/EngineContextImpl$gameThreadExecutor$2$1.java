package com.tencent.mobileqq.triton.internal.engine.init;

import com.tencent.mobileqq.triton.engine.TTEngine;
import java.util.concurrent.Executor;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Ljava/lang/Runnable;", "kotlin.jvm.PlatformType", "execute"}, k=3, mv={1, 1, 16})
final class EngineContextImpl$gameThreadExecutor$2$1
  implements Executor
{
  EngineContextImpl$gameThreadExecutor$2$1(EngineContextImpl.gameThreadExecutor.2 param2) {}
  
  public final void execute(Runnable paramRunnable)
  {
    this.this$0.this$0.getTtEngine().postRunnable(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.engine.init.EngineContextImpl.gameThreadExecutor.2.1
 * JD-Core Version:    0.7.0.1
 */