package com.tencent.mobileqq.triton.internal.engine.init;

import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.engine.EngineState;
import com.tencent.mobileqq.triton.engine.GameLaunchCallback;
import com.tencent.mobileqq.triton.internal.engine.Engine;
import com.tencent.mobileqq.triton.internal.engine.EngineContext;
import com.tencent.mobileqq.triton.statistic.GameLaunchStatistic;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class EngineInit$performLaunchGame$1$onGameLaunched$1
  implements Runnable
{
  EngineInit$performLaunchGame$1$onGameLaunched$1(EngineInit.performLaunchGame.1 param1, GameLaunchStatistic paramGameLaunchStatistic) {}
  
  public final void run()
  {
    this.this$0.this$0.getEngineContext().setEngineState(EngineState.STOPPED);
    if (this.$statics.getSuccess()) {
      EngineInit.access$getEngineContextImpl$p(this.this$0.this$0).getLifeCycleOwner().notifyOnGameLaunched((TritonEngine)EngineInit.access$getEngine$p(this.this$0.this$0));
    } else {
      EngineInit.access$getEngine$p(this.this$0.this$0).destroy();
    }
    GameLaunchCallback localGameLaunchCallback = this.this$0.$gameLaunchCallback;
    Engine localEngine;
    if (this.$statics.getSuccess()) {
      localEngine = EngineInit.access$getEngine$p(this.this$0.this$0);
    } else {
      localEngine = null;
    }
    localGameLaunchCallback.onGameLaunched((TritonEngine)localEngine, this.$statics);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.engine.init.EngineInit.performLaunchGame.1.onGameLaunched.1
 * JD-Core Version:    0.7.0.1
 */