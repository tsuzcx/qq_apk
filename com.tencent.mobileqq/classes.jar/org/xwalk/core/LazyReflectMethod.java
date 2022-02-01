package org.xwalk.core;

import java.lang.reflect.Method;

public class LazyReflectMethod
  extends ReflectMethod
{
  boolean mInited = false;
  
  public LazyReflectMethod() {}
  
  public LazyReflectMethod(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    super(paramClass, paramString, paramVarArgs);
  }
  
  public LazyReflectMethod(Object paramObject, String paramString, Class<?>... paramVarArgs)
  {
    super(paramObject, paramString, paramVarArgs);
  }
  
  protected boolean doInit()
  {
    if (this.mClass == null) {
      return false;
    }
    if ((this.mInited) && (this.mMethod != null)) {
      return this.mInited;
    }
    try
    {
      if (this.mInited)
      {
        boolean bool = this.mInited;
        return bool;
      }
    }
    finally
    {
      label68:
      Class localClass;
      for (;;)
      {
        label104:
        throw localObject;
      }
    }
    try
    {
      this.mMethod = this.mClass.getMethod(this.mName, this.mParameterTypes);
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      break label68;
    }
    for (localClass = this.mClass; localClass != null; localClass = localClass.getSuperclass()) {
      try
      {
        this.mMethod = localClass.getDeclaredMethod(this.mName, this.mParameterTypes);
        this.mMethod.setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        break label104;
      }
    }
    this.mInited = true;
    return this.mMethod != null;
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
    this.mInited = false;
    return true;
  }
  
  public Object invoke(Object... paramVarArgs)
  {
    doInit();
    return super.invoke(paramVarArgs);
  }
  
  public boolean isNull()
  {
    doInit();
    return super.isNull();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.LazyReflectMethod
 * JD-Core Version:    0.7.0.1
 */