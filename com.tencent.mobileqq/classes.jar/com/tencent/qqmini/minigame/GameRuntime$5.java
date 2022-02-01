package com.tencent.qqmini.minigame;

import android.os.Process;

class GameRuntime$5
  implements Runnable
{
  GameRuntime$5(GameRuntime paramGameRuntime) {}
  
  public void run()
  {
    Process.killProcess(Process.myPid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.GameRuntime.5
 * JD-Core Version:    0.7.0.1
 */