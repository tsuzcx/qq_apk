package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StGetRobotUinReq;
import NS_MINI_INTERFACE.INTERFACE.StGetRobotUinRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

public class GetRobotUinRequest
  extends ProtoBufRequest
{
  public static final String TAG = "GetRobotUinRequest";
  private INTERFACE.StGetRobotUinReq req = new INTERFACE.StGetRobotUinReq();
  
  public GetRobotUinRequest(COMM.StCommonExt paramStCommonExt, String paramString)
  {
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
    this.req.appid.set(paramString);
  }
  
  protected byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "GetRobotUin";
  }
  
  protected String getModule()
  {
    return "mini_app_info";
  }
  
  public JSONObject getResponse(byte[] paramArrayOfByte, JSONObject paramJSONObject)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    INTERFACE.StGetRobotUinRsp localStGetRobotUinRsp = new INTERFACE.StGetRobotUinRsp();
    try
    {
      localStGetRobotUinRsp.mergeFrom(paramArrayOfByte);
      paramJSONObject.put("robotUin", localStGetRobotUinRsp.uin.get());
      return paramJSONObject;
    }
    catch (Exception paramArrayOfByte)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("onResponse fail.");
      paramJSONObject.append(paramArrayOfByte);
      QMLog.d("GetRobotUinRequest", paramJSONObject.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.GetRobotUinRequest
 * JD-Core Version:    0.7.0.1
 */