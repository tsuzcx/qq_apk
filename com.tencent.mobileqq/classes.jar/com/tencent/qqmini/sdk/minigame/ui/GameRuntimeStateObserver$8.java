package com.tencent.qqmini.sdk.minigame.ui;

import bewi;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class GameRuntimeStateObserver$8
  implements Runnable
{
  public GameRuntimeStateObserver$8(bewi parambewi) {}
  
  public void run()
  {
    bewi.a(this.this$0).a();
    if ((bewi.a(this.this$0) != null) && (bewi.a(this.this$0).launchParam != null)) {
      MiniGameAdBannerPopup.a(bewi.a(this.this$0), bewi.a(this.this$0).appId, bewi.a(this.this$0).launchParam.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.ui.GameRuntimeStateObserver.8
 * JD-Core Version:    0.7.0.1
 */