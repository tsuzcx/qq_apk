package com.tencent.mobileqq.mini.report;

import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.SingleDcData;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;

class MiniProgramReporter$4
  implements Runnable
{
  MiniProgramReporter$4(MiniProgramReporter paramMiniProgramReporter, List paramList) {}
  
  public void run()
  {
    if ((this.val$dcDataList != null) && (!this.val$dcDataList.isEmpty()))
    {
      if (((APP_REPORT_TRANSFER.SingleDcData)this.val$dcDataList.get(0)).dcid.get() != 7) {
        break label68;
      }
      MiniProgramReporter.access$500(this.this$0).addAll(this.val$dcDataList);
    }
    for (;;)
    {
      MiniProgramReporter.access$400(this.this$0);
      return;
      label68:
      MiniProgramReporter.access$600(this.this$0).addAll(this.val$dcDataList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniProgramReporter.4
 * JD-Core Version:    0.7.0.1
 */