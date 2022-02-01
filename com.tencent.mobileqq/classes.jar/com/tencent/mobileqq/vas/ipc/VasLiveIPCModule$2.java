package com.tencent.mobileqq.vas.ipc;

import android.os.Bundle;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver.OnCallback;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

class VasLiveIPCModule$2
  extends IPublicAccountObserver.OnCallback
{
  VasLiveIPCModule$2(VasLiveIPCModule paramVasLiveIPCModule, int paramInt) {}
  
  public void onFollowPublicAccount(boolean paramBoolean, String paramString)
  {
    paramString = new StringBuilder();
    paramString.append("onFollowPublicAccount issuccess = ");
    paramString.append(paramBoolean);
    QLog.i("VasLiveIPCModule", 1, paramString.toString());
    paramString = new Bundle();
    paramString.putInt("ret", paramBoolean ^ true);
    this.this$0.callbackResult(this.val$callbackId, EIPCResult.createResult(0, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ipc.VasLiveIPCModule.2
 * JD-Core Version:    0.7.0.1
 */