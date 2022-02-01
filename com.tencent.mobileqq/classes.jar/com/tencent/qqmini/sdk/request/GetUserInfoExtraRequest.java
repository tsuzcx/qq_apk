package com.tencent.qqmini.sdk.request;

import NS_MINI_INTERFACE.INTERFACE.StGetUserInfoExtraReq;
import NS_MINI_INTERFACE.INTERFACE.StGetUserInfoExtraRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

public class GetUserInfoExtraRequest
  extends ProtoBufRequest
{
  private static final String TAG = "GetUserInfoExtraRequest";
  private INTERFACE.StGetUserInfoExtraReq req = new INTERFACE.StGetUserInfoExtraReq();
  
  public GetUserInfoExtraRequest(String paramString)
  {
    this.req.appid.set(paramString);
  }
  
  protected byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "GetUserInfoExtra";
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
    INTERFACE.StGetUserInfoExtraRsp localStGetUserInfoExtraRsp = new INTERFACE.StGetUserInfoExtraRsp();
    try
    {
      localStGetUserInfoExtraRsp.mergeFrom(paramArrayOfByte);
      if (localStGetUserInfoExtraRsp != null)
      {
        paramJSONObject.put("encryptedData", localStGetUserInfoExtraRsp.encryptedData.get());
        paramJSONObject.put("iv", localStGetUserInfoExtraRsp.iv.get());
        return paramJSONObject;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      QMLog.d("GetUserInfoExtraRequest", "onResponse fail." + paramArrayOfByte);
      return null;
    }
    QMLog.d("GetUserInfoExtraRequest", "onResponse fail.rsp = null");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.GetUserInfoExtraRequest
 * JD-Core Version:    0.7.0.1
 */