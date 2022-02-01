package com.tencent.mobileqq.teamwork;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

class TeamWorkUtils$ProcessTDFileScheduler$1
  implements Runnable
{
  TeamWorkUtils$ProcessTDFileScheduler$1(TeamWorkUtils.ProcessTDFileScheduler paramProcessTDFileScheduler, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Iterator localIterator = TeamWorkUtils.ProcessTDFileScheduler.a(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      TeamWorkUtils.a((MessageRecord)localIterator.next(), this.a);
      localIterator.remove();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkUtils.ProcessTDFileScheduler.1
 * JD-Core Version:    0.7.0.1
 */