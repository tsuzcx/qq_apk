package com.tencent.robolectric;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

final class ReflectionHelpers$3
  implements InvocationHandler
{
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    try
    {
      paramObject = this.jdField_a_of_type_JavaLangClass.getMethod(paramMethod.getName(), paramMethod.getParameterTypes());
      paramObject.setAccessible(true);
      paramObject = paramObject.invoke(this.jdField_a_of_type_JavaLangObject, paramArrayOfObject);
      return paramObject;
    }
    catch (NoSuchMethodException paramObject) {}
    return ReflectionHelpers.a().get(paramMethod.getReturnType().getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.robolectric.ReflectionHelpers.3
 * JD-Core Version:    0.7.0.1
 */