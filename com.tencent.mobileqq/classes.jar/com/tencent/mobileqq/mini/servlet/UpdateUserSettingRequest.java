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
    if (paramArrayOfByte == null) {}
    do
    {
      return null;
      INTERFACE.StUpdateUserSettingRsp localStUpdateUserSettingRsp = new INTERFACE.StUpdateUserSettingRsp();
      try
      {
        localStUpdateUserSettingRsp.mergeFrom(decode(paramArrayOfByte));
        return localStUpdateUserSettingRsp;
      }
      catch (Exception paramArrayOfByte) {}
    } while (!QLog.isColorLevel());
    QLog.d("ProtoBufRequest", 2, "onResponse fail." + paramArrayOfByte);
    return null;
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.UpdateUserSettingRequest
 * JD-Core Version:    0.7.0.1
 */