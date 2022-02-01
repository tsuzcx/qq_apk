package org.aspectj.lang.reflect;

import org.aspectj.lang.Signature;

public abstract interface CatchClauseSignature
  extends Signature
{
  public abstract String getParameterName();
  
  public abstract Class getParameterType();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.lang.reflect.CatchClauseSignature
 * JD-Core Version:    0.7.0.1
 */