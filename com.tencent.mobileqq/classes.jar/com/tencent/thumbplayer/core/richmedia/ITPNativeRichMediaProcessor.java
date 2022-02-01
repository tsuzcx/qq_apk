package com.tencent.thumbplayer.core.richmedia;

public abstract interface ITPNativeRichMediaProcessor
{
  public abstract void deselectFeatureAsync(int paramInt);
  
  public abstract TPNativeRichMediaFeatureData getCurrentPositionMsFeatureData(long paramLong, int[] paramArrayOfInt);
  
  public abstract TPNativeRichMediaFeature[] getFeatures();
  
  public abstract void prepareAsync();
  
  public abstract void release();
  
  public abstract void reset();
  
  public abstract void seek(long paramLong);
  
  public abstract void selectFeatureAsync(int paramInt, TPNativeRichMediaRequestExtraInfo paramTPNativeRichMediaRequestExtraInfo);
  
  public abstract void setInnerProcessorCallback(ITPNativeRichMediaInnerProcessorCallback paramITPNativeRichMediaInnerProcessorCallback);
  
  public abstract void setPlaybackRate(float paramFloat);
  
  public abstract void setProcessorCallback(ITPNativeRichMediaProcessorCallback paramITPNativeRichMediaProcessorCallback);
  
  public abstract void setRichMediaSource(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.richmedia.ITPNativeRichMediaProcessor
 * JD-Core Version:    0.7.0.1
 */