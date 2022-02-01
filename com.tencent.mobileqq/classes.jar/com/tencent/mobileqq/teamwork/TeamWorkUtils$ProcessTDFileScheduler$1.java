package com.tencent.mobileqq.teamwork;

import bcvs;
import bcvt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TeamWorkUtils$ProcessTDFileScheduler$1
  implements Runnable
{
  public TeamWorkUtils$ProcessTDFileScheduler$1(bcvt parambcvt, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Iterator localIterator = bcvt.a(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      bcvs.a((MessageRecord)localIterator.next(), this.a);
      localIterator.remove();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkUtils.ProcessTDFileScheduler.1
 * JD-Core Version:    0.7.0.1
 */