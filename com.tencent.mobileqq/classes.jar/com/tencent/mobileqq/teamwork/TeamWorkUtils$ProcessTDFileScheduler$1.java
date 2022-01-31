package com.tencent.mobileqq.teamwork;

import ayfx;
import ayfy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TeamWorkUtils$ProcessTDFileScheduler$1
  implements Runnable
{
  public TeamWorkUtils$ProcessTDFileScheduler$1(ayfy paramayfy, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Iterator localIterator = ayfy.a(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      ayfx.a((MessageRecord)localIterator.next(), this.a);
      localIterator.remove();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkUtils.ProcessTDFileScheduler.1
 * JD-Core Version:    0.7.0.1
 */