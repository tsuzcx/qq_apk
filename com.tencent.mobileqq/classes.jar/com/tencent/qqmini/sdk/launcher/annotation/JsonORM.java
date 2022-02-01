package com.tencent.qqmini.sdk.launcher.annotation;

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
  
  private static <T> void doParse(JSONObject paramJSONObject, JsonORM.ColumnInfo[] paramArrayOfColumnInfo, T paramT)
  {
    int j = paramArrayOfColumnInfo.length;
    int i = 0;
    for (;;)
    {
      JsonORM.ColumnInfo localColumnInfo;
      if (i < j) {
        localColumnInfo = paramArrayOfColumnInfo[i];
      }
      for (;;)
      {
        try
        {
          switch (localColumnInfo.type)
          {
          case 0: 
            throw new JsonORM.JsonParseException("un-support type : " + localColumnInfo.type);
          }
        }
        catch (IllegalAccessException paramJSONObject)
        {
          throw new JsonORM.JsonParseException("access field failed : " + localColumnInfo.field.getName(), paramJSONObject);
        }
        writePrimitiveField(localColumnInfo.type, paramJSONObject, localColumnInfo.key, localColumnInfo.field, paramT);
        break;
        writeArrayField(paramJSONObject, paramT, localColumnInfo);
        break;
        JSONObject localJSONObject = paramJSONObject.optJSONObject(localColumnInfo.key);
        if (localJSONObject == null) {
          break;
        }
        localColumnInfo.field.set(paramT, parseFrom(localJSONObject, localColumnInfo.field.getType()));
        break;
        return;
      }
      i += 1;
    }
  }
  
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
    try
    {
      localObject2 = paramClass.newInstance();
      doParse(paramJSONObject, (JsonORM.ColumnInfo[])localObject1, localObject2);
      return localObject2;
    }
    catch (Exception paramJSONObject)
    {
      throw new JsonORM.JsonParseException("create class instance failed : " + paramClass.getName(), paramJSONObject);
    }
  }
  
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
        break label315;
        ((JSONObject)localObject2).put(localClass.key, localClass.field.getDouble(paramObject));
        break label315;
        Object localObject3 = localClass.field.get(paramObject);
        if (localObject3 != null)
        {
          ((JSONObject)localObject2).put(localClass.key, localObject3);
          break label315;
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
      label315:
      i += 1;
    }
  }
  
  private static <T> void writeArrayField(JSONObject paramJSONObject, T paramT, JsonORM.ColumnInfo paramColumnInfo)
  {
    paramJSONObject = paramJSONObject.optJSONArray(paramColumnInfo.key);
    Class localClass;
    int i;
    if (paramJSONObject != null)
    {
      localClass = paramColumnInfo.field.getType().getComponentType();
      i = getColumnInfoType(localClass);
    }
    switch (i)
    {
    default: 
      paramColumnInfo.field.set(paramT, parseFrom(paramJSONObject, localClass));
      return;
    }
    writePrimitiveArrayField(i, paramJSONObject, paramColumnInfo.field, paramT);
  }
  
  private static void writeBooleanField(JSONArray paramJSONArray, Field paramField, Object paramObject, int paramInt)
  {
    boolean[] arrayOfBoolean = new boolean[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfBoolean[i] = paramJSONArray.optBoolean(i);
      i += 1;
    }
    paramField.set(paramObject, arrayOfBoolean);
  }
  
  private static void writeDoubleField(JSONArray paramJSONArray, Field paramField, Object paramObject, int paramInt)
  {
    double[] arrayOfDouble = new double[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfDouble[i] = paramJSONArray.optDouble(i);
      i += 1;
    }
    paramField.set(paramObject, arrayOfDouble);
  }
  
  private static void writeIntField(JSONArray paramJSONArray, Field paramField, Object paramObject, int paramInt)
  {
    int[] arrayOfInt = new int[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfInt[i] = paramJSONArray.optInt(i);
      i += 1;
    }
    paramField.set(paramObject, arrayOfInt);
  }
  
  private static void writeLongField(JSONArray paramJSONArray, Field paramField, Object paramObject, int paramInt)
  {
    long[] arrayOfLong = new long[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfLong[i] = paramJSONArray.optLong(i);
      i += 1;
    }
    paramField.set(paramObject, arrayOfLong);
  }
  
  private static void writePrimitiveArrayField(int paramInt, JSONArray paramJSONArray, Field paramField, Object paramObject)
  {
    int i = paramJSONArray.length();
    switch (paramInt)
    {
    default: 
      throw new JsonORM.JsonParseException("un-support array field type : " + paramInt);
    case 1: 
      writeBooleanField(paramJSONArray, paramField, paramObject, i);
      return;
    case 2: 
      writeIntField(paramJSONArray, paramField, paramObject, i);
      return;
    case 3: 
      writeLongField(paramJSONArray, paramField, paramObject, i);
      return;
    case 4: 
      writeDoubleField(paramJSONArray, paramField, paramObject, i);
      return;
    }
    writeStringField(paramJSONArray, paramField, paramObject, i);
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
  
  private static void writeStringField(JSONArray paramJSONArray, Field paramField, Object paramObject, int paramInt)
  {
    String[] arrayOfString = new String[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfString[i] = paramJSONArray.optString(i);
      i += 1;
    }
    paramField.set(paramObject, arrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.annotation.JsonORM
 * JD-Core Version:    0.7.0.1
 */