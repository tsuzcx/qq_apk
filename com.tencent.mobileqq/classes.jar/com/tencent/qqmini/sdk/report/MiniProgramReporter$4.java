package com.tencent.qqmini.sdk.report;

import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.SingleDcData;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;

class MiniProgramReporter$4
  implements Runnable
{
  MiniProgramReporter$4(MiniProgramReporter paramMiniProgramReporter, APP_REPORT_TRANSFER.SingleDcData paramSingleDcData) {}
  
  public void run()
  {
    if (this.val$singleDcData.dcid.get() == 7) {
      MiniProgramReporter.access$400(this.this$0).add(this.val$singleDcData);
    }
    for (;;)
    {
      MiniProgramReporter.access$300(this.this$0);
      return;
      MiniProgramReporter.access$500(this.this$0).add(this.val$singleDcData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramReporter.4
 * JD-Core Version:    0.7.0.1
 */