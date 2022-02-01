package com.tencent.qqlive.module.videoreport.dtreport.lazy;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface LazyInitType
{
  public static final int INIT_BY_CUSTOM_SEQUENCE = 2;
  public static final int INIT_BY_DEFAULT_SEQUENCE = 0;
  public static final int INIT_BY_SYSTEM_FIRST_DRAW_SEQUENCE = 1;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.lazy.LazyInitType
 * JD-Core Version:    0.7.0.1
 */