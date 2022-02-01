package com.tencent.mobileqq.kandian.base.ktx;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/base/ktx/ViewGroupExtensionKt$removeViewWithAnim$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ViewGroupExtensionKt$removeViewWithAnim$1$1
  implements Animation.AnimationListener
{
  public void onAnimationEnd(@Nullable Animation paramAnimation)
  {
    Animation.AnimationListener localAnimationListener = this.a.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener;
    if (localAnimationListener != null) {
      localAnimationListener.onAnimationEnd(paramAnimation);
    }
    this.a.jdField_a_of_type_AndroidViewView.setVisibility(4);
    this.a.jdField_a_of_type_AndroidViewView.post((Runnable)new ViewGroupExtensionKt.removeViewWithAnim.1.1.onAnimationEnd.1(this));
  }
  
  public void onAnimationRepeat(@Nullable Animation paramAnimation)
  {
    Animation.AnimationListener localAnimationListener = this.a.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener;
    if (localAnimationListener != null) {
      localAnimationListener.onAnimationRepeat(paramAnimation);
    }
  }
  
  public void onAnimationStart(@Nullable Animation paramAnimation)
  {
    Animation.AnimationListener localAnimationListener = this.a.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener;
    if (localAnimationListener != null) {
      localAnimationListener.onAnimationStart(paramAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.ktx.ViewGroupExtensionKt.removeViewWithAnim.1.1
 * JD-Core Version:    0.7.0.1
 */