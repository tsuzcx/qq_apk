package com.tencent.util;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.push.BadgeUtilImpl;
import com.tencent.qphone.base.util.QLog;

public final class BadgeUtils$2
  implements Runnable
{
  public void run()
  {
    try
    {
      if (!BadgeUtilImpl.isEnabled(BaseApplicationImpl.sApplication)) {
        BadgeUtilImpl.disableBadge(BaseApplicationImpl.sApplication);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("BadgeUtils", 2, "disableBadge mobileqq", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.util.BadgeUtils.2
 * JD-Core Version:    0.7.0.1
 */