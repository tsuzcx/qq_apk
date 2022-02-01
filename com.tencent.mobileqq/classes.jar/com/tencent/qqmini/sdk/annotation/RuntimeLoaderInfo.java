package com.tencent.qqmini.sdk.annotation;

import java.lang.annotation.Annotation;

@MiniKeep
public @interface RuntimeLoaderInfo
{
  @MiniKeep
  String className();
  
  @MiniKeep
  int type();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.annotation.RuntimeLoaderInfo
 * JD-Core Version:    0.7.0.1
 */