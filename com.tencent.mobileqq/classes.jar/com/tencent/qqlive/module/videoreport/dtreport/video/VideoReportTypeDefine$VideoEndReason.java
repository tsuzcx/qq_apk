package com.tencent.qqlive.module.videoreport.dtreport.video;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface VideoReportTypeDefine$VideoEndReason
{
  public static final int VIDEO_PLAY_END_BY_COMPLETE = 2;
  public static final int VIDEO_PLAY_END_BY_ERROR = 1;
  public static final int VIDEO_PLAY_END_BY_PAUSE = 3;
  public static final int VIDEO_PLAY_END_BY_STAGING = 4;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.VideoReportTypeDefine.VideoEndReason
 * JD-Core Version:    0.7.0.1
 */