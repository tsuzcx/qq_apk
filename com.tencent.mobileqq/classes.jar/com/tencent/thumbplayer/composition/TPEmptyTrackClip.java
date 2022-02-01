package com.tencent.thumbplayer.composition;

import com.tencent.thumbplayer.api.composition.ITPMediaTrackClip;
import java.io.Serializable;

public class TPEmptyTrackClip
  implements ITPMediaTrackClip, Serializable
{
  private int mClipId;
  private int mClipType;
  private long mEndTime = 0L;
  private long mStartPosition;
  private long mStartTime = 0L;
  
  public TPEmptyTrackClip(int paramInt)
  {
    this.mClipType = paramInt;
    this.mClipId = TPMediaCompositionHelper.generateTrackClipId(this.mClipType);
  }
  
  public ITPMediaTrackClip clone(int paramInt)
  {
    if ((paramInt != 3) && (paramInt != 2) && (paramInt != 1)) {
      return null;
    }
    TPEmptyTrackClip localTPEmptyTrackClip = new TPEmptyTrackClip(paramInt);
    localTPEmptyTrackClip.mClipId = TPMediaCompositionHelper.generateTrackClipId(paramInt);
    localTPEmptyTrackClip.mStartTime = this.mStartTime;
    localTPEmptyTrackClip.mEndTime = this.mEndTime;
    return localTPEmptyTrackClip;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof TPEmptyTrackClip)) {
      return false;
    }
    if ((this.mClipId == ((TPEmptyTrackClip)paramObject).getClipId()) && (this.mClipType == ((TPEmptyTrackClip)paramObject).getMediaType())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int getClipId()
  {
    return this.mClipId;
  }
  
  public long getEndTimeMs()
  {
    return this.mEndTime;
  }
  
  public String getFilePath()
  {
    return null;
  }
  
  public int getMediaType()
  {
    return this.mClipType;
  }
  
  public long getOriginalDurationMs()
  {
    return this.mEndTime - this.mStartTime;
  }
  
  public long getStartPositionMs()
  {
    return this.mStartPosition;
  }
  
  public long getStartTimeMs()
  {
    return this.mStartTime;
  }
  
  public String getUrl()
  {
    return null;
  }
  
  public void setCutTimeRange(long paramLong1, long paramLong2)
  {
    long l = paramLong1;
    if (paramLong1 < 0L) {
      l = 0L;
    }
    if (l >= paramLong2) {
      throw new IllegalArgumentException("setCutTimeRange: Start time is greater than end time");
    }
    this.mStartTime = l;
    this.mEndTime = paramLong2;
  }
  
  public void setOriginalDurationMs(long paramLong) {}
  
  public void setStartPositionMs(long paramLong)
  {
    this.mStartPosition = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.composition.TPEmptyTrackClip
 * JD-Core Version:    0.7.0.1
 */