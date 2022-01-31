package com.tencent.mobileqq.minigame.manager;

import com.tencent.mobileqq.mini.tfs.BaseTask;

public abstract interface PreloadManager$PreloadListener
{
  public abstract void onPreloadEngineLoad(boolean paramBoolean, String paramString, int paramInt);
  
  public abstract void onPreloadGpkgLoad(boolean paramBoolean, String paramString);
  
  public abstract void onPreloadInitRuntimeDone();
  
  public abstract void onPreloadTaskProgress(BaseTask paramBaseTask, float paramFloat, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.PreloadManager.PreloadListener
 * JD-Core Version:    0.7.0.1
 */