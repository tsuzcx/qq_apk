package com.tencent.qqmini.sdk.report;

import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.SingleDcData;
import bgya;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;

public class MiniProgramReporter$4
  implements Runnable
{
  public MiniProgramReporter$4(bgya parambgya, APP_REPORT_TRANSFER.SingleDcData paramSingleDcData) {}
  
  public void run()
  {
    if (this.a.dcid.get() == 7) {
      bgya.c(this.this$0).add(this.a);
    }
    for (;;)
    {
      bgya.a(this.this$0);
      return;
      bgya.d(this.this$0).add(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramReporter.4
 * JD-Core Version:    0.7.0.1
 */