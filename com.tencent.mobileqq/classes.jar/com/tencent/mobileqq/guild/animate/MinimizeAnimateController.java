package com.tencent.mobileqq.guild.animate;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import androidx.annotation.RequiresApi;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/guild/animate/MinimizeAnimateController;", "Lcom/tencent/mobileqq/guild/animate/IZoomAnimateController;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "animateAnchor", "Landroid/graphics/Rect;", "animateBoundScale", "", "animateDuringValue", "", "animateIconDrawable", "Landroid/graphics/drawable/Drawable;", "animateIconScaleValue", "", "animateListener", "Lcom/tencent/mobileqq/guild/animate/ZoomAnimateListener;", "animateProcessing", "", "animateScaleValue", "getContext", "()Landroid/content/Context;", "initSuccess", "srcContentLayout", "Landroid/view/View;", "addAnimateAlphaIcon", "animateView", "Lcom/tencent/mobileqq/guild/animate/RectangleClipCompatLayout;", "icon", "addAnimateMask", "addAnimateMicIcon", "attach", "activity", "Landroid/app/Activity;", "fragment", "Landroidx/fragment/app/Fragment;", "checkFloatWindowPermission", "clearAnimateCompatLayout", "", "getAnchorPointRect", "getAnimateCompatLayout", "clipView", "getEndRect", "direction", "", "srcLayout", "anchor", "getStartRect", "initCloseAnimation", "Landroid/animation/Animator;", "initOpenAnimation", "onGlobalLayout", "setAnchorIconDrawable", "setAnchorPoint", "rect", "setAnimateListener", "listener", "startAnimate", "startCloseAnimation", "startOpenAnimation", "Companion", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class MinimizeAnimateController
  implements ViewTreeObserver.OnGlobalLayoutListener, IZoomAnimateController
{
  public static final MinimizeAnimateController.Companion a = new MinimizeAnimateController.Companion(null);
  private ZoomAnimateListener b;
  private View c;
  private boolean d;
  private float e;
  private long f;
  private double g;
  private Rect h;
  private Drawable i;
  @NotNull
  private final Context j;
  
  private final View a(RectangleClipCompatLayout paramRectangleClipCompatLayout)
  {
    View localView = new View(this.j);
    localView.setBackgroundColor(-16777216);
    paramRectangleClipCompatLayout.addView(localView, new ViewGroup.LayoutParams(-1, -1));
    return localView;
  }
  
  private final View a(RectangleClipCompatLayout paramRectangleClipCompatLayout, Drawable paramDrawable)
  {
    ImageView localImageView = new ImageView(this.j);
    localImageView.setImageDrawable(paramDrawable);
    localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    paramDrawable = (View)localImageView;
    paramRectangleClipCompatLayout.addView(paramDrawable, new ViewGroup.LayoutParams(-1, -1));
    return paramDrawable;
  }
  
  private final RectangleClipCompatLayout a(View paramView)
  {
    Object localObject = paramView.getParent();
    if (localObject != null)
    {
      localObject = (ViewGroup)localObject;
      if ((paramView instanceof RectangleClipCompatLayout)) {
        return (RectangleClipCompatLayout)paramView;
      }
      if ((localObject instanceof RectangleClipCompatLayout)) {
        return (RectangleClipCompatLayout)localObject;
      }
      RectangleClipCompatLayout localRectangleClipCompatLayout = new RectangleClipCompatLayout(paramView.getContext());
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      int k = ((ViewGroup)localObject).indexOfChild(paramView);
      ((ViewGroup)localObject).removeView(paramView);
      localRectangleClipCompatLayout.addView(paramView, new ViewGroup.LayoutParams(-1, -1));
      ((ViewGroup)localObject).addView((View)localRectangleClipCompatLayout, k, localLayoutParams);
      return localRectangleClipCompatLayout;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
  }
  
  private final void b(View paramView)
  {
    if ((paramView instanceof RectangleClipCompatLayout))
    {
      RectangleClipCompatLayout localRectangleClipCompatLayout = (RectangleClipCompatLayout)paramView;
      Object localObject = localRectangleClipCompatLayout.getParent();
      if (localObject != null)
      {
        localObject = (ViewGroup)localObject;
        View localView = localRectangleClipCompatLayout.getChildAt(0);
        ((ViewGroup)localObject).removeView(paramView);
        localRectangleClipCompatLayout.removeView(localView);
        ((ViewGroup)localObject).addView(localView, localRectangleClipCompatLayout.getLayoutParams());
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
    }
  }
  
  private final void c()
  {
    Animator localAnimator = b();
    localAnimator.addListener((Animator.AnimatorListener)new MinimizeAnimateController.startOpenAnimation.1(this));
    localAnimator.start();
  }
  
  @NotNull
  public final Rect a()
  {
    Rect localRect1 = new Rect();
    Rect localRect2 = this.h;
    if (localRect2 != null)
    {
      localRect1.top = localRect2.top;
      localRect1.left = localRect2.left;
      localRect1.right = localRect2.right;
      localRect1.bottom = localRect2.bottom;
    }
    return localRect1;
  }
  
  @NotNull
  public final Rect a(int paramInt, @NotNull View paramView, @NotNull Rect paramRect)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "srcLayout");
    Intrinsics.checkParameterIsNotNull(paramRect, "anchor");
    Rect localRect = new Rect();
    if (paramInt == 1)
    {
      paramView.getLocalVisibleRect(localRect);
      localRect.top = 0;
      return localRect;
    }
    if (paramInt == 2)
    {
      localRect.top = ((paramView.getHeight() - paramRect.height()) / 2);
      localRect.left = ((paramView.getWidth() - paramRect.width()) / 2);
      localRect.right = (localRect.left + paramRect.width());
      localRect.bottom = (localRect.top + paramRect.height());
    }
    return localRect;
  }
  
  @NotNull
  public final Animator b()
  {
    Object localObject1 = this.c;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("srcContentLayout");
    }
    Object localObject5 = a((View)localObject1);
    localObject1 = a((RectangleClipCompatLayout)localObject5, this.i);
    Object localObject3 = a((RectangleClipCompatLayout)localObject5);
    Object localObject6 = a();
    int k = ((Rect)localObject6).width();
    Object localObject2 = this.c;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("srcContentLayout");
    }
    localObject2 = a(2, (View)localObject2, (Rect)localObject6);
    Object localObject4 = this.c;
    if (localObject4 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("srcContentLayout");
    }
    localObject4 = b(2, (View)localObject4, (Rect)localObject6);
    Object localObject7 = new StringBuilder();
    ((StringBuilder)localObject7).append("initCloseAnimation: open | startRect - ");
    ((StringBuilder)localObject7).append(((Rect)localObject2).toShortString());
    QLog.i("MinimizeAnimate", 1, ((StringBuilder)localObject7).toString());
    localObject7 = new StringBuilder();
    ((StringBuilder)localObject7).append("initCloseAnimation: open | endRect - ");
    ((StringBuilder)localObject7).append(((Rect)localObject4).toShortString());
    QLog.i("MinimizeAnimate", 1, ((StringBuilder)localObject7).toString());
    localObject5 = (View)localObject5;
    localObject7 = new RectangleRevealAnimator((View)localObject5, (Rect)localObject2, k, (Rect)localObject4, 0.0F);
    Object localObject8 = this.c;
    if (localObject8 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("srcContentLayout");
    }
    localObject8 = AnimationCompatUtils.b((View)localObject8, this.e, 1.0F);
    float f1 = ((Rect)localObject6).left - ((Rect)localObject2).left;
    float f2 = ((Rect)localObject6).top - ((Rect)localObject2).top - ((Rect)localObject4).top;
    localObject6 = this.c;
    if (localObject6 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("srcContentLayout");
    }
    f2 -= ((View)localObject6).getY();
    localObject6 = AnimationCompatUtils.a((View)localObject5, f1, 0.0F, f2, 0.0F);
    Object localObject9 = new StringBuilder();
    ((StringBuilder)localObject9).append("initCloseAnimation: open | translate - x[");
    ((StringBuilder)localObject9).append(f1);
    ((StringBuilder)localObject9).append("]  y[");
    ((StringBuilder)localObject9).append(f2);
    ((StringBuilder)localObject9).append(']');
    QLog.i("MinimizeAnimate", 1, ((StringBuilder)localObject9).toString());
    localObject9 = AnimationCompatUtils.a((View)localObject3, 0.5F, 0.0F);
    localObject3 = new AnimatorSet();
    ((AnimatorSet)localObject3).playTogether(new Animator[] { localObject6, localObject8, (Animator)localObject7, localObject9 });
    ((AnimatorSet)localObject3).setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
    ((AnimatorSet)localObject3).setDuration(this.f);
    f1 = ((Rect)localObject4).width() * 1.0F / ((Rect)localObject2).width();
    localObject2 = AnimationCompatUtils.a((View)localObject1, 1.0F, 0.0F);
    localObject4 = AnimationCompatUtils.b((View)localObject1, f1, 0.8F);
    localObject1 = new AnimatorSet();
    ((AnimatorSet)localObject1).playTogether(new Animator[] { localObject2, localObject4 });
    ((AnimatorSet)localObject1).setDuration(this.f / 2);
    localObject2 = AnimationCompatUtils.a((View)localObject5, 0.0F, 1.0F);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "contentAlphaAnimator");
    ((Animator)localObject2).setDuration(10L);
    localObject4 = new AnimatorSet();
    ((AnimatorSet)localObject4).playTogether(new Animator[] { localObject2, (Animator)localObject1, (Animator)localObject3 });
    return (Animator)localObject4;
  }
  
  @NotNull
  public final Rect b(int paramInt, @NotNull View paramView, @NotNull Rect paramRect)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "srcLayout");
    Intrinsics.checkParameterIsNotNull(paramRect, "anchor");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("x[");
    ((StringBuilder)localObject).append(paramView.getX());
    ((StringBuilder)localObject).append("] y[");
    ((StringBuilder)localObject).append(paramView.getY());
    ((StringBuilder)localObject).append("]");
    QLog.d("MinimizeAnimate", 1, ((StringBuilder)localObject).toString());
    localObject = new int[2];
    paramView.getLocationInWindow((int[])localObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lx[");
    localStringBuilder.append(localObject[0]);
    localStringBuilder.append("] ly[");
    localStringBuilder.append(localObject[1]);
    localStringBuilder.append("]");
    QLog.d("MinimizeAnimate", 1, localStringBuilder.toString());
    localObject = new int[2];
    paramView.getLocationOnScreen((int[])localObject);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("l2x[");
    localStringBuilder.append(localObject[0]);
    localStringBuilder.append("] l2y[");
    localStringBuilder.append(localObject[1]);
    localStringBuilder.append("]");
    QLog.d("MinimizeAnimate", 1, localStringBuilder.toString());
    localObject = new Rect();
    paramView.getLocalVisibleRect((Rect)localObject);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("rect:");
    localStringBuilder.append(((Rect)localObject).toShortString());
    QLog.d("MinimizeAnimate", 1, localStringBuilder.toString());
    localObject = new Rect();
    if (paramInt == 1)
    {
      double d1 = paramRect.height();
      double d2 = this.g;
      Double.isNaN(d1);
      d1 *= d2;
      d2 = paramRect.width();
      double d3 = this.g;
      Double.isNaN(d2);
      d2 *= d3;
      double d4 = paramView.getHeight();
      Double.isNaN(d4);
      d3 = 2;
      Double.isNaN(d3);
      ((Rect)localObject).top = ((int)((d4 - d1) / d3));
      d4 = paramView.getWidth();
      Double.isNaN(d4);
      Double.isNaN(d3);
      ((Rect)localObject).left = ((int)((d4 - d2) / d3));
      d3 = ((Rect)localObject).left;
      Double.isNaN(d3);
      ((Rect)localObject).right = ((int)(d3 + d2));
      d2 = ((Rect)localObject).top;
      Double.isNaN(d2);
      ((Rect)localObject).bottom = ((int)(d2 + d1));
      return localObject;
    }
    if (paramInt == 2)
    {
      paramView.getLocalVisibleRect((Rect)localObject);
      ((Rect)localObject).top = 0;
    }
    return localObject;
  }
  
  @RequiresApi(16)
  public void onGlobalLayout()
  {
    View localView = this.c;
    if (localView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("srcContentLayout");
    }
    localView.getViewTreeObserver().removeGlobalOnLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.animate.MinimizeAnimateController
 * JD-Core Version:    0.7.0.1
 */