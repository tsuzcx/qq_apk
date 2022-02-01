package com.tencent.qqlive.module.videoreport.dtreport.video.data;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface PageSwitch
{
  public static final int ALL_CLOSE = 0;
  public static final int ALL_OPEN = 3;
  public static final int END_OPEN = 2;
  public static final int START_OPEN = 1;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.data.PageSwitch
 * JD-Core Version:    0.7.0.1
 */