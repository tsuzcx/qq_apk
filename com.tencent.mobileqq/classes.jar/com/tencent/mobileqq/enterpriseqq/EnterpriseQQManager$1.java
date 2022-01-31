package com.tencent.mobileqq.enterpriseqq;

import apwl;
import apwn;
import com.tencent.mobileqq.app.soso.SosoInterface;
import java.util.ArrayList;
import java.util.Iterator;

public class EnterpriseQQManager$1
  implements Runnable
{
  public EnterpriseQQManager$1(apwl paramapwl) {}
  
  public void run()
  {
    if ((apwl.a(this.this$0) != null) && (apwl.a(this.this$0) != null))
    {
      SosoInterface.a(this.this$0.a);
      return;
    }
    synchronized (apwl.a())
    {
      if ((apwl.a(this.this$0) == null) || (apwl.a(this.this$0).size() <= 0)) {
        break label144;
      }
      Iterator localIterator = apwl.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        apwn localapwn = (apwn)localIterator.next();
        if (localapwn != null) {
          this.this$0.a(apwl.a(this.this$0), apwl.a(this.this$0), localapwn.a, localapwn.b, false, 0.0D, 0.0D);
        }
      }
    }
    apwl.a(this.this$0).clear();
    label144:
    apwl.a(this.this$0, null);
    apwl.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager.1
 * JD-Core Version:    0.7.0.1
 */