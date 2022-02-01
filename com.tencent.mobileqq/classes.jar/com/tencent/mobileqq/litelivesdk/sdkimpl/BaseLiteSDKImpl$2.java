package com.tencent.mobileqq.litelivesdk.sdkimpl;

import com.tencent.livesdk.liveengine.FloatRoomManager;
import com.tencent.livesdk.liveengine.LiveEngine;
import com.tencent.qphone.base.util.QLog;

class BaseLiteSDKImpl$2
  implements Runnable
{
  BaseLiteSDKImpl$2(BaseLiteSDKImpl paramBaseLiteSDKImpl, LiveEngine paramLiveEngine) {}
  
  public void run()
  {
    try
    {
      if (this.a != null)
      {
        if (this.a.getFloatRoomManager() == null) {
          return;
        }
        this.a.getFloatRoomManager().g();
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      QLog.e("BaseLiteSDKImpl", 1, "enterFloatWindowCheck close float window exception", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.sdkimpl.BaseLiteSDKImpl.2
 * JD-Core Version:    0.7.0.1
 */