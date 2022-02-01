package com.tencent.mobileqq.winkpublish.player.widget;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import feedcloud.FeedCloudMeta.StVideoUrl;

class PublishAbsBaseVideoView$2
  implements Runnable
{
  PublishAbsBaseVideoView$2(PublishAbsBaseVideoView paramPublishAbsBaseVideoView, FeedCloudMeta.StVideoUrl paramStVideoUrl) {}
  
  public void run()
  {
    if (this.this$0.getSuperPlayer() != null)
    {
      QLog.i("BaseVideoView", 1, String.format("triggerDowngradeVideoUrl:url: %s, startoffset:%d, levelType:%d", new Object[] { this.a.playUrl.get(), Integer.valueOf((int)this.this$0.getSuperPlayer().getCurrentPositionMs()), Integer.valueOf(this.a.levelType.get()) }));
      this.this$0.setVideoPath(null, this.a.playUrl.get(), (int)this.this$0.getSuperPlayer().getCurrentPositionMs());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.player.widget.PublishAbsBaseVideoView.2
 * JD-Core Version:    0.7.0.1
 */