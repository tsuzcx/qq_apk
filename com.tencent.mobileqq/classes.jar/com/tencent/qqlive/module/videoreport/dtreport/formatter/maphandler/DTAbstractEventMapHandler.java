package com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler;

import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import java.util.Map;

abstract class DTAbstractEventMapHandler
  implements IEventMapHandler
{
  private Object getAndRemoveInteractiveFlag(Map<?, ?> paramMap)
  {
    if (!isValidMap(paramMap)) {
      return null;
    }
    return paramMap.remove("is_interactive_flag");
  }
  
  private String getContentId(Map<?, ?> paramMap)
  {
    if (!isValidMap(paramMap)) {}
    do
    {
      return null;
      paramMap = paramMap.get("pg_contentid");
    } while (paramMap == null);
    return paramMap.toString();
  }
  
  private String getPageId(Map<?, ?> paramMap)
  {
    if (!isValidMap(paramMap)) {}
    do
    {
      return null;
      paramMap = paramMap.get("pgid");
    } while (paramMap == null);
    return paramMap.toString();
  }
  
  private String getPageStp(Map<?, ?> paramMap)
  {
    if ((isValidMap(paramMap)) && (paramMap.containsKey("pg_stp")))
    {
      paramMap = paramMap.get("pg_stp");
      if (paramMap != null) {}
    }
    else
    {
      return null;
    }
    return paramMap.toString();
  }
  
  private String getRefPageId(Map<?, ?> paramMap)
  {
    if ((isValidMap(paramMap)) && (paramMap.containsKey("ref_pg")))
    {
      paramMap = paramMap.get("ref_pg");
      if (isValidMap(paramMap))
      {
        paramMap = (Map)paramMap;
        if (paramMap.containsKey("pgid"))
        {
          paramMap = paramMap.get("pgid");
          if (paramMap == null) {
            return null;
          }
          return paramMap.toString();
        }
      }
    }
    return null;
  }
  
  void formatLvTime(Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    if ((isValidMap(paramMap2)) && (paramMap2.containsKey("lvtm")))
    {
      paramMap2 = paramMap2.get("lvtm");
      if (paramMap2 != null) {
        paramMap1.put("dt_lvtm", paramMap2.toString());
      }
    }
  }
  
  void formatPage(Map<String, Object> paramMap, Map paramMap1)
  {
    if ((isValidMap(paramMap1)) && (isValidMap(paramMap)))
    {
      String str1 = getPageId(paramMap1);
      String str2 = getContentId(paramMap1);
      String str3 = getRefPageId(paramMap1);
      String str4 = getPageStp(paramMap1);
      Object localObject = getAndRemoveInteractiveFlag(paramMap1);
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
        paramMap.put("dt_pgstp", str4);
      }
      if (localObject != null) {
        paramMap1.put("dt_is_interactive_flag", localObject);
      }
    }
  }
  
  void formatPublicParams(Map<String, Object> paramMap)
  {
    if (!isValidMap(paramMap)) {}
    do
    {
      return;
      if (paramMap.containsKey("usid")) {
        paramMap.put("dt_usid", (String)paramMap.remove("usid"));
      }
      if (paramMap.containsKey("us_stmp")) {
        paramMap.put("dt_usstmp", Long.valueOf(((Long)paramMap.remove("us_stmp")).longValue()));
      }
    } while (!paramMap.containsKey("coldstart"));
    paramMap.put("dt_coldstart", (String)paramMap.remove("coldstart"));
  }
  
  boolean isValidMap(Object paramObject)
  {
    return ((paramObject instanceof Map)) && (!BaseUtils.isEmpty((Map)paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTAbstractEventMapHandler
 * JD-Core Version:    0.7.0.1
 */