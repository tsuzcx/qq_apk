package com.tencent.qqmini.sdk.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface MiniConfig
{
  boolean dexEnabled() default true;
  
  boolean flutterEnabled() default false;
  
  MiniProcess[] processes();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.annotation.MiniConfig
 * JD-Core Version:    0.7.0.1
 */