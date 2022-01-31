package com.tencent.qqmini.sdk.minigame;

import android.os.Process;
import beuh;

public class GameRuntime$4
  implements Runnable
{
  public GameRuntime$4(beuh parambeuh) {}
  
  public void run()
  {
    Process.killProcess(Process.myPid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.GameRuntime.4
 * JD-Core Version:    0.7.0.1
 */