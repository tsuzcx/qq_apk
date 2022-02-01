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
    Object localObject3;
    for (;;)
    {
      return null;
      try
      {
        Object localObject1 = paramClass.newInstance();
        if (localObject1 != null)
        {
          paramClass = paramClass.getDeclaredFields();
          int j = paramClass.length;
          int i = 0;
          for (;;)
          {
            if (i >= j) {
              break label109;
            }
            localField = paramClass[i];
            str = localField.getName();
            int k = localField.getModifiers();
            if ((!Modifier.isStatic(k)) || (!Modifier.isFinal(k))) {
              break;
            }
            i += 1;
          }
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
        Field localField;
        String str;
        do
        {
          for (;;)
          {
            localObject3 = null;
          }
        } while (jsonToField(paramJSONObject, localObject3, localField, str));
        return null;
      }
    }
    label109:
    return localObject3;
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
        break label334;
      }
      localField = arrayOfField[i];
      paramClass = localField.getName();
      if ((localField.isAnnotationPresent(JSONUtils.NotKey.class)) || (Modifier.isStatic(localField.getModifiers()))) {
        break label337;
      }
      if (localField.isAnnotationPresent(JSONUtils.FieldName.class)) {
        paramClass = ((JSONUtils.FieldName)localField.getAnnotation(JSONUtils.FieldName.class)).value();
      }
      if (!paramJSONObject.has(paramClass)) {
        break label337;
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
          break label344;
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
        break label337;
        label334:
        return localObject;
      }
      label337:
      i += 1;
      break;
      label344:
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
            break label248;
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
      label248:
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
  
  private static boolean jsonToField(JSONObject paramJSONObject, Object paramObject, Field paramField, String paramString)
  {
    String str = paramField.getType().getSimpleName();
    try
    {
      if (!paramJSONObject.has(paramString)) {
        break label222;
      }
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
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      return false;
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
    label222:
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.JSONUtils
 * JD-Core Version:    0.7.0.1
 */