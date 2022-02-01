package com.tencent.treasurecard.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtil
{
  public static Map<String, Object> a(String paramString)
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
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static List<Map<String, Object>> b(String paramString)
  {
    try
    {
      JSONArray localJSONArray = new JSONArray(paramString);
      paramString = new ArrayList();
      int i = 0;
      for (;;)
      {
        String str1 = paramString;
        try
        {
          if (i >= localJSONArray.length()) {
            return ???;
          }
          paramString.add(a(localJSONArray.getJSONObject(i).toString()));
          i += 1;
        }
        catch (Exception localException1) {}
      }
      localException2.printStackTrace();
    }
    catch (Exception localException2)
    {
      paramString = null;
    }
    String str2 = paramString;
    return str2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.treasurecard.util.JsonUtil
 * JD-Core Version:    0.7.0.1
 */