package com.tencent.mobileqq.limitchat;

import aoeo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

public final class LimitChatUtil$2
  implements Runnable
{
  public LimitChatUtil$2(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    aoeo localaoeo = (aoeo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(127);
    if (localaoeo != null) {
      localaoeo.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.limitchat.LimitChatUtil.2
 * JD-Core Version:    0.7.0.1
 */