package com.tencent.mtt.hippy.views.audioview;

public abstract interface AudioPlayManager$AudioManagerListener
{
  public abstract void onPlayBuffering(String paramString);
  
  public abstract void onPlayComplete(String paramString);
  
  public abstract void onPlayError(String paramString, int paramInt1, int paramInt2);
  
  public abstract void onPlayPause(String paramString);
  
  public abstract void onPlayProgress(String paramString, int paramInt1, int paramInt2);
  
  public abstract void onPlayResume(String paramString);
  
  public abstract void onPlayStart(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.audioview.AudioPlayManager.AudioManagerListener
 * JD-Core Version:    0.7.0.1
 */