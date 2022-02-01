package com.tencent.mobileqq.jsonconverter;

import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONConverter
{
  public static <T> T a(String paramString, Class<T> paramClass)
  {
    if (!b(paramString))
    {
      if (paramClass == null) {
        return null;
      }
      try
      {
        paramString = a(new JSONObject(paramString), paramClass);
        return paramString;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public static <T> T a(JSONObject paramJSONObject, Class<T> paramClass)
  {
    if (paramJSONObject != null)
    {
      if (paramClass == null) {
        return null;
      }
      try
      {
        Object localObject1 = paramClass.newInstance();
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
      catch (InstantiationException localInstantiationException)
      {
        localInstantiationException.printStackTrace();
      }
      Object localObject2 = null;
      if (localObject2 == null) {
        return null;
      }
      Field[] arrayOfField = paramClass.getDeclaredFields();
      if (arrayOfField != null)
      {
        if (arrayOfField.length == 0) {
          return null;
        }
        int j = arrayOfField.length;
        int i = 0;
        while (i < j)
        {
          Field localField = arrayOfField[i];
          Object localObject3;
          if (localField != null)
          {
            int k = localField.getModifiers();
            if ((!Modifier.isStatic(k)) || (!Modifier.isFinal(k)))
            {
              paramClass = localField.getName();
              localObject3 = (Alias)localField.getAnnotation(Alias.class);
              if (localObject3 != null) {
                paramClass = ((Alias)localObject3).a();
              }
              if ((b(paramClass)) || (!paramJSONObject.has(paramClass))) {}
            }
          }
          try
          {
            localObject3 = localField.getType().getSimpleName();
            localField.setAccessible(true);
            if ("int".equals(localObject3))
            {
              localField.set(localObject2, Integer.valueOf(paramJSONObject.optInt(paramClass)));
            }
            else if ("boolean".equals(localObject3))
            {
              localField.set(localObject2, Boolean.valueOf(paramJSONObject.optBoolean(paramClass)));
            }
            else if ("long".equals(localObject3))
            {
              localField.set(localObject2, Long.valueOf(paramJSONObject.optLong(paramClass)));
            }
            else if ("double".equals(localObject3))
            {
              localField.set(localObject2, Double.valueOf(paramJSONObject.optDouble(paramClass)));
            }
            else if ("float".equals(localObject3))
            {
              localField.set(localObject2, Float.valueOf((float)paramJSONObject.optDouble(paramClass)));
            }
            else if ("String".equals(localObject3))
            {
              localField.set(localObject2, paramJSONObject.optString(paramClass));
            }
            else if ("Object".equals(localObject3))
            {
              localField.set(localObject2, new Object());
            }
            else
            {
              localObject3 = paramJSONObject.opt(paramClass);
              if ((localObject3 instanceof JSONObject))
              {
                paramClass = a((JSONObject)localObject3, localField.getType());
              }
              else if ((localObject3 instanceof JSONArray))
              {
                paramClass = (ParameterizedType)localField.getGenericType();
                paramClass = a((JSONArray)localObject3, paramClass.getActualTypeArguments()[0]);
              }
              else
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("convertFromJSONObject unknown field ");
                ((StringBuilder)localObject3).append(paramClass);
                a(((StringBuilder)localObject3).toString());
                paramClass = null;
              }
              localField.set(localObject2, paramClass);
            }
            i += 1;
          }
          catch (IllegalAccessException paramJSONObject)
          {
            paramJSONObject.printStackTrace();
            return null;
          }
        }
        return localObject2;
      }
    }
    return null;
  }
  
  public static <T> List<T> a(String paramString, Type paramType)
  {
    if (!b(paramString))
    {
      if (paramType == null) {
        return null;
      }
      try
      {
        paramString = a(new JSONArray(paramString), paramType);
        return paramString;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public static <T> List<T> a(JSONArray paramJSONArray, Type paramType)
  {
    if ((paramJSONArray != null) && (paramType != null))
    {
      ArrayList localArrayList = new ArrayList();
      int j = paramJSONArray.length();
      int i = 0;
      while (i < j)
      {
        Object localObject = paramJSONArray.opt(i);
        if (localObject != null) {
          if ((localObject instanceof JSONObject))
          {
            Class localClass = (Class)paramType;
            localArrayList.add(a((JSONObject)localObject, localClass));
          }
          else if ((localObject instanceof JSONArray))
          {
            localArrayList.add(a((JSONArray)localObject, ((ParameterizedType)paramType).getActualTypeArguments()[0]));
          }
          else
          {
            localArrayList.add(localObject);
          }
        }
        i += 1;
      }
      return localArrayList;
    }
    return null;
  }
  
  public static <T> JSONArray a(List<T> paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return localJSONArray;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = paramList.next();
        if (localObject != null) {
          if (b(localObject)) {
            localJSONArray.put(localObject);
          } else if ((localObject instanceof List)) {
            localJSONArray.put(a((List)localObject));
          } else {
            localJSONArray.put(a(localObject));
          }
        }
      }
    }
    return localJSONArray;
  }
  
  public static <T> JSONObject a(T paramT)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramT == null) {
      return localJSONObject;
    }
    Field[] arrayOfField = paramT.getClass().getDeclaredFields();
    if (arrayOfField != null)
    {
      if (arrayOfField.length == 0) {
        return localJSONObject;
      }
      int j = arrayOfField.length;
      int i = 0;
      while (i < j)
      {
        Object localObject1 = arrayOfField[i];
        if (localObject1 != null)
        {
          Object localObject2 = (Alias)((Field)localObject1).getAnnotation(Alias.class);
          if (localObject2 != null)
          {
            localObject2 = ((Alias)localObject2).a();
            if (!b((String)localObject2)) {
              try
              {
                localObject1 = ((Field)localObject1).get(paramT);
                if (localObject1 != null) {
                  if (b(localObject1)) {
                    localJSONObject.put((String)localObject2, localObject1);
                  } else if ((localObject1 instanceof List)) {
                    localJSONObject.put((String)localObject2, a((List)localObject1));
                  } else {
                    localJSONObject.put((String)localObject2, a(localObject1));
                  }
                }
              }
              catch (IllegalAccessException localIllegalAccessException)
              {
                localIllegalAccessException.printStackTrace();
              }
              catch (JSONException localJSONException)
              {
                localJSONException.printStackTrace();
              }
            }
          }
        }
        i += 1;
      }
    }
    return localJSONObject;
  }
  
  private static void a(String paramString)
  {
    QLog.d("JSONConverter", 2, paramString);
  }
  
  private static boolean b(Object paramObject)
  {
    return ((paramObject instanceof Integer)) || ((paramObject instanceof String)) || ((paramObject instanceof Boolean)) || ((paramObject instanceof Double)) || ((paramObject instanceof Float)) || ((paramObject instanceof Long)) || ((paramObject instanceof Byte)) || ((paramObject instanceof Character)) || ((paramObject instanceof Short));
  }
  
  private static boolean b(String paramString)
  {
    return (paramString == null) || (paramString.length() <= 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsonconverter.JSONConverter
 * JD-Core Version:    0.7.0.1
 */