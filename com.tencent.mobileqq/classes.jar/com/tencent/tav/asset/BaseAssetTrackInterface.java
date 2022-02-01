package com.tencent.tav.asset;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;

public abstract interface BaseAssetTrackInterface
{
  public abstract void insertEmptyTimeRange(CMTimeRange paramCMTimeRange);
  
  public abstract boolean insertTimeRange(CMTimeRange paramCMTimeRange, AssetTrack paramAssetTrack, CMTime paramCMTime);
  
  public abstract void removeTimeRange(CMTimeRange paramCMTimeRange);
  
  public abstract void scaleTimeRange(CMTimeRange paramCMTimeRange, CMTime paramCMTime);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.asset.BaseAssetTrackInterface
 * JD-Core Version:    0.7.0.1
 */