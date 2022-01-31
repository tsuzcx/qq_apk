package com.tencent.mobileqq.limitchat;

import acjm;
import atls;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class LimitChatDamon$1
  implements Runnable
{
  public LimitChatDamon$1(atls paramatls, String paramString, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    synchronized (this.this$0)
    {
      atls.a(this.this$0, null);
      ??? = new SessionInfo();
      ((SessionInfo)???).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((SessionInfo)???).b = this.jdField_a_of_type_JavaLangString;
      ((SessionInfo)???).jdField_a_of_type_Int = 1037;
      acjm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (SessionInfo)???);
      if (QLog.isColorLevel()) {
        QLog.d("LimitChatDamon", 2, "sendMessageReadConfirm , real send:" + this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.limitchat.LimitChatDamon.1
 * JD-Core Version:    0.7.0.1
 */