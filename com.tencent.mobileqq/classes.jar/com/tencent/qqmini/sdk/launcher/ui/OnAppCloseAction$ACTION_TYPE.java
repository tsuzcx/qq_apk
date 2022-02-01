package com.tencent.qqmini.sdk.launcher.ui;

import com.tencent.qqmini.sdk.annotation.MiniKeep;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@MiniKeep
public @interface OnAppCloseAction$ACTION_TYPE
{
  public static final int DEFAULT = 0;
  public static final int GUESS_YOU_LIKE = 1;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.ui.OnAppCloseAction.ACTION_TYPE
 * JD-Core Version:    0.7.0.1
 */