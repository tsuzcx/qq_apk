package com.tencent.mobileqq.emosm.favroaming;

import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class FavEmoSendControlConstant
{
  public static void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    String str2 = "0";
    String str1;
    if (paramBoolean) {
      str1 = "1";
    } else {
      str1 = "0";
    }
    localHashMap.put("sucFlag", str1);
    localHashMap.put("retCode", String.valueOf(paramInt1));
    localHashMap.put("serverRetCode", String.valueOf(paramInt2));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "FavEmoUploadLocal", false, 0L, 0L, localHashMap, null);
    if (paramBoolean) {
      str1 = str2;
    } else {
      str1 = String.valueOf(paramInt1);
    }
    EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus(str1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.FavEmoSendControlConstant
 * JD-Core Version:    0.7.0.1
 */