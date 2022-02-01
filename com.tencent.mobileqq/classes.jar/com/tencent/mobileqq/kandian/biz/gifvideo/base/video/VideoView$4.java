package com.tencent.mobileqq.kandian.biz.gifvideo.base.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.pts.data.Util;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;

class VideoView$4
  implements View.OnClickListener
{
  VideoView$4(VideoView paramVideoView) {}
  
  public void onClick(View paramView)
  {
    if (Util.e(VideoView.access$200(this.a)))
    {
      VideoView.access$500(this.a);
      return;
    }
    if (!VideoPlayController.a.a()) {
      ReadInJoyLogicEngineEventDispatcher.a().a(VideoView.access$200(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoView.4
 * JD-Core Version:    0.7.0.1
 */