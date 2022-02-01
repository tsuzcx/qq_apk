package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class VideoFeedsStressFollowLayout$1
  implements View.OnClickListener
{
  VideoFeedsStressFollowLayout$1(VideoFeedsStressFollowLayout paramVideoFeedsStressFollowLayout) {}
  
  public final void onClick(View paramView)
  {
    paramView = VideoFeedsStressFollowLayout.a(this.a);
    if ((paramView != null) && (paramView.p == true)) {
      return;
    }
    paramView = VideoFeedsStressFollowLayout.a(this.a).iterator();
    while (paramView.hasNext()) {
      ((VideoFeedsStressFollowLayout.OnFollowActionListener)paramView.next()).a(VideoFeedsStressFollowLayout.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsStressFollowLayout.1
 * JD-Core Version:    0.7.0.1
 */