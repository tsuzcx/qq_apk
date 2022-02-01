package com.tencent.mobileqq.qrscan.minicode;

class MiniCodeController$1
  implements Runnable
{
  MiniCodeController$1(MiniCodeController paramMiniCodeController, int paramInt, long paramLong) {}
  
  public void run()
  {
    long l2 = MiniScanReport.a("report_tag_detect_supporttype", 0L);
    long l1 = System.currentTimeMillis();
    if (l1 - l2 > 86400000L)
    {
      MiniScanReport.b(MiniCodeController.a(this.this$0), this.jdField_a_of_type_Int);
      MiniScanReport.a("report_tag_detect_supporttype", l1);
    }
    l2 = this.jdField_a_of_type_Long;
    if ((l2 > 0L) && (l2 < 15000L) && (l1 - MiniScanReport.a("report_tag_detect_init_internal_cost", 0L) > 86400000L))
    {
      MiniScanReport.e(MiniCodeController.a(this.this$0), (int)this.jdField_a_of_type_Long);
      MiniScanReport.a("report_tag_detect_init_internal_cost", l1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.minicode.MiniCodeController.1
 * JD-Core Version:    0.7.0.1
 */