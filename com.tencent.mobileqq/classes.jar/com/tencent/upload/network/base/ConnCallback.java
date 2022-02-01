package com.tencent.upload.network.base;

import java.lang.annotation.Annotation;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.METHOD})
public @interface ConnCallback
{
  int id() default -1;
  
  String name() default "";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.network.base.ConnCallback
 * JD-Core Version:    0.7.0.1
 */