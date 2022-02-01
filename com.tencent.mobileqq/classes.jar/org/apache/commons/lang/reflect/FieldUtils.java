package org.apache.commons.lang.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang.ClassUtils;

public class FieldUtils
{
  public static Field getDeclaredField(Class paramClass, String paramString)
  {
    return getDeclaredField(paramClass, paramString, false);
  }
  
  public static Field getDeclaredField(Class paramClass, String paramString, boolean paramBoolean)
  {
    if ((paramClass == null) || (paramString != null)) {}
    try
    {
      paramClass = paramClass.getDeclaredField(paramString);
      if (!MemberUtils.isAccessible(paramClass))
      {
        if (paramBoolean)
        {
          paramClass.setAccessible(true);
          return paramClass;
        }
        return null;
      }
      return paramClass;
    }
    catch (NoSuchFieldException paramClass) {}
    throw new IllegalArgumentException("The field name must not be null");
    throw new IllegalArgumentException("The class must not be null");
    return null;
  }
  
  public static Field getField(Class paramClass, String paramString)
  {
    paramClass = getField(paramClass, paramString, false);
    MemberUtils.setAccessibleWorkaround(paramClass);
    return paramClass;
  }
  
  public static Field getField(Class paramClass, String paramString, boolean paramBoolean)
  {
    if (paramClass != null)
    {
      if (paramString != null)
      {
        for (Object localObject1 = paramClass; localObject1 != null; localObject1 = ((Class)localObject1).getSuperclass()) {
          try
          {
            localObject2 = ((Class)localObject1).getDeclaredField(paramString);
            if (!Modifier.isPublic(((Field)localObject2).getModifiers()))
            {
              if (paramBoolean) {
                ((Field)localObject2).setAccessible(true);
              }
            }
            else {
              return localObject2;
            }
          }
          catch (NoSuchFieldException localNoSuchFieldException1)
          {
            Object localObject2;
            label45:
            Iterator localIterator;
            break label45;
          }
        }
        localObject1 = null;
        localIterator = ClassUtils.getAllInterfaces(paramClass).iterator();
        while (localIterator.hasNext()) {
          try
          {
            localObject2 = ((Class)localIterator.next()).getField(paramString);
            if (localObject1 == null)
            {
              localObject1 = localObject2;
            }
            else
            {
              localObject2 = new StringBuffer();
              ((StringBuffer)localObject2).append("Reference to field ");
              ((StringBuffer)localObject2).append(paramString);
              ((StringBuffer)localObject2).append(" is ambiguous relative to ");
              ((StringBuffer)localObject2).append(paramClass);
              ((StringBuffer)localObject2).append("; a matching field exists on two or more implemented interfaces.");
              throw new IllegalArgumentException(((StringBuffer)localObject2).toString());
            }
          }
          catch (NoSuchFieldException localNoSuchFieldException2)
          {
            label162:
            break label162;
          }
        }
        return localObject1;
      }
      else
      {
        throw new IllegalArgumentException("The field name must not be null");
      }
    }
    else
    {
      paramClass = new IllegalArgumentException("The class must not be null");
      for (;;)
      {
        throw paramClass;
      }
    }
  }
  
  public static Object readDeclaredField(Object paramObject, String paramString)
  {
    return readDeclaredField(paramObject, paramString, false);
  }
  
  public static Object readDeclaredField(Object paramObject, String paramString, boolean paramBoolean)
  {
    if (paramObject != null)
    {
      Class localClass = paramObject.getClass();
      Field localField = getDeclaredField(localClass, paramString, paramBoolean);
      if (localField != null) {
        return readField(localField, paramObject);
      }
      paramObject = new StringBuffer();
      paramObject.append("Cannot locate declared field ");
      paramObject.append(localClass.getName());
      paramObject.append(".");
      paramObject.append(paramString);
      throw new IllegalArgumentException(paramObject.toString());
    }
    throw new IllegalArgumentException("target object must not be null");
  }
  
  public static Object readDeclaredStaticField(Class paramClass, String paramString)
  {
    return readDeclaredStaticField(paramClass, paramString, false);
  }
  
  public static Object readDeclaredStaticField(Class paramClass, String paramString, boolean paramBoolean)
  {
    Object localObject = getDeclaredField(paramClass, paramString, paramBoolean);
    if (localObject != null) {
      return readStaticField((Field)localObject, false);
    }
    localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Cannot locate declared field ");
    ((StringBuffer)localObject).append(paramClass.getName());
    ((StringBuffer)localObject).append(".");
    ((StringBuffer)localObject).append(paramString);
    throw new IllegalArgumentException(((StringBuffer)localObject).toString());
  }
  
  public static Object readField(Object paramObject, String paramString)
  {
    return readField(paramObject, paramString, false);
  }
  
  public static Object readField(Object paramObject, String paramString, boolean paramBoolean)
  {
    if (paramObject != null)
    {
      Class localClass = paramObject.getClass();
      Field localField = getField(localClass, paramString, paramBoolean);
      if (localField != null) {
        return readField(localField, paramObject);
      }
      paramObject = new StringBuffer();
      paramObject.append("Cannot locate field ");
      paramObject.append(paramString);
      paramObject.append(" on ");
      paramObject.append(localClass);
      throw new IllegalArgumentException(paramObject.toString());
    }
    throw new IllegalArgumentException("target object must not be null");
  }
  
  public static Object readField(Field paramField, Object paramObject)
  {
    return readField(paramField, paramObject, false);
  }
  
  public static Object readField(Field paramField, Object paramObject, boolean paramBoolean)
  {
    if (paramField != null)
    {
      if ((paramBoolean) && (!paramField.isAccessible())) {
        paramField.setAccessible(true);
      } else {
        MemberUtils.setAccessibleWorkaround(paramField);
      }
      return paramField.get(paramObject);
    }
    throw new IllegalArgumentException("The field must not be null");
  }
  
  public static Object readStaticField(Class paramClass, String paramString)
  {
    return readStaticField(paramClass, paramString, false);
  }
  
  public static Object readStaticField(Class paramClass, String paramString, boolean paramBoolean)
  {
    Object localObject = getField(paramClass, paramString, paramBoolean);
    if (localObject != null) {
      return readStaticField((Field)localObject, false);
    }
    localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Cannot locate field ");
    ((StringBuffer)localObject).append(paramString);
    ((StringBuffer)localObject).append(" on ");
    ((StringBuffer)localObject).append(paramClass);
    throw new IllegalArgumentException(((StringBuffer)localObject).toString());
  }
  
  public static Object readStaticField(Field paramField)
  {
    return readStaticField(paramField, false);
  }
  
  public static Object readStaticField(Field paramField, boolean paramBoolean)
  {
    if (paramField != null)
    {
      if (Modifier.isStatic(paramField.getModifiers())) {
        return readField(paramField, (Object)null, paramBoolean);
      }
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("The field '");
      localStringBuffer.append(paramField.getName());
      localStringBuffer.append("' is not static");
      throw new IllegalArgumentException(localStringBuffer.toString());
    }
    throw new IllegalArgumentException("The field must not be null");
  }
  
  public static void writeDeclaredField(Object paramObject1, String paramString, Object paramObject2)
  {
    writeDeclaredField(paramObject1, paramString, paramObject2, false);
  }
  
  public static void writeDeclaredField(Object paramObject1, String paramString, Object paramObject2, boolean paramBoolean)
  {
    if (paramObject1 != null)
    {
      Class localClass = paramObject1.getClass();
      Field localField = getDeclaredField(localClass, paramString, paramBoolean);
      if (localField != null)
      {
        writeField(localField, paramObject1, paramObject2);
        return;
      }
      paramObject1 = new StringBuffer();
      paramObject1.append("Cannot locate declared field ");
      paramObject1.append(localClass.getName());
      paramObject1.append(".");
      paramObject1.append(paramString);
      throw new IllegalArgumentException(paramObject1.toString());
    }
    throw new IllegalArgumentException("target object must not be null");
  }
  
  public static void writeDeclaredStaticField(Class paramClass, String paramString, Object paramObject)
  {
    writeDeclaredStaticField(paramClass, paramString, paramObject, false);
  }
  
  public static void writeDeclaredStaticField(Class paramClass, String paramString, Object paramObject, boolean paramBoolean)
  {
    Field localField = getDeclaredField(paramClass, paramString, paramBoolean);
    if (localField != null)
    {
      writeField(localField, (Object)null, paramObject);
      return;
    }
    paramObject = new StringBuffer();
    paramObject.append("Cannot locate declared field ");
    paramObject.append(paramClass.getName());
    paramObject.append(".");
    paramObject.append(paramString);
    throw new IllegalArgumentException(paramObject.toString());
  }
  
  public static void writeField(Object paramObject1, String paramString, Object paramObject2)
  {
    writeField(paramObject1, paramString, paramObject2, false);
  }
  
  public static void writeField(Object paramObject1, String paramString, Object paramObject2, boolean paramBoolean)
  {
    if (paramObject1 != null)
    {
      Class localClass = paramObject1.getClass();
      Field localField = getField(localClass, paramString, paramBoolean);
      if (localField != null)
      {
        writeField(localField, paramObject1, paramObject2);
        return;
      }
      paramObject1 = new StringBuffer();
      paramObject1.append("Cannot locate declared field ");
      paramObject1.append(localClass.getName());
      paramObject1.append(".");
      paramObject1.append(paramString);
      throw new IllegalArgumentException(paramObject1.toString());
    }
    throw new IllegalArgumentException("target object must not be null");
  }
  
  public static void writeField(Field paramField, Object paramObject1, Object paramObject2)
  {
    writeField(paramField, paramObject1, paramObject2, false);
  }
  
  public static void writeField(Field paramField, Object paramObject1, Object paramObject2, boolean paramBoolean)
  {
    if (paramField != null)
    {
      if ((paramBoolean) && (!paramField.isAccessible())) {
        paramField.setAccessible(true);
      } else {
        MemberUtils.setAccessibleWorkaround(paramField);
      }
      paramField.set(paramObject1, paramObject2);
      return;
    }
    throw new IllegalArgumentException("The field must not be null");
  }
  
  public static void writeStaticField(Class paramClass, String paramString, Object paramObject)
  {
    writeStaticField(paramClass, paramString, paramObject, false);
  }
  
  public static void writeStaticField(Class paramClass, String paramString, Object paramObject, boolean paramBoolean)
  {
    Field localField = getField(paramClass, paramString, paramBoolean);
    if (localField != null)
    {
      writeStaticField(localField, paramObject);
      return;
    }
    paramObject = new StringBuffer();
    paramObject.append("Cannot locate field ");
    paramObject.append(paramString);
    paramObject.append(" on ");
    paramObject.append(paramClass);
    throw new IllegalArgumentException(paramObject.toString());
  }
  
  public static void writeStaticField(Field paramField, Object paramObject)
  {
    writeStaticField(paramField, paramObject, false);
  }
  
  public static void writeStaticField(Field paramField, Object paramObject, boolean paramBoolean)
  {
    if (paramField != null)
    {
      if (Modifier.isStatic(paramField.getModifiers()))
      {
        writeField(paramField, (Object)null, paramObject, paramBoolean);
        return;
      }
      paramObject = new StringBuffer();
      paramObject.append("The field '");
      paramObject.append(paramField.getName());
      paramObject.append("' is not static");
      throw new IllegalArgumentException(paramObject.toString());
    }
    throw new IllegalArgumentException("The field must not be null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.reflect.FieldUtils
 * JD-Core Version:    0.7.0.1
 */