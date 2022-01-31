package com.tencent.mobileqq.enterpriseqq;

import aoej;
import aoel;
import com.tencent.mobileqq.app.soso.SosoInterface;
import java.util.ArrayList;
import java.util.Iterator;

public class EnterpriseQQManager$1
  implements Runnable
{
  public EnterpriseQQManager$1(aoej paramaoej) {}
  
  public void run()
  {
    if ((aoej.a(this.this$0) != null) && (aoej.a(this.this$0) != null))
    {
      SosoInterface.a(this.this$0.a);
      return;
    }
    synchronized (aoej.a())
    {
      if ((aoej.a(this.this$0) == null) || (aoej.a(this.this$0).size() <= 0)) {
        break label144;
      }
      Iterator localIterator = aoej.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        aoel localaoel = (aoel)localIterator.next();
        if (localaoel != null) {
          this.this$0.a(aoej.a(this.this$0), aoej.a(this.this$0), localaoel.a, localaoel.b, false, 0.0D, 0.0D);
        }
      }
    }
    aoej.a(this.this$0).clear();
    label144:
    aoej.a(this.this$0, null);
    aoej.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager.1
 * JD-Core Version:    0.7.0.1
 */