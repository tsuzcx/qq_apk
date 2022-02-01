package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

public class EdgeEffect
{
  private static final float EPSILON = 0.001F;
  private static final float HELD_EDGE_ALPHA = 0.7F;
  private static final float HELD_EDGE_SCALE_Y = 0.5F;
  private static final float HELD_GLOW_ALPHA = 0.5F;
  private static final float HELD_GLOW_SCALE_Y = 0.5F;
  private static final float MAX_ALPHA = 0.8F;
  private static final float MAX_GLOW_HEIGHT = 4.0F;
  private static final int MIN_VELOCITY = 100;
  private static final int MIN_WIDTH = 300;
  private static final int PULL_DECAY_TIME = 1000;
  private static final float PULL_DISTANCE_ALPHA_GLOW_FACTOR = 1.1F;
  private static final int PULL_DISTANCE_EDGE_FACTOR = 7;
  private static final int PULL_DISTANCE_GLOW_FACTOR = 7;
  private static final float PULL_EDGE_BEGIN = 0.6F;
  private static final float PULL_GLOW_BEGIN = 1.0F;
  private static final int PULL_TIME = 167;
  private static final int RECEDE_TIME = 1000;
  private static final int STATE_ABSORB = 2;
  private static final int STATE_IDLE = 0;
  private static final int STATE_PULL = 1;
  private static final int STATE_PULL_DECAY = 4;
  private static final int STATE_RECEDE = 3;
  private static final String TAG = "EdgeEffect";
  private static final int VELOCITY_EDGE_FACTOR = 8;
  private static final int VELOCITY_GLOW_FACTOR = 16;
  private float mDuration;
  private Drawable mEdge;
  private float mEdgeAlpha;
  private float mEdgeAlphaFinish;
  private float mEdgeAlphaStart;
  private float mEdgeScaleY;
  private float mEdgeScaleYFinish;
  private float mEdgeScaleYStart;
  private Drawable mGlow;
  private float mGlowAlpha;
  private float mGlowAlphaFinish;
  private float mGlowAlphaStart;
  private float mGlowScaleY;
  private float mGlowScaleYFinish;
  private float mGlowScaleYStart;
  private int mHeight;
  private final Interpolator mInterpolator;
  private final int mMinWidth;
  private float mPullDistance;
  private long mStartTime;
  private int mState = 0;
  private int mWidth;
  
  public EdgeEffect(Context paramContext)
  {
    paramContext = paramContext.getResources();
    this.mEdge = paramContext.getDrawable(2130841657);
    this.mGlow = paramContext.getDrawable(2130841658);
    this.mMinWidth = ((int)(paramContext.getDisplayMetrics().density * 300.0F + 0.5F));
    this.mInterpolator = new DecelerateInterpolator();
  }
  
  private void update()
  {
    float f1 = Math.min((float)(AnimationUtils.currentAnimationTimeMillis() - this.mStartTime) / this.mDuration, 1.0F);
    float f2 = this.mInterpolator.getInterpolation(f1);
    this.mEdgeAlpha = (this.mEdgeAlphaStart + (this.mEdgeAlphaFinish - this.mEdgeAlphaStart) * f2);
    this.mEdgeScaleY = (this.mEdgeScaleYStart + (this.mEdgeScaleYFinish - this.mEdgeScaleYStart) * f2);
    this.mGlowAlpha = (this.mGlowAlphaStart + (this.mGlowAlphaFinish - this.mGlowAlphaStart) * f2);
    this.mGlowScaleY = (this.mGlowScaleYStart + (this.mGlowScaleYFinish - this.mGlowScaleYStart) * f2);
    if (f1 >= 0.999F) {}
    switch (this.mState)
    {
    default: 
      return;
    case 2: 
      this.mState = 3;
      this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
      this.mDuration = 1000.0F;
      this.mEdgeAlphaStart = this.mEdgeAlpha;
      this.mEdgeScaleYStart = this.mEdgeScaleY;
      this.mGlowAlphaStart = this.mGlowAlpha;
      this.mGlowScaleYStart = this.mGlowScaleY;
      this.mEdgeAlphaFinish = 0.0F;
      this.mEdgeScaleYFinish = 0.0F;
      this.mGlowAlphaFinish = 0.0F;
      this.mGlowScaleYFinish = 0.0F;
      return;
    case 1: 
      this.mState = 4;
      this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
      this.mDuration = 1000.0F;
      this.mEdgeAlphaStart = this.mEdgeAlpha;
      this.mEdgeScaleYStart = this.mEdgeScaleY;
      this.mGlowAlphaStart = this.mGlowAlpha;
      this.mGlowScaleYStart = this.mGlowScaleY;
      this.mEdgeAlphaFinish = 0.0F;
      this.mEdgeScaleYFinish = 0.0F;
      this.mGlowAlphaFinish = 0.0F;
      this.mGlowScaleYFinish = 0.0F;
      return;
    case 4: 
      if (this.mGlowScaleYFinish != 0.0F) {}
      for (f1 = 1.0F / (this.mGlowScaleYFinish * this.mGlowScaleYFinish);; f1 = 3.4028235E+38F)
      {
        float f3 = this.mEdgeScaleYStart;
        this.mEdgeScaleY = (f1 * (f2 * (this.mEdgeScaleYFinish - this.mEdgeScaleYStart)) + f3);
        this.mState = 3;
        return;
      }
    }
    this.mState = 0;
  }
  
  public boolean draw(Canvas paramCanvas)
  {
    boolean bool = false;
    update();
    int i = this.mEdge.getIntrinsicHeight();
    this.mEdge.getIntrinsicWidth();
    int j = this.mGlow.getIntrinsicHeight();
    int k = this.mGlow.getIntrinsicWidth();
    this.mGlow.setAlpha((int)(Math.max(0.0F, Math.min(this.mGlowAlpha, 1.0F)) * 255.0F));
    j = (int)Math.min(j * this.mGlowScaleY * j / k * 0.6F, j * 4.0F);
    if (this.mWidth < this.mMinWidth)
    {
      k = (this.mWidth - this.mMinWidth) / 2;
      this.mGlow.setBounds(k, 0, this.mWidth - k, j);
      this.mGlow.draw(paramCanvas);
      this.mEdge.setAlpha((int)(Math.max(0.0F, Math.min(this.mEdgeAlpha, 1.0F)) * 255.0F));
      i = (int)(i * this.mEdgeScaleY);
      if (this.mWidth >= this.mMinWidth) {
        break label249;
      }
      j = (this.mWidth - this.mMinWidth) / 2;
      this.mEdge.setBounds(j, 0, this.mWidth - j, i);
    }
    for (;;)
    {
      this.mEdge.draw(paramCanvas);
      if (this.mState != 0) {
        bool = true;
      }
      return bool;
      this.mGlow.setBounds(0, 0, this.mWidth, j);
      break;
      label249:
      this.mEdge.setBounds(0, 0, this.mWidth, i);
    }
  }
  
  public void finish()
  {
    this.mState = 0;
  }
  
  public boolean isFinished()
  {
    return this.mState == 0;
  }
  
  public void onAbsorb(int paramInt)
  {
    this.mState = 2;
    paramInt = Math.max(100, Math.abs(paramInt));
    this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
    this.mDuration = (0.1F + paramInt * 0.03F);
    this.mEdgeAlphaStart = 0.0F;
    this.mEdgeScaleYStart = 0.0F;
    this.mEdgeScaleY = 0.0F;
    this.mGlowAlphaStart = 0.5F;
    this.mGlowScaleYStart = 0.0F;
    this.mEdgeAlphaFinish = Math.max(0, Math.min(paramInt * 8, 1));
    this.mEdgeScaleYFinish = Math.max(0.5F, Math.min(paramInt * 8, 1.0F));
    this.mGlowScaleYFinish = Math.min(0.025F + paramInt / 100 * paramInt * 0.00015F, 1.75F);
    this.mGlowAlphaFinish = Math.max(this.mGlowAlphaStart, Math.min(paramInt * 16 * 1.0E-005F, 0.8F));
  }
  
  public void onPull(float paramFloat)
  {
    long l = AnimationUtils.currentAnimationTimeMillis();
    if ((this.mState == 4) && ((float)(l - this.mStartTime) < this.mDuration)) {
      return;
    }
    if (this.mState != 1) {
      this.mGlowScaleY = 1.0F;
    }
    this.mState = 1;
    this.mStartTime = l;
    this.mDuration = 167.0F;
    this.mPullDistance += paramFloat;
    float f1 = Math.abs(this.mPullDistance);
    float f2 = Math.max(0.6F, Math.min(f1, 0.8F));
    this.mEdgeAlphaStart = f2;
    this.mEdgeAlpha = f2;
    f1 = Math.max(0.5F, Math.min(f1 * 7.0F, 1.0F));
    this.mEdgeScaleYStart = f1;
    this.mEdgeScaleY = f1;
    f1 = Math.min(0.8F, this.mGlowAlpha + Math.abs(paramFloat) * 1.1F);
    this.mGlowAlphaStart = f1;
    this.mGlowAlpha = f1;
    f2 = Math.abs(paramFloat);
    f1 = f2;
    if (paramFloat > 0.0F)
    {
      f1 = f2;
      if (this.mPullDistance < 0.0F) {
        f1 = -f2;
      }
    }
    if (this.mPullDistance == 0.0F) {
      this.mGlowScaleY = 0.0F;
    }
    paramFloat = Math.min(4.0F, Math.max(0.0F, f1 * 7.0F + this.mGlowScaleY));
    this.mGlowScaleYStart = paramFloat;
    this.mGlowScaleY = paramFloat;
    this.mEdgeAlphaFinish = this.mEdgeAlpha;
    this.mEdgeScaleYFinish = this.mEdgeScaleY;
    this.mGlowAlphaFinish = this.mGlowAlpha;
    this.mGlowScaleYFinish = this.mGlowScaleY;
  }
  
  public void onRelease()
  {
    this.mPullDistance = 0.0F;
    if ((this.mState != 1) && (this.mState != 4)) {
      return;
    }
    this.mState = 3;
    this.mEdgeAlphaStart = this.mEdgeAlpha;
    this.mEdgeScaleYStart = this.mEdgeScaleY;
    this.mGlowAlphaStart = this.mGlowAlpha;
    this.mGlowScaleYStart = this.mGlowScaleY;
    this.mEdgeAlphaFinish = 0.0F;
    this.mEdgeScaleYFinish = 0.0F;
    this.mGlowAlphaFinish = 0.0F;
    this.mGlowScaleYFinish = 0.0F;
    this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
    this.mDuration = 1000.0F;
  }
  
  public void setEdgeDrawable(Drawable paramDrawable)
  {
    this.mEdge = paramDrawable;
    this.mGlow = paramDrawable;
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.widget.EdgeEffect
 * JD-Core Version:    0.7.0.1
 */