package com.tencent.mobileqq.forward;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ark.api.IArkVipReport;
import com.tencent.mobileqq.ark.vipreport.ArkVipSceneConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.model.AccountInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ForwardStatisticsReporter
{
  private static Map<String, Long> a = new HashMap();
  
  static {}
  
  static void a()
  {
    ArkVipSceneConfig localArkVipSceneConfig = new ArkVipSceneConfig();
    localArkVipSceneConfig.jdField_a_of_type_JavaLangString = "OpenShare";
    localArkVipSceneConfig.b = "KEY_STAGE_1_TOTAL";
    localArkVipSceneConfig.c = "KEY_STAGE_2_TOTAL";
    localArkVipSceneConfig.jdField_a_of_type_Long = 30000L;
    localArkVipSceneConfig.jdField_a_of_type_JavaUtilSet = new ForwardStatisticsReporter.1();
    ((IArkVipReport)QRoute.api(IArkVipReport.class)).initScene("OpenShare", localArkVipSceneConfig);
    localArkVipSceneConfig = new ArkVipSceneConfig();
    localArkVipSceneConfig.jdField_a_of_type_JavaLangString = "OpenLogin";
    localArkVipSceneConfig.b = "KEY_LOGIN_STAGE_1_TOTAL";
    localArkVipSceneConfig.c = "KEY_AUTHORITY_TOTAL";
    localArkVipSceneConfig.jdField_a_of_type_Long = 30000L;
    localArkVipSceneConfig.jdField_a_of_type_JavaUtilSet = new ForwardStatisticsReporter.2();
    ((IArkVipReport)QRoute.api(IArkVipReport.class)).initScene("OpenLogin", localArkVipSceneConfig);
  }
  
  public static void a(String paramString)
  {
    try
    {
      long l = System.currentTimeMillis();
      a.put(paramString, Long.valueOf(l));
      ((IArkVipReport)QRoute.api(IArkVipReport.class)).startSceneByEvent(paramString, l);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void a(String paramString, long paramLong)
  {
    try
    {
      Object localObject = (AppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (localObject == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("report == null key");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("ForwardStatisticsReporter", 1, ((StringBuilder)localObject).toString());
        return;
      }
      localObject = ((AppInterface)localObject).getCurrentAccountUin();
      QLog.d("ForwardStatisticsReporter", 1, new Object[] { paramString, "=", Long.valueOf(paramLong), ", uin=", AuthorityUtil.a((String)localObject) });
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance((String)localObject, paramString, true, paramLong, 0L, null, "", false);
      ((IArkVipReport)QRoute.api(IArkVipReport.class)).addEventToScene(paramString, true, paramLong, null);
      return;
    }
    finally {}
  }
  
  public static void a(String paramString, long paramLong, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    String str = ((AppInterface)BaseApplicationImpl.sApplication.getRuntime()).getCurrentAccountUin();
    QLog.d("ForwardStatisticsReporter", 1, new Object[] { "reportSaveImage key=", paramString, ",duration=", Long.valueOf(paramLong), ", uin=", AuthorityUtil.a(str) });
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(str, paramString, paramBoolean, paramLong, 0L, paramHashMap, "", false);
    ((IArkVipReport)QRoute.api(IArkVipReport.class)).addEventToScene(paramString, true, paramLong, paramHashMap);
  }
  
  public static void a(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_ERROR_CODE", Integer.toString(paramBundle.getInt("code")));
    localHashMap.put("param_error_ret", Integer.toString(paramBundle.getInt("ret")));
    a(paramString, localHashMap, paramBoolean);
  }
  
  public static void a(String paramString, AccountInfo paramAccountInfo)
  {
    try
    {
      a(paramString, paramAccountInfo, true);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void a(String paramString, AccountInfo paramAccountInfo, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    if (paramAccountInfo == null) {
      paramAccountInfo = "";
    } else {
      paramAccountInfo = paramAccountInfo.jdField_a_of_type_JavaLangString;
    }
    a(paramString, paramAccountInfo, paramHashMap, paramBoolean);
  }
  
  public static void a(String paramString, AccountInfo paramAccountInfo, boolean paramBoolean)
  {
    try
    {
      a(paramString, paramAccountInfo, null, paramBoolean);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void a(String paramString1, String paramString2, long paramLong, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    try
    {
      Object localObject = (Long)a.get(paramString1);
      if (localObject == null)
      {
        QLog.e("ForwardStatisticsReporter", 1, new Object[] { "report invalid key =", paramString1 });
        return;
      }
      a.remove(paramString1);
      paramLong -= ((Long)localObject).longValue();
      if ((paramHashMap != null) && (!paramHashMap.isEmpty()))
      {
        localObject = new StringBuilder();
        Iterator localIterator = paramHashMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          ((StringBuilder)localObject).append((String)localEntry.getKey());
          ((StringBuilder)localObject).append("=");
          ((StringBuilder)localObject).append((String)localEntry.getValue());
          ((StringBuilder)localObject).append(" ");
        }
        QLog.d("ForwardStatisticsReporter", 1, new Object[] { paramString1, "=", Long.valueOf(paramLong), ", uin=", AuthorityUtil.a(paramString2), ", params[", ((StringBuilder)localObject).toString(), "]" });
      }
      else
      {
        QLog.d("ForwardStatisticsReporter", 1, new Object[] { paramString1, "=", Long.valueOf(paramLong), ", uin=", AuthorityUtil.a(paramString2) });
      }
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(paramString2, paramString1, paramBoolean, paramLong, 0L, paramHashMap, "", false);
      ((IArkVipReport)QRoute.api(IArkVipReport.class)).addEventToScene(paramString1, paramBoolean, paramLong, paramHashMap);
      if ("KEY_STAGE_2_TOTAL".equals(paramString1)) {
        a.clear();
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString1;
    }
  }
  
  public static void a(String paramString1, String paramString2, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    try
    {
      a(paramString1, paramString2, System.currentTimeMillis(), paramHashMap, paramBoolean);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      a(paramString1, paramString2, null, paramBoolean);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public static void a(String paramString, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    try
    {
      a(paramString, ((AppInterface)BaseApplicationImpl.sApplication.getRuntime()).getCurrentAccountUin(), paramHashMap, paramBoolean);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    try
    {
      a(paramString, ((AppInterface)BaseApplicationImpl.sApplication.getRuntime()).getCurrentAccountUin(), paramBoolean);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void b()
  {
    try
    {
      a.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void b(String paramString)
  {
    try
    {
      a(paramString, true);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardStatisticsReporter
 * JD-Core Version:    0.7.0.1
 */