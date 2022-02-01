package com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler;

import java.util.Map;

public class DTViewFlattenEventMapHandler
  extends DTBaseElementEventMapHandler
{
  public void formatCustomParams(String paramString, Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    super.formatCustomParams(paramString, paramMap1, paramMap2);
    if (paramMap1 != null)
    {
      if (paramMap2 == null) {
        return;
      }
      paramString = remove(paramMap2, "element_params");
      if (paramString != null) {
        paramMap1.put("dt_element_params", paramString);
      }
    }
  }
  
  protected String getElementId(Map<String, Object> paramMap)
  {
    if (!isValidMap(paramMap)) {
      return null;
    }
    return (String)paramMap.get("eid");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTViewFlattenEventMapHandler
 * JD-Core Version:    0.7.0.1
 */