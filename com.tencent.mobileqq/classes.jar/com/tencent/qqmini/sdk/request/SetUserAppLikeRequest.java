package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StSetUserAppLikeReq;
import NS_MINI_INTERFACE.INTERFACE.StSetUserAppLikeRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

public class SetUserAppLikeRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_userapp.SetUserAppLike";
  public static final String TAG = "SetUserAppLikeRequest";
  private INTERFACE.StSetUserAppLikeReq req = new INTERFACE.StSetUserAppLikeReq();
  
  public SetUserAppLikeRequest(COMM.StCommonExt paramStCommonExt, String paramString, int paramInt)
  {
    this.req.appId.set(paramString);
    this.req.doLike.set(paramInt);
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "SetUserAppLike";
  }
  
  protected String getModule()
  {
    return "mini_app_userapp";
  }
  
  public JSONObject getResponse(byte[] paramArrayOfByte, JSONObject paramJSONObject)
  {
    INTERFACE.StSetUserAppLikeRsp localStSetUserAppLikeRsp = new INTERFACE.StSetUserAppLikeRsp();
    localStSetUserAppLikeRsp.mergeFrom(paramArrayOfByte);
    if (localStSetUserAppLikeRsp != null)
    {
      paramJSONObject.put("response", localStSetUserAppLikeRsp);
      paramJSONObject.put("resultCode", 0);
      return paramJSONObject;
    }
    QMLog.d("SetUserAppLikeRequest", "onResponse fail.rsp = null");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.SetUserAppLikeRequest
 * JD-Core Version:    0.7.0.1
 */