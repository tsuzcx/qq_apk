package com.tencent.qqlive.module.videoreport.dtreport.reportchannel;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DTAppKeyExtractor
{
  private static final Set<String> sElementEvents = new HashSet();
  
  static
  {
    sElementEvents.add("imp");
    sElementEvents.add("imp_end");
    sElementEvents.add("clck");
  }
  
  public static String getAppKey(String paramString, Map<String, Object> paramMap)
  {
    if (paramMap == null) {
      return null;
    }
    String str = getAppKeyFromMap(paramMap);
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    paramMap = paramMap.get("udf_kv");
    if (!(paramMap instanceof Map)) {
      return null;
    }
    str = getAppKeyFromMap(paramMap);
    if (TextUtils.isEmpty(str))
    {
      if (!isElementEvent(paramString)) {
        return str;
      }
      paramString = (Map)paramMap;
      paramMap = getAppKeyFromElementPath(paramString.get("element_params"));
      if (!TextUtils.isEmpty(paramMap)) {
        return paramMap;
      }
      return getAppKeyFromMap(paramString.get("cur_pg"));
    }
    return str;
  }
  
  private static String getAppKeyFromElementPath(Object paramObject)
  {
    if (!(paramObject instanceof List)) {
      return null;
    }
    paramObject = ((List)paramObject).iterator();
    while (paramObject.hasNext())
    {
      String str = getAppKeyFromMap(paramObject.next());
      if (!TextUtils.isEmpty(str)) {
        return str;
      }
    }
    return null;
  }
  
  private static String getAppKeyFromMap(@NonNull Object paramObject)
  {
    if (!(paramObject instanceof Map)) {
      return null;
    }
    paramObject = ((Map)paramObject).get("dt_appkey");
    if ((paramObject instanceof String)) {
      return (String)paramObject;
    }
    return null;
  }
  
  private static boolean isElementEvent(String paramString)
  {
    return sElementEvents.contains(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.reportchannel.DTAppKeyExtractor
 * JD-Core Version:    0.7.0.1
 */