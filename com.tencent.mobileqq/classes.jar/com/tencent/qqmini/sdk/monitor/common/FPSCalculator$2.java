package com.tencent.qqmini.sdk.monitor.common;

import android.annotation.TargetApi;
import android.os.Handler;
import android.view.Choreographer;
import bdnw;
import bdrp;

public class FPSCalculator$2
  implements Runnable
{
  public FPSCalculator$2(bdrp parambdrp) {}
  
  @TargetApi(16)
  public void run()
  {
    for (;;)
    {
      try
      {
        if (bdrp.a(this.this$0) == null) {
          continue;
        }
        bdrp.a(this.this$0).removeFrameCallback(bdrp.a(this.this$0));
        bdrp.a(this.this$0).postFrameCallback(bdrp.a(this.this$0));
      }
      catch (Exception localException)
      {
        if (!bdnw.a()) {
          continue;
        }
        bdnw.a("FPSCalculator", "Choreographer.getInstance", localException);
        continue;
      }
      bdrp.a(this.this$0).removeCallbacks(bdrp.a(this.this$0));
      return;
      bdrp.a(this.this$0, Choreographer.getInstance());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.monitor.common.FPSCalculator.2
 * JD-Core Version:    0.7.0.1
 */