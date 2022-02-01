package com.tencent.mobileqq.doc;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.tendoc.TencentDocUserConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocUserConfigProcessor;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class TencentDocUtils
{
  public static void a(String paramString)
  {
    QLog.d("TencentDocUtils", 1, "WL_DEBUG reportClickEvent actionName = " + paramString);
    ReportController.b(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool = TencentDocPref.a(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount());
    if (!bool)
    {
      paramQQAppInterface = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(paramQQAppInterface, TempGetProfileDetailProcessor.class);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.getTencentDocSwitch();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TencentDocUtils", 1, "WL_DEBUG updateTencentDocUser isUser = " + bool);
    }
    return bool;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    paramQQAppInterface = paramQQAppInterface.getCurrentUin();
    paramBoolean = localBaseApplication.getSharedPreferences("call_tim_config_pre" + paramQQAppInterface, 0).getBoolean("call_tim_config_switch", false);
    paramQQAppInterface = TencentDocUserConfigProcessor.a().a();
    if (QLog.isColorLevel()) {
      QLog.d("TencentDocUtils", 2, "WL_DEBUG showInQQSettingMe enable = " + paramBoolean + ", isUser = " + false + ", userConfigMeURL = " + paramQQAppInterface);
    }
    return (!paramBoolean) && (paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doc.TencentDocUtils
 * JD-Core Version:    0.7.0.1
 */