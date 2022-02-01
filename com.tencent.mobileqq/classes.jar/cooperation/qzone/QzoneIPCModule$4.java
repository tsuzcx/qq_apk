package cooperation.qzone;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.beans.QCircleFakeFeed.Builder;
import cooperation.qqcircle.events.QCircleFeedEvent;
import cooperation.qqcircle.events.QCircleFuelAnimationEvent;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StVideo;
import feedcloud.FeedCloudWrite.StPublishFeedRsp;

class QzoneIPCModule$4
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudWrite.StPublishFeedRsp>
{
  QzoneIPCModule$4(QzoneIPCModule paramQzoneIPCModule, String paramString, int paramInt) {}
  
  public void onReceive(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StPublishFeedRsp paramStPublishFeedRsp)
  {
    QLog.d("[QzoneIPCModule_upload2]QCircle", 1, "ACTION_QCIRCLE_PULISH_FEED onReceive isSuccess:" + paramBoolean + " retCode:" + paramLong + " errMsg:" + paramString + " traceId:" + paramVSBaseRequest.getTraceId());
    QzoneIPCModule.ResultParmas localResultParmas = new QzoneIPCModule.ResultParmas(this.this$0);
    localResultParmas.retCode = paramLong;
    localResultParmas.errMsg = paramString;
    localResultParmas.clientKey = this.val$clientKey;
    localResultParmas.traceId = paramVSBaseRequest.getTraceId();
    localResultParmas.callbackId = this.val$callbackId;
    if ((paramStPublishFeedRsp != null) && (paramStPublishFeedRsp.feed != null) && (paramStPublishFeedRsp.feed.id != null)) {
      localResultParmas.feedId = paramStPublishFeedRsp.feed.id.get();
    }
    if ((paramBoolean) && (paramLong == 0L) && (paramStPublishFeedRsp != null) && (paramStPublishFeedRsp.feed != null) && (paramStPublishFeedRsp.feed.id != null))
    {
      paramVSBaseRequest = new QCircleFakeFeed.Builder().setFeedId(paramStPublishFeedRsp.feed.id.get()).setClientKey(this.val$clientKey).setCreateTime(paramStPublishFeedRsp.feed.createTime.get()).setPuin(paramStPublishFeedRsp.feed.poster.id.get()).setFeedType(paramStPublishFeedRsp.feed.feedType.get()).setVideoPath(paramStPublishFeedRsp.feed.video.playUrl.get()).setCoverPath(paramStPublishFeedRsp.feed.cover.picUrl.get()).setWidth(paramStPublishFeedRsp.feed.cover.width.get()).setHeight(paramStPublishFeedRsp.feed.cover.height.get()).setDuration(paramStPublishFeedRsp.feed.video.duration.get()).build();
      QLog.d("[QzoneIPCModule_upload2]QCircle", 1, new Object[] { "ACTION_QCIRCLE_PULISH_FEED onReceive feed id:", paramStPublishFeedRsp.feed.id.get(), " clientKey:", this.val$clientKey });
      SimpleEventBus.getInstance().dispatchEvent(new QCircleFuelAnimationEvent(true));
      QzoneIPCModule.access$500(this.this$0, paramVSBaseRequest, 0, localResultParmas);
      return;
    }
    if (paramLong == 10027L)
    {
      paramVSBaseRequest = new QCircleFakeFeed.Builder().setClientKey(this.val$clientKey).build();
      SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedEvent(paramVSBaseRequest, 3));
    }
    QzoneIPCModule.access$600(this.this$0, localResultParmas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QzoneIPCModule.4
 * JD-Core Version:    0.7.0.1
 */