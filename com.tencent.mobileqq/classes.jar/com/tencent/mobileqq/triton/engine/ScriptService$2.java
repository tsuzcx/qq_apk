package com.tencent.mobileqq.triton.engine;

import java.util.concurrent.Executor;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "command", "Ljava/lang/Runnable;", "kotlin.jvm.PlatformType", "execute"}, k=3, mv={1, 1, 16})
final class ScriptService$2
  implements Executor
{
  ScriptService$2(ScriptService paramScriptService) {}
  
  public final void execute(Runnable paramRunnable)
  {
    ScriptService.access$getMEngine$p(this.this$0).postRunnable(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.engine.ScriptService.2
 * JD-Core Version:    0.7.0.1
 */