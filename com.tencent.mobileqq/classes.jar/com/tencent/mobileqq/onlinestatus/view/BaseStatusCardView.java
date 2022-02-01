package com.tencent.mobileqq.onlinestatus.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.theme.ThemeNavigationBarUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;

public abstract class BaseStatusCardView
  extends ReportDialog
  implements Animator.AnimatorListener
{
  protected float a;
  protected AnimatorSet a;
  protected View a;
  protected BaseStatusCardView.OnDismissCallback a;
  private int[] a;
  protected float b;
  protected View b;
  
  public BaseStatusCardView(@NonNull Context paramContext, BaseStatusCardView.OnDismissCallback paramOnDismissCallback)
  {
    super(paramContext, 2131755400);
    this.jdField_a_of_type_Float = 0.5F;
    this.jdField_b_of_type_Float = 0.5F;
    this.jdField_a_of_type_ArrayOfInt = new int[2];
    setCanceledOnTouchOutside(true);
    setCancelable(true);
    paramContext = getWindow();
    if (paramContext != null)
    {
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        paramContext.addFlags(67108864);
      }
      ImmersiveUtils.clearCoverForStatus(paramContext, true);
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewBaseStatusCardView$OnDismissCallback = paramOnDismissCallback;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(TextView paramTextView)
  {
    a(paramTextView, 2131165605, 2131167266);
  }
  
  public void a(TextView paramTextView, int paramInt1, int paramInt2)
  {
    if (!QQTheme.a()) {
      paramInt1 = paramInt2;
    }
    paramTextView.setTextColor(paramTextView.getResources().getColor(paramInt1));
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat != null)
    {
      if (paramArrayOfFloat.length != 2) {
        return;
      }
      this.jdField_a_of_type_Float = paramArrayOfFloat[0];
      this.jdField_b_of_type_Float = paramArrayOfFloat[1];
    }
  }
  
  protected abstract void a(int[] paramArrayOfInt);
  
  public void aL_()
  {
    show();
  }
  
  protected void b(boolean paramBoolean)
  {
    float f4 = 1.0F;
    float f1;
    if (paramBoolean) {
      f1 = 0.3F;
    } else {
      f1 = 1.0F;
    }
    float f2;
    if (paramBoolean) {
      f2 = 1.0F;
    } else {
      f2 = 0.0F;
    }
    float f3;
    if (paramBoolean) {
      f3 = 0.5F;
    } else {
      f3 = 1.0F;
    }
    if (!paramBoolean) {
      f4 = 0.0F;
    }
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView, "scaleX", new float[] { f1, f2 });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView, "scaleY", new float[] { f1, f2 });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "alpha", new float[] { f3, f4 });
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2).with(localObjectAnimator3);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.setDuration(300L);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
  }
  
  public boolean b(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      if (this.jdField_a_of_type_AndroidViewView == null) {
        return false;
      }
      a(this.jdField_a_of_type_ArrayOfInt);
      this.jdField_b_of_type_AndroidViewView.setPivotX(this.jdField_a_of_type_Float * this.jdField_a_of_type_ArrayOfInt[0]);
      this.jdField_b_of_type_AndroidViewView.setPivotY(this.jdField_b_of_type_Float * this.jdField_a_of_type_ArrayOfInt[1]);
      this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      b(paramBoolean);
      if (!paramBoolean) {
        this.jdField_a_of_type_AndroidAnimationAnimatorSet.addListener(this);
      }
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
      return true;
    }
    return false;
  }
  
  public void dismiss()
  {
    f();
    if (!b(false))
    {
      super.dismiss();
      e();
    }
  }
  
  protected void e() {}
  
  protected void f() {}
  
  public void k()
  {
    f();
    super.dismiss();
    e();
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.dismiss();
    e();
    paramAnimator.removeListener(this);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.dismiss();
    e();
    paramAnimator.removeListener(this);
  }
  
  public void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationEnd(paramAnimator);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationStart(paramAnimator);
  }
  
  public void show()
  {
    ThemeNavigationBarUtil.a(getWindow());
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.BaseStatusCardView
 * JD-Core Version:    0.7.0.1
 */