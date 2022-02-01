package com.tencent.mobileqq.vashealth;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.vashealth.config.HealthConfigBean;
import com.tencent.mobileqq.vashealth.config.HealthConfigProcessor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class VSHealthReportUtil
{
  public static void a(AppInterface paramAppInterface, String paramString, HashMap<String, String> paramHashMap)
  {
    if (a())
    {
      b(paramAppInterface, paramString, paramHashMap);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("VSHealthReportUtil", 1, "[reportToBeacon] no need to report to beacon");
    }
  }
  
  public static void a(String paramString1, String paramString2, HashMap<String, String> paramHashMap)
  {
    Object localObject = paramHashMap;
    if (paramHashMap == null) {
      localObject = new HashMap();
    }
    ((HashMap)localObject).put("userid", paramString1);
    ((HashMap)localObject).put("platform", "android");
    ((HashMap)localObject).put("data_timestamp", String.valueOf(System.currentTimeMillis()));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramString1, paramString2, true, 0L, 0L, (HashMap)localObject, "");
  }
  
  private static boolean a()
  {
    return HealthConfigProcessor.a().a() ^ true;
  }
  
  private static void b(AppInterface paramAppInterface, String paramString, HashMap<String, String> paramHashMap)
  {
    if (paramAppInterface == null)
    {
      QLog.e("VSHealthReportUtil", 1, "[reportToBeacon] report to beacon error, app is null!");
      return;
    }
    a(paramAppInterface.getCurrentAccountUin(), paramString, paramHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.VSHealthReportUtil
 * JD-Core Version:    0.7.0.1
 */