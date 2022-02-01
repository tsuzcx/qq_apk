package com.tencent.qqlive.module.videoreport.report;

import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import java.util.HashMap;
import java.util.Map;

final class FinalDataTarget$2
  implements Runnable
{
  FinalDataTarget$2(Map paramMap, String paramString, FinalData paramFinalData, Object paramObject) {}
  
  public void run()
  {
    FinalDataTarget.access$100(this.val$publicParams);
    FinalDataTarget.access$200(this.val$publicParams);
    FinalDataTarget.access$300(this.val$appKey, this.val$finalData.eventKey, this.val$publicParams);
    HashMap localHashMap = new HashMap();
    if (this.val$finalData.eventParams != null) {
      localHashMap.putAll(this.val$finalData.eventParams);
    }
    localHashMap.putAll(this.val$publicParams);
    if (!VideoReportInner.getInstance().isReportEnable())
    {
      FinalDataTarget.access$400(this.val$finalData);
      return;
    }
    FinalDataTarget.access$500(this.val$object, this.val$finalData.eventKey, localHashMap, this.val$appKey);
    FinalDataTarget.access$400(this.val$finalData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.FinalDataTarget.2
 * JD-Core Version:    0.7.0.1
 */