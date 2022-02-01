package com.tencent.mobileqq.flashshow.request.like;

import com.tencent.mobileqq.flashshow.request.FSBaseRequest;
import com.tencent.mobileqq.flashshow.utils.FSCommonUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudWrite.StDoLikeReq;
import feedcloud.FeedCloudWrite.StDoLikeRsp;

public class FSLikeRequest
  extends FSBaseRequest
{
  private FeedCloudMeta.StFeed mFeed;
  private int mLikeType;
  private FeedCloudWrite.StDoLikeReq mReq = new FeedCloudWrite.StDoLikeReq();
  
  public FSLikeRequest(FeedCloudMeta.StFeed paramStFeed, int paramInt)
  {
    this.mReq.likeType.set(paramInt);
    this.mReq.feed.set(FSCommonUtil.a(paramStFeed));
    this.mReq.feed.cover.set(paramStFeed.cover.get());
    this.mReq.feed.images.set(paramStFeed.images.get());
    this.mReq.like.set(paramStFeed.likeInfo);
    this.mFeed = paramStFeed;
    this.mLikeType = paramInt;
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudWrite.StDoLikeRsp localStDoLikeRsp = new FeedCloudWrite.StDoLikeRsp();
    try
    {
      localStDoLikeRsp.mergeFrom(paramArrayOfByte);
      return localStDoLikeRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStDoLikeRsp;
  }
  
  public String getCmdName()
  {
    return "QflashSvr.trpc.qflash.commwriter.ComWriter.DoLike";
  }
  
  public FeedCloudMeta.StFeed getFeed()
  {
    return this.mFeed;
  }
  
  public int getLikeType()
  {
    return this.mLikeType;
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.request.like.FSLikeRequest
 * JD-Core Version:    0.7.0.1
 */