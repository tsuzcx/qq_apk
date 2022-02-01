package com.tencent.mobileqq.vas.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

class VasLiveIPCModule$2
  extends PublicAccountObserver
{
  VasLiveIPCModule$2(VasLiveIPCModule paramVasLiveIPCModule, int paramInt) {}
  
  public void onFollowPublicAccount(boolean paramBoolean, String paramString)
  {
    int i = 1;
    QLog.i("VasLiveIPCModule", 1, "onFollowPublicAccount issuccess = " + paramBoolean);
    paramString = new Bundle();
    if (paramBoolean) {
      i = 0;
    }
    paramString.putInt("ret", i);
    this.this$0.callbackResult(this.val$callbackId, EIPCResult.createResult(0, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ipc.VasLiveIPCModule.2
 * JD-Core Version:    0.7.0.1
 */