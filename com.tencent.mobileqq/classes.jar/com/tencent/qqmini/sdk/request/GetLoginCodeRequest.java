package com.tencent.qqmini.sdk.request;

import NS_MINI_INTERFACE.INTERFACE.StGetCodeReq;
import NS_MINI_INTERFACE.INTERFACE.StGetCodeRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

public class GetLoginCodeRequest
  extends ProtoBufRequest
{
  private INTERFACE.StGetCodeReq req = new INTERFACE.StGetCodeReq();
  
  public GetLoginCodeRequest(String paramString)
  {
    this.req.appid.set(paramString);
  }
  
  protected byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "GetCode";
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
    INTERFACE.StGetCodeRsp localStGetCodeRsp = new INTERFACE.StGetCodeRsp();
    try
    {
      localStGetCodeRsp.mergeFrom(paramArrayOfByte);
      if (localStGetCodeRsp != null)
      {
        paramJSONObject.put("code", localStGetCodeRsp.code.get());
        return paramJSONObject;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      QMLog.d("ProtoBufRequest", "onResponse fail." + paramArrayOfByte);
      return null;
    }
    QMLog.d("ProtoBufRequest", "onResponse fail.rsp = null");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.GetLoginCodeRequest
 * JD-Core Version:    0.7.0.1
 */