package com.tencent.mobileqq.flashshow.request.follow;

import com.tencent.mobileqq.flashshow.request.FSBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudWrite.StDoFollowReq;
import feedcloud.FeedCloudWrite.StDoFollowRsp;

public class FSDoFollowRequest
  extends FSBaseRequest
{
  private FeedCloudWrite.StDoFollowReq mRequest;
  
  public FSDoFollowRequest(FeedCloudMeta.StUser paramStUser, int paramInt, FeedCloudCommon.StCommonExt paramStCommonExt)
  {
    this(paramStUser, paramInt, paramStCommonExt, false);
  }
  
  public FSDoFollowRequest(FeedCloudMeta.StUser paramStUser, int paramInt, FeedCloudCommon.StCommonExt paramStCommonExt, boolean paramBoolean) {}
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudWrite.StDoFollowRsp localStDoFollowRsp = new FeedCloudWrite.StDoFollowRsp();
    try
    {
      localStDoFollowRsp.mergeFrom(paramArrayOfByte);
      return localStDoFollowRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStDoFollowRsp;
  }
  
  public String getCmdName()
  {
    return "QflashSvr.trpc.qflash.commwriter.ComWriter.DoFollow";
  }
  
  public FeedCloudWrite.StDoFollowReq getRequest()
  {
    return this.mRequest;
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.request.follow.FSDoFollowRequest
 * JD-Core Version:    0.7.0.1
 */