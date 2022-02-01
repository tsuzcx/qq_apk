package com.tencent.mtt.hippy;

import com.tencent.mtt.hippy.utils.TimeMonitor;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class HippyEngineManagerImpl$5
  implements Runnable
{
  HippyEngineManagerImpl$5(HippyEngineManagerImpl paramHippyEngineManagerImpl, Throwable paramThrowable, HippyEngine.EngineInitStatus paramEngineInitStatus) {}
  
  public void run()
  {
    Object localObject;
    if (this.this$0.mCurrentState != HippyEngine.EngineState.DESTROYED)
    {
      this.this$0.mStartTimeMonitor.end();
      localObject = this.this$0;
      int i;
      if (((HippyEngineManagerImpl)localObject).mCurrentState == HippyEngine.EngineState.INITED) {
        i = 0;
      } else {
        i = 1;
      }
      HippyEngineManagerImpl.access$000((HippyEngineManagerImpl)localObject, i, this.val$error);
    }
    Iterator localIterator = this.this$0.mEventListeners.iterator();
    while (localIterator.hasNext())
    {
      HippyEngine.EngineListener localEngineListener = (HippyEngine.EngineListener)localIterator.next();
      HippyEngine.EngineInitStatus localEngineInitStatus = this.val$code;
      localObject = this.val$error;
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((Throwable)localObject).toString();
      }
      localEngineListener.onInitialized(localEngineInitStatus, (String)localObject);
    }
    this.this$0.mEventListeners.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.HippyEngineManagerImpl.5
 * JD-Core Version:    0.7.0.1
 */