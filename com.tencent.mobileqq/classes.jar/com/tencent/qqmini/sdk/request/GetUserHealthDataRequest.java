package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StGetUserHealthDataReq;
import NS_MINI_INTERFACE.INTERFACE.StGetUserHealthDataRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

public class GetUserHealthDataRequest
  extends ProtoBufRequest
{
  public static final String TAG = "GetUserHealthDataRequest";
  private INTERFACE.StGetUserHealthDataReq req = new INTERFACE.StGetUserHealthDataReq();
  
  public GetUserHealthDataRequest(COMM.StCommonExt paramStCommonExt, String paramString)
  {
    this.req.appid.set(paramString);
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
    return "GetUserHealthData";
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
    INTERFACE.StGetUserHealthDataRsp localStGetUserHealthDataRsp = new INTERFACE.StGetUserHealthDataRsp();
    try
    {
      localStGetUserHealthDataRsp.mergeFrom(paramArrayOfByte);
      paramJSONObject.put("encryptedData", localStGetUserHealthDataRsp.encryptedData.get());
      paramJSONObject.put("iv", localStGetUserHealthDataRsp.iv.get());
      return paramJSONObject;
    }
    catch (Exception paramArrayOfByte)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("onResponse fail.");
      paramJSONObject.append(paramArrayOfByte);
      QMLog.d("GetUserHealthDataRequest", paramJSONObject.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.GetUserHealthDataRequest
 * JD-Core Version:    0.7.0.1
 */