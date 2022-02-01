package com.tencent.mobileqq.qrscan.minicode;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MobileQQ;

final class MiniScanReport$5
  implements Runnable
{
  MiniScanReport$5(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    long l1 = MiniScanReport.a("report_tag_aio_minicode_result", 0L);
    long l2 = System.currentTimeMillis();
    if (l2 - l1 > 10800000L)
    {
      HashMap localHashMap = new HashMap();
      boolean bool = this.a;
      String str2 = "1";
      String str1;
      if (bool) {
        str1 = "1";
      } else {
        str1 = "0";
      }
      localHashMap.put("report_key_aio_decode_suc", str1);
      if (this.b) {
        str1 = str2;
      } else {
        str1 = "0";
      }
      localHashMap.put("report_key_aio_detect_suc", str1);
      localHashMap.put("report_key_qq_version", "0");
      localHashMap.put("report_key_qq_subversion", "5295");
      MiniScanReport.a(localHashMap);
      StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance("", "report_tag_aio_minicode_result", true, 0L, 0L, localHashMap, "");
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.MiniScanReport", 2, String.format("onAIOMiniCodeResultReport [decodeSuc,detectSuc]=[%b,%b]", new Object[] { Boolean.valueOf(this.a), Boolean.valueOf(this.b) }));
      }
      MiniScanReport.a("report_tag_aio_minicode_result", l2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.minicode.MiniScanReport.5
 * JD-Core Version:    0.7.0.1
 */