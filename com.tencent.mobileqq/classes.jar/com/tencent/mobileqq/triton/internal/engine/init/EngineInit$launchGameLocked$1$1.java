package com.tencent.mobileqq.triton.internal.engine.init;

import com.tencent.mobileqq.triton.engine.GameLaunchCallback;
import com.tencent.mobileqq.triton.internal.utils.Utils;
import com.tencent.mobileqq.triton.statistic.EngineInitStatistic;
import com.tencent.mobileqq.triton.statistic.GameLaunchStatistic;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class EngineInit$launchGameLocked$1$1
  implements Runnable
{
  EngineInit$launchGameLocked$1$1(EngineInit.launchGameLocked.1 param1, EngineInitStatistic paramEngineInitStatistic) {}
  
  public final void run()
  {
    this.this$0.$gameLaunchCallback.onGameLaunched(null, new GameLaunchStatistic(false, this.$initStatistic.getException(), Utils.timeStamp() - this.this$0.$begin, CollectionsKt.emptyList(), this.$initStatistic));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.engine.init.EngineInit.launchGameLocked.1.1
 * JD-Core Version:    0.7.0.1
 */