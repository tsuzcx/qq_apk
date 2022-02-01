package com.tencent.qqmini.v8rt.engine;

import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsValueUtil
{
  public static final String TAG = "Utils";
  
  public static Object convertJsValueString(String paramString)
  {
    if ((paramString.startsWith("\"")) && (paramString.endsWith("\""))) {
      return paramString.substring(1, paramString.length() - 1);
    }
    if ((paramString.startsWith("{")) && (paramString.endsWith("}"))) {
      return getMapObject(paramString);
    }
    if ((paramString.startsWith("[")) && (paramString.endsWith("]"))) {
      return getArrayObject(paramString);
    }
    if ((!paramString.equals("true")) && (!paramString.equals("false")))
    {
      if (paramString.equals("null")) {
        return null;
      }
      if (paramString.matches("^-?\\d+"))
      {
        Logger.w("Utils", "javascript number not handled");
        return Long.valueOf(Long.parseLong(paramString));
      }
      Logger.w("Utils", "unknown return data types");
      return null;
    }
    return Boolean.valueOf(paramString.equals("true"));
  }
  
  private static Object convertJsonToMap(JSONObject paramJSONObject, Map<String, Object> paramMap)
  {
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!putObject(paramJSONObject, str, paramMap)) && (!putArray(paramJSONObject, str, paramMap)) && (!putNumber(paramJSONObject, str, paramMap)) && (!putNull(paramJSONObject, str, paramMap)) && (!putString(paramJSONObject, str, paramMap)) && (!putBoolean(paramJSONObject, str, paramMap)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("unrecognized property ");
        localStringBuilder.append(str);
        Logger.w("Utils", localStringBuilder.toString());
      }
    }
    return paramMap;
  }
  
  private static Object getArrayObject(String paramString)
  {
    try
    {
      localObject = new JSONArray(paramString);
      paramString = (String)localObject;
    }
    catch (JSONException localJSONException)
    {
      Object localObject;
      label14:
      break label14;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("unexpected json array notation ");
    ((StringBuilder)localObject).append(paramString);
    Log.e("Utils", ((StringBuilder)localObject).toString());
    paramString = null;
    if (paramString != null) {
      return putArray(paramString, new ArrayList());
    }
    return null;
  }
  
  private static Object getMapObject(String paramString)
  {
    try
    {
      localObject = new JSONObject(paramString);
      paramString = (String)localObject;
    }
    catch (JSONException localJSONException)
    {
      Object localObject;
      label14:
      break label14;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("unexpected json object notation ");
    ((StringBuilder)localObject).append(paramString);
    Log.e("Utils", ((StringBuilder)localObject).toString());
    paramString = null;
    if ((paramString != null) && (!JSONObject.NULL.equals(paramString))) {
      return convertJsonToMap(paramString, new HashMap());
    }
    return null;
  }
  
  private static ArrayList putArray(JSONArray paramJSONArray, ArrayList paramArrayList)
  {
    int i = 0;
    while (i < paramJSONArray.length())
    {
      try
      {
        localObject1 = paramJSONArray.get(i);
        if (JSONObject.NULL.equals(localObject1))
        {
          paramArrayList.add(null);
        }
        else
        {
          Object localObject2;
          if ((localObject1 instanceof JSONObject))
          {
            localObject2 = new HashMap();
            paramArrayList.add(convertJsonToMap((JSONObject)localObject1, (Map)localObject2));
          }
          else if ((localObject1 instanceof JSONArray))
          {
            localObject2 = new ArrayList();
            paramArrayList.add(putArray((JSONArray)localObject1, (ArrayList)localObject2));
          }
          else
          {
            paramArrayList.add(localObject1);
          }
        }
      }
      catch (JSONException localJSONException)
      {
        Object localObject1;
        label110:
        break label110;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("failed get value from json array ");
      ((StringBuilder)localObject1).append(paramJSONArray);
      Logger.e("Utils", ((StringBuilder)localObject1).toString());
      i += 1;
    }
    return paramArrayList;
  }
  
  private static boolean putArray(JSONObject paramJSONObject, String paramString, Map paramMap)
  {
    try
    {
      paramMap.put(paramString, putArray(paramJSONObject.getJSONArray(paramString), new ArrayList()));
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      label25:
      break label25;
    }
    return false;
  }
  
  private static boolean putBoolean(JSONObject paramJSONObject, String paramString, Map paramMap)
  {
    try
    {
      paramMap.put(paramString, Boolean.valueOf(paramJSONObject.getBoolean(paramString)));
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      label18:
      break label18;
    }
    return false;
  }
  
  private static boolean putNull(JSONObject paramJSONObject, String paramString, Map paramMap)
  {
    if (paramJSONObject.isNull(paramString))
    {
      paramMap.put(paramString, null);
      return true;
    }
    return false;
  }
  
  private static boolean putNumber(JSONObject paramJSONObject, String paramString, Map paramMap)
  {
    try
    {
      paramMap.put(paramString, Double.valueOf(paramJSONObject.getDouble(paramString)));
      return true;
    }
    catch (JSONException localJSONException1)
    {
      label18:
      label36:
      label54:
      break label18;
    }
    try
    {
      paramMap.put(paramString, Long.valueOf(paramJSONObject.getLong(paramString)));
      return true;
    }
    catch (JSONException localJSONException2)
    {
      break label36;
    }
    try
    {
      paramMap.put(paramString, Integer.valueOf(paramJSONObject.getInt(paramString)));
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      break label54;
    }
    return false;
  }
  
  private static boolean putObject(JSONObject paramJSONObject, String paramString, Map paramMap)
  {
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject(paramString);
      HashMap localHashMap = new HashMap();
      convertJsonToMap(paramJSONObject, localHashMap);
      paramMap.put(paramString, localHashMap);
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      label31:
      break label31;
    }
    return false;
  }
  
  private static boolean putString(JSONObject paramJSONObject, String paramString, Map paramMap)
  {
    try
    {
      paramMap.put(paramString, paramJSONObject.getString(paramString));
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      label15:
      break label15;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.v8rt.engine.JsValueUtil
 * JD-Core Version:    0.7.0.1
 */