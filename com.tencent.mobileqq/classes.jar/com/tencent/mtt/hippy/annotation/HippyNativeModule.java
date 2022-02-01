package com.tencent.mtt.hippy.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface HippyNativeModule
{
  boolean init() default false;
  
  String name();
  
  HippyNativeModule.Thread thread() default HippyNativeModule.Thread.BRIDGE;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.annotation.HippyNativeModule
 * JD-Core Version:    0.7.0.1
 */