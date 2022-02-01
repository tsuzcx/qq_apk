package org.light.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public final class GsonUtils
{
  private static final String TAG = "org.light.utils.GsonUtils";
  private static Gson gson = new GsonBuilder().create();
  
  public static void confirmValueIsArray(JsonObject paramJsonObject, String paramString)
  {
    if (paramJsonObject != null)
    {
      if (paramString == null) {
        return;
      }
      JsonElement localJsonElement = paramJsonObject.get(paramString);
      if (localJsonElement == null) {
        return;
      }
      if (localJsonElement.isJsonArray()) {
        return;
      }
      JsonArray localJsonArray = new JsonArray();
      localJsonArray.add(localJsonElement);
      paramJsonObject.remove(paramString);
      paramJsonObject.add(paramString, localJsonArray);
    }
  }
  
  public static double getDoubleUnsafe(JsonArray paramJsonArray, int paramInt)
  {
    return paramJsonArray.get(paramInt).getAsDouble();
  }
  
  public static float getFloatSafe(JsonArray paramJsonArray, int paramInt)
  {
    if (paramInt >= paramJsonArray.size()) {
      return 0.0F;
    }
    return paramJsonArray.get(paramInt).getAsFloat();
  }
  
  public static float getFloatUnsafe(JsonArray paramJsonArray, int paramInt)
  {
    return paramJsonArray.get(paramInt).getAsFloat();
  }
  
  public static int getIntUnsafe(JsonArray paramJsonArray, int paramInt)
  {
    return paramJsonArray.get(paramInt).getAsInt();
  }
  
  public static int getIntUnsafe(JsonObject paramJsonObject, String paramString)
  {
    return paramJsonObject.get(paramString).getAsInt();
  }
  
  public static JsonObject getJsonObjectUnsafe(JsonArray paramJsonArray, int paramInt)
  {
    return paramJsonArray.get(paramInt).getAsJsonObject();
  }
  
  public static String getStringUnsafe(JsonArray paramJsonArray, int paramInt)
  {
    return paramJsonArray.get(paramInt).getAsString();
  }
  
  public static String getStringUnsafe(JsonObject paramJsonObject, String paramString)
  {
    return paramJsonObject.get(paramString).getAsString();
  }
  
  public static JsonObject json2JsonObject(String paramString)
  {
    try
    {
      paramString = new JsonParser().parse(paramString);
      if ((paramString instanceof JsonObject))
      {
        paramString = (JsonObject)paramString;
        return paramString;
      }
    }
    catch (JsonSyntaxException paramString)
    {
      label26:
      break label26;
    }
    return null;
  }
  
  public static <T> T json2Obj(Gson paramGson, String paramString, Class<T> paramClass)
  {
    try
    {
      paramGson = paramGson.fromJson(paramString, paramClass);
      return paramGson;
    }
    catch (Throwable paramGson)
    {
      label9:
      break label9;
    }
    return null;
  }
  
  public static <T> T json2Obj(Gson paramGson, String paramString, Type paramType)
  {
    try
    {
      paramGson = paramGson.fromJson(paramString, paramType);
      return paramGson;
    }
    catch (Exception paramGson)
    {
      label9:
      break label9;
    }
    return null;
  }
  
  public static <T> T json2Obj(String paramString, Class<T> paramClass)
  {
    return json2Obj(gson, paramString, paramClass);
  }
  
  public static <T> T json2Obj(String paramString, Type paramType)
  {
    try
    {
      paramString = gson.fromJson(paramString, paramType);
      return paramString;
    }
    catch (Exception paramString)
    {
      label11:
      break label11;
    }
    return null;
  }
  
  public static <T> List<T> json2ObjList(Gson paramGson, String paramString, Class<T> paramClass)
  {
    try
    {
      JsonArray localJsonArray = new JsonParser().parse(paramString).getAsJsonArray();
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      int j;
      return localArrayList;
    }
    catch (Exception paramGson)
    {
      for (;;)
      {
        try
        {
          j = localJsonArray.size();
          paramString = localArrayList;
          if (i < j)
          {
            localArrayList.add(paramGson.fromJson(localJsonArray.get(i), paramClass));
            i += 1;
            continue;
            paramString = null;
          }
          return paramString;
        }
        catch (Exception paramGson) {}
        paramGson = paramGson;
      }
    }
  }
  
  public static <T> List<T> json2ObjList(String paramString, Class<T> paramClass)
  {
    return json2ObjList(gson, paramString, paramClass);
  }
  
  public static <T> String obj2Json(Gson paramGson, T paramT)
  {
    try
    {
      paramGson = paramGson.toJson(paramT);
      return paramGson;
    }
    catch (Exception paramGson)
    {
      label8:
      break label8;
    }
    return null;
  }
  
  public static <T> String obj2Json(Gson paramGson, T paramT, Type paramType)
  {
    try
    {
      paramGson = paramGson.toJson(paramT, paramType);
      return paramGson;
    }
    catch (Exception paramGson)
    {
      label9:
      break label9;
    }
    return null;
  }
  
  public static <T> String obj2Json(T paramT)
  {
    return obj2Json(gson, paramT);
  }
  
  public static <T> String obj2Json(T paramT, Type paramType)
  {
    return obj2Json(gson, paramT, paramType);
  }
  
  public static <T> String objList2Json(Gson paramGson, List<T> paramList)
  {
    try
    {
      paramGson = paramGson.toJson(paramList);
      return paramGson;
    }
    catch (Exception paramGson)
    {
      label8:
      break label8;
    }
    return null;
  }
  
  public static <T> String objList2Json(List<T> paramList)
  {
    return objList2Json(gson, paramList);
  }
  
  public static boolean optBoolean(JsonObject paramJsonObject, String paramString)
  {
    return optBoolean(paramJsonObject, paramString, false);
  }
  
  public static boolean optBoolean(JsonObject paramJsonObject, String paramString, boolean paramBoolean)
  {
    try
    {
      paramJsonObject = paramJsonObject.get(paramString);
      if ((paramJsonObject instanceof JsonPrimitive))
      {
        boolean bool = paramJsonObject.getAsBoolean();
        return bool;
      }
      return paramBoolean;
    }
    catch (Exception paramJsonObject) {}
    return paramBoolean;
  }
  
  public static double optDouble(JsonArray paramJsonArray, int paramInt)
  {
    return optDouble(paramJsonArray, paramInt, (0.0D / 0.0D));
  }
  
  public static double optDouble(JsonArray paramJsonArray, int paramInt, double paramDouble)
  {
    if (paramInt >= 0) {}
    try
    {
      if (paramInt < paramJsonArray.size())
      {
        paramJsonArray = paramJsonArray.get(paramInt);
        if ((paramJsonArray instanceof JsonPrimitive))
        {
          double d = paramJsonArray.getAsDouble();
          return d;
        }
      }
      return paramDouble;
    }
    catch (Exception paramJsonArray) {}
    return paramDouble;
  }
  
  public static double optDouble(JsonObject paramJsonObject, String paramString)
  {
    return optDouble(paramJsonObject, paramString, (0.0D / 0.0D));
  }
  
  public static double optDouble(JsonObject paramJsonObject, String paramString, double paramDouble)
  {
    try
    {
      paramJsonObject = paramJsonObject.get(paramString);
      if ((paramJsonObject instanceof JsonPrimitive))
      {
        double d = paramJsonObject.getAsDouble();
        return d;
      }
      return paramDouble;
    }
    catch (Exception paramJsonObject) {}
    return paramDouble;
  }
  
  public static float optFloat(JsonObject paramJsonObject, String paramString)
  {
    return optFloat(paramJsonObject, paramString, (0.0F / 0.0F));
  }
  
  public static float optFloat(JsonObject paramJsonObject, String paramString, float paramFloat)
  {
    try
    {
      paramJsonObject = paramJsonObject.get(paramString);
      if ((paramJsonObject instanceof JsonPrimitive))
      {
        float f = paramJsonObject.getAsFloat();
        return f;
      }
      return paramFloat;
    }
    catch (Exception paramJsonObject) {}
    return paramFloat;
  }
  
  public static int optInt(JsonArray paramJsonArray, int paramInt)
  {
    return optInt(paramJsonArray, paramInt, 0);
  }
  
  public static int optInt(JsonArray paramJsonArray, int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0) {}
    try
    {
      if (paramInt1 < paramJsonArray.size())
      {
        paramJsonArray = paramJsonArray.get(paramInt1);
        if ((paramJsonArray instanceof JsonPrimitive))
        {
          paramInt1 = paramJsonArray.getAsInt();
          return paramInt1;
        }
      }
      return paramInt2;
    }
    catch (Exception paramJsonArray) {}
    return paramInt2;
  }
  
  public static int optInt(JsonObject paramJsonObject, String paramString)
  {
    return optInt(paramJsonObject, paramString, 0);
  }
  
  public static int optInt(JsonObject paramJsonObject, String paramString, int paramInt)
  {
    try
    {
      paramJsonObject = paramJsonObject.get(paramString);
      if ((paramJsonObject instanceof JsonPrimitive))
      {
        int i = paramJsonObject.getAsInt();
        return i;
      }
      return paramInt;
    }
    catch (Exception paramJsonObject) {}
    return paramInt;
  }
  
  public static JsonArray optJsonArray(JsonArray paramJsonArray, int paramInt)
  {
    if (paramInt >= 0) {}
    try
    {
      if (paramInt < paramJsonArray.size())
      {
        paramJsonArray = paramJsonArray.get(paramInt);
        if ((paramJsonArray instanceof JsonArray))
        {
          paramJsonArray = (JsonArray)paramJsonArray;
          return paramJsonArray;
        }
      }
    }
    catch (Exception paramJsonArray)
    {
      label32:
      break label32;
    }
    return null;
  }
  
  public static JsonArray optJsonArray(JsonObject paramJsonObject, String paramString)
  {
    try
    {
      paramJsonObject = paramJsonObject.get(paramString);
      if ((paramJsonObject instanceof JsonArray))
      {
        paramJsonObject = (JsonArray)paramJsonObject;
        return paramJsonObject;
      }
    }
    catch (Exception paramJsonObject)
    {
      label20:
      break label20;
    }
    return null;
  }
  
  public static JsonObject optJsonObject(JsonArray paramJsonArray, int paramInt)
  {
    if (paramInt >= 0) {}
    try
    {
      if (paramInt < paramJsonArray.size())
      {
        paramJsonArray = paramJsonArray.get(paramInt);
        if ((paramJsonArray instanceof JsonObject))
        {
          paramJsonArray = (JsonObject)paramJsonArray;
          return paramJsonArray;
        }
      }
    }
    catch (Exception paramJsonArray)
    {
      label32:
      break label32;
    }
    return null;
  }
  
  public static JsonObject optJsonObject(JsonObject paramJsonObject, String paramString)
  {
    try
    {
      paramJsonObject = paramJsonObject.get(paramString);
      if ((paramJsonObject instanceof JsonObject))
      {
        paramJsonObject = (JsonObject)paramJsonObject;
        return paramJsonObject;
      }
    }
    catch (Exception paramJsonObject)
    {
      label20:
      break label20;
    }
    return null;
  }
  
  public static long optLong(JsonObject paramJsonObject, String paramString)
  {
    return optLong(paramJsonObject, paramString, 0L);
  }
  
  public static long optLong(JsonObject paramJsonObject, String paramString, long paramLong)
  {
    try
    {
      paramJsonObject = paramJsonObject.get(paramString);
      if ((paramJsonObject instanceof JsonPrimitive))
      {
        long l = paramJsonObject.getAsLong();
        return l;
      }
      return paramLong;
    }
    catch (Exception paramJsonObject) {}
    return paramLong;
  }
  
  public static String optString(JsonArray paramJsonArray, int paramInt)
  {
    if (paramInt >= 0) {}
    try
    {
      if (paramInt < paramJsonArray.size())
      {
        paramJsonArray = paramJsonArray.get(paramInt);
        if ((paramJsonArray instanceof JsonPrimitive))
        {
          paramJsonArray = paramJsonArray.getAsString();
          return paramJsonArray;
        }
      }
    }
    catch (Exception paramJsonArray)
    {
      label32:
      break label32;
    }
    return "";
  }
  
  public static String optString(JsonObject paramJsonObject, String paramString)
  {
    return optString(paramJsonObject, paramString, "");
  }
  
  public static String optString(JsonObject paramJsonObject, String paramString1, String paramString2)
  {
    try
    {
      paramJsonObject = paramJsonObject.get(paramString1);
      if ((paramJsonObject instanceof JsonPrimitive))
      {
        paramJsonObject = paramJsonObject.getAsString();
        return paramJsonObject;
      }
      return paramString2;
    }
    catch (Exception paramJsonObject) {}
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.light.utils.GsonUtils
 * JD-Core Version:    0.7.0.1
 */