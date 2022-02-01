package com.tencent.qqmini.minigame.ui;

import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;

class GameUIProxy$2
  implements Runnable
{
  GameUIProxy$2(GameUIProxy paramGameUIProxy) {}
  
  public void run()
  {
    GameUIProxy.access$200(this.this$0).onRuntimeAttachActivity(GameUIProxy.access$000(this.this$0), GameUIProxy.access$100(this.this$0));
    GameUIProxy.access$200(this.this$0).onRuntimeResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.ui.GameUIProxy.2
 * JD-Core Version:    0.7.0.1
 */