package com.tencent.mobileqq.tianshu.impl.qboss;

import NS_MOBILE_QBOSS_PROTO.MobileQbossReportExceptionReq;
import NS_MOBILE_QBOSS_PROTO.MobileQbossReportExceptionRsp;
import NS_MOBILE_QBOSS_PROTO.ReportExceptionInfo;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QzoneExternalRequest;
import java.util.ArrayList;

public class QbossErrorReportRequest
  extends QzoneExternalRequest
{
  private JceStruct a;
  
  public QbossErrorReportRequest(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    ArrayList localArrayList = new ArrayList(1);
    ReportExceptionInfo localReportExceptionInfo = new ReportExceptionInfo();
    localReportExceptionInfo.iCode = paramInt3;
    localReportExceptionInfo.iAppid = paramInt1;
    localReportExceptionInfo.iTaskId = paramInt2;
    localReportExceptionInfo.strMsg = paramString;
    localArrayList.add(localReportExceptionInfo);
    this.a = new MobileQbossReportExceptionReq(paramLong, localArrayList);
  }
  
  public static MobileQbossReportExceptionRsp a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    paramArrayOfByte = (MobileQbossReportExceptionRsp)QzoneExternalRequest.decode(paramArrayOfByte, "reportException");
    if (paramArrayOfByte == null) {
      return null;
    }
    return paramArrayOfByte;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.mobileqboss.reportException";
  }
  
  public JceStruct getReq()
  {
    return this.a;
  }
  
  public String uniKey()
  {
    return "reportException";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.impl.qboss.QbossErrorReportRequest
 * JD-Core Version:    0.7.0.1
 */