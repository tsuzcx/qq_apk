package com.tencent.mobileqq.triton.internal.render.monitor;

import com.tencent.mobileqq.triton.engine.ScreenShotCallback;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ScreenShootMonitor$onGetScreenShot$1
  implements Runnable
{
  ScreenShootMonitor$onGetScreenShot$1(ScreenShootMonitor paramScreenShootMonitor, Object paramObject) {}
  
  public final void run()
  {
    Iterator localIterator = ((Iterable)ScreenShootMonitor.access$getPendingCallback$p(this.this$0)).iterator();
    while (localIterator.hasNext()) {
      ((ScreenShotCallback)localIterator.next()).onGetScreenShot(this.$result);
    }
    ScreenShootMonitor.access$getPendingCallback$p(this.this$0).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.render.monitor.ScreenShootMonitor.onGetScreenShot.1
 * JD-Core Version:    0.7.0.1
 */