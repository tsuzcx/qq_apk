package com.tencent.mobileqq.util;

import android.annotation.TargetApi;
import android.os.Handler;
import android.view.Choreographer;
import bhgt;
import com.tencent.qphone.base.util.QLog;

public class FPSCalculator$2
  implements Runnable
{
  public FPSCalculator$2(bhgt parambhgt) {}
  
  @TargetApi(16)
  public void run()
  {
    for (;;)
    {
      try
      {
        if (bhgt.a(this.this$0) == null) {
          continue;
        }
        bhgt.a(this.this$0).removeFrameCallback(bhgt.a(this.this$0));
        bhgt.a(this.this$0).postFrameCallback(bhgt.a(this.this$0));
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FPSCalculator", 2, "Choreographer.getInstance", localException);
        continue;
      }
      bhgt.a(this.this$0).removeCallbacks(bhgt.a(this.this$0));
      return;
      bhgt.a(this.this$0, Choreographer.getInstance());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.FPSCalculator.2
 * JD-Core Version:    0.7.0.1
 */