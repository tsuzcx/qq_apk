package com.tencent.mobileqq.servlet;

import axch;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.service.qzone.QZoneTitleTabManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;

public class QZoneManagerImp$2
  implements Runnable
{
  public QZoneManagerImp$2(axch paramaxch, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    boolean bool = true;
    int i = LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 1, this.a.getLongAccountUin());
    axch localaxch = this.this$0;
    if ((i & 0x80) != 0) {}
    for (;;)
    {
      localaxch.b(bool);
      QZoneTitleTabManager.a(this.a.getCurrentAccountUin());
      axch.a(this.this$0);
      axch.a(this.this$0, axch.b(this.this$0));
      if (QLog.isColorLevel()) {
        QLog.d("UndealCount.QZoneManagerImp.", 2, "QZoneManagerImp init notifyQQTab type:" + Long.toBinaryString(axch.a(this.this$0)));
      }
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneManagerImp.2
 * JD-Core Version:    0.7.0.1
 */