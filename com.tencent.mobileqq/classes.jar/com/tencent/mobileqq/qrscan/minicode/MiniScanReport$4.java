package com.tencent.mobileqq.qrscan.minicode;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MobileQQ;

final class MiniScanReport$4
  implements Runnable
{
  MiniScanReport$4(int paramInt1, int paramInt2) {}
  
  public void run()
  {
    long l1 = MiniScanReport.a("report_tag_detect_support_easy", 0L);
    long l2 = System.currentTimeMillis();
    if (l2 - l1 > 86400000L)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("report_key_detect_support_type", String.valueOf(this.a));
      localHashMap.put("report_key_detect_support_type_strict", String.valueOf(this.b));
      MiniScanReport.a(localHashMap);
      StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance("", "report_tag_detect_support_easy", true, 0L, 0L, localHashMap, "");
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.MiniScanReport", 2, String.format("onDetectSupportEasyReport [model,sdkver]=[%s,%d]", new Object[] { Build.MODEL, Integer.valueOf(Build.VERSION.SDK_INT) }));
      }
      MiniScanReport.b("report_tag_detect_support_easy", l2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.minicode.MiniScanReport.4
 * JD-Core Version:    0.7.0.1
 */