package com.tencent.mobileqq.structmsg;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import mqq.app.AppRuntime;

class StructMsgForGeneralShare$6
  implements Runnable
{
  StructMsgForGeneralShare$6(StructMsgForGeneralShare paramStructMsgForGeneralShare, AppRuntime paramAppRuntime) {}
  
  public void run()
  {
    ((QQAppInterface)this.a).a().a(this.this$0.message.frienduin, this.this$0.message.msgtype, this.this$0.message.uniseq, "extStr", this.this$0.message.extStr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.6
 * JD-Core Version:    0.7.0.1
 */