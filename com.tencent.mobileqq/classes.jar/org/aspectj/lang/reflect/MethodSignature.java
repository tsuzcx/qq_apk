package org.aspectj.lang.reflect;

import java.lang.reflect.Method;

public abstract interface MethodSignature
  extends CodeSignature
{
  public abstract Method getMethod();
  
  public abstract Class getReturnType();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.lang.reflect.MethodSignature
 * JD-Core Version:    0.7.0.1
 */