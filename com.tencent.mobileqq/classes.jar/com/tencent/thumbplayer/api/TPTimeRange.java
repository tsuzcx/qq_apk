package com.tencent.thumbplayer.api;

public class TPTimeRange
{
  private long mEndTimeMs;
  private long mStartTimeMs;
  
  public TPTimeRange(long paramLong1, long paramLong2)
  {
    this.mStartTimeMs = paramLong1;
    this.mEndTimeMs = paramLong2;
  }
  
  public long getEndTimeMs()
  {
    return this.mEndTimeMs;
  }
  
  public long getStartTimeMs()
  {
    return this.mStartTimeMs;
  }
  
  public void setEndTimeMs(long paramLong)
  {
    this.mEndTimeMs = paramLong;
  }
  
  public void setStartTimeMs(long paramLong)
  {
    this.mStartTimeMs = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPTimeRange
 * JD-Core Version:    0.7.0.1
 */