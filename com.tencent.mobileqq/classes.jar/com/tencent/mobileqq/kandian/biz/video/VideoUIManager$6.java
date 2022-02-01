package com.tencent.mobileqq.kandian.biz.video;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeedback.MsgLayoutHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeedback.PlayFeedbackHelper;

class VideoUIManager$6
  implements Runnable
{
  VideoUIManager$6(VideoUIManager paramVideoUIManager, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    VideoUIManager.l(this.this$0).setVisibility(8);
    VideoUIManager.m(this.this$0);
    VideoUIManager.n(this.this$0).setVisibility(8);
    VideoUIManager.o(this.this$0).setVisibility(8);
    VideoUIManager.p(this.this$0).setVisibility(8);
    if (this.a == 1) {
      VideoUIManager.q(this.this$0);
    }
    VideoUIManager.r(this.this$0).a(this.a, this.b, this.c);
    if (this.a == 1) {
      PlayFeedbackHelper.a(VideoUIManager.s(this.this$0).a(), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.VideoUIManager.6
 * JD-Core Version:    0.7.0.1
 */