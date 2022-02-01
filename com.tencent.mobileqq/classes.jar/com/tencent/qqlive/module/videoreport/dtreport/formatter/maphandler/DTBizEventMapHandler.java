package com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler;

import com.tencent.qqlive.module.videoreport.Log;
import java.util.Map;

class DTBizEventMapHandler
  extends DTBaseEventMapHandler
{
  private static final String TAG = "DTBizEventMapHandler";
  private DTNewsPageParamsFlattenHelper mNewsFlattenHelper = new DTNewsPageParamsFlattenHelper();
  
  public void formatCustomParams(String paramString, Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    super.formatCustomParams(paramString, paramMap1, paramMap2);
    if (paramMap1 != null)
    {
      if (paramMap2 == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("add others ");
      localStringBuilder.append(paramString);
      Log.e("DTBizEventMapHandler", localStringBuilder.toString());
      formatPage(paramMap1, this.mNewsFlattenHelper.getMapParams(paramMap2, "cur_pg"));
      this.mNewsFlattenHelper.flattenPageParams(paramMap1, paramMap2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTBizEventMapHandler
 * JD-Core Version:    0.7.0.1
 */