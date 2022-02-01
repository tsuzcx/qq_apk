package com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DTBaseEventMapHandler
  extends DTAbstractEventMapHandler
{
  void extractDTParamOut(Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    if (!isValidMap(paramMap1)) {
      return;
    }
    paramMap1 = paramMap1.entrySet().iterator();
    while (paramMap1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap1.next();
      String str = (String)localEntry.getKey();
      if (str.startsWith("dt_"))
      {
        paramMap2.put(str, localEntry.getValue());
        paramMap1.remove();
      }
    }
  }
  
  void formatCustomParams(String paramString, Map<String, Object> paramMap1, Map<String, Object> paramMap2) {}
  
  public final void formatEvent(String paramString, Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    formatPublicParams(paramMap1);
    formatCustomParams(paramString, paramMap1, paramMap2);
    extractDTParamOut(paramMap2, paramMap1);
  }
  
  void formatSingleParam(Map<String, Object> paramMap1, String paramString1, Map<String, Object> paramMap2, String paramString2)
  {
    if (isValidMap(paramMap1)) {
      paramMap1 = getOrRemove(paramMap1, paramString1);
    } else {
      paramMap1 = null;
    }
    paramMap2.put(paramString2, paramMap1);
  }
  
  void formatSingleParamNonNull(Map<String, Object> paramMap1, String paramString1, Map<String, Object> paramMap2, String paramString2)
  {
    if (isValidMap(paramMap1)) {
      paramMap1 = getOrRemove(paramMap1, paramString1);
    } else {
      paramMap1 = null;
    }
    if (paramMap1 != null) {
      paramMap2.put(paramString2, paramMap1);
    }
  }
  
  protected Object remove(Map<String, Object> paramMap, String paramString)
  {
    if ((paramMap != null) && (paramString != null) && (paramMap.containsKey(paramString))) {
      return paramMap.remove(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTBaseEventMapHandler
 * JD-Core Version:    0.7.0.1
 */