package com.tencent.tkd.topicsdk.widget;

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
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/SlidingUpDialog;", "Lcom/tencent/tkd/topicsdk/framework/BaseDialog;", "context", "Landroid/content/Context;", "customView", "Landroid/view/View;", "customViewLp", "Landroid/widget/RelativeLayout$LayoutParams;", "(Landroid/content/Context;Landroid/view/View;Landroid/widget/RelativeLayout$LayoutParams;)V", "isNightMode", "", "()Z", "dismiss", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "show", "sliding", "view", "startY", "", "endY", "duration", "", "animEndCallback", "Lkotlin/Function0;", "slidingDown", "slidingUp", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class SlidingUpDialog
  extends BaseDialog
{
  private final View jdField_a_of_type_AndroidViewView;
  private final RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  
  public SlidingUpDialog(@NotNull Context paramContext, @NotNull View paramView, @NotNull RelativeLayout.LayoutParams paramLayoutParams)
  {
    super(paramContext, 16973833);
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = paramLayoutParams;
  }
  
  private final void a()
  {
    ((RelativeLayout)findViewById(R.id.bf)).post((Runnable)new SlidingUpDialog.slidingUp.1(this));
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
    Object localObject = (RelativeLayout)findViewById(R.id.bf);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "rootView");
    localObject = (View)localObject;
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(R.id.bf);
    Intrinsics.checkExpressionValueIsNotNull(localRelativeLayout, "rootView");
    a((View)localObject, 0.0F, localRelativeLayout.getHeight(), 200L, (Function0)new SlidingUpDialog.slidingDown.1(this));
  }
  
  public boolean a()
  {
    return TopicSDK.a.a().a().a().a();
  }
  
  public void dismiss()
  {
    b();
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    if (getWindow() != null)
    {
      setCanceledOnTouchOutside(false);
      setCancelable(true);
    }
    super.onCreate(paramBundle);
    setContentView(R.layout.J);
    this.jdField_a_of_type_AndroidViewView.setId(R.id.af);
    paramBundle = findViewById(R.id.p);
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "blank");
    paramBundle = paramBundle.getLayoutParams();
    if (paramBundle == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }
    ((RelativeLayout.LayoutParams)paramBundle).addRule(3, this.jdField_a_of_type_AndroidViewView.getId());
    ((FrameLayout)findViewById(R.id.D)).setOnClickListener((View.OnClickListener)new SlidingUpDialog.onCreate.2(this));
    ((RelativeLayout)findViewById(R.id.bf)).addView(this.jdField_a_of_type_AndroidViewView, (ViewGroup.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    ((PressTextView)findViewById(R.id.s)).setOnClickListener((View.OnClickListener)new SlidingUpDialog.onCreate.3(this));
  }
  
  public void show()
  {
    super.show();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.SlidingUpDialog
 * JD-Core Version:    0.7.0.1
 */