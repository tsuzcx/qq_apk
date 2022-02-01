package com.tencent.mobileqq.mini.servlet;

import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.StDataReportRsp;
import com.tencent.qphone.base.util.QLog;

public class DataReportRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_report_transfer.DataReport";
  private byte[] datas;
  
  public DataReportRequest(byte[] paramArrayOfByte)
  {
    this.datas = paramArrayOfByte;
  }
  
  public static APP_REPORT_TRANSFER.StDataReportRsp onResponse(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    Object localObject = new APP_REPORT_TRANSFER.StDataReportRsp();
    try
    {
      ((APP_REPORT_TRANSFER.StDataReportRsp)localObject).mergeFrom(decode(paramArrayOfByte));
      return localObject;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onResponse fail.");
        ((StringBuilder)localObject).append(paramArrayOfByte);
        QLog.d("ProtoBufRequest", 2, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  public byte[] getBusiBuf()
  {
    return this.datas;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.DataReportRequest
 * JD-Core Version:    0.7.0.1
 */