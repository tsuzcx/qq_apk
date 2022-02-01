package com.tencent.mobileqq.statistics;

import android.text.TextUtils;
import com.tencent.beacon.event.open.BeaconConfig;
import com.tencent.beacon.event.open.BeaconConfig.Builder;
import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.BeaconEvent.Builder;
import com.tencent.beacon.event.open.BeaconReport;
import com.tencent.beacon.event.open.EventResult;
import com.tencent.beacon.event.open.EventType;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class QQBeaconReport
{
  private static final AtomicBoolean a = new AtomicBoolean(false);
  
  public static void a()
  {
    b("");
  }
  
  private static void a(EventResult paramEventResult)
  {
    if ((!paramEventResult.isSuccess()) && (paramEventResult.errorCode != 101) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("EventResult{ eventID:");
      localStringBuilder.append(paramEventResult.eventID);
      localStringBuilder.append(", errorCode: ");
      localStringBuilder.append(paramEventResult.errorCode);
      localStringBuilder.append(", errorMsg: ");
      localStringBuilder.append(paramEventResult.errMsg);
      localStringBuilder.append("}");
      QLog.d("QQBeaconReport", 2, localStringBuilder.toString());
    }
  }
  
  public static void a(String paramString)
  {
    a("", paramString);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, new HashMap());
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, Map<String, String> paramMap, boolean paramBoolean2)
  {
    c(paramString1, paramString2, paramString3, paramBoolean1, paramMap, paramBoolean2);
  }
  
  public static void a(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    a(paramString1, paramString2, paramMap, false);
  }
  
  public static void a(String paramString1, String paramString2, Map<String, String> paramMap, boolean paramBoolean)
  {
    a(paramString1, paramString2, true, paramMap, paramBoolean);
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean1, Map<String, String> paramMap, boolean paramBoolean2)
  {
    c("", paramString1, paramString2, paramBoolean1, paramMap, paramBoolean2);
  }
  
  private static boolean a()
  {
    return false;
  }
  
  private static void b()
  {
    QQBeaconReport.2 local2 = new QQBeaconReport.2();
    BeaconReport.getInstance().setLogger(local2);
  }
  
  public static void b(String paramString)
  {
    if (a.compareAndSet(false, true))
    {
      BaseApplication localBaseApplication = BaseApplication.getContext();
      BeaconConfig localBeaconConfig = BeaconConfig.builder().auditEnable(false).setNormalPollingTime(30000L).qmspEnable(false).build();
      BeaconReport localBeaconReport = BeaconReport.getInstance();
      if (a())
      {
        localBeaconReport.setLogAble(true);
        b();
      }
      else
      {
        localBeaconReport.setLogAble(false);
      }
      localBeaconReport.setChannelID(AppSetting.c());
      if (!TextUtils.isEmpty(paramString)) {
        localBeaconReport.setAppVersion(paramString);
      }
      localBeaconReport.start(localBaseApplication, "0S200MNJT807V3GE", localBeaconConfig);
      QLog.d("QQBeaconReport", 1, new Object[] { "start: isDebugVersion = ", Boolean.valueOf(false) });
    }
  }
  
  public static void c(String paramString)
  {
    QLog.d("QQBeaconReport", 1, new Object[] { "setUserId = ", paramString });
    BeaconReport.getInstance().setUserID(paramString);
  }
  
  private static void c(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, Map<String, String> paramMap, boolean paramBoolean2)
  {
    if (UiThreadUtil.a())
    {
      ThreadManagerV2.excute(new QQBeaconReport.1(paramString1, paramString2, paramString3, paramBoolean1, paramMap, paramBoolean2), 16, null, false);
      return;
    }
    d(paramString1, paramString2, paramString3, paramBoolean1, paramMap, paramBoolean2);
  }
  
  private static void d(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, Map<String, String> paramMap, boolean paramBoolean2)
  {
    if (!TextUtils.isEmpty(paramString3))
    {
      BeaconEvent.Builder localBuilder = BeaconEvent.builder();
      if (!TextUtils.isEmpty(paramString1)) {
        localBuilder.withAppKey(paramString1);
      }
      paramString1 = paramMap;
      if (paramMap == null) {
        paramString1 = new HashMap();
      }
      if (!TextUtils.isEmpty(paramString2)) {
        paramString1.put("user_uin", paramString2);
      }
      localBuilder.withCode(paramString3);
      localBuilder.withIsSucceed(paramBoolean1);
      if (paramBoolean2) {
        localBuilder.withType(EventType.REALTIME);
      }
      localBuilder.withParams(paramString1);
      paramString1 = localBuilder.build();
      a(BeaconReport.getInstance().report(paramString1));
      return;
    }
    throw new RuntimeException("report a event with a empty key!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.QQBeaconReport
 * JD-Core Version:    0.7.0.1
 */