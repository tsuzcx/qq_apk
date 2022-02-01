package com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler;

import java.util.Map;

public class DTBaseBizEventMapHandler
  extends DTBaseElementEventMapHandler
{
  protected String getElementId(Map<String, Object> paramMap)
  {
    if (!isValidMap(paramMap)) {
      return null;
    }
    return (String)paramMap.get("eid");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTBaseBizEventMapHandler
 * JD-Core Version:    0.7.0.1
 */