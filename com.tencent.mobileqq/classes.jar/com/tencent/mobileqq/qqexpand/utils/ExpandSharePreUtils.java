package com.tencent.mobileqq.qqexpand.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qqexpand.manager.config.ExtendFriendABTestConfig;
import com.tencent.mobileqq.qqexpand.manager.config.ExtendFriendABTestConfig.ExtendFriendABJson;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import expand.network.ExtendFriendABTestConfig.GetTabTestInfoRsp;
import java.util.List;
import mqq.app.AppRuntime;

public class ExpandSharePreUtils
{
  public static String a(String paramString)
  {
    return SharedPreUtils.g(paramString).getString("extend_friend_config_785_taskid", "");
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    paramString1 = SharedPreUtils.g(paramString1);
    paramString1.edit().putInt("expand_greet_limit_code", paramInt).apply();
    paramString1.edit().putString("expand_greet_limit_string", paramString2).apply();
    paramString1.edit().putLong("expand_greet_limit_time", System.currentTimeMillis()).apply();
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
  
  public static void a(String paramString, boolean paramBoolean)
  {
    SharedPreUtils.g(paramString).edit().putBoolean("extend_friend_is_pull_user_category", paramBoolean).apply();
  }
  
  public static boolean a(String paramString, ExtendFriendABTestConfig.GetTabTestInfoRsp paramGetTabTestInfoRsp, QQAppInterface paramQQAppInterface)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if ((paramGetTabTestInfoRsp != null) && (paramGetTabTestInfoRsp.grayPolicyInfoList != null) && (paramGetTabTestInfoRsp.grayPolicyInfoList.get() != null) && (paramGetTabTestInfoRsp.grayPolicyInfoList.get().size() != 0))
    {
      SharedPreferences localSharedPreferences = SharedPreUtils.g(paramString);
      if (localSharedPreferences != null)
      {
        paramString = ExtendFriendABTestConfig.buildConfigJson(ExtendFriendABTestConfig.buildConfigList(paramGetTabTestInfoRsp.grayPolicyInfoList.get()));
        try
        {
          paramString = ExtendFriendABTestConfig.ExtendFriendABJson.getNoTimeStampGson().toJson(paramString);
        }
        catch (Throwable paramString)
        {
          QLog.w("ExpandSharePreUtils", 1, "setABTestConfig transform json failed ! ", paramString);
          paramString = ExtendFriendABTestConfig.ExtendFriendABJson.getEmptyJson();
        }
        if (QLog.isColorLevel())
        {
          paramGetTabTestInfoRsp = new StringBuilder();
          paramGetTabTestInfoRsp.append("setABTestConfig abTestJson ： ");
          paramGetTabTestInfoRsp.append(paramString);
          QLog.i("ExpandSharePreUtils", 2, paramGetTabTestInfoRsp.toString());
        }
        bool1 = bool2;
        if (paramQQAppInterface != null)
        {
          ((IExpandManager)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).c(paramString);
          bool1 = true;
        }
        localSharedPreferences.edit().putString("extend_friend_ab_test_config", paramString).apply();
      }
      return bool1;
    }
    QLog.w("ExpandSharePreUtils", 2, "setABTestConfig return");
    return false;
  }
  
  public static int b(String paramString)
  {
    return SharedPreUtils.a(paramString, "extend_friend_config_785").getInt("sp_extend_friend_entry_add_friend", -1);
  }
  
  public static void b(String paramString, long paramLong)
  {
    SharedPreUtils.g(paramString).edit().putLong("extend_friend_pull_user_category_interval", paramLong).apply();
  }
  
  public static String c(String paramString)
  {
    return SharedPreUtils.g(paramString).getString("extend_friend_ab_test_config", ExtendFriendABTestConfig.ExtendFriendABJson.getEmptyJson());
  }
  
  public static boolean d(String paramString)
  {
    IExpandManager localIExpandManager = (IExpandManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    boolean bool = localIExpandManager.ac();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("check850SaveEmptyAIONode startLabSaveEmptyAIONode ： ");
      localStringBuilder.append(bool);
      QLog.i("ExpandSharePreUtils", 2, localStringBuilder.toString());
    }
    int i;
    if (localIExpandManager.f(paramString) == 0) {
      i = 1;
    } else {
      i = 0;
    }
    return (bool) && (i != 0);
  }
  
  public static boolean e(String paramString)
  {
    Object localObject = SharedPreUtils.g(paramString).getString("extend_friend_ab_test_start_date", "");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("account ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" first pull ab test info ");
      QLog.w("ExpandSharePreUtils", 1, ((StringBuilder)localObject).toString());
      return false;
    }
    paramString = DateUtils.a.a(System.currentTimeMillis());
    boolean bool = ((String)localObject).equals(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isABTestPullToday localDate ");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" ,curDateStr ");
    localStringBuilder.append(paramString);
    QLog.d("ExpandSharePreUtils", 1, localStringBuilder.toString());
    return bool;
  }
  
  public static boolean f(String paramString)
  {
    long l = SharedPreUtils.g(paramString).getLong("extend_friend_pull_user_category_interval", 0L);
    if (l == 0L) {
      return true;
    }
    return System.currentTimeMillis() - l >= 7200000L;
  }
  
  public static int g(String paramString)
  {
    return SharedPreUtils.g(paramString).getInt("expand_greet_limit_code", 0);
  }
  
  public static String h(String paramString)
  {
    return SharedPreUtils.g(paramString).getString("expand_greet_limit_string", "");
  }
  
  public static long i(String paramString)
  {
    return SharedPreUtils.g(paramString).getLong("expand_greet_limit_time", 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.ExpandSharePreUtils
 * JD-Core Version:    0.7.0.1
 */