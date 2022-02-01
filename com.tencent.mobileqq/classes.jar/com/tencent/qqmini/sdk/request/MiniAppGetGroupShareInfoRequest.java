package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_SHARE.MiniProgramShare.StGetGroupShareInfoReq;
import NS_MINI_SHARE.MiniProgramShare.StGetGroupShareInfoRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

public class MiniAppGetGroupShareInfoRequest
  extends ProtoBufRequest
{
  private static final String TAG = "MiniAppGetGroupShareInfoRequest";
  private MiniProgramShare.StGetGroupShareInfoReq req = new MiniProgramShare.StGetGroupShareInfoReq();
  
  public MiniAppGetGroupShareInfoRequest(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2)
  {
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
    this.req.appid.set(paramString1);
    this.req.shareTicket.set(paramString2);
  }
  
  protected byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "GetGroupShareInfo";
  }
  
  protected String getModule()
  {
    return "mini_app_share";
  }
  
  public JSONObject getResponse(byte[] paramArrayOfByte, JSONObject paramJSONObject)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    MiniProgramShare.StGetGroupShareInfoRsp localStGetGroupShareInfoRsp = new MiniProgramShare.StGetGroupShareInfoRsp();
    try
    {
      localStGetGroupShareInfoRsp.mergeFrom(paramArrayOfByte);
      paramJSONObject.put("response", localStGetGroupShareInfoRsp);
      paramJSONObject.put("resultCode", paramJSONObject.get("retCode"));
      return paramJSONObject;
    }
    catch (Exception paramArrayOfByte)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("onResponse fail.");
      paramJSONObject.append(paramArrayOfByte);
      QMLog.d("MiniAppGetGroupShareInfoRequest", paramJSONObject.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.MiniAppGetGroupShareInfoRequest
 * JD-Core Version:    0.7.0.1
 */