package com.tencent.qqmini.sdk.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
@MiniKeep
public @interface RuntimeLoaderConfig
{
  public static final int RUNTIME_TYPE_ALL = -1;
  public static final int RUNTIME_TYPE_ALL_APP = 3;
  public static final int RUNTIME_TYPE_APP = 1;
  public static final int RUNTIME_TYPE_FLUTTER = 2;
  public static final int RUNTIME_TYPE_GAME = 4;
  
  @MiniKeep
  RuntimeLoaderInfo[] loaders();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.annotation.RuntimeLoaderConfig
 * JD-Core Version:    0.7.0.1
 */