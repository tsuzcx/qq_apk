package com.tencent.mobileqq.mini.report;

import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.SingleDcData;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;

class MiniProgramReporter$5
  implements Runnable
{
  MiniProgramReporter$5(MiniProgramReporter paramMiniProgramReporter, APP_REPORT_TRANSFER.SingleDcData paramSingleDcData) {}
  
  public void run()
  {
    if (this.val$singleDcData.dcid.get() == 7) {
      MiniProgramReporter.access$500(this.this$0).add(this.val$singleDcData);
    } else {
      MiniProgramReporter.access$600(this.this$0).add(this.val$singleDcData);
    }
    MiniProgramReporter.access$400(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniProgramReporter.5
 * JD-Core Version:    0.7.0.1
 */