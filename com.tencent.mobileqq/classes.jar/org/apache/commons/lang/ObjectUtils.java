package org.apache.commons.lang;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import org.apache.commons.lang.exception.CloneFailedException;
import org.apache.commons.lang.reflect.MethodUtils;

public class ObjectUtils
{
  public static final ObjectUtils.Null NULL = new ObjectUtils.Null();
  
  public static StringBuffer appendIdentityToString(StringBuffer paramStringBuffer, Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    StringBuffer localStringBuffer = paramStringBuffer;
    if (paramStringBuffer == null) {
      localStringBuffer = new StringBuffer();
    }
    localStringBuffer.append(paramObject.getClass().getName());
    localStringBuffer.append('@');
    localStringBuffer.append(Integer.toHexString(System.identityHashCode(paramObject)));
    return localStringBuffer;
  }
  
  public static Object clone(Object paramObject)
  {
    if ((paramObject instanceof Cloneable))
    {
      Object localObject;
      if (paramObject.getClass().isArray())
      {
        localObject = paramObject.getClass().getComponentType();
        if (!((Class)localObject).isPrimitive()) {
          return ((Object[])paramObject).clone();
        }
        int i = Array.getLength(paramObject);
        localObject = Array.newInstance((Class)localObject, i);
        for (;;)
        {
          int j = i - 1;
          if (i <= 0) {
            break;
          }
          Array.set(localObject, j, Array.get(paramObject, j));
          i = j;
        }
        return localObject;
      }
      try
      {
        localObject = MethodUtils.invokeMethod(paramObject, "clone", null);
        return localObject;
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        localStringBuffer = new StringBuffer();
        localStringBuffer.append("Exception cloning Cloneable type ");
        localStringBuffer.append(paramObject.getClass().getName());
        throw new CloneFailedException(localStringBuffer.toString(), localInvocationTargetException.getTargetException());
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localStringBuffer = new StringBuffer();
        localStringBuffer.append("Cannot clone Cloneable type ");
        localStringBuffer.append(paramObject.getClass().getName());
        throw new CloneFailedException(localStringBuffer.toString(), localIllegalAccessException);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append("Cloneable type ");
        localStringBuffer.append(paramObject.getClass().getName());
        localStringBuffer.append(" has no clone method");
        throw new CloneFailedException(localStringBuffer.toString(), localNoSuchMethodException);
      }
    }
    return null;
  }
  
  public static Object cloneIfPossible(Object paramObject)
  {
    Object localObject = clone(paramObject);
    if (localObject == null) {
      return paramObject;
    }
    return localObject;
  }
  
  public static int compare(Comparable paramComparable1, Comparable paramComparable2)
  {
    return compare(paramComparable1, paramComparable2, false);
  }
  
  public static int compare(Comparable paramComparable1, Comparable paramComparable2, boolean paramBoolean)
  {
    if (paramComparable1 == paramComparable2) {
      return 0;
    }
    int i = 1;
    if (paramComparable1 == null)
    {
      if (paramBoolean) {
        return 1;
      }
      return -1;
    }
    if (paramComparable2 == null)
    {
      if (paramBoolean) {
        i = -1;
      }
      return i;
    }
    return paramComparable1.compareTo(paramComparable2);
  }
  
  public static Object defaultIfNull(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 != null) {
      return paramObject1;
    }
    return paramObject2;
  }
  
  public static boolean equals(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == paramObject2) {
      return true;
    }
    if ((paramObject1 != null) && (paramObject2 != null)) {
      return paramObject1.equals(paramObject2);
    }
    return false;
  }
  
  public static int hashCode(Object paramObject)
  {
    if (paramObject == null) {
      return 0;
    }
    return paramObject.hashCode();
  }
  
  public static String identityToString(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    identityToString(localStringBuffer, paramObject);
    return localStringBuffer.toString();
  }
  
  public static void identityToString(StringBuffer paramStringBuffer, Object paramObject)
  {
    if (paramObject != null)
    {
      paramStringBuffer.append(paramObject.getClass().getName());
      paramStringBuffer.append('@');
      paramStringBuffer.append(Integer.toHexString(System.identityHashCode(paramObject)));
      return;
    }
    throw new NullPointerException("Cannot get the toString of a null identity");
  }
  
  public static Object max(Comparable paramComparable1, Comparable paramComparable2)
  {
    if (compare(paramComparable1, paramComparable2, false) >= 0) {
      return paramComparable1;
    }
    return paramComparable2;
  }
  
  public static Object min(Comparable paramComparable1, Comparable paramComparable2)
  {
    if (compare(paramComparable1, paramComparable2, true) <= 0) {
      return paramComparable1;
    }
    return paramComparable2;
  }
  
  public static boolean notEqual(Object paramObject1, Object paramObject2)
  {
    return equals(paramObject1, paramObject2) ^ true;
  }
  
  public static String toString(Object paramObject)
  {
    if (paramObject == null) {
      return "";
    }
    return paramObject.toString();
  }
  
  public static String toString(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      return paramString;
    }
    return paramObject.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.ObjectUtils
 * JD-Core Version:    0.7.0.1
 */