package com.tencent.viola.ui.view.overscroll;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

public class AbsOverScrollDecorator$BounceBackState
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener, AbsOverScrollDecorator.IDecoratorState
{
  protected final AbsOverScrollDecorator.AnimationAttributes mAnimAttributes;
  protected final Interpolator mBounceBackInterpolator = new DecelerateInterpolator();
  protected final float mDecelerateFactor;
  protected final float mDoubleDecelerateFactor;
  
  public AbsOverScrollDecorator$BounceBackState(AbsOverScrollDecorator paramAbsOverScrollDecorator, float paramFloat)
  {
    this.mDecelerateFactor = paramFloat;
    this.mDoubleDecelerateFactor = (2.0F * paramFloat);
    this.mAnimAttributes = paramAbsOverScrollDecorator.createAnimationAttributes();
  }
  
  protected Animator createAnimator()
  {
    float f1 = 0.0F;
    Object localObject = this.this$0.mViewAdapter.getView();
    this.mAnimAttributes.init((View)localObject);
    if ((this.this$0.mVelocity == 0.0F) || ((this.this$0.mVelocity < 0.0F) && (this.this$0.mStartAttr.mDir)) || ((this.this$0.mVelocity > 0.0F) && (!this.this$0.mStartAttr.mDir))) {
      return createBounceBackAnimator(this.mAnimAttributes.mAbsOffset);
    }
    float f2 = -this.this$0.mVelocity / this.mDecelerateFactor;
    if (f2 < 0.0F) {}
    for (;;)
    {
      f2 = -this.this$0.mVelocity * this.this$0.mVelocity / this.mDoubleDecelerateFactor + this.mAnimAttributes.mAbsOffset;
      localObject = createSlowdownAnimator((View)localObject, (int)f1, f2);
      ObjectAnimator localObjectAnimator = createBounceBackAnimator(f2);
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playSequentially(new Animator[] { localObject, localObjectAnimator });
      return localAnimatorSet;
      f1 = f2;
    }
  }
  
  protected ObjectAnimator createBounceBackAnimator(float paramFloat)
  {
    Object localObject = this.this$0.mViewAdapter.getView();
    paramFloat = Math.abs(paramFloat) / this.mAnimAttributes.mMaxOffset;
    localObject = ObjectAnimator.ofFloat(localObject, this.mAnimAttributes.mProperty, new float[] { this.this$0.mStartAttr.mAbsOffset });
    ((ObjectAnimator)localObject).setDuration(Math.max((int)(paramFloat * 800.0F), 200));
    ((ObjectAnimator)localObject).setInterpolator(this.mBounceBackInterpolator);
    ((ObjectAnimator)localObject).addUpdateListener(this);
    return localObject;
  }
  
  protected ObjectAnimator createSlowdownAnimator(View paramView, int paramInt, float paramFloat)
  {
    paramView = ObjectAnimator.ofFloat(paramView, this.mAnimAttributes.mProperty, new float[] { paramFloat });
    paramView.setDuration(paramInt);
    paramView.setInterpolator(this.mBounceBackInterpolator);
    paramView.addUpdateListener(this);
    return paramView;
  }
  
  public void handleEntryTransition(AbsOverScrollDecorator.IDecoratorState paramIDecoratorState)
  {
    paramIDecoratorState = createAnimator();
    paramIDecoratorState.addListener(this);
    paramIDecoratorState.start();
  }
  
  public boolean handleMoveTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean handleUpOrCancelTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.this$0.issueStateTransition(this.this$0.mIdleState);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.mAnimAttributes.onUpdate(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.view.overscroll.AbsOverScrollDecorator.BounceBackState
 * JD-Core Version:    0.7.0.1
 */