package com.tencent.mobileqq.minigame.ui;

import absn;
import abso;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.ui.CapsuleButton;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.minigame.jsapi.manager.FloatDragAdDataManager;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoader;
import com.tencent.mobileqq.triton.TritonEngine;

class GameActivity$29
  implements Runnable
{
  GameActivity$29(GameActivity paramGameActivity) {}
  
  public void run()
  {
    GameActivity.access$4000(this.this$0);
    absn.a().a(this.this$0, new abso());
    MiniGameAdBannerPopup.checkShouldShow(this.this$0, this.this$0.mGameAppConfig);
    FloatDragAdDataManager.requestAd(this.this$0, this.this$0.mGameAppConfig.config.appId, this.this$0.mGameAppConfig.launchParam.scene);
    if ((GameActivity.access$4100(this.this$0) != null) && (GameActivity.access$4100(this.this$0).getCapsuleButton() != null))
    {
      GameActivity.access$4100(this.this$0).getCapsuleButton().showKingCardTips();
      GameActivity.access$4100(this.this$0).getCapsuleButton().updateRedDotVisible();
      GameActivity.access$4100(this.this$0).getCapsuleButton().setMoreStatus(0);
    }
    if (GameActivity.access$4200(this.this$0) == 2)
    {
      TritonEngine localTritonEngine = GameActivity.access$000(this.this$0).getGameEngine();
      if (localTritonEngine != null) {
        localTritonEngine.stop();
      }
    }
    for (;;)
    {
      GameActivity.access$4300(this.this$0);
      return;
      GameActivity.access$3000(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.29
 * JD-Core Version:    0.7.0.1
 */