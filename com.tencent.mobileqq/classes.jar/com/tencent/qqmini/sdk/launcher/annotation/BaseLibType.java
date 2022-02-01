package com.tencent.qqmini.sdk.launcher.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface BaseLibType
{
  public static final int MINI_APP_BASELIB = 1;
  public static final int MINI_APP_ENGINE = 3;
  public static final int MINI_GAME_ENGINE = 2;
  public static final int NOT_SET = -1;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.annotation.BaseLibType
 * JD-Core Version:    0.7.0.1
 */