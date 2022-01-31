package com.tencent.qqmini.sdk.minigame.ui;

import bgzu;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class GameRuntimeStateObserver$4
  implements Runnable
{
  public GameRuntimeStateObserver$4(bgzu parambgzu) {}
  
  public void run()
  {
    if (bgzu.a(this.this$0) != null) {
      bgzu.a(this.this$0).a();
    }
    if ((bgzu.a(this.this$0) != null) && (bgzu.a(this.this$0).launchParam != null)) {
      MiniGameAdBannerPopup.a(bgzu.a(this.this$0), bgzu.a(this.this$0).appId, bgzu.a(this.this$0).launchParam.scene);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.ui.GameRuntimeStateObserver.4
 * JD-Core Version:    0.7.0.1
 */