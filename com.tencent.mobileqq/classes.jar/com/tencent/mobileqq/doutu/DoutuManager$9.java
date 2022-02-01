package com.tencent.mobileqq.doutu;

import asaa;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class DoutuManager$9
  implements Runnable
{
  public DoutuManager$9(asaa paramasaa, List paramList) {}
  
  public void run()
  {
    try
    {
      synchronized (this.this$0)
      {
        if (asaa.a(this.this$0) != null)
        {
          asaa.a(this.this$0).drop(DoutuData.class);
          Iterator localIterator = this.a.iterator();
          if (localIterator.hasNext())
          {
            DoutuData localDoutuData = (DoutuData)localIterator.next();
            asaa.a(this.this$0).persistOrReplace(localDoutuData);
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("DoutuManager", 2, "persistDoutuData error ", localThrowable);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.DoutuManager.9
 * JD-Core Version:    0.7.0.1
 */