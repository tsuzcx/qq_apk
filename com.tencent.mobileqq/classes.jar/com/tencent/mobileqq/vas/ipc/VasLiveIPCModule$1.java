package com.tencent.mobileqq.vas.ipc;

import android.os.Bundle;
import aoeg;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

class VasLiveIPCModule$1
  extends aoeg
{
  VasLiveIPCModule$1(VasLiveIPCModule paramVasLiveIPCModule, int paramInt) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ipc.VasLiveIPCModule.1
 * JD-Core Version:    0.7.0.1
 */