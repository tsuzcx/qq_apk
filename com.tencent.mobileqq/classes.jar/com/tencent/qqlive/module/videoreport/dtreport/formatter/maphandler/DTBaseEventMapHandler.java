package com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler;

import java.util.Map;

public class DTBaseEventMapHandler
  extends DTAbstractEventMapHandler
{
  public void formatEvent(String paramString, Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    formatPublicParams(paramMap1);
  }
  
  void formatSingleParam(Map<String, Object> paramMap1, String paramString1, Map<String, Object> paramMap2, String paramString2)
  {
    if (isValidMap(paramMap1)) {}
    for (paramMap1 = paramMap1.get(paramString1);; paramMap1 = null)
    {
      paramMap2.put(paramString2, paramMap1);
      return;
    }
  }
  
  void formatSingleParamNonNull(Map<String, Object> paramMap1, String paramString1, Map<String, Object> paramMap2, String paramString2)
  {
    if (isValidMap(paramMap1)) {}
    for (paramMap1 = paramMap1.get(paramString1);; paramMap1 = null)
    {
      if (paramMap1 != null) {
        paramMap2.put(paramString2, paramMap1);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTBaseEventMapHandler
 * JD-Core Version:    0.7.0.1
 */