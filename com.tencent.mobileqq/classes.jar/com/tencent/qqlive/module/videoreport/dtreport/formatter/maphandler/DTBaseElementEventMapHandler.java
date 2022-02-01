package com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler;

import android.text.TextUtils;
import java.util.Map;

abstract class DTBaseElementEventMapHandler
  extends DTBaseEventMapHandler
{
  public void formatCustomParams(String paramString, Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    super.formatCustomParams(paramString, paramMap1, paramMap2);
    if ((isValidMap(paramMap2)) && (paramMap2.containsKey("cur_pg")) && (isValidMap(paramMap2.get("cur_pg")))) {
      formatPage(paramMap1, (Map)paramMap2.get("cur_pg"));
    }
    String str = getElementId(paramMap2);
    if (!TextUtils.isEmpty(str)) {
      paramMap1.put("dt_eid", str);
    }
    if ("imp_end".equals(paramString))
    {
      formatSingleParam(paramMap2, "element_lvtm", paramMap1, "dt_element_lvtm");
      formatSingleParam(paramMap2, "element_area", paramMap1, "dt_element_area");
      formatSingleParam(paramMap2, "ele_imp_area", paramMap1, "dt_ele_imp_area");
      formatSingleParam(paramMap2, "ele_imp_rate", paramMap1, "dt_ele_imp_rate");
    }
  }
  
  protected abstract String getElementId(Map<String, Object> paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTBaseElementEventMapHandler
 * JD-Core Version:    0.7.0.1
 */