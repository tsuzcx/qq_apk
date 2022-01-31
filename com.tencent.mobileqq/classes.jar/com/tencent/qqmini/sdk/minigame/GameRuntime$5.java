package com.tencent.qqmini.sdk.minigame;

import android.os.Process;
import bdoz;

public class GameRuntime$5
  implements Runnable
{
  public GameRuntime$5(bdoz parambdoz) {}
  
  public void run()
  {
    Process.killProcess(Process.myPid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.GameRuntime.5
 * JD-Core Version:    0.7.0.1
 */