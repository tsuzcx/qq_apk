package com.tencent.mobileqq.dinifly.utils;

import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public abstract class BaseLottieAnimator
  extends ValueAnimator
{
  private final Set<Animator.AnimatorListener> listeners = new CopyOnWriteArraySet();
  private final Set<ValueAnimator.AnimatorUpdateListener> updateListeners = new CopyOnWriteArraySet();
  
  public void addListener(Animator.AnimatorListener paramAnimatorListener)
  {
    this.listeners.add(paramAnimatorListener);
  }
  
  public void addUpdateListener(ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    this.updateListeners.add(paramAnimatorUpdateListener);
  }
  
  public long getStartDelay()
  {
    throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
  }
  
  void notifyCancel()
  {
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext()) {
      ((Animator.AnimatorListener)localIterator.next()).onAnimationCancel(this);
    }
  }
  
  void notifyEnd(boolean paramBoolean)
  {
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext())
    {
      Animator.AnimatorListener localAnimatorListener = (Animator.AnimatorListener)localIterator.next();
      if (Build.VERSION.SDK_INT >= 26) {
        localAnimatorListener.onAnimationEnd(this, paramBoolean);
      } else {
        localAnimatorListener.onAnimationEnd(this);
      }
    }
  }
  
  void notifyRepeat()
  {
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext()) {
      ((Animator.AnimatorListener)localIterator.next()).onAnimationRepeat(this);
    }
  }
  
  void notifyStart(boolean paramBoolean)
  {
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext())
    {
      Animator.AnimatorListener localAnimatorListener = (Animator.AnimatorListener)localIterator.next();
      if (Build.VERSION.SDK_INT >= 26) {
        localAnimatorListener.onAnimationStart(this, paramBoolean);
      } else {
        localAnimatorListener.onAnimationStart(this);
      }
    }
  }
  
  void notifyUpdate()
  {
    Iterator localIterator = this.updateListeners.iterator();
    while (localIterator.hasNext()) {
      ((ValueAnimator.AnimatorUpdateListener)localIterator.next()).onAnimationUpdate(this);
    }
  }
  
  public void removeAllListeners()
  {
    this.listeners.clear();
  }
  
  public void removeAllUpdateListeners()
  {
    this.updateListeners.clear();
  }
  
  public void removeListener(Animator.AnimatorListener paramAnimatorListener)
  {
    this.listeners.remove(paramAnimatorListener);
  }
  
  public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    this.updateListeners.remove(paramAnimatorUpdateListener);
  }
  
  public ValueAnimator setDuration(long paramLong)
  {
    throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
  }
  
  public void setInterpolator(TimeInterpolator paramTimeInterpolator)
  {
    throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
  }
  
  public void setStartDelay(long paramLong)
  {
    throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.utils.BaseLottieAnimator
 * JD-Core Version:    0.7.0.1
 */