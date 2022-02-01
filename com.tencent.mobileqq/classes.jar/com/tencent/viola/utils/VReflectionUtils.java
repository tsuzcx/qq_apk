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
      if (j < m)
      {
        Object localObject = arrayOfAnnotation[j];
        if (localObject == null) {}
        for (;;)
        {
          j += 1;
          break;
          if ((localObject instanceof VComponentProp))
          {
            localObject = (VComponentProp)localObject;
            if (((VComponentProp)localObject).initToHostView()) {
              localHashMap.put(((VComponentProp)localObject).name(), ((VComponentProp)localObject).nativeReturnMethod());
            }
          }
        }
      }
      i += 1;
    }
    return localHashMap;
  }
  
  public static Field getDeclaredField(Object paramObject, String paramString)
  {
    paramObject = paramObject.getClass();
    while (paramObject != Object.class) {
      try
      {
        Field localField = paramObject.getDeclaredField(paramString);
        return localField;
      }
      catch (Exception localException)
      {
        paramObject = paramObject.getSuperclass();
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
    catch (IllegalAccessException paramObject)
    {
      paramObject.printStackTrace();
      return null;
    }
    catch (IndexOutOfBoundsException paramObject)
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
      for (;;)
      {
        try
        {
          paramObject = paramString.invoke(paramObject, new Object[0]);
          return paramObject;
        }
        catch (IllegalAccessException paramObject)
        {
          paramObject.printStackTrace();
          return null;
        }
        catch (InvocationTargetException paramObject)
        {
          paramObject.printStackTrace();
        }
        paramString = paramString;
        paramString.printStackTrace();
        paramString = null;
      }
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
    if (paramObject != null) {
      if (paramObject.getClass() != paramType) {}
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return paramObject;
                } while (((paramType instanceof Class)) && (((Class)paramType).isAssignableFrom(paramObject.getClass())));
                if ((paramType != String.class) || (paramObject == null)) {}
                try
                {
                  return new JSONObject().toString();
                }
                catch (JSONException paramType)
                {
                  break;
                }
              } while ((paramObject instanceof String));
              paramType = new JSONObject(paramObject.toString()).toString();
              return paramType;
              if (paramType != Integer.TYPE) {
                break;
              }
            } while (paramObject.getClass().isAssignableFrom(Integer.TYPE));
            return Integer.valueOf(ViolaUtils.getInt(paramObject));
            if (paramType != Long.TYPE) {
              break;
            }
          } while (paramObject.getClass().isAssignableFrom(Long.TYPE));
          return Long.valueOf(ViolaUtils.getLong(paramObject));
          if (paramType != Double.TYPE) {
            break;
          }
        } while (paramObject.getClass().isAssignableFrom(Double.TYPE));
        return Double.valueOf(ViolaUtils.getDouble(paramObject));
        if (paramType == Boolean.class) {
          return Boolean.valueOf(ViolaUtils.getBoolean(paramObject));
        }
        if (paramType == Boolean.TYPE) {
          return Boolean.valueOf(ViolaUtils.getBoolean(paramObject));
        }
        if (paramType != Float.TYPE) {
          break;
        }
      } while (paramObject.getClass().isAssignableFrom(Float.TYPE));
      return Float.valueOf(ViolaUtils.getFloat(paramObject));
    } while (((paramType == JSONArray.class) && (paramObject != null) && (paramObject.getClass() == JSONArray.class)) || ((paramType == JSONObject.class) && (paramObject != null) && (paramObject.getClass() == JSONObject.class)));
    try
    {
      if ((paramObject instanceof String)) {}
      for (paramType = (String)paramObject;; paramType = new JSONObject(paramObject.toString()).toString()) {
        return new JSONObject(paramType);
      }
      return null;
    }
    catch (JSONException paramType) {}
  }
  
  public static void setProperty(Object paramObject1, Field paramField, Object paramObject2)
  {
    if ((paramObject1 == null) || (paramField == null)) {
      return;
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
    if ((paramObject1 == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      try
      {
        Field localField = getDeclaredField(paramObject1, paramString);
        if (localField == null) {
          continue;
        }
        if (((paramObject2 instanceof BigDecimal)) || ((paramObject2 instanceof Number)) || ((paramObject2 instanceof String))) {
          if ((localField.getType() == Float.class) || (localField.getType() == Float.TYPE)) {
            paramString = Float.valueOf(Float.parseFloat(paramObject2.toString()));
          }
        }
        for (;;)
        {
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
          return;
          if ((localField.getType() == Double.class) || (localField.getType() == Double.TYPE)) {
            paramString = Double.valueOf(Double.parseDouble(paramObject2.toString()));
          } else if ((localField.getType() == Integer.class) || (localField.getType() == Integer.TYPE)) {
            paramString = Integer.valueOf((int)Double.parseDouble(paramObject2.toString()));
          } else if ((localField.getType() == Boolean.class) || (localField.getType() == Boolean.TYPE)) {
            paramString = Boolean.valueOf(paramObject2.toString());
          } else {
            paramString = paramObject2;
          }
        }
        return;
      }
      catch (Exception paramObject1) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.utils.VReflectionUtils
 * JD-Core Version:    0.7.0.1
 */