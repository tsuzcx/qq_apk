package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StGetSDKOpenKeyTokenReq;
import NS_MINI_INTERFACE.INTERFACE.StGetSDKOpenKeyTokenRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

public class GetSDKOpenKeyTokenRequest
  extends ProtoBufRequest
{
  public static final String TAG = "GetSDKOpenKeyTokenRequest";
  private INTERFACE.StGetSDKOpenKeyTokenReq req = new INTERFACE.StGetSDKOpenKeyTokenReq();
  
  public GetSDKOpenKeyTokenRequest(COMM.StCommonExt paramStCommonExt)
  {
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
    return "GetSDKOpenKeyToken";
  }
  
  protected String getModule()
  {
    return "mini_program_auth";
  }
  
  public JSONObject getResponse(byte[] paramArrayOfByte, JSONObject paramJSONObject)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    INTERFACE.StGetSDKOpenKeyTokenRsp localStGetSDKOpenKeyTokenRsp = new INTERFACE.StGetSDKOpenKeyTokenRsp();
    try
    {
      localStGetSDKOpenKeyTokenRsp.mergeFrom(paramArrayOfByte);
      if (localStGetSDKOpenKeyTokenRsp != null)
      {
        paramJSONObject.put("token", localStGetSDKOpenKeyTokenRsp.token.get());
        return paramJSONObject;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      QMLog.d("GetSDKOpenKeyTokenRequest", "onResponse fail." + paramArrayOfByte);
      return null;
    }
    QMLog.d("GetSDKOpenKeyTokenRequest", "onResponse fail.rsp = null");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.GetSDKOpenKeyTokenRequest
 * JD-Core Version:    0.7.0.1
 */