package org.aspectj.lang.reflect;

public abstract interface SourceLocation
{
  public abstract int getColumn();
  
  public abstract String getFileName();
  
  public abstract int getLine();
  
  public abstract Class getWithinType();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.lang.reflect.SourceLocation
 * JD-Core Version:    0.7.0.1
 */