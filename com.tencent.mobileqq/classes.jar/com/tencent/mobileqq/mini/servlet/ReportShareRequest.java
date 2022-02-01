package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE.StReportShareReq;
import NS_MINI_INTERFACE.INTERFACE.StReportShareRsp;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

public class ReportShareRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_usr_time.ReportShare";
  public static final String TAG = "ReportShareRequest";
  private INTERFACE.StReportShareReq req = new INTERFACE.StReportShareReq();
  
  public ReportShareRequest(long paramLong, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    this.req.reportTime.set(paramLong);
    this.req.appid.set(paramString1);
    this.req.appType.set(paramInt1);
    this.req.shareScene.set(paramInt2);
    this.req.shareType.set(paramInt3);
    this.req.destType.set(paramInt4);
    this.req.destId.set(paramString2);
  }
  
  public static INTERFACE.StReportShareRsp onResponse(byte[] paramArrayOfByte)
  {
    INTERFACE.StReportShareRsp localStReportShareRsp = new INTERFACE.StReportShareRsp();
    try
    {
      localStReportShareRsp.mergeFrom(decode(paramArrayOfByte));
      return localStReportShareRsp;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReportShareRequest", 2, "onResponse fail." + paramArrayOfByte);
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
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.ReportShareRequest
 * JD-Core Version:    0.7.0.1
 */