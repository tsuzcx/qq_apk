package com.tencent.mobileqq.minigame.manager;

public abstract interface GameRuntimeLoader$GameRuntimeListener
  extends GameRuntimeLoader.GameRuntimeProgressListener
{
  public abstract void onEngineLoad(boolean paramBoolean, String paramString, int paramInt);
  
  public abstract void onGpkgLoad(boolean paramBoolean, String paramString);
  
  public abstract void onInitRuntimeDone();
  
  public abstract void onJsPluginEngineLoad(boolean paramBoolean, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameRuntimeLoader.GameRuntimeListener
 * JD-Core Version:    0.7.0.1
 */