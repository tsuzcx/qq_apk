package com.tencent.thumbplayer.api.richmedia;

import com.tencent.thumbplayer.api.TPTimeRange;

public abstract interface ITPRichMediaAsyncRequester
{
  public abstract void cancelRequest(int paramInt);
  
  public abstract TPRichMediaFeature[] getFeatures();
  
  public abstract void prepareAsync();
  
  public abstract void release();
  
  public abstract int requestFeatureDataAsyncAtTimeMs(int paramInt, long paramLong);
  
  public abstract int requestFeatureDataAsyncAtTimeMsArray(int paramInt, long[] paramArrayOfLong);
  
  public abstract int requestFeatureDataAsyncAtTimeRange(int paramInt, TPTimeRange paramTPTimeRange);
  
  public abstract int requestFeatureDataAsyncAtTimeRanges(int paramInt, TPTimeRange[] paramArrayOfTPTimeRange);
  
  public abstract void setRequesterListener(ITPRichMediaAsyncRequesterListener paramITPRichMediaAsyncRequesterListener);
  
  public abstract void setRichMediaSource(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.api.richmedia.ITPRichMediaAsyncRequester
 * JD-Core Version:    0.7.0.1
 */