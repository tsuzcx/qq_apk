package com.tencent.tav.decoder;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;

public class VideoDecoderQuickSeekHelper
{
  private boolean careForSeekTime = false;
  private long lastReadSampleTime = -1L;
  private long segmentStartTime = 0L;
  private float speed = 1.0F;
  private CMTimeRange timeRange;
  private DecoderTrackSegment trackSegment;
  
  private VideoDecoderQuickSeekHelper() {}
  
  public VideoDecoderQuickSeekHelper(boolean paramBoolean, DecoderTrackSegment paramDecoderTrackSegment, long paramLong)
  {
    this.careForSeekTime = paramBoolean;
    this.trackSegment = paramDecoderTrackSegment;
    this.timeRange = paramDecoderTrackSegment.getTimeRange();
    this.segmentStartTime = paramLong;
    if (paramDecoderTrackSegment.getScaledDuration().getTimeUs() > 0L) {
      this.speed = ((float)paramDecoderTrackSegment.getTimeRange().getDurationUs() * 1.0F / (float)paramDecoderTrackSegment.getScaledDuration().getTimeUs());
    }
  }
  
  private boolean isContinuesBackSeek(long paramLong)
  {
    return (this.careForSeekTime) && (SeekTimeStore.compareNewSeekTime(paramLong) > 0);
  }
  
  private boolean isContinuesForwardSeek(long paramLong1, long paramLong2)
  {
    return (this.careForSeekTime) && (SeekTimeStore.compareNewSeekTime(paramLong1) < 0) && (this.lastReadSampleTime < paramLong1) && (SeekTimeStore.compareNewSeekTime(paramLong2) < 0) && (paramLong2 > 0L);
  }
  
  private boolean isFreelyCornerSeek(long paramLong1, long paramLong2)
  {
    return (this.careForSeekTime) && (SeekTimeStore.compareNewSeekTime(paramLong1) < 0) && (SeekTimeStore.compareNewSeekTime(paramLong2) < 0) && (paramLong2 > 0L);
  }
  
  public boolean isCanQuicklyFinish(long paramLong1, long paramLong2)
  {
    return isFreelyCornerSeek(((float)this.segmentStartTime + (float)(paramLong1 - this.timeRange.getStartUs()) * this.speed), ((float)this.segmentStartTime + (float)(paramLong2 - this.timeRange.getStartUs()) * this.speed));
  }
  
  public boolean isCanSkipCurDecoder(long paramLong1, long paramLong2)
  {
    long l = ((float)this.segmentStartTime + (float)(paramLong1 - this.timeRange.getStartUs()) * this.speed);
    paramLong2 = ((float)this.segmentStartTime + (float)(paramLong2 - this.timeRange.getStartUs()) * this.speed);
    return (isContinuesBackSeek(l)) || (isContinuesForwardSeek(l, paramLong2)) || ((paramLong1 > this.timeRange.getStartUs()) && (isCanQuicklyFinish(l, paramLong2)));
  }
  
  public boolean isCareForSeekTime()
  {
    return this.careForSeekTime;
  }
  
  public void setLastReadSampleTime(long paramLong)
  {
    this.lastReadSampleTime = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.decoder.VideoDecoderQuickSeekHelper
 * JD-Core Version:    0.7.0.1
 */