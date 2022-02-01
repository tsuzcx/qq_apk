package com.tencent.mobileqq.extendfriend.utils;

import androidx.annotation.Nullable;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.config.ExtendFriendConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class ExpandReportUtils
{
  static {}
  
  public static String a()
  {
    ExtendFriendManager localExtendFriendManager = (ExtendFriendManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    if (localExtendFriendManager == null)
    {
      QLog.e("ExpandReportUtils", 1, "getDefaultReportParams but manager is null");
      return "";
    }
    return a(localExtendFriendManager);
  }
  
  private static String a(ExtendFriendManager paramExtendFriendManager)
  {
    ExtendFriendConfig localExtendFriendConfig = paramExtendFriendManager.a();
    String str = "";
    if (localExtendFriendConfig != null) {
      str = localExtendFriendConfig.a();
    }
    if (paramExtendFriendManager.f()) {
      return "homepage_new_boxlist-" + str;
    }
    if (paramExtendFriendManager.e() == 1) {
      return "homepage_old_meet-" + str;
    }
    return "homepage_old_school-" + str;
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
    for (;;)
    {
      ExtendFriendManager localExtendFriendManager = (ExtendFriendManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      if (localExtendFriendManager == null) {
        QLog.e("ExpandReportUtils", 1, "report but manager is null");
      }
      do
      {
        return;
        if (!paramMap.containsKey("manage_test_plan")) {
          paramMap.put("manage_test_plan", a(localExtendFriendManager));
        }
        if (!paramMap.containsKey("TAB_test_plan")) {
          paramMap.put("TAB_test_plan", localExtendFriendManager.a());
        }
        paramMap.put("uid", a(BaseApplicationImpl.getApplication().getRuntime()));
        UserAction.onUserActionToTunnel("0AND0Y11VZ3PFHQD", paramString, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2, paramBoolean3);
      } while (!QLog.isDevelopLevel());
      QLog.d("ExpandReportUtils", 4, "report " + paramString + " params:" + paramMap);
      return;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.utils.ExpandReportUtils
 * JD-Core Version:    0.7.0.1
 */