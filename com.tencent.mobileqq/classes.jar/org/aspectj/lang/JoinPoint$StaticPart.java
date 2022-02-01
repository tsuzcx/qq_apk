package org.aspectj.lang;

import org.aspectj.lang.reflect.SourceLocation;

public abstract interface JoinPoint$StaticPart
{
  public abstract int getId();
  
  public abstract String getKind();
  
  public abstract Signature getSignature();
  
  public abstract SourceLocation getSourceLocation();
  
  public abstract String toLongString();
  
  public abstract String toShortString();
  
  public abstract String toString();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.lang.JoinPoint.StaticPart
 * JD-Core Version:    0.7.0.1
 */