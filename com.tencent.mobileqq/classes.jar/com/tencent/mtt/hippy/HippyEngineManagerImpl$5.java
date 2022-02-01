package com.tencent.mtt.hippy;

import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.mtt.hippy.common.Callback;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.utils.TimeMonitor;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class HippyEngineManagerImpl$5
  implements Callback<Boolean>
{
  HippyEngineManagerImpl$5(HippyEngineManagerImpl paramHippyEngineManagerImpl) {}
  
  public void callback(Boolean paramBoolean, Throwable paramThrowable)
  {
    if ((this.this$0.mCurrentState != HippyEngine.EngineState.INITING) && (this.this$0.mCurrentState != HippyEngine.EngineState.ONRESTART))
    {
      LogUtils.e("HippyEngineManagerImpl", "initBridge callback error STATUS_WRONG_STATE, state=" + this.this$0.mCurrentState);
      this.this$0.notifyEngineInitialized(-150, paramThrowable);
      return;
    }
    this.this$0.mStartTimeMonitor.startEvent(HippyEngineMonitorEvent.ENGINE_LOAD_EVENT_NOTIFY_ENGINE_INITED);
    Object localObject1 = this.this$0.mInstances.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (HippyRootView)((Iterator)localObject1).next();
      HippyEngineManagerImpl.access$100(this.this$0, (HippyRootView)localObject2);
    }
    Object localObject2 = this.this$0.mCurrentState;
    HippyEngineManagerImpl localHippyEngineManagerImpl = this.this$0;
    if (paramBoolean.booleanValue())
    {
      localObject1 = HippyEngine.EngineState.INITED;
      localHippyEngineManagerImpl.mCurrentState = ((HippyEngine.EngineState)localObject1);
      if (localObject2 == HippyEngine.EngineState.ONRESTART) {
        break label207;
      }
      localObject1 = this.this$0;
      if (!paramBoolean.booleanValue()) {
        break label201;
      }
    }
    label201:
    for (int i = 0;; i = -50)
    {
      ((HippyEngineManagerImpl)localObject1).notifyEngineInitialized(i, paramThrowable);
      return;
      localObject1 = HippyEngine.EngineState.INITERRORED;
      break;
    }
    label207:
    LogUtils.e("HippyEngineManagerImpl", "initBridge callback error STATUS_WRONG_STATE, state=" + this.this$0.mCurrentState);
    this.this$0.notifyEngineInitialized(-150, paramThrowable);
    this.this$0.mStartTimeMonitor.end();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.HippyEngineManagerImpl.5
 * JD-Core Version:    0.7.0.1
 */