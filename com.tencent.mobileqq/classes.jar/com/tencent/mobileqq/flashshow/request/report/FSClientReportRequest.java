package com.tencent.mobileqq.flashshow.request.report;

import NS_COMM.COMM.Entry;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebReq;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import com.tencent.richframework.common.RFWCommonGlobalInfo;
import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;
import qqcircle.QQCircleReport.StDataReportReq;
import qqcircle.QQCircleReport.StDataReportRsp;

public class FSClientReportRequest
  extends QCircleBaseRequest
{
  private QQCircleReport.StDataReportReq mReq = new QQCircleReport.StDataReportReq();
  
  public FSClientReportRequest(List<QQCircleReport.SingleDcData> paramList)
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
    return "QflashSvr.trpc.qflash.clientreport.ClientReport.DataReport";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
  
  protected byte[] getRequestWrapper(ByteStringMicro paramByteStringMicro)
  {
    PROTOCAL.StQWebReq localStQWebReq = new PROTOCAL.StQWebReq();
    try
    {
      localStQWebReq.mergeFrom(super.getRequestWrapper(paramByteStringMicro));
    }
    catch (InvalidProtocolBufferMicroException paramByteStringMicro)
    {
      paramByteStringMicro.printStackTrace();
    }
    paramByteStringMicro = new COMM.Entry();
    paramByteStringMicro.key.set("fc-appid");
    paramByteStringMicro.value.set("95");
    localStQWebReq.Extinfo.add(paramByteStringMicro);
    paramByteStringMicro = new COMM.Entry();
    paramByteStringMicro.key.set("environment_id");
    paramByteStringMicro.value.set(RFWCommonGlobalInfo.a());
    localStQWebReq.Extinfo.add(paramByteStringMicro);
    return localStQWebReq.toByteArray();
  }
  
  public void reportCmdSuccessRate(PROTOCAL.StQWebRsp paramStQWebRsp) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.request.report.FSClientReportRequest
 * JD-Core Version:    0.7.0.1
 */