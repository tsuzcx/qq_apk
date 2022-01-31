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
    if (paramClass.isPrimitive()) {
      throw new JsonORM.JsonParseException("un-support primitive field : " + paramClass);
    }
    return 5;
  }
  
  private static void parseColumnInfo(Class<?> paramClass, ArrayList<JsonORM.ColumnInfo> paramArrayList)
  {
    paramClass = paramClass.getDeclaredFields();
    int i = 0;
    if (i != paramClass.length)
    {
      Field localField = paramClass[i];
      JsonORM.Column localColumn = (JsonORM.Column)localField.getAnnotation(JsonORM.Column.class);
      if (localColumn == null) {}
      for (;;)
      {
        i += 1;
        break;
        paramArrayList.add(new JsonORM.ColumnInfo(localColumn.key(), getColumnInfoType(localField.getType()), localField));
      }
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
    if ((paramJSONObject == null) || (paramClass == null)) {
      throw new IllegalArgumentException("both jsonObject and clazz should not be null");
    }
    Object localObject2 = (JsonORM.ColumnInfo[])sColumnInfoMap.get(paramClass);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = parseColumnInfo(paramClass);
      sColumnInfoMap.put(paramClass, localObject1);
    }
    int i;
    try
    {
      localObject2 = paramClass.newInstance();
      int j = localObject1.length;
      i = 0;
      if (i >= j) {
        break label390;
      }
      paramClass = localObject1[i];
      try
      {
        switch (paramClass.type)
        {
        case 0: 
          label128:
          throw new JsonORM.JsonParseException("un-support type : " + paramClass.type);
        }
      }
      catch (IllegalAccessException paramJSONObject)
      {
        throw new JsonORM.JsonParseException("access field failed : " + paramClass.field.getName(), paramJSONObject);
      }
      writePrimitiveField(paramClass.type, paramJSONObject, paramClass.key, paramClass.field, localObject2);
    }
    catch (Exception paramJSONObject)
    {
      throw new JsonORM.JsonParseException("create class instance failed : " + paramClass.getName(), paramJSONObject);
    }
    break label396;
    Object localObject3 = paramJSONObject.optJSONArray(paramClass.key);
    Class localClass;
    int k;
    if (localObject3 != null)
    {
      localClass = paramClass.field.getType().getComponentType();
      k = getColumnInfoType(localClass);
      switch (k)
      {
      }
    }
    for (;;)
    {
      paramClass.field.set(localObject2, parseFrom((JSONArray)localObject3, localClass));
      break label396;
      writePrimitiveArrayField(k, (JSONArray)localObject3, paramClass.field, localObject2);
      break label396;
      localObject3 = paramJSONObject.optJSONObject(paramClass.key);
      if (localObject3 != null)
      {
        paramClass.field.set(localObject2, parseFrom((JSONObject)localObject3, paramClass.field.getType()));
        break label396;
        label390:
        return localObject2;
        break label128;
      }
      label396:
      i += 1;
      break;
    }
  }
  
  @NonNull
  public static <T> T[] parseFrom(JSONArray paramJSONArray, Class<T> paramClass)
  {
    if ((paramJSONArray == null) || (paramClass == null)) {
      throw new IllegalArgumentException("both jsonArray and clazz should not be null");
    }
    if (paramClass.isPrimitive()) {
      throw new JsonORM.JsonParseException("do not support primitive array field : " + paramClass);
    }
    int j = paramJSONArray.length();
    Object[] arrayOfObject = (Object[])Array.newInstance(paramClass, j);
    int i = 0;
    if (i < j)
    {
      JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
      if (localJSONObject != null) {
        arrayOfObject[i] = parseFrom(localJSONObject, paramClass);
      }
      for (;;)
      {
        i += 1;
        break;
        arrayOfObject[i] = null;
      }
    }
    return arrayOfObject;
  }
  
  public static JSONObject toJSON(Object paramObject)
  {
    if (paramObject == null) {
      throw new IllegalArgumentException("object should not be null");
    }
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
    for (;;)
    {
      if (i < j)
      {
        localClass = localObject1[i];
        try
        {
          switch (localClass.type)
          {
          case 1: 
            ((JSONObject)localObject2).put(localClass.key, localClass.field.getBoolean(paramObject));
          }
        }
        catch (IllegalAccessException paramObject)
        {
          throw new JsonORM.JsonParseException("access field failed", paramObject);
          ((JSONObject)localObject2).put(localClass.key, localClass.field.getInt(paramObject));
        }
        catch (JSONException paramObject)
        {
          throw new JsonORM.JsonParseException("operate json object error", paramObject);
        }
        ((JSONObject)localObject2).put(localClass.key, localClass.field.getLong(paramObject));
        break label316;
        ((JSONObject)localObject2).put(localClass.key, localClass.field.getDouble(paramObject));
        break label316;
        Object localObject3 = localClass.field.get(paramObject);
        if (localObject3 != null)
        {
          ((JSONObject)localObject2).put(localClass.key, localObject3);
          break label316;
          localObject3 = localClass.field.get(paramObject);
          if (localObject3 != null) {
            ((JSONObject)localObject2).put(localClass.key, toJSON(localObject3));
          }
        }
      }
      else
      {
        return localObject2;
      }
      label316:
      i += 1;
    }
  }
  
  private static void writePrimitiveArrayField(int paramInt, JSONArray paramJSONArray, Field paramField, Object paramObject)
  {
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i = 0;
    int i1 = paramJSONArray.length();
    switch (paramInt)
    {
    default: 
      throw new JsonORM.JsonParseException("un-support array field type : " + paramInt);
    case 1: 
      localObject = new boolean[i1];
      paramInt = i;
      while (paramInt < i1)
      {
        localObject[paramInt] = paramJSONArray.optBoolean(paramInt);
        paramInt += 1;
      }
      paramField.set(paramObject, localObject);
      return;
    case 2: 
      localObject = new int[i1];
      paramInt = j;
      while (paramInt < i1)
      {
        localObject[paramInt] = paramJSONArray.optInt(paramInt);
        paramInt += 1;
      }
      paramField.set(paramObject, localObject);
      return;
    case 3: 
      localObject = new long[i1];
      paramInt = k;
      while (paramInt < i1)
      {
        localObject[paramInt] = paramJSONArray.optLong(paramInt);
        paramInt += 1;
      }
      paramField.set(paramObject, localObject);
      return;
    case 4: 
      localObject = new double[i1];
      paramInt = m;
      while (paramInt < i1)
      {
        localObject[paramInt] = paramJSONArray.optDouble(paramInt);
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
    switch (paramInt)
    {
    default: 
      throw new JsonORM.JsonParseException("un-support field type : " + paramInt);
    case 1: 
      paramField.set(paramObject, Boolean.valueOf(paramJSONObject.optBoolean(paramString)));
      return;
    case 2: 
      paramField.set(paramObject, Integer.valueOf(paramJSONObject.optInt(paramString)));
      return;
    case 3: 
      paramField.set(paramObject, Long.valueOf(paramJSONObject.optLong(paramString)));
      return;
    case 4: 
      paramField.set(paramObject, Double.valueOf(paramJSONObject.optDouble(paramString)));
      return;
    }
    paramField.set(paramObject, paramJSONObject.optString(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.sdk.JsonORM
 * JD-Core Version:    0.7.0.1
 */