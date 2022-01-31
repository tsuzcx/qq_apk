package com.tencent.mobileqq.matchchat;

import asfl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public final class MatchChatMsgUtil$1
  implements Runnable
{
  public MatchChatMsgUtil$1(QQAppInterface paramQQAppInterface, RedTouch paramRedTouch) {}
  
  public void run()
  {
    int i = asfl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("MatchChatMsgUtil", 2, "updateExtendFriendRedTouch() : " + i);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
      ThreadManager.getUIHandler().post(new MatchChatMsgUtil.1.1(this, i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.matchchat.MatchChatMsgUtil.1
 * JD-Core Version:    0.7.0.1
 */