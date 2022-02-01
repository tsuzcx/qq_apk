package com.tencent.qqmini.sdk.monitor.common;

import android.annotation.TargetApi;
import android.os.Handler;
import android.view.Choreographer;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class FPSCalculator$1
  implements Runnable
{
  FPSCalculator$1(FPSCalculator paramFPSCalculator) {}
  
  @TargetApi(16)
  public void run()
  {
    for (;;)
    {
      try
      {
        if (FPSCalculator.access$000(this.this$0) == null) {
          continue;
        }
        FPSCalculator.access$000(this.this$0).removeFrameCallback(FPSCalculator.access$100(this.this$0));
        FPSCalculator.access$000(this.this$0).postFrameCallback(FPSCalculator.access$100(this.this$0));
      }
      catch (Exception localException)
      {
        if (!QMLog.isColorLevel()) {
          continue;
        }
        QMLog.d("FPSCalculator", "Choreographer.getInstance", localException);
        continue;
      }
      FPSCalculator.access$300(this.this$0).removeCallbacks(FPSCalculator.access$200(this.this$0));
      return;
      FPSCalculator.access$002(this.this$0, Choreographer.getInstance());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.monitor.common.FPSCalculator.1
 * JD-Core Version:    0.7.0.1
 */