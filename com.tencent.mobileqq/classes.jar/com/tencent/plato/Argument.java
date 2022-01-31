package com.tencent.plato;

import com.tencent.plato.core.IFunction;
import com.tencent.plato.core.IWritableArray;
import com.tencent.plato.core.IWritableMap;

public class Argument
{
  public static Object toBaseType(Object paramObject)
  {
    if (((paramObject instanceof Boolean)) || ((paramObject instanceof Integer)) || ((paramObject instanceof Double)) || ((paramObject instanceof Float)) || ((paramObject instanceof String))) {
      return paramObject;
    }
    return toString(paramObject, null);
  }
  
  public static Boolean toBoolean(Object paramObject, Boolean paramBoolean)
  {
    if ((paramObject instanceof Boolean)) {
      return (Boolean)paramObject;
    }
    if ((paramObject instanceof String))
    {
      paramObject = (String)paramObject;
      if ("true".equalsIgnoreCase(paramObject)) {
        return Boolean.valueOf(true);
      }
      if ("false".equalsIgnoreCase(paramObject)) {
        return Boolean.valueOf(false);
      }
    }
    return paramBoolean;
  }
  
  public static Double toDouble(Object paramObject, Double paramDouble)
  {
    if ((paramObject instanceof Double)) {
      return (Double)paramObject;
    }
    if ((paramObject instanceof Number)) {
      return Double.valueOf(((Number)paramObject).doubleValue());
    }
    if ((paramObject instanceof String)) {
      try
      {
        paramObject = Double.valueOf((String)paramObject);
        return paramObject;
      }
      catch (NumberFormatException paramObject) {}
    }
    return paramDouble;
  }
  
  public static IWritableArray toExportedArray(Object paramObject)
  {
    if ((paramObject instanceof IWritableArray)) {
      return (IWritableArray)paramObject;
    }
    return null;
  }
  
  public static IWritableMap toExportedMap(Object paramObject)
  {
    if ((paramObject instanceof IWritableMap)) {
      return (IWritableMap)paramObject;
    }
    return null;
  }
  
  public static Float toFloat(Object paramObject, Float paramFloat)
  {
    if ((paramObject instanceof Float)) {
      return (Float)paramObject;
    }
    if ((paramObject instanceof Number)) {
      return Float.valueOf(((Number)paramObject).floatValue());
    }
    if ((paramObject instanceof String)) {
      try
      {
        paramObject = Float.valueOf((String)paramObject);
        return paramObject;
      }
      catch (NumberFormatException paramObject) {}
    }
    return paramFloat;
  }
  
  public static IFunction toFunction(Object paramObject)
  {
    if ((paramObject instanceof IFunction)) {
      return (IFunction)paramObject;
    }
    return null;
  }
  
  public static Integer toInteger(Object paramObject, Integer paramInteger)
  {
    if ((paramObject instanceof Integer)) {
      return (Integer)paramObject;
    }
    if ((paramObject instanceof Number)) {
      return Integer.valueOf(((Number)paramObject).intValue());
    }
    if ((paramObject instanceof String)) {
      try
      {
        int i = (int)Double.parseDouble((String)paramObject);
        return Integer.valueOf(i);
      }
      catch (NumberFormatException paramObject) {}
    }
    return paramInteger;
  }
  
  public static Long toLong(Object paramObject, Long paramLong)
  {
    if ((paramObject instanceof Long)) {
      return (Long)paramObject;
    }
    if ((paramObject instanceof Number)) {
      return Long.valueOf(((Number)paramObject).longValue());
    }
    if ((paramObject instanceof String)) {
      try
      {
        long l = Double.parseDouble((String)paramObject);
        return Long.valueOf(l);
      }
      catch (NumberFormatException paramObject) {}
    }
    return paramLong;
  }
  
  public static String toString(Object paramObject, String paramString)
  {
    if ((paramObject instanceof String)) {
      return (String)paramObject;
    }
    if (paramObject != null) {
      return String.valueOf(paramObject);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.Argument
 * JD-Core Version:    0.7.0.1
 */