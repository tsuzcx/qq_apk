package com.tencent.mobileqq.leba.core.redtouch;

import android.os.Handler;
import atgy;
import avoh;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qphone.base.util.QLog;
import nan;

public class LebaSpecificRedTouch$1
  implements Runnable
{
  public LebaSpecificRedTouch$1(atgy paramatgy, QQAppInterface paramQQAppInterface, Handler paramHandler, RedTouch paramRedTouch, long paramLong) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    Object localObject = (nan)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(70);
    localObject = ((nan)localObject).a(((nan)localObject).a(), false);
    if (QLog.isColorLevel()) {
      QLog.d("nearby.redpoint", 2, "updateNearbyRedPointAsync, getNearbyRedPoint costTime=" + (System.currentTimeMillis() - l));
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new LebaSpecificRedTouch.1.1(this, (avoh)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.leba.core.redtouch.LebaSpecificRedTouch.1
 * JD-Core Version:    0.7.0.1
 */