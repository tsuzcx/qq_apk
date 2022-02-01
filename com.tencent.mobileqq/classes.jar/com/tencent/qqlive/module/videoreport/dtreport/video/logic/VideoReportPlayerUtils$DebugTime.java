package com.tencent.qqlive.module.videoreport.dtreport.video.logic;

import com.tencent.qqlive.module.videoreport.Log;

public class VideoReportPlayerUtils$DebugTime
{
  private static final String TAG = "DebugTime::";
  private long startTime;
  
  public VideoReportPlayerUtils$DebugTime(long paramLong)
  {
    this.startTime = paramLong;
  }
  
  public void debug(String paramString)
  {
    Log.d("DebugTime::", paramString + " time=" + (System.currentTimeMillis() - this.startTime));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoReportPlayerUtils.DebugTime
 * JD-Core Version:    0.7.0.1
 */