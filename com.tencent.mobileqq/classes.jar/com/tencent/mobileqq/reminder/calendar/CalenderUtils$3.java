package com.tencent.mobileqq.reminder.calendar;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;

class CalenderUtils$3
  implements QQPermissionCallback
{
  CalenderUtils$3(CalenderUtils paramCalenderUtils, Runnable paramRunnable, AppActivity paramAppActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.b(this.b, null, HardCodeUtil.a(2131887638));
    QLog.d("QQReminder.CalenderUtils", 1, "use deny permission");
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.c.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.reminder.calendar.CalenderUtils.3
 * JD-Core Version:    0.7.0.1
 */