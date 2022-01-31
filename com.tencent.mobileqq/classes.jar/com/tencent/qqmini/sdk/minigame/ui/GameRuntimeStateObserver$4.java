package com.tencent.qqmini.sdk.minigame.ui;

import bgvn;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class GameRuntimeStateObserver$4
  implements Runnable
{
  public GameRuntimeStateObserver$4(bgvn parambgvn) {}
  
  public void run()
  {
    if (bgvn.a(this.this$0) != null) {
      bgvn.a(this.this$0).a();
    }
    if ((bgvn.a(this.this$0) != null) && (bgvn.a(this.this$0).launchParam != null)) {
      MiniGameAdBannerPopup.a(bgvn.a(this.this$0), bgvn.a(this.this$0).appId, bgvn.a(this.this$0).launchParam.scene);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.ui.GameRuntimeStateObserver.4
 * JD-Core Version:    0.7.0.1
 */