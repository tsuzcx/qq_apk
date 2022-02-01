package com.tencent.qapmsdk.dropframe;

import android.view.Choreographer;
import com.tencent.qapmsdk.common.logger.Logger;

class DropFrameMonitor$1
  implements Runnable
{
  DropFrameMonitor$1(DropFrameMonitor paramDropFrameMonitor) {}
  
  public void run()
  {
    try
    {
      DropFrameMonitor.access$002(this.this$0, Choreographer.getInstance());
      return;
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.exception("QAPM_dropframe_DropFrameMonitor", "init choreographer error", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.dropframe.DropFrameMonitor.1
 * JD-Core Version:    0.7.0.1
 */