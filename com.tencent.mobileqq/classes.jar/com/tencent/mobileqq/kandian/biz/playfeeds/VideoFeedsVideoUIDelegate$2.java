package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.kandian.biz.video.playfeedback.PlayFeedbackHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IMsgLayoutHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseVideoItemHolder;
import com.tencent.qphone.base.util.QLog;

class VideoFeedsVideoUIDelegate$2
  implements Runnable
{
  VideoFeedsVideoUIDelegate$2(VideoFeedsVideoUIDelegate paramVideoFeedsVideoUIDelegate, String paramString, VideoPlayParam paramVideoPlayParam) {}
  
  public void run()
  {
    QLog.d("VideoFeedsVideoUIDelegate", 2, "onVideoError playButton setVisibility GONE");
    VideoFeedsVideoUIDelegate.a(this.this$0, false);
    this.this$0.a.ad.clearAnimation();
    this.this$0.a.ad.setVisibility(8);
    this.this$0.a.ae.setVisibility(0);
    this.this$0.a.aC.a(1, this.a, "点击重试");
    PlayFeedbackHelper.a(this.b.c.l, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsVideoUIDelegate.2
 * JD-Core Version:    0.7.0.1
 */