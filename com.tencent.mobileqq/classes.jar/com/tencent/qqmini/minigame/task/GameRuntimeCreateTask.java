package com.tencent.qqmini.minigame.task;

import android.content.Context;
import com.tencent.qqmini.minigame.GameRuntime;
import com.tencent.qqmini.sdk.annotation.ClassTag;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.task.MainThreadTask;

@ClassTag(tag="GameRuntimeCreateTask")
public class GameRuntimeCreateTask
  extends MainThreadTask
{
  private static final String TAG = "GameRuntimeCreateTask";
  
  public GameRuntimeCreateTask(Context paramContext, BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    super(paramContext, paramBaseRuntimeLoader);
  }
  
  public void executeInMainThread()
  {
    try
    {
      BaseRuntime localBaseRuntime = getRuntimeLoader().getRuntime();
      if ((localBaseRuntime != null) && ((localBaseRuntime instanceof GameRuntime)))
      {
        onTaskSucceed();
        return;
      }
      onTaskFailed();
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("GameRuntimeCreateTask", "Failed execute GameRuntimeCreateTask", localThrowable);
      onTaskFailed();
    }
  }
  
  public GameRuntime getGameRuntime()
  {
    return (GameRuntime)getRuntimeLoader().getRuntime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.task.GameRuntimeCreateTask
 * JD-Core Version:    0.7.0.1
 */