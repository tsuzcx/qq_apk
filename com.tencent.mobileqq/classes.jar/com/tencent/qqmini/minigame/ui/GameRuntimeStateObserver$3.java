package com.tencent.qqmini.minigame.ui;

import com.tencent.qqmini.minigame.manager.FloatDragAdDataManager;
import com.tencent.qqmini.minigame.manager.PendantDataManager;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class GameRuntimeStateObserver$3
  implements Runnable
{
  GameRuntimeStateObserver$3(GameRuntimeStateObserver paramGameRuntimeStateObserver) {}
  
  public void run()
  {
    if (GameRuntimeStateObserver.access$300(this.this$0) != null) {
      GameRuntimeStateObserver.access$300(this.this$0).hide();
    }
    if ((GameRuntimeStateObserver.access$400(this.this$0) != null) && (GameRuntimeStateObserver.access$400(this.this$0).launchParam != null))
    {
      MiniGameAdBannerPopup.checkShouldShow(GameRuntimeStateObserver.access$200(this.this$0), GameRuntimeStateObserver.access$400(this.this$0).appId, GameRuntimeStateObserver.access$400(this.this$0).launchParam.scene);
      FloatDragAdDataManager.requestAd(GameRuntimeStateObserver.access$200(this.this$0), GameRuntimeStateObserver.access$500(this.this$0).getGameRuntime(), GameRuntimeStateObserver.access$400(this.this$0).appId, GameRuntimeStateObserver.access$400(this.this$0).launchParam.scene);
      PendantDataManager.requestAd(GameRuntimeStateObserver.access$200(this.this$0), GameRuntimeStateObserver.access$500(this.this$0).getGameRuntime(), GameRuntimeStateObserver.access$400(this.this$0).appId, GameRuntimeStateObserver.access$400(this.this$0).launchParam.scene);
      if (GameRuntimeStateObserver.access$500(this.this$0) != null) {
        GameRuntimeStateObserver.access$500(this.this$0).preloadLoadingAd();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.ui.GameRuntimeStateObserver.3
 * JD-Core Version:    0.7.0.1
 */