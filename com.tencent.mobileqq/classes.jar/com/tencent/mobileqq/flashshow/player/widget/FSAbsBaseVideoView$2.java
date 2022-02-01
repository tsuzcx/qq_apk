package com.tencent.mobileqq.flashshow.player.widget;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudMeta.StVideoUrl;
import java.util.Collections;

class FSAbsBaseVideoView$2
  implements Runnable
{
  FSAbsBaseVideoView$2(FSAbsBaseVideoView paramFSAbsBaseVideoView, FeedCloudMeta.StVideoUrl paramStVideoUrl) {}
  
  public void run()
  {
    if (this.this$0.getSuperPlayer() != null)
    {
      QLog.i("FSBaseVideoView", 1, String.format("triggerDowngradeVideoUrl:url: %s, startoffset:%d, levelType:%d", new Object[] { this.a.playUrl.get(), Integer.valueOf((int)this.this$0.getSuperPlayer().getCurrentPositionMs()), Integer.valueOf(this.a.levelType.get()) }));
      this.this$0.setVideoPath(null, this.a.playUrl.get(), (int)this.this$0.getSuperPlayer().getCurrentPositionMs());
      FSAbsBaseVideoView localFSAbsBaseVideoView = this.this$0;
      localFSAbsBaseVideoView.a(localFSAbsBaseVideoView.getVideoPlayId(), "video_play_downgrade_url", this.this$0.getData(), Collections.singletonList(QCircleReportHelper.newEntry("video_url", this.a.playUrl.get())));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.player.widget.FSAbsBaseVideoView.2
 * JD-Core Version:    0.7.0.1
 */