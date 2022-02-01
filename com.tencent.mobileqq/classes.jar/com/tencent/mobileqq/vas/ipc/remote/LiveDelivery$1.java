package com.tencent.mobileqq.vas.ipc.remote;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessObserver;
import eipc.EIPCModule;
import eipc.EIPCResult;

class LiveDelivery$1
  implements BusinessObserver
{
  LiveDelivery$1(LiveDelivery paramLiveDelivery, EIPCModule paramEIPCModule, int paramInt) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    EIPCResult localEIPCResult = new EIPCResult();
    localEIPCResult.data = new Bundle();
    if (paramObject != null) {
      localEIPCResult.data.putByteArray("rspBytes", (byte[])paramObject);
    }
    this.val$moudle.callbackResult(this.val$callbackId, localEIPCResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ipc.remote.LiveDelivery.1
 * JD-Core Version:    0.7.0.1
 */