package com.tencent.qqmini.sdk.minigame.ui;

import bewz;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class GameRuntimeStateObserver$8
  implements Runnable
{
  public GameRuntimeStateObserver$8(bewz parambewz) {}
  
  public void run()
  {
    bewz.a(this.this$0).a();
    if ((bewz.a(this.this$0) != null) && (bewz.a(this.this$0).launchParam != null)) {
      MiniGameAdBannerPopup.a(bewz.a(this.this$0), bewz.a(this.this$0).appId, bewz.a(this.this$0).launchParam.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.ui.GameRuntimeStateObserver.8
 * JD-Core Version:    0.7.0.1
 */