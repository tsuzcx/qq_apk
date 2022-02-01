package com.tencent.mobileqq.qcircle.api.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;
import qqcircle.QQCircleReport.StDataReportReq;
import qqcircle.QQCircleReport.StDataReportRsp;

public class QCircleClientReportRequest
  extends QCircleBaseRequest
{
  private QQCircleReport.StDataReportReq mReq = new QQCircleReport.StDataReportReq();
  
  public QCircleClientReportRequest(List<QQCircleReport.SingleDcData> paramList)
  {
    this.mReq.dcdata.set(paramList);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    QQCircleReport.StDataReportRsp localStDataReportRsp = new QQCircleReport.StDataReportRsp();
    try
    {
      localStDataReportRsp.mergeFrom(paramArrayOfByte);
      return localStDataReportRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStDataReportRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.circlereport.clientreport.ClientReport.DataReport";
  }
  
  public byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.requests.QCircleClientReportRequest
 * JD-Core Version:    0.7.0.1
 */