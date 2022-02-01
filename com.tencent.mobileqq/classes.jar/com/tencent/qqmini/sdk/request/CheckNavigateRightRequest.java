package com.tencent.qqmini.sdk.request;

import NS_MINI_INTERFACE.INTERFACE.StCheckNavigateRightReq;
import NS_MINI_INTERFACE.INTERFACE.StCheckNavigateRightRsp;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

public class CheckNavigateRightRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_info.CheckNavigateRight";
  private static final String TAG = "GetNewBaseLibRequest";
  private INTERFACE.StCheckNavigateRightReq req = new INTERFACE.StCheckNavigateRightReq();
  
  public CheckNavigateRightRequest(String paramString1, String paramString2)
  {
    this.req.appId.set(paramString1);
    this.req.targetAppId.set(paramString2);
  }
  
  protected byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "CheckNavigateRight";
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
    INTERFACE.StCheckNavigateRightRsp localStCheckNavigateRightRsp = new INTERFACE.StCheckNavigateRightRsp();
    try
    {
      localStCheckNavigateRightRsp.mergeFrom(paramArrayOfByte);
      if (localStCheckNavigateRightRsp == null) {
        break label124;
      }
      int i = localStCheckNavigateRightRsp.actionCode.get();
      paramJSONObject.put("action_code", i);
      paramJSONObject.put("skip_local_check", localStCheckNavigateRightRsp.skipLocalCheck.get());
      if (i == 0)
      {
        paramJSONObject.put("reason", localStCheckNavigateRightRsp.wording.get());
        return paramJSONObject;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      QMLog.d("GetNewBaseLibRequest", "onResponse fail." + paramArrayOfByte);
      return null;
    }
    paramJSONObject.put("wording", localStCheckNavigateRightRsp.wording.get());
    return paramJSONObject;
    label124:
    QMLog.d("GetNewBaseLibRequest", "onResponse fail.rsp = null");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.CheckNavigateRightRequest
 * JD-Core Version:    0.7.0.1
 */