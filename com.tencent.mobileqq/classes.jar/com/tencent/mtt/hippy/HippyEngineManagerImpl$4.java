package com.tencent.mtt.hippy;

import com.tencent.mtt.hippy.utils.TimeMonitor;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class HippyEngineManagerImpl$4
  implements Runnable
{
  HippyEngineManagerImpl$4(HippyEngineManagerImpl paramHippyEngineManagerImpl, Throwable paramThrowable, int paramInt) {}
  
  public void run()
  {
    int i;
    label63:
    HippyEngine.EngineListener localEngineListener;
    if (this.this$0.mCurrentState != HippyEngine.EngineState.DESTROYED)
    {
      this.this$0.mStartTimeMonitor.end();
      localObject = this.this$0;
      if (this.this$0.mCurrentState == HippyEngine.EngineState.INITED)
      {
        i = 0;
        HippyEngineManagerImpl.access$000((HippyEngineManagerImpl)localObject, i, this.val$error);
      }
    }
    else
    {
      Iterator localIterator = this.this$0.mEventListeners.iterator();
      if (!localIterator.hasNext()) {
        break label125;
      }
      localEngineListener = (HippyEngine.EngineListener)localIterator.next();
      i = this.val$code;
      if (this.val$error != null) {
        break label114;
      }
    }
    label114:
    for (Object localObject = null;; localObject = this.val$error.toString())
    {
      localEngineListener.onInitialized(i, (String)localObject);
      break label63;
      i = 1;
      break;
    }
    label125:
    this.this$0.mEventListeners.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.HippyEngineManagerImpl.4
 * JD-Core Version:    0.7.0.1
 */