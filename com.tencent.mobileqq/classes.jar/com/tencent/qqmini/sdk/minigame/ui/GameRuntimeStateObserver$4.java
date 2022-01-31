package com.tencent.qqmini.sdk.minigame.ui;

import android.app.Activity;
import bewi;

public class GameRuntimeStateObserver$4
  implements Runnable
{
  public GameRuntimeStateObserver$4(bewi parambewi) {}
  
  public void run()
  {
    if (!bewi.a(this.this$0).isFinishing()) {
      bewi.a(this.this$0).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.ui.GameRuntimeStateObserver.4
 * JD-Core Version:    0.7.0.1
 */