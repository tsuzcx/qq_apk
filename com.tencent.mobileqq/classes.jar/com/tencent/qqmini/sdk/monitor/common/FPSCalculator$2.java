package com.tencent.qqmini.sdk.monitor.common;

import android.annotation.TargetApi;
import android.os.Handler;
import android.view.Choreographer;
import betc;
import beyc;

public class FPSCalculator$2
  implements Runnable
{
  public FPSCalculator$2(beyc parambeyc) {}
  
  @TargetApi(16)
  public void run()
  {
    for (;;)
    {
      try
      {
        if (beyc.a(this.this$0) == null) {
          continue;
        }
        beyc.a(this.this$0).removeFrameCallback(beyc.a(this.this$0));
        beyc.a(this.this$0).postFrameCallback(beyc.a(this.this$0));
      }
      catch (Exception localException)
      {
        if (!betc.a()) {
          continue;
        }
        betc.a("FPSCalculator", "Choreographer.getInstance", localException);
        continue;
      }
      beyc.a(this.this$0).removeCallbacks(beyc.a(this.this$0));
      return;
      beyc.a(this.this$0, Choreographer.getInstance());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.monitor.common.FPSCalculator.2
 * JD-Core Version:    0.7.0.1
 */