package com.tencent.tkd.topicsdk.common;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"addAnimationEndListener", "", "Landroid/animation/ValueAnimator;", "listener", "Lkotlin/Function0;", "Landroid/view/animation/Animation;", "topicsdk-common_release"}, k=2, mv={1, 1, 16})
public final class AnimationExtensionsKt
{
  public static final void a(@NotNull ValueAnimator paramValueAnimator, @NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramValueAnimator, "$this$addAnimationEndListener");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "listener");
    paramValueAnimator.addListener((Animator.AnimatorListener)new AnimationExtensionsKt.addAnimationEndListener.1(paramFunction0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.AnimationExtensionsKt
 * JD-Core Version:    0.7.0.1
 */