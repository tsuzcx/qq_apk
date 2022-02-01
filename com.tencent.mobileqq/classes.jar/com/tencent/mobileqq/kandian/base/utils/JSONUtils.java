package com.tencent.mobileqq.kandian.base.utils;

import androidx.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JSONUtils
{
  public static String a(String paramString, @Nullable Map<String, Object> paramMap)
  {
    if ((paramMap != null) && (paramMap.size() > 0)) {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
        }
        paramMap = localJSONObject.toString();
        return paramMap;
      }
      catch (Exception paramMap)
      {
        QLog.e("JSONUtils", 1, paramMap.getMessage());
      }
    }
    return paramString;
  }
  
  @Nullable
  public static JSONArray a(String paramString1, String paramString2)
  {
    paramString1 = a(paramString1);
    if (paramString1 != null)
    {
      if (paramString1.length() <= 0) {
        return null;
      }
      paramString1 = paramString1.optJSONArray(paramString2);
      if (paramString1 != null)
      {
        if (paramString1.length() <= 0) {
          return null;
        }
        return paramString1;
      }
    }
    return null;
  }
  
  @Nullable
  public static JSONObject a(String paramString)
  {
    try
    {
      paramString = (JSONObject)new JSONTokener(paramString).nextValue();
      return paramString;
    }
    catch (Exception paramString)
    {
      label17:
      break label17;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.JSONUtils
 * JD-Core Version:    0.7.0.1
 */