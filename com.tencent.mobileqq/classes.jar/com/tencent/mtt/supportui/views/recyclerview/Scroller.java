package com.tencent.mtt.supportui.views.recyclerview;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class Scroller
{
  public static float ALPHA = 0.0F;
  private static float DECELERATION_RATE = 0.0F;
  private static final int DEFAULT_DURATION = 250;
  private static float END_TENSION = 0.0F;
  private static final int FLING_MODE = 1;
  public static final int ILLEGAL_DURING = 2147483647;
  private static final int NB_SAMPLES = 100;
  private static final int SCROLL_MODE = 0;
  private static final float[] SPLINE;
  private static float START_TENSION;
  public static boolean mUseIphoneAlgorithm = true;
  private static float sViscousFluidNormalize = 1.0F / viscousFluid(1.0F);
  private static float sViscousFluidScale;
  private float mCurrVelocity;
  private int mCurrX;
  private int mCurrY;
  private float mDeceleration;
  private float mDeltaX;
  private float mDeltaY;
  private float mDistance;
  private int mDuration;
  private float mDurationReciprocal;
  private int mFinalX;
  private int mFinalY;
  private boolean mFinished = true;
  private boolean mFlywheel;
  public Interpolator mInterpolator;
  private boolean mIsUpOrLeft = false;
  private long mLastComputeTime = -1L;
  private int mMaxX;
  private int mMaxY;
  private int mMinX;
  private int mMinY;
  private int mMode;
  private final float mPpi;
  private ScrollInterpolator mScrollInterpolator = new ScrollInterpolator();
  private long mStartTime;
  private int mStartX;
  private int mStartY;
  private float mVelocity;
  
  static
  {
    DECELERATION_RATE = (float)(Math.log(0.75D) / Math.log(0.9D));
    ALPHA = 200.0F;
    START_TENSION = 0.175F;
    END_TENSION = 0.35F;
    SPLINE = new float[101];
    float f1 = 0.0F;
    int i = 0;
    if (i <= 100)
    {
      float f4 = i / 100.0F;
      float f2 = 1.0F;
      for (;;)
      {
        float f3 = (f2 - f1) / 2.0F + f1;
        float f5 = 3.0F * f3 * (1.0F - f3);
        float f6 = ((1.0F - f3) * START_TENSION + END_TENSION * f3) * f5 + f3 * f3 * f3;
        if (Math.abs(f6 - f4) < 1.E-005D)
        {
          SPLINE[i] = (f3 * f3 * f3 + f5);
          i += 1;
          break;
        }
        if (f6 > f4) {
          f2 = f3;
        } else {
          f1 = f3;
        }
      }
    }
    SPLINE[100] = 1.0F;
    sViscousFluidScale = 8.0F;
    sViscousFluidNormalize = 1.0F;
  }
  
  public Scroller(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public Scroller(Context paramContext, Interpolator paramInterpolator)
  {
    this(paramContext, paramInterpolator, true);
  }
  
  public Scroller(Context paramContext, Interpolator paramInterpolator, boolean paramBoolean)
  {
    this.mInterpolator = paramInterpolator;
    this.mPpi = (paramContext.getResources().getDisplayMetrics().density * 160.0F);
    this.mDeceleration = computeDeceleration(ViewConfiguration.getScrollFriction());
    this.mFlywheel = paramBoolean;
  }
  
  private float computeDeceleration(float paramFloat)
  {
    return 386.0878F * this.mPpi * paramFloat;
  }
  
  public static float viscousFluid(float paramFloat)
  {
    paramFloat = sViscousFluidScale * paramFloat;
    if (paramFloat < 1.0F) {}
    for (paramFloat -= 1.0F - (float)Math.exp(-paramFloat);; paramFloat = (1.0F - (float)Math.exp(1.0F - paramFloat)) * (1.0F - 0.3678795F) + 0.3678795F) {
      return paramFloat * sViscousFluidNormalize;
    }
  }
  
  public void abortAnimation()
  {
    this.mCurrX = this.mFinalX;
    this.mCurrY = this.mFinalY;
    this.mFinished = true;
  }
  
  public void clearVelocity()
  {
    this.mVelocity = 0.0F;
    this.mCurrVelocity = 0.0F;
  }
  
  public boolean computeScrollOffset()
  {
    if (this.mFinished) {
      return false;
    }
    int i = (int)(AnimationUtils.currentAnimationTimeMillis() - this.mStartTime);
    if (this.mDuration == 2147483647) {
      switch (this.mMode)
      {
      }
    }
    for (;;)
    {
      return true;
      if (Math.abs(System.currentTimeMillis() - this.mLastComputeTime) > 2L)
      {
        this.mLastComputeTime = System.currentTimeMillis();
        int j;
        if (this.mIsUpOrLeft)
        {
          i = this.mFinalX - this.mStartX;
          j = this.mFinalY - this.mStartY;
          this.mCurrX -= this.mScrollInterpolator.getStep(this.mCurrX, i, this.mFinalX);
          this.mCurrY -= this.mScrollInterpolator.getStep(this.mCurrY, j, this.mFinalY);
          if (((i == 0) && (j == 0)) || ((j != 0) && (this.mCurrY <= this.mFinalY)) || ((i != 0) && (this.mCurrX <= this.mFinalX)))
          {
            this.mCurrX = this.mFinalX;
            this.mCurrY = this.mFinalY;
            this.mFinished = true;
            if (AnimationUtils.currentAnimationTimeMillis() - this.mStartTime > 700L) {
              mUseIphoneAlgorithm = false;
            }
          }
        }
        else
        {
          i = this.mFinalX - this.mStartX;
          j = this.mFinalY - this.mStartY;
          this.mCurrX += this.mScrollInterpolator.getStep(this.mCurrX, i, this.mFinalX);
          this.mCurrY += this.mScrollInterpolator.getStep(this.mCurrY, j, this.mFinalY);
          if (((i == 0) && (j == 0)) || ((j != 0) && (this.mCurrY >= this.mFinalY)) || ((i != 0) && (this.mCurrX >= this.mFinalX)))
          {
            this.mCurrX = this.mFinalX;
            this.mCurrY = this.mFinalY;
            this.mFinished = true;
            if (AnimationUtils.currentAnimationTimeMillis() - this.mStartTime > 700L)
            {
              mUseIphoneAlgorithm = false;
              continue;
              if (i < this.mDuration)
              {
                float f1;
                switch (this.mMode)
                {
                default: 
                  break;
                case 0: 
                  f1 = i * this.mDurationReciprocal;
                  if (this.mInterpolator == null) {}
                  for (f1 = viscousFluid(f1);; f1 = this.mInterpolator.getInterpolation(f1))
                  {
                    this.mCurrX = (this.mStartX + Math.round(this.mDeltaX * f1));
                    i = this.mStartY;
                    this.mCurrY = (Math.round(f1 * this.mDeltaY) + i);
                    break;
                  }
                case 1: 
                  float f5 = i / this.mDuration;
                  i = (int)(100.0F * f5);
                  f1 = i / 100.0F;
                  float f2 = (i + 1) / 100.0F;
                  float f3 = SPLINE[i];
                  float f4 = SPLINE[(i + 1)];
                  f5 = (f5 - f1) / (f2 - f1) * (f4 - f3) + f3;
                  this.mCurrVelocity = ((f4 - f3) / (f2 - f1) * this.mDistance / this.mDuration * 1000.0F);
                  this.mCurrX = (this.mStartX + Math.round((this.mFinalX - this.mStartX) * f5));
                  this.mCurrX = Math.min(this.mCurrX, this.mMaxX);
                  this.mCurrX = Math.max(this.mCurrX, this.mMinX);
                  i = this.mStartY;
                  this.mCurrY = (Math.round(f5 * (this.mFinalY - this.mStartY)) + i);
                  this.mCurrY = Math.min(this.mCurrY, this.mMaxY);
                  this.mCurrY = Math.max(this.mCurrY, this.mMinY);
                  if ((this.mCurrX != this.mFinalX) || (this.mCurrY != this.mFinalY)) {
                    continue;
                  }
                  this.mFinished = true;
                  break;
                }
              }
              else
              {
                this.mCurrX = this.mFinalX;
                this.mCurrY = this.mFinalY;
                this.mFinished = true;
              }
            }
          }
        }
      }
    }
  }
  
  public void extendDuration(int paramInt)
  {
    this.mDuration = (timePassed() + paramInt);
    this.mDurationReciprocal = (1.0F / this.mDuration);
    this.mFinished = false;
  }
  
  public void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    int j = paramInt3;
    int i = paramInt4;
    float f1;
    float f4;
    if (this.mFlywheel)
    {
      j = paramInt3;
      i = paramInt4;
      if (!this.mFinished)
      {
        f1 = getCurrVelocity();
        f4 = this.mFinalX - this.mStartX;
        f2 = this.mFinalY - this.mStartY;
        f3 = (float)Math.sqrt(f4 * f4 + f2 * f2);
        f4 /= f3;
        f2 /= f3;
        f3 = f4 * f1;
        f1 *= f2;
        j = paramInt3;
        i = paramInt4;
        if (Math.signum(paramInt3) == Math.signum(f3))
        {
          j = paramInt3;
          i = paramInt4;
          if (Math.signum(paramInt4) == Math.signum(f1))
          {
            j = (int)(f3 + paramInt3);
            i = (int)(f1 + paramInt4);
          }
        }
      }
    }
    this.mMode = 1;
    this.mFinished = false;
    float f3 = (float)Math.sqrt(j * j + i * i);
    this.mVelocity = f3;
    double d1 = Math.log(START_TENSION * f3 / ALPHA);
    this.mDuration = ((int)(1000.0D * Math.exp(d1 / (DECELERATION_RATE - 1.0D))));
    this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
    this.mStartX = paramInt1;
    this.mStartY = paramInt2;
    if (f3 == 0.0F)
    {
      f1 = 1.0F;
      if (f3 != 0.0F) {
        break label445;
      }
    }
    label445:
    for (float f2 = 1.0F;; f2 = i / f3)
    {
      double d2 = ALPHA;
      paramInt3 = (int)(Math.exp(d1 * (DECELERATION_RATE / (DECELERATION_RATE - 1.0D))) * d2);
      f4 = paramInt3;
      this.mDistance = ((int)(Math.signum(f3) * f4));
      this.mMinX = paramInt5;
      this.mMaxX = paramInt6;
      this.mMinY = paramInt7;
      this.mMaxY = paramInt8;
      this.mFinalX = (Math.round(f1 * paramInt3) + paramInt1);
      this.mFinalX = Math.min(this.mFinalX, this.mMaxX);
      this.mFinalX = Math.max(this.mFinalX, this.mMinX);
      this.mFinalY = (Math.round(f2 * paramInt3) + paramInt2);
      this.mFinalY = Math.min(this.mFinalY, this.mMaxY);
      this.mFinalY = Math.max(this.mFinalY, this.mMinY);
      return;
      f1 = j / f3;
      break;
    }
  }
  
  public final void forceFinished(boolean paramBoolean)
  {
    this.mFinished = paramBoolean;
  }
  
  public float getCurrVelocity()
  {
    if (this.mMode == 1) {
      return this.mCurrVelocity;
    }
    return this.mVelocity - this.mDeceleration * timePassed() / 2000.0F;
  }
  
  public final int getCurrX()
  {
    return this.mCurrX;
  }
  
  public final int getCurrY()
  {
    return this.mCurrY;
  }
  
  public final int getDuration()
  {
    return this.mDuration;
  }
  
  public final int getFinalX()
  {
    return this.mFinalX;
  }
  
  public final int getFinalY()
  {
    return this.mFinalY;
  }
  
  public final int getStartX()
  {
    return this.mStartX;
  }
  
  public final int getStartY()
  {
    return this.mStartY;
  }
  
  public final boolean isFinished()
  {
    return this.mFinished;
  }
  
  public boolean isFling()
  {
    return this.mMode == 1;
  }
  
  public boolean isScrollingInDirection(float paramFloat1, float paramFloat2)
  {
    return (!this.mFinished) && (Math.signum(paramFloat1) == Math.signum(this.mFinalX - this.mStartX)) && (Math.signum(paramFloat2) == Math.signum(this.mFinalY - this.mStartY));
  }
  
  public void setFinalX(int paramInt)
  {
    this.mFinalX = paramInt;
    this.mDeltaX = (this.mFinalX - this.mStartX);
    this.mFinished = false;
  }
  
  public void setFinalY(int paramInt)
  {
    this.mFinalY = paramInt;
    this.mDeltaY = (this.mFinalY - this.mStartY);
    this.mFinished = false;
  }
  
  public final void setFriction(float paramFloat)
  {
    this.mDeceleration = computeDeceleration(paramFloat);
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    startScroll(paramInt1, paramInt2, paramInt3, paramInt4, 250);
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    this.mMode = 0;
    this.mFinished = false;
    this.mDuration = paramInt5;
    this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
    this.mStartX = paramInt1;
    this.mStartY = paramInt2;
    this.mFinalX = (paramInt1 + paramInt3);
    this.mFinalY = (paramInt2 + paramInt4);
    this.mDeltaX = paramInt3;
    this.mDeltaY = paramInt4;
    this.mCurrX = this.mStartX;
    this.mCurrY = this.mStartY;
    if (this.mStartX == this.mFinalX) {
      if (this.mFinalY < this.mStartY)
      {
        this.mIsUpOrLeft = bool1;
        this.mScrollInterpolator.initVelocity(this.mFinalY - this.mStartY);
      }
    }
    while (this.mStartY != this.mFinalY) {
      for (;;)
      {
        this.mDurationReciprocal = (1.0F / this.mDuration);
        return;
        bool1 = false;
      }
    }
    if (this.mFinalX < this.mStartX) {}
    for (bool1 = bool2;; bool1 = false)
    {
      this.mIsUpOrLeft = bool1;
      this.mScrollInterpolator.initVelocity(this.mFinalX - this.mStartX);
      break;
    }
  }
  
  public int timePassed()
  {
    return (int)(AnimationUtils.currentAnimationTimeMillis() - this.mStartTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.Scroller
 * JD-Core Version:    0.7.0.1
 */