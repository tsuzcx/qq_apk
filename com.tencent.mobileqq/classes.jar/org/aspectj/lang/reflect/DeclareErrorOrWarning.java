package org.aspectj.lang.reflect;

public abstract interface DeclareErrorOrWarning
{
  public abstract AjType getDeclaringType();
  
  public abstract String getMessage();
  
  public abstract PointcutExpression getPointcutExpression();
  
  public abstract boolean isError();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.lang.reflect.DeclareErrorOrWarning
 * JD-Core Version:    0.7.0.1
 */