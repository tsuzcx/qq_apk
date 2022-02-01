package com.tencent.util;

import com.tencent.mobileqq.msf.core.push.BadgeUtilImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

final class BadgeUtils$2
  implements Runnable
{
  public void run()
  {
    try
    {
      if (!BadgeUtilImpl.isEnabled(MobileQQ.sMobileQQ))
      {
        BadgeUtilImpl.disableBadge(MobileQQ.sMobileQQ);
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("BadgeUtils", 2, "disableBadge mobileqq", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.util.BadgeUtils.2
 * JD-Core Version:    0.7.0.1
 */