package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StSetUserAvatarReq;
import NS_MINI_INTERFACE.INTERFACE.StSetUserAvatarRsp;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

public class SetAvatarRequest
  extends ProtoBufRequest
{
  private static final String TAG = "SetAvatarRequest";
  private INTERFACE.StSetUserAvatarReq req = new INTERFACE.StSetUserAvatarReq();
  
  public SetAvatarRequest(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    this.req.appid.set(paramString1);
    this.req.uin.set(paramString2);
    this.req.set_type.set(paramInt);
    this.req.item_id.set(paramString3);
    this.req.busi_info.set(paramString4);
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
  }
  
  protected byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "SetUserAvatar";
  }
  
  protected String getModule()
  {
    return "mini_app_userapp";
  }
  
  public JSONObject getResponse(byte[] paramArrayOfByte, JSONObject paramJSONObject)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    INTERFACE.StSetUserAvatarRsp localStSetUserAvatarRsp = new INTERFACE.StSetUserAvatarRsp();
    try
    {
      localStSetUserAvatarRsp.mergeFrom(paramArrayOfByte);
      return paramJSONObject;
    }
    catch (Exception paramArrayOfByte)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("onResponse fail.");
      paramJSONObject.append(paramArrayOfByte);
      QMLog.d("SetAvatarRequest", paramJSONObject.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.SetAvatarRequest
 * JD-Core Version:    0.7.0.1
 */