package com.tencent.qqmini.sdk.request;

import NS_MINI_INTERFACE.INTERFACE.StCheckBindingStateReq;
import NS_MINI_INTERFACE.INTERFACE.StCheckBindingStateRsp;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

public class CheckBindingStateRequest
  extends ProtoBufRequest
{
  private static final String TAG = "CheckBindingStateRequest";
  private INTERFACE.StCheckBindingStateReq req = new INTERFACE.StCheckBindingStateReq();
  
  public CheckBindingStateRequest(String paramString1, String paramString2, int paramInt)
  {
    this.req.appId.set(paramString1);
    this.req.uid.set(paramString2);
    this.req.bindType.set(paramInt);
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "CheckBindingState";
  }
  
  protected String getModule()
  {
    return "mini_native_page";
  }
  
  public JSONObject getResponse(byte[] paramArrayOfByte, JSONObject paramJSONObject)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    INTERFACE.StCheckBindingStateRsp localStCheckBindingStateRsp = new INTERFACE.StCheckBindingStateRsp();
    try
    {
      localStCheckBindingStateRsp.mergeFrom(paramArrayOfByte);
      paramJSONObject.put("key_check_State", localStCheckBindingStateRsp.bindingState.get());
      return paramJSONObject;
    }
    catch (Exception paramArrayOfByte)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("onResponse fail.");
      paramJSONObject.append(paramArrayOfByte);
      QMLog.d("CheckBindingStateRequest", paramJSONObject.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.CheckBindingStateRequest
 * JD-Core Version:    0.7.0.1
 */