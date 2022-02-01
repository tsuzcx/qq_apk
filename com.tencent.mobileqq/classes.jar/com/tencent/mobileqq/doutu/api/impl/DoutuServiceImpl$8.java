package com.tencent.mobileqq.doutu.api.impl;

import com.tencent.mobileqq.doutu.DoutuData;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class DoutuServiceImpl$8
  implements Runnable
{
  DoutuServiceImpl$8(DoutuServiceImpl paramDoutuServiceImpl, List paramList) {}
  
  public void run()
  {
    try
    {
      synchronized (this.this$0)
      {
        if (DoutuServiceImpl.access$400(this.this$0) != null)
        {
          DoutuServiceImpl.access$400(this.this$0).drop(DoutuData.class);
          Iterator localIterator = this.a.iterator();
          while (localIterator.hasNext())
          {
            DoutuData localDoutuData = (DoutuData)localIterator.next();
            DoutuServiceImpl.access$400(this.this$0).persistOrReplace(localDoutuData);
          }
        }
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("DoutuServiceImpl", 2, "persistDoutuData error ", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.api.impl.DoutuServiceImpl.8
 * JD-Core Version:    0.7.0.1
 */