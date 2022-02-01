package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.base.utils.KandianUGStatisticUtils;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.UGDownloadInfo;
import com.tencent.mobileqq.utils.SharedPreUtils;

class VideoFeedsUGView$1
  implements View.OnClickListener
{
  VideoFeedsUGView$1(VideoFeedsUGView paramVideoFeedsUGView) {}
  
  public void onClick(View paramView)
  {
    SharedPreUtils.a("ug_prefix_ug_1get3_ug_close_time", System.currentTimeMillis());
    this.a.setVisibility(8);
    KandianUGStatisticUtils.a(KandianUGStatisticUtils.b(this.a.a.i, "101", this.a.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsUGView.1
 * JD-Core Version:    0.7.0.1
 */