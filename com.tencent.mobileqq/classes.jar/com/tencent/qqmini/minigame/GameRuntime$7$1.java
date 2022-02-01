package com.tencent.qqmini.minigame;

import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.engine.GameLaunchCallback;
import com.tencent.mobileqq.triton.statistic.FirstFrameStatistic;
import com.tencent.mobileqq.triton.statistic.GameLaunchStatistic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class GameRuntime$7$1
  implements GameLaunchCallback
{
  GameRuntime$7$1(GameRuntime.7 param7) {}
  
  public void onFirstFrame(@NotNull FirstFrameStatistic paramFirstFrameStatistic)
  {
    GameRuntime.access$700(this.this$1.this$0, paramFirstFrameStatistic);
  }
  
  public void onGameLaunched(@Nullable TritonEngine paramTritonEngine, @NotNull GameLaunchStatistic paramGameLaunchStatistic)
  {
    GameRuntime.access$600(this.this$1.this$0, paramTritonEngine, paramGameLaunchStatistic);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.GameRuntime.7.1
 * JD-Core Version:    0.7.0.1
 */