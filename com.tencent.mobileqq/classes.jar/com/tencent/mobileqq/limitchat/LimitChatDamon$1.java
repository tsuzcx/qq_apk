package com.tencent.mobileqq.limitchat;

import acvv;
import auyn;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class LimitChatDamon$1
  implements Runnable
{
  public LimitChatDamon$1(auyn paramauyn, String paramString, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    synchronized (this.this$0)
    {
      auyn.a(this.this$0, null);
      ??? = new SessionInfo();
      ((SessionInfo)???).curFriendUin = this.jdField_a_of_type_JavaLangString;
      ((SessionInfo)???).troopUin = this.jdField_a_of_type_JavaLangString;
      ((SessionInfo)???).curType = 1037;
      acvv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (SessionInfo)???);
      if (QLog.isColorLevel()) {
        QLog.d("LimitChatDamon", 2, "sendMessageReadConfirm , real send:" + this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.limitchat.LimitChatDamon.1
 * JD-Core Version:    0.7.0.1
 */