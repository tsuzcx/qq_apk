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
import com.tencent.biz.pubaccount.readinjoy.ugc.selecttopic.SlidingUpDialog.slidingDown.1;
import com.tencent.biz.pubaccount.readinjoy.ugc.selecttopic.SlidingUpDialog.slidingUp.1;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/SlidingUpDialog;", "Landroid/app/Dialog;", "context", "Landroid/app/Activity;", "customView", "Landroid/view/View;", "customViewLp", "Landroid/widget/RelativeLayout$LayoutParams;", "(Landroid/app/Activity;Landroid/view/View;Landroid/widget/RelativeLayout$LayoutParams;)V", "rootView", "Landroid/widget/RelativeLayout;", "dismiss", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setCancelOnTouchOutside", "setTranslucentStatusBar", "sliding", "view", "startY", "", "endY", "duration", "", "animEndCallback", "Lkotlin/Function0;", "slidingDown", "slidingUp", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class rpw
  extends ReportDialog
{
  private final View jdField_a_of_type_AndroidViewView;
  private final RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  
  public rpw(@NotNull Activity paramActivity, @NotNull View paramView, @NotNull RelativeLayout.LayoutParams paramLayoutParams)
  {
    super((Context)paramActivity, 16973833);
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = paramLayoutParams;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private final void a()
  {
    findViewById(2131365081).setOnTouchListener((View.OnTouchListener)new rpy(this));
    RelativeLayout localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localRelativeLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    localRelativeLayout.setOnTouchListener((View.OnTouchListener)rpz.a);
  }
  
  private final void a(View paramView, float paramFloat1, float paramFloat2, long paramLong, Function0<Unit> paramFunction0)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 });
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new rqa(paramView));
    if (paramFunction0 != null) {
      localValueAnimator.addListener((Animator.AnimatorListener)new rqb(paramFunction0));
    }
    Intrinsics.checkExpressionValueIsNotNull(localValueAnimator, "valueAnimator");
    localValueAnimator.setDuration(paramLong);
    localValueAnimator.start();
  }
  
  private final void b()
  {
    RelativeLayout localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localRelativeLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    localRelativeLayout.post((Runnable)new SlidingUpDialog.slidingUp.1(this));
  }
  
  private final void c()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    localObject = (View)localObject;
    RelativeLayout localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
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
      if (Build.VERSION.SDK_INT < 21) {
        break label47;
      }
      View localView = localWindow.getDecorView();
      Intrinsics.checkExpressionValueIsNotNull(localView, "decorView");
      localView.setSystemUiVisibility(1280);
      localWindow.addFlags(-2147483648);
      localWindow.setStatusBarColor(0);
    }
    for (;;)
    {
      return;
      label47:
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
    setContentView(2131560221);
    this.jdField_a_of_type_AndroidViewView.setId(2131375940);
    paramBundle = findViewById(2131363577);
    localObject = findViewById(2131376684);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.rootView)");
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject);
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "blank");
    paramBundle = paramBundle.getLayoutParams();
    if (paramBundle == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }
    ((RelativeLayout.LayoutParams)paramBundle).addRule(3, this.jdField_a_of_type_AndroidViewView.getId());
    paramBundle = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (paramBundle == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    paramBundle.addView(this.jdField_a_of_type_AndroidViewView, (ViewGroup.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    a();
    findViewById(2131364175).setOnClickListener((View.OnClickListener)new rpx(this));
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rpw
 * JD-Core Version:    0.7.0.1
 */