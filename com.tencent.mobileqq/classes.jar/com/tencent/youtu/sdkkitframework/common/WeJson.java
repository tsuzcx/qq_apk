package com.tencent.youtu.sdkkitframework.common;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeJson
{
  private static final String EMPTY_ARR = "[]";
  private static final String EMPTY_MAP = "{}";
  
  private <T> T fromArr(JSONArray paramJSONArray, Class<T> paramClass)
  {
    paramClass = paramClass.getComponentType();
    Object localObject = Array.newInstance(paramClass, paramJSONArray.length());
    int i = 0;
    while (i < paramJSONArray.length())
    {
      Array.set(localObject, i, fromJsonData(getObject(paramJSONArray, i), paramClass, paramClass));
      i += 1;
    }
    return localObject;
  }
  
  private <T> T fromJsonArr(JSONArray paramJSONArray, Class<T> paramClass, Class<?> paramClass1)
  {
    if (paramClass.equals(List.class)) {
      return fromList(paramJSONArray, paramClass, paramClass1);
    }
    if (paramClass.isArray()) {
      return fromArr(paramJSONArray, paramClass);
    }
    paramJSONArray = new StringBuilder();
    paramJSONArray.append("json 解析错误:不支持的类型:");
    paramJSONArray.append(paramClass.getName());
    throw new WeJsonException(paramJSONArray.toString());
  }
  
  private Object fromJsonData(Object paramObject, Class<?> paramClass1, Class<?> paramClass2)
  {
    if ((paramObject instanceof JSONArray)) {
      return fromJsonArr((JSONArray)paramObject, paramClass1, paramClass2);
    }
    Object localObject = paramObject;
    if ((paramObject instanceof JSONObject)) {
      localObject = fromJsonObj((JSONObject)paramObject, paramClass1, paramClass2);
    }
    return localObject;
  }
  
  private <T> T fromJsonObj(JSONObject paramJSONObject, Class<T> paramClass, Class<?> paramClass1)
  {
    if (paramClass.equals(Map.class)) {
      return fromMap(paramJSONObject, paramClass, paramClass1);
    }
    return fromPojo(paramJSONObject, paramClass);
  }
  
  private List fromList(JSONArray paramJSONArray, Class<List> paramClass, Class<?> paramClass1)
  {
    if (paramClass1 != null)
    {
      Object localObject1;
      if (paramClass.getName().equals("java.util.List")) {
        localObject1 = new ArrayList();
      }
      try
      {
        localObject1 = (List)paramClass.newInstance();
        int i = 0;
        while (i < paramJSONArray.length())
        {
          Object localObject2 = getObject(paramJSONArray, i);
          if ((localObject2 instanceof JSONArray)) {
            ((List)localObject1).add(fromJsonArr((JSONArray)localObject2, paramClass, paramClass1));
          } else if ((localObject2 instanceof JSONObject)) {
            ((List)localObject1).add(fromJsonObj((JSONObject)localObject2, paramClass, paramClass1));
          } else {
            ((List)localObject1).add(localObject2);
          }
          i += 1;
        }
        return localObject1;
      }
      catch (Exception paramJSONArray)
      {
        throw new WeJsonException("创建List类型失败,该列表不支持无参实例化", paramJSONArray);
      }
    }
    paramJSONArray = new WeJsonException("无法确定列表项的类型");
    for (;;)
    {
      throw paramJSONArray;
    }
  }
  
  private Map fromMap(JSONObject paramJSONObject, Class<Map> paramClass, Class<?> paramClass1)
  {
    if (paramClass1 != null)
    {
      Object localObject1;
      if (paramClass.getName().equals("java.util.Map")) {
        localObject1 = new HashMap();
      }
      try
      {
        localObject1 = (Map)paramClass.newInstance();
        Iterator localIterator = paramJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          Object localObject2 = getObject(paramJSONObject, str);
          if (localObject2 != null) {
            ((Map)localObject1).put(str, fromJsonData(localObject2, paramClass, paramClass1));
          } else {
            ((Map)localObject1).put(str, null);
          }
        }
        return localObject1;
      }
      catch (Exception paramJSONObject)
      {
        throw new WeJsonException("创建Map类型失败,该Map不支持无参实例化", paramJSONObject);
      }
    }
    paramJSONObject = new WeJsonException("无法确定列表项的类型");
    for (;;)
    {
      throw paramJSONObject;
    }
  }
  
  private <T> T fromPojo(JSONObject paramJSONObject, Class<T> paramClass)
  {
    Object localObject2 = paramClass.getDeclaredFields();
    Object localObject3 = paramClass.getSuperclass();
    Object localObject1 = new Field[0];
    if (localObject3 != null) {
      localObject1 = ((Class)localObject3).getDeclaredFields();
    }
    localObject3 = new Field[localObject2.length + localObject1.length];
    int i = 0;
    while (i < localObject2.length)
    {
      localObject3[i] = localObject2[i];
      i += 1;
    }
    i = localObject2.length;
    while (i < localObject3.length)
    {
      localObject3[i] = localObject1[(i - localObject2.length)];
      i += 1;
    }
    if (localObject3.length == 0) {
      return null;
    }
    try
    {
      Object localObject4 = paramClass.newInstance();
      i = 0;
      while (i < localObject3.length)
      {
        Object localObject5 = localObject3[i];
        String str = ((Field)localObject5).getName();
        if (!str.contains("$"))
        {
          int j = ((Field)localObject5).getModifiers();
          localObject1 = paramJSONObject.opt(str);
          if (localObject1 != null)
          {
            localObject2 = fromJsonData(localObject1, getMemberType(paramClass, (Field)localObject5), getSubType(paramClass, (Field)localObject5, localObject1));
            localObject1 = localObject2;
            if (JSONObject.NULL.equals(localObject2)) {
              localObject1 = null;
            }
            if ((j & 0x1) != 0)
            {
              try
              {
                ((Field)localObject5).set(localObject4, localObject1);
              }
              catch (IllegalAccessException paramJSONObject)
              {
                throw new WeJsonException("设置成员变量值失败.", paramJSONObject);
              }
            }
            else
            {
              StringBuilder localStringBuilder2 = new StringBuilder();
              localStringBuilder2.append("set");
              localStringBuilder2.append(str.substring(0, 1).toUpperCase());
              if (str.length() == 1) {
                localObject2 = "";
              } else {
                localObject2 = str.substring(1);
              }
              localStringBuilder2.append((String)localObject2);
              localObject2 = localStringBuilder2.toString();
              localObject5 = ((Field)localObject5).getType();
              try
              {
                localObject2 = paramClass.getMethod((String)localObject2, new Class[] { localObject5 });
                try
                {
                  ((Method)localObject2).invoke(localObject4, new Object[] { localObject1 });
                }
                catch (Exception paramJSONObject)
                {
                  throw new WeJsonException("调用set方法失败.", paramJSONObject);
                }
                i += 1;
              }
              catch (NoSuchMethodException localNoSuchMethodException)
              {
                localNoSuchMethodException.printStackTrace();
              }
            }
          }
        }
      }
      return localObject4;
    }
    catch (Exception paramJSONObject)
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("必须为该类型提供一个无参构造方法:");
      localStringBuilder1.append(paramClass.getName());
      paramJSONObject = new WeJsonException(localStringBuilder1.toString(), paramJSONObject);
    }
    for (;;)
    {
      throw paramJSONObject;
    }
  }
  
  private <T> Class<?> getMemberType(Class<T> paramClass, Field paramField)
  {
    if ((paramField.getGenericType() instanceof TypeVariable))
    {
      paramClass.getTypeParameters();
      paramField = paramClass.getGenericSuperclass();
      if ((paramField instanceof ParameterizedType))
      {
        paramClass = ((ParameterizedType)paramField).getActualTypeArguments()[0];
        if ((paramClass instanceof Class)) {
          return (Class)paramClass;
        }
        throw new WeJsonException("不支持嵌套泛型");
      }
      paramField = new StringBuilder();
      paramField.append("缺少泛型信息:");
      paramField.append(paramClass);
      throw new WeJsonException(paramField.toString());
    }
    return paramField.getType();
  }
  
  private Object getObject(JSONArray paramJSONArray, int paramInt)
  {
    try
    {
      paramJSONArray = paramJSONArray.get(paramInt);
      return paramJSONArray;
    }
    catch (JSONException paramJSONArray)
    {
      throw new WeJsonException("JSONArray.get() cause JSONException", paramJSONArray);
    }
  }
  
  private Object getObject(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      paramJSONObject = paramJSONObject.get(paramString);
      return paramJSONObject;
    }
    catch (JSONException paramJSONObject)
    {
      throw new WeJsonException("JSONObject.get() cause JSONException", paramJSONObject);
    }
  }
  
  private <T> Class<?> getSubType(Class<T> paramClass, Field paramField, Object paramObject)
  {
    if ((paramField.getGenericType() instanceof TypeVariable))
    {
      paramClass.getTypeParameters();
      paramField = paramClass.getGenericSuperclass();
      if ((paramField instanceof ParameterizedType))
      {
        paramClass = ((ParameterizedType)paramField).getActualTypeArguments()[0];
        if ((paramClass instanceof Class)) {
          return (Class)paramClass;
        }
        throw new WeJsonException("不支持嵌套泛型");
      }
      paramField = new StringBuilder();
      paramField.append("缺少泛型信息:");
      paramField.append(paramClass);
      throw new WeJsonException(paramField.toString());
    }
    if (paramField.getType().equals(List.class))
    {
      paramClass = paramField.getGenericType();
      if ((paramClass instanceof ParameterizedType))
      {
        paramClass = ((ParameterizedType)paramClass).getActualTypeArguments()[0];
        if ((paramClass instanceof Class)) {
          return (Class)paramClass;
        }
        paramClass = new StringBuilder();
        paramClass.append("不支持嵌套泛型:");
        paramClass.append(paramField.getName());
        throw new WeJsonException(paramClass.toString());
      }
      paramClass = new StringBuilder();
      paramClass.append("缺少泛型类型声明:");
      paramClass.append(paramField.getName());
      throw new WeJsonException(paramClass.toString());
    }
    if (paramField.getType().equals(Map.class))
    {
      paramClass = paramField.getGenericType();
      if ((paramClass instanceof ParameterizedType))
      {
        paramClass = ((ParameterizedType)paramClass).getActualTypeArguments()[1];
        if ((paramClass instanceof Class)) {
          return (Class)paramClass;
        }
        paramClass = new StringBuilder();
        paramClass.append("不支持嵌套泛型:");
        paramClass.append(paramField.getName());
        throw new WeJsonException(paramClass.toString());
      }
      paramClass = new StringBuilder();
      paramClass.append("缺少泛型类型声明:");
      paramClass.append(paramField.getName());
      throw new WeJsonException(paramClass.toString());
    }
    return paramField.getType();
  }
  
  private String getValidStr(String paramString)
  {
    return paramString.replace("\"", "\\\"").replace("\\", "\\\\").replace("\b", "\\b").replace("\n", "\\n").replace("\r", "\\r").replace("\f", "\\f").replace("\t", "\\t");
  }
  
  private <T> boolean isPrimitivePackageType(T paramT)
  {
    return ((paramT instanceof Integer)) || ((paramT instanceof Short)) || ((paramT instanceof Long)) || ((paramT instanceof Byte)) || ((paramT instanceof Boolean)) || ((paramT instanceof Float)) || ((paramT instanceof Double)) || ((paramT instanceof Character));
  }
  
  private <T> void process(StringBuilder paramStringBuilder, T paramT)
  {
    if (paramT.getClass().isPrimitive())
    {
      paramStringBuilder.append(paramT);
      return;
    }
    if ((paramT instanceof String))
    {
      paramStringBuilder.append('"');
      paramStringBuilder.append(getValidStr((String)paramT));
      paramStringBuilder.append('"');
      return;
    }
    if (isPrimitivePackageType(paramT))
    {
      paramStringBuilder.append(paramT);
      return;
    }
    if (paramT.getClass().isArray())
    {
      processArr(paramStringBuilder, (Object[])paramT);
      return;
    }
    if ((paramT instanceof Iterable))
    {
      processIterable(paramStringBuilder, (Iterable)paramT);
      return;
    }
    if ((paramT instanceof Map))
    {
      processMap(paramStringBuilder, (Map)paramT);
      return;
    }
    processObj(paramStringBuilder, paramT);
  }
  
  private <T> void processArr(StringBuilder paramStringBuilder, Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject.length == 0)
    {
      paramStringBuilder.append("[]");
      return;
    }
    paramStringBuilder.append('[');
    int i = 0;
    while (i < paramArrayOfObject.length)
    {
      process(paramStringBuilder, paramArrayOfObject[i]);
      if (i < paramArrayOfObject.length - 1) {
        paramStringBuilder.append(',');
      }
      i += 1;
    }
    paramStringBuilder.append(']');
  }
  
  private void processIterable(StringBuilder paramStringBuilder, Iterable paramIterable)
  {
    paramIterable = paramIterable.iterator();
    paramStringBuilder.append('[');
    int i = 0;
    while (paramIterable.hasNext())
    {
      i += 1;
      process(paramStringBuilder, paramIterable.next());
      paramStringBuilder.append(',');
    }
    if (i > 0) {
      paramStringBuilder.deleteCharAt(paramStringBuilder.length() - 1);
    }
    paramStringBuilder.append(']');
  }
  
  private void processMap(StringBuilder paramStringBuilder, Map<String, Object> paramMap)
  {
    if (paramMap.size() == 0)
    {
      paramStringBuilder.append("{}");
      return;
    }
    paramStringBuilder.append('{');
    int i = 0;
    int j = paramMap.size();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      Object localObject = localEntry.getValue();
      String str = (String)localEntry.getKey();
      if ((str != null) && (!str.equals("")) && (localObject != null) && ((!(localObject instanceof String)) || (!localEntry.equals(""))))
      {
        paramStringBuilder.append('"');
        paramStringBuilder.append(str);
        paramStringBuilder.append('"');
        paramStringBuilder.append(':');
        process(paramStringBuilder, localObject);
        if (i < j - 1) {
          paramStringBuilder.append(',');
        }
        i += 1;
      }
    }
    paramStringBuilder.append('}');
  }
  
  private <T> void processObj(StringBuilder paramStringBuilder, T paramT)
  {
    Object localObject1 = paramT.getClass().getDeclaredFields();
    Object localObject3 = paramT.getClass().getSuperclass().getDeclaredFields();
    Object localObject2 = new Field[localObject1.length + localObject3.length];
    int j = 0;
    int i = 0;
    while (i < localObject1.length)
    {
      localObject2[i] = localObject1[i];
      i += 1;
    }
    i = localObject1.length;
    while (i < localObject2.length)
    {
      localObject2[i] = localObject3[(i - localObject1.length)];
      i += 1;
    }
    if (localObject2.length == 0)
    {
      paramStringBuilder.append("{}");
      return;
    }
    localObject3 = new HashMap();
    i = 0;
    try
    {
      int k;
      while (i < localObject2.length)
      {
        localObject1 = localObject2[i];
        k = ((Field)localObject1).getModifiers();
        if ((k & 0x8) == 0)
        {
          String str = ((Field)localObject1).getName();
          if (!str.contains("$")) {
            if ((k & 0x1) != 0)
            {
              localObject1 = ((Field)localObject1).get(paramT);
              if (localObject1 != null) {
                ((Map)localObject3).put(str, localObject1);
              }
            }
            else
            {
              Class localClass = paramT.getClass();
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("get");
              localStringBuilder.append(str.substring(0, 1).toUpperCase());
              if (str.length() == 1) {
                localObject1 = "";
              } else {
                localObject1 = str.substring(1);
              }
              localStringBuilder.append((String)localObject1);
              localObject1 = localClass.getMethod(localStringBuilder.toString(), new Class[0]);
              if (localObject1 != null)
              {
                localObject1 = ((Method)localObject1).invoke(paramT, new Object[0]);
                if (localObject1 != null) {
                  ((Map)localObject3).put(str, localObject1);
                }
              }
            }
          }
        }
        i += 1;
      }
      return;
    }
    catch (Exception paramT)
    {
      paramT.printStackTrace();
      paramStringBuilder.append('{');
      k = ((Map)localObject3).size();
      paramT = ((Map)localObject3).entrySet().iterator();
      i = j;
      while (paramT.hasNext())
      {
        localObject2 = (Map.Entry)paramT.next();
        j = i + 1;
        localObject1 = (String)((Map.Entry)localObject2).getKey();
        localObject2 = ((Map.Entry)localObject2).getValue();
        if (((localObject2 instanceof String)) && (localObject2.equals("")))
        {
          i = j;
        }
        else
        {
          paramStringBuilder.append('"');
          paramStringBuilder.append((String)localObject1);
          paramStringBuilder.append('"');
          paramStringBuilder.append(':');
          process(paramStringBuilder, localObject2);
          i = j;
          if (j < k)
          {
            paramStringBuilder.append(',');
            i = j;
          }
        }
      }
      paramStringBuilder.append('}');
    }
  }
  
  public <T> T fromJson(String paramString, Class<T> paramClass)
  {
    if (paramString == null) {
      return null;
    }
    if (paramClass != null)
    {
      paramString = paramString.trim();
      if (paramString.startsWith("[")) {
        try
        {
          paramString = fromJsonArr(new JSONArray(paramString), paramClass, null);
          if (paramString == null) {
            break label151;
          }
          return paramString;
        }
        catch (Exception paramString)
        {
          paramClass = new StringBuilder();
          paramClass.append("json 解析错误");
          paramClass.append(paramString.getMessage());
          throw new WeJsonException(paramClass.toString(), paramString);
        }
      } else if (paramString.startsWith("{")) {
        try
        {
          paramString = fromJsonObj(new JSONObject(paramString), paramClass, null);
          return paramString;
        }
        catch (Exception paramString)
        {
          paramClass = new StringBuilder();
          paramClass.append("json 解析错误:");
          paramClass.append(paramString.getMessage());
          throw new WeJsonException(paramClass.toString(), paramString);
        }
      }
      label151:
      throw new WeJsonException("classOfT 指定错误");
    }
    throw new WeJsonException("必须指定classOfT");
  }
  
  public <T> String toJson(T paramT)
  {
    return toJson(paramT, 0);
  }
  
  public <T> String toJson(T paramT, int paramInt)
  {
    if (paramT == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    process(localStringBuilder, paramT);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.common.WeJson
 * JD-Core Version:    0.7.0.1
 */