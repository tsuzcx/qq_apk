package com.tencent.mobileqq.winkpublish.task;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.beans.QCircleFakeFeed;
import feedcloud.FeedCloudRead.StGetFeedDetailRsp;

class FSUploadShuoShuoTask$2
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetFeedDetailRsp>
{
  FSUploadShuoShuoTask$2(FSUploadShuoShuoTask paramFSUploadShuoShuoTask, FSUploadShuoShuoTask.ResultParmas paramResultParmas, int paramInt, QCircleFakeFeed paramQCircleFakeFeed) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedDetailRsp paramStGetFeedDetailRsp)
  {
    paramBaseRequest = new StringBuilder();
    paramBaseRequest.append("fetch real feed success:");
    paramBaseRequest.append(paramBoolean);
    paramBaseRequest.append("  retCode code:");
    paramBaseRequest.append(paramLong);
    QLog.d("[upload2_FSUploadShuoShuoTask]", 1, paramBaseRequest.toString());
    if ((paramBoolean) && (paramLong == 0L) && (paramStGetFeedDetailRsp.feed != null))
    {
      FSUploadShuoShuoTask.a(this.d, this.a);
      return;
    }
    paramBaseRequest = new StringBuilder();
    paramBaseRequest.append("start retry retryCount:");
    paramBaseRequest.append(this.b);
    QLog.d("[upload2_FSUploadShuoShuoTask]", 1, paramBaseRequest.toString());
    if (!this.d.a(this.c, this.b, this.a)) {
      FSUploadShuoShuoTask.a(this.d, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.task.FSUploadShuoShuoTask.2
 * JD-Core Version:    0.7.0.1
 */