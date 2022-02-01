package com.tencent.widget;

import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.tencent.util.AnimateUtils;

public class OverScroller
{
  public static int BOUNCE_DURANTION = 400;
  private static final int DEFAULT_DURATION = 250;
  private static final int FLING_MODE = 1;
  public static final int FLING_MODE_NORMAL = 0;
  public static final int FLING_MODE_SLOW = 1;
  private static final int SCROLL_MODE = 0;
  private static final int SCROLL_MODE_NO_BACK = 2;
  private final boolean mFlywheel;
  private Interpolator mInterpolator;
  private int mMode;
  private final OverScroller.SplineOverScroller mScrollerX;
  private final OverScroller.SplineOverScroller mScrollerY;
  
  public OverScroller(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public OverScroller(Context paramContext, Interpolator paramInterpolator)
  {
    this(paramContext, paramInterpolator, true);
  }
  
  public OverScroller(Context paramContext, Interpolator paramInterpolator, float paramFloat1, float paramFloat2)
  {
    this(paramContext, paramInterpolator, true);
  }
  
  public OverScroller(Context paramContext, Interpolator paramInterpolator, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    this(paramContext, paramInterpolator, paramBoolean);
  }
  
  public OverScroller(Context paramContext, Interpolator paramInterpolator, boolean paramBoolean)
  {
    this.mInterpolator = paramInterpolator;
    this.mFlywheel = paramBoolean;
    this.mScrollerX = new OverScroller.SplineOverScroller();
    this.mScrollerY = new OverScroller.SplineOverScroller();
    OverScroller.SplineOverScroller.initFromContext(paramContext);
  }
  
  public void abortAnimation()
  {
    this.mScrollerX.finish();
    this.mScrollerY.finish();
  }
  
  public boolean computeScrollOffset()
  {
    if (isFinished()) {
      return false;
    }
    switch (this.mMode)
    {
    }
    for (;;)
    {
      return true;
      long l = AnimationUtils.currentAnimationTimeMillis() - OverScroller.SplineOverScroller.access$600(this.mScrollerX);
      int i = OverScroller.SplineOverScroller.access$500(this.mScrollerX);
      if (l < i)
      {
        float f = (float)l / i;
        if (this.mInterpolator == null) {}
        for (f = AnimateUtils.a(f);; f = this.mInterpolator.getInterpolation(f))
        {
          if (!OverScroller.SplineOverScroller.access$000(this.mScrollerX)) {
            this.mScrollerX.updateScroll(f);
          }
          if (OverScroller.SplineOverScroller.access$000(this.mScrollerY)) {
            break;
          }
          this.mScrollerY.updateScroll(f);
          break;
        }
      }
      abortAnimation();
      continue;
      if ((!OverScroller.SplineOverScroller.access$000(this.mScrollerX)) && (!this.mScrollerX.update()) && (!this.mScrollerX.continueWhenFinishedForNoBack())) {
        this.mScrollerX.finish();
      }
      if ((!OverScroller.SplineOverScroller.access$000(this.mScrollerY)) && (!this.mScrollerY.update()) && (!this.mScrollerY.continueWhenFinishedForNoBack()))
      {
        this.mScrollerY.finish();
        continue;
        if ((!OverScroller.SplineOverScroller.access$000(this.mScrollerX)) && (!this.mScrollerX.update()) && (!this.mScrollerX.continueWhenFinished())) {
          this.mScrollerX.finish();
        }
        if ((!OverScroller.SplineOverScroller.access$000(this.mScrollerY)) && (!this.mScrollerY.update()) && (!this.mScrollerY.continueWhenFinished())) {
          this.mScrollerY.finish();
        }
      }
    }
  }
  
  @Deprecated
  public void extendDuration(int paramInt)
  {
    this.mScrollerX.extendDuration(paramInt);
    this.mScrollerY.extendDuration(paramInt);
  }
  
  public void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    fling(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, 0, 0);
  }
  
  public void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    fling(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, 1);
  }
  
  public void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11)
  {
    if ((this.mFlywheel) && (!isFinished()))
    {
      float f1 = OverScroller.SplineOverScroller.access$200(this.mScrollerX);
      float f2 = OverScroller.SplineOverScroller.access$200(this.mScrollerY);
      if ((Math.signum(paramInt3) == Math.signum(f1)) && (Math.signum(paramInt4) == Math.signum(f2)))
      {
        paramInt3 = (int)(f1 + paramInt3);
        paramInt4 = (int)(paramInt4 + f2);
      }
    }
    for (;;)
    {
      this.mMode = paramInt11;
      this.mScrollerX.fling(paramInt1, paramInt3, paramInt5, paramInt6, paramInt9);
      this.mScrollerY.fling(paramInt2, paramInt4, paramInt7, paramInt8, paramInt10);
      return;
    }
  }
  
  public void fling(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    fling(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10);
    OverScroller.SplineOverScroller.access$602(this.mScrollerX, paramLong);
    OverScroller.SplineOverScroller.access$602(this.mScrollerY, paramLong);
  }
  
  public final void forceFinished(boolean paramBoolean)
  {
    OverScroller.SplineOverScroller.access$002(this.mScrollerX, OverScroller.SplineOverScroller.access$002(this.mScrollerY, paramBoolean));
  }
  
  public float getCurrVelocity()
  {
    return (float)Math.sqrt(OverScroller.SplineOverScroller.access$200(this.mScrollerX) * OverScroller.SplineOverScroller.access$200(this.mScrollerX) + OverScroller.SplineOverScroller.access$200(this.mScrollerY) * OverScroller.SplineOverScroller.access$200(this.mScrollerY));
  }
  
  public float getCurrVelocityY()
  {
    return OverScroller.SplineOverScroller.access$200(this.mScrollerY);
  }
  
  public final int getCurrX()
  {
    return OverScroller.SplineOverScroller.access$100(this.mScrollerX);
  }
  
  public final int getCurrY()
  {
    return OverScroller.SplineOverScroller.access$100(this.mScrollerY);
  }
  
  @Deprecated
  public final int getDuration()
  {
    return Math.max(OverScroller.SplineOverScroller.access$500(this.mScrollerX), OverScroller.SplineOverScroller.access$500(this.mScrollerY));
  }
  
  public final int getFinalX()
  {
    return OverScroller.SplineOverScroller.access$400(this.mScrollerX);
  }
  
  public final int getFinalY()
  {
    return OverScroller.SplineOverScroller.access$400(this.mScrollerY);
  }
  
  public Interpolator getInterpolator()
  {
    return this.mInterpolator;
  }
  
  public final int getStartX()
  {
    return OverScroller.SplineOverScroller.access$300(this.mScrollerX);
  }
  
  public final int getStartY()
  {
    return OverScroller.SplineOverScroller.access$300(this.mScrollerY);
  }
  
  public final boolean isFinished()
  {
    return (OverScroller.SplineOverScroller.access$000(this.mScrollerX)) && (OverScroller.SplineOverScroller.access$000(this.mScrollerY));
  }
  
  public boolean isOverScrolled()
  {
    return ((!OverScroller.SplineOverScroller.access$000(this.mScrollerX)) && (OverScroller.SplineOverScroller.access$700(this.mScrollerX) != 0)) || ((!OverScroller.SplineOverScroller.access$000(this.mScrollerY)) && (OverScroller.SplineOverScroller.access$700(this.mScrollerY) != 0));
  }
  
  public boolean isScrollingInDirection(float paramFloat1, float paramFloat2)
  {
    int i = OverScroller.SplineOverScroller.access$400(this.mScrollerX);
    int j = OverScroller.SplineOverScroller.access$300(this.mScrollerX);
    int k = OverScroller.SplineOverScroller.access$400(this.mScrollerY);
    int m = OverScroller.SplineOverScroller.access$300(this.mScrollerY);
    return (!isFinished()) && (Math.signum(paramFloat1) == Math.signum(i - j)) && (Math.signum(paramFloat2) == Math.signum(k - m));
  }
  
  public void notifyHorizontalEdgeReached(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mScrollerX.notifyEdgeReached(paramInt1, paramInt2, paramInt3);
  }
  
  public void notifyVerticalEdgeReached(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mScrollerY.notifyEdgeReached(paramInt1, paramInt2, paramInt3);
  }
  
  @Deprecated
  public void setFinalX(int paramInt)
  {
    this.mScrollerX.setFinalPosition(paramInt);
  }
  
  @Deprecated
  public void setFinalY(int paramInt)
  {
    this.mScrollerY.setFinalPosition(paramInt);
  }
  
  public void setFlingMode(int paramInt)
  {
    this.mScrollerY.setFlingMode(paramInt);
  }
  
  public final void setFriction(float paramFloat)
  {
    this.mScrollerX.setFriction(paramFloat);
    this.mScrollerY.setFriction(paramFloat);
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.mInterpolator = paramInterpolator;
  }
  
  public boolean springBack(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.mMode = 1;
    boolean bool1 = this.mScrollerX.springback(paramInt1, paramInt3, paramInt4);
    boolean bool2 = this.mScrollerY.springback(paramInt2, paramInt5, paramInt6);
    return (bool1) || (bool2);
  }
  
  public boolean springBack(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    this.mMode = 1;
    boolean bool1 = this.mScrollerX.springback(paramInt1, paramInt3, paramInt4, paramInt7);
    boolean bool2 = this.mScrollerY.springback(paramInt2, paramInt5, paramInt6, paramInt7);
    return (bool1) || (bool2);
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    startScroll(paramInt1, paramInt2, paramInt3, paramInt4, 250);
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.mMode = 0;
    this.mScrollerX.startScroll(paramInt1, paramInt3, paramInt5);
    this.mScrollerY.startScroll(paramInt2, paramInt4, paramInt5);
  }
  
  public int timePassed()
  {
    return (int)(AnimationUtils.currentAnimationTimeMillis() - Math.min(OverScroller.SplineOverScroller.access$600(this.mScrollerX), OverScroller.SplineOverScroller.access$600(this.mScrollerY)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.widget.OverScroller
 * JD-Core Version:    0.7.0.1
 */