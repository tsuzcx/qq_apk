package com.tencent.qqmini.sdk.request;

import NS_MINI_INTERFACE.INTERFACE.StDelPhoneNumbersReq;
import NS_MINI_INTERFACE.INTERFACE.StDelPhoneNumbersRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

public class DelPhoneNumberRequest
  extends ProtoBufRequest
{
  private static final String TAG = "DelPhoneNumberRequest";
  private INTERFACE.StDelPhoneNumbersReq req = new INTERFACE.StDelPhoneNumbersReq();
  
  public DelPhoneNumberRequest(String paramString1, String paramString2)
  {
    this.req.purePhoneNumber.set(paramString2);
    this.req.appId.set(paramString1);
  }
  
  protected byte[] getBusiBuf()
  {
    return new byte[0];
  }
  
  protected String getCmdName()
  {
    return "DelPhoneNumbers";
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
    INTERFACE.StDelPhoneNumbersRsp localStDelPhoneNumbersRsp = new INTERFACE.StDelPhoneNumbersRsp();
    try
    {
      localStDelPhoneNumbersRsp.mergeFrom(paramArrayOfByte);
      return paramJSONObject;
    }
    catch (Exception paramArrayOfByte)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("onResponse fail.");
      paramJSONObject.append(paramArrayOfByte);
      QMLog.d("DelPhoneNumberRequest", paramJSONObject.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.DelPhoneNumberRequest
 * JD-Core Version:    0.7.0.1
 */