package com.tencent.mobileqq.qrscan.minicode;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MobileQQ;

final class MiniScanReport$1
  implements Runnable
{
  MiniScanReport$1(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7) {}
  
  public void run()
  {
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(MobileQQ.getContext());
    int i = this.a;
    HashMap localHashMap;
    if ((i > 0) && (i < 180000))
    {
      localHashMap = new HashMap();
      localHashMap.put("report_key_scan_total", String.valueOf(this.b));
      localHashMap.put("report_key_scan_cnt", String.valueOf(this.c));
      localHashMap.put("report_key_scan_avg", String.valueOf(this.a));
      localHashMap.put("report_key_scan_suc", String.valueOf(this.d));
      MiniScanReport.a(localHashMap);
      localStatisticCollector.collectPerformance("", "report_tag_scan_avg_qr", true, 0L, 0L, localHashMap, "");
    }
    if (this.e > 0)
    {
      i = this.f;
      if ((i > 0) && (i < 180000))
      {
        localHashMap = new HashMap();
        localHashMap.put("report_key_scan_total", String.valueOf(this.b));
        localHashMap.put("report_key_scan_cnt", String.valueOf(this.e));
        localHashMap.put("report_key_scan_avg", String.valueOf(this.f));
        localHashMap.put("report_key_scan_suc", String.valueOf(this.d));
        MiniScanReport.a(localHashMap);
        localStatisticCollector.collectPerformance("", "report_tag_scan_avg_minidecode", true, 0L, 0L, localHashMap, "");
      }
    }
    if (this.g > 0)
    {
      i = this.h;
      if ((i > 0) && (i < 180000))
      {
        localHashMap = new HashMap();
        localHashMap.put("report_key_scan_total", String.valueOf(this.b));
        localHashMap.put("report_key_scan_cnt", String.valueOf(this.g));
        localHashMap.put("report_key_scan_avg", String.valueOf(this.h));
        localHashMap.put("report_key_scan_suc", String.valueOf(this.d));
        MiniScanReport.a(localHashMap);
        localStatisticCollector.collectPerformance("", "report_tag_scan_avg_minidetect", true, 0L, 0L, localHashMap, "");
      }
    }
    if ((QLog.isColorLevel()) || (MiniScanReport.b())) {
      QLog.i("MiniRecog.MiniScanReport", 1, String.format("base_test_scan markScanEnd [sucType,totalConsume,qrAvg,decodeAvg,detectAvg]=[%d,%d,%d,%d,%d]", new Object[] { Integer.valueOf(this.d), Long.valueOf(this.b), Integer.valueOf(this.a), Integer.valueOf(this.f), Integer.valueOf(this.h) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.minicode.MiniScanReport.1
 * JD-Core Version:    0.7.0.1
 */