package com.tencent.qqlive.module.videoreport.dtreport.time.base;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface ITimeProcessor$ProcessorState
{
  public static final int INIT = -1;
  public static final int STARTED = 0;
  public static final int STOPPED = 1;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.time.base.ITimeProcessor.ProcessorState
 * JD-Core Version:    0.7.0.1
 */