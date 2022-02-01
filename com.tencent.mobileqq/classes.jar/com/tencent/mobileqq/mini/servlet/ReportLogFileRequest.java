package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StReportLogFileReq;
import NS_MINI_INTERFACE.INTERFACE.StReportLogFileRsp;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class ReportLogFileRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_info.ReportLogFile";
  public static final String TAG = "ReportLogFileRequest";
  private INTERFACE.StReportLogFileReq req = new INTERFACE.StReportLogFileReq();
  
  public ReportLogFileRequest(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2, int paramInt)
  {
    this.req.appid.set(paramString1);
    this.req.fileUrl.set(paramString2);
    this.req.fileSize.set(paramInt);
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
  }
  
  public static INTERFACE.StReportLogFileRsp onResponse(byte[] paramArrayOfByte)
  {
    INTERFACE.StReportLogFileRsp localStReportLogFileRsp = new INTERFACE.StReportLogFileRsp();
    try
    {
      localStReportLogFileRsp.mergeFrom(decode(paramArrayOfByte));
      return localStReportLogFileRsp;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReportLogFileRequest", 2, "onResponse fail." + paramArrayOfByte);
      }
    }
    return null;
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.ReportLogFileRequest
 * JD-Core Version:    0.7.0.1
 */