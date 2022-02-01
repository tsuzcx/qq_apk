package com.tencent.mobileqq.servlet;

import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

class QZoneNotifyServlet$5
  implements Runnable
{
  QZoneNotifyServlet$5(QZoneNotifyServlet paramQZoneNotifyServlet) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QZone scheduled QZoneFeedTimeTask run. currentTime:");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.this$0.getAppRuntime();
    if (localObject == null) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(((AppRuntime)localObject).getApplication(), QZoneNotifyServlet.class);
    localNewIntent.setAction("Qzone_Get_NewAndUnread_Count");
    localNewIntent.putExtra("bNotWorkInBackGround", true);
    localNewIntent.putExtra("qzone_send_by_time", 4);
    ((AppRuntime)localObject).startServlet(localNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneNotifyServlet.5
 * JD-Core Version:    0.7.0.1
 */