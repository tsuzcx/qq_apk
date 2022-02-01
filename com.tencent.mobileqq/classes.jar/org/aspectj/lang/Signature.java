package org.aspectj.lang;

public abstract interface Signature
{
  public abstract Class getDeclaringType();
  
  public abstract String getDeclaringTypeName();
  
  public abstract int getModifiers();
  
  public abstract String getName();
  
  public abstract String toLongString();
  
  public abstract String toShortString();
  
  public abstract String toString();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.lang.Signature
 * JD-Core Version:    0.7.0.1
 */