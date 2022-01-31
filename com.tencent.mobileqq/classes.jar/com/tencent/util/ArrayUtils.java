package com.tencent.util;

public class ArrayUtils
{
  public static boolean a(Object[] paramArrayOfObject, Object paramObject)
  {
    if ((paramArrayOfObject == null) || (paramObject == null)) {}
    for (;;)
    {
      return false;
      int j = paramArrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramArrayOfObject[i];
        if ((localObject != null) && (localObject.equals(paramObject))) {
          return true;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.util.ArrayUtils
 * JD-Core Version:    0.7.0.1
 */