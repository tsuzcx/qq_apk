package com.tencent.mobileqq.enterpriseqq;

import asuw;
import asuy;
import com.tencent.mobileqq.app.soso.SosoInterface;
import java.util.ArrayList;
import java.util.Iterator;

public class EnterpriseQQManager$1
  implements Runnable
{
  public EnterpriseQQManager$1(asuw paramasuw) {}
  
  public void run()
  {
    if ((asuw.a(this.this$0) != null) && (asuw.a(this.this$0) != null))
    {
      SosoInterface.a(this.this$0.a);
      return;
    }
    synchronized (asuw.a())
    {
      if ((asuw.a(this.this$0) == null) || (asuw.a(this.this$0).size() <= 0)) {
        break label144;
      }
      Iterator localIterator = asuw.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        asuy localasuy = (asuy)localIterator.next();
        if (localasuy != null) {
          this.this$0.a(asuw.a(this.this$0), asuw.a(this.this$0), localasuy.a, localasuy.b, false, 0.0D, 0.0D);
        }
      }
    }
    asuw.a(this.this$0).clear();
    label144:
    asuw.a(this.this$0, null);
    asuw.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager.1
 * JD-Core Version:    0.7.0.1
 */