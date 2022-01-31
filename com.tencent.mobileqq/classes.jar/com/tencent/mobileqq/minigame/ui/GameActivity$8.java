package com.tencent.mobileqq.minigame.ui;

import com.tencent.mobileqq.minigame.manager.GameRuntimeLoader;
import com.tencent.mobileqq.triton.sdk.ITTEngine;

class GameActivity$8
  implements Runnable
{
  GameActivity$8(GameActivity paramGameActivity) {}
  
  public void run()
  {
    if ((this.this$0.isResume()) && (GameActivity.access$1100(this.this$0)) && (!GameActivity.access$1200(this.this$0)))
    {
      GameActivity.access$1202(this.this$0, true);
      GameActivity.access$1300(this.this$0).getGameEngine().onResume();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.8
 * JD-Core Version:    0.7.0.1
 */