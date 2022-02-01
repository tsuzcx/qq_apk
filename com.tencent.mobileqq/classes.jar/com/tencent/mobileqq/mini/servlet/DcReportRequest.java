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
    if (paramArrayOfByte == null) {
      return null;
    }
    Object localObject = new REPORT.StDcReportRsp();
    try
    {
      ((REPORT.StDcReportRsp)localObject).mergeFrom(decode(paramArrayOfByte));
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
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.DcReportRequest
 * JD-Core Version:    0.7.0.1
 */