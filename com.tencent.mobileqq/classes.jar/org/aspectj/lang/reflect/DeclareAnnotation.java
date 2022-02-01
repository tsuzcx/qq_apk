package org.aspectj.lang.reflect;

import java.lang.annotation.Annotation;

public abstract interface DeclareAnnotation
{
  public abstract Annotation getAnnotation();
  
  public abstract String getAnnotationAsText();
  
  public abstract AjType<?> getDeclaringType();
  
  public abstract DeclareAnnotation.Kind getKind();
  
  public abstract SignaturePattern getSignaturePattern();
  
  public abstract TypePattern getTypePattern();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.lang.reflect.DeclareAnnotation
 * JD-Core Version:    0.7.0.1
 */