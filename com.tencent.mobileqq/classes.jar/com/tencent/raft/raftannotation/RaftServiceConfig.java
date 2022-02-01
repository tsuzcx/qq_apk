package com.tencent.raft.raftannotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited
@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.ANNOTATION_TYPE, java.lang.annotation.ElementType.METHOD})
public @interface RaftServiceConfig
{
  RaftArg[] factoryArgs() default {};
  
  Class<?> factoryClass() default Void.class;
  
  String factoryMethod() default "";
  
  RaftArg[] initMethodArgs() default {};
  
  Class<?> interfaceClass() default Void.class;
  
  RaftMethod[] methods() default {};
  
  RaftArg[] properties() default {};
  
  String scope() default "Prototype";
  
  Class<?> serviceClass() default Void.class;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.raft.raftannotation.RaftServiceConfig
 * JD-Core Version:    0.7.0.1
 */