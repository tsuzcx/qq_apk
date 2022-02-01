package com.tencent.tkd.topicsdk.mediaselector;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import com.tencent.tkd.R.id;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/mediaselector/BottomSelectorLayout$handleCloseRecentMediaItem$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class BottomSelectorLayout$handleCloseRecentMediaItem$$inlined$let$lambda$1
  implements Animation.AnimationListener
{
  BottomSelectorLayout$handleCloseRecentMediaItem$$inlined$let$lambda$1(RecentMediaListView paramRecentMediaListView, BottomSelectorLayout paramBottomSelectorLayout) {}
  
  public void onAnimationEnd(@Nullable Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout.setRecentMediaSlidingLayout((RecentMediaListView)null);
    ((FrameLayout)this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout.a(R.id.ak)).removeView((View)this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorRecentMediaListView);
  }
  
  public void onAnimationRepeat(@Nullable Animation paramAnimation) {}
  
  public void onAnimationStart(@Nullable Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.BottomSelectorLayout.handleCloseRecentMediaItem..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */