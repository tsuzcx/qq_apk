package com.tencent.qqmini.minigame.task;

import android.content.Context;
import com.tencent.mobileqq.triton.TritonPlatform;
import com.tencent.qqmini.minigame.GameRuntime;
import com.tencent.qqmini.sdk.annotation.ClassTag;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.task.MainThreadTask;

@ClassTag(tag="InitGameRuntimeTask")
public class InitGameRuntimeTask
  extends MainThreadTask
{
  private static final String TAG = "InitGameRuntimeTask";
  
  public InitGameRuntimeTask(Context paramContext, BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    super(paramContext, paramBaseRuntimeLoader);
  }
  
  public void executeInMainThread()
  {
    Object localObject = getDependTasks();
    GameRuntime localGameRuntime = null;
    if (localObject != null)
    {
      localGameRuntime = (GameRuntime)getRuntimeLoader().getRuntime();
      localObject = ((TritonEngineInitTask)getRuntimeLoader().getTask(TritonEngineInitTask.class)).getTritonPlatform();
    }
    else
    {
      localObject = null;
    }
    MiniAppInfo localMiniAppInfo = getRuntimeLoader().getMiniAppInfo();
    if ((localGameRuntime != null) && (localObject != null) && (localMiniAppInfo != null)) {
      try
      {
        localGameRuntime.init((TritonPlatform)localObject);
        localGameRuntime.loadMiniApp(localMiniAppInfo);
        onTaskSucceed();
        return;
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("InitGameRuntimeTask", localThrowable.getMessage(), localThrowable);
        onTaskFailed();
        return;
      }
    }
    onTaskFailed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.task.InitGameRuntimeTask
 * JD-Core Version:    0.7.0.1
 */