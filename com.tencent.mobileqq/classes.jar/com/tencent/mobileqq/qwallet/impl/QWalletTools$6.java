package com.tencent.mobileqq.qwallet.impl;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;
import mqq.app.AppRuntime;

final class QWalletTools$6
  implements Runnable
{
  QWalletTools$6(MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    ((IMessageFacade)QWalletHelperImpl.getAppRuntime().getRuntimeService(IMessageFacade.class, "")).updateMsgFieldByUniseq(this.a.frienduin, this.a.istroop, this.a.uniseq, "extStr", this.a.extStr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.impl.QWalletTools.6
 * JD-Core Version:    0.7.0.1
 */