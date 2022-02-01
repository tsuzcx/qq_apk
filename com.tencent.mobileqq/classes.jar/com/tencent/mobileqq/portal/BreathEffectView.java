package com.tencent.mobileqq.portal;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

public class BreathEffectView
  extends ImageView
  implements Animation.AnimationListener
{
  ObjectAnimator a;
  private int b;
  
  public BreathEffectView(Context paramContext)
  {
    super(paramContext);
  }
  
  public BreathEffectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BreathEffectView", 2, "yure yellow");
    }
    g();
    setImageResource(2130846731);
    d();
    this.b = 1;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BreathEffectView", 2, "formal red");
    }
    g();
    setImageResource(2130846732);
    d();
    this.b = 2;
  }
  
  public void c()
  {
    g();
    setImageResource(2130848412);
    e();
  }
  
  public void d()
  {
    setVisibility(0);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.2F, 1.0F);
    localAlphaAnimation.setAnimationListener(this);
    localAlphaAnimation.setRepeatMode(2);
    localAlphaAnimation.setDuration(1300L);
    localAlphaAnimation.setRepeatCount(-1);
    startAnimation(localAlphaAnimation);
  }
  
  public void e()
  {
    setVisibility(0);
    this.a = ObjectAnimator.ofFloat(this, "alpha", new float[] { 0.0F, 1.0F, 0.5F, 1.0F, 0.0F });
    this.a.setInterpolator(new AccelerateDecelerateInterpolator());
    this.a.addUpdateListener(new BreathEffectView.1(this));
    this.a.setDuration(4000L);
    this.a.setRepeatCount(0);
    this.a.start();
  }
  
  public void f()
  {
    ObjectAnimator localObjectAnimator = this.a;
    if (localObjectAnimator != null)
    {
      localObjectAnimator.end();
      this.a.cancel();
      this.a = null;
    }
  }
  
  public void g()
  {
    Animation localAnimation = getAnimation();
    if (localAnimation != null)
    {
      localAnimation.setAnimationListener(null);
      setAnimation(null);
      clearAnimation();
    }
    setImageDrawable(null);
    this.b = 0;
  }
  
  public int getCurDisplayState()
  {
    return this.b;
  }
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.BreathEffectView
 * JD-Core Version:    0.7.0.1
 */