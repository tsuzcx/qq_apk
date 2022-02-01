package com.tencent.qqlive.module.videoreport.dtreport.video;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface VideoReportTypeDefine$PlayerStateMachine
{
  public static final int INIT = -1;
  public static final int PAUSED = 3;
  public static final int PREPARED = 1;
  public static final int STARTED = 2;
  public static final int STOPPED = 4;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.VideoReportTypeDefine.PlayerStateMachine
 * JD-Core Version:    0.7.0.1
 */