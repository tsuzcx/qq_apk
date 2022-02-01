package com.tencent.mobileqq.minigame.ui;

import com.tencent.mobileqq.minigame.task.LaunchEngineUISteps;
import com.tencent.qphone.base.util.QLog;

class GameActivity$2
  implements Runnable
{
  GameActivity$2(GameActivity paramGameActivity) {}
  
  public void run()
  {
    if (!GameActivity.access$200(this.this$0).isDone()) {
      QLog.e("[minigame] GameActivity", 1, "GameLaunchStuck for 10S GameLoadTaskExecutionStatics:\n" + GameActivity.access$300(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.2
 * JD-Core Version:    0.7.0.1
 */