package com.tencent.mobileqq.imaxad;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

class ImaxAdPresenter$1
  implements Runnable
{
  ImaxAdPresenter$1(ImaxAdPresenter paramImaxAdPresenter, QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    this.a.getMessageFacade().a(this.b.frienduin, this.b.msgtype, this.b.uniseq, "extStr", this.b.extStr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAdPresenter.1
 * JD-Core Version:    0.7.0.1
 */