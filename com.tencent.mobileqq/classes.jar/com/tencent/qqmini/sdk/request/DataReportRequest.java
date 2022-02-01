package com.tencent.qqmini.sdk.request;

import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.StDataReportRsp;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

public class DataReportRequest
  extends ProtoBufRequest
{
  private static final String CMD_STRING = "LightAppSvc.mini_app_report_transfer.DataReport";
  private byte[] datas;
  
  public DataReportRequest(byte[] paramArrayOfByte)
  {
    this.datas = paramArrayOfByte;
  }
  
  public byte[] getBusiBuf()
  {
    return this.datas;
  }
  
  protected String getCmdName()
  {
    return "DataReport";
  }
  
  public String getCmdString()
  {
    return "LightAppSvc.mini_app_report_transfer.DataReport";
  }
  
  protected String getModule()
  {
    return "mini_app_report_transfer";
  }
  
  public JSONObject getResponse(byte[] paramArrayOfByte, JSONObject paramJSONObject)
  {
    if (paramArrayOfByte == null) {
      paramJSONObject = null;
    }
    for (;;)
    {
      return paramJSONObject;
      try
      {
        APP_REPORT_TRANSFER.StDataReportRsp localStDataReportRsp = new APP_REPORT_TRANSFER.StDataReportRsp();
        localStDataReportRsp.mergeFrom(paramArrayOfByte);
        int i = localStDataReportRsp.ret.get();
        if (i != 0)
        {
          QMLog.d("ProtoBufRequest", "onResponse fail.retCode = " + i);
          return null;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        QMLog.d("ProtoBufRequest", "onResponse fail." + paramArrayOfByte);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.DataReportRequest
 * JD-Core Version:    0.7.0.1
 */