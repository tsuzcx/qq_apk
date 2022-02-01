package com.tencent.mobileqq.servlet;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.service.qzone.QZoneTitleTabManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;

class QZoneManagerImp$2
  implements Runnable
{
  QZoneManagerImp$2(QZoneManagerImp paramQZoneManagerImp, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    long l = this.a.getLongAccountUin();
    boolean bool = true;
    int i = LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 1, l);
    Object localObject = this.this$0;
    if ((i & 0x80) == 0) {
      bool = false;
    }
    ((QZoneManagerImp)localObject).b(bool);
    QZoneTitleTabManager.a(this.a.getCurrentAccountUin());
    QZoneManagerImp.b(this.this$0);
    localObject = this.this$0;
    QZoneManagerImp.a((QZoneManagerImp)localObject, QZoneManagerImp.c((QZoneManagerImp)localObject));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QZoneManagerImp init notifyQQTab type:");
      ((StringBuilder)localObject).append(Long.toBinaryString(QZoneManagerImp.a(this.this$0)));
      QLog.d("UndealCount.QZoneManagerImp.", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneManagerImp.2
 * JD-Core Version:    0.7.0.1
 */