package com.tencent.mobileqq.servlet;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import mqq.app.NewIntent;

class QZoneManagerImp$4
  implements Runnable
{
  QZoneManagerImp$4(QZoneManagerImp paramQZoneManagerImp, int paramInt) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("QZoneManagerImp..UndealCount", 2, "sendGetFeedByTime.click leba.nowtime: " + l + ",QZoneNotifyServlet.lastGetFeedTime: " + QZoneNotifyServlet.c + ",config interval:" + QZoneHelper.getUpdateCountIntervalWhenClickFeedTab() + "difference: " + (l - QZoneNotifyServlet.c));
    }
    QQAppInterface localQQAppInterface;
    if (l - QZoneNotifyServlet.c > QZoneHelper.getUpdateCountIntervalWhenClickFeedTab())
    {
      localQQAppInterface = QZoneManagerImp.a(this.this$0);
      if ((localQQAppInterface != null) && (localQQAppInterface.getApplication() != null)) {
        break label103;
      }
    }
    label103:
    do
    {
      return;
      NewIntent localNewIntent = new NewIntent(localQQAppInterface.getApplication(), QZoneNotifyServlet.class);
      localNewIntent.setAction("Qzone_Get_NewAndUnread_Count");
      localNewIntent.putExtra("qzone_send_by_time", this.a);
      localNewIntent.putExtra("scene", 103);
      localQQAppInterface.startServlet(localNewIntent);
    } while (!QLog.isColorLevel());
    QLog.d("QZoneManagerImp..UndealCount", 2, "sendGetFeedByTime.click leba.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneManagerImp.4
 * JD-Core Version:    0.7.0.1
 */