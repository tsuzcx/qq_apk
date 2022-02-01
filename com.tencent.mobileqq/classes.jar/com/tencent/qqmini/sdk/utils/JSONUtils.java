package com.tencent.qqmini.sdk.utils;

import com.tencent.mobileqq.pb.PBField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public class JSONUtils
{
  static final String TAG = "JSONUtils";
  
  public static JSONObject convert2JSON(Object paramObject)
  {
    JSONObject localJSONObject = new JSONObject();
    Field[] arrayOfField = paramObject.getClass().getDeclaredFields();
    int j = arrayOfField.length;
    int i = 0;
    for (;;)
    {
      if (i < j) {
        try
        {
          if (Modifier.isPublic(arrayOfField[i].getModifiers()))
          {
            arrayOfField[i].setAccessible(true);
            Object localObject2 = arrayOfField[i].get(paramObject);
            localObject1 = localObject2;
            if ((localObject2 instanceof PBField)) {
              localObject1 = localObject2.getClass().getDeclaredMethod("get", new Class[0]).invoke(localObject2, new Object[0]);
            }
            if ((localObject1 instanceof List))
            {
              localObject2 = new JSONArray();
              localObject1 = ((List)localObject1).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                Object localObject3 = ((Iterator)localObject1).next();
                if (isBaseType(localObject3)) {
                  ((JSONArray)localObject2).put(localObject3);
                } else if (localObject3 != null) {
                  ((JSONArray)localObject2).put(convert2JSON(localObject3));
                }
              }
              localJSONObject.put(arrayOfField[i].getName(), localObject2);
            }
            else if (isBaseType(localObject1))
            {
              localJSONObject.put(arrayOfField[i].getName(), localObject1);
            }
            else if (localObject1 != null)
            {
              localJSONObject.put(arrayOfField[i].getName(), convert2JSON(localObject1));
            }
          }
          i += 1;
        }
        catch (Exception paramObject)
        {
          Object localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("convert error:");
          ((StringBuilder)localObject1).append(paramObject);
          QMLog.e("JSONUtils", ((StringBuilder)localObject1).toString());
        }
      }
    }
    return localJSONObject;
  }
  
  public static Object convertFrom(JSONObject paramJSONObject, Class<?> paramClass)
  {
    if (paramJSONObject != null) {
      if (paramClass == null) {
        return null;
      }
    }
    try
    {
      localObject = paramClass.newInstance();
    }
    catch (InstantiationException|IllegalAccessException localInstantiationException)
    {
      Object localObject;
      label19:
      int j;
      int i;
      break label19;
    }
    localObject = null;
    if (localObject == null) {
      return null;
    }
    paramClass = paramClass.getDeclaredFields();
    j = paramClass.length;
    i = 0;
    while (i < j)
    {
      Field localField = paramClass[i];
      String str = localField.getName();
      int k = localField.getModifiers();
      if (((!Modifier.isStatic(k)) || (!Modifier.isFinal(k))) && (!jsonToField(paramJSONObject, localObject, localField, str))) {
        return null;
      }
      i += 1;
    }
    return localObject;
    return null;
  }
  
  public static <T> T convertFromJsonObject(JSONObject paramJSONObject, Class<T> paramClass)
  {
    if (paramJSONObject != null) {
      if (paramClass == null) {
        return null;
      }
    }
    for (;;)
    {
      try
      {
        Object localObject = paramClass.newInstance();
        Field[] arrayOfField = paramClass.getFields();
        int k = arrayOfField.length;
        int i = 0;
        if (i < k)
        {
          Field localField = arrayOfField[i];
          paramClass = localField.getName();
          if ((!localField.isAnnotationPresent(JSONUtils.NotKey.class)) && (!Modifier.isStatic(localField.getModifiers())))
          {
            if (localField.isAnnotationPresent(JSONUtils.FieldName.class)) {
              paramClass = ((JSONUtils.FieldName)localField.getAnnotation(JSONUtils.FieldName.class)).value();
            }
            if (paramJSONObject.has(paramClass))
            {
              Class localClass2 = localField.getType();
              if (isBaseType(localClass2))
              {
                localField.set(localObject, paramJSONObject.get(paramClass));
              }
              else if (List.class.isAssignableFrom(localClass2))
              {
                JSONArray localJSONArray = paramJSONObject.getJSONArray(paramClass);
                if (!localField.isAnnotationPresent(JSONUtils.GenericType.class)) {
                  return null;
                }
                Class localClass1 = ((JSONUtils.GenericType)localField.getAnnotation(JSONUtils.GenericType.class)).value();
                if (List.class.equals(localClass2)) {
                  paramClass = new ArrayList();
                } else {
                  paramClass = (List)localClass2.newInstance();
                }
                localField.set(localObject, paramClass);
                if (!isBaseType(localClass1)) {
                  break label353;
                }
                j = 0;
                if (j < localJSONArray.length())
                {
                  paramClass.add(localJSONArray.get(j));
                  j += 1;
                  continue;
                  if (j < localJSONArray.length())
                  {
                    paramClass.add(convertFromJsonObject(localJSONArray.getJSONObject(j), localClass1));
                    j += 1;
                    continue;
                  }
                }
              }
              else
              {
                localField.set(paramJSONObject.getJSONObject(paramClass), localClass2);
              }
            }
          }
          i += 1;
          continue;
        }
        return localObject;
      }
      catch (Exception paramJSONObject)
      {
        paramClass = new StringBuilder();
        paramClass.append("convert json error\n");
        paramClass.append(paramJSONObject);
        QMLog.e("JSONUtils", paramClass.toString());
      }
      return null;
      label353:
      int j = 0;
    }
  }
  
  public static JSONObject convertTo(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    localJSONObject = new JSONObject();
    Field[] arrayOfField = paramObject.getClass().getDeclaredFields();
    if (arrayOfField != null)
    {
      if (arrayOfField.length <= 0) {
        return localJSONObject;
      }
      try
      {
        int j = arrayOfField.length;
        int i = 0;
        while (i < j)
        {
          Field localField = arrayOfField[i];
          int k = localField.getModifiers();
          if ((!Modifier.isStatic(k)) || (!Modifier.isFinal(k)))
          {
            String str1 = localField.getName();
            String str2 = localField.getType().getSimpleName();
            if (str2.equals("int")) {
              localJSONObject.put(str1, localField.getInt(paramObject));
            } else if (str2.equals("boolean")) {
              localJSONObject.put(str1, localField.getBoolean(paramObject));
            } else if (str2.equals("long")) {
              localJSONObject.put(str1, localField.getLong(paramObject));
            } else if (str2.equals("double")) {
              localJSONObject.put(str1, localField.getDouble(paramObject));
            } else if (str2.equals("String")) {
              localJSONObject.put(str1, (String)localField.get(paramObject));
            }
          }
          i += 1;
        }
        return localJSONObject;
      }
      catch (JSONException paramObject)
      {
        paramObject.printStackTrace();
        return localJSONObject;
      }
      catch (IllegalAccessException paramObject)
      {
        paramObject.printStackTrace();
      }
    }
  }
  
  static boolean isBaseType(Class paramClass)
  {
    return (paramClass.isPrimitive()) || (paramClass.equals(Integer.class)) || (paramClass.equals(Long.class)) || (paramClass.equals(String.class)) || (paramClass.equals(Boolean.class)) || (paramClass.equals(Double.class));
  }
  
  static boolean isBaseType(Object paramObject)
  {
    return ((paramObject instanceof Integer)) || ((paramObject instanceof Long)) || ((paramObject instanceof String)) || ((paramObject instanceof Boolean)) || ((paramObject instanceof Double));
  }
  
  private static boolean jsonToField(JSONObject paramJSONObject, Object paramObject, Field paramField, String paramString)
  {
    String str = paramField.getType().getSimpleName();
    try
    {
      if (paramJSONObject.has(paramString))
      {
        paramField.setAccessible(true);
        if (str.equals("int"))
        {
          paramField.set(paramObject, Integer.valueOf(paramJSONObject.getInt(paramString)));
          return true;
        }
        if (str.equals("boolean"))
        {
          paramField.set(paramObject, Boolean.valueOf(paramJSONObject.getBoolean(paramString)));
          return true;
        }
        if (str.equals("long"))
        {
          paramField.set(paramObject, Long.valueOf(paramJSONObject.getLong(paramString)));
          return true;
        }
        if (str.equals("double"))
        {
          paramField.set(paramObject, Double.valueOf(paramJSONObject.getDouble(paramString)));
          return true;
        }
        if (str.equals("String"))
        {
          paramField.set(paramObject, paramJSONObject.getString(paramString));
          return true;
        }
        if (str.equals("String[]"))
        {
          paramJSONObject = paramJSONObject.getJSONArray(paramString);
          if (paramJSONObject.length() > 0)
          {
            paramString = new String[paramJSONObject.length()];
            int i = 0;
            while (i < paramJSONObject.length())
            {
              paramString[i] = paramJSONObject.getString(i);
              i += 1;
            }
            paramField.set(paramObject, paramString);
          }
        }
      }
      return true;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.JSONUtils
 * JD-Core Version:    0.7.0.1
 */