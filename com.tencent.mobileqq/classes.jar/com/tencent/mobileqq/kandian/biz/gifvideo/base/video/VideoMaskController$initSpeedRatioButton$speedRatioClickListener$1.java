package com.tencent.mobileqq.kandian.biz.gifvideo.base.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.base.video.player.api.IPlayer;
import com.tencent.mobileqq.kandian.biz.gifvideo.utils.VideoReportUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class VideoMaskController$initSpeedRatioButton$speedRatioClickListener$1
  implements View.OnClickListener
{
  VideoMaskController$initSpeedRatioButton$speedRatioClickListener$1(VideoMaskController paramVideoMaskController) {}
  
  public final void onClick(View paramView)
  {
    VideoMaskController.e(this.a);
    paramView = VideoReportUtil.a;
    AbsBaseArticleInfo localAbsBaseArticleInfo = VideoMaskController.c(this.a);
    IPlayer localIPlayer = this.a.f();
    long l;
    if (localIPlayer != null) {
      l = localIPlayer.o();
    } else {
      l = 0L;
    }
    paramView.a(localAbsBaseArticleInfo, l, VideoMaskController.f(this.a));
    VideoMaskController.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoMaskController.initSpeedRatioButton.speedRatioClickListener.1
 * JD-Core Version:    0.7.0.1
 */