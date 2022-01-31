package com.tencent.mobileqq.mini.report;

import NS_MINI_REPORT.REPORT.SingleDcData;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class MiniProgramReporter$3
  implements Runnable
{
  MiniProgramReporter$3(MiniProgramReporter paramMiniProgramReporter, REPORT.SingleDcData paramSingleDcData) {}
  
  public void run()
  {
    if (this.val$singleDcData.dcid.get() == 4) {
      MiniProgramReporter.access$000(this.this$0).add(this.val$singleDcData);
    }
    for (;;)
    {
      MiniProgramReporter.access$300(this.this$0);
      return;
      if (this.val$singleDcData.dcid.get() == 9) {
        MiniProgramReporter.access$100(this.this$0).add(this.val$singleDcData);
      } else {
        QLog.e("MiniProgramReporter", 1, " should not report by dcReport " + MiniProgramReporter.access$200(this.val$singleDcData));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniProgramReporter.3
 * JD-Core Version:    0.7.0.1
 */