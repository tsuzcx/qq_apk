package com.tencent.mobileqq.qqlive.util;

import android.app.Activity;
import android.os.Build.VERSION;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class QQLiveCommonUtil
{
  public static boolean a(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (((IQQFloatingPermission)QRoute.api(IQQFloatingPermission.class)).checkPermission(MobileQQ.sMobileQQ))
      {
        QLog.d("QQLiveCommonUtil", 1, "the floating ball permission is granted");
        return true;
      }
      QLog.i("QQLiveCommonUtil", 1, "show the permission dialog");
      if (paramActivity != null) {
        ((IQQFloatingPermission)QRoute.api(IQQFloatingPermission.class)).enterPermissionRequestDialog(paramActivity);
      } else {
        QLog.i("QQLiveCommonUtil", 1, "activity is null");
      }
      return false;
    }
    QLog.d("QQLiveCommonUtil", 1, "the system api is under 23, the permission is granted");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.util.QQLiveCommonUtil
 * JD-Core Version:    0.7.0.1
 */