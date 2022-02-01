package com.tencent.qqmini.sdk.manager;

import com.tencent.qqmini.sdk.task.BaseTask;

public abstract interface MiniLoadManager$MiniLoadListener
{
  public abstract void onEngineLoad(boolean paramBoolean, String paramString);
  
  public abstract void onGpkgLoad(boolean paramBoolean, String paramString);
  
  public abstract void onTaskProgress(BaseTask paramBaseTask, float paramFloat, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.MiniLoadManager.MiniLoadListener
 * JD-Core Version:    0.7.0.1
 */