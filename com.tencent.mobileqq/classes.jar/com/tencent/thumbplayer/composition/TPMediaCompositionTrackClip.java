package com.tencent.thumbplayer.composition;

import android.text.TextUtils;
import com.tencent.thumbplayer.api.composition.ITPMediaTrackClip;
import java.io.Serializable;

public class TPMediaCompositionTrackClip
  implements ITPMediaTrackClip, Serializable
{
  private int mClipId;
  private String mClipPath;
  private int mClipType;
  private long mEndTime;
  private long mOriginalDuration;
  private long mStartPosition;
  private long mStartTime;
  
  private TPMediaCompositionTrackClip() {}
  
  public TPMediaCompositionTrackClip(String paramString, int paramInt)
  {
    this(paramString, paramInt, 0L, -1L);
  }
  
  public TPMediaCompositionTrackClip(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("TPMediaCompositionTrackClip : clipPath empty");
    }
    this.mClipType = paramInt;
    this.mClipPath = paramString;
    this.mStartTime = paramLong1;
    this.mEndTime = paramLong2;
    if (this.mStartTime < 0L) {
      this.mStartTime = 0L;
    }
    if (this.mEndTime <= 0L) {
      this.mEndTime = getOriginalDurationMs();
    }
    this.mClipId = TPMediaCompositionHelper.generateTrackClipId(this.mClipType);
  }
  
  public ITPMediaTrackClip clone(int paramInt)
  {
    if ((paramInt != 3) && (paramInt != 2) && (paramInt != 1)) {
      return null;
    }
    TPMediaCompositionTrackClip localTPMediaCompositionTrackClip = new TPMediaCompositionTrackClip();
    localTPMediaCompositionTrackClip.mClipType = paramInt;
    localTPMediaCompositionTrackClip.mClipId = TPMediaCompositionHelper.generateTrackClipId(this.mClipType);
    localTPMediaCompositionTrackClip.mStartTime = this.mStartTime;
    localTPMediaCompositionTrackClip.mEndTime = this.mEndTime;
    localTPMediaCompositionTrackClip.mClipPath = this.mClipPath;
    return localTPMediaCompositionTrackClip;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof TPMediaCompositionTrackClip)) {
      return false;
    }
    if ((this.mClipId == ((TPMediaCompositionTrackClip)paramObject).getClipId()) && (this.mClipType == ((TPMediaCompositionTrackClip)paramObject).getMediaType())) {}
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
    return this.mClipPath;
  }
  
  public int getMediaType()
  {
    return this.mClipType;
  }
  
  public long getOriginalDurationMs()
  {
    return this.mOriginalDuration;
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
    return this.mClipPath;
  }
  
  public void setCutTimeRange(long paramLong1, long paramLong2)
  {
    if (paramLong1 >= getOriginalDurationMs()) {
      throw new IllegalArgumentException("setCutTimeRange: Start time is greater than duration");
    }
    if (paramLong2 > getOriginalDurationMs()) {
      throw new IllegalArgumentException("setCutTimeRange: Start time is greater than duration");
    }
    long l = paramLong1;
    if (paramLong1 < 0L) {
      l = 0L;
    }
    paramLong1 = paramLong2;
    if (paramLong2 <= 0L) {
      paramLong1 = getOriginalDurationMs();
    }
    if (l >= paramLong1) {
      throw new IllegalArgumentException("setCutTimeRange: Start time is greater than end time");
    }
    this.mStartTime = l;
    this.mEndTime = paramLong1;
  }
  
  public void setFilePath(String paramString)
  {
    this.mClipPath = paramString;
  }
  
  public void setOriginalDurationMs(long paramLong)
  {
    this.mOriginalDuration = paramLong;
  }
  
  public void setStartPositionMs(long paramLong)
  {
    this.mStartPosition = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.composition.TPMediaCompositionTrackClip
 * JD-Core Version:    0.7.0.1
 */