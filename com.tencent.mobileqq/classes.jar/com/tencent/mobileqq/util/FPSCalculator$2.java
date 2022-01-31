package com.tencent.mobileqq.util;

import android.annotation.TargetApi;
import android.os.Handler;
import android.view.Choreographer;
import bcwk;
import com.tencent.qphone.base.util.QLog;

public class FPSCalculator$2
  implements Runnable
{
  public FPSCalculator$2(bcwk parambcwk) {}
  
  @TargetApi(16)
  public void run()
  {
    for (;;)
    {
      try
      {
        if (bcwk.a(this.this$0) == null) {
          continue;
        }
        bcwk.a(this.this$0).removeFrameCallback(bcwk.a(this.this$0));
        bcwk.a(this.this$0).postFrameCallback(bcwk.a(this.this$0));
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FPSCalculator", 2, "Choreographer.getInstance", localException);
        continue;
      }
      bcwk.a(this.this$0).removeCallbacks(bcwk.a(this.this$0));
      return;
      bcwk.a(this.this$0, Choreographer.getInstance());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.FPSCalculator.2
 * JD-Core Version:    0.7.0.1
 */