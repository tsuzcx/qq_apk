package com.tencent.qqmini.sdk.request;

import NS_MINI_INTERFACE.INTERFACE.StReportExecuteReq;
import NS_MINI_INTERFACE.INTERFACE.StReportExecuteRsp;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

public class ReportExecuteRequest
  extends ProtoBufRequest
{
  public static final String TAG = "ReportExecuteRequest";
  private INTERFACE.StReportExecuteReq req = new INTERFACE.StReportExecuteReq();
  
  public ReportExecuteRequest(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.req.appid.set(paramString1);
    this.req.execTime.set(paramInt);
    this.req.instrTraceId.set(paramString2);
    this.req.ruleName.set(paramString3);
  }
  
  protected byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "ReportExecute";
  }
  
  protected String getModule()
  {
    return "mini_app_growguard";
  }
  
  public JSONObject getResponse(byte[] paramArrayOfByte, JSONObject paramJSONObject)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    INTERFACE.StReportExecuteRsp localStReportExecuteRsp = new INTERFACE.StReportExecuteRsp();
    try
    {
      localStReportExecuteRsp.mergeFrom(paramArrayOfByte);
      if (localStReportExecuteRsp != null)
      {
        paramJSONObject.put("response", localStReportExecuteRsp);
        paramJSONObject.put("resultCode", 0);
        return paramJSONObject;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      QMLog.d("ReportExecuteRequest", "onResponse fail." + paramArrayOfByte);
      return null;
    }
    QMLog.d("ReportExecuteRequest", "onResponse fail.rsp = null");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.ReportExecuteRequest
 * JD-Core Version:    0.7.0.1
 */