package com.tencent.qqmini.minigame.ui;

import com.tencent.qqmini.minigame.task.LaunchEngineUISteps;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.task.TaskStaticsVisualizer;

class GameRuntimeStateObserver$1
  implements Runnable
{
  GameRuntimeStateObserver$1(GameRuntimeStateObserver paramGameRuntimeStateObserver) {}
  
  public void run()
  {
    if (!GameRuntimeStateObserver.access$000(this.this$0).isDone())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("GameLaunchStuck for 10S GameLoadTaskExecutionStatics:\n");
      localStringBuilder.append(TaskStaticsVisualizer.visualizeToString(GameRuntimeStateObserver.access$100(this.this$0)));
      QMLog.e("GameRuntimeState", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.ui.GameRuntimeStateObserver.1
 * JD-Core Version:    0.7.0.1
 */