package com.tencent.viola.utils;

import android.text.TextUtils;
import com.tencent.viola.annotation.VComponentField;
import com.tencent.viola.annotation.VComponentProp;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VReflectionUtils
{
  public static Map<String, String> getAttrMap(Class paramClass)
  {
    HashMap localHashMap = new HashMap();
    paramClass = paramClass.getMethods();
    int k = paramClass.length;
    int i = 0;
    while (i < k)
    {
      Annotation[] arrayOfAnnotation = paramClass[i].getDeclaredAnnotations();
      int m = arrayOfAnnotation.length;
      int j = 0;
      while (j < m)
      {
        Object localObject = arrayOfAnnotation[j];
        if ((localObject != null) && ((localObject instanceof VComponentProp)))
        {
          localObject = (VComponentProp)localObject;
          if (((VComponentProp)localObject).initToHostView()) {
            localHashMap.put(((VComponentProp)localObject).name(), ((VComponentProp)localObject).nativeReturnMethod());
          }
        }
        j += 1;
      }
      i += 1;
    }
    return localHashMap;
  }
  
  public static Field getDeclaredField(Object paramObject, String paramString)
  {
    for (paramObject = paramObject.getClass(); paramObject != Object.class; paramObject = paramObject.getSuperclass()) {
      try
      {
        Field localField = paramObject.getDeclaredField(paramString);
        return localField;
      }
      catch (Exception localException)
      {
        label19:
        break label19;
      }
    }
    return null;
  }
  
  public static Object getFieldValueFromComponent(Object paramObject, String paramString)
  {
    try
    {
      paramString = getDeclaredField(paramObject, paramString);
      paramString.setAccessible(true);
      paramObject = paramString.get(paramObject);
      return paramObject;
    }
    catch (IndexOutOfBoundsException paramObject)
    {
      paramObject.printStackTrace();
    }
    catch (IllegalAccessException paramObject)
    {
      paramObject.printStackTrace();
    }
    return null;
  }
  
  public static Object getMethodValue(Object paramObject, String paramString)
  {
    try
    {
      paramString = paramObject.getClass().getMethod(paramString, new Class[0]);
    }
    catch (NoSuchMethodException paramString)
    {
      paramString.printStackTrace();
      paramString = null;
    }
    try
    {
      paramObject = paramString.invoke(paramObject, new Object[0]);
      return paramObject;
    }
    catch (InvocationTargetException paramObject)
    {
      paramObject.printStackTrace();
      return null;
    }
    catch (IllegalAccessException paramObject)
    {
      paramObject.printStackTrace();
    }
    return null;
  }
  
  public static Map<String, String> getPropertyMap(Class paramClass)
  {
    HashMap localHashMap = new HashMap();
    paramClass = paramClass.getDeclaredFields();
    int j = paramClass.length;
    int i = 0;
    while (i < j)
    {
      VComponentField localVComponentField = paramClass[i];
      if (localVComponentField.isAnnotationPresent(VComponentField.class))
      {
        localVComponentField = (VComponentField)localVComponentField.getAnnotation(VComponentField.class);
        localHashMap.put(localVComponentField.propertyName(), localVComponentField.nativeReturnMethod());
      }
      i += 1;
    }
    return localHashMap;
  }
  
  public static Object parseArgument(Type paramType, Object paramObject)
  {
    if (paramObject != null)
    {
      if (paramObject.getClass() == paramType) {
        return paramObject;
      }
      if (((paramType instanceof Class)) && (((Class)paramType).isAssignableFrom(paramObject.getClass()))) {
        return paramObject;
      }
    }
    if ((paramType != String.class) || (paramObject == null)) {}
    try
    {
      return new JSONObject().toString();
    }
    catch (JSONException paramType)
    {
      break label316;
    }
    if ((paramObject instanceof String)) {
      return paramObject;
    }
    paramType = new JSONObject(paramObject.toString()).toString();
    return paramType;
    if (paramType == Integer.TYPE)
    {
      if (paramObject.getClass().isAssignableFrom(Integer.TYPE)) {
        return paramObject;
      }
      return Integer.valueOf(ViolaUtils.getInt(paramObject));
    }
    if (paramType == Long.TYPE)
    {
      if (paramObject.getClass().isAssignableFrom(Long.TYPE)) {
        return paramObject;
      }
      return Long.valueOf(ViolaUtils.getLong(paramObject));
    }
    if (paramType == Double.TYPE)
    {
      if (paramObject.getClass().isAssignableFrom(Double.TYPE)) {
        return paramObject;
      }
      return Double.valueOf(ViolaUtils.getDouble(paramObject));
    }
    if (paramType == Boolean.class) {
      return Boolean.valueOf(ViolaUtils.getBoolean(paramObject));
    }
    if (paramType == Boolean.TYPE) {
      return Boolean.valueOf(ViolaUtils.getBoolean(paramObject));
    }
    if (paramType == Float.TYPE)
    {
      if (paramObject.getClass().isAssignableFrom(Float.TYPE)) {
        return paramObject;
      }
      return Float.valueOf(ViolaUtils.getFloat(paramObject));
    }
    if ((paramType == JSONArray.class) && (paramObject != null) && (paramObject.getClass() == JSONArray.class)) {
      return paramObject;
    }
    if ((paramType == JSONObject.class) && (paramObject != null) && (paramObject.getClass() == JSONObject.class)) {
      return paramObject;
    }
    if ((paramObject instanceof String)) {
      paramType = (String)paramObject;
    } else {
      paramType = new JSONObject(paramObject.toString()).toString();
    }
    paramType = new JSONObject(paramType);
    return paramType;
    label316:
    return null;
  }
  
  public static void setProperty(Object paramObject1, Field paramField, Object paramObject2)
  {
    if (paramObject1 != null) {
      if (paramField == null) {
        return;
      }
    }
    try
    {
      paramField.setAccessible(true);
      paramField.set(paramObject1, paramObject2);
      return;
    }
    catch (Exception paramObject1) {}
  }
  
  public static void setValue(Object paramObject1, String paramString, Object paramObject2)
  {
    if (paramObject1 != null) {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        Field localField = getDeclaredField(paramObject1, paramString);
        if (localField != null)
        {
          if (((paramObject2 instanceof BigDecimal)) || ((paramObject2 instanceof Number)) || ((paramObject2 instanceof String)))
          {
            if ((localField.getType() != Float.class) && (localField.getType() != Float.TYPE))
            {
              if ((localField.getType() != Double.class) && (localField.getType() != Double.TYPE))
              {
                if ((localField.getType() != Integer.class) && (localField.getType() != Integer.TYPE))
                {
                  if (localField.getType() != Boolean.class) {
                    if (localField.getType() != Boolean.TYPE) {
                      break label239;
                    }
                  }
                  paramString = Boolean.valueOf(paramObject2.toString());
                }
                else
                {
                  paramString = Integer.valueOf((int)Double.parseDouble(paramObject2.toString()));
                }
              }
              else {
                paramString = Double.valueOf(Double.parseDouble(paramObject2.toString()));
              }
            }
            else {
              paramString = Float.valueOf(Float.parseFloat(paramObject2.toString()));
            }
            Object localObject;
            if (localField.getType() != Boolean.TYPE)
            {
              localObject = paramString;
              if (localField.getType() != Boolean.class) {}
            }
            else
            {
              localObject = paramString;
              if (paramObject2 != null) {
                localObject = Boolean.valueOf(paramObject2.toString());
              }
            }
            setProperty(paramObject1, localField, localObject);
          }
        }
        else {
          return;
        }
      }
      catch (Exception paramObject1)
      {
        return;
      }
      label239:
      paramString = paramObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.utils.VReflectionUtils
 * JD-Core Version:    0.7.0.1
 */