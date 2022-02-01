package com.tencent.qqmini.miniapp.util;

public abstract interface VideoCompress$Listener
{
  public abstract void onFailure(String paramString);
  
  public abstract void onFinish(boolean paramBoolean);
  
  public abstract void onProgress(String paramString, float paramFloat);
  
  public abstract void onStart();
  
  public abstract void onSuccess(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.util.VideoCompress.Listener
 * JD-Core Version:    0.7.0.1
 */