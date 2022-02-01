package com.tencent.mobileqq.vas.qid;

import QQService.EVIPSPEC;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.qvip.QVipQidConfig;
import com.tencent.mobileqq.config.business.qvip.QVipQidProcessor;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class VipQidHelper
{
  public static String a = "VipQidHelper";
  
  public static void a(Activity paramActivity, ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject = new StringBuilder().append(QVipQidProcessor.c().a);
    if (paramProfileCardInfo != null) {}
    for (String str = "&from=icon";; str = "&from=set")
    {
      str = str;
      localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      Intent localIntent = new Intent(BaseApplicationImpl.getApplication(), QQBrowserActivity.class);
      localIntent.putExtra("uin", (String)localObject);
      localIntent.putExtra("url", str);
      localIntent.putExtra("hide_more_button", true);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      if (paramActivity != null) {
        paramActivity.startActivity(localIntent);
      }
      a("0X800B60D", paramProfileCardInfo);
      return;
    }
  }
  
  public static void a(AppInterface paramAppInterface, boolean paramBoolean)
  {
    if (paramAppInterface == null) {
      return;
    }
    paramAppInterface.getApp().getSharedPreferences("qq_vip_configs", 4).edit().putBoolean("qid_keyword_open", paramBoolean).apply();
  }
  
  public static void a(String paramString, int paramInt)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      ReportController.b((QQAppInterface)localAppRuntime, "dc00898", "", "", "", paramString, 0, 0, String.valueOf(paramInt), "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "QID_LOG,reportQIdEvent,entry:" + paramInt);
      }
    }
  }
  
  public static void a(String paramString, ProfileCardInfo paramProfileCardInfo)
  {
    if ((paramProfileCardInfo == null) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null)) {}
    do
    {
      return;
      localObject = BaseApplicationImpl.getApplication().getRuntime();
    } while (!(localObject instanceof QQAppInterface));
    Object localObject = (QQAppInterface)localObject;
    int i;
    label57:
    int j;
    if (TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d))
    {
      i = 1;
      if (!paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a.equals(((QQAppInterface)localObject).getCurrentAccountUin())) {
        break label179;
      }
      j = 1;
      label77:
      if (!paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.isVipOpen(EVIPSPEC.E_SP_SUPERVIP)) {
        break label184;
      }
    }
    label179:
    label184:
    for (int k = 1;; k = 0)
    {
      ReportController.b((AppRuntime)localObject, "dc00898", "", "", "", paramString, i, 0, String.valueOf(j), String.valueOf(k), "", "");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(a, 2, "QID_LOG,reportQIdEvent,fromType:" + i + " isOwner:" + j + " openVip:" + k);
      return;
      i = 2;
      break label57;
      j = 2;
      break label77;
    }
  }
  
  public static boolean a(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {
      return false;
    }
    return paramAppInterface.getApp().getSharedPreferences("qq_vip_configs", 4).getBoolean("qid_keyword_open", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qid.VipQidHelper
 * JD-Core Version:    0.7.0.1
 */