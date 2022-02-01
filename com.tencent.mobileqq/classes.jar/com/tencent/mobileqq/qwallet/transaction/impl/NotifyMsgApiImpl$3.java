package com.tencent.mobileqq.qwallet.transaction.impl;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

final class NotifyMsgApiImpl$3
  implements Runnable
{
  NotifyMsgApiImpl$3(MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    if ((QWalletTools.a() != null) && (this.a != null)) {
      ((IMessageFacade)MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IMessageFacade.class, "")).updateMsgFieldByUniseq(this.a.frienduin, this.a.istroop, this.a.uniseq, "extStr", this.a.extStr);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl.3
 * JD-Core Version:    0.7.0.1
 */