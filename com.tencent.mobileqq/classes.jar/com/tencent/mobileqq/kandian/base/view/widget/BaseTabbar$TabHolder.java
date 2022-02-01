package com.tencent.mobileqq.kandian.base.view.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.qphone.base.util.QLog;

public class BaseTabbar$TabHolder
{
  public RedDotTextView a;
  public ImageView b;
  public TextView c;
  public View d;
  public ImageView e;
  public ImageView f;
  private boolean g = true;
  
  private void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
    if (this.g)
    {
      b();
      return;
    }
    c();
  }
  
  private void b()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
    localLayoutParams.addRule(1, this.a.getId());
    this.b.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
    localLayoutParams.addRule(1, this.a.getId());
    this.c.setLayoutParams(localLayoutParams);
    this.a.setVisibility(0);
    this.e.setVisibility(8);
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObjectAnimator1 = ObjectAnimator.ofFloat(this.e, "scaleX", new float[] { 1.0F, 0.8F, 1.0F }).setDuration(150L);
      localObjectAnimator2 = ObjectAnimator.ofFloat(this.e, "scaleY", new float[] { 1.0F, 0.8F, 1.0F }).setDuration(150L);
      localObject = ObjectAnimator.ofFloat(this.e, "rotation", new float[] { 0.0F, 720.0F }).setDuration(800L);
      ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.e, "alpha", new float[] { 1.0F, 0.0F }).setDuration(200L);
      localObjectAnimator3.setStartDelay(700L);
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.setInterpolator(new LinearInterpolator());
      localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2);
      localAnimatorSet.play(localObjectAnimator2).before((Animator)localObject);
      localAnimatorSet.play((Animator)localObject).with(localObjectAnimator3);
      localAnimatorSet.addListener(new BaseTabbar.TabHolder.1(this, paramBoolean));
      localAnimatorSet.start();
      return;
    }
    this.g = paramBoolean;
    this.e.setVisibility(0);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.e, "alpha", new float[] { 0.0F, 1.0F }).setDuration(500L);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.e, "rotation", new float[] { -30.0F, 0.0F }).setDuration(500L);
    Object localObject = new AnimatorSet();
    ((AnimatorSet)localObject).play(localObjectAnimator2).with(localObjectAnimator1);
    ((AnimatorSet)localObject).addListener(new BaseTabbar.TabHolder.2(this));
    ((AnimatorSet)localObject).start();
  }
  
  private void c()
  {
    this.e.setVisibility(0);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
    localLayoutParams.addRule(1, this.e.getId());
    this.b.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
    localLayoutParams.addRule(1, this.e.getId());
    this.c.setLayoutParams(localLayoutParams);
    this.a.setVisibility(8);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.g == paramBoolean1) {
      return;
    }
    if (QLog.isDebugVersion()) {
      QLog.d("TabBarView", 4, "setIsTextStyle isTextStyle:");
    }
    if (paramBoolean2)
    {
      b(paramBoolean1);
      return;
    }
    a(paramBoolean1);
  }
  
  public boolean a()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.BaseTabbar.TabHolder
 * JD-Core Version:    0.7.0.1
 */