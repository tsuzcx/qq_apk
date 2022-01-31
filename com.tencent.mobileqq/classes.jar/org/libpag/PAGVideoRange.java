package org.libpag;

public class PAGVideoRange
{
  public long endTime = 0L;
  public long playDuration = 0L;
  public boolean reversed = false;
  public long startTime = 0L;
  
  public PAGVideoRange(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    this.startTime = paramLong1;
    this.endTime = paramLong2;
    this.playDuration = paramLong3;
    this.reversed = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     org.libpag.PAGVideoRange
 * JD-Core Version:    0.7.0.1
 */