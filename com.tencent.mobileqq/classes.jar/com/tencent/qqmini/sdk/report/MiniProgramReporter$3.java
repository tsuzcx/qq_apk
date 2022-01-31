package com.tencent.qqmini.sdk.report;

import NS_MINI_REPORT.REPORT.SingleDcData;
import bdnw;
import bdsr;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;

public class MiniProgramReporter$3
  implements Runnable
{
  public MiniProgramReporter$3(bdsr parambdsr, REPORT.SingleDcData paramSingleDcData) {}
  
  public void run()
  {
    if (this.a.dcid.get() == 4) {
      bdsr.a(this.this$0).add(this.a);
    }
    for (;;)
    {
      bdsr.a(this.this$0);
      return;
      if (this.a.dcid.get() == 9) {
        bdsr.b(this.this$0).add(this.a);
      } else {
        bdnw.d("MiniProgramReporter", " should not report by dcReport " + bdsr.a(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramReporter.3
 * JD-Core Version:    0.7.0.1
 */