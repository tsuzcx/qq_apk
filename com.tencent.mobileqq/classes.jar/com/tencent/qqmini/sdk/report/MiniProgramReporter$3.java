package com.tencent.qqmini.sdk.report;

import NS_MINI_REPORT.REPORT.SingleDcData;
import betc;
import bezf;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;

public class MiniProgramReporter$3
  implements Runnable
{
  public MiniProgramReporter$3(bezf parambezf, REPORT.SingleDcData paramSingleDcData) {}
  
  public void run()
  {
    if (this.a.dcid.get() == 4) {
      bezf.a(this.this$0).add(this.a);
    }
    for (;;)
    {
      bezf.a(this.this$0);
      return;
      if (this.a.dcid.get() == 9) {
        bezf.b(this.this$0).add(this.a);
      } else {
        betc.d("MiniProgramReporter", " should not report by dcReport " + bezf.a(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramReporter.3
 * JD-Core Version:    0.7.0.1
 */