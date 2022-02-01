package com.tencent.tkd.topicsdk.common;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/common/AnimationExtensionsKt$addAnimationEndListener$2", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "topicsdk-common_release"}, k=1, mv={1, 1, 16})
public final class AnimationExtensionsKt$addAnimationEndListener$2
  implements Animation.AnimationListener
{
  public void onAnimationEnd(@Nullable Animation paramAnimation)
  {
    this.a.invoke();
  }
  
  public void onAnimationRepeat(@Nullable Animation paramAnimation) {}
  
  public void onAnimationStart(@Nullable Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.AnimationExtensionsKt.addAnimationEndListener.2
 * JD-Core Version:    0.7.0.1
 */