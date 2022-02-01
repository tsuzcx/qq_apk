package com.tencent.thumbplayer.richmedia;

import com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer;
import com.tencent.thumbplayer.api.richmedia.TPRichMediaFeatureData;

public abstract interface ITPInnerRichMediaSynchronizer
  extends ITPRichMediaSynchronizer
{
  public abstract TPRichMediaFeatureData getCurrentPositionMsFeatureData(long paramLong, int[] paramArrayOfInt);
  
  public abstract void seek(long paramLong);
  
  public abstract void setInnerListener(ITPInnerRichMediaSynchronizer.ITPRichMediaInnerSynchronizerListener paramITPRichMediaInnerSynchronizerListener);
  
  public abstract void setPlaybackRate(float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.richmedia.ITPInnerRichMediaSynchronizer
 * JD-Core Version:    0.7.0.1
 */