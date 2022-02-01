package com.tencent.mobileqq.studymode;

import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.QLog;

public class KidModeUtils
{
  public static String a(String paramString)
  {
    if (paramString == null) {
      return "null";
    }
    return String.valueOf(paramString.length());
  }
  
  public static void a(BaseActivity paramBaseActivity, String paramString, int paramInt)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      if (paramBaseActivity == null) {
        return;
      }
      String str = paramString;
      if (paramString.endsWith("\n")) {
        str = paramString.substring(0, paramString.length() - 1);
      }
      new QQToastNotifier(paramBaseActivity).notifyUser(str, paramBaseActivity.getTitleBarHeight(), 0, paramInt);
    }
  }
  
  public static void a(String paramString, QQAppInterface paramQQAppInterface)
  {
    QLog.d("KidModeUtils", 1, new Object[] { "call judge from=", paramString });
    if (paramQQAppInterface == null)
    {
      QLog.d("KidModeUtils", 2, "judgeAndShowUpgradeKidMode App=null");
      return;
    }
    if (!StudyModeManager.h())
    {
      QLog.d("KidModeUtils", 2, "judgeAndShowUpgradeKidMode Switch=OFF");
      c(paramQQAppInterface);
      return;
    }
    if (d(paramQQAppInterface))
    {
      QLog.d("KidModeUtils", 2, "hasShowUpgradeTipsAtVersion=true");
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new KidModeUtils.1(paramQQAppInterface));
  }
  
  private static void b(QQAppInterface paramQQAppInterface)
  {
    if (BaseActivity.sTopActivity == null)
    {
      QLog.d("KidModeUtils", 2, "showKidModeUpgradeDialog sTopActivity is null");
      return;
    }
    QQCustomDialog localQQCustomDialog = DialogUtil.a(BaseActivity.sTopActivity, 230, 2131624611, null, BaseApplicationImpl.sApplication.getString(2131916825), BaseApplicationImpl.sApplication.getString(2131916824), null, null, new KidModeUtils.2());
    if (!localQQCustomDialog.isShowing()) {
      localQQCustomDialog.show();
    }
    c(paramQQAppInterface);
  }
  
  public static void b(String paramString, QQAppInterface paramQQAppInterface)
  {
    QLog.d("KidModeUtils", 1, new Object[] { "call judge from=", paramString });
    if (!StudyModeManager.h())
    {
      QLog.d("KidModeUtils", 2, "manualSwitchMark Switch=OFF");
      return;
    }
    if (paramQQAppInterface == null)
    {
      QLog.d("KidModeUtils", 2, "manualSwitchMark App=null");
      return;
    }
    if (d(paramQQAppInterface))
    {
      QLog.d("KidModeUtils", 2, "hasShowUpgradeTipsAtVersion=true");
      return;
    }
    c(paramQQAppInterface);
  }
  
  private static void c(QQAppInterface paramQQAppInterface)
  {
    SharedPreUtils.a(BaseApplicationImpl.getContext(), "", true, "study_mode_upgrade_dialog_has_show1", Boolean.valueOf(true));
  }
  
  private static boolean d(QQAppInterface paramQQAppInterface)
  {
    return ((Boolean)SharedPreUtils.a(BaseApplicationImpl.getContext(), "", "study_mode_upgrade_dialog_has_show1", Boolean.valueOf(false))).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeUtils
 * JD-Core Version:    0.7.0.1
 */