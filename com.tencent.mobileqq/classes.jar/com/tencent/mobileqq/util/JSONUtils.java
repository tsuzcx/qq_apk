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
    if ((paramJSONObject == null) || (paramClass == null)) {
      return null;
    }
    Object localObject3;
    for (;;)
    {
      Object localObject4;
      Object localObject5;
      int j;
      Object localObject6;
      try
      {
        Object localObject1 = paramClass.newInstance();
        if (localObject1 == null) {
          break;
        }
        paramClass = paramClass.getDeclaredFields();
        int k = paramClass.length;
        int i = 0;
        if (i >= k) {
          break label362;
        }
        localObject4 = paramClass[i];
        localObject5 = localObject4.getName();
        j = localObject4.getModifiers();
        if ((Modifier.isStatic(j)) && (Modifier.isFinal(j)))
        {
          i += 1;
          continue;
        }
      }
      catch (InstantiationException localInstantiationException)
      {
        Object localObject2 = null;
        continue;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;)
        {
          localObject3 = null;
          continue;
          localObject6 = localObject4.getType().getSimpleName();
          try
          {
            if (paramJSONObject.has((String)localObject5))
            {
              localObject4.setAccessible(true);
              if (((String)localObject6).equals("int")) {
                localObject4.set(localObject3, Integer.valueOf(paramJSONObject.getInt((String)localObject5)));
              }
            }
          }
          catch (JSONException paramJSONObject)
          {
            if (!QLog.isDevelopLevel()) {
              break;
            }
            paramJSONObject.printStackTrace();
            return null;
            if (!((String)localObject6).equals("boolean")) {
              break label202;
            }
            localObject4.set(localObject3, Boolean.valueOf(paramJSONObject.getBoolean((String)localObject5)));
          }
          catch (IllegalAccessException paramJSONObject) {}
        }
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      paramJSONObject.printStackTrace();
      return null;
      label202:
      if (((String)localObject6).equals("long"))
      {
        localObject4.set(localObject3, Long.valueOf(paramJSONObject.getLong((String)localObject5)));
      }
      else if (((String)localObject6).equals("double"))
      {
        localObject4.set(localObject3, Double.valueOf(paramJSONObject.getDouble((String)localObject5)));
      }
      else if (((String)localObject6).equals("String"))
      {
        localObject4.set(localObject3, paramJSONObject.getString((String)localObject5));
      }
      else if (((String)localObject6).equals("String[]"))
      {
        localObject5 = paramJSONObject.getJSONArray((String)localObject5);
        if (((JSONArray)localObject5).length() > 0)
        {
          localObject6 = new String[((JSONArray)localObject5).length()];
          j = 0;
          while (j < ((JSONArray)localObject5).length())
          {
            localObject6[j] = ((JSONArray)localObject5).getString(j);
            j += 1;
          }
          localObject4.set(localObject3, localObject6);
        }
      }
    }
    label362:
    return localObject3;
  }
  
  public static JSONObject a(Object paramObject)
  {
    JSONObject localJSONObject = new JSONObject();
    Field[] arrayOfField = paramObject.getClass().getDeclaredFields();
    int j = arrayOfField.length;
    int i = 0;
    for (;;)
    {
      if (i < j) {}
      Object localObject2;
      Object localObject1;
      for (;;)
      {
        Object localObject3;
        try
        {
          if (!Modifier.isPublic(arrayOfField[i].getModifiers())) {
            break label277;
          }
          arrayOfField[i].setAccessible(true);
          localObject2 = arrayOfField[i].get(paramObject);
          localObject1 = localObject2;
          if ((localObject2 instanceof PBField)) {
            localObject1 = localObject2.getClass().getDeclaredMethod("get", new Class[0]).invoke(localObject2, new Object[0]);
          }
          if (!(localObject1 instanceof List)) {
            break label232;
          }
          localObject2 = new JSONArray();
          localObject1 = ((List)localObject1).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject3 = ((Iterator)localObject1).next();
          if (a(localObject3))
          {
            ((JSONArray)localObject2).put(localObject3);
            continue;
            return localJSONObject;
          }
        }
        catch (Exception paramObject)
        {
          if (QLog.isColorLevel()) {
            QLog.e("JSONUtils", 2, "convert error:" + paramObject);
          }
        }
        if (localObject3 != null) {
          ((JSONArray)localObject2).put(a(localObject3));
        }
      }
      localJSONObject.put(arrayOfField[i].getName(), localObject2);
      break label277;
      label232:
      if (a(localObject1)) {
        localJSONObject.put(arrayOfField[i].getName(), localObject1);
      } else if (localObject1 != null) {
        localJSONObject.put(arrayOfField[i].getName(), a(localObject1));
      }
      label277:
      i += 1;
    }
  }
  
  static boolean a(Class paramClass)
  {
    return (paramClass.isPrimitive()) || (paramClass.equals(Integer.class)) || (paramClass.equals(Long.class)) || (paramClass.equals(String.class)) || (paramClass.equals(Boolean.class)) || (paramClass.equals(Double.class));
  }
  
  static boolean a(Object paramObject)
  {
    return ((paramObject instanceof Integer)) || ((paramObject instanceof Long)) || ((paramObject instanceof String)) || ((paramObject instanceof Boolean)) || ((paramObject instanceof Double));
  }
  
  public static <T> T b(JSONObject paramJSONObject, Class<T> paramClass)
  {
    if ((paramJSONObject == null) || (paramClass == null)) {
      return null;
    }
    Object localObject;
    int i;
    Field localField;
    Class localClass2;
    try
    {
      localObject = paramClass.newInstance();
      Field[] arrayOfField = paramClass.getFields();
      int k = arrayOfField.length;
      i = 0;
      if (i >= k) {
        break label344;
      }
      localField = arrayOfField[i];
      paramClass = localField.getName();
      if ((localField.isAnnotationPresent(JSONUtils.NotKey.class)) || (Modifier.isStatic(localField.getModifiers()))) {
        break label347;
      }
      if (localField.isAnnotationPresent(JSONUtils.FieldName.class)) {
        paramClass = ((JSONUtils.FieldName)localField.getAnnotation(JSONUtils.FieldName.class)).a();
      }
      if (!paramJSONObject.has(paramClass)) {
        break label347;
      }
      localClass2 = localField.getType();
      if (a(localClass2)) {
        localField.set(localObject, paramJSONObject.get(paramClass));
      }
    }
    catch (Exception paramJSONObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d("JSONUtils", 2, "convert json error\n" + paramJSONObject);
      }
      return null;
    }
    JSONArray localJSONArray;
    Class localClass1;
    int j;
    if (List.class.isAssignableFrom(localClass2))
    {
      localJSONArray = paramJSONObject.getJSONArray(paramClass);
      if (!localField.isAnnotationPresent(JSONUtils.GenericType.class)) {
        return null;
      }
      localClass1 = ((JSONUtils.GenericType)localField.getAnnotation(JSONUtils.GenericType.class)).a();
      if (List.class.equals(localClass2)) {}
      for (paramClass = new ArrayList();; paramClass = (List)localClass2.newInstance())
      {
        localField.set(localObject, paramClass);
        if (!a(localClass1)) {
          break label354;
        }
        j = 0;
        while (j < localJSONArray.length())
        {
          paramClass.add(localJSONArray.get(j));
          j += 1;
        }
      }
    }
    for (;;)
    {
      if (j < localJSONArray.length())
      {
        paramClass.add(b(localJSONArray.getJSONObject(j), localClass1));
        j += 1;
        continue;
        localField.set(paramJSONObject.getJSONObject(paramClass), localClass2);
        break label347;
        label344:
        return localObject;
      }
      label347:
      i += 1;
      break;
      label354:
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.JSONUtils
 * JD-Core Version:    0.7.0.1
 */