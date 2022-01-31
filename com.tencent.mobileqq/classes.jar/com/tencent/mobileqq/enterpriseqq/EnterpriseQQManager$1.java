package com.tencent.mobileqq.enterpriseqq;

import aqau;
import aqaw;
import com.tencent.mobileqq.app.soso.SosoInterface;
import java.util.ArrayList;
import java.util.Iterator;

public class EnterpriseQQManager$1
  implements Runnable
{
  public EnterpriseQQManager$1(aqau paramaqau) {}
  
  public void run()
  {
    if ((aqau.a(this.this$0) != null) && (aqau.a(this.this$0) != null))
    {
      SosoInterface.a(this.this$0.a);
      return;
    }
    synchronized (aqau.a())
    {
      if ((aqau.a(this.this$0) == null) || (aqau.a(this.this$0).size() <= 0)) {
        break label144;
      }
      Iterator localIterator = aqau.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        aqaw localaqaw = (aqaw)localIterator.next();
        if (localaqaw != null) {
          this.this$0.a(aqau.a(this.this$0), aqau.a(this.this$0), localaqaw.a, localaqaw.b, false, 0.0D, 0.0D);
        }
      }
    }
    aqau.a(this.this$0).clear();
    label144:
    aqau.a(this.this$0, null);
    aqau.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager.1
 * JD-Core Version:    0.7.0.1
 */