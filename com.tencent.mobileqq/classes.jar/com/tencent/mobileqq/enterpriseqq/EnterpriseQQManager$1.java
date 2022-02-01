package com.tencent.mobileqq.enterpriseqq;

import argw;
import argy;
import com.tencent.mobileqq.app.soso.SosoInterface;
import java.util.ArrayList;
import java.util.Iterator;

public class EnterpriseQQManager$1
  implements Runnable
{
  public EnterpriseQQManager$1(argw paramargw) {}
  
  public void run()
  {
    if ((argw.a(this.this$0) != null) && (argw.a(this.this$0) != null))
    {
      SosoInterface.startLocation(this.this$0.a);
      return;
    }
    synchronized (argw.a())
    {
      if ((argw.a(this.this$0) == null) || (argw.a(this.this$0).size() <= 0)) {
        break label144;
      }
      Iterator localIterator = argw.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        argy localargy = (argy)localIterator.next();
        if (localargy != null) {
          this.this$0.a(argw.a(this.this$0), argw.a(this.this$0), localargy.a, localargy.b, false, 0.0D, 0.0D);
        }
      }
    }
    argw.a(this.this$0).clear();
    label144:
    argw.a(this.this$0, null);
    argw.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager.1
 * JD-Core Version:    0.7.0.1
 */