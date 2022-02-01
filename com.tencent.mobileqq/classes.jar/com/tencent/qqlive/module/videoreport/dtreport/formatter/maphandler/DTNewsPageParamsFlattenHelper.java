package com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class DTNewsPageParamsFlattenHelper
  extends DTBaseEventMapHandler
{
  void flattenPageParams(Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    Map localMap1 = removeMapParams(paramMap2, "cur_pg");
    if ((paramMap1 != null) && (localMap1 != null))
    {
      paramMap1.put("dt_pg_path", localMap1.remove("pg_path"));
      paramMap1.put("dt_is_interactive_flag", localMap1.remove("dt_is_interactive_flag"));
      Map localMap2 = removeMapParams(localMap1, "ref_pg");
      paramMap1.put("dt_refpg_path", remove(localMap2, "pg_path"));
      putAllPageParams(paramMap2, localMap2, "refpg_");
      putAllPageParams(paramMap2, localMap1, "pg_");
    }
  }
  
  Map<String, Object> getMapParams(Map<String, Object> paramMap, String paramString)
  {
    if ((!isValidMap(paramMap)) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    paramMap = paramMap.get(paramString);
    if (!isValidMap(paramMap)) {
      return null;
    }
    return (Map)paramMap;
  }
  
  Object getOrRemove(@NonNull Map<?, ?> paramMap, String paramString)
  {
    return paramMap.remove(paramString);
  }
  
  void putAllPageParams(Map<String, Object> paramMap1, Map<String, Object> paramMap2, String paramString)
  {
    if ((!isValidMap(paramMap1)) || (BaseUtils.isEmpty(paramMap2))) {}
    for (;;)
    {
      return;
      paramMap2 = paramMap2.entrySet().iterator();
      while (paramMap2.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap2.next();
        if ((localEntry != null) && (localEntry.getKey() != null) && (localEntry.getValue() != null)) {
          paramMap1.put(paramString + (String)localEntry.getKey(), localEntry.getValue());
        }
      }
    }
  }
  
  Object remove(Map<String, Object> paramMap, String paramString)
  {
    if ((paramMap == null) || (paramString == null) || (!paramMap.containsKey(paramString))) {
      return null;
    }
    return paramMap.remove(paramString);
  }
  
  Map<String, Object> removeMapParams(Map<String, Object> paramMap, String paramString)
  {
    Map localMap = getMapParams(paramMap, paramString);
    remove(paramMap, paramString);
    return localMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTNewsPageParamsFlattenHelper
 * JD-Core Version:    0.7.0.1
 */