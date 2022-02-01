package com.tencent.mobileqq.triton.engine;

import androidx.annotation.MainThread;
import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.statistic.FirstFrameStatistic;
import com.tencent.mobileqq.triton.statistic.GameLaunchStatistic;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/engine/GameLaunchCallback;", "", "onFirstFrame", "", "statics", "Lcom/tencent/mobileqq/triton/statistic/FirstFrameStatistic;", "onGameLaunched", "engine", "Lcom/tencent/mobileqq/triton/TritonEngine;", "Lcom/tencent/mobileqq/triton/statistic/GameLaunchStatistic;", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public abstract interface GameLaunchCallback
{
  @MainThread
  public abstract void onFirstFrame(@NotNull FirstFrameStatistic paramFirstFrameStatistic);
  
  @MainThread
  public abstract void onGameLaunched(@Nullable TritonEngine paramTritonEngine, @NotNull GameLaunchStatistic paramGameLaunchStatistic);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.engine.GameLaunchCallback
 * JD-Core Version:    0.7.0.1
 */