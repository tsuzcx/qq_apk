package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

class MessengerService$IncomingHandler$9
  extends WtloginObserver
{
  MessengerService$IncomingHandler$9(MessengerService.IncomingHandler paramIncomingHandler, Bundle paramBundle1, Bundle paramBundle2, MessengerService paramMessengerService) {}
  
  public void onCheckDevLockStatus(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if ((paramInt == 0) && (paramDevlockInfo != null))
    {
      paramWUserSigInfo = this.a;
      paramInt = paramDevlockInfo.AllowSet;
      boolean bool2 = false;
      if (paramInt == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramWUserSigInfo.putBoolean("hasSecurityPhoneNumber", bool1);
      paramWUserSigInfo = this.a;
      boolean bool1 = bool2;
      if (paramDevlockInfo.DevSetup == 1) {
        bool1 = true;
      }
      paramWUserSigInfo.putBoolean("devlockIsOpen", bool1);
    }
    this.b.putBundle("response", this.a);
    this.c.a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.9
 * JD-Core Version:    0.7.0.1
 */