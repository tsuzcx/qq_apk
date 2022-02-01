package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StGetUserAppInfoReq;
import NS_MINI_INTERFACE.INTERFACE.StGetUserAppInfoRsp;
import com.tencent.mobileqq.pb.PBRepeatField;
import java.util.List;
import org.json.JSONObject;

public class GetUserAppInfoRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_userapp.GetUserAppInfo";
  public static final String TAG = "GetUserAppInfoRequest";
  private INTERFACE.StGetUserAppInfoReq req = new INTERFACE.StGetUserAppInfoReq();
  
  public GetUserAppInfoRequest(COMM.StCommonExt paramStCommonExt, List<String> paramList)
  {
    this.req.appIds.set(paramList);
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
    return "GetUserAppInfo";
  }
  
  protected String getModule()
  {
    return "mini_app_userapp";
  }
  
  public JSONObject getResponse(byte[] paramArrayOfByte, JSONObject paramJSONObject)
  {
    INTERFACE.StGetUserAppInfoRsp localStGetUserAppInfoRsp = new INTERFACE.StGetUserAppInfoRsp();
    localStGetUserAppInfoRsp.mergeFrom(paramArrayOfByte);
    paramJSONObject.put("response", localStGetUserAppInfoRsp);
    paramJSONObject.put("resultCode", 0);
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.GetUserAppInfoRequest
 * JD-Core Version:    0.7.0.1
 */