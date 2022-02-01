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
          case 6: 
            continue;
            writeArrayField(paramJSONObject, paramT, localColumnInfo);
            break;
          case 5: 
            JSONObject localJSONObject = paramJSONObject.optJSONObject(localColumnInfo.key);
            if (localJSONObject == null) {
              break label224;
            }
            localColumnInfo.field.set(paramT, parseFrom(localJSONObject, localColumnInfo.field.getType()));
            break;
          case 0: 
          case 1: 
          case 2: 
          case 3: 
          case 4: 
            writePrimitiveField(localColumnInfo.type, paramJSONObject, localColumnInfo.key, localColumnInfo.field, paramT);
            break label224;
            paramJSONObject = new StringBuilder();
            paramJSONObject.append("un-support type : ");
            paramJSONObject.append(localColumnInfo.type);
            throw new JsonORM.JsonParseException(paramJSONObject.toString());
          }
        }
        catch (IllegalAccessException paramJSONObject)
        {
          paramArrayOfColumnInfo = new StringBuilder();
          paramArrayOfColumnInfo.append("access field failed : ");
          paramArrayOfColumnInfo.append(localColumnInfo.field.getName());
          throw new JsonORM.JsonParseException(paramArrayOfColumnInfo.toString(), paramJSONObject);
        }
        return;
      }
      label224:
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
  
  public static <T> T parseFrom(JSONObject paramJSONObject, Class<T> paramClass)
  {
    if ((paramJSONObject != null) && (paramClass != null))
    {
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
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("create class instance failed : ");
        ((StringBuilder)localObject1).append(paramClass.getName());
        throw new JsonORM.JsonParseException(((StringBuilder)localObject1).toString(), paramJSONObject);
      }
    }
    throw new IllegalArgumentException("both jsonObject and clazz should not be null");
  }
  
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
  
  private static <T> void writeArrayField(JSONObject paramJSONObject, T paramT, JsonORM.ColumnInfo paramColumnInfo)
  {
    paramJSONObject = paramJSONObject.optJSONArray(paramColumnInfo.key);
    if (paramJSONObject != null)
    {
      Class localClass = paramColumnInfo.field.getType().getComponentType();
      int i = getColumnInfoType(localClass);
      if ((i != 0) && (i != 1) && (i != 2) && (i != 3) && (i != 4))
      {
        paramColumnInfo.field.set(paramT, parseFrom(paramJSONObject, localClass));
        return;
      }
      writePrimitiveArrayField(i, paramJSONObject, paramColumnInfo.field, paramT);
    }
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
              writeDoubleField(paramJSONArray, paramField, paramObject, i);
              return;
            }
            paramJSONArray = new StringBuilder();
            paramJSONArray.append("un-support array field type : ");
            paramJSONArray.append(paramInt);
            throw new JsonORM.JsonParseException(paramJSONArray.toString());
          }
          writeLongField(paramJSONArray, paramField, paramObject, i);
          return;
        }
        writeIntField(paramJSONArray, paramField, paramObject, i);
        return;
      }
      writeBooleanField(paramJSONArray, paramField, paramObject, i);
      return;
    }
    writeStringField(paramJSONArray, paramField, paramObject, i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.annotation.JsonORM
 * JD-Core Version:    0.7.0.1
 */