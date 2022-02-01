package com.tencent.qqmini.sdk.request;

import NS_MINI_INTERFACE.INTERFACE.StGetFormIdReq;
import NS_MINI_INTERFACE.INTERFACE.StGetFormIdRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

public class GetFormIdRequest
  extends ProtoBufRequest
{
  private static final String TAG = "GetFormIdRequest";
  private INTERFACE.StGetFormIdReq req = new INTERFACE.StGetFormIdReq();
  
  public GetFormIdRequest(String paramString)
  {
    this.req.appid.set(paramString);
  }
  
  protected byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "GetFormId";
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
    INTERFACE.StGetFormIdRsp localStGetFormIdRsp = new INTERFACE.StGetFormIdRsp();
    try
    {
      localStGetFormIdRsp.mergeFrom(paramArrayOfByte);
      paramJSONObject.put("formId", localStGetFormIdRsp.formId.get());
      return paramJSONObject;
    }
    catch (Exception paramArrayOfByte)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("onResponse fail.");
      paramJSONObject.append(paramArrayOfByte);
      QMLog.d("GetFormIdRequest", paramJSONObject.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.GetFormIdRequest
 * JD-Core Version:    0.7.0.1
 */