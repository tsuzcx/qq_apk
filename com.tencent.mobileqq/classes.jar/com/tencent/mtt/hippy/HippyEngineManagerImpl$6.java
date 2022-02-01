package com.tencent.mtt.hippy;

import com.tencent.mtt.hippy.common.Callback;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.utils.TimeMonitor;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class HippyEngineManagerImpl$6
  implements Callback<Boolean>
{
  HippyEngineManagerImpl$6(HippyEngineManagerImpl paramHippyEngineManagerImpl) {}
  
  public void callback(Boolean paramBoolean, Throwable paramThrowable)
  {
    if ((this.this$0.mCurrentState != HippyEngine.EngineState.INITING) && (this.this$0.mCurrentState != HippyEngine.EngineState.ONRESTART))
    {
      paramBoolean = new StringBuilder();
      paramBoolean.append("initBridge callback error STATUS_WRONG_STATE, state=");
      paramBoolean.append(this.this$0.mCurrentState);
      LogUtils.e("HippyEngineManagerImpl", paramBoolean.toString());
      this.this$0.notifyEngineInitialized(HippyEngine.EngineInitStatus.STATUS_WRONG_STATE, paramThrowable);
      return;
    }
    this.this$0.mStartTimeMonitor.startEvent("notifyEngineInited");
    Object localObject1 = this.this$0.mInstances.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (HippyRootView)((Iterator)localObject1).next();
      HippyEngineManagerImpl.access$100(this.this$0, (HippyRootView)localObject2);
    }
    Object localObject2 = this.this$0.mCurrentState;
    HippyEngineManagerImpl localHippyEngineManagerImpl = this.this$0;
    if (paramBoolean.booleanValue()) {
      localObject1 = HippyEngine.EngineState.INITED;
    } else {
      localObject1 = HippyEngine.EngineState.INITERRORED;
    }
    localHippyEngineManagerImpl.mCurrentState = ((HippyEngine.EngineState)localObject1);
    if (localObject2 != HippyEngine.EngineState.ONRESTART)
    {
      localObject1 = this.this$0;
      if (paramBoolean.booleanValue()) {
        paramBoolean = HippyEngine.EngineInitStatus.STATUS_OK;
      } else {
        paramBoolean = HippyEngine.EngineInitStatus.STATUS_ERR_BRIDGE;
      }
      ((HippyEngineManagerImpl)localObject1).notifyEngineInitialized(paramBoolean, paramThrowable);
      return;
    }
    paramBoolean = new StringBuilder();
    paramBoolean.append("initBridge callback error STATUS_WRONG_STATE, state=");
    paramBoolean.append(this.this$0.mCurrentState);
    LogUtils.e("HippyEngineManagerImpl", paramBoolean.toString());
    this.this$0.notifyEngineInitialized(HippyEngine.EngineInitStatus.STATUS_WRONG_STATE, paramThrowable);
    this.this$0.mStartTimeMonitor.end();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.HippyEngineManagerImpl.6
 * JD-Core Version:    0.7.0.1
 */