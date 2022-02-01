package com.tencent.mobileqq.leba.business.redtouch;

import android.os.Handler;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.redtouch.INearbyRedInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;

class LebaSpecificRedTouchBiz$1
  implements Runnable
{
  LebaSpecificRedTouchBiz$1(LebaSpecificRedTouchBiz paramLebaSpecificRedTouchBiz, QQAppInterface paramQQAppInterface, Handler paramHandler, RedTouch paramRedTouch, long paramLong) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    Object localObject = (TroopRedTouchManager)this.a.getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
    localObject = ((TroopRedTouchManager)localObject).a(((TroopRedTouchManager)localObject).p(), false);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateNearbyRedPointAsync, getNearbyRedPoint costTime=");
      localStringBuilder.append(System.currentTimeMillis() - l);
      QLog.d("LebaSpecificRedTouchBiz", 2, localStringBuilder.toString());
    }
    this.b.post(new LebaSpecificRedTouchBiz.1.1(this, (INearbyRedInfo)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.redtouch.LebaSpecificRedTouchBiz.1
 * JD-Core Version:    0.7.0.1
 */