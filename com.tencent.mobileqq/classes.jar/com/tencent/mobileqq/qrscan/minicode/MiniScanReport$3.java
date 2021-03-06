package com.tencent.mobileqq.qrscan.minicode;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MobileQQ;

final class MiniScanReport$3
  implements Runnable
{
  MiniScanReport$3(int paramInt1, int paramInt2) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("report_key_detect_support_type", String.valueOf(this.a));
    localHashMap.put("report_key_detect_init_stauts", String.valueOf(this.b));
    localHashMap.put("report_key_qq_version", "0");
    localHashMap.put("report_key_qq_subversion", "5770");
    int i = MiniScanReport.d();
    localHashMap.put("report_key_detect_init_process", String.valueOf(i));
    MiniScanReport.a(localHashMap);
    StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance("", "report_tag_detect_supporttype", true, 0L, 0L, localHashMap, "");
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.MiniScanReport", 2, String.format("onDetectSupportReport [supportType,initStatus]=[%d,%d] pid=%d", new Object[] { Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(i) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.minicode.MiniScanReport.3
 * JD-Core Version:    0.7.0.1
 */