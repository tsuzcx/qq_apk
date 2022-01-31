package com.tencent.qqmini.sdk.minigame.ui;

import bewz;

public class GameRuntimeStateObserver$5
  implements Runnable
{
  public GameRuntimeStateObserver$5(bewz parambewz, Float paramFloat) {}
  
  public void run()
  {
    bewz.a(this.this$0).setProgressTxt((int)(this.a.floatValue() * 100.0F) + "%");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.ui.GameRuntimeStateObserver.5
 * JD-Core Version:    0.7.0.1
 */