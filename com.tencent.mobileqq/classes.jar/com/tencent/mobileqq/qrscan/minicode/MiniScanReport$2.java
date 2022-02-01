package com.tencent.mobileqq.qrscan.minicode;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MobileQQ;

final class MiniScanReport$2
  implements Runnable
{
  MiniScanReport$2(boolean paramBoolean, int paramInt, String paramString) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    if (this.a) {
      localObject = "1";
    } else {
      localObject = "0";
    }
    localHashMap.put("report_key_so_suc", localObject);
    localHashMap.put("report_key_so_version", String.valueOf(this.b));
    String str = this.c;
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    localHashMap.put("report_key_so_md5", localObject);
    localHashMap.put("report_key_qq_version", "0");
    localHashMap.put("report_key_qq_subversion", "5770");
    StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance("", "report_tag_so_cover", true, 0L, 0L, localHashMap, "");
    if (QLog.isColorLevel())
    {
      boolean bool = this.a;
      int i = this.b;
      str = this.c;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      QLog.i("MiniRecog.MiniScanReport", 2, String.format("onSoCoverReport [suc,ver,md5]=[%b,%d,%s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), localObject }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.minicode.MiniScanReport.2
 * JD-Core Version:    0.7.0.1
 */