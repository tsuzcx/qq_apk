package com.tencent.mobileqq.util;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QuickLoginReporter
{
  public static void a(int paramInt, String paramString)
  {
    a("getPhoneResult", paramInt, paramString);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = ((AppRuntime)localObject).getAccount();
    }
    localHashMap.put("keyUin", localObject);
    localHashMap.put("keyErrorCode", String.valueOf(paramInt));
    localHashMap.put("keyQuickLoginResult", paramString1);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    localHashMap.put("keyErrorMsg", paramString1);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String)localObject, "quickLoginReportEvent", false, 0L, 0L, localHashMap, "");
  }
  
  public static void b(int paramInt, String paramString)
  {
    a("phoneLoginResult", paramInt, paramString);
  }
  
  public static void c(int paramInt, String paramString)
  {
    a("maskUinLoginResult", paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.QuickLoginReporter
 * JD-Core Version:    0.7.0.1
 */