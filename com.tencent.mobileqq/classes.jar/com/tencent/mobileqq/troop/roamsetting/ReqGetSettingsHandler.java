package com.tencent.mobileqq.troop.roamsetting;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.troop.roamsetting.api.IRoamSettingService;
import com.tencent.mobileqq.troop.roamsetting.api.impl.RoamSettingServiceImpl;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class ReqGetSettingsHandler
  extends RoamSettingHandler
  implements IReqGetSettingsHandler
{
  private ToServiceMsg a;
  
  public ReqGetSettingsHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public ToServiceMsg a()
  {
    return this.a;
  }
  
  public void a(boolean paramBoolean)
  {
    ((RoamSettingServiceImpl)this.appRuntime.getRuntimeService(IRoamSettingService.class, "")).loadAllRoamSettings(paramBoolean, this);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    FromServiceMsg localFromServiceMsg = new FromServiceMsg(this.appRuntime.getAccount(), "ProfileService.ReqGetSettings");
    localFromServiceMsg.setMsgSuccess();
    localFromServiceMsg.putWupBuffer(paramArrayOfByte);
    this.appRuntime.receiveToService(this.a, localFromServiceMsg);
  }
  
  public void send(ToServiceMsg paramToServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RoamSettingHandler", 2, "ReqGetSettingsItem.send...");
    }
    this.a = paramToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.roamsetting.ReqGetSettingsHandler
 * JD-Core Version:    0.7.0.1
 */