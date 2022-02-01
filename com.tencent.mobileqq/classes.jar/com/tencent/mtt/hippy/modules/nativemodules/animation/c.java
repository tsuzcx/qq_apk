package com.tencent.mtt.hippy.modules.nativemodules.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.os.Build.VERSION;
import java.util.ArrayList;

public class c
  extends a
  implements Animator.AnimatorListener
{
  private final AnimatorSet d = new AnimatorSet();
  private AnimatorSet.Builder e;
  private a f;
  private ArrayList<Integer> g;
  private a h = null;
  private int i = 0;
  private int j = 0;
  private int k = -1;
  private final a.a l = new c.1(this);
  
  public c(int paramInt)
  {
    super(paramInt);
    this.d.addListener(this);
  }
  
  public Animator a()
  {
    return this.d;
  }
  
  public void a(a parama, boolean paramBoolean)
  {
    if (parama != null)
    {
      if (parama.a() == null) {
        return;
      }
      parama.a(this.l);
      if (this.h == null) {
        this.h = parama;
      }
      if (this.g == null) {
        this.g = new ArrayList();
      }
      this.g.add(Integer.valueOf(parama.d()));
      if (this.f == null) {}
      for (AnimatorSet.Builder localBuilder = this.d.play(parama.a());; localBuilder = this.d.play(parama.a()).after(this.f.a()))
      {
        this.e = localBuilder;
        this.f = parama;
        return;
        if (!paramBoolean)
        {
          this.e.with(parama.a());
          return;
        }
      }
    }
  }
  
  public void b()
  {
    int m = this.k;
    if ((m == -1) || (m == 2))
    {
      this.j = 0;
      this.k = 0;
      this.d.start();
    }
  }
  
  public void c()
  {
    int m = this.k;
    this.k = 2;
    if ((!this.d.isStarted()) && (m == 1)) {
      onAnimationEnd(this.d);
    }
    this.d.cancel();
  }
  
  public void c(int paramInt)
  {
    this.i = paramInt;
    this.j = 0;
  }
  
  public Object f()
  {
    a locala = this.h;
    if (locala != null) {
      return locala.f();
    }
    return Integer.valueOf(0);
  }
  
  public Object g()
  {
    a locala = this.h;
    if (locala != null) {
      return locala.g();
    }
    return Integer.valueOf(0);
  }
  
  public void h()
  {
    if ((this.d != null) && (Build.VERSION.SDK_INT >= 19)) {
      this.d.resume();
    }
  }
  
  public void i()
  {
    if ((this.d != null) && (Build.VERSION.SDK_INT >= 19)) {
      this.d.pause();
    }
  }
  
  public ArrayList<Integer> j()
  {
    return this.g;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.k == 2)
    {
      super.onAnimationEnd(paramAnimator);
      return;
    }
    int m = this.i;
    if ((m != -1) && ((m <= 0) || (this.j >= m - 1)))
    {
      this.k = 2;
      super.onAnimationEnd(paramAnimator);
      return;
    }
    this.k = 1;
    this.j += 1;
    this.d.start();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.k < 1)
    {
      super.onAnimationStart(paramAnimator);
      return;
    }
    onAnimationRepeat(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.animation.c
 * JD-Core Version:    0.7.0.1
 */