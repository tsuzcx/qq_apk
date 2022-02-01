package com.tencent.tkd.topicsdk.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/PressView;", "", "()V", "touchDown", "", "view", "Landroid/view/View;", "isDarkBg", "", "isScale", "touchUp", "topicsdk-widget_release"}, k=1, mv={1, 1, 16})
public final class PressView
{
  public static final PressView a = new PressView();
  
  public final void a(@NotNull View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    if (paramBoolean1)
    {
      localObject = ValueAnimator.ofFloat(new float[] { 1.0F, 0.85F });
      ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new PressView.touchDown.1(paramView));
      Intrinsics.checkExpressionValueIsNotNull(localObject, "animator");
      ((ValueAnimator)localObject).setDuration(200L);
      ((ValueAnimator)localObject).start();
      return;
    }
    if (paramBoolean2)
    {
      localObject = new ScaleAnimation(1.0F, 0.8F, 1.0F, 0.8F, paramView.getWidth() / 2, paramView.getHeight() / 2);
      ((ScaleAnimation)localObject).setDuration(200L);
      ((ScaleAnimation)localObject).setFillAfter(true);
      paramView.startAnimation((Animation)localObject);
      return;
    }
    Object localObject = new AlphaAnimation(1.0F, 0.5F);
    ((AlphaAnimation)localObject).setDuration(200L);
    ((AlphaAnimation)localObject).setFillAfter(true);
    paramView.startAnimation((Animation)localObject);
  }
  
  public final void b(@NotNull View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    if (paramBoolean1)
    {
      localObject = ValueAnimator.ofFloat(new float[] { 0.85F, 1.0F });
      ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new PressView.touchUp.1(paramView));
      Intrinsics.checkExpressionValueIsNotNull(localObject, "animator");
      ((ValueAnimator)localObject).setDuration(200L);
      ((ValueAnimator)localObject).start();
      return;
    }
    if (paramBoolean2)
    {
      localObject = new ScaleAnimation(0.8F, 1.0F, 0.8F, 1.0F, paramView.getWidth() / 2, paramView.getHeight() / 2);
      ((ScaleAnimation)localObject).setDuration(200L);
      ((ScaleAnimation)localObject).setFillAfter(true);
      paramView.startAnimation((Animation)localObject);
      return;
    }
    Object localObject = new AlphaAnimation(0.5F, 1.0F);
    ((AlphaAnimation)localObject).setDuration(200L);
    ((AlphaAnimation)localObject).setFillAfter(true);
    paramView.startAnimation((Animation)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.PressView
 * JD-Core Version:    0.7.0.1
 */