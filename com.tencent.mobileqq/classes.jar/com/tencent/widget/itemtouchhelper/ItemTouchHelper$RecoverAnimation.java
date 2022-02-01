package com.tencent.widget.itemtouchhelper;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class ItemTouchHelper$RecoverAnimation
  extends D8SafeAnimatorListener
{
  final int mActionState;
  final int mAnimationType;
  boolean mEnded = false;
  private float mFraction;
  public boolean mIsPendingCleanup;
  boolean mOverridden = false;
  final float mStartDx;
  final float mStartDy;
  final float mTargetX;
  final float mTargetY;
  private final ValueAnimator mValueAnimator;
  final RecyclerView.ViewHolder mViewHolder;
  float mX;
  float mY;
  
  ItemTouchHelper$RecoverAnimation(ItemTouchHelper paramItemTouchHelper, RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.mActionState = paramInt2;
    this.mAnimationType = paramInt1;
    this.mViewHolder = paramViewHolder;
    this.mStartDx = paramFloat1;
    this.mStartDy = paramFloat2;
    this.mTargetX = paramFloat3;
    this.mTargetY = paramFloat4;
    this.mValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.mValueAnimator.addUpdateListener(new ItemTouchHelper.RecoverAnimation.1(this, paramItemTouchHelper));
    this.mValueAnimator.setTarget(paramViewHolder.itemView);
    this.mValueAnimator.addListener(this);
    setFraction(0.0F);
  }
  
  public void cancel()
  {
    this.mValueAnimator.cancel();
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    setFraction(1.0F);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!this.mEnded) {
      this.mViewHolder.setIsRecyclable(true);
    }
    this.mEnded = true;
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
  
  public void setDuration(long paramLong)
  {
    this.mValueAnimator.setDuration(paramLong);
  }
  
  public void setFraction(float paramFloat)
  {
    this.mFraction = paramFloat;
  }
  
  public void start()
  {
    this.mViewHolder.setIsRecyclable(false);
    this.mValueAnimator.start();
  }
  
  public void update()
  {
    float f1 = this.mStartDx;
    float f2 = this.mTargetX;
    if (f1 == f2) {
      this.mX = this.mViewHolder.itemView.getTranslationX();
    } else {
      this.mX = (f1 + this.mFraction * (f2 - f1));
    }
    f1 = this.mStartDy;
    f2 = this.mTargetY;
    if (f1 == f2)
    {
      this.mY = this.mViewHolder.itemView.getTranslationY();
      return;
    }
    this.mY = (f1 + this.mFraction * (f2 - f1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.itemtouchhelper.ItemTouchHelper.RecoverAnimation
 * JD-Core Version:    0.7.0.1
 */