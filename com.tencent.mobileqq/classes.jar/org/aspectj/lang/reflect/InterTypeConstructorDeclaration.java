package org.aspectj.lang.reflect;

import java.lang.reflect.Type;

public abstract interface InterTypeConstructorDeclaration
  extends InterTypeDeclaration
{
  public abstract AjType<?>[] getExceptionTypes();
  
  public abstract Type[] getGenericParameterTypes();
  
  public abstract AjType<?>[] getParameterTypes();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.lang.reflect.InterTypeConstructorDeclaration
 * JD-Core Version:    0.7.0.1
 */