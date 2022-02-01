package com.tencent.mobileqq.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

public class OverScrollRecyclerView$BounceBackState
  extends D8SafeAnimatorListener
  implements ValueAnimator.AnimatorUpdateListener, OverScrollRecyclerView.IDecoratorState
{
  protected final OverScrollRecyclerView.OverScrollStateManager a;
  protected final Interpolator b = new DecelerateInterpolator();
  protected final float c;
  protected final float d;
  protected final OverScrollRecyclerView.AnimationAttributes e;
  
  public OverScrollRecyclerView$BounceBackState(OverScrollRecyclerView.OverScrollStateManager paramOverScrollStateManager, float paramFloat)
  {
    this.a = paramOverScrollStateManager;
    this.c = paramFloat;
    this.d = (paramFloat * 2.0F);
    this.e = new OverScrollRecyclerView.AnimationAttributes();
  }
  
  protected Animator a()
  {
    Object localObject1 = this.a.b();
    Object localObject2 = this.a.b;
    Object localObject3 = this.a.c;
    float f3 = this.a.d;
    ((OverScrollRecyclerView.IOverScrollDecor)localObject2).a((View)localObject1, this.e);
    float f1 = 0.0F;
    if ((f3 != 0.0F) && ((f3 >= 0.0F) || (!((OverScrollRecyclerView.OverScrollStartAttributes)localObject3).c)) && ((f3 <= 0.0F) || (((OverScrollRecyclerView.OverScrollStartAttributes)localObject3).c)))
    {
      float f4 = -f3;
      float f2 = f4 / this.c;
      if (f2 >= 0.0F) {
        f1 = f2;
      }
      f2 = f4 * f3 / this.d;
      f2 = this.e.b + f2;
      localObject1 = a((View)localObject1, (int)f1, f2);
      localObject2 = a(f2);
      localObject3 = new AnimatorSet();
      ((AnimatorSet)localObject3).playSequentially(new Animator[] { localObject1, localObject2 });
      return localObject3;
    }
    return a(this.e.b);
  }
  
  protected ObjectAnimator a(float paramFloat)
  {
    Object localObject = this.a.b();
    OverScrollRecyclerView.OverScrollStartAttributes localOverScrollStartAttributes = this.a.c;
    paramFloat = Math.abs(paramFloat) / this.e.c;
    localObject = ObjectAnimator.ofFloat(localObject, this.e.a, new float[] { localOverScrollStartAttributes.b });
    ((ObjectAnimator)localObject).setDuration(Math.max((int)(paramFloat * 800.0F), 200));
    ((ObjectAnimator)localObject).setInterpolator(this.b);
    ((ObjectAnimator)localObject).addUpdateListener(this);
    return localObject;
  }
  
  protected ObjectAnimator a(View paramView, int paramInt, float paramFloat)
  {
    paramView = ObjectAnimator.ofFloat(paramView, this.e.a, new float[] { paramFloat });
    paramView.setDuration(paramInt);
    paramView.setInterpolator(this.b);
    paramView.addUpdateListener(this);
    return paramView;
  }
  
  public void a(OverScrollRecyclerView.IDecoratorState paramIDecoratorState)
  {
    paramIDecoratorState = a();
    paramIDecoratorState.addListener(this);
    paramIDecoratorState.start();
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = this.a;
    paramAnimator.a(paramAnimator.e);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.OverScrollRecyclerView.BounceBackState
 * JD-Core Version:    0.7.0.1
 */