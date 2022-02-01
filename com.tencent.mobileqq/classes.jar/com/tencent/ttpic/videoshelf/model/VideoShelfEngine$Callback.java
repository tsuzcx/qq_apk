package com.tencent.ttpic.videoshelf.model;

public abstract interface VideoShelfEngine$Callback
{
  public abstract void onCancelCompleted();
  
  public abstract void onCompleted();
  
  public abstract void onError(int paramInt1, int paramInt2, String paramString);
  
  public abstract void onProgress(int paramInt);
  
  public abstract void onStartGenerate();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.model.VideoShelfEngine.Callback
 * JD-Core Version:    0.7.0.1
 */