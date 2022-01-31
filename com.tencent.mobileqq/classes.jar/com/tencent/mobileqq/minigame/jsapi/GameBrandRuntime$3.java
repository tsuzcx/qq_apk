package com.tencent.mobileqq.minigame.jsapi;

import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.mobileqq.minigame.utils.GameLog;

class GameBrandRuntime$3
  implements Runnable
{
  GameBrandRuntime$3(GameBrandRuntime paramGameBrandRuntime, GameActivity paramGameActivity) {}
  
  public void run()
  {
    try
    {
      GameLog.getInstance().i("GameBrandRuntime", "exit mini program. moveTaskToBack");
      this.val$activity.moveTaskToBack(true);
      return;
    }
    catch (Throwable localThrowable)
    {
      GameLog.getInstance().e("GameBrandRuntime", "exit mini program. failed:", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.GameBrandRuntime.3
 * JD-Core Version:    0.7.0.1
 */