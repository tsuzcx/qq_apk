package com.tencent.mtt.hippy.bridge;

import android.os.Handler;
import android.os.Message;
import com.tencent.mtt.hippy.HippyEngine.ModuleLoadStatus;
import com.tencent.mtt.hippy.HippyRootView;

class b$2
  extends NativeCallback
{
  b$2(b paramb, Handler paramHandler, HippyRootView paramHippyRootView)
  {
    super(paramHandler);
  }
  
  public void Call(long paramLong, Message paramMessage, String paramString)
  {
    if (paramLong == 1L)
    {
      b.a(this.b, HippyEngine.ModuleLoadStatus.STATUS_OK, null, this.a);
      return;
    }
    b.a(this.b, HippyEngine.ModuleLoadStatus.STATUS_ERR_RUN_BUNDLE, "load module error. loader.load failed. check the file.", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.bridge.b.2
 * JD-Core Version:    0.7.0.1
 */