package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StUpdateUserSettingReq;
import NS_MINI_INTERFACE.INTERFACE.StUpdateUserSettingRsp;
import NS_MINI_INTERFACE.INTERFACE.StUserSettingInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class UpdateUserSettingRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_user_info.UpdateUserSetting";
  private INTERFACE.StUpdateUserSettingReq req = new INTERFACE.StUpdateUserSettingReq();
  
  public UpdateUserSettingRequest(COMM.StCommonExt paramStCommonExt, String paramString, INTERFACE.StUserSettingInfo paramStUserSettingInfo)
  {
    this.req.appid.set(paramString);
    if (paramStUserSettingInfo != null) {
      this.req.setting.set(paramStUserSettingInfo);
    }
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
  }
  
  public static INTERFACE.StUpdateUserSettingRsp onResponse(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    Object localObject = new INTERFACE.StUpdateUserSettingRsp();
    try
    {
      ((INTERFACE.StUpdateUserSettingRsp)localObject).mergeFrom(decode(paramArrayOfByte));
      return localObject;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onResponse fail.");
        ((StringBuilder)localObject).append(paramArrayOfByte);
        QLog.d("ProtoBufRequest", 2, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.UpdateUserSettingRequest
 * JD-Core Version:    0.7.0.1
 */