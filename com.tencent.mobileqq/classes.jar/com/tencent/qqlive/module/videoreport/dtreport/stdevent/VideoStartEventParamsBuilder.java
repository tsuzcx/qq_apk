package com.tencent.qqlive.module.videoreport.dtreport.stdevent;

import android.support.annotation.CallSuper;
import java.util.Map;

public class VideoStartEventParamsBuilder
  extends BaseVideoEventParamsBuilder<VideoStartEventParamsBuilder>
{
  private long mPlayStartTime;
  
  public VideoStartEventParamsBuilder(String paramString1, long paramLong1, String paramString2, long paramLong2)
  {
    super(paramString1, paramLong1, paramString2);
    this.mPlayStartTime = paramLong2;
  }
  
  @CallSuper
  void onBuild(Map<String, String> paramMap)
  {
    putSingleParam(paramMap, "play_start_time", String.valueOf(this.mPlayStartTime));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.stdevent.VideoStartEventParamsBuilder
 * JD-Core Version:    0.7.0.1
 */