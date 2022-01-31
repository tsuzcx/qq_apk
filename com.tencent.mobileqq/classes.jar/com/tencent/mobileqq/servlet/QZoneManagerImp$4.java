package com.tencent.mobileqq.servlet;

import axch;
import axcj;
import bgxy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

public class QZoneManagerImp$4
  implements Runnable
{
  public QZoneManagerImp$4(axch paramaxch, int paramInt) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("QZoneManagerImp..UndealCount", 2, "sendGetFeedByTime.click leba.nowtime: " + l + ",QZoneNotifyServlet.lastGetFeedTime: " + axcj.c + ",config interval:" + bgxy.a() + "difference: " + (l - axcj.c));
    }
    QQAppInterface localQQAppInterface;
    if (l - axcj.c > bgxy.a())
    {
      localQQAppInterface = axch.a(this.this$0);
      if ((localQQAppInterface != null) && (localQQAppInterface.getApplication() != null)) {
        break label103;
      }
    }
    label103:
    do
    {
      return;
      NewIntent localNewIntent = new NewIntent(localQQAppInterface.getApplication(), axcj.class);
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