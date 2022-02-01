package com.tencent.rmonitor.resource.collector.frame;

import android.view.Choreographer;
import com.tencent.rmonitor.common.logger.Logger;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 15})
final class FrameManager$1
  implements Runnable
{
  public static final 1 a = new 1();
  
  public final void run()
  {
    try
    {
      FrameManager.a(FrameManager.a, Choreographer.getInstance());
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.b.a("RMonitor_frame_FrameManager", "init choreographer error", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.resource.collector.frame.FrameManager.1
 * JD-Core Version:    0.7.0.1
 */