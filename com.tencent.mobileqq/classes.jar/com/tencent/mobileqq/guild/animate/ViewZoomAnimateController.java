package com.tencent.mobileqq.guild.animate;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import androidx.annotation.RequiresApi;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/guild/animate/ViewZoomAnimateController;", "Lcom/tencent/mobileqq/guild/animate/IZoomAnimateController;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "animateAnchor", "Landroid/graphics/Rect;", "animateBoundScale", "", "animateContentBgDrawable", "Landroid/graphics/drawable/Drawable;", "animateContentLayout", "Landroid/view/View;", "animateDuringValue", "", "animateIconDrawable", "animateListener", "Lcom/tencent/mobileqq/guild/animate/ZoomAnimateListener;", "animateProcessing", "", "animateRootLayout", "animateScaleValue", "", "animateZoomView", "getContext", "()Landroid/content/Context;", "initSuccess", "addAnimateAlphaIcon", "animateView", "Lcom/tencent/mobileqq/guild/animate/RectangleClipCompatLayout;", "icon", "addAnimateMask", "addAnimateMicIcon", "attach", "rootView", "contentView", "checkFloatWindowPermission", "clearAnimateCompatLayout", "", "force", "getAnchorPointRect", "getAnimateCompatLayout", "getAnimateImageView", "Landroid/widget/ImageView;", "getEndRect", "direction", "", "srcLayout", "anchor", "getOpenAnimateCompatLayout", "getStartRect", "initCloseAnimation", "Landroid/animation/Animator;", "initOpenAnimation", "onGlobalLayout", "setAnchorIconDrawable", "setAnchorPoint", "rect", "setAnimateListener", "listener", "startAnimate", "startCloseAnimation", "startOpenAnimation", "Companion", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class ViewZoomAnimateController
  implements ViewTreeObserver.OnGlobalLayoutListener, IZoomAnimateController
{
  public static final ViewZoomAnimateController.Companion a = new ViewZoomAnimateController.Companion(null);
  private ZoomAnimateListener b;
  private View c;
  private boolean d;
  private float e;
  private long f;
  private double g;
  private Rect h;
  private Drawable i;
  private View j;
  private Drawable k;
  @NotNull
  private final Context l;
  
  private final View a(RectangleClipCompatLayout paramRectangleClipCompatLayout)
  {
    View localView = new View(this.l);
    localView.setBackgroundColor(-16777216);
    paramRectangleClipCompatLayout.addView(localView, new ViewGroup.LayoutParams(-1, -1));
    return localView;
  }
  
  private final View a(RectangleClipCompatLayout paramRectangleClipCompatLayout, Drawable paramDrawable)
  {
    ImageView localImageView = new ImageView(this.l);
    localImageView.setImageDrawable(paramDrawable);
    localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    paramDrawable = (View)localImageView;
    paramRectangleClipCompatLayout.addView(paramDrawable, new ViewGroup.LayoutParams(-1, -1));
    return paramDrawable;
  }
  
  private final RectangleClipCompatLayout a(View paramView)
  {
    if (paramView != null)
    {
      paramView = (ViewGroup)paramView;
      View localView = paramView.findViewById(2131428867);
      RectangleClipCompatLayout localRectangleClipCompatLayout = new RectangleClipCompatLayout(paramView.getContext());
      paramView.removeView(localView);
      paramView.addView((View)localRectangleClipCompatLayout, new ViewGroup.LayoutParams(-1, -1));
      localRectangleClipCompatLayout.addView(localView, new ViewGroup.LayoutParams(-1, -1));
      return localRectangleClipCompatLayout;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
  }
  
  private final void a(View paramView, boolean paramBoolean)
  {
    if ((paramView instanceof RectangleClipCompatLayout))
    {
      RectangleClipCompatLayout localRectangleClipCompatLayout = (RectangleClipCompatLayout)paramView;
      Object localObject = localRectangleClipCompatLayout.getParent();
      if (localObject != null)
      {
        localObject = (ViewGroup)localObject;
        ((ViewGroup)localObject).removeView(paramView);
        if (!paramBoolean)
        {
          paramView = localRectangleClipCompatLayout.getChildAt(0);
          localRectangleClipCompatLayout.removeView(paramView);
          ((ViewGroup)localObject).addView(paramView, localRectangleClipCompatLayout.getLayoutParams());
        }
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
      }
    }
  }
  
  private final void c()
  {
    Animator localAnimator = b();
    localAnimator.addListener((Animator.AnimatorListener)new ViewZoomAnimateController.startOpenAnimation.1(this));
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
      Intrinsics.throwUninitializedPropertyAccessException("animateContentLayout");
    }
    Object localObject5 = ((View)localObject1).findViewById(2131428867);
    localObject1 = this.c;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("animateContentLayout");
    }
    Object localObject3 = a((View)localObject1);
    localObject1 = (View)localObject3;
    this.j = ((View)localObject1);
    Object localObject2 = a((RectangleClipCompatLayout)localObject3, this.i);
    Object localObject4 = a((RectangleClipCompatLayout)localObject3);
    Object localObject7 = a();
    int m = ((Rect)localObject7).width();
    localObject3 = this.c;
    if (localObject3 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("animateContentLayout");
    }
    localObject3 = a(2, (View)localObject3, (Rect)localObject7);
    Object localObject6 = new StringBuilder();
    ((StringBuilder)localObject6).append("initOpenAnimation: start rect [");
    ((StringBuilder)localObject6).append(localObject3);
    ((StringBuilder)localObject6).append(']');
    QLog.i("ViewZoomAnimateController", 1, ((StringBuilder)localObject6).toString());
    localObject6 = this.c;
    if (localObject6 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("animateContentLayout");
    }
    localObject6 = b(2, (View)localObject6, (Rect)localObject7);
    Object localObject8 = new StringBuilder();
    ((StringBuilder)localObject8).append("initOpenAnimation: end rect [");
    ((StringBuilder)localObject8).append(localObject6);
    ((StringBuilder)localObject8).append(']');
    QLog.i("ViewZoomAnimateController", 1, ((StringBuilder)localObject8).toString());
    localObject8 = new RectangleRevealAnimator((View)localObject1, (Rect)localObject3, m, (Rect)localObject6, 0.0F);
    localObject5 = AnimationCompatUtils.b((View)localObject5, this.e, 1.0F);
    float f1 = ((Rect)localObject7).left - ((Rect)localObject3).left;
    float f2 = ((Rect)localObject7).top - ((Rect)localObject3).top - ((Rect)localObject6).top;
    localObject7 = this.c;
    if (localObject7 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("animateContentLayout");
    }
    localObject7 = AnimationCompatUtils.a((View)localObject1, f1, 0.0F, f2 - ((View)localObject7).getY(), 0.0F);
    Animator localAnimator = AnimationCompatUtils.a((View)localObject4, 0.5F, 0.0F);
    localObject4 = new AnimatorSet();
    ((AnimatorSet)localObject4).playTogether(new Animator[] { localObject7, localObject5, (Animator)localObject8, localAnimator });
    ((AnimatorSet)localObject4).setDuration(this.f);
    f1 = ((Rect)localObject6).width() * 1.0F / ((Rect)localObject3).width();
    localObject3 = AnimationCompatUtils.a((View)localObject2, 1.0F, 0.0F);
    localObject5 = AnimationCompatUtils.b((View)localObject2, f1, 0.8F);
    localObject2 = new AnimatorSet();
    ((AnimatorSet)localObject2).playTogether(new Animator[] { localObject3, localObject5 });
    ((AnimatorSet)localObject2).setDuration(this.f / 2);
    localObject1 = AnimationCompatUtils.a((View)localObject1, 0.0F, 1.0F);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "contentAlphaAnimator");
    ((Animator)localObject1).setDuration(10L);
    localObject3 = new AnimatorSet();
    ((AnimatorSet)localObject3).playTogether(new Animator[] { localObject1, (Animator)localObject2, (Animator)localObject4 });
    return (Animator)localObject3;
  }
  
  @NotNull
  public final Rect b(int paramInt, @NotNull View paramView, @NotNull Rect paramRect)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "srcLayout");
    Intrinsics.checkParameterIsNotNull(paramRect, "anchor");
    Rect localRect = new Rect();
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
      localRect.top = ((int)((d4 - d1) / d3));
      d4 = paramView.getWidth();
      Double.isNaN(d4);
      Double.isNaN(d3);
      localRect.left = ((int)((d4 - d2) / d3));
      d3 = localRect.left;
      Double.isNaN(d3);
      localRect.right = ((int)(d3 + d2));
      d2 = localRect.top;
      Double.isNaN(d2);
      localRect.bottom = ((int)(d2 + d1));
      return localRect;
    }
    if (paramInt == 2)
    {
      paramView.getDrawingRect(localRect);
      localRect.top = 0;
    }
    return localRect;
  }
  
  @RequiresApi(16)
  public void onGlobalLayout()
  {
    View localView = this.c;
    if (localView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("animateContentLayout");
    }
    localView.getViewTreeObserver().removeGlobalOnLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.animate.ViewZoomAnimateController
 * JD-Core Version:    0.7.0.1
 */