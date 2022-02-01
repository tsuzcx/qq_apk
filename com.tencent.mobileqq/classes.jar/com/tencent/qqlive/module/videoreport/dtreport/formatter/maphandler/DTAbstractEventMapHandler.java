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
  
  private String removeContentId(Map paramMap)
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
  
  private String removePageId(Map<?, ?> paramMap)
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
  
  private String removePageStp(Map<?, ?> paramMap)
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
  
  private String removeRefPageParams(Map<?, ?> paramMap, String paramString)
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
      Object localObject = getAndRemoveInteractiveFlag(paramMap1);
      String str1 = removePageId(paramMap1);
      String str2 = removeContentId(paramMap1);
      String str3 = removeRefPageParams(paramMap1, "pgid");
      String str4 = removeRefPageParams(paramMap1, "pg_contentid");
      String str5 = removePageStp(paramMap1);
      if (!TextUtils.isEmpty(str1)) {
        paramMap.put("dt_pgid", str1);
      }
      if (!TextUtils.isEmpty(str2)) {
        paramMap.put("dt_pg_contentid", str2);
      }
      if (!TextUtils.isEmpty(str3)) {
        paramMap.put("dt_ref_pgid", str3);
      }
      if (!TextUtils.isEmpty(str4)) {
        paramMap.put("dt_refpg_contentid", str4);
      }
      if (!TextUtils.isEmpty(str5)) {
        paramMap.put("dt_pgstp", str5);
      }
      if (localObject != null) {
        paramMap1.put("dt_is_interactive_flag", localObject);
      }
    }
  }
  
  void formatPublicParams(Map<String, Object> paramMap)
  {
    if (!isValidMap(paramMap)) {
      return;
    }
    if (paramMap.containsKey("usid")) {
      paramMap.put("dt_usid", paramMap.remove("usid"));
    }
    if (paramMap.containsKey("us_stmp")) {
      paramMap.put("dt_usstmp", paramMap.remove("us_stmp"));
    }
    if (paramMap.containsKey("ussn")) {
      paramMap.put("dt_ussn", paramMap.remove("ussn"));
    }
    if (paramMap.containsKey("coldstart")) {
      paramMap.put("dt_coldstart", paramMap.remove("coldstart"));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTAbstractEventMapHandler
 * JD-Core Version:    0.7.0.1
 */