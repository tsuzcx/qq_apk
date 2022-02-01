package cooperation.qzone;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.beans.QCircleFakeFeed;
import cooperation.qqcircle.events.QCircleFeedEvent;
import feedcloud.FeedCloudRead.StGetFeedDetailRsp;

class QzoneIPCModule$5
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetFeedDetailRsp>
{
  QzoneIPCModule$5(QzoneIPCModule paramQzoneIPCModule, QCircleFakeFeed paramQCircleFakeFeed, QzoneIPCModule.ResultParmas paramResultParmas, int paramInt) {}
  
  public void onReceive(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedDetailRsp paramStGetFeedDetailRsp)
  {
    QLog.d("[QzoneIPCModule_upload2]QCircle", 1, "fetch real feed success:" + paramBoolean + "  retCode code:" + paramLong);
    if ((paramBoolean) && (paramLong == 0L) && (paramStGetFeedDetailRsp.feed != null))
    {
      SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedEvent(this.val$feed, 2));
      QzoneIPCModule.access$600(this.this$0, this.val$resultParmas);
    }
    do
    {
      return;
      QLog.d("QzoneIPCModule", 1, "start retry retryCount:" + this.val$retryCount);
    } while (this.this$0.needRetry(this.val$feed, this.val$retryCount, this.val$resultParmas));
    QzoneIPCModule.access$600(this.this$0, this.val$resultParmas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QzoneIPCModule.5
 * JD-Core Version:    0.7.0.1
 */