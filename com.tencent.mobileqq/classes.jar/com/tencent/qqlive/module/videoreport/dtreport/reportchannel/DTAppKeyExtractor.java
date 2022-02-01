package com.tencent.qqlive.module.videoreport.dtreport.reportchannel;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class DTAppKeyExtractor
{
  private static final Set<String> sElementEvents = new HashSet();
  
  static
  {
    sElementEvents.add("imp");
    sElementEvents.add("imp_end");
    sElementEvents.add("clck");
  }
  
  static String getAppKey(String paramString, Map<String, Object> paramMap)
  {
    String str = null;
    if (paramMap == null) {
      paramMap = str;
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            return paramMap;
            localObject = getAppKeyFromMap(paramMap);
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              return localObject;
            }
            localObject = paramMap.get("udf_kv");
            paramMap = str;
          } while (!(localObject instanceof Map));
          str = getAppKeyFromMap(localObject);
          paramMap = str;
        } while (!TextUtils.isEmpty(str));
        paramMap = str;
      } while (!isElementEvent(paramString));
      paramString = getAppKeyFromElementPath(((Map)localObject).get("element_params"));
      paramMap = paramString;
    } while (!TextUtils.isEmpty(paramString));
    return getAppKeyFromMap(((Map)localObject).get("cur_pg"));
  }
  
  private static String getAppKeyFromElementPath(Object paramObject)
  {
    if (!(paramObject instanceof List)) {}
    String str;
    do
    {
      while (!paramObject.hasNext())
      {
        return null;
        paramObject = ((List)paramObject).iterator();
      }
      str = getAppKeyFromMap(paramObject.next());
    } while (TextUtils.isEmpty(str));
    return str;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.reportchannel.DTAppKeyExtractor
 * JD-Core Version:    0.7.0.1
 */