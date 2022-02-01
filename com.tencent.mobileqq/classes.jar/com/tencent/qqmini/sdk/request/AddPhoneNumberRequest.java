package com.tencent.qqmini.sdk.request;

import NS_MINI_INTERFACE.INTERFACE.StAddPhoneNumberReq;
import NS_MINI_INTERFACE.INTERFACE.StAddPhoneNumberRsp;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

public class AddPhoneNumberRequest
  extends ProtoBufRequest
{
  private static final String TAG = "AddPhoneNumberRequest";
  private INTERFACE.StAddPhoneNumberReq req = new INTERFACE.StAddPhoneNumberReq();
  
  public AddPhoneNumberRequest(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.req.purePhoneNumber.set(paramString2);
    this.req.countryCode.set(paramString3);
    this.req.isSave.set(paramInt);
    this.req.appId.set(paramString1);
  }
  
  protected byte[] getBusiBuf()
  {
    return new byte[0];
  }
  
  protected String getCmdName()
  {
    return "GetPhoneNumber";
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
    INTERFACE.StAddPhoneNumberRsp localStAddPhoneNumberRsp = new INTERFACE.StAddPhoneNumberRsp();
    try
    {
      localStAddPhoneNumberRsp.mergeFrom(paramArrayOfByte);
      if (localStAddPhoneNumberRsp != null)
      {
        paramJSONObject.put("encryptedData", localStAddPhoneNumberRsp.encryptedData.get());
        paramJSONObject.put("iv", localStAddPhoneNumberRsp.iv.get());
        return paramJSONObject;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      QMLog.d("AddPhoneNumberRequest", "onResponse fail." + paramArrayOfByte);
      return null;
    }
    QMLog.d("AddPhoneNumberRequest", "onResponse fail.rsp = null");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.AddPhoneNumberRequest
 * JD-Core Version:    0.7.0.1
 */