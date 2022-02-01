package com.tencent.mobileqq.triton.internal.engine.init;

import com.tencent.mobileqq.triton.engine.GameLaunchCallback;
import com.tencent.mobileqq.triton.statistic.FirstFrameStatistic;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class EngineInit$performLaunchGame$1$onFirstFrame$1
  implements Runnable
{
  EngineInit$performLaunchGame$1$onFirstFrame$1(EngineInit.performLaunchGame.1 param1, FirstFrameStatistic paramFirstFrameStatistic) {}
  
  public final void run()
  {
    this.this$0.$gameLaunchCallback.onFirstFrame(this.$statics);
    EngineInit.access$getEngineContextImpl$p(this.this$0.this$0).getLifeCycleOwner().notifyOnFirstFrame();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.engine.init.EngineInit.performLaunchGame.1.onFirstFrame.1
 * JD-Core Version:    0.7.0.1
 */