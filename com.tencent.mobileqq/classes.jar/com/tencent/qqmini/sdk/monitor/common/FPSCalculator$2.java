package com.tencent.qqmini.sdk.monitor.common;

import android.annotation.TargetApi;
import android.os.Handler;
import android.view.Choreographer;
import besl;
import bexl;

public class FPSCalculator$2
  implements Runnable
{
  public FPSCalculator$2(bexl parambexl) {}
  
  @TargetApi(16)
  public void run()
  {
    for (;;)
    {
      try
      {
        if (bexl.a(this.this$0) == null) {
          continue;
        }
        bexl.a(this.this$0).removeFrameCallback(bexl.a(this.this$0));
        bexl.a(this.this$0).postFrameCallback(bexl.a(this.this$0));
      }
      catch (Exception localException)
      {
        if (!besl.a()) {
          continue;
        }
        besl.a("FPSCalculator", "Choreographer.getInstance", localException);
        continue;
      }
      bexl.a(this.this$0).removeCallbacks(bexl.a(this.this$0));
      return;
      bexl.a(this.this$0, Choreographer.getInstance());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.monitor.common.FPSCalculator.2
 * JD-Core Version:    0.7.0.1
 */