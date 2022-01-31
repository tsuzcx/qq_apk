package com.tencent.mobileqq.doutu;

import amxv;
import atmp;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class DoutuManager$9
  implements Runnable
{
  public DoutuManager$9(amxv paramamxv, List paramList) {}
  
  public void run()
  {
    try
    {
      synchronized (this.this$0)
      {
        if (amxv.a(this.this$0) != null)
        {
          amxv.a(this.this$0).a(DoutuData.class);
          Iterator localIterator = this.a.iterator();
          if (localIterator.hasNext())
          {
            DoutuData localDoutuData = (DoutuData)localIterator.next();
            amxv.a(this.this$0).b(localDoutuData);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.DoutuManager.9
 * JD-Core Version:    0.7.0.1
 */