package com.tencent.mtt.hippy.bridge;

import android.os.Handler;
import android.os.Message;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.utils.TimeMonitor;

class b$3
  extends NativeCallback
{
  b$3(b paramb, Handler paramHandler, Message paramMessage, String paramString)
  {
    super(paramHandler, paramMessage, paramString);
  }
  
  public void Call(long paramLong, Message paramMessage, String paramString)
  {
    if ((paramMessage.obj instanceof HippyMap))
    {
      int i = ((HippyMap)paramMessage.obj).getInt("id");
      paramMessage = this.a.a.getInstance(i);
      if ((paramMessage != null) && (paramMessage.getTimeMonitor() != null)) {
        paramMessage.getTimeMonitor().startEvent(HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.bridge.b.3
 * JD-Core Version:    0.7.0.1
 */