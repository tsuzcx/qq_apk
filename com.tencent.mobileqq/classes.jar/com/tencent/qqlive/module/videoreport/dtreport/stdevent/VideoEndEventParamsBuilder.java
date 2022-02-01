package com.tencent.qqlive.module.videoreport.dtreport.stdevent;

import android.support.annotation.CallSuper;
import java.util.Locale;
import java.util.Map;

public class VideoEndEventParamsBuilder
  extends BaseVideoEventParamsBuilder<VideoEndEventParamsBuilder>
{
  private long mPlayEndTime;
  private long mPlayLvtm;
  private double mPlayPer;
  private String mVideoErrorCode;
  
  public VideoEndEventParamsBuilder(String paramString1, long paramLong1, String paramString2, long paramLong2, long paramLong3, double paramDouble)
  {
    super(paramString1, paramLong1, paramString2);
    this.mPlayEndTime = paramLong2;
    this.mPlayLvtm = paramLong3;
    this.mPlayPer = paramDouble;
  }
  
  @CallSuper
  void onBuild(Map<String, String> paramMap)
  {
    putSingleParam(paramMap, "video_error_code", this.mVideoErrorCode);
    putSingleParam(paramMap, "play_end_time", Long.valueOf(this.mPlayEndTime));
    putSingleParam(paramMap, "play_lvtm", Long.valueOf(this.mPlayLvtm));
    putSingleParam(paramMap, "play_per", String.format(Locale.getDefault(), "%.2f", new Object[] { Double.valueOf(this.mPlayPer) }));
  }
  
  public VideoEndEventParamsBuilder setVideoErrorCode(String paramString)
  {
    this.mVideoErrorCode = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.stdevent.VideoEndEventParamsBuilder
 * JD-Core Version:    0.7.0.1
 */