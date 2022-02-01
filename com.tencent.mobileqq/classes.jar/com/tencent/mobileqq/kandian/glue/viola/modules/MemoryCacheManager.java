package com.tencent.mobileqq.kandian.glue.viola.modules;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class MemoryCacheManager
{
  private static final Map<String, JSONObject> a = new ConcurrentHashMap();
  
  public static JSONObject a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new JSONObject();
    }
    JSONObject localJSONObject = (JSONObject)a.get(paramString);
    paramString = localJSONObject;
    if (localJSONObject == null) {
      paramString = new JSONObject();
    }
    return paramString;
  }
  
  public static boolean a(String paramString, JSONObject paramJSONObject)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    a.put(paramString, localJSONObject);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.MemoryCacheManager
 * JD-Core Version:    0.7.0.1
 */