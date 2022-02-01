package com.tencent.mobileqq.util;

import android.os.Handler;
import bggs;
import bggu;
import java.util.Vector;

public class FPSCalculator$3
  implements Runnable
{
  public FPSCalculator$3(bggs parambggs) {}
  
  public void run()
  {
    Object localObject1 = bggs.a(this.this$0);
    int i = 0;
    try
    {
      while (i < bggs.a(this.this$0).size())
      {
        bggu localbggu = (bggu)bggs.a(this.this$0).get(i);
        bggs.a(this.this$0, System.currentTimeMillis());
        localbggu.onInfo(bggs.a(this.this$0), 60.0D);
        i += 1;
      }
      bggs.a(this.this$0).postDelayed(bggs.b(this.this$0), 500L);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.FPSCalculator.3
 * JD-Core Version:    0.7.0.1
 */