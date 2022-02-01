package com.tencent.qqmini.sdk.manager;

public abstract interface EngineInstaller$Callback
{
  public abstract void onEngineWorkAbort();
  
  public abstract void onEngineWorkBegin();
  
  public abstract void onEngineWorkFinish();
  
  public abstract void onMessageUpdate(float paramFloat, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.EngineInstaller.Callback
 * JD-Core Version:    0.7.0.1
 */