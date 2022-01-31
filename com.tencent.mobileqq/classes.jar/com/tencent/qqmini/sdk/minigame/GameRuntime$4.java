package com.tencent.qqmini.sdk.minigame;

import android.app.Activity;
import bdnw;
import bdoz;

public class GameRuntime$4
  implements Runnable
{
  public GameRuntime$4(bdoz parambdoz) {}
  
  public void run()
  {
    try
    {
      bdnw.b("GameRuntime", "exit mini game. moveTaskToBack");
      bdoz.a(this.this$0).moveTaskToBack(true);
      return;
    }
    catch (Throwable localThrowable)
    {
      bdnw.d("GameRuntime", "exit mini game. failed:", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.GameRuntime.4
 * JD-Core Version:    0.7.0.1
 */