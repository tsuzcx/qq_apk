package com.tencent.qqmini.minigame.ui;

import android.app.Activity;

class GameRuntimeStateObserver$5
  implements Runnable
{
  GameRuntimeStateObserver$5(GameRuntimeStateObserver paramGameRuntimeStateObserver) {}
  
  public void run()
  {
    if ((GameRuntimeStateObserver.access$200(this.this$0) != null) && (!GameRuntimeStateObserver.access$200(this.this$0).isFinishing())) {
      GameRuntimeStateObserver.access$200(this.this$0).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.ui.GameRuntimeStateObserver.5
 * JD-Core Version:    0.7.0.1
 */