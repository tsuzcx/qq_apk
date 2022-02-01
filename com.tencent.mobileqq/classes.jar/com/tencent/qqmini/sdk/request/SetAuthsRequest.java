package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StSetAuthsReq;
import NS_MINI_INTERFACE.INTERFACE.StUserAuthInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class SetAuthsRequest
  extends ProtoBufRequest
{
  private static final String TAG = "SetAuthsRequest";
  private INTERFACE.StSetAuthsReq req = new INTERFACE.StSetAuthsReq();
  
  public SetAuthsRequest(COMM.StCommonExt paramStCommonExt, String paramString, INTERFACE.StUserAuthInfo paramStUserAuthInfo)
  {
    this.req.appid.set(paramString);
    if (paramStUserAuthInfo != null)
    {
      paramString = new ArrayList();
      paramString.add(paramStUserAuthInfo);
      this.req.auths.set(paramString);
    }
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
    return "SetAuths";
  }
  
  protected String getModule()
  {
    return "mini_user_info";
  }
  
  public JSONObject getResponse(byte[] paramArrayOfByte, JSONObject paramJSONObject)
  {
    if (paramArrayOfByte != null) {
      return paramJSONObject;
    }
    try
    {
      QMLog.d("SetAuthsRequest", "onResponse fail.rsp = null");
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("onResponse fail.");
      paramJSONObject.append(paramArrayOfByte);
      QMLog.d("SetAuthsRequest", paramJSONObject.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.SetAuthsRequest
 * JD-Core Version:    0.7.0.1
 */