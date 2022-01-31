package com.tencent.mobileqq.util;

import android.os.Handler;
import baxq;
import baxs;
import java.util.Vector;

public class FPSCalculator$3
  implements Runnable
{
  public FPSCalculator$3(baxq parambaxq) {}
  
  public void run()
  {
    Object localObject1 = baxq.a(this.this$0);
    int i = 0;
    try
    {
      while (i < baxq.a(this.this$0).size())
      {
        baxs localbaxs = (baxs)baxq.a(this.this$0).get(i);
        baxq.a(this.this$0, System.currentTimeMillis());
        localbaxs.onInfo(baxq.a(this.this$0), 60.0D);
        i += 1;
      }
      baxq.a(this.this$0).postDelayed(baxq.b(this.this$0), 500L);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.util.FPSCalculator.3
 * JD-Core Version:    0.7.0.1
 */