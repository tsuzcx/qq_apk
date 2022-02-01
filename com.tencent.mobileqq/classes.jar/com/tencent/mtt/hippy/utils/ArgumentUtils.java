package com.tencent.mtt.hippy.utils;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class ArgumentUtils
{
  private static final byte[] EMPTY_OBJ_BYTES = { 34, 34 };
  private static final byte[] EMPTY_STRING_BYTES = { 110, 117, 108, 108 };
  
  public static void covertObject2JsonByte(GrowByteBuffer paramGrowByteBuffer, Object paramObject)
  {
    paramGrowByteBuffer.reset();
    if (paramObject != null) {
      objectToJson(paramGrowByteBuffer, paramObject);
    }
  }
  
  public static HippyArray fromArray(Object paramObject)
  {
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i = 0;
    HippyArray localHippyArray = new HippyArray();
    if ((paramObject instanceof String[]))
    {
      paramObject = (String[])(String[])paramObject;
      j = paramObject.length;
      while (i < j)
      {
        localHippyArray.pushString(paramObject[i]);
        i += 1;
      }
    }
    if ((paramObject instanceof Parcelable[]))
    {
      paramObject = (Parcelable[])(Parcelable[])paramObject;
      j = paramObject.length;
      i = 0;
      while (i < j)
      {
        Object localObject = paramObject[i];
        if ((localObject instanceof Bundle)) {
          localHippyArray.pushMap(fromBundle((Bundle)localObject));
        }
        i += 1;
      }
    }
    if ((paramObject instanceof int[]))
    {
      paramObject = (int[])(int[])paramObject;
      k = paramObject.length;
      i = j;
      while (i < k)
      {
        localHippyArray.pushInt(paramObject[i]);
        i += 1;
      }
    }
    if ((paramObject instanceof float[]))
    {
      paramObject = (float[])(float[])paramObject;
      j = paramObject.length;
      i = k;
      while (i < j)
      {
        localHippyArray.pushDouble(paramObject[i]);
        i += 1;
      }
    }
    if ((paramObject instanceof double[]))
    {
      paramObject = (double[])(double[])paramObject;
      j = paramObject.length;
      i = m;
      while (i < j)
      {
        localHippyArray.pushDouble(paramObject[i]);
        i += 1;
      }
    }
    if (!(paramObject instanceof boolean[])) {
      throw new IllegalArgumentException("Unknown array type " + paramObject.getClass());
    }
    paramObject = (boolean[])(boolean[])paramObject;
    j = paramObject.length;
    i = n;
    while (i < j)
    {
      localHippyArray.pushBoolean(paramObject[i]);
      i += 1;
    }
    return localHippyArray;
  }
  
  public static HippyMap fromBundle(Bundle paramBundle)
  {
    HippyMap localHippyMap = new HippyMap();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramBundle.get(str);
      if (localObject == null)
      {
        localHippyMap.pushNull(str);
      }
      else if (localObject.getClass().isArray())
      {
        localHippyMap.pushArray(str, fromArray(localObject));
      }
      else if ((localObject instanceof String))
      {
        localHippyMap.pushString(str, (String)localObject);
      }
      else if ((localObject instanceof Number))
      {
        if ((localObject instanceof Integer)) {
          localHippyMap.pushInt(str, ((Integer)localObject).intValue());
        } else {
          localHippyMap.pushDouble(str, ((Number)localObject).doubleValue());
        }
      }
      else if ((localObject instanceof Boolean))
      {
        localHippyMap.pushBoolean(str, ((Boolean)localObject).booleanValue());
      }
      else
      {
        if (!(localObject instanceof Bundle)) {
          throw new IllegalArgumentException("Could not convert " + localObject.getClass());
        }
        localHippyMap.pushMap(str, fromBundle((Bundle)localObject));
      }
    }
    return localHippyMap;
  }
  
  public static HippyArray fromJavaArgs(Object[] paramArrayOfObject)
  {
    HippyArray localHippyArray = new HippyArray();
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length <= 0)) {
      return localHippyArray;
    }
    for (;;)
    {
      int i;
      try
      {
        int j = paramArrayOfObject.length;
        i = 0;
        if (i >= j) {
          break;
        }
        Object localObject = paramArrayOfObject[i];
        if (localObject == null) {
          localHippyArray.pushNull();
        } else {
          parseObjectGotoArray(localHippyArray, localObject);
        }
      }
      catch (Throwable paramArrayOfObject)
      {
        return localHippyArray;
      }
      i += 1;
    }
  }
  
  public static String objectToJson(Object paramObject)
  {
    if (paramObject == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    objectToJson(localStringBuilder, paramObject);
    return localStringBuilder.toString();
  }
  
  private static void objectToJson(GrowByteBuffer paramGrowByteBuffer, Object paramObject)
  {
    int j = 0;
    int i = 0;
    if (paramObject == null) {
      paramGrowByteBuffer.putByteArray(EMPTY_OBJ_BYTES);
    }
    do
    {
      return;
      if ((paramObject instanceof String))
      {
        paramObject = (String)paramObject;
        if (TextUtils.isEmpty(paramObject))
        {
          paramGrowByteBuffer.putByteArray(EMPTY_OBJ_BYTES);
          return;
        }
        stringFormat(paramObject, paramGrowByteBuffer);
        return;
      }
      if ((paramObject.getClass().isAssignableFrom(Integer.TYPE)) || ((paramObject instanceof Integer)))
      {
        paramGrowByteBuffer.putInt(((Integer)paramObject).intValue());
        return;
      }
      if ((paramObject.getClass().isAssignableFrom(Long.TYPE)) || ((paramObject instanceof Long)))
      {
        paramGrowByteBuffer.putLong(((Long)paramObject).longValue());
        return;
      }
      if ((paramObject.getClass().isAssignableFrom(Double.TYPE)) || ((paramObject instanceof Double)))
      {
        if (Double.isNaN(((Double)paramObject).doubleValue())) {
          paramObject = Integer.valueOf(0);
        }
        for (;;)
        {
          paramGrowByteBuffer.putDouble(((Double)paramObject).doubleValue());
          return;
        }
      }
      if ((paramObject.getClass().isAssignableFrom(Boolean.TYPE)) || ((paramObject instanceof Boolean)))
      {
        paramGrowByteBuffer.putBoolean(((Boolean)paramObject).booleanValue());
        return;
      }
      if ((paramObject.getClass().isAssignableFrom(Float.TYPE)) || ((paramObject instanceof Float)))
      {
        if (Float.isNaN(((Float)paramObject).floatValue())) {
          paramObject = Integer.valueOf(0);
        }
        for (;;)
        {
          paramGrowByteBuffer.putFloat(((Float)paramObject).floatValue());
          return;
        }
      }
      if ((paramObject.getClass().isAssignableFrom([B.class)) || ((paramObject instanceof byte[])))
      {
        paramGrowByteBuffer.putByteArray((byte[])paramObject);
        return;
      }
      if ((paramObject instanceof HippyArray))
      {
        paramGrowByteBuffer.putByte((byte)91);
        paramObject = (HippyArray)paramObject;
        j = paramObject.size();
        while (i < j)
        {
          objectToJson(paramGrowByteBuffer, paramObject.getObject(i));
          if (i != j - 1) {
            paramGrowByteBuffer.putByte((byte)44);
          }
          i += 1;
        }
        paramGrowByteBuffer.putByte((byte)93);
        return;
      }
    } while (!(paramObject instanceof HippyMap));
    paramGrowByteBuffer.putByte((byte)123);
    paramObject = (HippyMap)paramObject;
    Object localObject = paramObject.keySet();
    int k = ((Set)localObject).size();
    localObject = ((Set)localObject).iterator();
    i = j;
    if (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      paramGrowByteBuffer.putByte((byte)34);
      if (TextUtils.isEmpty(str)) {
        paramGrowByteBuffer.putByteArray(EMPTY_STRING_BYTES);
      }
      for (;;)
      {
        paramGrowByteBuffer.putByte((byte)34);
        paramGrowByteBuffer.putByte((byte)58);
        objectToJson(paramGrowByteBuffer, paramObject.get(str));
        i += 1;
        if (i != k) {
          paramGrowByteBuffer.putByte((byte)44);
        }
        break;
        paramGrowByteBuffer.putByteArray(str.getBytes());
      }
    }
    paramGrowByteBuffer.putByte((byte)125);
  }
  
  private static void objectToJson(StringBuilder paramStringBuilder, Object paramObject)
  {
    int i = 0;
    if (paramObject == null) {
      paramStringBuilder.append("\"\"");
    }
    do
    {
      return;
      if ((paramObject instanceof String))
      {
        paramObject = (String)paramObject;
        if (TextUtils.isEmpty(paramObject))
        {
          paramStringBuilder.append("\"\"");
          return;
        }
        stringFormat(paramObject, paramStringBuilder);
        return;
      }
      if ((paramObject.getClass().isAssignableFrom(Integer.TYPE)) || ((paramObject instanceof Integer)))
      {
        paramStringBuilder.append(paramObject);
        return;
      }
      if ((paramObject.getClass().isAssignableFrom(Long.TYPE)) || ((paramObject instanceof Long)))
      {
        paramStringBuilder.append(paramObject);
        return;
      }
      if ((paramObject.getClass().isAssignableFrom(Double.TYPE)) || ((paramObject instanceof Double)))
      {
        localObject = paramObject;
        if (Double.isNaN(((Double)paramObject).doubleValue())) {
          localObject = Integer.valueOf(0);
        }
        paramStringBuilder.append(localObject);
        return;
      }
      if ((paramObject.getClass().isAssignableFrom(Boolean.TYPE)) || ((paramObject instanceof Boolean)))
      {
        paramStringBuilder.append(paramObject);
        return;
      }
      if ((paramObject.getClass().isAssignableFrom(Float.TYPE)) || ((paramObject instanceof Float)))
      {
        localObject = paramObject;
        if (Float.isNaN(((Float)paramObject).floatValue())) {
          localObject = Integer.valueOf(0);
        }
        paramStringBuilder.append(localObject);
        return;
      }
      if ((paramObject instanceof HippyArray))
      {
        paramStringBuilder.append("[");
        paramObject = (HippyArray)paramObject;
        int j = paramObject.size();
        while (i < j)
        {
          objectToJson(paramStringBuilder, paramObject.getObject(i));
          if (i != j - 1) {
            paramStringBuilder.append(",");
          }
          i += 1;
        }
        paramStringBuilder.append("]");
        return;
      }
    } while (!(paramObject instanceof HippyMap));
    paramStringBuilder.append("{");
    paramObject = (HippyMap)paramObject;
    Object localObject = paramObject.keySet().iterator();
    for (i = 0; ((Iterator)localObject).hasNext(); i = 1)
    {
      String str = (String)((Iterator)localObject).next();
      paramStringBuilder.append("\"");
      paramStringBuilder.append(str);
      paramStringBuilder.append("\"");
      paramStringBuilder.append(":");
      objectToJson(paramStringBuilder, paramObject.get(str));
      paramStringBuilder.append(",");
    }
    if (i != 0) {
      paramStringBuilder.deleteCharAt(paramStringBuilder.length() - 1);
    }
    paramStringBuilder.append("}");
  }
  
  public static String objectToJsonOpt(Object paramObject, StringBuilder paramStringBuilder)
  {
    if (paramObject == null) {
      return "";
    }
    objectToJson(paramStringBuilder, paramObject);
    return paramStringBuilder.toString();
  }
  
  public static Object parseArgument(Type paramType, HippyArray paramHippyArray, int paramInt)
  {
    if (paramType == String.class) {
      return paramHippyArray.getString(paramInt);
    }
    if ((paramType == Integer.TYPE) || (paramType == Integer.class)) {
      return Integer.valueOf(paramHippyArray.getInt(paramInt));
    }
    if ((paramType == Long.TYPE) || (paramType == Long.class)) {
      return Long.valueOf(paramHippyArray.getLong(paramInt));
    }
    if ((paramType == Double.TYPE) || (paramType == Double.class)) {
      return Double.valueOf(paramHippyArray.getDouble(paramInt));
    }
    if ((paramType == Boolean.TYPE) || (paramType == Boolean.class)) {
      return Boolean.valueOf(paramHippyArray.getBoolean(paramInt));
    }
    if ((paramType == Float.TYPE) || (paramType == Float.class)) {
      return Float.valueOf((float)paramHippyArray.getDouble(paramInt));
    }
    if (paramType == HippyArray.class) {
      return paramHippyArray.getArray(paramInt);
    }
    if (paramType == HippyMap.class) {
      return paramHippyArray.getMap(paramInt);
    }
    throw new RuntimeException("parseArgument exception");
  }
  
  public static Object parseArgument(Type paramType, HippyMap paramHippyMap, String paramString)
  {
    if (paramType == String.class) {
      return paramHippyMap.getString(paramString);
    }
    if ((paramType == Integer.TYPE) || (paramType == Integer.class)) {
      return Integer.valueOf(paramHippyMap.getInt(paramString));
    }
    if ((paramType == Long.TYPE) || (paramType == Long.class)) {
      return Long.valueOf(paramHippyMap.getLong(paramString));
    }
    if ((paramType == Double.TYPE) || (paramType == Double.class)) {
      return Double.valueOf(paramHippyMap.getDouble(paramString));
    }
    if ((paramType == Float.TYPE) || (paramType == Float.class)) {
      return Float.valueOf((float)paramHippyMap.getDouble(paramString));
    }
    if ((paramType == Boolean.TYPE) || (paramType == Boolean.class)) {
      return Boolean.valueOf(paramHippyMap.getBoolean(paramString));
    }
    if (paramType == HippyArray.class) {
      return paramHippyMap.getArray(paramString);
    }
    if (paramType == HippyMap.class) {
      return paramHippyMap.getMap(paramString);
    }
    throw new RuntimeException("parseArgument exception");
  }
  
  public static Object parseArgument(Type paramType, Object paramObject)
  {
    Object localObject;
    if (paramType == String.class) {
      localObject = String.valueOf(paramObject);
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return localObject;
            if ((paramType == Integer.TYPE) || (paramType == Integer.class)) {
              return Integer.valueOf(((Number)paramObject).intValue());
            }
            if ((paramType == Long.TYPE) || (paramType == Long.class)) {
              return Long.valueOf(((Number)paramObject).longValue());
            }
            if ((paramType == Double.TYPE) || (paramType == Double.class)) {
              return Double.valueOf(((Number)paramObject).doubleValue());
            }
            if ((paramType == Float.TYPE) || (paramType == Float.class)) {
              return Float.valueOf(((Number)paramObject).floatValue());
            }
            localObject = paramObject;
          } while (paramType == Boolean.TYPE);
          localObject = paramObject;
        } while (paramType == Boolean.class);
        localObject = paramObject;
      } while (paramType == HippyArray.class);
      localObject = paramObject;
    } while (paramType == HippyMap.class);
    throw new RuntimeException("parseArgument exception");
  }
  
  private static void parseObjectGotoArray(HippyArray paramHippyArray, Object paramObject)
  {
    if ((paramObject == null) || (paramObject == JSONObject.NULL)) {
      paramHippyArray.pushNull();
    }
    do
    {
      return;
      localObject = paramObject.getClass();
      if ((paramObject instanceof String))
      {
        paramHippyArray.pushString((String)paramObject);
        return;
      }
      if ((localObject == Integer.TYPE) || (localObject == Integer.class))
      {
        paramHippyArray.pushInt(((Integer)paramObject).intValue());
        return;
      }
      if ((localObject == Double.TYPE) || (localObject == Double.class))
      {
        paramHippyArray.pushDouble(((Double)paramObject).doubleValue());
        return;
      }
      if ((localObject == Long.TYPE) || (localObject == Long.class))
      {
        paramHippyArray.pushLong(((Long)paramObject).longValue());
        return;
      }
      if ((localObject == Boolean.TYPE) || (localObject == Boolean.class))
      {
        paramHippyArray.pushBoolean(((Boolean)paramObject).booleanValue());
        return;
      }
      if (localObject == HippyArray.class)
      {
        paramHippyArray.pushArray((HippyArray)paramObject);
        return;
      }
      if (localObject == HippyMap.class)
      {
        paramHippyArray.pushMap((HippyMap)paramObject);
        return;
      }
      if (localObject == JSONArray.class)
      {
        localObject = new HippyArray();
        paramObject = (JSONArray)paramObject;
        int j = paramObject.length();
        int i = 0;
        while (i < j)
        {
          parseObjectGotoArray((HippyArray)localObject, paramObject.get(i));
          i += 1;
        }
        paramHippyArray.pushArray((HippyArray)localObject);
        return;
      }
    } while (localObject != JSONObject.class);
    Object localObject = new HippyMap();
    paramObject = (JSONObject)paramObject;
    Iterator localIterator = paramObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      parseObjectGotoMap((HippyMap)localObject, str, paramObject.get(str));
    }
    paramHippyArray.pushMap((HippyMap)localObject);
  }
  
  private static void parseObjectGotoMap(HippyMap paramHippyMap, String paramString, Object paramObject)
  {
    if ((paramObject == null) || (paramObject == JSONObject.NULL)) {
      paramHippyMap.pushNull(paramString);
    }
    for (;;)
    {
      return;
      Object localObject = paramObject.getClass();
      if ((paramObject instanceof String))
      {
        paramHippyMap.pushString(paramString, (String)paramObject);
        return;
      }
      if ((localObject == Integer.TYPE) || (localObject == Integer.class))
      {
        paramHippyMap.pushInt(paramString, ((Integer)paramObject).intValue());
        return;
      }
      if ((localObject == Double.TYPE) || (localObject == Double.class))
      {
        paramHippyMap.pushDouble(paramString, ((Double)paramObject).doubleValue());
        return;
      }
      if ((localObject == Long.TYPE) || (localObject == Long.class))
      {
        paramHippyMap.pushLong(paramString, ((Long)paramObject).longValue());
        return;
      }
      if ((localObject == Boolean.TYPE) || (localObject == Boolean.class))
      {
        paramHippyMap.pushBoolean(paramString, ((Boolean)paramObject).booleanValue());
        return;
      }
      if (localObject == JSONArray.class)
      {
        localObject = new HippyArray();
        paramHippyMap.pushArray(paramString, (HippyArray)localObject);
        paramHippyMap = (JSONArray)paramObject;
        int j = paramHippyMap.length();
        int i = 0;
        while (i < j)
        {
          parseObjectGotoArray((HippyArray)localObject, paramHippyMap.get(i));
          i += 1;
        }
      }
      else if (localObject == JSONObject.class)
      {
        localObject = new HippyMap();
        paramHippyMap.pushMap(paramString, (HippyMap)localObject);
        paramHippyMap = (JSONObject)paramObject;
        paramString = paramHippyMap.keys();
        while (paramString.hasNext())
        {
          paramObject = (String)paramString.next();
          parseObjectGotoMap((HippyMap)localObject, paramObject, paramHippyMap.get(paramObject));
        }
      }
    }
  }
  
  public static HippyArray parseToArray(String paramString)
  {
    localHippyArray = new HippyArray();
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return localHippyArray;
      try
      {
        paramString = new JSONArray(paramString);
        int j = paramString.length();
        int i = 0;
        while (i < j)
        {
          parseObjectGotoArray(localHippyArray, paramString.get(i));
          i += 1;
        }
        return localHippyArray;
      }
      catch (Throwable paramString) {}
    }
  }
  
  public static HippyMap parseToMap(String paramString)
  {
    localHippyMap = new HippyMap();
    if (TextUtils.isEmpty(paramString)) {
      return localHippyMap;
    }
    try
    {
      paramString = new JSONObject(paramString);
      Iterator localIterator = paramString.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        parseObjectGotoMap(localHippyMap, str, paramString.get(str));
      }
      return localHippyMap;
    }
    catch (Throwable paramString)
    {
      return localHippyMap;
    }
  }
  
  private static void stringFormat(String paramString, GrowByteBuffer paramGrowByteBuffer)
  {
    StringBuilder localStringBuilder = paramGrowByteBuffer.getStringBuilderCache();
    stringFormat(paramString, localStringBuilder);
    paramGrowByteBuffer.putString(localStringBuilder.toString());
  }
  
  private static void stringFormat(String paramString, StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append("\"");
    int j = paramString.length();
    int i = 0;
    if (i < j)
    {
      char c = paramString.charAt(i);
      switch (c)
      {
      default: 
        if (c <= '\037') {
          paramStringBuilder.append(String.format("\\u%04x", new Object[] { Integer.valueOf(c) }));
        }
        break;
      }
      for (;;)
      {
        i += 1;
        break;
        paramStringBuilder.append('\\').append(c);
        continue;
        paramStringBuilder.append("\\t");
        continue;
        paramStringBuilder.append("\\b");
        continue;
        paramStringBuilder.append("\\n");
        continue;
        paramStringBuilder.append("\\r");
        continue;
        paramStringBuilder.append("\\f");
        continue;
        paramStringBuilder.append(c);
      }
    }
    paramStringBuilder.append("\"");
  }
  
  public static Bundle toBundle(HippyMap paramHippyMap)
  {
    Bundle localBundle = new Bundle(9);
    if (paramHippyMap != null)
    {
      Iterator localIterator = paramHippyMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = paramHippyMap.get(str);
        if (localObject == null)
        {
          localBundle.putString(str, null);
        }
        else if ((localObject instanceof String))
        {
          localBundle.putString(str, (String)localObject);
        }
        else if ((localObject.getClass().isAssignableFrom(Integer.TYPE)) || ((localObject instanceof Integer)))
        {
          localBundle.putInt(str, ((Integer)localObject).intValue());
        }
        else if ((localObject.getClass().isAssignableFrom(Long.TYPE)) || ((localObject instanceof Long)))
        {
          localBundle.putLong(str, ((Long)localObject).longValue());
        }
        else if ((localObject.getClass().isAssignableFrom(Double.TYPE)) || ((localObject instanceof Double)))
        {
          localBundle.putDouble(str, ((Double)localObject).doubleValue());
        }
        else if ((localObject.getClass().isAssignableFrom(Boolean.TYPE)) || ((localObject instanceof Boolean)))
        {
          localBundle.putBoolean(str, ((Boolean)localObject).booleanValue());
        }
        else if ((localObject instanceof HippyMap))
        {
          localBundle.putBundle(str, toBundle((HippyMap)localObject));
        }
        else
        {
          if ((localObject instanceof HippyArray)) {
            throw new UnsupportedOperationException("Arrays aren't supported yet.");
          }
          throw new IllegalArgumentException("Could not convert object with key: " + str + ".");
        }
      }
    }
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.utils.ArgumentUtils
 * JD-Core Version:    0.7.0.1
 */