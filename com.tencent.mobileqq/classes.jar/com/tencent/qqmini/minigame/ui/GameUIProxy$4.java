package com.tencent.qqmini.minigame.ui;

import android.app.Activity;
import com.tencent.qqmini.minigame.GameRuntime;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.MiniLoadingAdManager;

class GameUIProxy$4
  implements Runnable
{
  GameUIProxy$4(GameUIProxy paramGameUIProxy, MiniAppInfo paramMiniAppInfo, Activity paramActivity, String paramString, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    if (!this.this$0.isAbleToShowAd()) {
      return;
    }
    if (GameUIProxy.access$200(this.this$0) != null) {
      GameUIProxy.access$200(this.this$0).onLoadingAdShowBegin();
    }
    MiniLoadingAdManager.getInstance().updateLoadingAdLayoutAndShow(this.a, this.b, true, this.c, this.d, this.e, new GameUIProxy.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.ui.GameUIProxy.4
 * JD-Core Version:    0.7.0.1
 */