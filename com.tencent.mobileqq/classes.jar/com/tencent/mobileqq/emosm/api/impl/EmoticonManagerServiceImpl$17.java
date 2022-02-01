package com.tencent.mobileqq.emosm.api.impl;

import com.tencent.mobileqq.data.EmoticonTab;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import java.util.Iterator;
import java.util.List;

class EmoticonManagerServiceImpl$17
  implements Runnable
{
  EmoticonManagerServiceImpl$17(EmoticonManagerServiceImpl paramEmoticonManagerServiceImpl) {}
  
  public void run()
  {
    synchronized (this.this$0)
    {
      this.this$0.em.drop(EmoticonTab.class.getSimpleName());
      EntityTransaction localEntityTransaction = this.this$0.em.getTransaction();
      try
      {
        localEntityTransaction.begin();
        Iterator localIterator = this.this$0.tabCache.iterator();
        String str;
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          EmoticonManagerServiceImpl.access$300(this.this$0, str, true, false);
        }
        localIterator = this.this$0.kanDianTabCache.iterator();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          EmoticonManagerServiceImpl.access$300(this.this$0, str, false, true);
        }
        localEntityTransaction.commit();
        localEntityTransaction.end();
        return;
      }
      finally
      {
        localEntityTransaction.end();
      }
    }
    for (;;)
    {
      throw localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.EmoticonManagerServiceImpl.17
 * JD-Core Version:    0.7.0.1
 */