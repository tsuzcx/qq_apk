package com.tencent.mobileqq.enterpriseqq;

import aoee;
import aoeg;
import com.tencent.mobileqq.app.soso.SosoInterface;
import java.util.ArrayList;
import java.util.Iterator;

public class EnterpriseQQManager$1
  implements Runnable
{
  public EnterpriseQQManager$1(aoee paramaoee) {}
  
  public void run()
  {
    if ((aoee.a(this.this$0) != null) && (aoee.a(this.this$0) != null))
    {
      SosoInterface.a(this.this$0.a);
      return;
    }
    synchronized (aoee.a())
    {
      if ((aoee.a(this.this$0) == null) || (aoee.a(this.this$0).size() <= 0)) {
        break label144;
      }
      Iterator localIterator = aoee.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        aoeg localaoeg = (aoeg)localIterator.next();
        if (localaoeg != null) {
          this.this$0.a(aoee.a(this.this$0), aoee.a(this.this$0), localaoeg.a, localaoeg.b, false, 0.0D, 0.0D);
        }
      }
    }
    aoee.a(this.this$0).clear();
    label144:
    aoee.a(this.this$0, null);
    aoee.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager.1
 * JD-Core Version:    0.7.0.1
 */