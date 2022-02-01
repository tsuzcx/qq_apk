package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import com.tencent.util.AnimateUtils;

class OverScroller$SplineOverScroller
{
  private static final int BOUNCE = 3;
  private static final int CUBIC = 1;
  private static float DECELERATION_RATE = (float)(Math.log(0.78D) / Math.log(0.9D));
  private static final float END_TENSION = 1.0F;
  private static final float GRAVITY = 2000.0F;
  private static final float INFLEXION = 0.35F;
  private static final int NB_SAMPLES = 100;
  private static final float P1 = 0.175F;
  private static final float P2 = 0.35F;
  private static float PHYSICAL_COEF = 0.0F;
  private static final int SCROLL = 4;
  private static final int SPLINE = 0;
  private static final float[] SPLINE_POSITION = new float[101];
  private static final float[] SPLINE_TIME = new float[101];
  private static final float START_TENSION = 0.5F;
  private float mCurrVelocity;
  private int mCurrentPosition;
  private float mDeceleration;
  private int mDuration;
  private int mFinal;
  private boolean mFinished = true;
  private float mFlingFriction = ViewConfiguration.getScrollFriction();
  private int mFlingMode = 0;
  private long mLastTime;
  private double mLastVelocity;
  private int mOver;
  private int mSplineDistance;
  private int mSplineDuration;
  private int mStart;
  private long mStartTime;
  private int mState = 0;
  private float mTension;
  private int mVelocity;
  
  static
  {
    float f1 = 0.0F;
    int i = 0;
    float f2 = 0.0F;
    if (i < 100)
    {
      float f5 = i / 100.0F;
      float f3 = 1.0F;
      for (;;)
      {
        float f4 = (f3 - f1) / 2.0F + f1;
        float f6 = 1.0F - f4;
        float f7 = f4 * 3.0F * f6;
        float f8 = f4 * f4 * f4;
        float f9 = (f6 * 0.175F + f4 * 0.35F) * f7 + f8;
        if (Math.abs(f9 - f5) < 1.E-005D)
        {
          SPLINE_POSITION[i] = (f7 * (f6 * 0.5F + f4) + f8);
          f3 = 1.0F;
          for (;;)
          {
            f4 = (f3 - f2) / 2.0F + f2;
            f6 = 1.0F - f4;
            f7 = f4 * 3.0F * f6;
            f8 = f4 * f4 * f4;
            f9 = (f6 * 0.5F + f4) * f7 + f8;
            if (Math.abs(f9 - f5) < 1.E-005D)
            {
              SPLINE_TIME[i] = (f7 * (f6 * 0.175F + f4 * 0.35F) + f8);
              i += 1;
              break;
            }
            if (f9 > f5) {
              f3 = f4;
            } else {
              f2 = f4;
            }
          }
        }
        if (f9 > f5) {
          f3 = f4;
        } else {
          f1 = f4;
        }
      }
    }
    float[] arrayOfFloat = SPLINE_POSITION;
    SPLINE_TIME[100] = 1.0F;
    arrayOfFloat[100] = 1.0F;
  }
  
  private void adjustDuration(int paramInt1, int paramInt2, int paramInt3)
  {
    float f3 = Math.abs((paramInt3 - paramInt1) / (paramInt2 - paramInt1));
    paramInt1 = (int)(f3 * 100.0F);
    if (paramInt1 < 100)
    {
      float f4 = paramInt1 / 100.0F;
      paramInt2 = paramInt1 + 1;
      float f5 = paramInt2 / 100.0F;
      float[] arrayOfFloat = SPLINE_TIME;
      float f1 = arrayOfFloat[paramInt1];
      float f2 = arrayOfFloat[paramInt2];
      f3 = (f3 - f4) / (f5 - f4);
      this.mDuration = ((int)(this.mDuration * (f1 + f3 * (f2 - f1))));
    }
  }
  
  private double getSplineDeceleration(int paramInt)
  {
    return Math.log(Math.abs(paramInt) * 0.35F / (this.mFlingFriction * PHYSICAL_COEF));
  }
  
  private double getSplineFlingDistance(int paramInt)
  {
    double d2 = getSplineDeceleration(paramInt);
    float f = DECELERATION_RATE;
    double d3 = f;
    Double.isNaN(d3);
    double d1 = this.mFlingFriction * PHYSICAL_COEF;
    double d4 = f;
    Double.isNaN(d4);
    d2 = Math.exp(d4 / (d3 - 1.0D) * d2);
    Double.isNaN(d1);
    return d1 * d2;
  }
  
  private int getSplineFlingDuration(int paramInt)
  {
    double d1 = getSplineDeceleration(paramInt);
    double d2 = DECELERATION_RATE;
    Double.isNaN(d2);
    return (int)(Math.exp(d1 / (d2 - 1.0D)) * 1000.0D);
  }
  
  static void initFromContext(Context paramContext)
  {
    PHYSICAL_COEF = paramContext.getResources().getDisplayMetrics().density * 160.0F * 386.0878F * 0.84F;
  }
  
  private void onEdgeReached()
  {
    long l = this.mStartTime;
    int i = this.mDuration;
    l += i;
    i = (int)(i / this.mSplineDuration * 100.0F);
    if (i < 100)
    {
      f1 = i / 100.0F;
      int j = i + 1;
      float f2 = j / 100.0F;
      float[] arrayOfFloat = SPLINE_POSITION;
      float f3 = arrayOfFloat[i];
      f1 = (arrayOfFloat[j] - f3) / (f2 - f1);
    }
    else
    {
      f1 = 0.0F;
    }
    this.mCurrVelocity = (f1 * this.mSplineDistance / this.mSplineDuration * 1000.0F);
    float f1 = this.mCurrVelocity;
    double d1 = f1;
    double d2 = this.mLastVelocity;
    Double.isNaN(d1);
    double d3 = l - this.mLastTime;
    Double.isNaN(d3);
    this.mDeceleration = ((float)((d1 - d2) / d3 * 1000.0D));
    bounce(this.mFinal, this.mOver, (int)f1, OverScroller.BOUNCE_DURANTION);
    this.mStartTime = l;
    update();
  }
  
  private void onEdgeReachedNoBack()
  {
    long l = this.mStartTime;
    int i = this.mDuration;
    l += i;
    i = (int)(i / this.mSplineDuration * 100.0F);
    float f1;
    if (i < 100)
    {
      f1 = i / 100.0F;
      int j = i + 1;
      float f2 = j / 100.0F;
      float[] arrayOfFloat = SPLINE_POSITION;
      float f3 = arrayOfFloat[i];
      f1 = (arrayOfFloat[j] - f3) / (f2 - f1);
    }
    else
    {
      f1 = 0.0F;
    }
    this.mCurrVelocity = (f1 * this.mSplineDistance / this.mSplineDuration * 1000.0F);
    double d1 = this.mCurrVelocity;
    double d2 = this.mLastVelocity;
    Double.isNaN(d1);
    double d3 = l - this.mLastTime;
    Double.isNaN(d3);
    this.mDeceleration = ((float)((d1 - d2) / d3 * 1000.0D));
    this.mStartTime = l;
  }
  
  private void startSpringback(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mFinished = false;
    this.mState = 1;
    this.mStart = paramInt1;
    this.mFinal = paramInt2;
    this.mOver = (paramInt2 - paramInt1);
    this.mDuration = OverScroller.BOUNCE_DURANTION;
  }
  
  private void startSpringback(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mFinished = false;
    this.mState = 1;
    this.mStart = paramInt1;
    this.mFinal = paramInt2;
    this.mOver = (paramInt2 - paramInt1);
    this.mDuration = paramInt4;
  }
  
  void bounce(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f2 = paramInt2 * 0.09606F / (paramInt4 * 1.E-005F);
    float f1;
    if (paramInt3 > 0) {
      f1 = 10.0F;
    } else {
      f1 = -10.0F;
    }
    if (Math.abs(paramInt3) < f2) {
      f1 = paramInt3 * 10.0F / f2;
    }
    this.mStart = paramInt1;
    this.mFinal = paramInt1;
    this.mVelocity = paramInt3;
    this.mOver = paramInt2;
    this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
    this.mDuration = paramInt4;
    this.mTension = f1;
    this.mCurrentPosition = this.mStart;
    this.mState = 3;
  }
  
  boolean continueWhenFinished()
  {
    int i = this.mState;
    if (i != 0)
    {
      if ((i == 1) || (i == 3)) {
        return false;
      }
    }
    else
    {
      if (this.mDuration >= this.mSplineDuration) {
        break label46;
      }
      onEdgeReached();
    }
    update();
    return true;
    label46:
    return false;
  }
  
  boolean continueWhenFinishedForNoBack()
  {
    int i = this.mState;
    if ((i != 0) && (i != 1) && (i != 3))
    {
      update();
      return true;
    }
    return false;
  }
  
  void extendDuration(int paramInt)
  {
    this.mDuration = ((int)(AnimationUtils.currentAnimationTimeMillis() - this.mStartTime) + paramInt);
    this.mFinished = false;
  }
  
  void finish()
  {
    this.mCurrentPosition = this.mFinal;
    this.mFinished = true;
  }
  
  void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.mSplineDuration = 0;
    this.mDuration = 0;
    this.mOver = paramInt5;
    this.mFinished = false;
    this.mVelocity = paramInt2;
    float f = paramInt2;
    this.mCurrVelocity = f;
    this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
    this.mStart = paramInt1;
    this.mCurrentPosition = paramInt1;
    if ((paramInt1 <= paramInt4) && (paramInt1 >= paramInt3))
    {
      this.mState = 0;
      double d1 = 0.0D;
      if (paramInt2 != 0)
      {
        if (this.mFlingMode == 1)
        {
          paramInt5 = getSplineFlingDuration(paramInt2) * 3 / 2;
          this.mSplineDuration = paramInt5;
          this.mDuration = paramInt5;
        }
        else
        {
          paramInt5 = getSplineFlingDuration(paramInt2);
          this.mSplineDuration = paramInt5;
          this.mDuration = paramInt5;
        }
        this.mDeceleration = ((float)(getSplineDeceleration(paramInt2) * 1000.0D));
        d1 = getSplineFlingDistance(paramInt2);
      }
      double d2 = Math.signum(f);
      Double.isNaN(d2);
      this.mSplineDistance = ((int)(d1 * d2));
      this.mFinal = (paramInt1 + this.mSplineDistance);
      paramInt1 = this.mFinal;
      if (paramInt1 < paramInt3)
      {
        adjustDuration(this.mStart, paramInt1, paramInt3);
        this.mFinal = paramInt3;
      }
      paramInt1 = this.mFinal;
      if (paramInt1 > paramInt4)
      {
        adjustDuration(this.mStart, paramInt1, paramInt4);
        this.mFinal = paramInt4;
      }
      this.mLastVelocity = paramInt2;
      this.mLastTime = this.mStartTime;
      return;
    }
    if (paramInt1 > paramInt4) {
      paramInt3 = paramInt4;
    }
    startSpringback(paramInt1, paramInt3, paramInt2);
  }
  
  void notifyEdgeReached(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = this.mState;
    if (i == 0)
    {
      if (paramInt1 == paramInt2)
      {
        bounce(paramInt2, paramInt3, this.mVelocity, OverScroller.BOUNCE_DURANTION);
        return;
      }
      adjustDuration(this.mStart, this.mFinal, this.mCurrentPosition - (paramInt1 - paramInt2));
      this.mOver = paramInt3;
      this.mFinal = paramInt2;
      onEdgeReached();
      return;
    }
    if (i == 4)
    {
      this.mCurrentPosition = 0;
      this.mFinal = 0;
      this.mFinished = true;
    }
  }
  
  void setFinalPosition(int paramInt)
  {
    this.mFinal = paramInt;
    this.mFinished = false;
  }
  
  void setFlingMode(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      return;
    }
    this.mFlingMode = paramInt;
  }
  
  void setFriction(float paramFloat)
  {
    this.mFlingFriction = paramFloat;
  }
  
  boolean springback(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mFinished = true;
    this.mFinal = paramInt1;
    this.mStart = paramInt1;
    this.mVelocity = 0;
    this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
    this.mDuration = 0;
    if (paramInt1 < paramInt2) {
      startSpringback(paramInt1, paramInt2, 0);
    } else if (paramInt1 > paramInt3) {
      startSpringback(paramInt1, paramInt3, 0);
    }
    return this.mFinished ^ true;
  }
  
  boolean springback(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mFinished = true;
    this.mFinal = paramInt1;
    this.mStart = paramInt1;
    this.mVelocity = 0;
    this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
    this.mDuration = 0;
    if (paramInt1 < paramInt2) {
      startSpringback(paramInt1, paramInt2, 0, paramInt4);
    } else if (paramInt1 > paramInt3) {
      startSpringback(paramInt1, paramInt3, 0, paramInt4);
    }
    return this.mFinished ^ true;
  }
  
  void startScroll(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mFinished = false;
    this.mStart = paramInt1;
    this.mFinal = (paramInt1 + paramInt2);
    this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
    this.mDuration = paramInt3;
    this.mDeceleration = 0.0F;
    this.mVelocity = 0;
    this.mState = 4;
  }
  
  boolean update()
  {
    long l1 = AnimationUtils.currentAnimationTimeMillis();
    long l2 = l1 - this.mStartTime;
    int i = this.mDuration;
    if (l2 > i) {
      return false;
    }
    double d1 = 0.0D;
    int j = this.mState;
    float f2 = 1.0F;
    float f1;
    float f3;
    if (j != 0)
    {
      if (j != 1)
      {
        if (j == 3)
        {
          f1 = (float)l2 / i - 1.0F;
          f2 = this.mOver;
          f3 = this.mTension;
          d1 = f2 * f1 * f1 * f1 * f1 * (f1 * f3 + f3);
        }
      }
      else {
        d1 = AnimateUtils.a((float)l2 / i) * this.mOver;
      }
    }
    else
    {
      f3 = (float)l2 / this.mSplineDuration;
      i = (int)(f3 * 100.0F);
      if (i < 100)
      {
        f2 = i / 100.0F;
        j = i + 1;
        f1 = j / 100.0F;
        float[] arrayOfFloat = SPLINE_POSITION;
        float f4 = arrayOfFloat[i];
        f1 = (arrayOfFloat[j] - f4) / (f1 - f2);
        f2 = f4 + (f3 - f2) * f1;
      }
      else
      {
        f1 = 0.0F;
      }
      i = this.mSplineDistance;
      d1 = f2 * i;
      this.mCurrVelocity = (f1 * i / this.mSplineDuration * 1000.0F);
      double d2 = this.mCurrVelocity;
      double d3 = this.mLastVelocity;
      Double.isNaN(d2);
      double d4 = l1 - this.mLastTime;
      Double.isNaN(d4);
      this.mDeceleration = ((float)((d2 - d3) / d4 * 1000.0D));
    }
    this.mCurrentPosition = (this.mStart + (int)Math.round(d1));
    return true;
  }
  
  void updateScroll(float paramFloat)
  {
    int i = this.mStart;
    this.mCurrentPosition = (i + Math.round(paramFloat * (this.mFinal - i)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.OverScroller.SplineOverScroller
 * JD-Core Version:    0.7.0.1
 */