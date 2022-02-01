package com.tencent.mobileqq.kandian.repo.common;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJKanDianUserDataAladdinConfig;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyMedalInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONArray;

public class RIJUserInfoSp
{
  public static int a()
  {
    if ((RIJKanDianUserDataAladdinConfig.a.a() == 0) && (RIJKanDianUserDataAladdinConfig.a.b() == 0)) {
      return 0;
    }
    if (b() == 0) {
      return 1;
    }
    return 2;
  }
  
  public static void a(int paramInt)
  {
    RIJSPUtils.a("readinjoy_user_data_switch", Integer.valueOf(paramInt));
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    a(paramAppRuntime, "");
    QLog.d("RIJUserInfoSp", 1, "clearMedalInfo");
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2, List<SelfInfoModule.BusinessCountInfo> paramList)
  {
    SharedPreferences localSharedPreferences = RIJSPUtils.a(paramAppRuntime, true, true);
    if (localSharedPreferences == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianFollowAndFansCount() failed");
      return;
    }
    Object localObject = null;
    paramAppRuntime = (AppRuntime)localObject;
    if (paramList != null)
    {
      paramAppRuntime = (AppRuntime)localObject;
      if (paramList.size() > 0)
      {
        paramAppRuntime = new JSONArray();
        localObject = paramList.iterator();
        while (((Iterator)localObject).hasNext()) {
          paramAppRuntime.put(((SelfInfoModule.BusinessCountInfo)((Iterator)localObject).next()).a());
        }
        localObject = paramAppRuntime.toString();
        paramAppRuntime = (AppRuntime)localObject;
        if (QLog.isColorLevel())
        {
          paramAppRuntime = new StringBuilder();
          paramAppRuntime.append("updateKandianFollowAndFansCount followNum:");
          paramAppRuntime.append(paramInt1);
          paramAppRuntime.append(", userNickName:");
          paramAppRuntime.append(paramInt2);
          paramAppRuntime.append(", fansInfoList = ");
          paramAppRuntime.append(paramList.size());
          QLog.d("RIJUserInfoSp", 2, paramAppRuntime.toString());
          paramAppRuntime = (AppRuntime)localObject;
        }
      }
    }
    paramList = localSharedPreferences.edit();
    paramList.putInt("kandian_user_follow_count", paramInt1);
    paramList.putInt("kandian_user_fans_count", paramInt2);
    if (paramAppRuntime != null) {
      paramList.putString("kandian_user_fans_info_list", paramAppRuntime);
    }
    RIJSPUtils.a(paramList, true);
  }
  
  public static void a(AppRuntime paramAppRuntime, ReadInJoyMedalInfo paramReadInJoyMedalInfo)
  {
    if (paramAppRuntime == null)
    {
      QLog.d("RIJUserInfoSp", 1, "updateUserMedal error! app is null");
      return;
    }
    paramReadInJoyMedalInfo.e = "1";
    paramReadInJoyMedalInfo.f = "1";
    paramReadInJoyMedalInfo.h = RIJQQAppInterfaceUtil.a();
    paramReadInJoyMedalInfo = paramReadInJoyMedalInfo.a();
    if (TextUtils.isEmpty(paramReadInJoyMedalInfo)) {
      return;
    }
    a(paramAppRuntime, paramReadInJoyMedalInfo);
    QLog.d("RIJUserInfoSp", 1, "updateUserMedal");
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateUserMedal() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("kandian_user_medal", paramString);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2, String paramString3, long paramLong3)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateUserInfo() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    if (!TextUtils.isEmpty(paramString1)) {
      paramAppRuntime.putString("kandian_user_head_url", paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      paramAppRuntime.putString("kandian_user_nick_name", paramString2);
    }
    if (paramInt != -1) {
      paramAppRuntime.putInt("kandian_user_is_vip", paramInt);
    }
    if (paramLong1 >= 0L) {
      paramAppRuntime.putLong("kandian_user_total_like", paramLong1);
    }
    if (paramLong2 >= 0L) {
      paramAppRuntime.putLong("kandain_user_feeds_dynamic", paramLong2);
    }
    if (TextUtils.isEmpty(paramString3)) {
      paramString3 = "";
    }
    paramAppRuntime.putString("kandian_user_desc", paramString3);
    paramAppRuntime.putLong("kandain_user_signin_status", paramLong3);
    RIJSPUtils.a(paramAppRuntime, true);
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("updateUserInfo userHeadUrl:");
      paramAppRuntime.append(paramString1);
      paramAppRuntime.append(", userNickName:");
      paramAppRuntime.append(paramString2);
      paramAppRuntime.append(", userIsVip = ");
      paramAppRuntime.append(paramInt);
      QLog.d("RIJUserInfoSp", 2, paramAppRuntime.toString());
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("Q.readinjoy.tt_report", 1, "updateKandianSelfForbidden() failed");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("kandian_user_forbidden", paramBoolean);
    RIJSPUtils.a(paramAppRuntime, true);
  }
  
  public static int b()
  {
    return ((Integer)RIJSPUtils.a("readinjoy_user_data_switch", Integer.valueOf(0))).intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.common.RIJUserInfoSp
 * JD-Core Version:    0.7.0.1
 */