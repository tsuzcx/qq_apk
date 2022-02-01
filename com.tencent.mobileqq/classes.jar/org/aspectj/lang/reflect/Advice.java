package org.aspectj.lang.reflect;

import java.lang.reflect.Type;

public abstract interface Advice
{
  public abstract AjType getDeclaringType();
  
  public abstract AjType<?>[] getExceptionTypes();
  
  public abstract Type[] getGenericParameterTypes();
  
  public abstract AdviceKind getKind();
  
  public abstract String getName();
  
  public abstract AjType<?>[] getParameterTypes();
  
  public abstract PointcutExpression getPointcutExpression();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.lang.reflect.Advice
 * JD-Core Version:    0.7.0.1
 */