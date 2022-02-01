package com.tencent.mtt.hippy;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class HippyEngineManagerImpl$1
  extends Handler
{
  HippyEngineManagerImpl$1(HippyEngineManagerImpl paramHippyEngineManagerImpl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100) {
      HippyEngineManagerImpl.access$000(this.this$0, 2, null);
    }
    super.handleMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.HippyEngineManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */