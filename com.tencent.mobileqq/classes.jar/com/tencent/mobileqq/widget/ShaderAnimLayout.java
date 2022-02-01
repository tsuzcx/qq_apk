package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Region.Op;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import bfrw;

public class ShaderAnimLayout
  extends RelativeLayout
{
  public static final long ANIM_DURATION = 200L;
  float mAnimFactor = 0.0F;
  private Animation.AnimationListener mAnimListener = new ShaderAnimLayout.2(this);
  private Animation mCalcAnimation = new ShaderAnimLayout.1(this);
  boolean mHide = false;
  private boolean mIsInitial;
  private Path mPath = new Path();
  
  public ShaderAnimLayout(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ShaderAnimLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ShaderAnimLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    if (!this.mIsInitial)
    {
      this.mCalcAnimation.setDuration(200L);
      this.mCalcAnimation.setInterpolator(new LinearInterpolator());
      this.mIsInitial = true;
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    this.mPath.reset();
    this.mPath.addRect(getWidth() * (1.0F - this.mAnimFactor), 0.0F, getWidth(), getBottom(), Path.Direction.CW);
    try
    {
      paramCanvas.clipPath(this.mPath, Region.Op.INTERSECT);
      super.dispatchDraw(paramCanvas);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        bfrw.a(this, 1, null);
      }
    }
  }
  
  public void hide()
  {
    if (getVisibility() == 0)
    {
      this.mHide = true;
      clearAnimation();
      this.mCalcAnimation.setAnimationListener(this.mAnimListener);
      startAnimation(this.mCalcAnimation);
    }
  }
  
  public void hideDirectly()
  {
    clearAnimation();
    this.mCalcAnimation.setAnimationListener(null);
    this.mHide = true;
    setVisibility(8);
    this.mAnimFactor = 0.0F;
  }
  
  public void hideIgnoreVisible()
  {
    this.mHide = true;
    clearAnimation();
    this.mCalcAnimation.setAnimationListener(this.mAnimListener);
    startAnimation(this.mCalcAnimation);
  }
  
  public void hideWithoutAnimation()
  {
    setVisibility(8);
  }
  
  public void show()
  {
    if (getVisibility() != 0)
    {
      this.mHide = false;
      this.mCalcAnimation.setAnimationListener(null);
      clearAnimation();
      setVisibility(0);
      startAnimation(this.mCalcAnimation);
    }
  }
  
  public void showDirectly()
  {
    clearAnimation();
    this.mCalcAnimation.setAnimationListener(null);
    this.mHide = false;
    setVisibility(0);
    this.mAnimFactor = 1.0F;
  }
  
  public void showIgnoreVisible()
  {
    this.mHide = false;
    this.mCalcAnimation.setAnimationListener(null);
    clearAnimation();
    setVisibility(0);
    startAnimation(this.mCalcAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ShaderAnimLayout
 * JD-Core Version:    0.7.0.1
 */