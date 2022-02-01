package com.tencent.qqmini.minigame.ui;

import com.tencent.qqmini.minigame.GameRuntime;
import com.tencent.qqmini.sdk.manager.MiniLoadingAdManager.OnDismissListener;

class GameUIProxy$4$1
  implements MiniLoadingAdManager.OnDismissListener
{
  GameUIProxy$4$1(GameUIProxy.4 param4) {}
  
  public void onDismiss()
  {
    if (GameUIProxy.access$200(this.a.this$0) != null) {
      GameUIProxy.access$200(this.a.this$0).onLoadingAdShowEnd();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.ui.GameUIProxy.4.1
 * JD-Core Version:    0.7.0.1
 */