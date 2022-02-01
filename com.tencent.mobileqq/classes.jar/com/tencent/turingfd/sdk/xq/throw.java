package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

public class throw
  extends Thread
{
  public throw(Map paramMap, CanisMajor paramCanisMajor) {}
  
  public void run()
  {
    Object localObject5 = CanisMinor.a;
    Map localMap = this.a;
    int i;
    long l;
    label268:
    synchronized (((CanisMinor)localObject5).e)
    {
      try
      {
        Context localContext = const.a;
        i = 0;
        CanisMinor.do localdo = null;
        boolean bool = false;
        try
        {
          if (i < ((CanisMinor)localObject5).g)
          {
            if (i != 0) {
              bool = true;
            }
            localdo = ((CanisMinor)localObject5).a(localMap, localContext, bool);
            l = localdo.a;
            if (l != 0L) {
              break label268;
            }
          }
          localObject5 = localdo;
          if (localdo == null) {
            localObject5 = new CanisMinor.do(-10000000L, new HashMap());
          }
        }
        finally
        {
          localObject2 = localObject1.toString();
          localObject5 = Date.a;
          localObject5 = new HashMap();
          ((HashMap)localObject5).put("602", localObject2);
          Date.a(localContext, (Map)localObject5);
          localObject5 = new CanisMinor.do(-6000000L, new HashMap());
        }
        Object localObject2 = ((CanisMinor.do)localObject5).b;
        if (localObject2 != null)
        {
          ??? = this.b;
          l = ((CanisMinor.do)localObject5).a;
          ((TuringSecurityService.do)???).a(l, (Map)localObject2);
          return;
        }
        localObject2 = this.b;
        l = ((CanisMinor.do)localObject5).a;
        localObject5 = new HashMap();
        ((TuringSecurityService.do)localObject2).a(l, (Map)localObject5);
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.throw
 * JD-Core Version:    0.7.0.1
 */