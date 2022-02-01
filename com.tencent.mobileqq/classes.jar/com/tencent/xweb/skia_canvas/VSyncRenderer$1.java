package com.tencent.xweb.skia_canvas;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class VSyncRenderer$1
  implements Runnable
{
  VSyncRenderer$1(VSyncRenderer paramVSyncRenderer) {}
  
  public void run()
  {
    VSyncRenderer.access$002(this.this$0, false);
    Object localObject = VSyncRenderer.access$100(this.this$0).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((VSyncRenderer.PresentCallback)((Iterator)localObject).next()).doPresent();
    }
    long l1 = SystemClock.elapsedRealtimeNanos();
    long l2 = VSyncRenderer.access$200(this.this$0);
    localObject = new ArrayList(VSyncRenderer.access$300(this.this$0).values());
    VSyncRenderer.access$300(this.this$0).clear();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((VSyncRenderer.AnimationCallback)((Iterator)localObject).next()).doAnimation(l1 - l2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.VSyncRenderer.1
 * JD-Core Version:    0.7.0.1
 */