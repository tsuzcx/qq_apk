package com.tencent.qqmini.sdk.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.ANNOTATION_TYPE})
public @interface MiniProcess
{
  Class internalUI() default Object.class;
  
  String name();
  
  ProcessType processType() default ProcessType.MINI_APP;
  
  Class receiver();
  
  int supportRuntimeType();
  
  Class ui();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.annotation.MiniProcess
 * JD-Core Version:    0.7.0.1
 */