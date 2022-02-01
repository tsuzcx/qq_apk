package com.tencent.mobileqq.teamwork.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

class TeamWorkUtilsTempImpl$ProcessTDFileScheduler$1
  implements Runnable
{
  TeamWorkUtilsTempImpl$ProcessTDFileScheduler$1(TeamWorkUtilsTempImpl.ProcessTDFileScheduler paramProcessTDFileScheduler, AppInterface paramAppInterface) {}
  
  public void run()
  {
    Iterator localIterator = TeamWorkUtilsTempImpl.ProcessTDFileScheduler.a(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      ((ITeamWorkUtilsTemp)QRoute.api(ITeamWorkUtilsTemp.class)).tryProcessTDDocMessageRecord(localMessageRecord, this.a);
      localIterator.remove();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.TeamWorkUtilsTempImpl.ProcessTDFileScheduler.1
 * JD-Core Version:    0.7.0.1
 */