package com.tencent.mobileqq.minigame.ui;

import com.tencent.mobileqq.minigame.manager.GameRuntimeLoader;
import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.engine.GameLaunchCallback;
import com.tencent.mobileqq.triton.statistic.FirstFrameStatistic;
import com.tencent.mobileqq.triton.statistic.GameLaunchStatistic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class GameActivity$35$1
  implements GameLaunchCallback
{
  GameActivity$35$1(GameActivity.35 param35) {}
  
  public void onFirstFrame(@NotNull FirstFrameStatistic paramFirstFrameStatistic)
  {
    GameActivity.access$5400(this.this$1.this$0, paramFirstFrameStatistic);
  }
  
  public void onGameLaunched(@Nullable TritonEngine paramTritonEngine, @NotNull GameLaunchStatistic paramGameLaunchStatistic)
  {
    GameActivity.access$000(this.this$1.this$0).setGameEngine(paramTritonEngine);
    GameActivity.access$5300(this.this$1.this$0, paramTritonEngine, paramGameLaunchStatistic);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.35.1
 * JD-Core Version:    0.7.0.1
 */