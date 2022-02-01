package org.apache.commons.lang.reflect;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.SystemUtils;

abstract class MemberUtils
{
  private static final int ACCESS_TEST = 7;
  private static final Method IS_SYNTHETIC;
  private static final Class[] ORDERED_PRIMITIVE_TYPES = { Byte.TYPE, Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE };
  static Class class$java$lang$reflect$Member;
  
  static
  {
    if (SystemUtils.isJavaVersionAtLeast(1.5F)) {}
    try
    {
      if (class$java$lang$reflect$Member == null)
      {
        localObject = class$("java.lang.reflect.Member");
        class$java$lang$reflect$Member = (Class)localObject;
      }
      else
      {
        localObject = class$java$lang$reflect$Member;
      }
      localObject = ((Class)localObject).getMethod("isSynthetic", ArrayUtils.EMPTY_CLASS_ARRAY);
    }
    catch (Exception localException)
    {
      Object localObject;
      label44:
      break label44;
    }
    localObject = null;
    IS_SYNTHETIC = (Method)localObject;
  }
  
  static Class class$(String paramString)
  {
    try
    {
      paramString = Class.forName(paramString);
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      throw new NoClassDefFoundError(paramString.getMessage());
    }
  }
  
  static int compareParameterTypes(Class[] paramArrayOfClass1, Class[] paramArrayOfClass2, Class[] paramArrayOfClass3)
  {
    float f1 = getTotalTransformationCost(paramArrayOfClass3, paramArrayOfClass1);
    float f2 = getTotalTransformationCost(paramArrayOfClass3, paramArrayOfClass2);
    if (f1 < f2) {
      return -1;
    }
    if (f2 < f1) {
      return 1;
    }
    return 0;
  }
  
  private static float getObjectTransformationCost(Class paramClass1, Class paramClass2)
  {
    if (paramClass2.isPrimitive()) {
      return getPrimitivePromotionCost(paramClass1, paramClass2);
    }
    float f2 = 0.0F;
    float f1;
    for (;;)
    {
      f1 = f2;
      if (paramClass1 == null) {
        break;
      }
      f1 = f2;
      if (paramClass2.equals(paramClass1)) {
        break;
      }
      if ((paramClass2.isInterface()) && (ClassUtils.isAssignable(paramClass1, paramClass2)))
      {
        f1 = f2 + 0.25F;
        break;
      }
      f2 += 1.0F;
      paramClass1 = paramClass1.getSuperclass();
    }
    f2 = f1;
    if (paramClass1 == null) {
      f2 = f1 + 1.5F;
    }
    return f2;
  }
  
  private static float getPrimitivePromotionCost(Class paramClass1, Class paramClass2)
  {
    float f1;
    if (!paramClass1.isPrimitive())
    {
      paramClass1 = ClassUtils.wrapperToPrimitive(paramClass1);
      f1 = 0.1F;
    }
    else
    {
      f1 = 0.0F;
    }
    int i = 0;
    float f2 = f1;
    while (paramClass1 != paramClass2)
    {
      Class[] arrayOfClass = ORDERED_PRIMITIVE_TYPES;
      if (i >= arrayOfClass.length) {
        break;
      }
      f1 = f2;
      Class localClass = paramClass1;
      if (paramClass1 == arrayOfClass[i])
      {
        f2 += 0.1F;
        f1 = f2;
        localClass = paramClass1;
        if (i < arrayOfClass.length - 1)
        {
          localClass = arrayOfClass[(i + 1)];
          f1 = f2;
        }
      }
      i += 1;
      f2 = f1;
      paramClass1 = localClass;
    }
    return f2;
  }
  
  private static float getTotalTransformationCost(Class[] paramArrayOfClass1, Class[] paramArrayOfClass2)
  {
    float f = 0.0F;
    int i = 0;
    while (i < paramArrayOfClass1.length)
    {
      f += getObjectTransformationCost(paramArrayOfClass1[i], paramArrayOfClass2[i]);
      i += 1;
    }
    return f;
  }
  
  static boolean isAccessible(Member paramMember)
  {
    return (paramMember != null) && (Modifier.isPublic(paramMember.getModifiers())) && (!isSynthetic(paramMember));
  }
  
  static boolean isPackageAccess(int paramInt)
  {
    return (paramInt & 0x7) == 0;
  }
  
  static boolean isSynthetic(Member paramMember)
  {
    Method localMethod = IS_SYNTHETIC;
    if (localMethod != null) {}
    try
    {
      boolean bool = ((Boolean)localMethod.invoke(paramMember, null)).booleanValue();
      return bool;
    }
    catch (Exception paramMember)
    {
      label23:
      break label23;
    }
    return false;
  }
  
  static void setAccessibleWorkaround(AccessibleObject paramAccessibleObject)
  {
    if (paramAccessibleObject != null)
    {
      if (paramAccessibleObject.isAccessible()) {
        return;
      }
      Member localMember = (Member)paramAccessibleObject;
      if ((!Modifier.isPublic(localMember.getModifiers())) || (!isPackageAccess(localMember.getDeclaringClass().getModifiers()))) {}
    }
    try
    {
      paramAccessibleObject.setAccessible(true);
      return;
    }
    catch (SecurityException paramAccessibleObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.reflect.MemberUtils
 * JD-Core Version:    0.7.0.1
 */