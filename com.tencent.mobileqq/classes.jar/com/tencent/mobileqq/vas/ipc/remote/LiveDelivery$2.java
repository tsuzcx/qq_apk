package com.tencent.mobileqq.vas.ipc.remote;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.vip.PbProtocol;
import eipc.EIPCModule;
import eipc.EIPCResult;

class LiveDelivery$2
  implements BusinessObserver
{
  LiveDelivery$2(LiveDelivery paramLiveDelivery, EIPCModule paramEIPCModule, int paramInt) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    EIPCResult localEIPCResult = new EIPCResult();
    localEIPCResult.data = new Bundle();
    localEIPCResult.data.putBoolean("isSuccess", paramBoolean);
    if (paramObject != null) {
      localEIPCResult.data.putByteArray("rspBytes", PbProtocol.b((byte[])paramObject));
    }
    this.val$moudle.callbackResult(this.val$callbackId, localEIPCResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ipc.remote.LiveDelivery.2
 * JD-Core Version:    0.7.0.1
 */