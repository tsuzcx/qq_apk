package com.tencent.qqmini.sdk.minigame.ui;

import bdqv;

public class GameRuntimeStateObserver$4
  implements Runnable
{
  public GameRuntimeStateObserver$4(bdqv parambdqv, Float paramFloat) {}
  
  public void run()
  {
    bdqv.a(this.this$0).setProgressTxt((int)(this.a.floatValue() * 100.0F) + "%");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.ui.GameRuntimeStateObserver.4
 * JD-Core Version:    0.7.0.1
 */