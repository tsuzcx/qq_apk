package com.tencent.mobileqq.persistence;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class MessageRecordEntityManagerCallback
  implements MessageRecordEntityManager.Callback
{
  public void a(List<MessageRecord> paramList)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    if ((paramList == null) || (paramList.size() <= 0) || (localAppRuntime == null)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        ((QQMessageFacade)localAppRuntime.getManager(QQManagerFactory.MGR_MSG_FACADE)).a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.MessageRecordEntityManagerCallback
 * JD-Core Version:    0.7.0.1
 */