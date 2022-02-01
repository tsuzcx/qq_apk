package org.aspectj.lang.reflect;

public abstract interface CodeSignature
  extends MemberSignature
{
  public abstract Class[] getExceptionTypes();
  
  public abstract String[] getParameterNames();
  
  public abstract Class[] getParameterTypes();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.lang.reflect.CodeSignature
 * JD-Core Version:    0.7.0.1
 */