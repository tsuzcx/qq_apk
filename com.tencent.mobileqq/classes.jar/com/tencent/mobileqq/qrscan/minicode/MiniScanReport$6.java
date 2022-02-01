package com.tencent.mobileqq.qrscan.minicode;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MobileQQ;

final class MiniScanReport$6
  implements Runnable
{
  MiniScanReport$6(int paramInt) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("report_key_aio_scan_recog_type", String.valueOf(this.a));
    StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance("", "report_tag_aio_scan_recog_type", true, 0L, 0L, localHashMap, "");
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.MiniScanReport", 2, String.format("onAIOScanRecogTypeReport %d", new Object[] { Integer.valueOf(this.a) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.minicode.MiniScanReport.6
 * JD-Core Version:    0.7.0.1
 */