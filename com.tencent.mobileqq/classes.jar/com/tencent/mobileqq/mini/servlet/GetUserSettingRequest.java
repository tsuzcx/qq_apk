package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE.StGetUserSettingReq;
import NS_MINI_INTERFACE.INTERFACE.StGetUserSettingRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class GetUserSettingRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_user_info.GetUserSetting";
  public static final String TAG = "VerifyPluginRequest";
  private INTERFACE.StGetUserSettingReq req = new INTERFACE.StGetUserSettingReq();
  
  public GetUserSettingRequest(String paramString1, String paramString2, String paramString3)
  {
    this.req.appid.set(paramString1);
    this.req.openid.set(paramString2);
    this.req.settingItem.set(paramString3);
  }
  
  public static INTERFACE.StGetUserSettingRsp onResponse(byte[] paramArrayOfByte)
  {
    INTERFACE.StGetUserSettingRsp localStGetUserSettingRsp = new INTERFACE.StGetUserSettingRsp();
    try
    {
      localStGetUserSettingRsp.mergeFrom(decode(paramArrayOfByte));
      return localStGetUserSettingRsp;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VerifyPluginRequest", 2, "onResponse fail." + paramArrayOfByte);
      }
    }
    return null;
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.GetUserSettingRequest
 * JD-Core Version:    0.7.0.1
 */