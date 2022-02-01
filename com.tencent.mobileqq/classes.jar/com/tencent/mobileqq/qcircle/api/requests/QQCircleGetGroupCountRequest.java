package com.tencent.mobileqq.qcircle.api.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt64Field;
import qqcircle.QQCircleCountergroup.GetGroupCountReq;
import qqcircle.QQCircleCountergroup.GetGroupCountRsp;

public class QQCircleGetGroupCountRequest
  extends QCircleBaseRequest
{
  private QQCircleCountergroup.GetGroupCountReq mReq = new QQCircleCountergroup.GetGroupCountReq();
  
  public QQCircleGetGroupCountRequest(long paramLong)
  {
    this.mReq.gid.set(paramLong);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    QQCircleCountergroup.GetGroupCountRsp localGetGroupCountRsp = new QQCircleCountergroup.GetGroupCountRsp();
    try
    {
      localGetGroupCountRsp.mergeFrom(paramArrayOfByte);
      return localGetGroupCountRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localGetGroupCountRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.videocircle.circlecountergroup.CircleCounterGroup.GetGroupCount";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.requests.QQCircleGetGroupCountRequest
 * JD-Core Version:    0.7.0.1
 */