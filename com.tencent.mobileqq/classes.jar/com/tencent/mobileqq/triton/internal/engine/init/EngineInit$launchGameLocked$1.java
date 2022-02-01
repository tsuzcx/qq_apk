package com.tencent.mobileqq.triton.internal.engine.init;

import com.tencent.mobileqq.triton.engine.GameLaunchCallback;
import com.tencent.mobileqq.triton.engine.GameLaunchParam;
import com.tencent.mobileqq.triton.internal.engine.Engine;
import com.tencent.mobileqq.triton.internal.engine.EngineContext;
import com.tencent.mobileqq.triton.statistic.EngineInitStatistic;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class EngineInit$launchGameLocked$1
  extends Lambda
  implements Function0<Unit>
{
  EngineInit$launchGameLocked$1(EngineInit paramEngineInit, GameLaunchCallback paramGameLaunchCallback, long paramLong, GameLaunchParam paramGameLaunchParam)
  {
    super(0);
  }
  
  public final void invoke()
  {
    EngineInitStatistic localEngineInitStatistic = EngineInit.access$getEngineInitStatistics$p(this.this$0);
    if (localEngineInitStatistic == null) {
      Intrinsics.throwNpe();
    }
    if (!localEngineInitStatistic.getSuccess())
    {
      EngineInit.access$getEngine$p(this.this$0).destroy();
      this.this$0.getEngineContext().getMainThreadExecutor().execute((Runnable)new EngineInit.launchGameLocked.1.1(this, localEngineInitStatistic));
      return;
    }
    EngineInit.access$performLaunchGame(this.this$0, this.$param, this.$gameLaunchCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.engine.init.EngineInit.launchGameLocked.1
 * JD-Core Version:    0.7.0.1
 */