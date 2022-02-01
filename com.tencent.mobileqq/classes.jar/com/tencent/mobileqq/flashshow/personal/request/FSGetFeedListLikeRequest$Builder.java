package com.tencent.mobileqq.flashshow.personal.request;

import com.tencent.mobileqq.flashshow.request.FSBaseRequest.Builder;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudRead.StGetFeedListReq;
import qqcircle.QQCircleFeedBase.StFeedListBusiRspData;

public class FSGetFeedListLikeRequest$Builder
  extends FSBaseRequest.Builder<FSGetFeedListLikeRequest>
{
  private final FeedCloudRead.StGetFeedListReq a = new FeedCloudRead.StGetFeedListReq();
  private final QQCircleFeedBase.StFeedListBusiRspData b = new QQCircleFeedBase.StFeedListBusiRspData();
  
  public FSGetFeedListLikeRequest$Builder(String paramString)
  {
    this.a.dstUserId.set(paramString);
  }
  
  public FSGetFeedListLikeRequest a()
  {
    this.a.busiReqData.set(ByteStringMicro.copyFrom(this.b.toByteArray()));
    this.mRealRequest = new FSGetFeedListLikeRequest(this.a, null);
    return (FSGetFeedListLikeRequest)this.mRealRequest;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.personal.request.FSGetFeedListLikeRequest.Builder
 * JD-Core Version:    0.7.0.1
 */