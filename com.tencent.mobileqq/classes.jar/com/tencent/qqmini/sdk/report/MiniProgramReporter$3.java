package com.tencent.qqmini.sdk.report;

import NS_MINI_REPORT.REPORT.SingleDcData;
import bhch;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.List;

public class MiniProgramReporter$3
  implements Runnable
{
  public MiniProgramReporter$3(bhch parambhch, REPORT.SingleDcData paramSingleDcData) {}
  
  public void run()
  {
    if (this.a.dcid.get() == 4) {
      bhch.a(this.this$0).add(this.a);
    }
    for (;;)
    {
      bhch.a(this.this$0);
      return;
      if (this.a.dcid.get() == 9) {
        bhch.b(this.this$0).add(this.a);
      } else {
        QMLog.e("MiniProgramReporter", " should not report by dcReport " + bhch.a(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramReporter.3
 * JD-Core Version:    0.7.0.1
 */