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
    if (this.flingEventListener != null) {
      this.flingEventListener.onFlingAnimationCancel();
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.flingEventListener != null) {
      this.flingEventListener.onFlingAnimationEnd();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    if (this.flingEventListener != null) {
      this.flingEventListener.onFlingAnimationRepeat();
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.flingEventListener != null) {
      this.flingEventListener.onFlingAnimationStart();
    }
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (this.mScroller.isFinished()) {}
    while ((!this.mScroller.computeScrollOffset()) || (this.flingControlListener == null)) {
      return;
    }
    int i = this.mScroller.getCurrX();
    int j = this.mScroller.getCurrY();
    this.flingControlListener.startFling(this.mCurrentX - i, this.mCurrentY - j);
    this.mCurrentX = i;
    this.mCurrentY = j;
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
    if (this.flingControlListener == null) {}
    RectF localRectF;
    do
    {
      return;
      localRectF = this.flingControlListener.getCurrentMatrixRectF();
    } while (localRectF == null);
    int i = Math.round(-localRectF.left);
    int j;
    int k;
    int m;
    if (localRectF.width() > paramInt1)
    {
      j = Math.round(localRectF.width() - paramInt1);
      paramInt1 = 0;
      k = Math.round(-localRectF.top);
      if (localRectF.height() <= paramInt2) {
        break label159;
      }
      m = Math.round(localRectF.height() - paramInt2);
    }
    for (paramInt2 = 0;; paramInt2 = k)
    {
      this.mCurrentX = i;
      this.mCurrentY = k;
      if ((i != j) || (k != m)) {
        this.mScroller.fling(i, k, paramInt3, paramInt4, paramInt1, j, paramInt2, m);
      }
      start();
      return;
      j = i;
      paramInt1 = i;
      break;
      label159:
      m = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.recyclerview.BrowserFlingAnimator
 * JD-Core Version:    0.7.0.1
 */