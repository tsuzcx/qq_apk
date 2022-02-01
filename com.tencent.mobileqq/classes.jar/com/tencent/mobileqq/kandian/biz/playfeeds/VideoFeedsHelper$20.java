package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.repo.feeds.RichTitleInfo;

final class VideoFeedsHelper$20
  implements View.OnClickListener
{
  private long d;
  
  VideoFeedsHelper$20(TextView paramTextView, RichTitleInfo paramRichTitleInfo, VideoInfo paramVideoInfo) {}
  
  public void onClick(View paramView)
  {
    if ((this.d == 0L) || (System.currentTimeMillis() - this.d > 2000L))
    {
      this.d = System.currentTimeMillis();
      ReadInJoyUtils.a(this.a.getContext(), this.b.d);
      if (this.b.e == 1)
      {
        VideoFeedsReporter.a.b(this.c);
        return;
      }
      VideoFeedsReporter.a.a(this.c, this.b.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper.20
 * JD-Core Version:    0.7.0.1
 */