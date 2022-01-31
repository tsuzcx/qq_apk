package com.tencent.mobileqq.servlet;

import ampk;
import android.os.Build.VERSION;
import azby;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;

public final class QZoneNotifyServlet$4
  implements Runnable
{
  public void run()
  {
    if ((Build.VERSION.SDK_INT < 23) || (BaseApplication.getContext() == null) || (BaseApplication.getContext().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0)) {
      try
      {
        azby.a(System.currentTimeMillis());
        ampk.a(azby.a());
        return;
      }
      catch (Exception localException)
      {
        QLog.e("Q.lebatab.UndealCount.QZoneNotifyServlet", 1, "locate exception " + localException);
        return;
      }
    }
    QZLog.w("QZLog", "定位有版本或权限限制");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneNotifyServlet.4
 * JD-Core Version:    0.7.0.1
 */