package org.light;

public class ClipInfo
{
  public String path;
  public TimeRange sourceTimeRange;
  public TimeRange targetTimeRange;
  
  public ClipInfo(String paramString, TimeRange paramTimeRange1, TimeRange paramTimeRange2)
  {
    this.path = paramString;
    this.sourceTimeRange = paramTimeRange1;
    this.targetTimeRange = paramTimeRange2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.light.ClipInfo
 * JD-Core Version:    0.7.0.1
 */