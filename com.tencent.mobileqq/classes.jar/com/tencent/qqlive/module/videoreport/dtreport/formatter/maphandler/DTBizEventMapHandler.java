package com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler;

import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.report.PageReporter;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;
import java.util.Map;

class DTBizEventMapHandler
  extends DTBaseEventMapHandler
{
  private static final String TAG = "DTBizEventMapHandler";
  private final Object mLock = new Object();
  private DTNewsPageParamsFlattenHelper mNewsFlattenHelper = new DTNewsPageParamsFlattenHelper();
  
  private void addCurPage(Map<String, Object> paramMap)
  {
    paramMap.put("cur_pg", PageReporter.getInstance().getCurPageReportInfo());
    Log.e("DTBizEventMapHandler", "add cur page");
  }
  
  private void addCurPageInMainThread(Map<String, Object> arg1)
  {
    try
    {
      ThreadUtils.runOnUiThread(new DTBizEventMapHandler.1(this, ???));
      synchronized (this.mLock)
      {
        this.mLock.wait();
        return;
      }
      return;
    }
    catch (Exception ???)
    {
      Log.e("DTBizEventMapHandler", ???.getMessage());
    }
  }
  
  public void formatCustomParams(String paramString, Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    super.formatCustomParams(paramString, paramMap1, paramMap2);
    if ((paramMap1 == null) || (paramMap2 == null)) {
      return;
    }
    if (!paramMap2.containsKey("cur_pg")) {
      addCurPageInMainThread(paramMap2);
    }
    Log.e("DTBizEventMapHandler", "add others " + paramString);
    formatPage(paramMap1, this.mNewsFlattenHelper.getMapParams(paramMap2, "cur_pg"));
    this.mNewsFlattenHelper.flattenPageParams(paramMap1, paramMap2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTBizEventMapHandler
 * JD-Core Version:    0.7.0.1
 */