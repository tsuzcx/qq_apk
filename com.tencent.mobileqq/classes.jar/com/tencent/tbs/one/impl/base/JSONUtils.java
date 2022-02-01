package com.tencent.tbs.one.impl.base;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtils
{
  public static JSONObject convertMapToJSONObject(Map paramMap)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        putQuietly(localJSONObject, localObject.toString(), paramMap.get(localObject));
      }
    }
    return localJSONObject;
  }
  
  public static <T> void putQuietly(JSONObject paramJSONObject, String paramString, T paramT)
  {
    try
    {
      paramJSONObject.put(paramString, paramT);
      return;
    }
    catch (JSONException paramJSONObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.base.JSONUtils
 * JD-Core Version:    0.7.0.1
 */