package com.tencent.mobileqq.vas.ipc;

import android.os.Bundle;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver.OnCallback;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

class VasLiveIPCModule$3
  extends IPublicAccountObserver.OnCallback
{
  VasLiveIPCModule$3(VasLiveIPCModule paramVasLiveIPCModule, int paramInt) {}
  
  public void onUnfollowPublicAccount(boolean paramBoolean, String paramString)
  {
    paramString = new StringBuilder();
    paramString.append("onUnfollowPublicAccount issuccess = ");
    paramString.append(paramBoolean);
    QLog.i("VasLiveIPCModule", 1, paramString.toString());
    paramString = new Bundle();
    paramString.putInt("ret", paramBoolean ^ true);
    this.this$0.callbackResult(this.val$callbackId, EIPCResult.createResult(0, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ipc.VasLiveIPCModule.3
 * JD-Core Version:    0.7.0.1
 */