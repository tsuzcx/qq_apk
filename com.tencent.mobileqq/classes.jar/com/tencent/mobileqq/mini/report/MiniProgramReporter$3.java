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
    if (this.val$singleDcData.dcid.get() == 4)
    {
      MiniProgramReporter.access$000(this.this$0).add(this.val$singleDcData);
    }
    else if (this.val$singleDcData.dcid.get() == 9)
    {
      MiniProgramReporter.access$100(this.this$0).add(this.val$singleDcData);
    }
    else if (this.val$singleDcData.dcid.get() == 5)
    {
      MiniProgramReporter.access$200(this.this$0).add(this.val$singleDcData);
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" should not report by dcReport ");
      localStringBuilder.append(MiniProgramReporter.access$300(this.val$singleDcData));
      QLog.e("MiniProgramReporter", 1, localStringBuilder.toString());
    }
    MiniProgramReporter.access$400(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniProgramReporter.3
 * JD-Core Version:    0.7.0.1
 */