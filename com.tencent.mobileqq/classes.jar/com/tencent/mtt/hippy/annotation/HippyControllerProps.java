package com.tencent.mtt.hippy.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface HippyControllerProps
{
  public static final String ARRAY = "array";
  public static final String BOOLEAN = "boolean";
  public static final String DEFAULT = "";
  public static final String MAP = "map";
  public static final String NUMBER = "number";
  public static final String STRING = "string";
  
  boolean defaultBoolean() default false;
  
  double defaultNumber() default 0.0D;
  
  String defaultString() default "";
  
  String defaultType() default "";
  
  String name() default "name";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.annotation.HippyControllerProps
 * JD-Core Version:    0.7.0.1
 */