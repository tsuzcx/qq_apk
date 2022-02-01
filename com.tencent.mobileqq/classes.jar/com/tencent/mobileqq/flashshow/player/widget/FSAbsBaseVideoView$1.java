package com.tencent.mobileqq.flashshow.player.widget;

import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.flashshow.player.FSExchangeHelper.VideoUrlAdapterCallBack;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudMeta.StVideo;
import java.util.Collections;

class FSAbsBaseVideoView$1
  implements FSExchangeHelper.VideoUrlAdapterCallBack
{
  FSAbsBaseVideoView$1(FSAbsBaseVideoView paramFSAbsBaseVideoView, int paramInt, FeedCloudMeta.StVideo paramStVideo) {}
  
  public void a(long paramLong, String paramString)
  {
    paramString = this.c;
    paramString.a(paramString.getVideoPlayId(), "video_exchange_url", this.c.getData(), Collections.singletonList(QCircleReportHelper.newEntry("ret_code", String.valueOf(paramLong))));
    if (VSNetworkHelper.isTimeOutRetCode((int)paramLong)) {
      return;
    }
    FSAbsBaseVideoView.a(this.c, this.b, this.a);
  }
  
  public void a(FeedCloudMeta.StVideo paramStVideo, boolean paramBoolean)
  {
    FSAbsBaseVideoView.a(this.c, paramStVideo, this.a);
    if (!paramBoolean)
    {
      paramStVideo = this.c;
      paramStVideo.a(paramStVideo.getVideoPlayId(), "video_exchange_url", this.c.getData(), Collections.singletonList(QCircleReportHelper.newEntry("ret_code", "0")));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.player.widget.FSAbsBaseVideoView.1
 * JD-Core Version:    0.7.0.1
 */