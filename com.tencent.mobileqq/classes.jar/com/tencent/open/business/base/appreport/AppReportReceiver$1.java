package com.tencent.open.business.base.appreport;

import android.content.Context;
import android.content.Intent;
import bdjc;
import bdlz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;

class AppReportReceiver$1
  implements Runnable
{
  AppReportReceiver$1(AppReportReceiver paramAppReportReceiver, Intent paramIntent, Context paramContext) {}
  
  public void run()
  {
    try
    {
      str2 = this.jdField_a_of_type_AndroidContentIntent.getAction();
      if (str2 == null) {
        return;
      }
      bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("android.intent.extra.REPLACING", false);
      Object localObject = this.jdField_a_of_type_AndroidContentIntent.getDataString();
      if ((localObject != null) && (((String)localObject).startsWith("package:")))
      {
        str3 = ((String)localObject).substring(8);
        String str1 = "";
        localObject = str1;
        if (BaseApplicationImpl.getApplication() != null)
        {
          localObject = str1;
          if (BaseApplicationImpl.getApplication().getFirstSimpleAccount() != null) {
            localObject = BaseApplicationImpl.getApplication().getFirstSimpleAccount().getUin();
          }
        }
        if ((str2.equals("android.intent.action.PACKAGE_ADDED")) && (!bool)) {
          if (str3.equals("com.tencent.mobileqq"))
          {
            if (!QLog.isColorLevel()) {
              return;
            }
            QLog.d("AppReportReceiver", 2, "mobileqq ACTION_PACKAGE_ADDED");
            return;
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      String str2;
      boolean bool;
      String str3;
      if (QLog.isColorLevel())
      {
        QLog.d("crash", 2, "", localThrowable);
        return;
        bool = str3.equals("com.tencent.android.qqdownloader");
        if (bool) {}
        try
        {
          bdjc.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), localThrowable);
          label166:
          while ((BaseApplicationImpl.isCurrentVersionFirstLaunch) && (QLog.isColorLevel()))
          {
            QLog.d("isFirstLaunch", 2, "firstlaunch!");
            return;
            if ((str2.equals("android.intent.action.PACKAGE_REMOVED")) && (!bool))
            {
              if (str3.equals("com.tencent.mobileqq")) {
                if (QLog.isColorLevel()) {
                  QLog.d("AppReportReceiver", 2, "mobileqq ACTION_PACKAGE_REMOVED");
                }
              }
            }
            else if ((str2.equals("android.intent.action.PACKAGE_REPLACED")) && (bool)) {
              if (str3.equals("com.tencent.mobileqq"))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("AppReportReceiver", 2, "mobileqq ACTION_PACKAGE_REPLACED deleteYYBApkPackage");
                }
                bdlz.a();
                return;
              }
            }
          }
        }
        catch (Exception localException)
        {
          break label166;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.open.business.base.appreport.AppReportReceiver.1
 * JD-Core Version:    0.7.0.1
 */