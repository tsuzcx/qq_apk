package com.tencent.mobileqq.flashshow.request.feed;

import com.tencent.mobileqq.flashshow.request.FSBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudWrite.StDelFeedReq;
import feedcloud.FeedCloudWrite.StDelFeedRsp;

public class FSDeleteFeedRequest
  extends FSBaseRequest
{
  public static final String TAG = "FSDeleteFeedRequest";
  public FeedCloudWrite.StDelFeedReq mReq;
  
  public FSDeleteFeedRequest(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null)
    {
      QLog.w("FSDeleteFeedRequest", 1, "stfeed is null");
      return;
    }
    this.mReq = new FeedCloudWrite.StDelFeedReq();
    this.mReq.feed.set(a(paramStFeed));
    this.mReq.from.set(0);
  }
  
  private FeedCloudMeta.StFeed a(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null)
    {
      QLog.e("FSDeleteFeedRequest", 1, "getSimpleFeed param feed is null");
      return null;
    }
    FeedCloudMeta.StFeed localStFeed = new FeedCloudMeta.StFeed();
    localStFeed.id.set(paramStFeed.id.get());
    localStFeed.createTime.set(paramStFeed.createTime.get());
    if (paramStFeed.poster != null)
    {
      FeedCloudMeta.StUser localStUser = new FeedCloudMeta.StUser();
      localStUser.id.set(paramStFeed.poster.id.get());
      localStFeed.poster.set(localStUser);
      return localStFeed;
    }
    QLog.e("FSDeleteFeedRequest", 1, "getSimpleFeed poster is null");
    return localStFeed;
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudWrite.StDelFeedRsp localStDelFeedRsp = new FeedCloudWrite.StDelFeedRsp();
    try
    {
      localStDelFeedRsp.mergeFrom(paramArrayOfByte);
      return localStDelFeedRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStDelFeedRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.qflash.commwriter.ComWriter.DelFeed";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.request.feed.FSDeleteFeedRequest
 * JD-Core Version:    0.7.0.1
 */