package com.tencent.mobileqq.qrscan.minicode;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MobileQQ;

final class MiniScanReport$8
  implements Runnable
{
  MiniScanReport$8(int paramInt1, int paramInt2) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("report_key_detect_support_type", String.valueOf(this.a));
    localHashMap.put("report_key_detect_init_cost", String.valueOf(this.b));
    localHashMap.put("report_key_qq_version", "8.8.175770");
    MiniScanReport.a(localHashMap);
    StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance("", "report_tag_detect_init_internal_cost", true, 0L, 0L, localHashMap, "");
    if ((QLog.isColorLevel()) || (MiniScanReport.b())) {
      QLog.i("MiniRecog.MiniScanReport", 2, String.format("base_test_scan onDetectInitInternalCost [supportType,timeCost]=[%d,%d]", new Object[] { Integer.valueOf(this.a), Integer.valueOf(this.b) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.minicode.MiniScanReport.8
 * JD-Core Version:    0.7.0.1
 */