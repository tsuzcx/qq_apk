package com.tencent.mobileqq.servlet;

import axcj;
import axcl;
import bgyp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

public class QZoneManagerImp$4
  implements Runnable
{
  public QZoneManagerImp$4(axcj paramaxcj, int paramInt) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("QZoneManagerImp..UndealCount", 2, "sendGetFeedByTime.click leba.nowtime: " + l + ",QZoneNotifyServlet.lastGetFeedTime: " + axcl.c + ",config interval:" + bgyp.a() + "difference: " + (l - axcl.c));
    }
    QQAppInterface localQQAppInterface;
    if (l - axcl.c > bgyp.a())
    {
      localQQAppInterface = axcj.a(this.this$0);
      if ((localQQAppInterface != null) && (localQQAppInterface.getApplication() != null)) {
        break label103;
      }
    }
    label103:
    do
    {
      return;
      NewIntent localNewIntent = new NewIntent(localQQAppInterface.getApplication(), axcl.class);
      localNewIntent.setAction("Qzone_Get_NewAndUnread_Count");
      localNewIntent.putExtra("qzone_send_by_time", this.a);
      localNewIntent.putExtra("scene", 103);
      localQQAppInterface.startServlet(localNewIntent);
    } while (!QLog.isColorLevel());
    QLog.d("QZoneManagerImp..UndealCount", 2, "sendGetFeedByTime.click leba.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneManagerImp.4
 * JD-Core Version:    0.7.0.1
 */