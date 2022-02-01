package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsRecommendPresenter$onDianZanClick$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoFeedsRecommendPresenter$onDianZanClick$1
  implements Animation.AnimationListener
{
  VideoFeedsRecommendPresenter$onDianZanClick$1(VideoItemHolder paramVideoItemHolder, int paramInt) {}
  
  public void onAnimationEnd(@NotNull Animation paramAnimation)
  {
    Intrinsics.checkParameterIsNotNull(paramAnimation, "animation");
    if (this.a.a() == this.b)
    {
      paramAnimation = this.a.g();
      if (paramAnimation != null) {
        paramAnimation = paramAnimation.a;
      } else {
        paramAnimation = null;
      }
      if (paramAnimation != null)
      {
        paramAnimation = this.a.g();
        if (paramAnimation != null)
        {
          paramAnimation = paramAnimation.a;
          if (paramAnimation != null) {
            paramAnimation.a(this.b);
          }
        }
      }
    }
  }
  
  public void onAnimationRepeat(@NotNull Animation paramAnimation)
  {
    Intrinsics.checkParameterIsNotNull(paramAnimation, "animation");
    if (this.b.az != null)
    {
      Object localObject1 = this.b.az;
      Object localObject2 = null;
      if (localObject1 != null) {
        localObject1 = ((VideoPlayParam)localObject1).c;
      } else {
        localObject1 = null;
      }
      if (localObject1 != null)
      {
        localObject1 = this.b.az;
        if (localObject1 != null)
        {
          localObject1 = ((VideoPlayParam)localObject1).c;
          if (localObject1 != null) {
            boolean bool = ((VideoInfo)localObject1).am;
          }
        }
        if (this.b.aS != null)
        {
          ImageView localImageView = this.b.aS;
          if (localImageView != null)
          {
            VideoFeedsAdapter localVideoFeedsAdapter = this.a.g();
            localObject1 = localObject2;
            if (localVideoFeedsAdapter != null) {
              localObject1 = localVideoFeedsAdapter.e(this.c);
            }
            localImageView.setImageDrawable((Drawable)localObject1);
          }
        }
      }
    }
    paramAnimation.setInterpolator((Interpolator)new AnticipateInterpolator());
  }
  
  public void onAnimationStart(@NotNull Animation paramAnimation)
  {
    Intrinsics.checkParameterIsNotNull(paramAnimation, "animation");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsRecommendPresenter.onDianZanClick.1
 * JD-Core Version:    0.7.0.1
 */