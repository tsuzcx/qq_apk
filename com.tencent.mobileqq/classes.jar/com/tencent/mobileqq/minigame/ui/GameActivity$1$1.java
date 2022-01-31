package com.tencent.mobileqq.minigame.ui;

import com.tencent.mobileqq.mini.monitor.ui.MiniAppMonitorInfoView;

class GameActivity$1$1
  implements Runnable
{
  GameActivity$1$1(GameActivity.1 param1, float paramFloat) {}
  
  public void run()
  {
    if (this.this$1.this$0.mMiniAppMonitorInfoView != null) {
      this.this$1.this$0.mMiniAppMonitorInfoView.updateFPSText(this.val$fps);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.1.1
 * JD-Core Version:    0.7.0.1
 */