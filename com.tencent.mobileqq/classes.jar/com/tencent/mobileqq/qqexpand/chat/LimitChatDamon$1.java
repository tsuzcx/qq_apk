package com.tencent.mobileqq.qqexpand.chat;

import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class LimitChatDamon$1
  implements Runnable
{
  LimitChatDamon$1(LimitChatDamon paramLimitChatDamon, String paramString, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    synchronized (this.this$0)
    {
      LimitChatDamon.a(this.this$0, null);
      ??? = new SessionInfo();
      String str = this.jdField_a_of_type_JavaLangString;
      ((SessionInfo)???).jdField_a_of_type_JavaLangString = str;
      ((SessionInfo)???).b = str;
      ((SessionInfo)???).jdField_a_of_type_Int = 1044;
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BaseSessionInfo)???);
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("sendMessageReadConfirm , real send:");
        ((StringBuilder)???).append(this.jdField_a_of_type_JavaLangString);
        QLog.d("LimitChatDamon", 2, ((StringBuilder)???).toString());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.chat.LimitChatDamon.1
 * JD-Core Version:    0.7.0.1
 */