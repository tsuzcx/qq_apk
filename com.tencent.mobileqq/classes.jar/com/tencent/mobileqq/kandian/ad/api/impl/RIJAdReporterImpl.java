package com.tencent.mobileqq.kandian.ad.api.impl;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdReporter;
import com.tencent.mobileqq.kandian.base.utils.api.IRIJRuntimeUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class RIJAdReporterImpl
  implements IRIJAdReporter
{
  private static final String TAG = "RIJAdReporterImpl";
  private static String chainId = "";
  private static String requestId = "";
  
  public void init(String paramString1, String paramString2)
  {
    requestId = paramString1;
    chainId = paramString2;
  }
  
  public void report(HashMap<String, String> paramHashMap, String paramString)
  {
    long l = System.currentTimeMillis();
    paramHashMap.put("ftime", new SimpleDateFormat("yyyyMMddHH").format(new Date(l)));
    paramHashMap.put("action_time", String.valueOf(l));
    paramHashMap.put("sysid", "kd");
    paramHashMap.put("user_id", BaseApplicationImpl.getApplication().getRuntime().getAccount());
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("report: ");
      localStringBuilder.append(paramHashMap.toString());
      QLog.d("RIJAdReporterImpl", 2, localStringBuilder.toString());
    }
    StatisticCollector.getInstance(((IRIJRuntimeUtils)QRoute.api(IRIJRuntimeUtils.class)).getAppRuntime().getApplicationContext()).collectPerformance("0DOU0ICZOF42AHNT", BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramString, true, 0L, 0L, paramHashMap, null);
  }
  
  public void reportAdShake(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ad_type", String.valueOf(1035));
    localHashMap.put("action", paramString1);
    localHashMap.put("expose_type", paramString2);
    localHashMap.put("expose_type_1", paramString3);
    localHashMap.put("play_type", paramString4);
    localHashMap.put("click_pos", paramString5);
    localHashMap.put("click_pos_1", paramString6);
    localHashMap.put("interact_type", paramString7);
    localHashMap.put("jump_mode", paramString8);
    localHashMap.put("request_id", requestId);
    localHashMap.put("chain_id", chainId);
    report(localHashMap, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.impl.RIJAdReporterImpl
 * JD-Core Version:    0.7.0.1
 */