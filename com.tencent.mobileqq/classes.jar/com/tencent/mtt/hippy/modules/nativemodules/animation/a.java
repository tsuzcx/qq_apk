package com.tencent.mtt.hippy.modules.nativemodules.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class a
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener
{
  protected final int a;
  protected CopyOnWriteArrayList<Integer> b;
  protected CopyOnWriteArrayList<a.a> c;
  
  public a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public abstract Animator a();
  
  public void a(int paramInt)
  {
    if (this.b == null) {
      this.b = new CopyOnWriteArrayList();
    }
    if (!this.b.contains(Integer.valueOf(paramInt))) {
      this.b.add(Integer.valueOf(paramInt));
    }
  }
  
  public void a(a.a parama)
  {
    if (this.c == null) {
      this.c = new CopyOnWriteArrayList();
    }
    this.c.add(parama);
  }
  
  public abstract void b();
  
  public void b(int paramInt)
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = this.b;
    if (localCopyOnWriteArrayList != null) {
      localCopyOnWriteArrayList.remove(Integer.valueOf(paramInt));
    }
  }
  
  public abstract void c();
  
  public int d()
  {
    return this.a;
  }
  
  public CopyOnWriteArrayList<Integer> e()
  {
    return this.b;
  }
  
  public abstract Object f();
  
  public abstract Object g();
  
  public abstract void h();
  
  public abstract void i();
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    paramAnimator = this.c;
    if (paramAnimator == null) {
      return;
    }
    paramAnimator = paramAnimator.iterator();
    while (paramAnimator.hasNext()) {
      ((a.a)paramAnimator.next()).onAnimationCancel(this);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = this.c;
    if (paramAnimator == null) {
      return;
    }
    paramAnimator = paramAnimator.iterator();
    while (paramAnimator.hasNext()) {
      ((a.a)paramAnimator.next()).onAnimationEnd(this);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationEnd(paramAnimator);
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    paramAnimator = this.c;
    if (paramAnimator == null) {
      return;
    }
    paramAnimator = paramAnimator.iterator();
    while (paramAnimator.hasNext()) {
      ((a.a)paramAnimator.next()).onAnimationRepeat(this);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    paramAnimator = this.c;
    if (paramAnimator == null) {
      return;
    }
    paramAnimator = paramAnimator.iterator();
    while (paramAnimator.hasNext()) {
      ((a.a)paramAnimator.next()).onAnimationStart(this);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationStart(paramAnimator);
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = this.c;
    if (paramValueAnimator == null) {
      return;
    }
    paramValueAnimator = paramValueAnimator.iterator();
    while (paramValueAnimator.hasNext()) {
      ((a.a)paramValueAnimator.next()).onAnimationUpdate(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.animation.a
 * JD-Core Version:    0.7.0.1
 */