package com.tencent.mobileqq.qqfeatureswitch;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class FeatureSDKReporter
{
  public static void a() {}
  
  public static void a(String paramString, FeatureSwitch paramFeatureSwitch)
  {
    if (paramFeatureSwitch == null) {
      paramFeatureSwitch = "";
    } else {
      paramFeatureSwitch = paramFeatureSwitch.toString();
    }
    QLog.d("FeatureSDKReporter", 1, new Object[] { "reportGetFeatureEvent : ", paramString });
    HashMap localHashMap = new HashMap();
    localHashMap.put("keyFeatureContent", paramFeatureSwitch);
    localHashMap.put("keyGetFeatureName", paramString);
    a("ft_get_switch_statue", localHashMap);
  }
  
  private static void a(String paramString, HashMap<String, String> paramHashMap)
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = ((AppRuntime)localObject).getAccount();
    }
    paramHashMap.put("keyUin", localObject);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String)localObject, paramString, false, 0L, 0L, paramHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqfeatureswitch.FeatureSDKReporter
 * JD-Core Version:    0.7.0.1
 */