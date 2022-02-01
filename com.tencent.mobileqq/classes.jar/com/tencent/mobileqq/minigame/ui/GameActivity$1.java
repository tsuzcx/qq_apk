package com.tencent.mobileqq.minigame.ui;

import android.os.Handler;
import com.tencent.mobileqq.mini.report.MiniGamePerformanceStatics;
import com.tencent.mobileqq.triton.sdk.FPSCallback;

class GameActivity$1
  implements FPSCallback
{
  GameActivity$1(GameActivity paramGameActivity) {}
  
  public void onFPSChange(float paramFloat)
  {
    GameActivity.access$000(this.this$0).onGetFps(paramFloat);
    GameActivity.access$100(this.this$0).post(new GameActivity.1.1(this, paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.1
 * JD-Core Version:    0.7.0.1
 */