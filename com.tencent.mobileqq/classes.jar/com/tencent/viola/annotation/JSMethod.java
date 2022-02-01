package com.tencent.viola.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface JSMethod
{
  public static final String NOT_SET = "_";
  
  String alias() default "_";
  
  boolean uiThread() default true;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.annotation.JSMethod
 * JD-Core Version:    0.7.0.1
 */