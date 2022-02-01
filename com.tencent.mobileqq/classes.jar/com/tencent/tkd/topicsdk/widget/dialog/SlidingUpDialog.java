package com.tencent.tkd.topicsdk.widget.dialog;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.tkd.R.id;
import com.tencent.tkd.R.layout;
import com.tencent.tkd.topicsdk.TopicSDK;
import com.tencent.tkd.topicsdk.TopicSDK.Companion;
import com.tencent.tkd.topicsdk.TopicSDKConfig;
import com.tencent.tkd.topicsdk.framework.BaseDialog;
import com.tencent.tkd.topicsdk.interfaces.ITheme;
import com.tencent.tkd.topicsdk.widget.PressTextView;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/dialog/SlidingUpDialog;", "Lcom/tencent/tkd/topicsdk/framework/BaseDialog;", "context", "Landroid/content/Context;", "customView", "Landroid/view/View;", "customViewLp", "Landroid/widget/RelativeLayout$LayoutParams;", "(Landroid/content/Context;Landroid/view/View;Landroid/widget/RelativeLayout$LayoutParams;)V", "isNightMode", "", "()Z", "dismiss", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "show", "sliding", "view", "startY", "", "endY", "duration", "", "animEndCallback", "Lkotlin/Function0;", "slidingDown", "slidingUp", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class SlidingUpDialog
  extends BaseDialog
{
  private final View a;
  private final RelativeLayout.LayoutParams b;
  
  public SlidingUpDialog(@NotNull Context paramContext, @NotNull View paramView, @NotNull RelativeLayout.LayoutParams paramLayoutParams)
  {
    super(paramContext, 16973833);
    this.a = paramView;
    this.b = paramLayoutParams;
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
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(R.id.ag);
    Intrinsics.checkExpressionValueIsNotNull(localRelativeLayout, "rootView");
    localRelativeLayout.setVisibility(4);
    ((RelativeLayout)findViewById(R.id.ag)).post((Runnable)new SlidingUpDialog.slidingUp.1(this));
  }
  
  private final void c()
  {
    Object localObject = (RelativeLayout)findViewById(R.id.ag);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "rootView");
    localObject = (View)localObject;
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(R.id.ag);
    Intrinsics.checkExpressionValueIsNotNull(localRelativeLayout, "rootView");
    a((View)localObject, 0.0F, localRelativeLayout.getHeight(), 200L, (Function0)new SlidingUpDialog.slidingDown.1(this));
  }
  
  public boolean a()
  {
    return TopicSDK.a.a().b().j().a();
  }
  
  public void dismiss()
  {
    c();
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    if (getWindow() != null)
    {
      setCanceledOnTouchOutside(false);
      setCancelable(true);
    }
    super.onCreate(paramBundle);
    setContentView(R.layout.E);
    this.a.setId(R.id.w);
    paramBundle = findViewById(R.id.d);
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "blank");
    paramBundle = paramBundle.getLayoutParams();
    if (paramBundle != null)
    {
      ((RelativeLayout.LayoutParams)paramBundle).addRule(3, this.a.getId());
      ((FrameLayout)findViewById(R.id.i)).setOnClickListener((View.OnClickListener)new SlidingUpDialog.onCreate.2(this));
      ((RelativeLayout)findViewById(R.id.ag)).setOnClickListener((View.OnClickListener)SlidingUpDialog.onCreate.3.a);
      ((RelativeLayout)findViewById(R.id.ag)).addView(this.a, (ViewGroup.LayoutParams)this.b);
      ((PressTextView)findViewById(R.id.g)).setOnClickListener((View.OnClickListener)new SlidingUpDialog.onCreate.4(this));
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
  }
  
  public void show()
  {
    super.show();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.dialog.SlidingUpDialog
 * JD-Core Version:    0.7.0.1
 */