package com.tencent.mobileqq.servlet;

import ayxn;
import ayxp;
import bizm;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

public class QZoneManagerImp$4
  implements Runnable
{
  public QZoneManagerImp$4(ayxn paramayxn, int paramInt) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("QZoneManagerImp..UndealCount", 2, "sendGetFeedByTime.click leba.nowtime: " + l + ",QZoneNotifyServlet.lastGetFeedTime: " + ayxp.c + ",config interval:" + bizm.a() + "difference: " + (l - ayxp.c));
    }
    QQAppInterface localQQAppInterface;
    if (l - ayxp.c > bizm.a())
    {
      localQQAppInterface = ayxn.a(this.this$0);
      if ((localQQAppInterface != null) && (localQQAppInterface.getApplication() != null)) {
        break label103;
      }
    }
    label103:
    do
    {
      return;
      NewIntent localNewIntent = new NewIntent(localQQAppInterface.getApplication(), ayxp.class);
      localNewIntent.setAction("Qzone_Get_NewAndUnread_Count");
      localNewIntent.putExtra("qzone_send_by_time", this.a);
      localNewIntent.putExtra("scene", 103);
      localQQAppInterface.startServlet(localNewIntent);
    } while (!QLog.isColorLevel());
    QLog.d("QZoneManagerImp..UndealCount", 2, "sendGetFeedByTime.click leba.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneManagerImp.4
 * JD-Core Version:    0.7.0.1
 */