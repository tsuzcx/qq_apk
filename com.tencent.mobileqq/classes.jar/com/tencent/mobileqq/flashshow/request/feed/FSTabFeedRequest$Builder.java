package com.tencent.mobileqq.flashshow.request.feed;

import com.tencent.mobileqq.flashshow.bean.FSMainTabInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudRead.StGetFeedListReq;
import qqcircle.QQCircleFeedBase.StFeedListBusiReqData;

public class FSTabFeedRequest$Builder
{
  private final FSTabFeedRequest a;
  
  public FSTabFeedRequest$Builder(FSMainTabInfo paramFSMainTabInfo, int paramInt)
  {
    this.a = new FSTabFeedRequest(paramFSMainTabInfo, paramInt, null);
  }
  
  private FeedCloudRead.StGetFeedListReq b()
  {
    return this.a.mRequest;
  }
  
  private QQCircleFeedBase.StFeedListBusiReqData c()
  {
    return this.a.mBusiReqData;
  }
  
  public FSTabFeedRequest a()
  {
    b().busiReqData.set(ByteStringMicro.copyFrom(c().toByteArray()));
    return this.a;
  }
  
  public void a(String paramString)
  {
    b().feedAttchInfo.set(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.request.feed.FSTabFeedRequest.Builder
 * JD-Core Version:    0.7.0.1
 */