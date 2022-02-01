package com.tencent.qqlive.module.videoreport.utils;

import com.tencent.qqlive.module.videoreport.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class JsonUtils
{
  private static final String TAG = "JsonUtils";
  
  public static String getJsonFromMap(Map<String, Object> paramMap)
  {
    try
    {
      paramMap = new JSONObject(paramMap).toString();
      return paramMap;
    }
    catch (Throwable paramMap)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getJsonFromMap ");
      localStringBuilder.append(paramMap);
      Log.e("JsonUtils", localStringBuilder.toString());
    }
    return "";
  }
  
  public static Map<String, Object> getMapForJson(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      localObject = paramString.keys();
      HashMap localHashMap = new HashMap();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        localHashMap.put(str, paramString.get(str));
      }
      return localHashMap;
    }
    catch (Throwable paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getMapForJson ");
      ((StringBuilder)localObject).append(paramString);
      Log.e("JsonUtils", ((StringBuilder)localObject).toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.utils.JsonUtils
 * JD-Core Version:    0.7.0.1
 */