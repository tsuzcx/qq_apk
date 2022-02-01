package com.tencent.qqmini.sdk.utils;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
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
  public static <T> JSONArray convert2JSONArray(List<T> paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    if ((paramList == null) || (paramList.isEmpty())) {
      return localJSONArray;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if (localObject != null) {
        if (isPrimitiveType(localObject)) {
          localJSONArray.put(localObject);
        } else if ((localObject instanceof List)) {
          localJSONArray.put(convert2JSONArray((List)localObject));
        } else {
          localJSONArray.put(convert2JSONObject(localObject));
        }
      }
    }
    return localJSONArray;
  }
  
  public static <T> JSONObject convert2JSONObject(T paramT)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramT == null) {
      return localJSONObject;
    }
    Field[] arrayOfField = paramT.getClass().getDeclaredFields();
    if ((arrayOfField == null) || (arrayOfField.length == 0)) {
      return localJSONObject;
    }
    int j = arrayOfField.length;
    int i = 0;
    if (i < j)
    {
      Object localObject1 = arrayOfField[i];
      if (localObject1 == null) {}
      for (;;)
      {
        i += 1;
        break;
        Object localObject2 = (Alias)((Field)localObject1).getAnnotation(Alias.class);
        if (localObject2 != null)
        {
          localObject2 = ((Alias)localObject2).value();
          if (!isEmpty((String)localObject2))
          {
            try
            {
              localObject1 = ((Field)localObject1).get(paramT);
              if (localObject1 == null) {
                continue;
              }
              if (isPrimitiveType(localObject1)) {
                localJSONObject.put((String)localObject2, localObject1);
              }
            }
            catch (JSONException localJSONException)
            {
              localJSONException.printStackTrace();
              continue;
              if (!(localJSONException instanceof List)) {
                break label178;
              }
              localJSONObject.put((String)localObject2, convert2JSONArray((List)localJSONException));
            }
            catch (IllegalAccessException localIllegalAccessException)
            {
              localIllegalAccessException.printStackTrace();
            }
            continue;
            label178:
            localJSONObject.put((String)localObject2, convert2JSONObject(localIllegalAccessException));
          }
        }
      }
    }
    return localJSONObject;
  }
  
  public static <T> List<T> convertFromJSONArray(String paramString, Type paramType)
  {
    if ((isEmpty(paramString)) || (paramType == null)) {
      return null;
    }
    try
    {
      paramString = convertFromJSONArray(new JSONArray(paramString), paramType);
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static <T> List<T> convertFromJSONArray(JSONArray paramJSONArray, Type paramType)
  {
    if ((paramJSONArray == null) || (paramType == null)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int j = paramJSONArray.length();
    int i = 0;
    if (i < j)
    {
      Object localObject = paramJSONArray.opt(i);
      if (localObject == null) {}
      for (;;)
      {
        i += 1;
        break;
        if ((localObject instanceof JSONObject))
        {
          Class localClass = (Class)paramType;
          localArrayList.add(convertFromJSONObject((JSONObject)localObject, localClass));
        }
        else if ((localObject instanceof JSONArray))
        {
          localArrayList.add(convertFromJSONArray((JSONArray)localObject, ((ParameterizedType)paramType).getActualTypeArguments()[0]));
        }
        else
        {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  public static <T> T convertFromJSONObject(String paramString, Class<T> paramClass)
  {
    if ((isEmpty(paramString)) || (paramClass == null)) {
      return null;
    }
    try
    {
      paramString = convertFromJSONObject(new JSONObject(paramString), paramClass);
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static <T> T convertFromJSONObject(JSONObject paramJSONObject, Class<T> paramClass)
  {
    if ((paramJSONObject == null) || (paramClass == null)) {
      return null;
    }
    Object localObject2;
    Field[] arrayOfField;
    int j;
    int i;
    try
    {
      Object localObject1 = paramClass.newInstance();
      if (localObject1 == null) {
        return null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        localObject2 = null;
      }
      arrayOfField = paramClass.getDeclaredFields();
      if ((arrayOfField == null) || (arrayOfField.length == 0)) {
        return null;
      }
      j = arrayOfField.length;
      i = 0;
    }
    Field localField;
    if (i < j)
    {
      localField = arrayOfField[i];
      if (localField != null) {}
    }
    label194:
    for (;;)
    {
      i += 1;
      break;
      int k = localField.getModifiers();
      if ((!Modifier.isStatic(k)) || (!Modifier.isFinal(k)))
      {
        paramClass = localField.getName();
        Object localObject3 = (Alias)localField.getAnnotation(Alias.class);
        if (localObject3 != null) {
          paramClass = ((Alias)localObject3).value();
        }
        for (;;)
        {
          for (;;)
          {
            if ((isEmpty(paramClass)) || (!paramJSONObject.has(paramClass))) {
              break label194;
            }
            try
            {
              localObject3 = localField.getType().getSimpleName();
              localField.setAccessible(true);
              setField(paramJSONObject, localObject2, localField, paramClass, (String)localObject3);
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
    }
  }
  
  private static boolean isEmpty(String paramString)
  {
    return (paramString == null) || (paramString.length() <= 0);
  }
  
  private static boolean isPrimitiveType(Object paramObject)
  {
    return ((paramObject instanceof Integer)) || ((paramObject instanceof String)) || ((paramObject instanceof Boolean)) || ((paramObject instanceof Double)) || ((paramObject instanceof Float)) || ((paramObject instanceof Long)) || ((paramObject instanceof Byte)) || ((paramObject instanceof Character)) || ((paramObject instanceof Short));
  }
  
  private static void printLog(String paramString)
  {
    QMLog.d("JSONConverter", paramString);
  }
  
  private static <T> void setField(JSONObject paramJSONObject, T paramT, Field paramField, String paramString1, String paramString2)
  {
    if ("int".equals(paramString2))
    {
      paramField.set(paramT, Integer.valueOf(paramJSONObject.optInt(paramString1)));
      return;
    }
    if ("boolean".equals(paramString2))
    {
      paramField.set(paramT, Boolean.valueOf(paramJSONObject.optBoolean(paramString1)));
      return;
    }
    if ("long".equals(paramString2))
    {
      paramField.set(paramT, Long.valueOf(paramJSONObject.optLong(paramString1)));
      return;
    }
    if ("double".equals(paramString2))
    {
      paramField.set(paramT, Double.valueOf(paramJSONObject.optDouble(paramString1)));
      return;
    }
    if ("float".equals(paramString2))
    {
      paramField.set(paramT, Float.valueOf((float)paramJSONObject.optDouble(paramString1)));
      return;
    }
    if ("String".equals(paramString2))
    {
      paramField.set(paramT, paramJSONObject.optString(paramString1));
      return;
    }
    if ("Object".equals(paramString2))
    {
      paramField.set(paramT, new Object());
      return;
    }
    paramJSONObject = paramJSONObject.opt(paramString1);
    if ((paramJSONObject instanceof JSONObject)) {
      paramJSONObject = convertFromJSONObject((JSONObject)paramJSONObject, paramField.getType());
    }
    for (;;)
    {
      paramField.set(paramT, paramJSONObject);
      return;
      if ((paramJSONObject instanceof JSONArray))
      {
        paramString1 = (ParameterizedType)paramField.getGenericType();
        paramJSONObject = convertFromJSONArray((JSONArray)paramJSONObject, paramString1.getActualTypeArguments()[0]);
      }
      else
      {
        printLog("convertFromJSONObject unknown field " + paramString1);
        paramJSONObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.JSONConverter
 * JD-Core Version:    0.7.0.1
 */