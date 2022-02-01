package com.tencent.mobileqq.identification;

import android.os.Bundle;
import com.tencent.mobileqq.observer.LoginVerifyObserver;
import eipc.EIPCResult;

class IdentificationIpcServer$2
  extends LoginVerifyObserver
{
  IdentificationIpcServer$2(IdentificationIpcServer paramIdentificationIpcServer, int paramInt) {}
  
  public void ipJudgeSuccess(boolean paramBoolean, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("usable", paramBoolean);
    localBundle.putString("msg", paramString);
    this.b.callbackResult(this.a, EIPCResult.createResult(0, localBundle));
  }
  
  public void onFailedResponse(String paramString1, int paramInt, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("cmd", paramString1);
    localBundle.putInt("code", paramInt);
    localBundle.putString("msg", paramString2);
    this.b.callbackResult(this.a, EIPCResult.createResult(-102, localBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.identification.IdentificationIpcServer.2
 * JD-Core Version:    0.7.0.1
 */