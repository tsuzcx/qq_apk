package com.tencent.qqmini.sdk.minigame;

import android.app.Activity;
import betc;
import beuy;

public class GameRuntime$3
  implements Runnable
{
  public GameRuntime$3(beuy parambeuy) {}
  
  public void run()
  {
    try
    {
      betc.b("GameRuntime", "exit mini game. moveTaskToBack");
      beuy.a(this.this$0).moveTaskToBack(true);
      return;
    }
    catch (Throwable localThrowable)
    {
      betc.d("GameRuntime", "exit mini game. failed:", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.GameRuntime.3
 * JD-Core Version:    0.7.0.1
 */