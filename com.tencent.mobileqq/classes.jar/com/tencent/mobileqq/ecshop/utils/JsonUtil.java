package com.tencent.mobileqq.ecshop.utils;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonUtil
{
  public static ArrayList<Object> a(JSONArray paramJSONArray)
  {
    if ((paramJSONArray != null) && (paramJSONArray.length() != 0))
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramJSONArray.length())
      {
        Object localObject = paramJSONArray.opt(i);
        if (localObject != null) {
          if (localObject.getClass() == JSONObject.class) {
            localArrayList.add(a((JSONObject)localObject));
          } else if (localObject.getClass() == JSONArray.class) {
            localArrayList.add(a((JSONArray)localObject));
          }
        }
        i += 1;
      }
      return localArrayList;
    }
    return null;
  }
  
  public static Map<String, Object> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    try
    {
      paramString = a(new JSONObject(paramString));
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return localLinkedHashMap;
  }
  
  public static Map<String, Object> a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(localIterator.next());
      ((StringBuilder)localObject1).append("");
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = paramJSONObject.get((String)localObject1);
      if (localObject2 != null) {
        if (localObject2.getClass() == JSONObject.class) {
          localLinkedHashMap.put(localObject1, a((JSONObject)localObject2));
        } else if (localObject2.getClass() == JSONArray.class) {
          localLinkedHashMap.put(localObject1, a((JSONArray)localObject2));
        } else {
          localLinkedHashMap.put(localObject1, localObject2);
        }
      }
    }
    return localLinkedHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.utils.JsonUtil
 * JD-Core Version:    0.7.0.1
 */