package com.tencent.thumbplayer.api.richmedia;

public abstract interface ITPRichMediaSynchronizer
{
  public abstract void deselectFeatureAsync(int paramInt);
  
  public abstract TPRichMediaFeature[] getFeatures();
  
  public abstract void prepareAsync();
  
  public abstract void release();
  
  public abstract void reset();
  
  public abstract void selectFeatureAsync(int paramInt, TPRichMediaRequestExtraInfo paramTPRichMediaRequestExtraInfo);
  
  public abstract void setListener(ITPRichMediaSynchronizerListener paramITPRichMediaSynchronizerListener);
  
  public abstract void setRichMediaSource(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer
 * JD-Core Version:    0.7.0.1
 */