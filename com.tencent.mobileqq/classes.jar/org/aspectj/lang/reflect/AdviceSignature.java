package org.aspectj.lang.reflect;

import java.lang.reflect.Method;

public abstract interface AdviceSignature
  extends CodeSignature
{
  public abstract Method getAdvice();
  
  public abstract Class getReturnType();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.lang.reflect.AdviceSignature
 * JD-Core Version:    0.7.0.1
 */