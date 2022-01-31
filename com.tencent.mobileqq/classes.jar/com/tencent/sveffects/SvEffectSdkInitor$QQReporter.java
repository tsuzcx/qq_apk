package com.tencent.sveffects;

import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class SvEffectSdkInitor$QQReporter
  implements Reporter
{
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    ReportController.b(null, paramString1, paramString2, "", paramString3, paramString4, paramInt1, paramInt2, paramString5, paramString6, paramString7, paramString8);
  }
  
  public void a(String paramString, boolean paramBoolean, long paramLong1, long paramLong2, HashMap paramHashMap)
  {
    StatisticCollector.a(BaseApplication.getContext()).a(null, paramString, paramBoolean, paramLong1, paramLong2, paramHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.sveffects.SvEffectSdkInitor.QQReporter
 * JD-Core Version:    0.7.0.1
 */