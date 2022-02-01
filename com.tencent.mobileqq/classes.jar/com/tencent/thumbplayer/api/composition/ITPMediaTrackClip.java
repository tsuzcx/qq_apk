package com.tencent.thumbplayer.api.composition;

public abstract interface ITPMediaTrackClip
  extends ITPMediaAsset
{
  public abstract ITPMediaTrackClip clone(int paramInt);
  
  public abstract int getClipId();
  
  public abstract long getEndTimeMs();
  
  public abstract String getFilePath();
  
  public abstract long getOriginalDurationMs();
  
  public abstract long getStartPositionMs();
  
  public abstract long getStartTimeMs();
  
  public abstract void setCutTimeRange(long paramLong1, long paramLong2);
  
  public abstract void setOriginalDurationMs(long paramLong);
  
  public abstract void setStartPositionMs(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.api.composition.ITPMediaTrackClip
 * JD-Core Version:    0.7.0.1
 */