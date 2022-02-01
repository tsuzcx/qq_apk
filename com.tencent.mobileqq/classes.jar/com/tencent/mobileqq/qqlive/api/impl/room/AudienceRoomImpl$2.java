package com.tencent.mobileqq.qqlive.api.impl.room;

import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.datareport.IDataReportModule;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.callback.login.IQQLiveLoginCallback;
import com.tencent.mobileqq.qqlive.callback.room.audience.EnterAudienceRoomCallback;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.data.room.EnterRoomInfo;
import com.tencent.qphone.base.util.QLog;

class AudienceRoomImpl$2
  implements IQQLiveLoginCallback
{
  AudienceRoomImpl$2(AudienceRoomImpl paramAudienceRoomImpl, IQQLiveModuleLogin paramIQQLiveModuleLogin, EnterRoomInfo paramEnterRoomInfo, boolean paramBoolean, EnterAudienceRoomCallback paramEnterAudienceRoomCallback) {}
  
  public void onFailed(int paramInt, String paramString)
  {
    QLog.e("AudienceRoomImpl", 1, "login failed not doEnterRoom");
    this.val$loginModule.unregisterLoginStateCallback(this);
    this.val$callback.onFailed(5105, "login failed");
  }
  
  public void onSuccess(LoginInfo paramLoginInfo)
  {
    QLog.i("AudienceRoomImpl", 1, "login success doEnterRoom");
    this.val$loginModule.unregisterLoginStateCallback(this);
    this.this$0.liveSDK.getDataReportModule().setLoginInfo(paramLoginInfo);
    AudienceRoomImpl.access$000(this.this$0, this.val$roomInfo, this.val$autoPlay, this.val$callback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.room.AudienceRoomImpl.2
 * JD-Core Version:    0.7.0.1
 */