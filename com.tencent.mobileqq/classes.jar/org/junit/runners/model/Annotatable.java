package org.junit.runners.model;

import java.lang.annotation.Annotation;

public abstract interface Annotatable
{
  public abstract <T extends Annotation> T getAnnotation(Class<T> paramClass);
  
  public abstract Annotation[] getAnnotations();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.junit.runners.model.Annotatable
 * JD-Core Version:    0.7.0.1
 */