package org.aspectj.lang.reflect;

public abstract interface DeclareSoft
{
  public abstract AjType getDeclaringType();
  
  public abstract PointcutExpression getPointcutExpression();
  
  public abstract AjType getSoftenedExceptionType();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.lang.reflect.DeclareSoft
 * JD-Core Version:    0.7.0.1
 */