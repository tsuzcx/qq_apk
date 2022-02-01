package org.aspectj.lang.reflect;

import java.lang.reflect.Type;

public abstract interface DeclareParents
{
  public abstract AjType getDeclaringType();
  
  public abstract Type[] getParentTypes();
  
  public abstract TypePattern getTargetTypesPattern();
  
  public abstract boolean isExtends();
  
  public abstract boolean isImplements();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.lang.reflect.DeclareParents
 * JD-Core Version:    0.7.0.1
 */