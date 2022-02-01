package com.tencent.mobileqq.stt;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.stt.shard.AIOSttResult;

class SttManager$4
  implements Runnable
{
  SttManager$4(SttManager paramSttManager, MessageForPtt paramMessageForPtt) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.a.frienduin, this.a.istroop, this.a.uniseq, this.a.msgData);
    if ((!this.a.getSttResult().a()) && (this.this$0.jdField_a_of_type_ComTencentMobileqqSttSttManager$ISttListener != null)) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqSttSttManager$ISttListener.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.stt.SttManager.4
 * JD-Core Version:    0.7.0.1
 */