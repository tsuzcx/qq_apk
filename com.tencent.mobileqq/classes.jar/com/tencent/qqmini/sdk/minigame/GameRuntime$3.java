package com.tencent.qqmini.sdk.minigame;

import android.app.Activity;
import besl;
import beuh;

public class GameRuntime$3
  implements Runnable
{
  public GameRuntime$3(beuh parambeuh) {}
  
  public void run()
  {
    try
    {
      besl.b("GameRuntime", "exit mini game. moveTaskToBack");
      beuh.a(this.this$0).moveTaskToBack(true);
      return;
    }
    catch (Throwable localThrowable)
    {
      besl.d("GameRuntime", "exit mini game. failed:", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.GameRuntime.3
 * JD-Core Version:    0.7.0.1
 */