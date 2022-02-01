package com.tencent.mobileqq.extendfriend.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.biz.expand.utils.DateUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.config.ExpandConfigManager;
import com.tencent.mobileqq.extendfriend.config.ExtendFriendABTestConfig;
import com.tencent.mobileqq.extendfriend.config.ExtendFriendABTestConfig.ExtendFriendABJson;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import expand.network.ExtendFriendABTestConfig.GetTabTestInfoRsp;
import java.util.List;
import mqq.app.AppRuntime;

public class ExpandSharePreUtils
{
  public static int a(String paramString)
  {
    return SharedPreUtils.a(paramString, "extend_friend_config_785").getInt("sp_extend_friend_entry_add_friend", -1);
  }
  
  public static String a(String paramString)
  {
    return SharedPreUtils.g(paramString).getString("extend_friend_config_785_taskid", "");
  }
  
  public static void a(String paramString, int paramInt)
  {
    SharedPreUtils.a(paramString, "extend_friend_config_785").edit().putInt("sp_extend_friend_entry_add_friend", paramInt).apply();
  }
  
  public static void a(String paramString, long paramLong)
  {
    SharedPreUtils.g(paramString).edit().putString("extend_friend_ab_test_start_date", DateUtils.a.a(paramLong)).apply();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    paramString1 = SharedPreUtils.g(paramString1);
    if (paramString1 != null) {
      paramString1.edit().putString("extend_friend_config_785_taskid", paramString2).apply();
    }
  }
  
  public static boolean a(String paramString)
  {
    ExtendFriendManager localExtendFriendManager = (ExtendFriendManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    boolean bool = localExtendFriendManager.a().e();
    if (QLog.isColorLevel()) {
      QLog.i("ExpandSharePreUtils", 2, "check850SaveEmptyAIONode startLabSaveEmptyAIONode ： " + bool);
    }
    if (localExtendFriendManager.a(paramString) == 0) {}
    for (int i = 1; (bool) && (i != 0); i = 0) {
      return true;
    }
    return false;
  }
  
  public static boolean a(String paramString, ExtendFriendABTestConfig.GetTabTestInfoRsp paramGetTabTestInfoRsp, QQAppInterface paramQQAppInterface)
  {
    if ((paramGetTabTestInfoRsp == null) || (paramGetTabTestInfoRsp.grayPolicyInfoList == null) || (paramGetTabTestInfoRsp.grayPolicyInfoList.get() == null) || (paramGetTabTestInfoRsp.grayPolicyInfoList.get().size() == 0))
    {
      QLog.w("ExpandSharePreUtils", 2, "setABTestConfig return");
      return false;
    }
    SharedPreferences localSharedPreferences = SharedPreUtils.g(paramString);
    if (localSharedPreferences != null)
    {
      paramString = ExtendFriendABTestConfig.buildConfigJson(ExtendFriendABTestConfig.buildConfigList(paramGetTabTestInfoRsp.grayPolicyInfoList.get()));
      try
      {
        paramString = ExtendFriendABTestConfig.ExtendFriendABJson.getNoTimeStampGson().toJson(paramString);
        if (QLog.isColorLevel()) {
          QLog.i("ExpandSharePreUtils", 2, "setABTestConfig abTestJson ： " + paramString);
        }
        if (paramQQAppInterface != null)
        {
          paramGetTabTestInfoRsp = ((ExtendFriendManager)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a();
          if (paramGetTabTestInfoRsp != null)
          {
            paramGetTabTestInfoRsp.b(paramString);
            bool = true;
            localSharedPreferences.edit().putString("extend_friend_ab_test_config", paramString).apply();
            return bool;
          }
        }
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          QLog.w("ExpandSharePreUtils", 1, "setABTestConfig transform json failed ! ", paramString);
          paramString = ExtendFriendABTestConfig.ExtendFriendABJson.getEmptyJson();
          continue;
          boolean bool = false;
        }
      }
    }
    return false;
  }
  
  public static String b(String paramString)
  {
    return SharedPreUtils.g(paramString).getString("extend_friend_ab_test_config", ExtendFriendABTestConfig.ExtendFriendABJson.getEmptyJson());
  }
  
  public static boolean b(String paramString)
  {
    String str = SharedPreUtils.g(paramString).getString("extend_friend_ab_test_start_date", "");
    if (TextUtils.isEmpty(str))
    {
      QLog.w("ExpandSharePreUtils", 1, "account " + paramString + " first pull ab test info ");
      return false;
    }
    paramString = DateUtils.a.a(System.currentTimeMillis());
    boolean bool = str.equals(paramString);
    QLog.d("ExpandSharePreUtils", 1, "isABTestPullToday localDate " + str + " ,curDateStr " + paramString);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.utils.ExpandSharePreUtils
 * JD-Core Version:    0.7.0.1
 */