package com.tencent.mobileqq.triton.engine;

import com.tencent.mobileqq.triton.internal.engine.EngineContext;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/triton/engine/ScriptService$3", "Ljava/lang/Runnable;", "run", "", "Triton_release"}, k=1, mv={1, 1, 16})
public final class ScriptService$3
  implements Runnable
{
  public void run()
  {
    EngineState localEngineState = ScriptService.access$getMEngine$p(this.this$0).getEngineContext().getEngineState();
    if (localEngineState == EngineState.STARTED) {
      ScriptService.access$printLiveLog(this.this$0);
    }
    if (localEngineState != EngineState.DESTROYED) {
      ScriptService.access$getMEngine$p(this.this$0).postRunnableDelayed((Runnable)this, ScriptService.access$getLIVE_LOG_DURATION_MS$cp());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.engine.ScriptService.3
 * JD-Core Version:    0.7.0.1
 */