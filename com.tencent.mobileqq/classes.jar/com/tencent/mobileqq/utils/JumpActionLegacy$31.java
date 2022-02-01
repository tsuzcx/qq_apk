package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.ark.api.IArkConfig;
import com.tencent.mobileqq.ark.config.bean.ArkAIKeyWordConfBean;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class JumpActionLegacy$31
  implements ArkAppMgr.IGetAppPathByNameCallback
{
  JumpActionLegacy$31(JumpActionLegacy paramJumpActionLegacy, QQProgressDialog paramQQProgressDialog, String paramString1, String paramString2, String paramString3) {}
  
  public void onGetAppPathByName(int paramInt, String paramString, ArkAppMgr.AppPathInfo paramAppPathInfo)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((paramString != null) && (paramString.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    if ((paramAppPathInfo != null) && (paramInt == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, new Object[] { "Ark mqqapi://ligthapp/open goToLightAppOpen get path succeed, appPath: ", paramAppPathInfo.path });
      }
      Object localObject = null;
      paramString = this.jdField_a_of_type_JavaLangString;
      if (TextUtils.isEmpty(paramString))
      {
        paramAppPathInfo = ArkAppCacheMgr.getApplicationLauncher(paramAppPathInfo.path);
        if ((!TextUtils.isEmpty(paramAppPathInfo)) && ((paramAppPathInfo.startsWith("http://")) || (paramAppPathInfo.startsWith("https://"))))
        {
          localObject = paramString;
          paramInt = 0;
          paramString = paramAppPathInfo;
          paramAppPathInfo = (ArkAppMgr.AppPathInfo)localObject;
          break label132;
        }
        paramString = paramAppPathInfo;
      }
      paramInt = 1;
      paramAppPathInfo = paramString;
      paramString = (String)localObject;
      label132:
      String str = this.b;
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "{}";
      }
      if (paramInt != 0)
      {
        ArkAppDataReport.a(null, this.c, "FullScreenOrH5Show", 0, 0, 0L, 0L, 0L, "", "");
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsJumpActionLegacy.a != null) {
          ArkFullScreenAppActivity.a(this.jdField_a_of_type_ComTencentMobileqqUtilsJumpActionLegacy.a, this.c, paramAppPathInfo, "0.0.0.1", (String)localObject, ArkAppCenterUtil.a(), null, 1);
        }
      }
      else
      {
        paramAppPathInfo = new Intent();
        paramAppPathInfo.setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.QQBrowserDelegationActivity");
        paramAppPathInfo.putExtra("param_force_internal_browser", true);
        paramAppPathInfo.putExtra("url", paramString);
        paramAppPathInfo.putExtra("injectrecommend", false);
        paramAppPathInfo.putExtra("browserType", 3);
        if (!TextUtils.isEmpty(this.c))
        {
          paramAppPathInfo.putExtra("h5_ark_app_name", this.c);
          paramString = ArkAppMgr.getInstance().getAppPathFromLocal(this.c);
          if (!TextUtils.isEmpty(paramString))
          {
            paramAppPathInfo.putExtra("h5_ark_app_path", paramString);
            paramString = ArkAppCacheMgr.getApplicationDesc(this.c);
            if (!TextUtils.isEmpty(paramString)) {
              paramAppPathInfo.putExtra("h5_ark_app_des", paramString);
            }
          }
        }
        paramString = (ArkAIKeyWordConfBean)((IArkConfig)QRoute.api(IArkConfig.class)).loadConfig(ArkAIKeyWordConfBean.class);
        if (paramString != null)
        {
          paramString = paramString.a();
          if (!TextUtils.isEmpty(paramString)) {
            paramAppPathInfo.putExtra("h5_ark_check_config", paramString);
          }
        }
        paramAppPathInfo.addFlags(603979776);
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsJumpActionLegacy.a != null) {
          this.jdField_a_of_type_ComTencentMobileqqUtilsJumpActionLegacy.a.startActivity(paramAppPathInfo);
        }
      }
    }
    else
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqUtilsJumpActionLegacy.a, 2131690124, 0).a();
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "Ark mqqapi://ligthapp/open goToLightAppOpen appPath is null ");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpActionLegacy.31
 * JD-Core Version:    0.7.0.1
 */