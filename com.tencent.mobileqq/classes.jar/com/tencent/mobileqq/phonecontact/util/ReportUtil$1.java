package com.tencent.mobileqq.phonecontact.util;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

final class ReportUtil$1
  implements Runnable
{
  ReportUtil$1(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("report_key_from", String.valueOf(this.a));
    localHashMap.put("report_key_type", String.valueOf(this.b));
    localHashMap.put("report_key_qqContactCnt", String.valueOf(this.c));
    localHashMap.put("report_key_rawContactCnt", String.valueOf(this.d));
    localHashMap.put("report_key_delCnt", String.valueOf(this.e));
    localHashMap.put("report_key_delCntConflict", String.valueOf(this.f));
    localHashMap.put("report_key_delCntDangerous", String.valueOf(this.g));
    localHashMap.put("report_key_insertCnt", String.valueOf(this.h));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actContactSyncExReport", true, 0L, 0L, localHashMap, "");
    if (QLog.isColorLevel()) {
      QLog.i("actContactSyncExReport", 2, String.format("reportContactSyncExIfNeed from|type|qqContactCnt|rawContactCnt|delCnt|delCntConflict|delCntDangerous|insertCnt = %d|%d|%d|%d|%d|%d|%d|%d", new Object[] { Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(this.f), Integer.valueOf(this.g), Integer.valueOf(this.h) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.util.ReportUtil.1
 * JD-Core Version:    0.7.0.1
 */