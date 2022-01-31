package com.tencent.mobileqq.mini.servlet;

import NS_MINI_REPORT.REPORT.StDcReportRsp;
import com.tencent.qphone.base.util.QLog;

public class DcReportRequest
  extends ProtoBufRequest
{
  private byte[] datas;
  
  public DcReportRequest(byte[] paramArrayOfByte)
  {
    this.datas = paramArrayOfByte;
  }
  
  public static REPORT.StDcReportRsp onResponse(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    do
    {
      return null;
      REPORT.StDcReportRsp localStDcReportRsp = new REPORT.StDcReportRsp();
      try
      {
        localStDcReportRsp.mergeFrom(decode(paramArrayOfByte));
        return localStDcReportRsp;
      }
      catch (Exception paramArrayOfByte) {}
    } while (!QLog.isColorLevel());
    QLog.d("ProtoBufRequest", 2, "onResponse fail." + paramArrayOfByte);
    return null;
  }
  
  public byte[] getBusiBuf()
  {
    return this.datas;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.DcReportRequest
 * JD-Core Version:    0.7.0.1
 */