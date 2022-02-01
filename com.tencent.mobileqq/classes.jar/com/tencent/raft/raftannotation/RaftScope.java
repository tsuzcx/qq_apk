package com.tencent.raft.raftannotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.TYPE})
public @interface RaftScope
{
  public static final String LazySingleton = "LazySingleton";
  public static final String Prototype = "Prototype";
  public static final String Singleton = "Singleton";
  public static final String WeakSingleton = "WeakSingleton";
  
  String value() default "Prototype";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.raft.raftannotation.RaftScope
 * JD-Core Version:    0.7.0.1
 */