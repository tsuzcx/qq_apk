package com.tencent.mobileqq.kandian.biz.gifvideo.base.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.base.video.player.api.IPlayer;
import com.tencent.mobileqq.kandian.biz.gifvideo.utils.VideoReportUtil;
import com.tencent.mobileqq.kandian.biz.pts.data.Util;

class VideoView$3
  implements View.OnClickListener
{
  VideoView$3(VideoView paramVideoView) {}
  
  public void onClick(View paramView)
  {
    long l;
    if (VideoView.access$400(this.a).a() != null) {
      l = VideoView.access$400(this.a).a().b();
    } else {
      l = 0L;
    }
    VideoReportUtil.a.b(VideoView.access$200(this.a), l, this.a.isPlaying());
    if (Util.e(VideoView.access$200(this.a)))
    {
      VideoView.access$500(this.a);
      return;
    }
    VideoView.access$600(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoView.3
 * JD-Core Version:    0.7.0.1
 */