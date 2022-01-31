package com.tencent.mobileqq.minigame.manager;

import com.tencent.mobileqq.mini.tfs.BaseTask;

public abstract interface GameLoadManager$GameLoadListener
{
  public abstract void onEngineLoad(boolean paramBoolean, String paramString, int paramInt);
  
  public abstract void onGpkgLoad(boolean paramBoolean, String paramString);
  
  public abstract void onInitRuntimeDone();
  
  public abstract void onJsPluginEngineLoad(boolean paramBoolean, String paramString);
  
  public abstract void onTaskProgress(BaseTask paramBaseTask, float paramFloat, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameLoadManager.GameLoadListener
 * JD-Core Version:    0.7.0.1
 */