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
    Object localObject1 = new HippyArray();
    boolean bool = paramObject instanceof String[];
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i = 0;
    if (bool)
    {
      paramObject = (String[])(String[])paramObject;
      j = paramObject.length;
      while (i < j)
      {
        ((HippyArray)localObject1).pushString(paramObject[i]);
        i += 1;
      }
    }
    if ((paramObject instanceof Parcelable[]))
    {
      paramObject = (Parcelable[])(Parcelable[])paramObject;
      k = paramObject.length;
      i = j;
      while (i < k)
      {
        Object localObject2 = paramObject[i];
        if ((localObject2 instanceof Bundle)) {
          ((HippyArray)localObject1).pushMap(fromBundle((Bundle)localObject2));
        }
        i += 1;
      }
    }
    if ((paramObject instanceof int[]))
    {
      paramObject = (int[])(int[])paramObject;
      j = paramObject.length;
      i = k;
      while (i < j)
      {
        ((HippyArray)localObject1).pushInt(paramObject[i]);
        i += 1;
      }
    }
    if ((paramObject instanceof float[]))
    {
      paramObject = (float[])(float[])paramObject;
      j = paramObject.length;
      i = m;
      while (i < j)
      {
        ((HippyArray)localObject1).pushDouble(paramObject[i]);
        i += 1;
      }
    }
    if ((paramObject instanceof double[]))
    {
      paramObject = (double[])(double[])paramObject;
      j = paramObject.length;
      i = n;
      while (i < j)
      {
        ((HippyArray)localObject1).pushDouble(paramObject[i]);
        i += 1;
      }
    }
    if ((paramObject instanceof boolean[]))
    {
      paramObject = (boolean[])(boolean[])paramObject;
      j = paramObject.length;
      i = i1;
      while (i < j)
      {
        ((HippyArray)localObject1).pushBoolean(paramObject[i]);
        i += 1;
      }
      return localObject1;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Unknown array type ");
    ((StringBuilder)localObject1).append(paramObject.getClass());
    paramObject = new IllegalArgumentException(((StringBuilder)localObject1).toString());
    for (;;)
    {
      throw paramObject;
    }
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
      else if ((localObject instanceof Bundle))
      {
        localHippyMap.pushMap(str, fromBundle((Bundle)localObject));
      }
      else
      {
        paramBundle = new StringBuilder();
        paramBundle.append("Could not convert ");
        paramBundle.append(localObject.getClass());
        throw new IllegalArgumentException(paramBundle.toString());
      }
    }
    return localHippyMap;
  }
  
  public static HippyArray fromJavaArgs(Object[] paramArrayOfObject)
  {
    localHippyArray = new HippyArray();
    if (paramArrayOfObject != null)
    {
      if (paramArrayOfObject.length <= 0) {
        return localHippyArray;
      }
      try
      {
        int j = paramArrayOfObject.length;
        int i = 0;
        Object localObject;
        while (i < j)
        {
          localObject = paramArrayOfObject[i];
          if (localObject == null) {
            localHippyArray.pushNull();
          } else {
            parseObjectGotoArray(localHippyArray, localObject);
          }
          i += 1;
        }
        return localHippyArray;
      }
      catch (Throwable paramArrayOfObject)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("fromJavaArgs: ");
        ((StringBuilder)localObject).append(paramArrayOfObject.getMessage());
        LogUtils.d("ArgumentUtils", ((StringBuilder)localObject).toString());
      }
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
    if (paramObject == null)
    {
      paramGrowByteBuffer.putByteArray(EMPTY_OBJ_BYTES);
      return;
    }
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
    if ((!paramObject.getClass().isAssignableFrom(Integer.TYPE)) && (!(paramObject instanceof Integer)))
    {
      if ((!paramObject.getClass().isAssignableFrom(Long.TYPE)) && (!(paramObject instanceof Long)))
      {
        boolean bool = paramObject.getClass().isAssignableFrom(Double.TYPE);
        int j = 0;
        int i = 0;
        if ((!bool) && (!(paramObject instanceof Double)))
        {
          if ((!paramObject.getClass().isAssignableFrom(Boolean.TYPE)) && (!(paramObject instanceof Boolean)))
          {
            if ((!paramObject.getClass().isAssignableFrom(Float.TYPE)) && (!(paramObject instanceof Float)))
            {
              if ((!paramObject.getClass().isAssignableFrom([B.class)) && (!(paramObject instanceof byte[])))
              {
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
                }
                for (byte b = 93;; b = 125)
                {
                  paramGrowByteBuffer.putByte(b);
                  return;
                  if (!(paramObject instanceof HippyMap)) {
                    break;
                  }
                  paramGrowByteBuffer.putByte((byte)123);
                  paramObject = (HippyMap)paramObject;
                  localObject = paramObject.keySet();
                  int k = ((Set)localObject).size();
                  localObject = ((Set)localObject).iterator();
                  i = j;
                  while (((Iterator)localObject).hasNext())
                  {
                    String str = (String)((Iterator)localObject).next();
                    paramGrowByteBuffer.putByte((byte)34);
                    if (TextUtils.isEmpty(str)) {
                      paramGrowByteBuffer.putByteArray(EMPTY_STRING_BYTES);
                    } else {
                      paramGrowByteBuffer.putByteArray(str.getBytes());
                    }
                    paramGrowByteBuffer.putByte((byte)34);
                    paramGrowByteBuffer.putByte((byte)58);
                    objectToJson(paramGrowByteBuffer, paramObject.get(str));
                    j = i + 1;
                    i = j;
                    if (j != k)
                    {
                      paramGrowByteBuffer.putByte((byte)44);
                      i = j;
                    }
                  }
                }
              }
              paramGrowByteBuffer.putByteArray((byte[])paramObject);
              return;
            }
            localObject = paramObject;
            if (Float.isNaN(((Float)paramObject).floatValue())) {
              localObject = Integer.valueOf(0);
            }
            paramGrowByteBuffer.putFloat(((Float)localObject).floatValue());
            return;
          }
          paramGrowByteBuffer.putBoolean(((Boolean)paramObject).booleanValue());
          return;
        }
        Object localObject = paramObject;
        if (Double.isNaN(((Double)paramObject).doubleValue())) {
          localObject = Integer.valueOf(0);
        }
        paramGrowByteBuffer.putDouble(((Double)localObject).doubleValue());
        return;
      }
      paramGrowByteBuffer.putLong(((Long)paramObject).longValue());
      return;
    }
    paramGrowByteBuffer.putInt(((Integer)paramObject).intValue());
  }
  
  private static void objectToJson(StringBuilder paramStringBuilder, Object paramObject)
  {
    if (paramObject == null)
    {
      paramStringBuilder.append("\"\"");
      return;
    }
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
    Object localObject = paramObject;
    if (!paramObject.getClass().isAssignableFrom(Integer.TYPE)) {
      if ((paramObject instanceof Integer))
      {
        localObject = paramObject;
      }
      else
      {
        localObject = paramObject;
        if (!paramObject.getClass().isAssignableFrom(Long.TYPE)) {
          if ((paramObject instanceof Long))
          {
            localObject = paramObject;
          }
          else
          {
            boolean bool = paramObject.getClass().isAssignableFrom(Double.TYPE);
            int j = 0;
            int i = 0;
            if ((!bool) && (!(paramObject instanceof Double)))
            {
              localObject = paramObject;
              if (!paramObject.getClass().isAssignableFrom(Boolean.TYPE)) {
                if ((paramObject instanceof Boolean))
                {
                  localObject = paramObject;
                }
                else
                {
                  if ((!paramObject.getClass().isAssignableFrom(Float.TYPE)) && (!(paramObject instanceof Float)))
                  {
                    if ((paramObject instanceof HippyArray))
                    {
                      paramStringBuilder.append("[");
                      paramObject = (HippyArray)paramObject;
                      j = paramObject.size();
                      while (i < j)
                      {
                        objectToJson(paramStringBuilder, paramObject.getObject(i));
                        if (i != j - 1) {
                          paramStringBuilder.append(",");
                        }
                        i += 1;
                      }
                    }
                    for (paramObject = "]";; paramObject = "}")
                    {
                      paramStringBuilder.append(paramObject);
                      return;
                      if (!(paramObject instanceof HippyMap)) {
                        break;
                      }
                      paramStringBuilder.append("{");
                      paramObject = (HippyMap)paramObject;
                      localObject = paramObject.keySet().iterator();
                      for (i = j; ((Iterator)localObject).hasNext(); i = 1)
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
                    }
                  }
                  localObject = paramObject;
                  if (!Float.isNaN(((Float)paramObject).floatValue())) {}
                }
              }
            }
            else
            {
              do
              {
                localObject = Integer.valueOf(0);
                break;
                localObject = paramObject;
              } while (Double.isNaN(((Double)paramObject).doubleValue()));
            }
          }
        }
      }
    }
    paramStringBuilder.append(localObject);
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
    if ((paramType != Integer.TYPE) && (paramType != Integer.class))
    {
      if ((paramType != Long.TYPE) && (paramType != Long.class))
      {
        if ((paramType != Double.TYPE) && (paramType != Double.class))
        {
          if ((paramType != Boolean.TYPE) && (paramType != Boolean.class))
          {
            if ((paramType != Float.TYPE) && (paramType != Float.class))
            {
              if (paramType == HippyArray.class) {
                return paramHippyArray.getArray(paramInt);
              }
              if (paramType == HippyMap.class) {
                return paramHippyArray.getMap(paramInt);
              }
              throw new RuntimeException("parseArgument exception");
            }
            return Float.valueOf((float)paramHippyArray.getDouble(paramInt));
          }
          return Boolean.valueOf(paramHippyArray.getBoolean(paramInt));
        }
        return Double.valueOf(paramHippyArray.getDouble(paramInt));
      }
      return Long.valueOf(paramHippyArray.getLong(paramInt));
    }
    return Integer.valueOf(paramHippyArray.getInt(paramInt));
  }
  
  public static Object parseArgument(Type paramType, HippyMap paramHippyMap, String paramString)
  {
    if (paramType == String.class) {
      return paramHippyMap.getString(paramString);
    }
    if ((paramType != Integer.TYPE) && (paramType != Integer.class))
    {
      if ((paramType != Long.TYPE) && (paramType != Long.class))
      {
        if ((paramType != Double.TYPE) && (paramType != Double.class))
        {
          if ((paramType != Float.TYPE) && (paramType != Float.class))
          {
            if ((paramType != Boolean.TYPE) && (paramType != Boolean.class))
            {
              if (paramType == HippyArray.class) {
                return paramHippyMap.getArray(paramString);
              }
              if (paramType == HippyMap.class) {
                return paramHippyMap.getMap(paramString);
              }
              throw new RuntimeException("parseArgument exception");
            }
            return Boolean.valueOf(paramHippyMap.getBoolean(paramString));
          }
          return Float.valueOf((float)paramHippyMap.getDouble(paramString));
        }
        return Double.valueOf(paramHippyMap.getDouble(paramString));
      }
      return Long.valueOf(paramHippyMap.getLong(paramString));
    }
    return Integer.valueOf(paramHippyMap.getInt(paramString));
  }
  
  public static Object parseArgument(Type paramType, Object paramObject)
  {
    if (paramType == String.class) {
      return String.valueOf(paramObject);
    }
    if ((paramType != Integer.TYPE) && (paramType != Integer.class))
    {
      if ((paramType != Long.TYPE) && (paramType != Long.class))
      {
        if ((paramType != Double.TYPE) && (paramType != Double.class))
        {
          if ((paramType != Float.TYPE) && (paramType != Float.class))
          {
            if (paramType != Boolean.TYPE)
            {
              if (paramType == Boolean.class) {
                return paramObject;
              }
              if (paramType == HippyArray.class) {
                return paramObject;
              }
              if (paramType == HippyMap.class) {
                return paramObject;
              }
              throw new RuntimeException("parseArgument exception");
            }
            return paramObject;
          }
          return Float.valueOf(((Number)paramObject).floatValue());
        }
        return Double.valueOf(((Number)paramObject).doubleValue());
      }
      return Long.valueOf(((Number)paramObject).longValue());
    }
    return Integer.valueOf(((Number)paramObject).intValue());
  }
  
  private static void parseObjectGotoArray(HippyArray paramHippyArray, Object paramObject)
  {
    if ((paramObject != null) && (paramObject != JSONObject.NULL))
    {
      Object localObject = paramObject.getClass();
      if ((paramObject instanceof String))
      {
        paramHippyArray.pushString((String)paramObject);
        return;
      }
      if ((localObject != Integer.TYPE) && (localObject != Integer.class))
      {
        if ((localObject != Double.TYPE) && (localObject != Double.class))
        {
          if ((localObject != Long.TYPE) && (localObject != Long.class))
          {
            if ((localObject != Boolean.TYPE) && (localObject != Boolean.class))
            {
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
              if (localObject == JSONObject.class)
              {
                localObject = new HippyMap();
                paramObject = (JSONObject)paramObject;
                Iterator localIterator = paramObject.keys();
                while (localIterator.hasNext())
                {
                  String str = (String)localIterator.next();
                  parseObjectGotoMap((HippyMap)localObject, str, paramObject.get(str));
                }
                paramHippyArray.pushMap((HippyMap)localObject);
              }
            }
            else
            {
              paramHippyArray.pushBoolean(((Boolean)paramObject).booleanValue());
            }
          }
          else {
            paramHippyArray.pushLong(((Long)paramObject).longValue());
          }
        }
        else {
          paramHippyArray.pushDouble(((Double)paramObject).doubleValue());
        }
      }
      else {
        paramHippyArray.pushInt(((Integer)paramObject).intValue());
      }
      return;
    }
    paramHippyArray.pushNull();
  }
  
  private static void parseObjectGotoMap(HippyMap paramHippyMap, String paramString, Object paramObject)
  {
    if ((paramObject != null) && (paramObject != JSONObject.NULL))
    {
      Object localObject = paramObject.getClass();
      if ((paramObject instanceof String))
      {
        paramHippyMap.pushString(paramString, (String)paramObject);
        return;
      }
      if ((localObject != Integer.TYPE) && (localObject != Integer.class)) {
        if ((localObject != Double.TYPE) && (localObject != Double.class)) {
          if ((localObject != Long.TYPE) && (localObject != Long.class)) {
            if ((localObject != Boolean.TYPE) && (localObject != Boolean.class))
            {
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
              if (localObject != JSONObject.class) {
                break label287;
              }
              localObject = new HippyMap();
              paramHippyMap.pushMap(paramString, (HippyMap)localObject);
              paramHippyMap = (JSONObject)paramObject;
              paramString = paramHippyMap.keys();
            }
          }
        }
      }
      while (paramString.hasNext())
      {
        paramObject = (String)paramString.next();
        parseObjectGotoMap((HippyMap)localObject, paramObject, paramHippyMap.get(paramObject));
        continue;
        paramHippyMap.pushBoolean(paramString, ((Boolean)paramObject).booleanValue());
        return;
        paramHippyMap.pushLong(paramString, ((Long)paramObject).longValue());
        return;
        paramHippyMap.pushDouble(paramString, ((Double)paramObject).doubleValue());
        return;
        paramHippyMap.pushInt(paramString, ((Integer)paramObject).intValue());
      }
      label287:
      return;
    }
    paramHippyMap.pushNull(paramString);
  }
  
  public static HippyArray parseToArray(String paramString)
  {
    HippyArray localHippyArray = new HippyArray();
    if (TextUtils.isEmpty(paramString)) {
      return localHippyArray;
    }
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
    return localHippyArray;
  }
  
  public static HippyMap parseToMap(String paramString)
  {
    HippyMap localHippyMap = new HippyMap();
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
    catch (Throwable paramString) {}
    return localHippyMap;
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
    while (i < j)
    {
      char c = paramString.charAt(i);
      String str;
      if (c != '\f') {
        if (c != '\r') {
          if ((c != '"') && (c != '/') && (c != '\\')) {
            switch (c)
            {
            default: 
              if (c <= '\037') {
                str = String.format("\\u%04x", new Object[] { Integer.valueOf(c) });
              }
              break;
            case '\n': 
              str = "\\n";
              break;
            case '\t': 
              str = "\\t";
              break;
            case '\b': 
              str = "\\b";
            }
          }
        }
      }
      for (;;)
      {
        paramStringBuilder.append(str);
        break;
        paramStringBuilder.append('\\');
        paramStringBuilder.append(c);
        break;
        str = "\\r";
        continue;
        str = "\\f";
      }
      i += 1;
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
        if (localObject == null) {}
        for (localObject = null;; localObject = (String)localObject)
        {
          localBundle.putString(str, (String)localObject);
          break;
          if (!(localObject instanceof String)) {
            break label82;
          }
        }
        label82:
        if ((!localObject.getClass().isAssignableFrom(Integer.TYPE)) && (!(localObject instanceof Integer)))
        {
          if ((!localObject.getClass().isAssignableFrom(Long.TYPE)) && (!(localObject instanceof Long)))
          {
            if ((!localObject.getClass().isAssignableFrom(Double.TYPE)) && (!(localObject instanceof Double)))
            {
              if ((!localObject.getClass().isAssignableFrom(Boolean.TYPE)) && (!(localObject instanceof Boolean)))
              {
                if ((localObject instanceof HippyMap))
                {
                  localBundle.putBundle(str, toBundle((HippyMap)localObject));
                }
                else
                {
                  if ((localObject instanceof HippyArray)) {
                    throw new UnsupportedOperationException("Arrays aren't supported yet.");
                  }
                  paramHippyMap = new StringBuilder();
                  paramHippyMap.append("Could not convert object with key: ");
                  paramHippyMap.append(str);
                  paramHippyMap.append(".");
                  throw new IllegalArgumentException(paramHippyMap.toString());
                }
              }
              else {
                localBundle.putBoolean(str, ((Boolean)localObject).booleanValue());
              }
            }
            else {
              localBundle.putDouble(str, ((Double)localObject).doubleValue());
            }
          }
          else {
            localBundle.putLong(str, ((Long)localObject).longValue());
          }
        }
        else {
          localBundle.putInt(str, ((Integer)localObject).intValue());
        }
      }
    }
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.utils.ArgumentUtils
 * JD-Core Version:    0.7.0.1
 */