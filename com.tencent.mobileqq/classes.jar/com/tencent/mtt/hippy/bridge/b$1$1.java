package com.tencent.mtt.hippy.bridge;

import android.os.Handler;
import android.os.Message;
import com.tencent.mtt.hippy.common.Callback;

class b$1$1
  extends NativeCallback
{
  b$1$1(b.1 param1, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public void Call(long paramLong, Message paramMessage, String paramString)
  {
    paramMessage = this.a.b;
    if (paramLong == 1L) {}
    for (boolean bool = true;; bool = false)
    {
      paramMessage.d = bool;
      paramMessage = null;
      if (!this.a.b.d) {
        paramMessage = new RuntimeException("load coreJsBundle failed,check your core jsBundle");
      }
      this.a.a.callback(Boolean.valueOf(this.a.b.d), paramMessage);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.bridge.b.1.1
 * JD-Core Version:    0.7.0.1
 */