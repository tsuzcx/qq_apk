package com.tencent.mobileqq.startup.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;

final class SetSplash$9
  implements Runnable
{
  public void run()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    long l = localCalendar.getTimeInMillis();
    BaseApplicationImpl.getApplication().getSharedPreferences("banner_and_splash", 0).edit().putLong("splashshowtime", l).commit();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("显示了一个非默认闪屏时间是");
      localStringBuilder.append(localCalendar.toString());
      QLog.d("SetSplash", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.SetSplash.9
 * JD-Core Version:    0.7.0.1
 */