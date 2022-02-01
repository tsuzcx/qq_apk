package com.tencent.qqmini.minigame.ui;

import com.tencent.qqmini.minigame.GameRuntime;
import com.tencent.qqmini.sdk.manager.MiniLoadingAdManager.OnDismissListener;

class GameUIProxy$3$1
  implements MiniLoadingAdManager.OnDismissListener
{
  GameUIProxy$3$1(GameUIProxy.3 param3) {}
  
  public void onDismiss()
  {
    if (GameUIProxy.access$200(this.this$1.this$0) != null)
    {
      GameRuntime localGameRuntime = (GameRuntime)GameUIProxy.access$200(this.this$1.this$0);
      localGameRuntime.resumeEngineOnly();
      localGameRuntime.setLoadingAdStatus(3);
      localGameRuntime.checkPayForFriendLogic(this.this$1.val$miniAppInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.ui.GameUIProxy.3.1
 * JD-Core Version:    0.7.0.1
 */