package com.tencent.mtt.hippy.bridge;

import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.nativemodules.timer.TimerModule;

class d$1
  implements Provider<TimerModule>
{
  d$1(d paramd, HippyEngineContext paramHippyEngineContext) {}
  
  public TimerModule a()
  {
    return new TimerModule(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.bridge.d.1
 * JD-Core Version:    0.7.0.1
 */