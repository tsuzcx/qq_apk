package com.tencent.mobileqq.profile.view.helper;

import android.view.View;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.util.DisplayUtil;

public class ShakeEffectGenerator
{
  private final int a;
  private final int b;
  private View c;
  private boolean d = false;
  private int e = 0;
  private int f = 0;
  private TranslateAnimation g;
  private Animation.AnimationListener h = new ShakeEffectGenerator.1(this);
  
  public ShakeEffectGenerator(View paramView)
  {
    if (paramView != null)
    {
      this.c = paramView;
      this.a = DisplayUtil.a(this.c.getContext(), 15.0F);
      double d1 = this.a;
      Double.isNaN(d1);
      this.b = ((int)(d1 / 1.5D));
      return;
    }
    throw new IllegalArgumentException("Wrapped View shouldn't be null!");
  }
  
  public void a()
  {
    this.d = false;
    this.e = 0;
    this.f = 0;
    int j;
    int i;
    int k;
    int m;
    int n;
    do
    {
      double d1 = this.b;
      double d2 = Math.random();
      Double.isNaN(d1);
      j = (int)(d1 * (d2 * 2.0D - 1.0D));
      i = this.b;
      i = (int)Math.sqrt(i * i - j * j);
      if (Math.random() <= 0.5D) {
        i = -i;
      }
      k = this.e;
      m = this.f;
      n = this.a;
    } while ((j + k) * (j + k) + (i + m) * (i + m) > n * n);
    this.g = new TranslateAnimation(k, k + j, m, m + i);
    this.e = (j + this.e);
    this.f = (i + this.f);
    this.g.setDuration(this.b * (int)(Math.random() * 30.0D + 50.0D));
    this.g.setAnimationListener(this.h);
    this.c.startAnimation(this.g);
  }
  
  public void b()
  {
    this.d = true;
    if (c()) {
      this.c.clearAnimation();
    }
  }
  
  public boolean c()
  {
    return this.c.getAnimation() == this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.helper.ShakeEffectGenerator
 * JD-Core Version:    0.7.0.1
 */