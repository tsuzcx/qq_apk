package com.tencent.open.business.base.appreport;

import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.automator.AutomatorHelper;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.open.downloadnew.YybHandleUtil;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;

class AppReportReceiver$1
  implements Runnable
{
  AppReportReceiver$1(AppReportReceiver paramAppReportReceiver, Intent paramIntent, Context paramContext) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        str3 = this.jdField_a_of_type_AndroidContentIntent.getAction();
        if (str3 == null) {
          return;
        }
        bool1 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("android.intent.extra.REPLACING", false);
        str1 = this.jdField_a_of_type_AndroidContentIntent.getDataString();
        if ((str1 != null) && (str1.startsWith("package:")))
        {
          str4 = str1.substring(8);
          if ((BaseApplicationImpl.getApplication() == null) || (BaseApplicationImpl.getApplication().getFirstSimpleAccount() == null)) {
            break label273;
          }
          str1 = BaseApplicationImpl.getApplication().getFirstSimpleAccount().getUin();
          boolean bool2 = str3.equals("android.intent.action.PACKAGE_ADDED");
          if ((bool2) && (!bool1))
          {
            if (str4.equals("com.tencent.mobileqq"))
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("AppReportReceiver", 2, "mobileqq ACTION_PACKAGE_ADDED");
              return;
            }
            bool1 = str4.equals("com.tencent.android.qqdownloader");
            if (!bool1) {
              continue;
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
        String str3;
        boolean bool1;
        String str1;
        String str4;
        if (QLog.isColorLevel()) {
          QLog.d("crash", 2, "", localThrowable);
        }
      }
      try
      {
        StaticAnalyz.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), str1);
      }
      catch (Exception localException)
      {
        continue;
      }
      if ((str3.equals("android.intent.action.PACKAGE_REMOVED")) && (!bool1))
      {
        if (str4.equals("com.tencent.mobileqq"))
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("AppReportReceiver", 2, "mobileqq ACTION_PACKAGE_REMOVED");
        }
      }
      else
      {
        if ((!str3.equals("android.intent.action.PACKAGE_REPLACED")) || (!bool1)) {
          continue;
        }
        if (str4.equals("com.tencent.mobileqq"))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AppReportReceiver", 2, "mobileqq ACTION_PACKAGE_REPLACED deleteYYBApkPackage");
          }
          YybHandleUtil.a();
          return;
        }
      }
      if (AutomatorHelper.b)
      {
        if (QLog.isColorLevel()) {
          QLog.d("isFirstLaunch", 2, "firstlaunch!");
        }
        return;
      }
      return;
      label273:
      String str2 = "";
    }
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.business.base.appreport.AppReportReceiver.1
 * JD-Core Version:    0.7.0.1
 */