package com.tencent.raft.raftannotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface RaftMethod
{
  RaftArg[] args() default {};
  
  String name() default "";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.raft.raftannotation.RaftMethod
 * JD-Core Version:    0.7.0.1
 */