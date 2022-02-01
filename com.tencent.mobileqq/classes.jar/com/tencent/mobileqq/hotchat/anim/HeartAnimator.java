package com.tencent.mobileqq.hotchat.anim;

import android.graphics.Path;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class HeartAnimator
{
  public final Random a;
  public final HeartAnimator.Config b;
  public final AtomicInteger c = new AtomicInteger(0);
  public Handler d;
  public Interpolator e;
  public Interpolator f;
  private HeartAnimator.HeartAnimatorListener g;
  
  public HeartAnimator(HeartLayout paramHeartLayout)
  {
    this.b = new HeartAnimator.Config(paramHeartLayout);
    this.a = new Random(System.currentTimeMillis());
    this.d = new Handler(Looper.getMainLooper());
    this.e = new OvershootInterpolator(1.0F);
    this.f = new LinearInterpolator();
  }
  
  public float a()
  {
    return (this.a.nextInt(40) - 20) * 1.0F;
  }
  
  public Path a(int paramInt1, int paramInt2, AtomicInteger paramAtomicInteger, View paramView)
  {
    Random localRandom = this.a;
    Path localPath = new Path();
    boolean bool = this.b.m;
    int i = 1;
    int j = 1;
    int k;
    int n;
    int m;
    float f1;
    float f2;
    if (!bool)
    {
      HeartAnimator.Config localConfig;
      if ((paramInt1 >= 0) && (paramInt1 <= paramView.getWidth()))
      {
        localConfig = this.b;
        localConfig.b = (paramInt1 - localConfig.i / 2);
      }
      else
      {
        this.b.b = ((paramView.getWidth() - this.b.i) / 2);
      }
      if ((paramInt2 >= 0) && (paramInt2 <= paramView.getHeight()))
      {
        this.b.c = (paramView.getHeight() - paramInt2 + this.b.i / 2);
      }
      else
      {
        localConfig = this.b;
        localConfig.c = localConfig.j;
      }
      if (this.a.nextBoolean()) {
        paramInt1 = j;
      } else {
        paramInt1 = -1;
      }
      j = (localRandom.nextInt(this.b.d) + this.b.e) * paramInt1;
      k = (localRandom.nextInt(this.b.d) + this.b.e) * paramInt1;
      n = paramView.getHeight() - this.b.c;
      paramInt2 = (int)(paramAtomicInteger.intValue() * 4 * this.b.a) + this.b.h + localRandom.nextInt(this.b.g);
      m = paramInt2 / this.b.f;
      paramInt1 = n - paramInt2;
      if (paramInt1 < 0) {
        paramInt1 = 0;
      }
      i = n - paramInt2 / 2;
      paramInt2 = i;
      if (i < 0) {
        paramInt2 = 0;
      }
      localPath.moveTo(this.b.b, n);
      f1 = this.b.b;
      f2 = n - m;
      float f3 = this.b.b + j;
      float f4 = paramInt2 + m;
      float f5 = this.b.b + j;
      float f6 = paramInt2;
      localPath.cubicTo(f1, f2, f3, f4, f5, f6);
      localPath.moveTo(this.b.b + j, f6);
      paramInt2 -= m;
      if (paramInt2 >= 0)
      {
        localPath.cubicTo(this.b.b + j, paramInt2, this.b.b + k, m + paramInt1, this.b.b + k, paramInt1);
        return localPath;
      }
    }
    else
    {
      k = this.b.o;
      m = this.b.n;
      n = this.b.i / 2;
      if (!this.a.nextBoolean()) {
        i = -1;
      }
      int i1 = localRandom.nextInt(this.b.d);
      int i2 = this.b.e;
      int i3 = localRandom.nextInt(this.b.d);
      int i4 = this.b.e;
      j = Math.abs(k - paramInt2) / (this.a.nextInt(3) + 2);
      if (k > paramInt2) {
        j = k - j;
      } else {
        j += k;
      }
      localPath.moveTo(paramInt1 - this.b.i / 2, paramInt2 - this.b.j / 2);
      f1 = (i1 + i2) * i + paramInt1;
      f2 = j;
      localPath.cubicTo(f1, f2, paramInt1 - i * (i3 + i4), f2, m - n, k);
    }
    return localPath;
  }
  
  public void a(View paramView, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, ViewGroup paramViewGroup, long paramLong, int paramInt3)
  {
    paramView.setTag(2131442303, Boolean.valueOf(true));
    paramViewGroup.addView(paramView, new ViewGroup.LayoutParams(paramInt1, paramInt2));
    HeartAnimator.FloatAnimation localFloatAnimation = new HeartAnimator.FloatAnimation(a((int)paramFloat1, (int)paramFloat2, this.c, paramViewGroup), a(), paramViewGroup, paramView, this.b);
    if (paramLong <= 0L) {
      paramLong = this.b.k;
    }
    localFloatAnimation.setDuration(paramLong);
    localFloatAnimation.setInterpolator(this.f);
    localFloatAnimation.f = paramInt3;
    localFloatAnimation.g = this.g;
    localFloatAnimation.h = this.e;
    localFloatAnimation.setAnimationListener(new HeartAnimator.1(this, paramViewGroup, paramView));
    paramView.startAnimation(localFloatAnimation);
  }
  
  public void a(View paramView, float paramFloat1, float paramFloat2, ViewGroup paramViewGroup)
  {
    a(paramView, paramFloat1, paramFloat2, paramViewGroup, -1L, 0);
  }
  
  public void a(View paramView, float paramFloat1, float paramFloat2, ViewGroup paramViewGroup, long paramLong, int paramInt)
  {
    a(paramView, paramFloat1, paramFloat2, this.b.i, this.b.j, paramViewGroup, paramLong, paramInt);
  }
  
  public void a(HeartAnimator.HeartAnimatorListener paramHeartAnimatorListener)
  {
    this.g = paramHeartAnimatorListener;
  }
  
  public HeartAnimator.Config b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.anim.HeartAnimator
 * JD-Core Version:    0.7.0.1
 */