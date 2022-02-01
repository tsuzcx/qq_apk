package com.tencent.mobileqq.stt;

import bcmt;
import bcmu;
import bcmx;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;

public class SttManager$4
  implements Runnable
{
  public SttManager$4(bcmt parambcmt, MessageForPtt paramMessageForPtt) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgContentByUniseq(this.a.frienduin, this.a.istroop, this.a.uniseq, this.a.msgData);
    if ((!this.a.getSttResult().a()) && (this.this$0.jdField_a_of_type_Bcmu != null)) {
      this.this$0.jdField_a_of_type_Bcmu.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.stt.SttManager.4
 * JD-Core Version:    0.7.0.1
 */