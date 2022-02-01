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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" time=");
    localStringBuilder.append(System.currentTimeMillis() - this.startTime);
    Log.d("DebugTime::", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoReportPlayerUtils.DebugTime
 * JD-Core Version:    0.7.0.1
 */