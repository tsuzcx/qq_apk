package com.tencent.mobileqq.flashshow.viewmodel.layer;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetFeedDetailRsp;

class FSLayerDetailViewModel$FeedDetailCall$1
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetFeedDetailRsp>
{
  FSLayerDetailViewModel$FeedDetailCall$1(FSLayerDetailViewModel.FeedDetailCall paramFeedDetailCall, FSLayerDetailViewModel.GetFeedDetailRspListener paramGetFeedDetailRspListener) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedDetailRsp paramStGetFeedDetailRsp)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" | Cmd = ");
    localStringBuilder.append(paramBaseRequest.getCmdName());
    localStringBuilder.append(" | TraceId:");
    localStringBuilder.append(paramBaseRequest.getTraceId());
    localStringBuilder.append(" | SeqId:");
    localStringBuilder.append(paramBaseRequest.getCurrentSeq());
    localStringBuilder.append(" | isSuc = ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" | retCode = ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" | errMsg = ");
    localStringBuilder.append(paramString);
    QLog.i("FSLayerDetailViewModel", 1, localStringBuilder.toString());
    if (FSLayerDetailViewModel.FeedDetailCall.a(this.b, paramBoolean, paramString, this.a)) {
      return;
    }
    if (FSLayerDetailViewModel.FeedDetailCall.a(this.b, paramStGetFeedDetailRsp, this.a)) {
      return;
    }
    FSLayerDetailViewModel.FeedDetailCall.a(this.b, paramString, paramStGetFeedDetailRsp, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.viewmodel.layer.FSLayerDetailViewModel.FeedDetailCall.1
 * JD-Core Version:    0.7.0.1
 */