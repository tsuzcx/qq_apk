package com.tencent.mobileqq.minigame.task;

import android.content.Context;
import com.tencent.mobileqq.mini.tfs.AsyncTask;
import com.tencent.mobileqq.minigame.manager.EngineInstanceManager;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoader.GameRuntimeProgressListener;
import com.tencent.mobileqq.minigame.manager.InstalledEngine;
import com.tencent.mobileqq.minigame.utils.GameLog;

public class InstalledEngineLoadTask
  extends AsyncTask
{
  private final String TAG = toString();
  private GameRuntimeLoader.GameRuntimeProgressListener mListener;
  
  public InstalledEngineLoadTask(Context paramContext, GameRuntimeLoader.GameRuntimeProgressListener paramGameRuntimeProgressListener)
  {
    super(paramContext);
    this.mListener = paramGameRuntimeProgressListener;
    GameLog.getInstance().i(this.TAG, "new InstalledEngineLoadTask");
  }
  
  public void executeAsync()
  {
    if (getInstalledEngine() != null)
    {
      GameLog.getInstance().i(this.TAG, "getInstalledEngine:" + getInstalledEngine());
      onTaskSucceed();
      return;
    }
    EngineInstanceManager.g().tryGetEngineFromMainProcess(new InstalledEngineLoadTask.1(this));
  }
  
  public InstalledEngine getInstalledEngine()
  {
    return EngineInstanceManager.g().getEngineInstance();
  }
  
  public String getInstalledEnginePath()
  {
    return EngineInstanceManager.g().getEngineInstancePath();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.task.InstalledEngineLoadTask
 * JD-Core Version:    0.7.0.1
 */