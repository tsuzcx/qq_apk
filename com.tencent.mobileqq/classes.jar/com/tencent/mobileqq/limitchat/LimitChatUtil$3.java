package com.tencent.mobileqq.limitchat;

import arhg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

public final class LimitChatUtil$3
  implements Runnable
{
  public LimitChatUtil$3(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    arhg localarhg = (arhg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(127);
    if (localarhg != null) {
      localarhg.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.limitchat.LimitChatUtil.3
 * JD-Core Version:    0.7.0.1
 */