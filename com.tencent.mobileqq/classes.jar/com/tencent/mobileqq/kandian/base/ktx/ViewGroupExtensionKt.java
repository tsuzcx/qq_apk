package com.tencent.mobileqq.kandian.base.ktx;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"addViewWithAnim", "", "Landroid/view/ViewGroup;", "view", "Landroid/view/View;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "animation", "Landroid/view/animation/Animation;", "index", "", "removeViewWithAnim", "animationListener", "Landroid/view/animation/Animation$AnimationListener;", "kandian_feature_impl_release"}, k=2, mv={1, 1, 16})
public final class ViewGroupExtensionKt
{
  public static final void a(@NotNull ViewGroup paramViewGroup, @NotNull View paramView, int paramInt, @NotNull ViewGroup.LayoutParams paramLayoutParams, @NotNull Animation paramAnimation)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "$this$addViewWithAnim");
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramLayoutParams, "layoutParams");
    Intrinsics.checkParameterIsNotNull(paramAnimation, "animation");
    paramView.setVisibility(4);
    paramViewGroup.addView(paramView, paramInt, paramLayoutParams);
    paramView.post((Runnable)new ViewGroupExtensionKt.addViewWithAnim.1(paramView, paramAnimation));
  }
  
  public static final void a(@NotNull ViewGroup paramViewGroup, @NotNull View paramView, @NotNull ViewGroup.LayoutParams paramLayoutParams, @NotNull Animation paramAnimation)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "$this$addViewWithAnim");
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramLayoutParams, "layoutParams");
    Intrinsics.checkParameterIsNotNull(paramAnimation, "animation");
    a(paramViewGroup, paramView, -1, paramLayoutParams, paramAnimation);
  }
  
  public static final void a(@NotNull ViewGroup paramViewGroup, @NotNull View paramView, @NotNull Animation paramAnimation, @Nullable Animation.AnimationListener paramAnimationListener)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "$this$removeViewWithAnim");
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramAnimation, "animation");
    paramView.post((Runnable)new ViewGroupExtensionKt.removeViewWithAnim.1(paramViewGroup, paramView, paramAnimation, paramAnimationListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.ktx.ViewGroupExtensionKt
 * JD-Core Version:    0.7.0.1
 */