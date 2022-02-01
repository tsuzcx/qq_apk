package com.tencent.qqmusic.mediaplayer;

class DataRangeTracker$Range
{
  private final long first;
  private final long second;
  
  private DataRangeTracker$Range(long paramLong1, long paramLong2)
  {
    this.first = paramLong1;
    this.second = paramLong2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.first);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.second);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.DataRangeTracker.Range
 * JD-Core Version:    0.7.0.1
 */