package com.tencent.mobileqq.flashshow.personal.request;

import com.tencent.mobileqq.flashshow.request.FSBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudRead.StGetFeedListReq;
import feedcloud.FeedCloudRead.StGetFeedListRsp;

public class FSGetFeedListLikeRequest
  extends FSBaseRequest
{
  protected FeedCloudRead.StGetFeedListReq mRequest;
  
  private FSGetFeedListLikeRequest(FeedCloudRead.StGetFeedListReq paramStGetFeedListReq)
  {
    this.mRequest = paramStGetFeedListReq;
  }
  
  public FeedCloudRead.StGetFeedListRsp decode(byte[] paramArrayOfByte)
  {
    FeedCloudRead.StGetFeedListRsp localStGetFeedListRsp = new FeedCloudRead.StGetFeedListRsp();
    try
    {
      localStGetFeedListRsp.mergeFrom(paramArrayOfByte);
      return localStGetFeedListRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStGetFeedListRsp;
  }
  
  public String getCmdName()
  {
    return "QflashSvr.trpc.qflash.commreader.ComReader.GetFeedListLike";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
  
  public void setAttachInfo(String paramString)
  {
    this.mRequest.feedAttchInfo.set(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.personal.request.FSGetFeedListLikeRequest
 * JD-Core Version:    0.7.0.1
 */