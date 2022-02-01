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
    this.b.setVisibility(0);
    this.c.setAnimationListener((Animation.AnimationListener)new ViewGroupExtensionKt.removeViewWithAnim.1.1(this));
    this.b.startAnimation(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.ktx.ViewGroupExtensionKt.removeViewWithAnim.1
 * JD-Core Version:    0.7.0.1
 */