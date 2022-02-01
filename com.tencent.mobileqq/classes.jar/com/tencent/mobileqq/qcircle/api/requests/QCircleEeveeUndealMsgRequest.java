package com.tencent.mobileqq.qcircle.api.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudEeveeBase.ClientInfo;
import feedcloud.FeedCloudEeveeUndealmsg.FcUndealMsgsReq;
import feedcloud.FeedCloudEeveeUndealmsg.FcUndealMsgsRsp;
import feedcloud.FeedCloudEeveeUndealmsg.SignalMsg;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QCircleEeveeUndealMsgRequest
  extends QCircleBaseRequest
{
  FeedCloudEeveeUndealmsg.FcUndealMsgsReq mReq = new FeedCloudEeveeUndealmsg.FcUndealMsgsReq();
  
  public QCircleEeveeUndealMsgRequest(FeedCloudEeveeBase.ClientInfo paramClientInfo, int paramInt1, int paramInt2, FeedCloudEeveeUndealmsg.SignalMsg paramSignalMsg)
  {
    this.mReq.appid.set(10000);
    this.mReq.uid.set(String.valueOf(MobileQQ.sMobileQQ.waitAppRuntime(null).getLongAccountUin()));
    this.mReq.clientInfo.set(paramClientInfo);
    this.mReq.visitScene.set(paramInt1);
    this.mReq.visitPage.set(paramInt2);
    this.mReq.signalMsg.set(paramSignalMsg);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudEeveeUndealmsg.FcUndealMsgsRsp localFcUndealMsgsRsp = new FeedCloudEeveeUndealmsg.FcUndealMsgsRsp();
    try
    {
      localFcUndealMsgsRsp.mergeFrom(paramArrayOfByte);
      return localFcUndealMsgsRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localFcUndealMsgsRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.eeveeundealmsg.EeveeMsgChannel.FcUndealMsgs";
  }
  
  public byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.requests.QCircleEeveeUndealMsgRequest
 * JD-Core Version:    0.7.0.1
 */