package com.tencent.plato.sdk.element;

import com.tencent.plato.IPlatoRuntime;
import com.tencent.plato.core.IReadableMap;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract interface IProperty
{
  public abstract void setProperty(IPlatoRuntime paramIPlatoRuntime, IReadableMap paramIReadableMap);
  
  public abstract void setStyle(IPlatoRuntime paramIPlatoRuntime, IReadableMap paramIReadableMap);
  
  public static abstract interface IPropSetter
  {
    public abstract String getName();
    
    public abstract Class[] getParameterTypes();
    
    public abstract <T extends IProperty> void invoke(T paramT, Object... paramVarArgs);
  }
  
  public static class PropSetter
    implements IProperty.IPropSetter
  {
    private final Class<?> mHostClazz;
    private final Method mMethod;
    private final String mMethodName;
    
    PropSetter(Class<?> paramClass, String paramString, Method paramMethod)
    {
      this.mHostClazz = paramClass;
      this.mMethodName = paramString;
      this.mMethod = paramMethod;
    }
    
    public String getName()
    {
      return this.mMethodName;
    }
    
    public Class[] getParameterTypes()
    {
      return this.mMethod.getParameterTypes();
    }
    
    public <T extends IProperty> void invoke(T paramT, Object... paramVarArgs)
    {
      try
      {
        this.mMethod.invoke(paramT, paramVarArgs);
        return;
      }
      catch (IllegalAccessException paramT)
      {
        throw new IllegalStateException(paramT.getCause());
      }
      catch (InvocationTargetException paramT)
      {
        throw new IllegalStateException(paramT.getTargetException());
      }
    }
    
    public String toString()
    {
      return this.mHostClazz.getName() + '.' + this.mMethodName;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.sdk.element.IProperty
 * JD-Core Version:    0.7.0.1
 */