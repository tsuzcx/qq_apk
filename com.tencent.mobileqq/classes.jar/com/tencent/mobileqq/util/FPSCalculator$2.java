package com.tencent.mobileqq.util;

import android.annotation.TargetApi;
import android.os.Handler;
import android.view.Choreographer;
import baxq;
import com.tencent.qphone.base.util.QLog;

public class FPSCalculator$2
  implements Runnable
{
  public FPSCalculator$2(baxq parambaxq) {}
  
  @TargetApi(16)
  public void run()
  {
    for (;;)
    {
      try
      {
        if (baxq.a(this.this$0) == null) {
          continue;
        }
        baxq.a(this.this$0).removeFrameCallback(baxq.a(this.this$0));
        baxq.a(this.this$0).postFrameCallback(baxq.a(this.this$0));
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FPSCalculator", 2, "Choreographer.getInstance", localException);
        continue;
      }
      baxq.a(this.this$0).removeCallbacks(baxq.a(this.this$0));
      return;
      baxq.a(this.this$0, Choreographer.getInstance());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.util.FPSCalculator.2
 * JD-Core Version:    0.7.0.1
 */