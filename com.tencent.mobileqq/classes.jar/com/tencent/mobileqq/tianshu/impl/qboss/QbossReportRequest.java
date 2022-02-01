package com.tencent.mobileqq.tianshu.impl.qboss;

import NS_MOBILE_QBOSS_PROTO.MobileQbossReportReq;
import NS_MOBILE_QBOSS_PROTO.MobileQbossReportRsp;
import NS_MOBILE_QBOSS_PROTO.tMobileQbossFeedBackInfo;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QzoneExternalRequest;
import java.util.ArrayList;

public class QbossReportRequest
  extends QzoneExternalRequest
{
  private JceStruct a;
  
  public QbossReportRequest(ArrayList<tMobileQbossFeedBackInfo> paramArrayList)
  {
    MobileQbossReportReq localMobileQbossReportReq = new MobileQbossReportReq();
    localMobileQbossReportReq.vecMobileQbossFeedBackInfo = paramArrayList;
    this.a = localMobileQbossReportReq;
  }
  
  public static MobileQbossReportRsp a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    paramArrayOfByte = (MobileQbossReportRsp)QzoneExternalRequest.decode(paramArrayOfByte, "report");
    if (paramArrayOfByte == null) {
      return null;
    }
    return paramArrayOfByte;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.mobileqboss.report";
  }
  
  public JceStruct getReq()
  {
    return this.a;
  }
  
  public String uniKey()
  {
    return "report";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.impl.qboss.QbossReportRequest
 * JD-Core Version:    0.7.0.1
 */