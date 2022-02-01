package com.tencent.qqlive.module.videoreport.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class JsonUtils
{
  public static String getJsonFromMap(Map<String, Object> paramMap)
  {
    try
    {
      paramMap = new JSONObject(paramMap).toString();
      return paramMap;
    }
    catch (Throwable paramMap)
    {
      paramMap.printStackTrace();
    }
    return "";
  }
  
  public static Map<String, Object> getMapForJson(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      Iterator localIterator = paramString.keys();
      HashMap localHashMap = new HashMap();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localHashMap.put(str, paramString.get(str));
      }
      return localHashMap;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.utils.JsonUtils
 * JD-Core Version:    0.7.0.1
 */