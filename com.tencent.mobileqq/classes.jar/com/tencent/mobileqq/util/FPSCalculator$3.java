package com.tencent.mobileqq.util;

import android.os.Handler;
import java.util.Vector;

class FPSCalculator$3
  implements Runnable
{
  FPSCalculator$3(FPSCalculator paramFPSCalculator) {}
  
  public void run()
  {
    Object localObject1 = FPSCalculator.e(this.this$0);
    int i = 0;
    try
    {
      while (i < FPSCalculator.f(this.this$0).size())
      {
        FPSCalculator.GetFPSListener localGetFPSListener = (FPSCalculator.GetFPSListener)FPSCalculator.f(this.this$0).get(i);
        FPSCalculator.b(this.this$0, System.currentTimeMillis());
        localGetFPSListener.onInfo(FPSCalculator.g(this.this$0), 60.0D);
        i += 1;
      }
      FPSCalculator.d(this.this$0).postDelayed(FPSCalculator.h(this.this$0), 500L);
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.FPSCalculator.3
 * JD-Core Version:    0.7.0.1
 */