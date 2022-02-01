package com.tencent.qqmini.sdk.request;

import NS_MINI_INTERFACE.INTERFACE.StGetUserSettingReq;
import NS_MINI_INTERFACE.INTERFACE.StGetUserSettingRsp;
import NS_MINI_INTERFACE.INTERFACE.StUserSettingInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

public class GetUserSettingRequest
  extends ProtoBufRequest
{
  private static final String TAG = "VerifyPluginRequest";
  private INTERFACE.StGetUserSettingReq req = new INTERFACE.StGetUserSettingReq();
  
  public GetUserSettingRequest(String paramString1, String paramString2, String paramString3)
  {
    this.req.appid.set(paramString1);
    this.req.openid.set(paramString2);
    this.req.settingItem.set(paramString3);
  }
  
  protected byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "GetUserSetting";
  }
  
  protected String getModule()
  {
    return "mini_user_info";
  }
  
  public JSONObject getResponse(byte[] paramArrayOfByte, JSONObject paramJSONObject)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    INTERFACE.StGetUserSettingRsp localStGetUserSettingRsp = new INTERFACE.StGetUserSettingRsp();
    try
    {
      localStGetUserSettingRsp.mergeFrom(paramArrayOfByte);
      if (localStGetUserSettingRsp.setting != null)
      {
        paramJSONObject.put("settingItem", localStGetUserSettingRsp.setting.settingItem.get());
        paramJSONObject.put("desc", localStGetUserSettingRsp.setting.desc.get());
        paramJSONObject.put("authState", localStGetUserSettingRsp.setting.authState.get());
        return paramJSONObject;
      }
      QMLog.d("VerifyPluginRequest", "onResponse fail.rsp = null");
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("onResponse fail.");
      paramJSONObject.append(paramArrayOfByte);
      QMLog.d("VerifyPluginRequest", paramJSONObject.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.GetUserSettingRequest
 * JD-Core Version:    0.7.0.1
 */