package com.tencent.mobileqq.imaxad;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

class ImaxAdPresenter$2
  implements Runnable
{
  ImaxAdPresenter$2(ImaxAdPresenter paramImaxAdPresenter, QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    this.a.getMessageFacade().a(this.b.frienduin, this.b.msgtype, this.b.uniseq, "extStr", this.b.extStr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAdPresenter.2
 * JD-Core Version:    0.7.0.1
 */