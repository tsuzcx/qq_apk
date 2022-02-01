package com.tencent.tav.asset;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeMapping;
import com.tencent.tav.coremedia.CMTimeRange;

public class AssetTrackSegment
{
  protected boolean empty;
  protected CMTime scaleDuration = CMTime.CMTimeZero;
  protected CMTimeMapping timeMapping;
  protected CMTimeRange timeRange;
  
  protected AssetTrackSegment() {}
  
  protected AssetTrackSegment(CMTimeRange paramCMTimeRange1, CMTimeRange paramCMTimeRange2)
  {
    this.timeMapping = new CMTimeMapping(paramCMTimeRange1, paramCMTimeRange2);
    this.scaleDuration = paramCMTimeRange2.getDuration().clone();
    this.timeRange = paramCMTimeRange2.clone();
  }
  
  public CMTime getScaleDuration()
  {
    return this.scaleDuration;
  }
  
  public CMTimeMapping getTimeMapping()
  {
    return this.timeMapping;
  }
  
  public boolean isEmpty()
  {
    return this.empty;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tav.asset.AssetTrackSegment
 * JD-Core Version:    0.7.0.1
 */