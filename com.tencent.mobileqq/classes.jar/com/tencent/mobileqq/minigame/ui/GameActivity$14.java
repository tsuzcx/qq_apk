package com.tencent.mobileqq.minigame.ui;

import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.widget.MiniLoadingAdLayout.OnDismissListener;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoader;
import com.tencent.mobileqq.triton.TritonEngine;

class GameActivity$14
  implements MiniLoadingAdLayout.OnDismissListener
{
  GameActivity$14(GameActivity paramGameActivity) {}
  
  public void onDismiss(boolean paramBoolean)
  {
    if (paramBoolean) {
      MiniProgramLpReportDC04239.reportMiniAppEvent(this.this$0.mGameAppConfig, MiniProgramLpReportDC04239.getAppType(this.this$0.mGameAppConfig), null, "ad", "ad_loading", "skip", null);
    }
    GameActivity.access$2900(this.this$0, 3);
    TritonEngine localTritonEngine = GameActivity.access$000(this.this$0).getGameEngine();
    if (localTritonEngine != null) {
      localTritonEngine.start();
    }
    GameActivity.access$3000(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.14
 * JD-Core Version:    0.7.0.1
 */