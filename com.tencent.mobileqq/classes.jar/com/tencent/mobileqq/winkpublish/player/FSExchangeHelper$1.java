package com.tencent.mobileqq.winkpublish.player;

import android.util.LruCache;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StVideo;
import qqcircle.QQCircleVideourlexchange.StGetVideoAdaptRsp;

class FSExchangeHelper$1
  implements VSDispatchObserver.onVSRspCallBack<QQCircleVideourlexchange.StGetVideoAdaptRsp>
{
  FSExchangeHelper$1(FSExchangeHelper paramFSExchangeHelper, FeedCloudMeta.StVideo paramStVideo, FSExchangeHelper.VideoUrlAdapterCallBack paramVideoUrlAdapterCallBack) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleVideourlexchange.StGetVideoAdaptRsp paramStGetVideoAdaptRsp)
  {
    if ((paramBoolean) && (paramLong == 0L) && (paramStGetVideoAdaptRsp.videos.size() > 0))
    {
      paramBaseRequest = (FeedCloudMeta.StVideo)paramStGetVideoAdaptRsp.videos.get(0);
      paramBaseRequest.fileId.set(this.a.fileId.get());
      if (paramBaseRequest.playUrl.get().trim().length() > 0)
      {
        this.b.a(paramBaseRequest, false);
        FSExchangeHelper.a(this.c).put(this.a.fileId.get(), paramBaseRequest);
        QLog.i("BaseVideoView_QCircleVideoUrlExchangeHelper", 1, String.format("exchangeVideoUrl: success fileId:%s ,videoExchange url %s:", new Object[] { paramBaseRequest.fileId.get(), paramBaseRequest.playUrl.get() }));
        return;
      }
      this.b.a(paramLong, paramString);
      QLog.e("BaseVideoView_QCircleVideoUrlExchangeHelper", 1, String.format("exchangeVideoUrl: failed fileId:%s ,final url:%s, retCode:%d, errMsg:%s", new Object[] { this.a.fileId.get(), this.a.playUrl.get(), Long.valueOf(paramLong), paramString }));
      return;
    }
    this.b.a(paramLong, paramString);
    QLog.e("BaseVideoView_QCircleVideoUrlExchangeHelper", 1, String.format("exchangeVideoUrl: failed fileId:%s ,final url:%s, retCode:%d, errMsg:%s", new Object[] { this.a.fileId.get(), this.a.playUrl.get(), Long.valueOf(paramLong), paramString }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.player.FSExchangeHelper.1
 * JD-Core Version:    0.7.0.1
 */