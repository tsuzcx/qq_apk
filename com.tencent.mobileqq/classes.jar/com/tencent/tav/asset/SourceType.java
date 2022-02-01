package com.tencent.tav.asset;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface SourceType
{
  public static final int AUDIO = 2;
  public static final int IMAGE = 3;
  public static final int VIDEO = 1;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tav.asset.SourceType
 * JD-Core Version:    0.7.0.1
 */