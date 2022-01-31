package com.tencent.qqmini.sdk.report;

import NS_MINI_REPORT.REPORT.SingleDcData;
import besl;
import beyo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;

public class MiniProgramReporter$3
  implements Runnable
{
  public MiniProgramReporter$3(beyo parambeyo, REPORT.SingleDcData paramSingleDcData) {}
  
  public void run()
  {
    if (this.a.dcid.get() == 4) {
      beyo.a(this.this$0).add(this.a);
    }
    for (;;)
    {
      beyo.a(this.this$0);
      return;
      if (this.a.dcid.get() == 9) {
        beyo.b(this.this$0).add(this.a);
      } else {
        besl.d("MiniProgramReporter", " should not report by dcReport " + beyo.a(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramReporter.3
 * JD-Core Version:    0.7.0.1
 */