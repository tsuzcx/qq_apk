package com.tencent.mobileqq.winkpublish.fs.request;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.winkpublish.fs.request.base.FSBaseRequest;
import com.tencent.mobileqq.winkpublish.util.FSTransUtils;
import feedcloud.FeedCloudMeta.StVideo;
import qqcircle.QQCircleVideourlexchange.StGetVideoAdaptReq;
import qqcircle.QQCircleVideourlexchange.StGetVideoAdaptRsp;

public class FSUrlAdapterRequest
  extends FSBaseRequest
{
  private final QQCircleVideourlexchange.StGetVideoAdaptReq mReq = new QQCircleVideourlexchange.StGetVideoAdaptReq();
  
  public FSUrlAdapterRequest(FeedCloudMeta.StVideo paramStVideo)
  {
    this.mReq.videos.add(paramStVideo);
    this.mReq.userID.set(FSTransUtils.a());
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    QQCircleVideourlexchange.StGetVideoAdaptRsp localStGetVideoAdaptRsp = new QQCircleVideourlexchange.StGetVideoAdaptRsp();
    try
    {
      localStGetVideoAdaptRsp.mergeFrom(paramArrayOfByte);
      return localStGetVideoAdaptRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStGetVideoAdaptRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.videocircle.videourlexchange.VideoURLExchange.GetVideoAdaptInfo";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.fs.request.FSUrlAdapterRequest
 * JD-Core Version:    0.7.0.1
 */