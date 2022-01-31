package com.tencent.qqmini.sdk.minigame;

import android.os.Process;
import bgtj;

public class GameRuntime$5
  implements Runnable
{
  public GameRuntime$5(bgtj parambgtj) {}
  
  public void run()
  {
    Process.killProcess(Process.myPid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.GameRuntime.5
 * JD-Core Version:    0.7.0.1
 */