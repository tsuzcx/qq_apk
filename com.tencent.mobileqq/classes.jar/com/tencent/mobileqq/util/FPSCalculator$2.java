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
    try
    {
      if (FPSCalculator.a(this.this$0) != null) {
        FPSCalculator.a(this.this$0).removeFrameCallback(FPSCalculator.a(this.this$0));
      } else {
        FPSCalculator.a(this.this$0, Choreographer.getInstance());
      }
      FPSCalculator.a(this.this$0).postFrameCallback(FPSCalculator.a(this.this$0));
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FPSCalculator", 2, "Choreographer.getInstance", localException);
      }
    }
    FPSCalculator.a(this.this$0).removeCallbacks(FPSCalculator.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.FPSCalculator.2
 * JD-Core Version:    0.7.0.1
 */