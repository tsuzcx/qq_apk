package com.tencent.mobileqq.util;

import com.tencent.mobileqq.pb.PBField;
import com.tencent.qphone.base.util.QLog;
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
  public static Object a(JSONObject paramJSONObject, Class<?> paramClass)
  {
    if (paramJSONObject != null) {
      if (paramClass == null) {
        return null;
      }
    }
    try
    {
      localObject1 = paramClass.newInstance();
    }
    catch (InstantiationException|IllegalAccessException localInstantiationException)
    {
      Object localObject1;
      label19:
      int k;
      int i;
      break label19;
    }
    localObject1 = null;
    if (localObject1 == null) {
      return null;
    }
    paramClass = paramClass.getDeclaredFields();
    k = paramClass.length;
    i = 0;
    while (i < k)
    {
      Object localObject2 = paramClass[i];
      Object localObject3 = localObject2.getName();
      int j = localObject2.getModifiers();
      Object localObject4;
      if ((!Modifier.isStatic(j)) || (!Modifier.isFinal(j))) {
        localObject4 = localObject2.getType().getSimpleName();
      }
      try
      {
        if (paramJSONObject.has((String)localObject3))
        {
          localObject2.setAccessible(true);
          if (((String)localObject4).equals("int"))
          {
            localObject2.set(localObject1, Integer.valueOf(paramJSONObject.getInt((String)localObject3)));
          }
          else if (((String)localObject4).equals("boolean"))
          {
            localObject2.set(localObject1, Boolean.valueOf(paramJSONObject.getBoolean((String)localObject3)));
          }
          else if (((String)localObject4).equals("long"))
          {
            localObject2.set(localObject1, Long.valueOf(paramJSONObject.getLong((String)localObject3)));
          }
          else if (((String)localObject4).equals("double"))
          {
            localObject2.set(localObject1, Double.valueOf(paramJSONObject.getDouble((String)localObject3)));
          }
          else if (((String)localObject4).equals("String"))
          {
            localObject2.set(localObject1, paramJSONObject.getString((String)localObject3));
          }
          else if (((String)localObject4).equals("String[]"))
          {
            localObject3 = paramJSONObject.getJSONArray((String)localObject3);
            if (((JSONArray)localObject3).length() > 0)
            {
              localObject4 = new String[((JSONArray)localObject3).length()];
              j = 0;
              while (j < ((JSONArray)localObject3).length())
              {
                localObject4[j] = ((JSONArray)localObject3).getString(j);
                j += 1;
              }
              localObject2.set(localObject1, localObject4);
            }
          }
        }
        i += 1;
      }
      catch (IllegalAccessException paramJSONObject)
      {
        if (QLog.isDevelopLevel()) {
          paramJSONObject.printStackTrace();
        }
        return null;
      }
      catch (JSONException paramJSONObject)
      {
        if (QLog.isDevelopLevel()) {
          paramJSONObject.printStackTrace();
        }
        return null;
      }
    }
    return localObject1;
    return null;
  }
  
  public static JSONObject a(Object paramObject)
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
                if (b(localObject3)) {
                  ((JSONArray)localObject2).put(localObject3);
                } else if (localObject3 != null) {
                  ((JSONArray)localObject2).put(a(localObject3));
                }
              }
              localJSONObject.put(arrayOfField[i].getName(), localObject2);
            }
            else if (b(localObject1))
            {
              localJSONObject.put(arrayOfField[i].getName(), localObject1);
            }
            else if (localObject1 != null)
            {
              localJSONObject.put(arrayOfField[i].getName(), a(localObject1));
            }
          }
          i += 1;
        }
        catch (Exception paramObject)
        {
          Object localObject1;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("convert error:");
            ((StringBuilder)localObject1).append(paramObject);
            QLog.e("JSONUtils", 2, ((StringBuilder)localObject1).toString());
          }
        }
      }
    }
    return localJSONObject;
  }
  
  static boolean a(Class paramClass)
  {
    return (paramClass.isPrimitive()) || (paramClass.equals(Integer.class)) || (paramClass.equals(Long.class)) || (paramClass.equals(String.class)) || (paramClass.equals(Boolean.class)) || (paramClass.equals(Double.class));
  }
  
  public static <T> T b(JSONObject paramJSONObject, Class<T> paramClass)
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
              paramClass = ((JSONUtils.FieldName)localField.getAnnotation(JSONUtils.FieldName.class)).a();
            }
            if (paramJSONObject.has(paramClass))
            {
              Class localClass2 = localField.getType();
              if (a(localClass2))
              {
                localField.set(localObject, paramJSONObject.get(paramClass));
              }
              else if (List.class.isAssignableFrom(localClass2))
              {
                JSONArray localJSONArray = paramJSONObject.getJSONArray(paramClass);
                if (!localField.isAnnotationPresent(JSONUtils.GenericType.class)) {
                  return null;
                }
                Class localClass1 = ((JSONUtils.GenericType)localField.getAnnotation(JSONUtils.GenericType.class)).a();
                if (List.class.equals(localClass2)) {
                  paramClass = new ArrayList();
                } else {
                  paramClass = (List)localClass2.newInstance();
                }
                localField.set(localObject, paramClass);
                if (!a(localClass1)) {
                  break label363;
                }
                j = 0;
                if (j < localJSONArray.length())
                {
                  paramClass.add(localJSONArray.get(j));
                  j += 1;
                  continue;
                  if (j < localJSONArray.length())
                  {
                    paramClass.add(b(localJSONArray.getJSONObject(j), localClass1));
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
        if (QLog.isColorLevel())
        {
          paramClass = new StringBuilder();
          paramClass.append("convert json error\n");
          paramClass.append(paramJSONObject);
          QLog.d("JSONUtils", 2, paramClass.toString());
        }
      }
      return null;
      label363:
      int j = 0;
    }
  }
  
  static boolean b(Object paramObject)
  {
    return ((paramObject instanceof Integer)) || ((paramObject instanceof Long)) || ((paramObject instanceof String)) || ((paramObject instanceof Boolean)) || ((paramObject instanceof Double));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.JSONUtils
 * JD-Core Version:    0.7.0.1
 */