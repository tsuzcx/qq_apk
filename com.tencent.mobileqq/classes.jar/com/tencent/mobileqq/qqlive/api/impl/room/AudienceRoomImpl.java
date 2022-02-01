package com.tencent.mobileqq.qqlive.api.impl.room;

import android.os.Bundle;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.datareport.IDataReportModule;
import com.tencent.mobileqq.qqlive.api.impl.room.report.AudienceRoomTechReporter;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.api.room.IAudienceRoom;
import com.tencent.mobileqq.qqlive.callback.login.IQQLiveLoginCallback;
import com.tencent.mobileqq.qqlive.callback.room.audience.EnterAudienceRoomCallback;
import com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.data.record.QQLiveCurRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.EnterRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveRoomInfo;
import com.tencent.qphone.base.util.QLog;

public class AudienceRoomImpl
  extends LiveTPPlayerRoom
  implements IAudienceRoom
{
  private static final String TAG = "AudienceRoomImpl";
  private AudienceRoomEnterExitModule enterRoomModule = new AudienceRoomEnterExitModule();
  private IQQLiveLoginCallback loginCallback = null;
  AudienceRoomTechReporter techReporter = new AudienceRoomTechReporter();
  
  public AudienceRoomImpl()
  {
    this(Boolean.valueOf(true));
  }
  
  public AudienceRoomImpl(Boolean paramBoolean)
  {
    super(paramBoolean.booleanValue());
  }
  
  private void doEnterRoom(EnterRoomInfo paramEnterRoomInfo, boolean paramBoolean, EnterAudienceRoomCallback paramEnterAudienceRoomCallback)
  {
    QLog.i("AudienceRoomImpl", 1, "doEnterRoom");
    this.enterRoomModule.enterRoom(paramEnterRoomInfo, this.liveSDK, new AudienceRoomImpl.3(this, paramEnterRoomInfo, paramBoolean, paramEnterAudienceRoomCallback));
  }
  
  private void recordCurRoom(LiveInfo paramLiveInfo)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("recordCurRoom liveInfo:");
      ((StringBuilder)localObject).append(paramLiveInfo);
      QLog.d("AudienceRoomImpl", 2, ((StringBuilder)localObject).toString());
    }
    if (this.liveSDK != null)
    {
      if (paramLiveInfo.roomInfo == null)
      {
        QLog.e("AudienceRoomImpl", 1, "doEnterRoom onSuccess recordRoomInfo, something null");
        return;
      }
      localObject = new QQLiveCurRoomInfo();
      ((QQLiveCurRoomInfo)localObject).roomId = paramLiveInfo.roomInfo.roomId;
      ((QQLiveCurRoomInfo)localObject).roomType = 2;
      paramLiveInfo = this.liveSDK.getLoginModule();
      if ((paramLiveInfo != null) && (paramLiveInfo.getLoginInfo() != null)) {
        ((QQLiveCurRoomInfo)localObject).uid = this.liveSDK.getLoginModule().getLoginInfo().uid;
      }
      if (QLog.isColorLevel())
      {
        paramLiveInfo = new StringBuilder();
        paramLiveInfo.append("recordCurRoom curRoomInfo:");
        paramLiveInfo.append(localObject);
        QLog.d("AudienceRoomImpl", 2, paramLiveInfo.toString());
      }
      this.liveSDK.recordCurRoomInfo((QQLiveCurRoomInfo)localObject);
      return;
    }
    QLog.e("AudienceRoomImpl", 1, "recordCurRoom liveSDK is null");
  }
  
  public void destroy()
  {
    super.destroy();
    this.enterRoomModule = null;
    this.liveSDK.getLoginModule().unregisterLoginStateCallback(this.loginCallback);
    this.loginCallback = null;
  }
  
  public void enterRoom(EnterRoomInfo paramEnterRoomInfo, boolean paramBoolean, EnterAudienceRoomCallback paramEnterAudienceRoomCallback)
  {
    if (this.isDestroy)
    {
      QLog.e("AudienceRoomImpl", 1, "enterRoom, but destroy");
      return;
    }
    this.isExitRoom = false;
    this.techReporter.onEnterRoomStart();
    IQQLiveModuleLogin localIQQLiveModuleLogin = this.liveSDK.getLoginModule();
    if ((localIQQLiveModuleLogin.getLoginStatus() != 3) && (localIQQLiveModuleLogin.getLoginStatus() != 0))
    {
      if (localIQQLiveModuleLogin.getLoginStatus() == 2)
      {
        QLog.i("AudienceRoomImpl", 1, "enterRoom waiting login");
        IQQLiveLoginCallback localIQQLiveLoginCallback = this.loginCallback;
        if (localIQQLiveLoginCallback != null) {
          localIQQLiveModuleLogin.unregisterLoginStateCallback(localIQQLiveLoginCallback);
        }
        this.loginCallback = new AudienceRoomImpl.2(this, localIQQLiveModuleLogin, paramEnterRoomInfo, paramBoolean, paramEnterAudienceRoomCallback);
        localIQQLiveModuleLogin.registerLoginStateCallback(this.loginCallback);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AudienceRoomImpl", 2, "direct doEnterRoom");
      }
      this.liveSDK.getDataReportModule().setLoginInfo(localIQQLiveModuleLogin.getLoginInfo());
      doEnterRoom(paramEnterRoomInfo, paramBoolean, paramEnterAudienceRoomCallback);
      return;
    }
    paramEnterRoomInfo = new StringBuilder();
    paramEnterRoomInfo.append("enterRoom failed loginStatus is ");
    paramEnterRoomInfo.append(localIQQLiveModuleLogin.getLoginStatus());
    QLog.e("AudienceRoomImpl", 1, paramEnterRoomInfo.toString());
    paramEnterAudienceRoomCallback.onFailed(5105, "login failed");
  }
  
  public void exitRoom(ExitRoomCallback paramExitRoomCallback)
  {
    if (this.isDestroy)
    {
      QLog.e("AudienceRoomImpl", 1, "exitRoom, but destroy");
      return;
    }
    this.techReporter.onExitRoomStart();
    super.exitRoom(paramExitRoomCallback);
    this.enterRoomModule.exitRoom(this.liveSDK, new AudienceRoomImpl.4(this, paramExitRoomCallback));
    if (this.liveSDK != null)
    {
      paramExitRoomCallback = this.enterRoomModule;
      if ((paramExitRoomCallback != null) && (paramExitRoomCallback.currentInfo != null)) {
        this.liveSDK.removeCurRoomRecord(this.enterRoomModule.currentInfo.getRoomId());
      }
    }
  }
  
  public BaseAnchorInfo getAnchorInfo()
  {
    if (this.isDestroy) {
      return null;
    }
    if (this.enterRoomModule.liveInfo != null) {
      return this.enterRoomModule.liveInfo.anchorInfo;
    }
    return null;
  }
  
  public BaseRoomInfo getRoomInfo()
  {
    if (this.isDestroy) {
      return null;
    }
    if ((this.enterRoomModule.liveInfo != null) && (this.enterRoomModule.liveInfo.roomInfo != null)) {
      return this.enterRoomModule.liveInfo.roomInfo;
    }
    return this.enterRoomModule.currentInfo;
  }
  
  public LiveInfo getRoomLiveInfo()
  {
    if (this.isDestroy) {
      return null;
    }
    return this.enterRoomModule.liveInfo;
  }
  
  public void init(IQQLiveSDK paramIQQLiveSDK)
  {
    super.init(paramIQQLiveSDK);
    this.isInited = true;
    this.techReporter.init(paramIQQLiveSDK);
    if (this.playModule != null) {
      this.playModule.registerRoomPlayerListener(this.techReporter);
    }
  }
  
  public boolean isAnchorRoom()
  {
    return false;
  }
  
  protected void onEnterRoom()
  {
    if (this.isDestroy) {
      return;
    }
    super.onEnterRoom();
    this.roomStatusService.registerRoomInfoListener(new AudienceRoomImpl.1(this));
  }
  
  public void preloadUrl(String paramString)
  {
    this.techReporter.setMediaUrl(paramString);
    super.preloadUrl(paramString);
  }
  
  public void reset()
  {
    if (this.isDestroy) {
      return;
    }
    super.reset();
    this.liveSDK.getLoginModule().unregisterLoginStateCallback(this.loginCallback);
    this.loginCallback = null;
    if (this.playModule != null) {
      this.playModule.registerRoomPlayerListener(this.techReporter);
    }
    this.techReporter.reset();
  }
  
  public void setExtraData(Bundle paramBundle)
  {
    this.techReporter.setExtraData(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.room.AudienceRoomImpl
 * JD-Core Version:    0.7.0.1
 */