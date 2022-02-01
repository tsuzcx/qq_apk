package com.tencent.mobileqq.winkpublish.player.widget;

import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.winkpublish.player.FSExchangeHelper.VideoUrlAdapterCallBack;
import feedcloud.FeedCloudMeta.StVideo;

class PublishAbsBaseVideoView$1
  implements FSExchangeHelper.VideoUrlAdapterCallBack
{
  PublishAbsBaseVideoView$1(PublishAbsBaseVideoView paramPublishAbsBaseVideoView, int paramInt, FeedCloudMeta.StVideo paramStVideo) {}
  
  public void a(long paramLong, String paramString)
  {
    if (VSNetworkHelper.isTimeOutRetCode((int)paramLong)) {
      return;
    }
    PublishAbsBaseVideoView.a(this.c, this.b, this.a);
  }
  
  public void a(FeedCloudMeta.StVideo paramStVideo, boolean paramBoolean)
  {
    PublishAbsBaseVideoView.a(this.c, paramStVideo, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.player.widget.PublishAbsBaseVideoView.1
 * JD-Core Version:    0.7.0.1
 */