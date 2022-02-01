package org.aspectj.internal.lang.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

final class StringToType$1
  implements ParameterizedType
{
  StringToType$1(Type[] paramArrayOfType, Class paramClass) {}
  
  public Type[] getActualTypeArguments()
  {
    return this.val$typeParams;
  }
  
  public Type getOwnerType()
  {
    return this.val$baseClass.getEnclosingClass();
  }
  
  public Type getRawType()
  {
    return this.val$baseClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.internal.lang.reflect.StringToType.1
 * JD-Core Version:    0.7.0.1
 */