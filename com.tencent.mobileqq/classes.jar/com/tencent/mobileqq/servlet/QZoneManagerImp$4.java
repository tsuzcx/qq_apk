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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendGetFeedByTime.click leba.nowtime: ");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append(",QZoneNotifyServlet.lastGetFeedTime: ");
      ((StringBuilder)localObject).append(QZoneNotifyServlet.c);
      ((StringBuilder)localObject).append(",config interval:");
      ((StringBuilder)localObject).append(QZoneHelper.getUpdateCountIntervalWhenClickFeedTab());
      ((StringBuilder)localObject).append("difference: ");
      ((StringBuilder)localObject).append(l - QZoneNotifyServlet.c);
      QLog.d("QZoneManagerImp..UndealCount", 2, ((StringBuilder)localObject).toString());
    }
    if (l - QZoneNotifyServlet.c > QZoneHelper.getUpdateCountIntervalWhenClickFeedTab())
    {
      localObject = QZoneManagerImp.d(this.this$0);
      if (localObject != null)
      {
        if (((QQAppInterface)localObject).getApplication() == null) {
          return;
        }
        NewIntent localNewIntent = new NewIntent(((QQAppInterface)localObject).getApplication(), QZoneNotifyServlet.class);
        localNewIntent.setAction("Qzone_Get_NewAndUnread_Count");
        localNewIntent.putExtra("qzone_send_by_time", this.a);
        localNewIntent.putExtra("scene", 103);
        ((QQAppInterface)localObject).startServlet(localNewIntent);
        if (QLog.isColorLevel()) {
          QLog.d("QZoneManagerImp..UndealCount", 2, "sendGetFeedByTime.click leba.");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneManagerImp.4
 * JD-Core Version:    0.7.0.1
 */