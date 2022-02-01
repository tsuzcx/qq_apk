package com.tencent.mobileqq.qwallet.config;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONParseUtils
{
  public static int a(JSONObject paramJSONObject, int paramInt, String... paramVarArgs)
  {
    int i = paramInt;
    if (paramJSONObject != null) {
      i = 0;
    }
    try
    {
      while (i < paramVarArgs.length - 1)
      {
        paramJSONObject = paramJSONObject.getJSONObject(paramVarArgs[i]);
        i += 1;
      }
      i = paramJSONObject.getInt(paramVarArgs[(paramVarArgs.length - 1)]);
      return i;
    }
    catch (Throwable paramJSONObject) {}
    return paramInt;
  }
  
  public static String a(JSONObject paramJSONObject, String paramString, String... paramVarArgs)
  {
    String str = paramString;
    int i;
    if (paramJSONObject != null) {
      i = 0;
    }
    try
    {
      while (i < paramVarArgs.length - 1)
      {
        paramJSONObject = paramJSONObject.getJSONObject(paramVarArgs[i]);
        i += 1;
      }
      str = paramJSONObject.getString(paramVarArgs[(paramVarArgs.length - 1)]);
      return str;
    }
    catch (Throwable paramJSONObject) {}
    return paramString;
  }
  
  public static JSONArray a(JSONObject paramJSONObject, String... paramVarArgs)
  {
    int i;
    if (paramJSONObject != null) {
      i = 0;
    }
    try
    {
      while (i < paramVarArgs.length - 1)
      {
        paramJSONObject = paramJSONObject.getJSONObject(paramVarArgs[i]);
        i += 1;
      }
      paramJSONObject = paramJSONObject.getJSONArray(paramVarArgs[(paramVarArgs.length - 1)]);
      return paramJSONObject;
    }
    catch (Throwable paramJSONObject)
    {
      label42:
      break label42;
    }
    return null;
  }
  
  public static JSONObject a(JSONObject paramJSONObject, String... paramVarArgs)
  {
    int i;
    if (paramJSONObject != null) {
      i = 0;
    }
    try
    {
      while (i < paramVarArgs.length - 1)
      {
        paramJSONObject = paramJSONObject.getJSONObject(paramVarArgs[i]);
        i += 1;
      }
      paramJSONObject = paramJSONObject.getJSONObject(paramVarArgs[(paramVarArgs.length - 1)]);
      return paramJSONObject;
    }
    catch (Throwable paramJSONObject)
    {
      label42:
      break label42;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.config.JSONParseUtils
 * JD-Core Version:    0.7.0.1
 */