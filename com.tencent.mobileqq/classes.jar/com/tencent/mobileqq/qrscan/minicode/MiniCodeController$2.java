package com.tencent.mobileqq.qrscan.minicode;

class MiniCodeController$2
  implements Runnable
{
  MiniCodeController$2(MiniCodeController paramMiniCodeController) {}
  
  public void run()
  {
    long l1 = MiniScanReport.a("report_tag_detect_supporttype", 0L);
    long l2 = System.currentTimeMillis();
    if (l2 - l1 > 86400000L)
    {
      MiniScanReport.b(MiniCodeController.a(this.this$0), -1);
      MiniScanReport.b("report_tag_detect_supporttype", l2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.minicode.MiniCodeController.2
 * JD-Core Version:    0.7.0.1
 */