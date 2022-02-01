package org.aspectj.lang.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public abstract interface InterTypeMethodDeclaration
  extends InterTypeDeclaration
{
  public abstract AjType<?>[] getExceptionTypes();
  
  public abstract Type[] getGenericParameterTypes();
  
  public abstract Type getGenericReturnType();
  
  public abstract String getName();
  
  public abstract AjType<?>[] getParameterTypes();
  
  public abstract AjType<?> getReturnType();
  
  public abstract TypeVariable<Method>[] getTypeParameters();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.lang.reflect.InterTypeMethodDeclaration
 * JD-Core Version:    0.7.0.1
 */