package com.tencent.mobileqq.kandian.biz.ugc.selecttopic;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/ugc/selecttopic/SlidingUpDialog;", "Landroid/app/Dialog;", "context", "Landroid/app/Activity;", "customView", "Landroid/view/View;", "showCancelBtn", "", "customViewLp", "Landroid/widget/RelativeLayout$LayoutParams;", "(Landroid/app/Activity;Landroid/view/View;ZLandroid/widget/RelativeLayout$LayoutParams;)V", "rootView", "Landroid/widget/RelativeLayout;", "dismiss", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setCancelOnTouchOutside", "setTranslucentStatusBar", "sliding", "view", "startY", "", "endY", "duration", "", "animEndCallback", "Lkotlin/Function0;", "slidingDown", "slidingUp", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class SlidingUpDialog
  extends Dialog
{
  private RelativeLayout a;
  private final View b;
  private final boolean c;
  private final RelativeLayout.LayoutParams d;
  
  public SlidingUpDialog(@NotNull Activity paramActivity, @NotNull View paramView, boolean paramBoolean, @NotNull RelativeLayout.LayoutParams paramLayoutParams)
  {
    super((Context)paramActivity, 16973833);
    this.b = paramView;
    this.c = paramBoolean;
    this.d = paramLayoutParams;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private final void a()
  {
    findViewById(2131431338).setOnTouchListener((View.OnTouchListener)new SlidingUpDialog.setCancelOnTouchOutside.1(this));
    RelativeLayout localRelativeLayout = this.a;
    if (localRelativeLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    localRelativeLayout.setOnTouchListener((View.OnTouchListener)SlidingUpDialog.setCancelOnTouchOutside.2.a);
  }
  
  private final void a(View paramView, float paramFloat1, float paramFloat2, long paramLong, Function0<Unit> paramFunction0)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 });
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new SlidingUpDialog.sliding.1(paramView));
    if (paramFunction0 != null) {
      localValueAnimator.addListener((Animator.AnimatorListener)new SlidingUpDialog.sliding.2(paramFunction0));
    }
    Intrinsics.checkExpressionValueIsNotNull(localValueAnimator, "valueAnimator");
    localValueAnimator.setDuration(paramLong);
    localValueAnimator.start();
  }
  
  private final void b()
  {
    RelativeLayout localRelativeLayout = this.a;
    if (localRelativeLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    localRelativeLayout.setVisibility(4);
    localRelativeLayout = this.a;
    if (localRelativeLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    localRelativeLayout.post((Runnable)new SlidingUpDialog.slidingUp.1(this));
  }
  
  private final void c()
  {
    Object localObject = this.a;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    localObject = (View)localObject;
    RelativeLayout localRelativeLayout = this.a;
    if (localRelativeLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    a((View)localObject, 0.0F, localRelativeLayout.getHeight(), 200L, (Function0)new SlidingUpDialog.slidingDown.1(this));
  }
  
  private final void d()
  {
    Window localWindow = getWindow();
    if (localWindow != null)
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        View localView = localWindow.getDecorView();
        Intrinsics.checkExpressionValueIsNotNull(localView, "decorView");
        localView.setSystemUiVisibility(1280);
        localWindow.addFlags(-2147483648);
        localWindow.setStatusBarColor(0);
        return;
      }
      if (Build.VERSION.SDK_INT == 19) {
        localWindow.addFlags(67108864);
      }
    }
  }
  
  public void dismiss()
  {
    c();
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    Object localObject = getWindow();
    if (localObject != null)
    {
      ((Window)localObject).requestFeature(1);
      ((Window)localObject).setBackgroundDrawable((Drawable)new ColorDrawable(0));
      ((Window)localObject).setLayout(-1, -1);
      setCanceledOnTouchOutside(false);
      setCancelable(true);
    }
    d();
    super.onCreate(paramBundle);
    setContentView(2131626276);
    this.b.setId(2131444279);
    paramBundle = findViewById(2131429582);
    localObject = findViewById(2131445143);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.rootView)");
    this.a = ((RelativeLayout)localObject);
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "blank");
    localObject = paramBundle.getLayoutParams();
    if (localObject != null)
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(3, this.b.getId());
      localObject = this.a;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
      }
      ((RelativeLayout)localObject).addView(this.b, (ViewGroup.LayoutParams)this.d);
      a();
      localObject = findViewById(2131430272);
      ((View)localObject).setOnClickListener((View.OnClickListener)new SlidingUpDialog.onCreate.2(this));
      if (!this.c)
      {
        Intrinsics.checkExpressionValueIsNotNull(localObject, "cancel");
        ((View)localObject).setVisibility(8);
        paramBundle.setVisibility(8);
      }
      b();
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selecttopic.SlidingUpDialog
 * JD-Core Version:    0.7.0.1
 */