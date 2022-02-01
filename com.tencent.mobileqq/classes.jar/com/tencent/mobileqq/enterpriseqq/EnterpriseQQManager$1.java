package com.tencent.mobileqq.enterpriseqq;

import aslc;
import asle;
import com.tencent.mobileqq.app.soso.SosoInterface;
import java.util.ArrayList;
import java.util.Iterator;

public class EnterpriseQQManager$1
  implements Runnable
{
  public EnterpriseQQManager$1(aslc paramaslc) {}
  
  public void run()
  {
    if ((aslc.a(this.this$0) != null) && (aslc.a(this.this$0) != null))
    {
      SosoInterface.startLocation(this.this$0.a);
      return;
    }
    synchronized (aslc.a())
    {
      if ((aslc.a(this.this$0) == null) || (aslc.a(this.this$0).size() <= 0)) {
        break label144;
      }
      Iterator localIterator = aslc.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        asle localasle = (asle)localIterator.next();
        if (localasle != null) {
          this.this$0.a(aslc.a(this.this$0), aslc.a(this.this$0), localasle.a, localasle.b, false, 0.0D, 0.0D);
        }
      }
    }
    aslc.a(this.this$0).clear();
    label144:
    aslc.a(this.this$0, null);
    aslc.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager.1
 * JD-Core Version:    0.7.0.1
 */