package com.tencent.tissue.v8rt.engine;

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
    Object localObject4 = null;
    Object localObject1;
    if ((paramString.startsWith("\"")) && (paramString.endsWith("\""))) {
      localObject1 = paramString.substring(1, paramString.length() - 1);
    }
    label124:
    do
    {
      do
      {
        do
        {
          do
          {
            return localObject1;
            if ((!paramString.startsWith("{")) || (!paramString.endsWith("}"))) {
              break label124;
            }
            try
            {
              localObject1 = new JSONObject(paramString);
              paramString = (String)localObject1;
            }
            catch (JSONException localJSONException1)
            {
              for (;;)
              {
                Log.e("Utils", "unexpected json object notation " + paramString);
                paramString = null;
              }
            }
            localObject1 = localObject4;
          } while (paramString == null);
          localObject1 = localObject4;
        } while (JSONObject.NULL.equals(paramString));
        return convertJsonToMap(paramString, new HashMap());
        if ((!paramString.startsWith("[")) || (!paramString.endsWith("]"))) {
          break label202;
        }
        try
        {
          localObject2 = new JSONArray(paramString);
          paramString = (String)localObject2;
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            Object localObject2;
            Log.e("Utils", "unexpected json array notation " + paramString);
            paramString = null;
          }
        }
        localObject2 = localObject4;
      } while (paramString == null);
      return putArray(paramString, new ArrayList());
      if ((paramString.equals("true")) || (paramString.equals("false"))) {
        return Boolean.valueOf(paramString.equals("true"));
      }
      Object localObject3 = localObject4;
    } while (paramString.equals("null"));
    label202:
    if (paramString.matches("^-?\\d+"))
    {
      Logger.w("Utils", "javascript number not handled");
      return Long.valueOf(Long.parseLong(paramString));
    }
    Logger.w("Utils", "unknown return data types");
    return null;
  }
  
  private static Object convertJsonToMap(JSONObject paramJSONObject, Map<String, Object> paramMap)
  {
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!putObject(paramJSONObject, str, paramMap)) && (!putArray(paramJSONObject, str, paramMap)) && (!putNumber(paramJSONObject, str, paramMap)) && (!putNull(paramJSONObject, str, paramMap)) && (!putString(paramJSONObject, str, paramMap)) && (!putBoolean(paramJSONObject, str, paramMap))) {
        Logger.w("Utils", "unrecognized property " + str);
      }
    }
    return paramMap;
  }
  
  private static ArrayList putArray(JSONArray paramJSONArray, ArrayList paramArrayList)
  {
    int i = 0;
    for (;;)
    {
      if (i < paramJSONArray.length())
      {
        Object localObject2;
        try
        {
          Object localObject1 = paramJSONArray.get(i);
          if (JSONObject.NULL.equals(localObject1))
          {
            paramArrayList.add(null);
          }
          else if ((localObject1 instanceof JSONObject))
          {
            localObject2 = new HashMap();
            paramArrayList.add(convertJsonToMap((JSONObject)localObject1, (Map)localObject2));
          }
        }
        catch (JSONException localJSONException)
        {
          Logger.e("Utils", "failed get value from json array " + paramJSONArray);
        }
        if ((localJSONException instanceof JSONArray))
        {
          localObject2 = new ArrayList();
          paramArrayList.add(putArray((JSONArray)localJSONException, (ArrayList)localObject2));
        }
        else
        {
          paramArrayList.add(localJSONException);
        }
      }
      else
      {
        return paramArrayList;
      }
      i += 1;
    }
  }
  
  private static boolean putArray(JSONObject paramJSONObject, String paramString, Map paramMap)
  {
    try
    {
      paramMap.put(paramString, putArray(paramJSONObject.getJSONArray(paramString), new ArrayList()));
      return true;
    }
    catch (JSONException paramJSONObject) {}
    return false;
  }
  
  private static boolean putBoolean(JSONObject paramJSONObject, String paramString, Map paramMap)
  {
    try
    {
      paramMap.put(paramString, Boolean.valueOf(paramJSONObject.getBoolean(paramString)));
      return true;
    }
    catch (JSONException paramJSONObject) {}
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
      try
      {
        paramMap.put(paramString, Long.valueOf(paramJSONObject.getLong(paramString)));
        return true;
      }
      catch (JSONException localJSONException2)
      {
        try
        {
          paramMap.put(paramString, Integer.valueOf(paramJSONObject.getInt(paramString)));
          return true;
        }
        catch (JSONException paramJSONObject) {}
      }
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
    catch (JSONException paramJSONObject) {}
    return false;
  }
  
  private static boolean putString(JSONObject paramJSONObject, String paramString, Map paramMap)
  {
    try
    {
      paramMap.put(paramString, paramJSONObject.getString(paramString));
      return true;
    }
    catch (JSONException paramJSONObject) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tissue.v8rt.engine.JsValueUtil
 * JD-Core Version:    0.7.0.1
 */