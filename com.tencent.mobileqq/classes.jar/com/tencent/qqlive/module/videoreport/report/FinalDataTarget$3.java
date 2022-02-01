package com.tencent.qqlive.module.videoreport.report;

import com.tencent.qqlive.module.videoreport.Configuration;
import com.tencent.qqlive.module.videoreport.dtreport.reportchannel.DTAppKeyExtractor;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.utils.IFormatter;
import java.util.HashMap;
import java.util.Map;

final class FinalDataTarget$3
  implements Runnable
{
  FinalDataTarget$3(Map paramMap, FinalData paramFinalData, Object paramObject) {}
  
  public void run()
  {
    FinalDataTarget.access$100(this.val$publicParams);
    FinalDataTarget.access$200(this.val$publicParams);
    FinalDataTarget.access$300(DTAppKeyExtractor.getAppKey(this.val$finalData.eventKey, this.val$finalData.eventParams), this.val$finalData.eventKey, this.val$publicParams);
    IFormatter localIFormatter = VideoReportInner.getInstance().getConfiguration().getFormatter();
    String str = this.val$finalData.eventKey;
    Map localMap = this.val$publicParams;
    if (this.val$finalData.eventParams == null) {
      localObject = null;
    } else {
      localObject = new HashMap(this.val$finalData.eventParams);
    }
    Object localObject = localIFormatter.formatEvent(str, localMap, (Map)localObject);
    if (VideoReportInner.getInstance().isReportEnable()) {
      FinalDataTarget.access$500(this.val$object, this.val$finalData.eventKey, (Map)localObject);
    }
    FinalDataTarget.access$400(this.val$finalData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.FinalDataTarget.3
 * JD-Core Version:    0.7.0.1
 */