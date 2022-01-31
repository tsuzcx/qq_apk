package com.tencent.mobileqq.servlet;

import axcl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class QZoneNotifyServlet$5
  implements Runnable
{
  public QZoneNotifyServlet$5(axcl paramaxcl) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 2, "QZone scheduled QZoneFeedTimeTask run. currentTime:" + System.currentTimeMillis());
    }
    AppRuntime localAppRuntime = this.this$0.getAppRuntime();
    if (localAppRuntime == null) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(localAppRuntime.getApplication(), axcl.class);
    localNewIntent.setAction("Qzone_Get_NewAndUnread_Count");
    localNewIntent.putExtra("bNotWorkInBackGround", true);
    localNewIntent.putExtra("qzone_send_by_time", 4);
    localAppRuntime.startServlet(localNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneNotifyServlet.5
 * JD-Core Version:    0.7.0.1
 */