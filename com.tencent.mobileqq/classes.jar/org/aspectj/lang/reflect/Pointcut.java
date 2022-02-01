package org.aspectj.lang.reflect;

public abstract interface Pointcut
{
  public abstract AjType getDeclaringType();
  
  public abstract int getModifiers();
  
  public abstract String getName();
  
  public abstract String[] getParameterNames();
  
  public abstract AjType<?>[] getParameterTypes();
  
  public abstract PointcutExpression getPointcutExpression();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.lang.reflect.Pointcut
 * JD-Core Version:    0.7.0.1
 */