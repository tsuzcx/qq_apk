package com.tencent.mobileqq.vas.ipc.remote;

import amyh;
import android.os.Bundle;
import eipc.EIPCModule;
import eipc.EIPCResult;

class LiveDelivery$4
  extends amyh
{
  LiveDelivery$4(LiveDelivery paramLiveDelivery, EIPCModule paramEIPCModule, int paramInt) {}
  
  public void onUnfollowPublicAccount(boolean paramBoolean, String paramString)
  {
    super.onFollowPublicAccount(paramBoolean, paramString);
    EIPCResult localEIPCResult = new EIPCResult();
    localEIPCResult.data = new Bundle();
    localEIPCResult.data.putBoolean("isSuccess", paramBoolean);
    localEIPCResult.data.putString("uin", paramString);
    this.val$moudle.callbackResult(this.val$callbackId, localEIPCResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ipc.remote.LiveDelivery.4
 * JD-Core Version:    0.7.0.1
 */