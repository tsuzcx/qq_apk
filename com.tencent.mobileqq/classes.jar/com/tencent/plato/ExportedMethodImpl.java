package com.tencent.plato;

import com.tencent.plato.core.IExportedMethod;
import com.tencent.plato.core.IExportedModule;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ExportedMethodImpl
  implements IExportedMethod
{
  private final Class<?> mHostClazz;
  private final Method mMethod;
  private final String mMethodName;
  private final boolean mUiThreadMethod;
  
  ExportedMethodImpl(Class<?> paramClass, String paramString, Method paramMethod, boolean paramBoolean)
  {
    this.mHostClazz = paramClass;
    this.mMethodName = paramString;
    this.mMethod = paramMethod;
    this.mUiThreadMethod = paramBoolean;
  }
  
  public String getName()
  {
    return this.mMethodName;
  }
  
  public Class[] getParameterTypes()
  {
    return this.mMethod.getParameterTypes();
  }
  
  public <T extends IExportedModule> Object invoke(T paramT, Object... paramVarArgs)
  {
    try
    {
      paramT = this.mMethod.invoke(paramT, paramVarArgs);
      return paramT;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.ExportedMethodImpl
 * JD-Core Version:    0.7.0.1
 */