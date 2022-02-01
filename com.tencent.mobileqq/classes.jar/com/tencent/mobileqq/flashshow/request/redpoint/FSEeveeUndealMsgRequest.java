package com.tencent.mobileqq.flashshow.request.redpoint;

import com.tencent.mobileqq.flashshow.request.FSBaseRequest;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import feedcloud.FeedCloudEeveeBase.ClientInfo;
import feedcloud.FeedCloudEeveeBase.StEeveeAttachInfo;
import feedcloud.FeedCloudEeveeUndealmsg.FcUndealMsgsReq;
import feedcloud.FeedCloudEeveeUndealmsg.FcUndealMsgsRsp;
import feedcloud.FeedCloudEeveeUndealmsg.SignalMsg;
import java.util.List;

public class FSEeveeUndealMsgRequest
  extends FSBaseRequest
{
  FeedCloudEeveeUndealmsg.FcUndealMsgsReq mReq = new FeedCloudEeveeUndealmsg.FcUndealMsgsReq();
  
  public FSEeveeUndealMsgRequest(FeedCloudEeveeBase.ClientInfo paramClientInfo, int paramInt1, int paramInt2, FeedCloudEeveeUndealmsg.SignalMsg paramSignalMsg, List<FeedCloudEeveeBase.StEeveeAttachInfo> paramList)
  {
    this.mReq.appid.set(10001);
    this.mReq.uid.set(((IAccountRuntime)QRoute.api(IAccountRuntime.class)).getAccount());
    this.mReq.clientInfo.set(paramClientInfo);
    this.mReq.visitScene.set(paramInt1);
    if ((paramList != null) && (paramList.size() != 0))
    {
      this.mReq.attachInfo.clear();
      this.mReq.attachInfo.addAll(paramList);
    }
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
    return "QflashSvr.trpc.qflash.eeveeundealmsg.EeveeMsgChannel.FcUndealMsgs";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.request.redpoint.FSEeveeUndealMsgRequest
 * JD-Core Version:    0.7.0.1
 */