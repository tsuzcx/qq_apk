package org.light;

public class TimeLine
{
  public int entityID = -1;
  public String event = "";
  public TimeRange range;
  public long time = -1L;
  public String type = "";
  
  public TimeLine(String paramString1, int paramInt, TimeRange paramTimeRange, long paramLong, String paramString2)
  {
    this.type = paramString1;
    this.entityID = paramInt;
    this.range = paramTimeRange;
    this.time = paramLong;
    this.event = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.TimeLine
 * JD-Core Version:    0.7.0.1
 */