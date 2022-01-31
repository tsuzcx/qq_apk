package com.tencent.oskplayer.util;

public class VideoSpeedReport$ReportPoint
{
  public static final String HTTP_OPEN = "http_open_start<->http_open_end";
  private long endTime = 0L;
  private String extraInfo;
  private boolean isEndTimeSet = false;
  private boolean isLaunchPoint = true;
  private boolean isStartTimeSet = false;
  private String name;
  private long startTime = 0L;
  private int upperLimit = 0;
  
  public VideoSpeedReport$ReportPoint(String paramString)
  {
    this.name = paramString;
  }
  
  public VideoSpeedReport$ReportPoint(String paramString, boolean paramBoolean)
  {
    this(paramString);
    this.isLaunchPoint = paramBoolean;
  }
  
  public VideoSpeedReport$ReportPoint(String paramString, boolean paramBoolean, int paramInt)
  {
    this(paramString, paramBoolean, null);
    this.upperLimit = paramInt;
  }
  
  public VideoSpeedReport$ReportPoint(String paramString1, boolean paramBoolean, String paramString2)
  {
    this(paramString1);
    this.isLaunchPoint = paramBoolean;
    this.extraInfo = paramString2;
  }
  
  public void clean()
  {
    this.startTime = 0L;
    this.endTime = 0L;
    this.isStartTimeSet = false;
    this.isEndTimeSet = false;
  }
  
  public long getEndTime()
  {
    return this.endTime;
  }
  
  public String getExtraInfo()
  {
    return this.extraInfo;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public long getStartTime()
  {
    return this.startTime;
  }
  
  public void setEndTime(long paramLong)
  {
    this.endTime = paramLong;
  }
  
  public void setStartTime(long paramLong)
  {
    this.startTime = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.oskplayer.util.VideoSpeedReport.ReportPoint
 * JD-Core Version:    0.7.0.1
 */