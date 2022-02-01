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
  public Handler a;
  public Interpolator a;
  public final HeartAnimator.Config a;
  private HeartAnimator.HeartAnimatorListener a;
  public final Random a;
  public final AtomicInteger a;
  public Interpolator b;
  
  public HeartAnimator(HeartLayout paramHeartLayout)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator$Config = new HeartAnimator.Config(paramHeartLayout);
    this.jdField_a_of_type_JavaUtilRandom = new Random(System.currentTimeMillis());
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = new OvershootInterpolator(1.0F);
    this.b = new LinearInterpolator();
  }
  
  public float a()
  {
    return (this.jdField_a_of_type_JavaUtilRandom.nextInt(40) - 20) * 1.0F;
  }
  
  public Path a(int paramInt1, int paramInt2, AtomicInteger paramAtomicInteger, View paramView)
  {
    Random localRandom = this.jdField_a_of_type_JavaUtilRandom;
    Path localPath = new Path();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator$Config.jdField_a_of_type_Boolean;
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
        localConfig = this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator$Config;
        localConfig.jdField_a_of_type_Int = (paramInt1 - localConfig.h / 2);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator$Config.jdField_a_of_type_Int = ((paramView.getWidth() - this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator$Config.h) / 2);
      }
      if ((paramInt2 >= 0) && (paramInt2 <= paramView.getHeight()))
      {
        this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator$Config.b = (paramView.getHeight() - paramInt2 + this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator$Config.h / 2);
      }
      else
      {
        localConfig = this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator$Config;
        localConfig.b = localConfig.i;
      }
      if (this.jdField_a_of_type_JavaUtilRandom.nextBoolean()) {
        paramInt1 = j;
      } else {
        paramInt1 = -1;
      }
      j = (localRandom.nextInt(this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator$Config.c) + this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator$Config.d) * paramInt1;
      k = (localRandom.nextInt(this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator$Config.c) + this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator$Config.d) * paramInt1;
      n = paramView.getHeight() - this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator$Config.b;
      paramInt2 = (int)(paramAtomicInteger.intValue() * 4 * this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator$Config.jdField_a_of_type_Float) + this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator$Config.g + localRandom.nextInt(this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator$Config.f);
      m = paramInt2 / this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator$Config.e;
      paramInt1 = n - paramInt2;
      if (paramInt1 < 0) {
        paramInt1 = 0;
      }
      i = n - paramInt2 / 2;
      paramInt2 = i;
      if (i < 0) {
        paramInt2 = 0;
      }
      localPath.moveTo(this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator$Config.jdField_a_of_type_Int, n);
      f1 = this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator$Config.jdField_a_of_type_Int;
      f2 = n - m;
      float f3 = this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator$Config.jdField_a_of_type_Int + j;
      float f4 = paramInt2 + m;
      float f5 = this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator$Config.jdField_a_of_type_Int + j;
      float f6 = paramInt2;
      localPath.cubicTo(f1, f2, f3, f4, f5, f6);
      localPath.moveTo(this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator$Config.jdField_a_of_type_Int + j, f6);
      paramInt2 -= m;
      if (paramInt2 >= 0)
      {
        localPath.cubicTo(this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator$Config.jdField_a_of_type_Int + j, paramInt2, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator$Config.jdField_a_of_type_Int + k, m + paramInt1, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator$Config.jdField_a_of_type_Int + k, paramInt1);
        return localPath;
      }
    }
    else
    {
      k = this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator$Config.l;
      m = this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator$Config.k;
      n = this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator$Config.h / 2;
      if (!this.jdField_a_of_type_JavaUtilRandom.nextBoolean()) {
        i = -1;
      }
      int i1 = localRandom.nextInt(this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator$Config.c);
      int i2 = this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator$Config.d;
      int i3 = localRandom.nextInt(this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator$Config.c);
      int i4 = this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator$Config.d;
      j = Math.abs(k - paramInt2) / (this.jdField_a_of_type_JavaUtilRandom.nextInt(3) + 2);
      if (k > paramInt2) {
        j = k - j;
      } else {
        j += k;
      }
      localPath.moveTo(paramInt1 - this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator$Config.h / 2, paramInt2 - this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator$Config.i / 2);
      f1 = (i1 + i2) * i + paramInt1;
      f2 = j;
      localPath.cubicTo(f1, f2, paramInt1 - i * (i3 + i4), f2, m - n, k);
    }
    return localPath;
  }
  
  public HeartAnimator.Config a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator$Config;
  }
  
  public void a(View paramView, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, ViewGroup paramViewGroup, long paramLong, int paramInt3)
  {
    paramView.setTag(2131374208, Boolean.valueOf(true));
    paramViewGroup.addView(paramView, new ViewGroup.LayoutParams(paramInt1, paramInt2));
    HeartAnimator.FloatAnimation localFloatAnimation = new HeartAnimator.FloatAnimation(a((int)paramFloat1, (int)paramFloat2, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger, paramViewGroup), a(), paramViewGroup, paramView, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator$Config);
    if (paramLong <= 0L) {
      paramLong = this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator$Config.j;
    }
    localFloatAnimation.setDuration(paramLong);
    localFloatAnimation.setInterpolator(this.b);
    localFloatAnimation.jdField_a_of_type_Int = paramInt3;
    localFloatAnimation.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator$HeartAnimatorListener = this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator$HeartAnimatorListener;
    localFloatAnimation.jdField_a_of_type_AndroidViewAnimationInterpolator = this.jdField_a_of_type_AndroidViewAnimationInterpolator;
    localFloatAnimation.setAnimationListener(new HeartAnimator.1(this, paramViewGroup, paramView));
    paramView.startAnimation(localFloatAnimation);
  }
  
  public void a(View paramView, float paramFloat1, float paramFloat2, ViewGroup paramViewGroup)
  {
    a(paramView, paramFloat1, paramFloat2, paramViewGroup, -1L, 0);
  }
  
  public void a(View paramView, float paramFloat1, float paramFloat2, ViewGroup paramViewGroup, long paramLong, int paramInt)
  {
    a(paramView, paramFloat1, paramFloat2, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator$Config.h, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator$Config.i, paramViewGroup, paramLong, paramInt);
  }
  
  public void a(HeartAnimator.HeartAnimatorListener paramHeartAnimatorListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator$HeartAnimatorListener = paramHeartAnimatorListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.anim.HeartAnimator
 * JD-Core Version:    0.7.0.1
 */