package com.tencent.richmediabrowser.view.recyclerview;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.RectF;
import android.view.animation.DecelerateInterpolator;
import com.tencent.richmediabrowser.listener.IBrowserFlingControlListener;
import com.tencent.richmediabrowser.listener.IBrowserFlingEventListener;

public class BrowserFlingAnimator
  extends ValueAnimator
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener
{
  private IBrowserFlingControlListener flingControlListener;
  private IBrowserFlingEventListener flingEventListener;
  private int mCurrentX;
  private int mCurrentY;
  private OverScroller mScroller;
  
  public BrowserFlingAnimator(Context paramContext)
  {
    this.mScroller = new OverScroller(paramContext);
    this.mScroller.setFriction(0.04F);
    setFloatValues(new float[] { 0.0F });
    setInterpolator(new DecelerateInterpolator());
    setDuration(400L);
    addUpdateListener(this);
    addListener(this);
  }
  
  public void cancelFling()
  {
    this.mScroller.forceFinished(true);
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    paramAnimator = this.flingEventListener;
    if (paramAnimator != null) {
      paramAnimator.onFlingAnimationCancel();
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = this.flingEventListener;
    if (paramAnimator != null) {
      paramAnimator.onFlingAnimationEnd();
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationEnd(paramAnimator);
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    paramAnimator = this.flingEventListener;
    if (paramAnimator != null) {
      paramAnimator.onFlingAnimationRepeat();
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    paramAnimator = this.flingEventListener;
    if (paramAnimator != null) {
      paramAnimator.onFlingAnimationStart();
    }
  }
  
  public void onAnimationStart(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationStart(paramAnimator);
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (this.mScroller.isFinished()) {
      return;
    }
    if ((this.mScroller.computeScrollOffset()) && (this.flingControlListener != null))
    {
      int i = this.mScroller.getCurrX();
      int j = this.mScroller.getCurrY();
      this.flingControlListener.startFling(this.mCurrentX - i, this.mCurrentY - j);
      this.mCurrentX = i;
      this.mCurrentY = j;
    }
  }
  
  public void setBrowserFlingControlListener(IBrowserFlingControlListener paramIBrowserFlingControlListener)
  {
    this.flingControlListener = paramIBrowserFlingControlListener;
  }
  
  public void setBrowserFlingEventListener(IBrowserFlingEventListener paramIBrowserFlingEventListener)
  {
    this.flingEventListener = paramIBrowserFlingEventListener;
  }
  
  public void startFling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = this.flingControlListener;
    if (localObject == null) {
      return;
    }
    localObject = ((IBrowserFlingControlListener)localObject).getCurrentMatrixRectF();
    if (localObject == null) {
      return;
    }
    int k = Math.round(-((RectF)localObject).left);
    float f1 = ((RectF)localObject).width();
    float f2 = paramInt1;
    int j;
    int i;
    if (f1 > f2)
    {
      j = Math.round(((RectF)localObject).width() - f2);
      i = 0;
    }
    else
    {
      paramInt1 = k;
      j = paramInt1;
      i = paramInt1;
    }
    int m = Math.round(-((RectF)localObject).top);
    f1 = ((RectF)localObject).height();
    f2 = paramInt2;
    if (f1 > f2)
    {
      paramInt2 = Math.round(((RectF)localObject).height() - f2);
      paramInt1 = 0;
    }
    else
    {
      paramInt1 = m;
      paramInt2 = paramInt1;
    }
    this.mCurrentX = k;
    this.mCurrentY = m;
    if ((k != j) || (m != paramInt2)) {
      this.mScroller.fling(k, m, paramInt3, paramInt4, i, j, paramInt1, paramInt2);
    }
    start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.recyclerview.BrowserFlingAnimator
 * JD-Core Version:    0.7.0.1
 */