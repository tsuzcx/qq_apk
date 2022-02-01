package com.tencent.raft.raftannotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited
@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.ANNOTATION_TYPE, java.lang.annotation.ElementType.METHOD})
public @interface RaftArg
{
  String method() default "";
  
  String name() default "";
  
  boolean valueBoolean() default false;
  
  Class<?> valueClass() default Void.class;
  
  double valueDouble() default 0.0D;
  
  float valueFloat() default 0.0F;
  
  int valueInt() default 0;
  
  String valueString() default "";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.raft.raftannotation.RaftArg
 * JD-Core Version:    0.7.0.1
 */