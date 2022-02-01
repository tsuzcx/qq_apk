package com.tencent.thumbplayer.utils;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.TYPE})
public @interface TPThreadAnnotations$ThreadSwitch
{
  boolean checkObj() default false;
  
  boolean needWait() default false;
  
  boolean removeRepeat() default false;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.TPThreadAnnotations.ThreadSwitch
 * JD-Core Version:    0.7.0.1
 */