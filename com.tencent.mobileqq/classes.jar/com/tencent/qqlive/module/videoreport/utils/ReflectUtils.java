package com.tencent.qqlive.module.videoreport.utils;

import com.tencent.qqlive.module.videoreport.Log;
import java.lang.reflect.Field;

public class ReflectUtils
{
  private static final String TAG = "ReflectUtils";
  
  public static Object getField(Class<?> paramClass, String paramString)
  {
    try
    {
      paramClass = getFieldWithException(paramClass, paramString, null);
      return paramClass;
    }
    catch (Exception paramClass)
    {
      paramString = new StringBuilder();
      paramString.append("getField ");
      paramString.append(paramClass);
      Log.e("ReflectUtils", paramString.toString());
    }
    return null;
  }
  
  public static Object getField(Class<?> paramClass, String paramString, Object paramObject)
  {
    try
    {
      paramClass = getFieldWithException(paramClass, paramString, paramObject);
      return paramClass;
    }
    catch (Exception paramClass)
    {
      paramString = new StringBuilder();
      paramString.append("getField ");
      paramString.append(paramClass);
      Log.e("ReflectUtils", paramString.toString());
    }
    return null;
  }
  
  public static <T> T getField(String paramString, Object paramObject)
  {
    try
    {
      paramString = paramObject.getClass().getField(paramString);
      paramString.setAccessible(true);
      paramString = paramString.get(paramObject);
      return paramString;
    }
    catch (Exception paramString)
    {
      label22:
      break label22;
    }
    return null;
  }
  
  public static Object getFieldWithException(Class<?> paramClass, String paramString, Object paramObject)
  {
    paramClass = paramClass.getDeclaredField(paramString);
    paramClass.setAccessible(true);
    return paramClass.get(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.utils.ReflectUtils
 * JD-Core Version:    0.7.0.1
 */