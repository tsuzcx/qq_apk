package com.tencent.qqmini.sdk.report;

import NS_MINI_REPORT.REPORT.SingleDcData;
import bgya;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.List;

public class MiniProgramReporter$3
  implements Runnable
{
  public MiniProgramReporter$3(bgya parambgya, REPORT.SingleDcData paramSingleDcData) {}
  
  public void run()
  {
    if (this.a.dcid.get() == 4) {
      bgya.a(this.this$0).add(this.a);
    }
    for (;;)
    {
      bgya.a(this.this$0);
      return;
      if (this.a.dcid.get() == 9) {
        bgya.b(this.this$0).add(this.a);
      } else {
        QMLog.e("MiniProgramReporter", " should not report by dcReport " + bgya.a(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramReporter.3
 * JD-Core Version:    0.7.0.1
 */