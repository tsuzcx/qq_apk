package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE.StGetUserSettingReq;
import NS_MINI_INTERFACE.INTERFACE.StGetUserSettingRsp;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class GetUserSettingRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_user_info.GetUserSetting";
  public static final String TAG = "VerifyPluginRequest";
  private INTERFACE.StGetUserSettingReq req = new INTERFACE.StGetUserSettingReq();
  
  public GetUserSettingRequest(String paramString1, String paramString2, String paramString3, List<String> paramList)
  {
    if (paramString1 != null) {
      this.req.appid.set(paramString1);
    }
    if (paramString2 != null) {
      this.req.openid.set(paramString2);
    }
    if (paramString3 != null) {
      this.req.settingItem.set(paramString3);
    }
    if (paramList != null) {
      this.req.templateIds.set(paramList);
    }
  }
  
  public static INTERFACE.StGetUserSettingRsp onResponse(byte[] paramArrayOfByte)
  {
    Object localObject = new INTERFACE.StGetUserSettingRsp();
    try
    {
      ((INTERFACE.StGetUserSettingRsp)localObject).mergeFrom(decode(paramArrayOfByte));
      return localObject;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onResponse fail.");
        ((StringBuilder)localObject).append(paramArrayOfByte);
        QLog.d("VerifyPluginRequest", 2, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.GetUserSettingRequest
 * JD-Core Version:    0.7.0.1
 */