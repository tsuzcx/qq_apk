package com.tencent.mobileqq.util;

import android.annotation.TargetApi;
import android.os.Handler;
import android.view.Choreographer;
import com.tencent.qphone.base.util.QLog;

class FPSCalculator$2
  implements Runnable
{
  FPSCalculator$2(FPSCalculator paramFPSCalculator) {}
  
  @TargetApi(16)
  public void run()
  {
    for (;;)
    {
      try
      {
        if (FPSCalculator.a(this.this$0) == null) {
          continue;
        }
        FPSCalculator.a(this.this$0).removeFrameCallback(FPSCalculator.a(this.this$0));
        FPSCalculator.a(this.this$0).postFrameCallback(FPSCalculator.a(this.this$0));
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FPSCalculator", 2, "Choreographer.getInstance", localException);
        continue;
      }
      FPSCalculator.a(this.this$0).removeCallbacks(FPSCalculator.a(this.this$0));
      return;
      FPSCalculator.a(this.this$0, Choreographer.getInstance());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.FPSCalculator.2
 * JD-Core Version:    0.7.0.1
 */