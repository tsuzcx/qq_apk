package com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler;

import android.support.annotation.NonNull;
import java.util.Map;

class DTNewsElementFlattenEventMapHandler
  extends DTBaseElementEventMapHandler
{
  private DTNewsPageParamsFlattenHelper mFlattenHelper = new DTNewsPageParamsFlattenHelper();
  
  public void formatCustomParams(String paramString, Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    super.formatCustomParams(paramString, paramMap1, paramMap2);
    if (paramMap1 != null)
    {
      if (paramMap2 == null) {
        return;
      }
      this.mFlattenHelper.flattenPageParams(paramMap1, paramMap2);
      paramString = remove(paramMap2, "element_path");
      if (paramString != null) {
        paramMap1.put("dt_element_path", paramString);
      }
    }
  }
  
  protected String getElementId(Map<String, Object> paramMap)
  {
    if (!isValidMap(paramMap)) {
      return null;
    }
    return (String)getOrRemove(paramMap, "eid");
  }
  
  Object getOrRemove(@NonNull Map<?, ?> paramMap, String paramString)
  {
    return this.mFlattenHelper.getOrRemove(paramMap, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTNewsElementFlattenEventMapHandler
 * JD-Core Version:    0.7.0.1
 */