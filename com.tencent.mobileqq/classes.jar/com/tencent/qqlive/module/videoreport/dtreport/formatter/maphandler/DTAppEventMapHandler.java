package com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler;

import java.util.Map;

public class DTAppEventMapHandler
  extends DTBaseEventMapHandler
{
  public void formatCustomParams(String paramString, Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    super.formatCustomParams(paramString, paramMap1, paramMap2);
    if ("appout".equals(paramString))
    {
      formatLvTime(paramMap1, paramMap2);
      if ((isValidMap(paramMap2)) && (paramMap2.containsKey("cur_pg")) && (isValidMap(paramMap2.get("cur_pg")))) {
        formatPage(paramMap1, (Map)paramMap2.get("cur_pg"));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTAppEventMapHandler
 * JD-Core Version:    0.7.0.1
 */