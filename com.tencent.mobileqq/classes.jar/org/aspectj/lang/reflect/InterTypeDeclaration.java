package org.aspectj.lang.reflect;

public abstract interface InterTypeDeclaration
{
  public abstract AjType<?> getDeclaringType();
  
  public abstract int getModifiers();
  
  public abstract AjType<?> getTargetType();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.lang.reflect.InterTypeDeclaration
 * JD-Core Version:    0.7.0.1
 */