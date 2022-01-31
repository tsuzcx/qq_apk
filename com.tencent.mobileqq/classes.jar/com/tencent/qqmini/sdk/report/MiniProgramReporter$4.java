package com.tencent.qqmini.sdk.report;

import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.SingleDcData;
import bezf;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;

public class MiniProgramReporter$4
  implements Runnable
{
  public MiniProgramReporter$4(bezf parambezf, APP_REPORT_TRANSFER.SingleDcData paramSingleDcData) {}
  
  public void run()
  {
    if (this.a.dcid.get() == 7) {
      bezf.c(this.this$0).add(this.a);
    }
    for (;;)
    {
      bezf.a(this.this$0);
      return;
      bezf.d(this.this$0).add(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramReporter.4
 * JD-Core Version:    0.7.0.1
 */