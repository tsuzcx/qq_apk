package com.tencent.mobileqq.kandian.base.ktx;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ViewGroupExtensionKt$removeViewWithAnim$1
  implements Runnable
{
  ViewGroupExtensionKt$removeViewWithAnim$1(ViewGroup paramViewGroup, View paramView, Animation paramAnimation, Animation.AnimationListener paramAnimationListener) {}
  
  public final void run()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener((Animation.AnimationListener)new ViewGroupExtensionKt.removeViewWithAnim.1.1(this));
    this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.ktx.ViewGroupExtensionKt.removeViewWithAnim.1
 * JD-Core Version:    0.7.0.1
 */