package com.tencent.mobileqq.winkpublish.task;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.winkpublish.api.IUploadLocalConfig;
import com.tencent.mobileqq.winkpublish.common.AUploadCommonSetting;
import com.tencent.mobileqq.winkpublish.fs.request.FSPublishFeedRequest;
import com.tencent.mobileqq.winkpublish.model.MediaWrapper;
import com.tencent.mobileqq.winkpublish.model.ShuoshuoVideoInfo;
import com.tencent.mobileqq.winkpublish.qcircle.request.QCirclePublishFeedRequest;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.beans.QCircleFakeFeed.Builder;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StVideo;
import feedcloud.FeedCloudWrite.StPublishFeedRsp;
import java.util.Arrays;
import java.util.List;

class FSUploadShuoShuoTask$1
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudWrite.StPublishFeedRsp>
{
  FSUploadShuoShuoTask$1(FSUploadShuoShuoTask paramFSUploadShuoShuoTask) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StPublishFeedRsp paramStPublishFeedRsp)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ACTION_QCIRCLE_PULISH_FEED onReceive isSuccess:");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" retCode:");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" errMsg:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" traceId:");
    ((StringBuilder)localObject).append(paramBaseRequest.getTraceId());
    QLog.d("[upload2_FSUploadShuoShuoTask]", 1, ((StringBuilder)localObject).toString());
    localObject = new FSUploadShuoShuoTask.ResultParmas(this.a);
    ((FSUploadShuoShuoTask.ResultParmas)localObject).a = paramLong;
    ((FSUploadShuoShuoTask.ResultParmas)localObject).b = paramString;
    ((FSUploadShuoShuoTask.ResultParmas)localObject).d = this.a.al;
    ((FSUploadShuoShuoTask.ResultParmas)localObject).e = paramBaseRequest.getTraceId();
    ((FSUploadShuoShuoTask.ResultParmas)localObject).h = paramStPublishFeedRsp.feed.createTime.get();
    ((FSUploadShuoShuoTask.ResultParmas)localObject).i = FSUploadShuoShuoTask.a(this.a);
    if ((paramStPublishFeedRsp != null) && (paramStPublishFeedRsp.feed != null) && (paramStPublishFeedRsp.feed.id != null)) {
      ((FSUploadShuoShuoTask.ResultParmas)localObject).c = paramStPublishFeedRsp.feed.id.get();
    }
    if ((((paramBaseRequest instanceof FSPublishFeedRequest)) || ((paramBaseRequest instanceof QCirclePublishFeedRequest))) && (this.a.p != null) && (this.a.p.size() > 0) && (((MediaWrapper)this.a.p.get(0)).c() != null))
    {
      ((FSUploadShuoShuoTask.ResultParmas)localObject).f = ((MediaWrapper)this.a.p.get(0)).c().h;
      ((FSUploadShuoShuoTask.ResultParmas)localObject).g = ((MediaWrapper)this.a.p.get(0)).c().b;
    }
    if ((paramBoolean) && (paramLong == 0L) && (paramStPublishFeedRsp != null) && (paramStPublishFeedRsp.feed != null) && (paramStPublishFeedRsp.feed.id != null))
    {
      paramString = new QCircleFakeFeed.Builder().setFeedId(paramStPublishFeedRsp.feed.id.get()).setClientKey(this.a.al).setCreateTime(paramStPublishFeedRsp.feed.createTime.get()).setPuin(paramStPublishFeedRsp.feed.poster.id.get()).setFeedType(paramStPublishFeedRsp.feed.feedType.get()).setVideoPath(paramStPublishFeedRsp.feed.video.playUrl.get()).setCoverPath(paramStPublishFeedRsp.feed.cover.picUrl.get()).setWidth(paramStPublishFeedRsp.feed.cover.width.get()).setHeight(paramStPublishFeedRsp.feed.cover.height.get()).setDuration(paramStPublishFeedRsp.feed.video.duration.get()).build();
      QLog.d("[upload2_FSUploadShuoShuoTask]", 1, new Object[] { "ACTION_QCIRCLE_PULISH_FEED onReceive feed id:", paramStPublishFeedRsp.feed.id.get(), " clientKey:", this.a.al });
      FSUploadShuoShuoTask.a(this.a, paramString, 0, (FSUploadShuoShuoTask.ResultParmas)localObject);
    }
    else
    {
      if (paramLong == 10027L) {
        new QCircleFakeFeed.Builder().setClientKey(this.a.al).build();
      }
      FSUploadShuoShuoTask.a(this.a, (FSUploadShuoShuoTask.ResultParmas)localObject);
    }
    AUploadCommonSetting.a().uploadQualityReport(QCirclePublishQualityReporter.E_PUBLISH_FEEDS_RESULT, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("traceid", FSUploadShuoShuoTask.b(this.a)), QCircleReportHelper.newEntry("ret_code", String.valueOf(paramLong)), QCircleReportHelper.newEntry("ext1", paramBaseRequest.getTraceId()), QCircleReportHelper.newEntry("ext2", String.valueOf(paramBaseRequest.getCurrentSeq())) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.task.FSUploadShuoShuoTask.1
 * JD-Core Version:    0.7.0.1
 */