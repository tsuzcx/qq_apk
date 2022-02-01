package org.xwalk.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.RejectedExecutionException;

public class ReflectMethod
{
  protected Object[] mArguments;
  protected Class<?> mClass;
  protected Object mInstance;
  protected Method mMethod;
  protected String mName;
  protected Class<?>[] mParameterTypes;
  
  public ReflectMethod() {}
  
  public ReflectMethod(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    init(null, paramClass, paramString, paramVarArgs);
  }
  
  public ReflectMethod(Object paramObject, String paramString, Class<?>... paramVarArgs)
  {
    init(paramObject, null, paramString, paramVarArgs);
  }
  
  public Object[] getArguments()
  {
    return this.mArguments;
  }
  
  public Object getInstance()
  {
    return this.mInstance;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public boolean init(Object paramObject, Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    this.mInstance = paramObject;
    if (paramClass == null) {
      if (paramObject != null) {
        paramClass = paramObject.getClass();
      } else {
        paramClass = null;
      }
    }
    this.mClass = paramClass;
    this.mName = paramString;
    this.mParameterTypes = paramVarArgs;
    this.mMethod = null;
    paramObject = this.mClass;
    boolean bool = false;
    if (paramObject == null) {
      return false;
    }
    try
    {
      this.mMethod = paramObject.getMethod(this.mName, this.mParameterTypes);
    }
    catch (NoSuchMethodException paramObject)
    {
      label80:
      label116:
      break label80;
    }
    for (paramObject = this.mClass; paramObject != null; paramObject = paramObject.getSuperclass()) {
      try
      {
        this.mMethod = paramObject.getDeclaredMethod(this.mName, this.mParameterTypes);
        this.mMethod.setAccessible(true);
      }
      catch (NoSuchMethodException paramClass)
      {
        break label116;
      }
    }
    if (this.mMethod != null) {
      bool = true;
    }
    return bool;
  }
  
  public Object invoke(Object... paramVarArgs)
  {
    Method localMethod = this.mMethod;
    if (localMethod != null)
    {
      try
      {
        paramVarArgs = localMethod.invoke(this.mInstance, paramVarArgs);
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
      catch (NullPointerException paramVarArgs) {}catch (IllegalAccessException paramVarArgs) {}
      throw new RejectedExecutionException(paramVarArgs);
    }
    throw new UnsupportedOperationException(toString());
  }
  
  public Object invokeWithArguments()
  {
    return invoke(this.mArguments);
  }
  
  public boolean isNull()
  {
    return this.mMethod == null;
  }
  
  public void setArguments(Object... paramVarArgs)
  {
    this.mArguments = paramVarArgs;
  }
  
  public String toString()
  {
    Object localObject1 = this.mMethod;
    if (localObject1 != null) {
      return ((Method)localObject1).toString();
    }
    localObject1 = "";
    if (this.mClass != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(this.mClass.toString());
      ((StringBuilder)localObject1).append(".");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    Object localObject2 = localObject1;
    if (this.mName != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(this.mName);
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.ReflectMethod
 * JD-Core Version:    0.7.0.1
 */