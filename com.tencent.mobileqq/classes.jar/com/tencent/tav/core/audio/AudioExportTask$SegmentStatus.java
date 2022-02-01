package com.tencent.tav.core.audio;

import com.tencent.tav.coremedia.CMTimeRange;

class AudioExportTask$SegmentStatus
{
  private float mProgress;
  private int mStatus;
  private CMTimeRange mTimeRange;
  
  public AudioExportTask$SegmentStatus(int paramInt, float paramFloat)
  {
    this.mStatus = paramInt;
    this.mProgress = paramFloat;
  }
  
  public CMTimeRange getTimeRange()
  {
    return this.mTimeRange;
  }
  
  public void setTimeRange(CMTimeRange paramCMTimeRange)
  {
    this.mTimeRange = paramCMTimeRange;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.core.audio.AudioExportTask.SegmentStatus
 * JD-Core Version:    0.7.0.1
 */