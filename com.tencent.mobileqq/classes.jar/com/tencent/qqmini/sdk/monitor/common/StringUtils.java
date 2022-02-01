package com.tencent.qqmini.sdk.monitor.common;

import java.lang.reflect.Field;

public class StringUtils
{
  static volatile boolean reflactCharArrayResult = true;
  static volatile boolean reflactDataResult = true;
  static Field sCountField;
  static Field sValueField;
  
  public static char[] getStringValue(StringBuilder paramStringBuilder)
  {
    try
    {
      if (sValueField == null)
      {
        sValueField = StringBuilder.class.getSuperclass().getDeclaredField("value");
        sValueField.setAccessible(true);
      }
      paramStringBuilder = (char[])sValueField.get(paramStringBuilder);
      return paramStringBuilder;
    }
    catch (IllegalAccessException paramStringBuilder)
    {
      paramStringBuilder.printStackTrace();
    }
    catch (IllegalArgumentException paramStringBuilder)
    {
      paramStringBuilder.printStackTrace();
    }
    catch (NoSuchFieldException paramStringBuilder)
    {
      paramStringBuilder.printStackTrace();
    }
    return null;
  }
  
  public static String newStringWithData(char[] paramArrayOfChar)
  {
    try
    {
      String str = new String();
      if (reflactDataResult)
      {
        if (sValueField == null)
        {
          sValueField = String.class.getDeclaredField("value");
          sValueField.setAccessible(true);
        }
        if (sCountField == null)
        {
          sCountField = String.class.getDeclaredField("count");
          sCountField.setAccessible(true);
        }
        sValueField.set(str, paramArrayOfChar);
        sCountField.set(str, Integer.valueOf(paramArrayOfChar.length));
        return str;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localIllegalArgumentException.printStackTrace();
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      localNoSuchFieldException.printStackTrace();
    }
    reflactDataResult = false;
    return new String(paramArrayOfChar);
  }
  
  public static char[] reflactCharArray(String paramString)
  {
    try
    {
      if (reflactCharArrayResult)
      {
        if (sValueField == null)
        {
          sValueField = String.class.getDeclaredField("value");
          sValueField.setAccessible(true);
        }
        paramString = (char[])sValueField.get(paramString);
        return paramString;
      }
    }
    catch (IllegalAccessException paramString)
    {
      paramString.printStackTrace();
    }
    catch (IllegalArgumentException paramString)
    {
      paramString.printStackTrace();
    }
    catch (NoSuchFieldException paramString)
    {
      paramString.printStackTrace();
    }
    reflactCharArrayResult = false;
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.monitor.common.StringUtils
 * JD-Core Version:    0.7.0.1
 */