package com.tencent.mobileqq.leba.core.redtouch;

import auxq;
import avod;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class LebaSpecificRedTouch$2
  implements Runnable
{
  public LebaSpecificRedTouch$2(auxq paramauxq, QQAppInterface paramQQAppInterface, RedTouch paramRedTouch, String paramString1, String paramString2, long paramLong) {}
  
  public void run()
  {
    int i = avod.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.LebaSpecificRedTouch", 2, "updateExtendFriendRedTouch() : " + i);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
      ThreadManager.getUIHandler().post(new LebaSpecificRedTouch.2.1(this, i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.core.redtouch.LebaSpecificRedTouch.2
 * JD-Core Version:    0.7.0.1
 */