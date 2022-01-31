package com.tencent.mobileqq.util;

import android.annotation.TargetApi;
import android.os.Handler;
import android.view.Choreographer;
import azvy;
import com.tencent.qphone.base.util.QLog;

public class FPSCalculator$2
  implements Runnable
{
  public FPSCalculator$2(azvy paramazvy) {}
  
  @TargetApi(16)
  public void run()
  {
    for (;;)
    {
      try
      {
        if (azvy.a(this.this$0) == null) {
          continue;
        }
        azvy.a(this.this$0).removeFrameCallback(azvy.a(this.this$0));
        azvy.a(this.this$0).postFrameCallback(azvy.a(this.this$0));
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FPSCalculator", 2, "Choreographer.getInstance", localException);
        continue;
      }
      azvy.a(this.this$0).removeCallbacks(azvy.a(this.this$0));
      return;
      azvy.a(this.this$0, Choreographer.getInstance());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.util.FPSCalculator.2
 * JD-Core Version:    0.7.0.1
 */