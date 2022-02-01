package com.tencent.taveffect.core;

import java.util.concurrent.TimeUnit;

public class TAVTimeRange
{
  private long _duration;
  private long _start;
  private TimeUnit _unit = TimeUnit.MILLISECONDS;
  
  public TAVTimeRange() {}
  
  public TAVTimeRange(long paramLong1, long paramLong2)
  {
    this._start = paramLong1;
    this._duration = paramLong2;
  }
  
  public TAVTimeRange clone()
  {
    return new TAVTimeRange(this._start, this._duration);
  }
  
  public boolean contain(long paramLong)
  {
    long l1 = this._duration;
    if (l1 > 0L)
    {
      long l2 = this._start;
      if ((l2 < paramLong) && (paramLong < l2 + l1)) {
        return true;
      }
    }
    return false;
  }
  
  public long duration()
  {
    return this._duration;
  }
  
  public long end()
  {
    return this._start + this._duration;
  }
  
  public boolean equals(TAVTimeRange paramTAVTimeRange)
  {
    if (paramTAVTimeRange == this) {
      return true;
    }
    if (paramTAVTimeRange == null) {
      return false;
    }
    return (this._start == paramTAVTimeRange._start) && (this._duration == paramTAVTimeRange._duration);
  }
  
  public TimeUnit getUnit()
  {
    return this._unit;
  }
  
  public void setUnit(TimeUnit paramTimeUnit)
  {
    this._unit = paramTimeUnit;
  }
  
  public long start()
  {
    return this._start;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TAVTimeRange{_unit=");
    localStringBuilder.append(this._unit);
    localStringBuilder.append(", _start=");
    localStringBuilder.append(this._start);
    localStringBuilder.append(", _duration=");
    localStringBuilder.append(this._duration);
    localStringBuilder.append(", _end=");
    localStringBuilder.append(this._start + this._duration);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void update(long paramLong1, long paramLong2)
  {
    this._start = paramLong1;
    this._duration = paramLong2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.taveffect.core.TAVTimeRange
 * JD-Core Version:    0.7.0.1
 */