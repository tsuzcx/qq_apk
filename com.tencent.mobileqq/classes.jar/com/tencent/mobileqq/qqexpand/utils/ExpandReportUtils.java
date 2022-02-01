package com.tencent.mobileqq.qqexpand.utils;

import androidx.annotation.Nullable;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qqexpand.config.ExpandConfig;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.statistics.QQUserAction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class ExpandReportUtils
{
  static {}
  
  public static String a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    paramBaseQQAppInterface = (IExpandManager)paramBaseQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    if (paramBaseQQAppInterface == null)
    {
      QLog.e("ExpandReportUtils", 1, "getDefaultReportParams but manager is null");
      return "";
    }
    return a(paramBaseQQAppInterface);
  }
  
  private static String a(IExpandManager paramIExpandManager)
  {
    paramIExpandManager = paramIExpandManager.t();
    if (paramIExpandManager != null) {
      paramIExpandManager = paramIExpandManager.getTestId();
    } else {
      paramIExpandManager = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("homepage_new_boxlist-");
    localStringBuilder.append(paramIExpandManager);
    return localStringBuilder.toString();
  }
  
  private static String a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return "";
    }
    return paramAppRuntime.getAccount();
  }
  
  public static void a()
  {
    UserAction.registerTunnel(new TunnelInfo("0AND0Y11VZ3PFHQD"));
    QLog.i("ExpandReportUtils", 1, "init expand tunnel");
  }
  
  public static void a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("frompage", paramString);
    a("app_launch#app_launch#none", true, localHashMap);
  }
  
  public static void a(String paramString, @Nullable HashMap<String, String> paramHashMap)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("frompage", paramString);
    if (paramHashMap != null) {
      localHashMap.putAll(paramHashMap);
    }
    a("click#all_page#entrance", true, localHashMap);
  }
  
  public static void a(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramMap == null) {
      paramMap = new HashMap();
    }
    Object localObject = (IExpandManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    if (localObject == null)
    {
      QLog.e("ExpandReportUtils", 1, "report but manager is null");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((IExpandManager)localObject).a());
    localStringBuilder.append("");
    paramMap.put("entry", localStringBuilder.toString());
    if (!paramMap.containsKey("manage_test_plan")) {
      paramMap.put("manage_test_plan", a((IExpandManager)localObject));
    }
    if (!paramMap.containsKey("TAB_test_plan")) {
      paramMap.put("TAB_test_plan", ((IExpandManager)localObject).f());
    }
    paramMap.put("uid", a(BaseApplicationImpl.getApplication().getRuntime()));
    QQUserAction.a("0AND0Y11VZ3PFHQD", paramString, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2, paramBoolean3);
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("report ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" params:");
      ((StringBuilder)localObject).append(paramMap);
      QLog.d("ExpandReportUtils", 4, ((StringBuilder)localObject).toString());
    }
  }
  
  public static void a(String paramString, boolean paramBoolean, Map<String, String> paramMap)
  {
    a(paramString, paramBoolean, -1L, -1L, paramMap, true, true);
  }
  
  public static void b(String paramString)
  {
    a(paramString, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.ExpandReportUtils
 * JD-Core Version:    0.7.0.1
 */