package com.tencent.mobileqq.qcircle.api.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import qqcircle.QQCirclePrivateMsgAIO.StGetPMBeginShowMsgReq;
import qqcircle.QQCirclePrivateMsgAIO.StGetPMBeginShowMsgRsp;

public class QCircleChatGetPMBeginShowMsgRequest
  extends QCircleBaseRequest
{
  private QQCirclePrivateMsgAIO.StGetPMBeginShowMsgReq mReq = new QQCirclePrivateMsgAIO.StGetPMBeginShowMsgReq();
  
  public QCircleChatGetPMBeginShowMsgRequest(String paramString)
  {
    this.mReq.userId.set(paramString);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    QQCirclePrivateMsgAIO.StGetPMBeginShowMsgRsp localStGetPMBeginShowMsgRsp = new QQCirclePrivateMsgAIO.StGetPMBeginShowMsgRsp();
    try
    {
      localStGetPMBeginShowMsgRsp.mergeFrom(paramArrayOfByte);
      return localStGetPMBeginShowMsgRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStGetPMBeginShowMsgRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.videocircle.circleprivatemsgaio.CirclePrivateMsgAio.GetPMBeginShowMsgReq";
  }
  
  public byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.requests.QCircleChatGetPMBeginShowMsgRequest
 * JD-Core Version:    0.7.0.1
 */