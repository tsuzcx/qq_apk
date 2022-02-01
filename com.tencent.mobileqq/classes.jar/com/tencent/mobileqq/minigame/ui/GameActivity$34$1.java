package com.tencent.mobileqq.minigame.ui;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.triton.sdk.callback.GameLaunchCallback;
import com.tencent.mobileqq.triton.sdk.statics.FirstRenderStatistic;
import com.tencent.mobileqq.triton.sdk.statics.GameLaunchStatistic;

class GameActivity$34$1
  implements GameLaunchCallback
{
  GameActivity$34$1(GameActivity.34 param34) {}
  
  public void onFirstRender(@NonNull FirstRenderStatistic paramFirstRenderStatistic)
  {
    GameActivity.access$5100(this.this$1.this$0, paramFirstRenderStatistic);
  }
  
  public void onGameLaunched(@NonNull GameLaunchStatistic paramGameLaunchStatistic)
  {
    GameActivity.access$5000(this.this$1.this$0, paramGameLaunchStatistic);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.34.1
 * JD-Core Version:    0.7.0.1
 */