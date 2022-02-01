package com.tencent.mobileqq.triton.sdk.statics;

import androidx.annotation.NonNull;

public final class TraceStatistics$Record
{
  @NonNull
  public final String name;
  public final long timeUs;
  
  public TraceStatistics$Record(@NonNull String paramString, long paramLong)
  {
    this.name = paramString;
    this.timeUs = paramLong;
  }
  
  public String toString()
  {
    return "Record{name='" + this.name + '\'' + ", timeUs=" + this.timeUs + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.sdk.statics.TraceStatistics.Record
 * JD-Core Version:    0.7.0.1
 */