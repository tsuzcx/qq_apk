package com.tencent.mobileqq.teamwork;

import becr;
import becs;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TeamWorkUtils$ProcessTDFileScheduler$1
  implements Runnable
{
  public TeamWorkUtils$ProcessTDFileScheduler$1(becs parambecs, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Iterator localIterator = becs.a(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      becr.a((MessageRecord)localIterator.next(), this.a);
      localIterator.remove();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkUtils.ProcessTDFileScheduler.1
 * JD-Core Version:    0.7.0.1
 */