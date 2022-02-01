package org.xwalk.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.RejectedExecutionException;

class ReflectConstructor
{
  private Class<?> mClass;
  private Constructor<?> mConstructor;
  private Class<?>[] mParameterTypes;
  
  public ReflectConstructor() {}
  
  public ReflectConstructor(Class<?> paramClass, Class<?>... paramVarArgs)
  {
    init(paramClass, paramVarArgs);
  }
  
  public boolean init(Class<?> paramClass, Class<?>... paramVarArgs)
  {
    this.mClass = paramClass;
    this.mParameterTypes = paramVarArgs;
    this.mConstructor = null;
    paramClass = this.mClass;
    boolean bool = false;
    if (paramClass == null) {
      return false;
    }
    try
    {
      this.mConstructor = paramClass.getConstructor(this.mParameterTypes);
    }
    catch (NoSuchMethodException paramClass)
    {
      label43:
      label69:
      break label43;
    }
    try
    {
      this.mConstructor = this.mClass.getDeclaredConstructor(this.mParameterTypes);
      this.mConstructor.setAccessible(true);
    }
    catch (NoSuchMethodException paramClass)
    {
      break label69;
    }
    if (this.mConstructor != null) {
      bool = true;
    }
    return bool;
  }
  
  public boolean isNull()
  {
    return this.mConstructor == null;
  }
  
  public Object newInstance(Object... paramVarArgs)
  {
    Constructor localConstructor = this.mConstructor;
    if (localConstructor != null) {
      try
      {
        paramVarArgs = localConstructor.newInstance(paramVarArgs);
        return paramVarArgs;
      }
      catch (InvocationTargetException paramVarArgs)
      {
        throw new RuntimeException(paramVarArgs.getCause());
      }
      catch (IllegalArgumentException paramVarArgs)
      {
        throw paramVarArgs;
      }
      catch (InstantiationException paramVarArgs)
      {
        throw new RejectedExecutionException(paramVarArgs);
      }
      catch (IllegalAccessException paramVarArgs)
      {
        throw new RejectedExecutionException(paramVarArgs);
      }
    }
    throw new UnsupportedOperationException(toString());
  }
  
  public String toString()
  {
    Object localObject = this.mConstructor;
    if (localObject != null) {
      return ((Constructor)localObject).toString();
    }
    localObject = "";
    if (this.mClass != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(this.mClass.toString());
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.ReflectConstructor
 * JD-Core Version:    0.7.0.1
 */