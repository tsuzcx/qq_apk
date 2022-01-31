package com.tencent.mobileqq.limitchat;

import aspy;
import atlt;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public final class LimitChatUtil$1
  implements Runnable
{
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatUtil", 2, "clearAioCacheAndDBMsg start");
    }
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long).iterator();
    while (localIterator.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      if (atlt.b(localChatMessage)) {
        if (-4023 == localChatMessage.msgtype) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, localChatMessage.msgtype, localChatMessage.uniseq);
        } else if ((localChatMessage.isSend()) && (localChatMessage.extraflag == 32768)) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, localChatMessage.uniseq);
        } else if (((localChatMessage instanceof MessageForUniteGrayTip)) && (atlt.a(((MessageForUniteGrayTip)localChatMessage).tipParam.b))) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, localChatMessage.uniseq);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatUtil", 2, "clearAioCacheAndDBMsg end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.limitchat.LimitChatUtil.1
 * JD-Core Version:    0.7.0.1
 */