package com.tencent.mobileqq.qcircle.api.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudWrite.StPublishFeedReq;
import feedcloud.FeedCloudWrite.StPublishFeedRsp;

public class QCirclePublishFeedRequest
  extends QCircleBaseRequest
{
  public static final String TAG = "QCirclePublishFeedRequest";
  FeedCloudWrite.StPublishFeedReq mReq = new FeedCloudWrite.StPublishFeedReq();
  
  public QCirclePublishFeedRequest(FeedCloudCommon.StCommonExt paramStCommonExt, FeedCloudMeta.StFeed paramStFeed)
  {
    this.mReq.feed.set(paramStFeed);
    this.mReq.extInfo.set(paramStCommonExt);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudWrite.StPublishFeedRsp localStPublishFeedRsp = new FeedCloudWrite.StPublishFeedRsp();
    try
    {
      localStPublishFeedRsp.mergeFrom(paramArrayOfByte);
      return localStPublishFeedRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStPublishFeedRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.PublishFeed";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.requests.QCirclePublishFeedRequest
 * JD-Core Version:    0.7.0.1
 */