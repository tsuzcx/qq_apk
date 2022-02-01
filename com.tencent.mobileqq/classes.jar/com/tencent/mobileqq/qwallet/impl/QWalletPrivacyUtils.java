package com.tencent.mobileqq.qwallet.impl;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletPreferenceApi;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class QWalletPrivacyUtils
{
  private static void a(QBaseActivity paramQBaseActivity, String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("title", paramString1);
    localIntent.putExtra("content", paramString2);
    localIntent.putExtra("background", paramString3);
    QPublicFragmentActivity.Launcher.a(paramQBaseActivity, localIntent, QPublicTransFragmentActivity.class, QWalletPrivacyFragment.class);
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null)
    {
      ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).putBoolean(paramAppRuntime.getAccount(), "privacy_has_click_agree", true);
      paramAppRuntime = (IQWalletConfigService)paramAppRuntime.getRuntimeService(IQWalletConfigService.class, "");
      if (paramAppRuntime != null)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("1", "1");
        paramAppRuntime.setConfigSession(localHashMap);
      }
    }
  }
  
  public static boolean a(QBaseActivity paramQBaseActivity, BaseQQAppInterface paramBaseQQAppInterface)
  {
    if (paramBaseQQAppInterface != null)
    {
      if (paramQBaseActivity == null) {
        return false;
      }
      boolean bool = ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).getBoolean(paramBaseQQAppInterface.getCurrentUin(), "privacy_has_click_agree", false);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("hasClickAgree");
        ((StringBuilder)localObject).append(bool);
        QLog.i("QWalletPrivacyUtils", 2, ((StringBuilder)localObject).toString());
      }
      if (bool) {
        return false;
      }
      Object localObject = (IQWalletConfigService)paramBaseQQAppInterface.getRuntimeService(IQWalletConfigService.class, "");
      if (localObject != null)
      {
        int i;
        if (((IQWalletConfigService)localObject).getInt("privacy", 0, new String[] { "switch" }) == 1) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          if (((IQWalletConfigService)localObject).getInt("session", 0, new String[] { "1" }) == 1) {
            i = 1;
          } else {
            i = 0;
          }
          if (i != 0)
          {
            ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).putBoolean(paramBaseQQAppInterface.getAccount(), "privacy_has_click_agree", true);
            return false;
          }
          paramBaseQQAppInterface = ((IQWalletConfigService)localObject).getString("privacy", "", new String[] { "title" });
          String str = ((IQWalletConfigService)localObject).getString("privacy", "", new String[] { "content" });
          if ((!TextUtils.isEmpty(paramBaseQQAppInterface)) && (!TextUtils.isEmpty(str)))
          {
            a(paramQBaseActivity, paramBaseQQAppInterface, str, ((IQWalletConfigService)localObject).getString("privacy", "https://i.gtimg.cn/channel/imglib/201802/upload_895b44a9069ca68cb5c84439c7e1d2aa.jpg", new String[] { "background" }));
            return true;
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.impl.QWalletPrivacyUtils
 * JD-Core Version:    0.7.0.1
 */