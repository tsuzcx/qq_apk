package org.aspectj.lang.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface SuppressAjWarnings
{
  String[] value() default {""};
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.lang.annotation.SuppressAjWarnings
 * JD-Core Version:    0.7.0.1
 */