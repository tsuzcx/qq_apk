package com.tencent.mobileqq.qqlive.api.impl.room;

import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.callback.login.IQQLiveLoginCallback;
import com.tencent.mobileqq.qqlive.callback.room.audience.GetRoomInfoCallback;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.qphone.base.util.QLog;

class BaseLiveRoom$2
  implements IQQLiveLoginCallback
{
  BaseLiveRoom$2(BaseLiveRoom paramBaseLiveRoom, IQQLiveModuleLogin paramIQQLiveModuleLogin, GetRoomInfoCallback paramGetRoomInfoCallback) {}
  
  public void onFailed(int paramInt, String paramString)
  {
    QLog.e("BaseLiveRoom", 1, "login failed not getRoomRealTimeInfo");
    this.val$loginModule.unregisterLoginStateCallback(this);
    this.val$callback.a(5105, "login failed");
  }
  
  public void onSuccess(LoginInfo paramLoginInfo)
  {
    QLog.i("BaseLiveRoom", 1, "login success getRoomRealTimeInfo");
    this.val$loginModule.unregisterLoginStateCallback(this);
    BaseLiveRoom.access$100(this.this$0, this.val$callback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.room.BaseLiveRoom.2
 * JD-Core Version:    0.7.0.1
 */