package com.tencent.youtu.sdkkitframework.liveness;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface SilentLivenessState$FacePreviewingAdvise
{
  public static final int ADVISE_EYE_CLOSE = 6;
  public static final int ADVISE_INBUFFER_PASS = 9;
  public static final int ADVISE_INCOMPLETE_FACE = 8;
  public static final int ADVISE_INCORRECT_POSTURE = 5;
  public static final int ADVISE_NAN = -1;
  public static final int ADVISE_NOT_IN_RECT = 4;
  public static final int ADVISE_NO_FACE = 1;
  public static final int ADVISE_PASS = 0;
  public static final int ADVISE_TOO_CLOSE = 3;
  public static final int ADVISE_TOO_FAR = 2;
  public static final int ADVISE_TOO_MANY_FACE = 7;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.SilentLivenessState.FacePreviewingAdvise
 * JD-Core Version:    0.7.0.1
 */