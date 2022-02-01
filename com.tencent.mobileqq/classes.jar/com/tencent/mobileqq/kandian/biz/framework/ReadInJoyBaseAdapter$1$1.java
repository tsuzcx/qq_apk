package com.tencent.mobileqq.kandian.biz.framework;

import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.api.IBaseHandler;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;

class ReadInJoyBaseAdapter$1$1
  implements Runnable
{
  ReadInJoyBaseAdapter$1$1(ReadInJoyBaseAdapter.1 param1, long paramLong, IBaseHandler paramIBaseHandler) {}
  
  public void run()
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder1 = new RIJTransMergeKanDianReport.ReportR5Builder();
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder2 = localReportR5Builder1.addStringNotThrow("cost", this.a).addStringNotThrow("type", this.c.a);
    if (this.c.g == null) {
      localObject = "0";
    } else {
      localObject = "1";
    }
    Object localObject = localReportR5Builder2.addStringNotThrow("result", (String)localObject).addStringNotThrow("handleID", this.b.s());
    int i;
    if (this.c.d == null) {
      i = 1;
    } else {
      i = 0;
    }
    ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).addStringNotThrow("isNewCreate", i).addStringNotThrow("isDebugVersion", 0).addStringNotThrow("isPublicVersion", 1);
    PublicAccountReportUtils.a("0X800AF90", localReportR5Builder1.build());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */