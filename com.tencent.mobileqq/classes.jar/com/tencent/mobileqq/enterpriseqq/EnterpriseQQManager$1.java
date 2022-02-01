package com.tencent.mobileqq.enterpriseqq;

import asfi;
import asfk;
import com.tencent.mobileqq.app.soso.SosoInterface;
import java.util.ArrayList;
import java.util.Iterator;

public class EnterpriseQQManager$1
  implements Runnable
{
  public EnterpriseQQManager$1(asfi paramasfi) {}
  
  public void run()
  {
    if ((asfi.a(this.this$0) != null) && (asfi.a(this.this$0) != null))
    {
      SosoInterface.a(this.this$0.a);
      return;
    }
    synchronized (asfi.a())
    {
      if ((asfi.a(this.this$0) == null) || (asfi.a(this.this$0).size() <= 0)) {
        break label144;
      }
      Iterator localIterator = asfi.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        asfk localasfk = (asfk)localIterator.next();
        if (localasfk != null) {
          this.this$0.a(asfi.a(this.this$0), asfi.a(this.this$0), localasfk.a, localasfk.b, false, 0.0D, 0.0D);
        }
      }
    }
    asfi.a(this.this$0).clear();
    label144:
    asfi.a(this.this$0, null);
    asfi.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager.1
 * JD-Core Version:    0.7.0.1
 */