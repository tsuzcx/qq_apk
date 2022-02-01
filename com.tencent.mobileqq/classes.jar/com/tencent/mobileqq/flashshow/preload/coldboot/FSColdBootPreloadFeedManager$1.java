package com.tencent.mobileqq.flashshow.preload.coldboot;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetFeedListRsp;

class FSColdBootPreloadFeedManager$1
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetFeedListRsp>
{
  FSColdBootPreloadFeedManager$1(FSColdBootPreloadFeedManager paramFSColdBootPreloadFeedManager) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preloadFeed onReceive: dispatch Success:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" | TraceId:");
    localStringBuilder.append(paramBaseRequest.getTraceId());
    localStringBuilder.append(" | SeqId:");
    localStringBuilder.append(paramBaseRequest.getCurrentSeq());
    localStringBuilder.append(" | retCode:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" | retMessage:");
    localStringBuilder.append(paramString);
    QLog.d("FSColdBootPreloadFeedManager", 1, localStringBuilder.toString());
    FSColdBootPreloadFeedManager.access$000(this.a, paramBoolean, paramLong, paramString, paramStGetFeedListRsp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.preload.coldboot.FSColdBootPreloadFeedManager.1
 * JD-Core Version:    0.7.0.1
 */