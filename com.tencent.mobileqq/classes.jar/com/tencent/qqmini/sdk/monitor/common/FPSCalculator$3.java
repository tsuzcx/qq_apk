package com.tencent.qqmini.sdk.monitor.common;

import android.os.Handler;
import bexl;
import bexn;
import java.util.Vector;

public class FPSCalculator$3
  implements Runnable
{
  public FPSCalculator$3(bexl parambexl) {}
  
  public void run()
  {
    Object localObject1 = bexl.a(this.this$0);
    int i = 0;
    try
    {
      while (i < bexl.a(this.this$0).size())
      {
        bexn localbexn = (bexn)bexl.a(this.this$0).get(i);
        bexl.a(this.this$0, System.currentTimeMillis());
        localbexn.a(bexl.a(this.this$0), 60.0D);
        i += 1;
      }
      bexl.a(this.this$0).postDelayed(bexl.b(this.this$0), 500L);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.monitor.common.FPSCalculator.3
 * JD-Core Version:    0.7.0.1
 */