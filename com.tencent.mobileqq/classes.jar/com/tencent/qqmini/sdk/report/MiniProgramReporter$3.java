package com.tencent.qqmini.sdk.report;

import NS_MINI_REPORT.REPORT.SingleDcData;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.List;

class MiniProgramReporter$3
  implements Runnable
{
  MiniProgramReporter$3(MiniProgramReporter paramMiniProgramReporter, REPORT.SingleDcData paramSingleDcData) {}
  
  public void run()
  {
    if (this.val$singleDcData.dcid.get() == 4)
    {
      MiniProgramReporter.access$000(this.this$0).add(this.val$singleDcData);
    }
    else if (this.val$singleDcData.dcid.get() == 9)
    {
      MiniProgramReporter.access$100(this.this$0).add(this.val$singleDcData);
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" should not report by dcReport ");
      localStringBuilder.append(MiniProgramReporter.access$200(this.val$singleDcData));
      QMLog.e("MiniProgramReporter", localStringBuilder.toString());
    }
    MiniProgramReporter.access$300(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramReporter.3
 * JD-Core Version:    0.7.0.1
 */