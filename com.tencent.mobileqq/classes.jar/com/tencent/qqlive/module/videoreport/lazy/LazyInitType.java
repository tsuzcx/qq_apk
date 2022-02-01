package com.tencent.qqlive.module.videoreport.lazy;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface LazyInitType
{
  public static final int INIT_BY_CUSTOM_SEQUENCE = 2;
  public static final int INIT_BY_DEFAULT_SEQUENCE = 0;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.lazy.LazyInitType
 * JD-Core Version:    0.7.0.1
 */