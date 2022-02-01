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
  private int[] a = new int[2];
  protected View i;
  protected View j;
  protected float k = 0.5F;
  protected float l = 0.5F;
  protected AnimatorSet m;
  protected BaseStatusCardView.OnDismissCallback n;
  
  public BaseStatusCardView(@NonNull Context paramContext, BaseStatusCardView.OnDismissCallback paramOnDismissCallback)
  {
    super(paramContext, 2131952168);
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
    this.n = paramOnDismissCallback;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(TextView paramTextView)
  {
    a(paramTextView, 2131165997, 2131168264);
  }
  
  public void a(TextView paramTextView, int paramInt1, int paramInt2)
  {
    if (!QQTheme.isNowThemeIsNight()) {
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
      this.k = paramArrayOfFloat[0];
      this.l = paramArrayOfFloat[1];
    }
  }
  
  protected abstract void a(int[] paramArrayOfInt);
  
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
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.j, "scaleX", new float[] { f1, f2 });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.j, "scaleY", new float[] { f1, f2 });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.i, "alpha", new float[] { f3, f4 });
    this.m.play(localObjectAnimator1).with(localObjectAnimator2).with(localObjectAnimator3);
    this.m.setDuration(300L);
    this.m.setInterpolator(new AccelerateDecelerateInterpolator());
  }
  
  public void dg_()
  {
    show();
  }
  
  public void dismiss()
  {
    k();
    if (!e(false))
    {
      super.dismiss();
      g();
    }
  }
  
  public boolean e(boolean paramBoolean)
  {
    if (this.j != null)
    {
      if (this.i == null) {
        return false;
      }
      a(this.a);
      this.j.setPivotX(this.k * this.a[0]);
      this.j.setPivotY(this.l * this.a[1]);
      this.m = new AnimatorSet();
      b(paramBoolean);
      if (!paramBoolean) {
        this.m.addListener(this);
      }
      this.m.start();
      return true;
    }
    return false;
  }
  
  protected void g() {}
  
  protected void k() {}
  
  public void m()
  {
    k();
    super.dismiss();
    g();
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.dismiss();
    g();
    paramAnimator.removeListener(this);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.dismiss();
    g();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.BaseStatusCardView
 * JD-Core Version:    0.7.0.1
 */