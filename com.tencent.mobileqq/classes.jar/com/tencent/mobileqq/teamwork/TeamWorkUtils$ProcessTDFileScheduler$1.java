package com.tencent.mobileqq.teamwork;

import baic;
import baid;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TeamWorkUtils$ProcessTDFileScheduler$1
  implements Runnable
{
  public TeamWorkUtils$ProcessTDFileScheduler$1(baid parambaid, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Iterator localIterator = baid.a(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      baic.a((MessageRecord)localIterator.next(), this.a);
      localIterator.remove();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkUtils.ProcessTDFileScheduler.1
 * JD-Core Version:    0.7.0.1
 */