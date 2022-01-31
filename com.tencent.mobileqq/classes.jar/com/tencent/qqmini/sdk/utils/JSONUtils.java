package com.tencent.qqmini.sdk.utils;

import com.tencent.mobileqq.pb.PBField;
import com.tencent.qqmini.sdk.log.QMLog;
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
      if (i < j) {}
      Object localObject2;
      Object localObject1;
      for (;;)
      {
        Object localObject3;
        try
        {
          if (!Modifier.isPublic(arrayOfField[i].getModifiers())) {
            break label270;
          }
          arrayOfField[i].setAccessible(true);
          localObject2 = arrayOfField[i].get(paramObject);
          localObject1 = localObject2;
          if ((localObject2 instanceof PBField)) {
            localObject1 = localObject2.getClass().getDeclaredMethod("get", new Class[0]).invoke(localObject2, new Object[0]);
          }
          if (!(localObject1 instanceof List)) {
            break label225;
          }
          localObject2 = new JSONArray();
          localObject1 = ((List)localObject1).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject3 = ((Iterator)localObject1).next();
          if (isBaseType(localObject3))
          {
            ((JSONArray)localObject2).put(localObject3);
            continue;
            return localJSONObject;
          }
        }
        catch (Exception paramObject)
        {
          QMLog.e("JSONUtils", "convert error:" + paramObject);
        }
        if (localObject3 != null) {
          ((JSONArray)localObject2).put(convert2JSON(localObject3));
        }
      }
      localJSONObject.put(arrayOfField[i].getName(), localObject2);
      break label270;
      label225:
      if (isBaseType(localObject1)) {
        localJSONObject.put(arrayOfField[i].getName(), localObject1);
      } else if (localObject1 != null) {
        localJSONObject.put(arrayOfField[i].getName(), convert2JSON(localObject1));
      }
      label270:
      i += 1;
    }
  }
  
  public static Object convertFrom(JSONObject paramJSONObject, Class<?> paramClass)
  {
    if ((paramJSONObject == null) || (paramClass == null)) {}
    for (;;)
    {
      return null;
      try
      {
        Object localObject1 = paramClass.newInstance();
        if (localObject1 == null) {
          continue;
        }
        paramClass = paramClass.getDeclaredFields();
        int k = paramClass.length;
        int i = 0;
        for (;;)
        {
          if (i >= k) {
            break label350;
          }
          localObject4 = paramClass[i];
          localObject5 = localObject4.getName();
          j = localObject4.getModifiers();
          if ((!Modifier.isStatic(j)) || (!Modifier.isFinal(j))) {
            break;
          }
          i += 1;
        }
      }
      catch (InstantiationException localInstantiationException)
      {
        for (;;)
        {
          Object localObject2 = null;
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        Object localObject3;
        for (;;)
        {
          Object localObject4;
          Object localObject5;
          int j;
          localObject3 = null;
          continue;
          Object localObject6 = localObject4.getType().getSimpleName();
          try
          {
            if (!paramJSONObject.has((String)localObject5)) {
              continue;
            }
            localObject4.setAccessible(true);
            if (((String)localObject6).equals("int")) {
              localObject4.set(localObject3, Integer.valueOf(paramJSONObject.getInt((String)localObject5)));
            }
          }
          catch (JSONException paramJSONObject)
          {
            paramJSONObject.printStackTrace();
            return null;
            if (((String)localObject6).equals("boolean")) {
              localObject4.set(localObject3, Boolean.valueOf(paramJSONObject.getBoolean((String)localObject5)));
            }
          }
          catch (IllegalAccessException paramJSONObject)
          {
            paramJSONObject.printStackTrace();
            return null;
          }
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
        label350:
        return localObject3;
      }
    }
  }
  
  public static <T> T convertFromJsonObject(JSONObject paramJSONObject, Class<T> paramClass)
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
        break label336;
      }
      localField = arrayOfField[i];
      paramClass = localField.getName();
      if ((localField.isAnnotationPresent(JSONUtils.NotKey.class)) || (Modifier.isStatic(localField.getModifiers()))) {
        break label339;
      }
      if (localField.isAnnotationPresent(JSONUtils.FieldName.class)) {
        paramClass = ((JSONUtils.FieldName)localField.getAnnotation(JSONUtils.FieldName.class)).value();
      }
      if (!paramJSONObject.has(paramClass)) {
        break label339;
      }
      localClass2 = localField.getType();
      if (isBaseType(localClass2)) {
        localField.set(localObject, paramJSONObject.get(paramClass));
      }
    }
    catch (Exception paramJSONObject)
    {
      QMLog.e("JSONUtils", "convert json error\n" + paramJSONObject);
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
      localClass1 = ((JSONUtils.GenericType)localField.getAnnotation(JSONUtils.GenericType.class)).value();
      if (List.class.equals(localClass2)) {}
      for (paramClass = new ArrayList();; paramClass = (List)localClass2.newInstance())
      {
        localField.set(localObject, paramClass);
        if (!isBaseType(localClass1)) {
          break label346;
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
        paramClass.add(convertFromJsonObject(localJSONArray.getJSONObject(j), localClass1));
        j += 1;
        continue;
        localField.set(paramJSONObject.getJSONObject(paramClass), localClass2);
        break label339;
        label336:
        return localObject;
      }
      label339:
      i += 1;
      break;
      label346:
      j = 0;
    }
  }
  
  public static JSONObject convertTo(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    Field[] arrayOfField = paramObject.getClass().getDeclaredFields();
    if ((arrayOfField == null) || (arrayOfField.length <= 0)) {
      return localJSONObject;
    }
    for (;;)
    {
      int i;
      try
      {
        int j = arrayOfField.length;
        i = 0;
        if (i < j)
        {
          localField = arrayOfField[i];
          int k = localField.getModifiers();
          if ((Modifier.isStatic(k)) && (Modifier.isFinal(k))) {
            break label246;
          }
          str1 = localField.getName();
          str2 = localField.getType().getSimpleName();
          if (!str2.equals("int")) {
            continue;
          }
          localJSONObject.put(str1, localField.getInt(paramObject));
        }
      }
      catch (IllegalAccessException paramObject)
      {
        paramObject.printStackTrace();
        return localJSONObject;
        if (str2.equals("boolean")) {
          localJSONObject.put(str1, localField.getBoolean(paramObject));
        }
      }
      catch (JSONException paramObject)
      {
        Field localField;
        String str1;
        String str2;
        paramObject.printStackTrace();
        continue;
        if (str2.equals("long")) {
          localJSONObject.put(str1, localField.getLong(paramObject));
        } else if (str2.equals("double")) {
          localJSONObject.put(str1, localField.getDouble(paramObject));
        } else if (str2.equals("String")) {
          localJSONObject.put(str1, (String)localField.get(paramObject));
        }
      }
      label246:
      i += 1;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.JSONUtils
 * JD-Core Version:    0.7.0.1
 */