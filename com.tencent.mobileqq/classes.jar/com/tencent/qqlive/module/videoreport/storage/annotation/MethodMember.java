package com.tencent.qqlive.module.videoreport.storage.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodMember
  implements Member
{
  private Method method;
  
  public MethodMember(Method paramMethod)
  {
    if (!paramMethod.isAccessible()) {
      paramMethod.setAccessible(true);
    }
    this.method = paramMethod;
  }
  
  public Object getValue(Object paramObject)
  {
    try
    {
      paramObject = this.method.invoke(paramObject, new Object[0]);
      return paramObject;
    }
    catch (InvocationTargetException paramObject)
    {
      throw new RuntimeException(paramObject);
    }
    catch (IllegalArgumentException paramObject)
    {
      throw new RuntimeException(paramObject);
    }
    catch (IllegalAccessException paramObject)
    {
      throw new RuntimeException(paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.storage.annotation.MethodMember
 * JD-Core Version:    0.7.0.1
 */