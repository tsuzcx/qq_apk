package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StGetAuthListReq;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

public class GetAuthListsRequest
  extends ProtoBufRequest
{
  private static final String TAG = "GetAuthListsRequest";
  private INTERFACE.StGetAuthListReq req = new INTERFACE.StGetAuthListReq();
  
  public GetAuthListsRequest(COMM.StCommonExt paramStCommonExt, String paramString)
  {
    this.req.appid.set(paramString);
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
    return "GetAuthList";
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
    if (paramArrayOfByte != null) {}
    try
    {
      paramJSONObject.put("authList", paramArrayOfByte);
      return paramJSONObject;
    }
    catch (Exception paramJSONObject)
    {
      break label29;
    }
    QMLog.d("GetAuthListsRequest", "onResponse fail.data = null");
    return null;
    label29:
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("onResponse fail.");
    paramArrayOfByte.append(paramJSONObject);
    QMLog.d("GetAuthListsRequest", paramArrayOfByte.toString());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.GetAuthListsRequest
 * JD-Core Version:    0.7.0.1
 */