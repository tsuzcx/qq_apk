package org.aspectj.lang.reflect;

import java.lang.reflect.Type;

public abstract interface InterTypeFieldDeclaration
  extends InterTypeDeclaration
{
  public abstract Type getGenericType();
  
  public abstract String getName();
  
  public abstract AjType<?> getType();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.lang.reflect.InterTypeFieldDeclaration
 * JD-Core Version:    0.7.0.1
 */