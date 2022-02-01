package com.tencent.mobileqq.stt;

import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.stt.shard.AIOSttResult;
import mqq.app.AppRuntime;

class SttManager$4
  implements Runnable
{
  SttManager$4(SttManager paramSttManager, MessageForPtt paramMessageForPtt) {}
  
  public void run()
  {
    ((IMessageFacade)this.this$0.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IMessageFacade.class, "")).updateMsgContentByUniseq(this.a.frienduin, this.a.istroop, this.a.uniseq, this.a.msgData);
    if ((!this.a.getSttResult().a()) && (this.this$0.jdField_a_of_type_ComTencentMobileqqSttISttListener != null)) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqSttISttListener.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.stt.SttManager.4
 * JD-Core Version:    0.7.0.1
 */