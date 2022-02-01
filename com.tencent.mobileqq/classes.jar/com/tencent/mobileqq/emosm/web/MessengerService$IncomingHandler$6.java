package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

class MessengerService$IncomingHandler$6
  extends WtloginObserver
{
  MessengerService$IncomingHandler$6(MessengerService.IncomingHandler paramIncomingHandler, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void onCheckDevLockStatus(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    paramWUserSigInfo = new Bundle();
    if ((paramInt == 0) && (paramDevlockInfo != null))
    {
      paramInt = paramDevlockInfo.DevSetup;
      boolean bool2 = false;
      if (paramInt == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramWUserSigInfo.putBoolean("auth_dev_open", bool1);
      boolean bool1 = bool2;
      if (paramDevlockInfo.AllowSet == 1) {
        bool1 = true;
      }
      paramWUserSigInfo.putBoolean("allow_set", bool1);
      paramWUserSigInfo.putString("phone_num", paramDevlockInfo.Mobile);
    }
    this.jdField_a_of_type_AndroidOsBundle.putBundle("response", paramWUserSigInfo);
    this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.6
 * JD-Core Version:    0.7.0.1
 */