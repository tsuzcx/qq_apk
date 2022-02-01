package com.tencent.mobileqq.qfix;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ShareReflectUtil
{
  public static Field findField(Object paramObject, String paramString)
  {
    for (Object localObject = paramObject.getClass(); localObject != null; localObject = ((Class)localObject).getSuperclass()) {
      try
      {
        Field localField = ((Class)localObject).getDeclaredField(paramString);
        if (!localField.isAccessible()) {
          localField.setAccessible(true);
        }
        return localField;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        label29:
        break label29;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Field ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" not found in ");
    ((StringBuilder)localObject).append(paramObject.getClass());
    paramObject = new NoSuchFieldException(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw paramObject;
    }
  }
  
  public static Method findMethod(Object paramObject, String paramString, Class... paramVarArgs)
  {
    for (Object localObject = paramObject.getClass(); localObject != null; localObject = ((Class)localObject).getSuperclass()) {
      try
      {
        Method localMethod = ((Class)localObject).getDeclaredMethod(paramString, paramVarArgs);
        if (!localMethod.isAccessible()) {
          localMethod.setAccessible(true);
        }
        return localMethod;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        label34:
        break label34;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Method ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" with parameters ");
    ((StringBuilder)localObject).append(Arrays.asList(paramVarArgs));
    ((StringBuilder)localObject).append(" not found in ");
    ((StringBuilder)localObject).append(paramObject.getClass());
    paramObject = new NoSuchMethodException(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qfix.ShareReflectUtil
 * JD-Core Version:    0.7.0.1
 */