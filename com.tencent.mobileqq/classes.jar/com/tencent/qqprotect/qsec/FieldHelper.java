package com.tencent.qqprotect.qsec;

import java.lang.reflect.Field;

public class FieldHelper
{
  public static Object a(Object paramObject, String paramString)
  {
    try
    {
      paramObject = paramObject.getClass().getField(paramString).get(paramObject);
      return paramObject;
    }
    catch (IllegalAccessException|IllegalArgumentException|NoSuchFieldException paramObject)
    {
      label15:
      break label15;
    }
    return null;
  }
  
  public static Object b(Object paramObject, String paramString)
  {
    try
    {
      String[] arrayOfString = paramString.split("\\.");
      int j = arrayOfString.length;
      int i = 0;
      for (;;)
      {
        paramString = paramObject;
        if (i >= j) {
          break;
        }
        paramString = arrayOfString[i];
        paramObject = paramObject.getClass().getField(paramString).get(paramObject);
        i += 1;
      }
    }
    catch (IllegalAccessException|IllegalArgumentException|NoSuchFieldException paramObject)
    {
      label46:
      break label46;
    }
    paramString = null;
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.FieldHelper
 * JD-Core Version:    0.7.0.1
 */