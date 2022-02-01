package com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.Map;

abstract class DTAbstractEventMapHandler
  implements IEventMapHandler
{
  static final String CUR_PAGE_PREFIX = "pg_";
  static final String REF_PAGE_PREFIX = "refpg_";
  
  private Object getAndRemoveInteractiveFlag(Map<?, ?> paramMap)
  {
    if (!isValidMap(paramMap)) {
      return null;
    }
    return paramMap.remove("is_interactive_flag");
  }
  
  private String getOrRemoveContentId(Map paramMap)
  {
    if (!isValidMap(paramMap)) {
      return null;
    }
    paramMap = getOrRemove(paramMap, "pg_contentid");
    if (paramMap == null) {
      return null;
    }
    return paramMap.toString();
  }
  
  private String getOrRemovePageId(Map<?, ?> paramMap)
  {
    if (!isValidMap(paramMap)) {
      return null;
    }
    paramMap = getOrRemove(paramMap, "pgid");
    if (paramMap == null) {
      return null;
    }
    return paramMap.toString();
  }
  
  private String getOrRemovePageStp(Map<?, ?> paramMap)
  {
    boolean bool = isValidMap(paramMap);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (bool)
    {
      localObject1 = localObject2;
      if (paramMap.containsKey("pg_stp"))
      {
        paramMap = getOrRemove(paramMap, "pg_stp");
        if (paramMap == null) {
          return null;
        }
        localObject1 = paramMap.toString();
      }
    }
    return localObject1;
  }
  
  private String getOrRemoveRefPageParams(Map<?, ?> paramMap, String paramString)
  {
    boolean bool = isValidMap(paramMap);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (bool)
    {
      localObject1 = localObject2;
      if (paramMap.containsKey("ref_pg"))
      {
        paramMap = paramMap.get("ref_pg");
        localObject1 = localObject2;
        if (isValidMap(paramMap))
        {
          paramMap = (Map)paramMap;
          localObject1 = localObject2;
          if (paramMap.containsKey(paramString))
          {
            paramMap = getOrRemove(paramMap, paramString);
            if (paramMap == null) {
              return null;
            }
            localObject1 = paramMap.toString();
          }
        }
      }
    }
    return localObject1;
  }
  
  private void putToMap(Map<String, Object> paramMap, String paramString, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    if (((paramObject instanceof String)) && (TextUtils.isEmpty((String)paramObject))) {
      return;
    }
    paramMap.put(paramString, paramObject);
  }
  
  void formatLvTime(Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    if (!isValidMap(paramMap2)) {
      return;
    }
    if (paramMap2.containsKey("lvtm"))
    {
      paramMap2 = getOrRemove(paramMap2, "lvtm");
      if (paramMap2 != null) {
        paramMap1.put("dt_lvtm", paramMap2);
      }
    }
  }
  
  void formatPage(Map<String, Object> paramMap, Map paramMap1)
  {
    if ((isValidMap(paramMap1)) && (isValidMap(paramMap)))
    {
      Object localObject = getOrRemovePageId(paramMap1);
      String str1 = getOrRemoveContentId(paramMap1);
      String str2 = getOrRemoveRefPageParams(paramMap1, "pgid");
      String str3 = getOrRemoveRefPageParams(paramMap1, "pg_contentid");
      String str4 = getOrRemovePageStp(paramMap1);
      putToMap(paramMap, "dt_pgid", localObject);
      putToMap(paramMap, "dt_pg_contentid", str1);
      putToMap(paramMap, "dt_ref_pgid", str2);
      putToMap(paramMap, "dt_refpg_contentid", str3);
      putToMap(paramMap, "dt_pgstp", str4);
      localObject = getAndRemoveInteractiveFlag(paramMap1);
      putToMap(paramMap1, "dt_is_interactive_flag", localObject);
      putToMap(paramMap, "dt_is_interactive_flag", localObject);
    }
  }
  
  void formatPublicParams(Map<String, Object> paramMap)
  {
    if (!isValidMap(paramMap)) {
      return;
    }
    formatSinglePublicParams(paramMap, "usid", "dt_usid");
    formatSinglePublicParams(paramMap, "us_stmp", "dt_usstmp");
    formatSinglePublicParams(paramMap, "ussn", "dt_ussn");
    formatSinglePublicParams(paramMap, "coldstart", "dt_coldstart");
  }
  
  void formatSinglePublicParams(Map<String, Object> paramMap, String paramString1, String paramString2)
  {
    if (paramMap.containsKey(paramString1)) {
      paramMap.put(paramString2, paramMap.remove(paramString1));
    }
  }
  
  Object getOrRemove(@NonNull Map<?, ?> paramMap, String paramString)
  {
    return paramMap.get(paramString);
  }
  
  boolean isValidMap(Object paramObject)
  {
    return paramObject instanceof Map;
  }
  
  void transferIfExist(Map<String, Object> paramMap1, Map<String, Object> paramMap2, String paramString)
  {
    if (paramMap2.containsKey(paramString)) {
      paramMap1.put(paramString, getOrRemove(paramMap2, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTAbstractEventMapHandler
 * JD-Core Version:    0.7.0.1
 */