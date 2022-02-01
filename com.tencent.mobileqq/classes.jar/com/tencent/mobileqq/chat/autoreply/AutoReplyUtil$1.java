package com.tencent.mobileqq.chat.autoreply;

import axvz;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForAutoReply;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Iterator;
import java.util.List;

public final class AutoReplyUtil$1
  implements Runnable
{
  public AutoReplyUtil$1(QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getMsgList(this.jdField_a_of_type_JavaLangString, 0);
    if (localObject == null) {}
    do
    {
      return;
      while (!((Iterator)localObject).hasNext()) {
        localObject = ((List)localObject).iterator();
      }
    } while (!((MessageRecord)((Iterator)localObject).next() instanceof MessageForAutoReply));
    axvz.a("0X800B0AD");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.chat.autoreply.AutoReplyUtil.1
 * JD-Core Version:    0.7.0.1
 */