package com.tencent.mtt.hippy.bridge;

import android.os.Handler;
import android.os.Message;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.mtt.hippy.adapter.thirdparty.HippyThirdPartyAdapter;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyBundleLoader;
import com.tencent.mtt.hippy.common.Callback;
import com.tencent.mtt.hippy.utils.TimeMonitor;

class b$1
  extends NativeCallback
{
  b$1(b paramb, Handler paramHandler, Callback paramCallback)
  {
    super(paramHandler);
  }
  
  public void Call(long paramLong, Message paramMessage, String paramString)
  {
    if (b.a(this.b) != null) {
      b.a(this.b).onRuntimeInit(paramLong);
    }
    this.b.a.getStartTimeMonitor().startEvent(HippyEngineMonitorEvent.ENGINE_LOAD_EVENT_LOAD_COMMONJS);
    if (this.b.b != null)
    {
      this.b.b.load(this.b.c, new b.1.1(this, this.b.e));
      return;
    }
    paramMessage = this.b;
    paramMessage.d = true;
    this.a.callback(Boolean.valueOf(paramMessage.d), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.bridge.b.1
 * JD-Core Version:    0.7.0.1
 */