package com.tencent.mobileqq.mini.sdk;

import android.support.annotation.NonNull;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonORM
{
  public static final int TYPE_ARRAY = 6;
  public static final int TYPE_BOOLEAN = 1;
  public static final int TYPE_DOUBLE = 4;
  public static final int TYPE_INT = 2;
  public static final int TYPE_LONG = 3;
  public static final int TYPE_OBJECT = 5;
  public static final int TYPE_STRING = 0;
  private static final Map<Class, JsonORM.ColumnInfo[]> sColumnInfoMap = new IdentityHashMap();
  
  public static int getColumnInfoType(Class<?> paramClass)
  {
    if (paramClass == String.class) {
      return 0;
    }
    if (paramClass == Boolean.TYPE) {
      return 1;
    }
    if (paramClass == Integer.TYPE) {
      return 2;
    }
    if (paramClass == Long.TYPE) {
      return 3;
    }
    if (paramClass == Double.TYPE) {
      return 4;
    }
    if (paramClass.isArray()) {
      return 6;
    }
    if (!paramClass.isPrimitive()) {
      return 5;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("un-support primitive field : ");
    localStringBuilder.append(paramClass);
    throw new JsonORM.JsonParseException(localStringBuilder.toString());
  }
  
  private static void parseColumnInfo(Class<?> paramClass, ArrayList<JsonORM.ColumnInfo> paramArrayList)
  {
    paramClass = paramClass.getDeclaredFields();
    int i = 0;
    while (i != paramClass.length)
    {
      Field localField = paramClass[i];
      JsonORM.Column localColumn = (JsonORM.Column)localField.getAnnotation(JsonORM.Column.class);
      if (localColumn != null) {
        paramArrayList.add(new JsonORM.ColumnInfo(localColumn.key(), getColumnInfoType(localField.getType()), localField));
      }
      i += 1;
    }
  }
  
  private static JsonORM.ColumnInfo[] parseColumnInfo(Class<?> paramClass)
  {
    ArrayList localArrayList = new ArrayList();
    while (paramClass != null)
    {
      parseColumnInfo(paramClass, localArrayList);
      paramClass = paramClass.getSuperclass();
    }
    paramClass = new JsonORM.ColumnInfo[localArrayList.size()];
    localArrayList.toArray(paramClass);
    return paramClass;
  }
  
  @NonNull
  public static <T> T parseFrom(JSONObject paramJSONObject, Class<T> paramClass)
  {
    Object localObject2;
    Object localObject1;
    if ((paramJSONObject != null) && (paramClass != null))
    {
      localObject2 = (JsonORM.ColumnInfo[])sColumnInfoMap.get(paramClass);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = parseColumnInfo(paramClass);
        sColumnInfoMap.put(paramClass, localObject1);
      }
    }
    for (;;)
    {
      int i;
      try
      {
        localObject2 = paramClass.newInstance();
        int j = localObject1.length;
        i = 0;
        if (i < j)
        {
          paramClass = localObject1[i];
          try
          {
            Object localObject3;
            switch (paramClass.type)
            {
            case 6: 
              continue;
              localObject3 = paramJSONObject.optJSONArray(paramClass.key);
              if (localObject3 == null) {
                break label424;
              }
              Class localClass = paramClass.field.getType().getComponentType();
              int k = getColumnInfoType(localClass);
              if ((k != 0) && (k != 1) && (k != 2) && (k != 3) && (k != 4)) {
                paramClass.field.set(localObject2, parseFrom((JSONArray)localObject3, localClass));
              } else {
                writePrimitiveArrayField(k, (JSONArray)localObject3, paramClass.field, localObject2);
              }
              break;
            case 5: 
              localObject3 = paramJSONObject.optJSONObject(paramClass.key);
              if (localObject3 == null) {
                break label424;
              }
              paramClass.field.set(localObject2, parseFrom((JSONObject)localObject3, paramClass.field.getType()));
              break;
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
              writePrimitiveField(paramClass.type, paramJSONObject, paramClass.key, paramClass.field, localObject2);
              break label424;
              paramJSONObject = new StringBuilder();
              paramJSONObject.append("un-support type : ");
              paramJSONObject.append(paramClass.type);
              throw new JsonORM.JsonParseException(paramJSONObject.toString());
            }
          }
          catch (IllegalAccessException paramJSONObject)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("access field failed : ");
            ((StringBuilder)localObject1).append(paramClass.field.getName());
            throw new JsonORM.JsonParseException(((StringBuilder)localObject1).toString(), paramJSONObject);
          }
        }
        return localObject2;
      }
      catch (Exception paramJSONObject)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("create class instance failed : ");
        ((StringBuilder)localObject1).append(paramClass.getName());
        throw new JsonORM.JsonParseException(((StringBuilder)localObject1).toString(), paramJSONObject);
      }
      paramJSONObject = new IllegalArgumentException("both jsonObject and clazz should not be null");
      for (;;)
      {
        throw paramJSONObject;
      }
      continue;
      label424:
      i += 1;
    }
  }
  
  @NonNull
  public static <T> T[] parseFrom(JSONArray paramJSONArray, Class<T> paramClass)
  {
    if ((paramJSONArray != null) && (paramClass != null))
    {
      if (!paramClass.isPrimitive())
      {
        int j = paramJSONArray.length();
        Object[] arrayOfObject = (Object[])Array.newInstance(paramClass, j);
        int i = 0;
        while (i < j)
        {
          JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
          if (localJSONObject != null) {
            arrayOfObject[i] = parseFrom(localJSONObject, paramClass);
          } else {
            arrayOfObject[i] = null;
          }
          i += 1;
        }
        return arrayOfObject;
      }
      paramJSONArray = new StringBuilder();
      paramJSONArray.append("do not support primitive array field : ");
      paramJSONArray.append(paramClass);
      throw new JsonORM.JsonParseException(paramJSONArray.toString());
    }
    paramJSONArray = new IllegalArgumentException("both jsonArray and clazz should not be null");
    for (;;)
    {
      throw paramJSONArray;
    }
  }
  
  public static JSONObject toJSON(Object paramObject)
  {
    if (paramObject != null)
    {
      Class localClass = paramObject.getClass();
      Object localObject2 = (JsonORM.ColumnInfo[])sColumnInfoMap.get(localClass);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = parseColumnInfo(localClass);
        sColumnInfoMap.put(localClass, localObject1);
      }
      localObject2 = new JSONObject();
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        localClass = localObject1[i];
        try
        {
          int k = localClass.type;
          Object localObject3;
          if (k != 0)
          {
            if (k != 1)
            {
              if (k != 2)
              {
                if (k != 3)
                {
                  if (k != 4)
                  {
                    if (k == 5)
                    {
                      localObject3 = localClass.field.get(paramObject);
                      if (localObject3 != null) {
                        ((JSONObject)localObject2).put(localClass.key, toJSON(localObject3));
                      }
                    }
                  }
                  else {
                    ((JSONObject)localObject2).put(localClass.key, localClass.field.getDouble(paramObject));
                  }
                }
                else {
                  ((JSONObject)localObject2).put(localClass.key, localClass.field.getLong(paramObject));
                }
              }
              else {
                ((JSONObject)localObject2).put(localClass.key, localClass.field.getInt(paramObject));
              }
            }
            else {
              ((JSONObject)localObject2).put(localClass.key, localClass.field.getBoolean(paramObject));
            }
          }
          else
          {
            localObject3 = localClass.field.get(paramObject);
            if (localObject3 != null) {
              ((JSONObject)localObject2).put(localClass.key, localObject3);
            }
          }
          i += 1;
        }
        catch (JSONException paramObject)
        {
          throw new JsonORM.JsonParseException("operate json object error", paramObject);
        }
        catch (IllegalAccessException paramObject)
        {
          throw new JsonORM.JsonParseException("access field failed", paramObject);
        }
      }
      return localObject2;
    }
    paramObject = new IllegalArgumentException("object should not be null");
    for (;;)
    {
      throw paramObject;
    }
  }
  
  private static void writePrimitiveArrayField(int paramInt, JSONArray paramJSONArray, Field paramField, Object paramObject)
  {
    int i1 = paramJSONArray.length();
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i = 0;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt == 4)
            {
              localObject = new double[i1];
              paramInt = i;
              while (paramInt < i1)
              {
                localObject[paramInt] = paramJSONArray.optDouble(paramInt);
                paramInt += 1;
              }
              paramField.set(paramObject, localObject);
              return;
            }
            paramJSONArray = new StringBuilder();
            paramJSONArray.append("un-support array field type : ");
            paramJSONArray.append(paramInt);
            throw new JsonORM.JsonParseException(paramJSONArray.toString());
          }
          localObject = new long[i1];
          paramInt = j;
          while (paramInt < i1)
          {
            localObject[paramInt] = paramJSONArray.optLong(paramInt);
            paramInt += 1;
          }
          paramField.set(paramObject, localObject);
          return;
        }
        localObject = new int[i1];
        paramInt = k;
        while (paramInt < i1)
        {
          localObject[paramInt] = paramJSONArray.optInt(paramInt);
          paramInt += 1;
        }
        paramField.set(paramObject, localObject);
        return;
      }
      localObject = new boolean[i1];
      paramInt = m;
      while (paramInt < i1)
      {
        localObject[paramInt] = paramJSONArray.optBoolean(paramInt);
        paramInt += 1;
      }
      paramField.set(paramObject, localObject);
      return;
    }
    Object localObject = new String[i1];
    paramInt = n;
    while (paramInt < i1)
    {
      localObject[paramInt] = paramJSONArray.optString(paramInt);
      paramInt += 1;
    }
    paramField.set(paramObject, localObject);
  }
  
  private static void writePrimitiveField(int paramInt, JSONObject paramJSONObject, String paramString, Field paramField, Object paramObject)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt == 4)
            {
              paramField.set(paramObject, Double.valueOf(paramJSONObject.optDouble(paramString)));
              return;
            }
            paramJSONObject = new StringBuilder();
            paramJSONObject.append("un-support field type : ");
            paramJSONObject.append(paramInt);
            throw new JsonORM.JsonParseException(paramJSONObject.toString());
          }
          paramField.set(paramObject, Long.valueOf(paramJSONObject.optLong(paramString)));
          return;
        }
        paramField.set(paramObject, Integer.valueOf(paramJSONObject.optInt(paramString)));
        return;
      }
      paramField.set(paramObject, Boolean.valueOf(paramJSONObject.optBoolean(paramString)));
      return;
    }
    paramField.set(paramObject, paramJSONObject.optString(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.sdk.JsonORM
 * JD-Core Version:    0.7.0.1
 */