package org.apache.commons.lang;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class Validate
{
  public static void allElementsOfType(Collection paramCollection, Class paramClass)
  {
    notNull(paramCollection);
    notNull(paramClass);
    paramCollection = paramCollection.iterator();
    int i = 0;
    while (paramCollection.hasNext()) {
      if (paramClass.isInstance(paramCollection.next()))
      {
        i += 1;
      }
      else
      {
        paramCollection = new StringBuffer();
        paramCollection.append("The validated collection contains an element not of type ");
        paramCollection.append(paramClass.getName());
        paramCollection.append(" at index: ");
        paramCollection.append(i);
        throw new IllegalArgumentException(paramCollection.toString());
      }
    }
  }
  
  public static void allElementsOfType(Collection paramCollection, Class paramClass, String paramString)
  {
    notNull(paramCollection);
    notNull(paramClass);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (!paramClass.isInstance(paramCollection.next())) {
        throw new IllegalArgumentException(paramString);
      }
    }
  }
  
  public static void isTrue(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException("The validated expression is false");
  }
  
  public static void isTrue(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException(paramString);
  }
  
  public static void isTrue(boolean paramBoolean, String paramString, double paramDouble)
  {
    if (paramBoolean) {
      return;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramString);
    localStringBuffer.append(paramDouble);
    throw new IllegalArgumentException(localStringBuffer.toString());
  }
  
  public static void isTrue(boolean paramBoolean, String paramString, long paramLong)
  {
    if (paramBoolean) {
      return;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramString);
    localStringBuffer.append(paramLong);
    throw new IllegalArgumentException(localStringBuffer.toString());
  }
  
  public static void isTrue(boolean paramBoolean, String paramString, Object paramObject)
  {
    if (paramBoolean) {
      return;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramString);
    localStringBuffer.append(paramObject);
    throw new IllegalArgumentException(localStringBuffer.toString());
  }
  
  public static void noNullElements(Collection paramCollection)
  {
    notNull(paramCollection);
    paramCollection = paramCollection.iterator();
    int i = 0;
    while (paramCollection.hasNext()) {
      if (paramCollection.next() != null)
      {
        i += 1;
      }
      else
      {
        paramCollection = new StringBuffer();
        paramCollection.append("The validated collection contains null element at index: ");
        paramCollection.append(i);
        throw new IllegalArgumentException(paramCollection.toString());
      }
    }
  }
  
  public static void noNullElements(Collection paramCollection, String paramString)
  {
    notNull(paramCollection);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (paramCollection.next() == null) {
        throw new IllegalArgumentException(paramString);
      }
    }
  }
  
  public static void noNullElements(Object[] paramArrayOfObject)
  {
    notNull(paramArrayOfObject);
    int i = 0;
    while (i < paramArrayOfObject.length) {
      if (paramArrayOfObject[i] != null)
      {
        i += 1;
      }
      else
      {
        paramArrayOfObject = new StringBuffer();
        paramArrayOfObject.append("The validated array contains null element at index: ");
        paramArrayOfObject.append(i);
        throw new IllegalArgumentException(paramArrayOfObject.toString());
      }
    }
  }
  
  public static void noNullElements(Object[] paramArrayOfObject, String paramString)
  {
    notNull(paramArrayOfObject);
    int i = 0;
    while (i < paramArrayOfObject.length) {
      if (paramArrayOfObject[i] != null) {
        i += 1;
      } else {
        throw new IllegalArgumentException(paramString);
      }
    }
  }
  
  public static void notEmpty(String paramString)
  {
    notEmpty(paramString, "The validated string is empty");
  }
  
  public static void notEmpty(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.length() != 0)) {
      return;
    }
    throw new IllegalArgumentException(paramString2);
  }
  
  public static void notEmpty(Collection paramCollection)
  {
    notEmpty(paramCollection, "The validated collection is empty");
  }
  
  public static void notEmpty(Collection paramCollection, String paramString)
  {
    if ((paramCollection != null) && (paramCollection.size() != 0)) {
      return;
    }
    throw new IllegalArgumentException(paramString);
  }
  
  public static void notEmpty(Map paramMap)
  {
    notEmpty(paramMap, "The validated map is empty");
  }
  
  public static void notEmpty(Map paramMap, String paramString)
  {
    if ((paramMap != null) && (paramMap.size() != 0)) {
      return;
    }
    throw new IllegalArgumentException(paramString);
  }
  
  public static void notEmpty(Object[] paramArrayOfObject)
  {
    notEmpty(paramArrayOfObject, "The validated array is empty");
  }
  
  public static void notEmpty(Object[] paramArrayOfObject, String paramString)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length != 0)) {
      return;
    }
    throw new IllegalArgumentException(paramString);
  }
  
  public static void notNull(Object paramObject)
  {
    notNull(paramObject, "The validated object is null");
  }
  
  public static void notNull(Object paramObject, String paramString)
  {
    if (paramObject != null) {
      return;
    }
    throw new IllegalArgumentException(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.Validate
 * JD-Core Version:    0.7.0.1
 */