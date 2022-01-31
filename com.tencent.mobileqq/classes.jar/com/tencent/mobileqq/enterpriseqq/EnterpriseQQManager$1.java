package com.tencent.mobileqq.enterpriseqq;

import annt;
import annv;
import com.tencent.mobileqq.app.soso.SosoInterface;
import java.util.ArrayList;
import java.util.Iterator;

public class EnterpriseQQManager$1
  implements Runnable
{
  public EnterpriseQQManager$1(annt paramannt) {}
  
  public void run()
  {
    if ((annt.a(this.this$0) != null) && (annt.a(this.this$0) != null))
    {
      SosoInterface.a(this.this$0.a);
      return;
    }
    synchronized (annt.a())
    {
      if ((annt.a(this.this$0) == null) || (annt.a(this.this$0).size() <= 0)) {
        break label144;
      }
      Iterator localIterator = annt.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        annv localannv = (annv)localIterator.next();
        if (localannv != null) {
          this.this$0.a(annt.a(this.this$0), annt.a(this.this$0), localannv.a, localannv.b, false, 0.0D, 0.0D);
        }
      }
    }
    annt.a(this.this$0).clear();
    label144:
    annt.a(this.this$0, null);
    annt.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager.1
 * JD-Core Version:    0.7.0.1
 */