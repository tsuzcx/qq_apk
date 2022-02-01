package com.tencent.mobileqq.chat.autoreply;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForAutoReply;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import java.util.Iterator;
import java.util.List;

final class AutoReplyUtil$1
  implements Runnable
{
  AutoReplyUtil$1(QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_JavaLangString, 0);
    if (localObject == null) {
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((MessageRecord)((Iterator)localObject).next() instanceof MessageForAutoReply)) {
        ReportHelperKt.a("0X800B0AD");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.chat.autoreply.AutoReplyUtil.1
 * JD-Core Version:    0.7.0.1
 */