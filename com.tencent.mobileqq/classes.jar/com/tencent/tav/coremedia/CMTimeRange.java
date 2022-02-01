package com.tencent.tav.coremedia;

import android.support.annotation.NonNull;

public class CMTimeRange
  implements Cloneable
{
  public static CMTimeRange CMTimeRangeInvalid = new CMTimeRange(CMTime.CMTimeZero, CMTime.CMTimeZero);
  @NonNull
  private CMTime duration;
  private CMTime end;
  @NonNull
  private CMTime start;
  
  public CMTimeRange(@NonNull CMTime paramCMTime1, @NonNull CMTime paramCMTime2)
  {
    Utils.checkNotNull(paramCMTime1);
    Utils.checkNotNull(paramCMTime2);
    this.start = paramCMTime1;
    this.duration = paramCMTime2;
    this.end = paramCMTime1.add(paramCMTime2);
  }
  
  public static CMTimeRange fromMs(long paramLong1, long paramLong2)
  {
    return new CMTimeRange(CMTime.fromMs(paramLong1), CMTime.fromMs(paramLong2));
  }
  
  public static CMTimeRange fromSeconds(float paramFloat1, float paramFloat2)
  {
    return new CMTimeRange(CMTime.fromSeconds(paramFloat1), CMTime.fromSeconds(paramFloat2));
  }
  
  public static CMTimeRange fromUs(long paramLong1, long paramLong2)
  {
    return new CMTimeRange(CMTime.fromUs(paramLong1), CMTime.fromUs(paramLong2));
  }
  
  public static CMTimeRange getIntersection(CMTimeRange paramCMTimeRange1, CMTimeRange paramCMTimeRange2)
  {
    if ((paramCMTimeRange1 != null) && (paramCMTimeRange2 != null))
    {
      paramCMTimeRange1 = paramCMTimeRange1.clone();
      paramCMTimeRange2 = paramCMTimeRange2.clone();
      CMTimeRange localCMTimeRange2 = paramCMTimeRange1;
      CMTimeRange localCMTimeRange1 = paramCMTimeRange2;
      if (paramCMTimeRange1.getStartUs() > paramCMTimeRange2.getStartUs())
      {
        localCMTimeRange1 = paramCMTimeRange1;
        localCMTimeRange2 = paramCMTimeRange2;
      }
      if ((localCMTimeRange2.getEndUs() > localCMTimeRange1.getStartUs()) && (localCMTimeRange2.getEndUs() < localCMTimeRange1.getEndUs())) {
        return new CMTimeRange(localCMTimeRange1.getStart(), localCMTimeRange2.getEnd().sub(localCMTimeRange1.getStart()));
      }
      if (localCMTimeRange2.getEndUs() >= localCMTimeRange1.getEndUs()) {
        return localCMTimeRange1;
      }
      if (localCMTimeRange2.getEndUs() < localCMTimeRange1.getStartUs()) {
        return CMTimeRangeInvalid;
      }
      return CMTimeRangeInvalid;
    }
    return CMTimeRangeInvalid;
  }
  
  public static CMTimeRange[] getUnions(CMTimeRange paramCMTimeRange1, CMTimeRange paramCMTimeRange2)
  {
    CMTimeRange[] arrayOfCMTimeRange = new CMTimeRange[2];
    if (paramCMTimeRange1 == null)
    {
      arrayOfCMTimeRange[0] = paramCMTimeRange2;
      return arrayOfCMTimeRange;
    }
    if (paramCMTimeRange2 == null)
    {
      arrayOfCMTimeRange[0] = paramCMTimeRange1;
      return arrayOfCMTimeRange;
    }
    paramCMTimeRange1 = paramCMTimeRange1.clone();
    paramCMTimeRange2 = paramCMTimeRange2.clone();
    CMTimeRange localCMTimeRange2 = paramCMTimeRange1;
    CMTimeRange localCMTimeRange1 = paramCMTimeRange2;
    if (paramCMTimeRange1.getStartUs() > paramCMTimeRange2.getStartUs())
    {
      localCMTimeRange1 = paramCMTimeRange1;
      localCMTimeRange2 = paramCMTimeRange2;
    }
    arrayOfCMTimeRange[0] = localCMTimeRange2;
    if ((localCMTimeRange2.getEndUs() >= localCMTimeRange1.getStartUs()) && (localCMTimeRange2.getEndUs() < localCMTimeRange1.getEndUs()))
    {
      arrayOfCMTimeRange[1] = new CMTimeRange(localCMTimeRange2.getEnd(), localCMTimeRange1.getEnd().sub(localCMTimeRange2.getEnd()));
      return arrayOfCMTimeRange;
    }
    if (localCMTimeRange2.getEndUs() >= localCMTimeRange1.getEndUs())
    {
      arrayOfCMTimeRange[1] = null;
      return arrayOfCMTimeRange;
    }
    if (localCMTimeRange2.getEndUs() < localCMTimeRange1.getStartUs()) {
      arrayOfCMTimeRange[1] = localCMTimeRange1;
    }
    return arrayOfCMTimeRange;
  }
  
  public CMTimeRange clone()
  {
    return new CMTimeRange(this.start, this.duration);
  }
  
  public boolean containsTime(@NonNull CMTime paramCMTime)
  {
    Utils.checkNotNull(paramCMTime);
    return (getStartUs() <= paramCMTime.getTimeUs()) && (getEndUs() > paramCMTime.getTimeUs());
  }
  
  public boolean containsTimeRange(@NonNull CMTimeRange paramCMTimeRange)
  {
    Utils.checkNotNull(paramCMTimeRange);
    return (getStartUs() <= paramCMTimeRange.getStartUs()) && (getEndUs() >= paramCMTimeRange.getEndUs());
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof CMTimeRange;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    CMTime localCMTime = this.start;
    paramObject = (CMTimeRange)paramObject;
    bool1 = bool2;
    if (localCMTime.equals(paramObject.start))
    {
      bool1 = bool2;
      if (this.duration.equals(paramObject.duration)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  @NonNull
  public CMTime getDuration()
  {
    return this.duration;
  }
  
  public long getDurationUs()
  {
    return this.duration.getTimeUs();
  }
  
  public CMTime getEnd()
  {
    return this.end;
  }
  
  public long getEndUs()
  {
    return getStartUs() + getDurationUs();
  }
  
  @NonNull
  public CMTime getStart()
  {
    return this.start;
  }
  
  public long getStartUs()
  {
    return this.start.getTimeUs();
  }
  
  public boolean isLegal()
  {
    return (getStartUs() >= 0L) && (getDurationUs() > 0L);
  }
  
  public void setDuration(@NonNull CMTime paramCMTime)
  {
    Utils.checkNotNull(paramCMTime);
    this.duration = paramCMTime;
    this.end = this.start.add(paramCMTime);
  }
  
  public void setStart(@NonNull CMTime paramCMTime)
  {
    Utils.checkNotNull(paramCMTime);
    this.start = paramCMTime;
    this.end = paramCMTime.add(this.duration);
  }
  
  public CMTimeRange[] split(float paramFloat)
  {
    if ((paramFloat >= 0.0F) && (paramFloat <= 1.0F))
    {
      CMTimeRange localCMTimeRange = new CMTimeRange(this.start, getDuration().multi(paramFloat));
      return new CMTimeRange[] { localCMTimeRange, new CMTimeRange(localCMTimeRange.getEnd(), getDuration().multi(1.0F - paramFloat)) };
    }
    return null;
  }
  
  public String toSimpleString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CMTimeRange{startUs=");
    localStringBuilder.append(this.start.getTimeUs());
    localStringBuilder.append(", durationUs=");
    localStringBuilder.append(this.duration.getTimeUs());
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CMTimeRange{start=");
    localStringBuilder.append(this.start);
    localStringBuilder.append(", duration=");
    localStringBuilder.append(this.duration);
    localStringBuilder.append(", end=");
    localStringBuilder.append(this.end);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.coremedia.CMTimeRange
 * JD-Core Version:    0.7.0.1
 */