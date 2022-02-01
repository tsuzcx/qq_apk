package com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler;

import java.util.Map;

class DTNewBizEventMapHandler
  extends DTBaseEventMapHandler
{
  private DTNewsPageParamsFlattenHelper mNewsFlattenHelper = new DTNewsPageParamsFlattenHelper();
  
  public void formatCustomParams(String paramString, Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    super.formatCustomParams(paramString, paramMap1, paramMap2);
    if (paramMap1 != null)
    {
      if (paramMap2 == null) {
        return;
      }
      formatPage(paramMap1, this.mNewsFlattenHelper.getMapParams(paramMap2, "cur_pg"));
      this.mNewsFlattenHelper.flattenPageParams(paramMap1, paramMap2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTNewBizEventMapHandler
 * JD-Core Version:    0.7.0.1
 */