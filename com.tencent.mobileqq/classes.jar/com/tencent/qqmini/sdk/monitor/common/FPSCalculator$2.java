package com.tencent.qqmini.sdk.monitor.common;

import android.annotation.TargetApi;
import android.os.Handler;
import android.view.Choreographer;
import bgwx;
import com.tencent.qqmini.sdk.log.QMLog;

public class FPSCalculator$2
  implements Runnable
{
  public FPSCalculator$2(bgwx parambgwx) {}
  
  @TargetApi(16)
  public void run()
  {
    for (;;)
    {
      try
      {
        if (bgwx.a(this.this$0) == null) {
          continue;
        }
        bgwx.a(this.this$0).removeFrameCallback(bgwx.a(this.this$0));
        bgwx.a(this.this$0).postFrameCallback(bgwx.a(this.this$0));
      }
      catch (Exception localException)
      {
        if (!QMLog.isColorLevel()) {
          continue;
        }
        QMLog.d("FPSCalculator", "Choreographer.getInstance", localException);
        continue;
      }
      bgwx.a(this.this$0).removeCallbacks(bgwx.a(this.this$0));
      return;
      bgwx.a(this.this$0, Choreographer.getInstance());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.monitor.common.FPSCalculator.2
 * JD-Core Version:    0.7.0.1
 */