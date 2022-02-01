package com.tencent.mobileqq.util;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.DeviceManageConfBean;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class NoDisturbUtil
{
  private static int a = -1;
  
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      a = i;
      if (QLog.isColorLevel()) {
        QLog.d("NoDisturbUtil", 2, new Object[] { "setMuteStat:", Integer.valueOf(a) });
      }
      return;
    }
  }
  
  public static boolean a(Context paramContext)
  {
    int i = SettingCloneUtil.readValueForInt(paramContext, null, "no_disturb_mode", "qqsetting_nodisturb_mode_key", 2147483647);
    int j = (int)NetConnInfoCenter.getServerTime();
    if (QLog.isColorLevel()) {
      QLog.d("NoDisturbUtil", 4, "canDisturb curServerTime = [" + j + "] isNoDisturbMode=" + i);
    }
    return j <= i;
  }
  
  public static boolean a(Context paramContext, AppInterface paramAppInterface)
  {
    return (!a(paramContext)) || ((!paramAppInterface.isBackgroundPause) && (ReflectionUtil.a(BaseApplication.getContext())));
  }
  
  public static boolean b(Context paramContext, AppInterface paramAppInterface)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    DeviceManageConfBean localDeviceManageConfBean = (DeviceManageConfBean)QConfigManager.a().a(528);
    boolean bool1 = bool3;
    if ((paramAppInterface instanceof BaseQQAppInterface))
    {
      bool1 = bool3;
      if (localDeviceManageConfBean != null)
      {
        bool1 = bool3;
        if (localDeviceManageConfBean.a == 1)
        {
          if (a != -1) {
            break label87;
          }
          bool1 = SettingCloneUtil.readValue(paramContext, paramAppInterface.getCurrentAccountUin(), null, "qqsetting_qrlogin_set_mute", false);
          if (!bool1) {
            break label82;
          }
        }
      }
    }
    label82:
    for (int i = 1;; i = 0)
    {
      a = i;
      return bool1;
    }
    label87:
    if (a == 1) {}
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.NoDisturbUtil
 * JD-Core Version:    0.7.0.1
 */