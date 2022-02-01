package com.tencent.mobileqq.qcircle.api.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudRead.StGetFollowListReq;
import feedcloud.FeedCloudRead.StGetFollowListRsp;

public class QCircleGetFollowListRequest
  extends QCircleBaseRequest
{
  private int mListNum;
  private FeedCloudRead.StGetFollowListReq mRequest;
  
  public QCircleGetFollowListRequest(String paramString, long paramLong)
  {
    this(paramString, paramLong, false);
  }
  
  public QCircleGetFollowListRequest(String paramString, long paramLong, boolean paramBoolean) {}
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudRead.StGetFollowListRsp localStGetFollowListRsp = new FeedCloudRead.StGetFollowListRsp();
    try
    {
      localStGetFollowListRsp.mergeFrom(paramArrayOfByte);
      return localStGetFollowListRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStGetFollowListRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetFollowList";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.requests.QCircleGetFollowListRequest
 * JD-Core Version:    0.7.0.1
 */