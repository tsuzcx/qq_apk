package com.tencent.mobileqq.minigame.ui;

import acsb;
import acsc;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.ui.CapsuleButton;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.minigame.jsapi.manager.FloatDragAdDataManager;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoader;
import com.tencent.mobileqq.triton.sdk.ITTEngine;

class GameActivity$28
  implements Runnable
{
  GameActivity$28(GameActivity paramGameActivity) {}
  
  public void run()
  {
    GameActivity.access$4000(this.this$0);
    acsb.a().a(this.this$0, new acsc());
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
      ITTEngine localITTEngine = GameActivity.access$1500(this.this$0).getGameEngine();
      if (localITTEngine != null) {
        localITTEngine.onPause();
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
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.28
 * JD-Core Version:    0.7.0.1
 */