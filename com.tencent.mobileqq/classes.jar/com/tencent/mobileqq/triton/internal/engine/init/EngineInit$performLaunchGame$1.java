package com.tencent.mobileqq.triton.internal.engine.init;

import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.engine.GameLaunchCallback;
import com.tencent.mobileqq.triton.internal.model.PlatformConfig;
import com.tencent.mobileqq.triton.statistic.FirstFrameStatistic;
import com.tencent.mobileqq.triton.statistic.GameLaunchStatistic;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/triton/internal/engine/init/EngineInit$performLaunchGame$1", "Lcom/tencent/mobileqq/triton/engine/GameLaunchCallback;", "onFirstFrame", "", "statics", "Lcom/tencent/mobileqq/triton/statistic/FirstFrameStatistic;", "onGameLaunched", "engine", "Lcom/tencent/mobileqq/triton/TritonEngine;", "Lcom/tencent/mobileqq/triton/statistic/GameLaunchStatistic;", "Triton_release"}, k=1, mv={1, 1, 16})
public final class EngineInit$performLaunchGame$1
  implements GameLaunchCallback
{
  EngineInit$performLaunchGame$1(GameLaunchCallback paramGameLaunchCallback) {}
  
  public void onFirstFrame(@NotNull FirstFrameStatistic paramFirstFrameStatistic)
  {
    Intrinsics.checkParameterIsNotNull(paramFirstFrameStatistic, "statics");
    EngineInit.access$getPlatformConfig$p(this.this$0).getMainThreadExecutor().execute((Runnable)new EngineInit.performLaunchGame.1.onFirstFrame.1(this, paramFirstFrameStatistic));
  }
  
  public void onGameLaunched(@Nullable TritonEngine paramTritonEngine, @NotNull GameLaunchStatistic paramGameLaunchStatistic)
  {
    Intrinsics.checkParameterIsNotNull(paramGameLaunchStatistic, "statics");
    EngineInit.access$getPlatformConfig$p(this.this$0).getMainThreadExecutor().execute((Runnable)new EngineInit.performLaunchGame.1.onGameLaunched.1(this, paramGameLaunchStatistic));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.engine.init.EngineInit.performLaunchGame.1
 * JD-Core Version:    0.7.0.1
 */