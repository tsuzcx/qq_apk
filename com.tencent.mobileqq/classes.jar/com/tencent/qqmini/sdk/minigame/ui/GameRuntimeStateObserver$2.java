package com.tencent.qqmini.sdk.minigame.ui;

import android.app.Activity;
import bgzu;

public class GameRuntimeStateObserver$2
  implements Runnable
{
  public GameRuntimeStateObserver$2(bgzu parambgzu) {}
  
  public void run()
  {
    if (!bgzu.a(this.this$0).isFinishing()) {
      bgzu.a(this.this$0).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.ui.GameRuntimeStateObserver.2
 * JD-Core Version:    0.7.0.1
 */