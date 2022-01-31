package com.tencent.mobileqq.triton.render.monitor;

import android.widget.TextView;
import java.util.Locale;

class FPSMonitor$1
  implements Runnable
{
  FPSMonitor$1(FPSMonitor paramFPSMonitor, float paramFloat) {}
  
  public void run()
  {
    if (FPSMonitor.access$000(this.this$0) != null) {
      FPSMonitor.access$000(this.this$0).setText(String.format(Locale.US, "%.1f", new Object[] { Float.valueOf(this.val$fps) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.render.monitor.FPSMonitor.1
 * JD-Core Version:    0.7.0.1
 */