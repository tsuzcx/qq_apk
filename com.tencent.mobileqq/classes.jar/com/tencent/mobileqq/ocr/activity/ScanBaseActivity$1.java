package com.tencent.mobileqq.ocr.activity;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;

class ScanBaseActivity$1
  implements Runnable
{
  ScanBaseActivity$1(ScanBaseActivity paramScanBaseActivity) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(-1003));
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "ocr_entrance", true, 0L, 0L, localHashMap, "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.activity.ScanBaseActivity.1
 * JD-Core Version:    0.7.0.1
 */