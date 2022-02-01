package com.tencent.tmassistantbase.util;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class d
{
  public static <T, S> String a(Map<T, S> paramMap, String paramString)
  {
    if (a(paramMap)) {
      return "";
    }
    Object localObject1 = paramMap.keySet();
    int j = ((Set)localObject1).size();
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    localObject1 = ((Set)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      localStringBuilder.append(localObject2);
      localStringBuilder.append("=");
      localStringBuilder.append(paramMap.get(localObject2));
      if (i < j - 1) {
        localStringBuilder.append(paramString);
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static Map<String, String> a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    paramString1 = paramString1.split(paramString2);
    paramString2 = new HashMap();
    int j = paramString1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramString1[i];
      try
      {
        paramString2.put(localObject.substring(0, localObject.indexOf("=")), localObject.substring(localObject.indexOf("=") + 1));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      i += 1;
    }
    return paramString2;
  }
  
  public static <T> boolean a(List<T> paramList)
  {
    return (paramList == null) || (paramList.size() <= 0);
  }
  
  public static <T, S> boolean a(Map<T, S> paramMap)
  {
    return (paramMap == null) || (paramMap.size() <= 0);
  }
  
  public static <T> String b(List<T> paramList)
  {
    if (paramList == null) {
      return "NULL";
    }
    StringBuilder localStringBuilder = new StringBuilder("size = ");
    localStringBuilder.append(paramList.size());
    localStringBuilder.append("data = [");
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(paramList.get(i));
      if (i < j - 1) {
        localStringBuilder.append(",");
      }
      i += 1;
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.d
 * JD-Core Version:    0.7.0.1
 */