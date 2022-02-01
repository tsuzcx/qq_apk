package com.tencent.qqmini.sdk.request;

import NS_MINI_INTERFACE.INTERFACE.StCheckSessionReq;
import NS_MINI_INTERFACE.INTERFACE.StCheckSessionRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

public class CheckSessionRequest
  extends ProtoBufRequest
{
  private INTERFACE.StCheckSessionReq req = new INTERFACE.StCheckSessionReq();
  
  public CheckSessionRequest(String paramString)
  {
    this.req.appid.set(paramString);
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "CheckSession";
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
    INTERFACE.StCheckSessionRsp localStCheckSessionRsp = new INTERFACE.StCheckSessionRsp();
    try
    {
      localStCheckSessionRsp.mergeFrom(paramArrayOfByte);
      return paramJSONObject;
    }
    catch (Exception paramArrayOfByte)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("onResponse fail.");
      paramJSONObject.append(paramArrayOfByte);
      QMLog.d("ProtoBufRequest", paramJSONObject.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.CheckSessionRequest
 * JD-Core Version:    0.7.0.1
 */