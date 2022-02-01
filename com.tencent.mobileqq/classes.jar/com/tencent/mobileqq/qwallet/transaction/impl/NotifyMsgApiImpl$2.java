package com.tencent.mobileqq.qwallet.transaction.impl;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

final class NotifyMsgApiImpl$2
  implements Runnable
{
  NotifyMsgApiImpl$2(ArrayList paramArrayList) {}
  
  public void run()
  {
    if (QWalletTools.b() != null)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        NotifyMsgApiImpl.WaitRecord localWaitRecord = (NotifyMsgApiImpl.WaitRecord)localIterator.next();
        if ((localWaitRecord != null) && (localWaitRecord.c != null)) {
          ((IMessageFacade)MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IMessageFacade.class, "")).updateMsgFieldByUniseq(localWaitRecord.c.frienduin, localWaitRecord.c.istroop, localWaitRecord.c.uniseq, "extStr", localWaitRecord.c.extStr);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl.2
 * JD-Core Version:    0.7.0.1
 */