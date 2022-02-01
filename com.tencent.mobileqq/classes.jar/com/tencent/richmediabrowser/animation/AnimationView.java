package com.tencent.richmediabrowser.animation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

public class AnimationView
  extends View
{
  public static final int ANIMATE_HEIGHT = 2;
  public static final int ANIMATE_NONE = 0;
  public static final int ANIMATE_WIDTH = 1;
  private static final int ANIMATION_STATE_DONE = 3;
  private static final int ANIMATION_STATE_RUNNING = 2;
  private static final int ANIMATION_STATE_STARTING = 1;
  AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
  private AnimationLister animationListener;
  private int backState = 3;
  float bottom;
  private int cutValue;
  private Drawable drawable;
  private Rect drawableRect;
  private RectF dst = new RectF();
  private Rect endDstRect;
  private Rect endSrcRect;
  boolean freeMode = false;
  float input;
  private boolean isBackAnimationing;
  boolean isEnter = true;
  private boolean isEnterAnimationing;
  public boolean isImgCenterCropMode;
  boolean isInAnimation = false;
  float left;
  private long mAnimationDuringTime = 350L;
  private long mAnimationStartTime;
  Paint paint = new Paint(6);
  float right;
  private Rect src = new Rect();
  private Rect startDstRect;
  private Rect startSrcRect;
  private int startState = 3;
  long startTime = 0L;
  private int startX;
  private int startY;
  private Rect tempBounds = new Rect();
  float top;
  ViscousFluidInterpolator viscousFluidInterpolator = new ViscousFluidInterpolator();
  
  public AnimationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void createBackAnimation(Canvas paramCanvas)
  {
    int i = this.backState;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        paramCanvas = this.animationListener;
        if (paramCanvas != null) {
          paramCanvas.onExitAnimationEnd();
        }
        this.isBackAnimationing = false;
        this.drawable.setBounds(this.drawableRect);
        return;
      }
      doBackAniRun(paramCanvas);
      return;
    }
    if ((this.startDstRect != null) && (this.endDstRect != null) && (this.drawable != null))
    {
      this.mAnimationStartTime = SystemClock.uptimeMillis();
      this.backState = 2;
      doBackAniRun(paramCanvas);
      return;
    }
    this.backState = 3;
    this.isBackAnimationing = false;
    super.draw(paramCanvas);
    paramCanvas = this.animationListener;
    if (paramCanvas != null) {
      paramCanvas.onExitAnimationEnd();
    }
  }
  
  private void createEnterAnimation(Canvas paramCanvas)
  {
    int i = this.startState;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        this.isEnterAnimationing = false;
        localAnimationLister = this.animationListener;
        if (localAnimationLister != null) {
          localAnimationLister.onEnterAnimationEnd();
        }
        paramCanvas.save();
        this.drawable.setBounds(this.endDstRect);
        this.drawable.draw(paramCanvas);
        paramCanvas.restore();
        this.drawable.setBounds(this.drawableRect);
        return;
      }
      doEnterAniRun(paramCanvas);
      return;
    }
    if ((this.startDstRect != null) && (this.endDstRect != null) && (this.drawable != null))
    {
      this.mAnimationStartTime = SystemClock.uptimeMillis();
      this.startState = 2;
      paramCanvas.save();
      doEnterAniRun(paramCanvas);
      return;
    }
    this.startState = 3;
    this.isEnterAnimationing = false;
    AnimationLister localAnimationLister = this.animationListener;
    if (localAnimationLister != null) {
      localAnimationLister.onEnterAnimationEnd();
    }
    super.draw(paramCanvas);
  }
  
  private void doBackAniRun(Canvas paramCanvas)
  {
    float f1 = (float)(SystemClock.uptimeMillis() - this.mAnimationStartTime) / (float)this.mAnimationDuringTime;
    if (f1 >= 1.0F) {
      this.backState = 3;
    }
    f1 = Math.min(f1, 1.0F);
    f1 = this.viscousFluidInterpolator.getInterpolation(f1);
    Rect localRect1 = this.startDstRect;
    Rect localRect2 = this.endDstRect;
    int[] arrayOfInt = new int[2];
    getLocationInWindow(arrayOfInt);
    localRect2 = new Rect(localRect2.left + arrayOfInt[0], localRect2.top + arrayOfInt[1], localRect2.right + arrayOfInt[0], localRect2.bottom + arrayOfInt[1]);
    int i = localRect2.right - localRect2.left;
    int j = localRect2.bottom - localRect2.top;
    float f2 = localRect1.right - localRect1.left + this.startX;
    float f3 = localRect1.bottom - localRect1.top + this.startY;
    float f4 = i;
    float f5 = f2 / f4;
    float f6 = j;
    float f7 = f3 / f6;
    paramCanvas.save();
    int k = this.cutValue;
    if (k == 1)
    {
      paramCanvas.translate((localRect1.left - arrayOfInt[0] - this.startX - (localRect2.left - arrayOfInt[0]) * f7) * f1, (localRect1.top - arrayOfInt[1] - this.startY - (localRect2.top - arrayOfInt[1]) * f7) * f1);
      f3 = 1.0F - (1.0F - f7) * f1;
      paramCanvas.scale(f3, f3);
      if (this.isImgCenterCropMode)
      {
        f3 = (i - j) / 2.0F;
        paramCanvas.translate(-f3 * f1, 0.0F);
        f2 = localRect2.left - arrayOfInt[0];
        f1 = f3 * f1;
        paramCanvas.clipRect(f2 + f1, localRect2.top - arrayOfInt[1], localRect2.right - arrayOfInt[0] - f1, localRect2.bottom - arrayOfInt[1]);
      }
      else
      {
        paramCanvas.clipRect(localRect2.left - arrayOfInt[0] + this.startX / f3 * f1, localRect2.top - arrayOfInt[1] + this.startY / f3 * f1, localRect2.right - arrayOfInt[0] - (f4 - f2 / f7) * f1, localRect2.bottom - arrayOfInt[1]);
      }
    }
    else if (k == 2)
    {
      paramCanvas.translate((localRect1.left - arrayOfInt[0] - this.startX - (localRect2.left - arrayOfInt[0]) * f5) * f1, (localRect1.top - arrayOfInt[1] - this.startY - (localRect2.top - arrayOfInt[1]) * f5) * f1);
      f2 = 1.0F - (1.0F - f5) * f1;
      paramCanvas.scale(f2, f2);
      if (this.isImgCenterCropMode)
      {
        f4 = (j - i) / 2.0F;
        paramCanvas.translate(0.0F, -f4 * f1);
        f2 = localRect2.left - arrayOfInt[0];
        f3 = localRect2.top - arrayOfInt[1];
        f1 = f4 * f1;
        paramCanvas.clipRect(f2, f3 + f1, localRect2.right - arrayOfInt[0], localRect2.bottom - arrayOfInt[1] - f1);
      }
      else
      {
        paramCanvas.clipRect(localRect2.left - arrayOfInt[0] + this.startX / f2 * f1, localRect2.top - arrayOfInt[1] + this.startY / f2 * f1, localRect2.right - arrayOfInt[0], localRect2.bottom - arrayOfInt[1] - (f6 - f3 / f5) * f1);
      }
    }
    else
    {
      paramCanvas.translate((localRect1.left - arrayOfInt[0] - (localRect2.left - arrayOfInt[0]) * f5) * f1, (localRect1.top - arrayOfInt[1] - (localRect2.top - arrayOfInt[1]) * f7) * f1);
      paramCanvas.scale(1.0F - (1.0F - f5) * f1, 1.0F - (1.0F - f7) * f1);
    }
    this.drawable.setBounds(this.endDstRect);
    this.drawable.draw(paramCanvas);
    paramCanvas.restore();
    invalidate();
  }
  
  private void doEnterAniRun(Canvas paramCanvas)
  {
    float f1 = (float)(SystemClock.uptimeMillis() - this.mAnimationStartTime) / (float)this.mAnimationDuringTime;
    if (f1 >= 1.0F) {
      this.startState = 3;
    }
    f1 = Math.min(f1, 1.0F);
    f1 = 1.0F - this.accelerateDecelerateInterpolator.getInterpolation(f1);
    Rect localRect1 = this.startDstRect;
    Rect localRect2 = this.endDstRect;
    int[] arrayOfInt = new int[2];
    getLocationInWindow(arrayOfInt);
    localRect2 = new Rect(localRect2.left + arrayOfInt[0], localRect2.top + arrayOfInt[1], localRect2.right + arrayOfInt[0], localRect2.bottom + arrayOfInt[1]);
    int i = localRect2.width();
    int j = localRect2.height();
    float f2 = localRect1.width();
    float f3 = localRect1.height();
    float f4 = i;
    float f5 = f2 / f4;
    float f6 = j;
    float f7 = f3 / f6;
    paramCanvas.save();
    int k = this.cutValue;
    if (k == 1)
    {
      paramCanvas.translate((localRect1.left - arrayOfInt[0] - (localRect2.left - arrayOfInt[0]) * f7) * f1, (localRect1.top - arrayOfInt[1] - (localRect2.top - arrayOfInt[1]) * f7) * f1);
      f3 = 1.0F - (1.0F - f7) * f1;
      paramCanvas.scale(f3, f3);
      if (this.isImgCenterCropMode)
      {
        f3 = (i - j) / 2.0F;
        paramCanvas.translate(-f3 * f1, 0.0F);
        f2 = localRect2.left - arrayOfInt[0];
        f1 = f3 * f1;
        paramCanvas.clipRect(f2 + f1, localRect2.top - arrayOfInt[1], localRect2.right - arrayOfInt[0] - f1, localRect2.bottom - arrayOfInt[1]);
      }
      else
      {
        paramCanvas.clipRect(localRect2.left - arrayOfInt[0], localRect2.top - arrayOfInt[1], localRect2.right - arrayOfInt[0] - (f4 - f2 / f7) * f1, localRect2.bottom - arrayOfInt[1]);
      }
    }
    else if (k == 2)
    {
      paramCanvas.translate((localRect1.left - arrayOfInt[0] - (localRect2.left - arrayOfInt[0]) * f5) * f1, (localRect1.top - arrayOfInt[1] - (localRect2.top - arrayOfInt[1]) * f5) * f1);
      f2 = 1.0F - (1.0F - f5) * f1;
      paramCanvas.scale(f2, f2);
      if (this.isImgCenterCropMode)
      {
        f4 = (j - i) / 2.0F;
        paramCanvas.translate(0.0F, -f4 * f1);
        f2 = localRect2.left - arrayOfInt[0];
        f3 = localRect2.top - arrayOfInt[1];
        f1 = f4 * f1;
        paramCanvas.clipRect(f2, f3 + f1, localRect2.right - arrayOfInt[0], localRect2.bottom - arrayOfInt[1] - f1);
      }
      else
      {
        paramCanvas.clipRect(localRect2.left - arrayOfInt[0], localRect2.top - arrayOfInt[1], localRect2.right - arrayOfInt[0], localRect2.bottom - arrayOfInt[1] - (f6 - f3 / f5) * f1);
      }
    }
    else
    {
      paramCanvas.translate((localRect1.left - arrayOfInt[0] - (localRect2.left - arrayOfInt[0]) * f5) * f1, (localRect1.top - arrayOfInt[1] - (localRect2.top - arrayOfInt[1]) * f7) * f1);
      paramCanvas.scale(1.0F - (1.0F - f5) * f1, 1.0F - (1.0F - f7) * f1);
    }
    this.drawable.setBounds(this.endDstRect);
    this.drawable.draw(paramCanvas);
    paramCanvas.restore();
    invalidate();
  }
  
  private void onDrawFreeMode(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    paramCanvas.save();
    if (this.startTime > 0L)
    {
      long l = System.currentTimeMillis() - this.startTime;
      this.input = ((float)l / (float)this.mAnimationDuringTime);
      if (this.isEnter) {
        this.input = this.accelerateDecelerateInterpolator.getInterpolation(this.input);
      } else {
        this.input = this.viscousFluidInterpolator.getInterpolation(this.input);
      }
      float f1 = 1.0F - this.input;
      if (this.isInAnimation) {
        if (l <= this.mAnimationDuringTime)
        {
          this.top = (this.startSrcRect.top * f1 + this.endSrcRect.top * this.input);
          this.bottom = (this.startSrcRect.bottom * f1 + this.endSrcRect.bottom * this.input);
          this.left = (this.startSrcRect.left * f1 + this.endSrcRect.left * this.input);
          this.right = (this.startSrcRect.right * f1 + this.endSrcRect.right * this.input);
          this.src.set((int)this.left, (int)this.top, (int)this.right, (int)this.bottom);
          this.top = (this.startDstRect.top * f1 + this.endDstRect.top * this.input);
          this.bottom = (this.startDstRect.bottom * f1 + this.endDstRect.bottom * this.input);
          this.left = (this.startDstRect.left * f1 + this.endDstRect.left * this.input);
          this.right = (this.startDstRect.right * f1 + this.endDstRect.right * this.input);
          this.dst.set(this.left, this.top, this.right, this.bottom);
        }
        else
        {
          this.isInAnimation = false;
          AnimationLister localAnimationLister = this.animationListener;
          if (localAnimationLister != null) {
            if (this.isEnter) {
              localAnimationLister.onEnterAnimationEnd();
            } else {
              localAnimationLister.onExitAnimationEnd();
            }
          }
        }
      }
      f1 = this.dst.width() / this.src.width();
      float f2 = this.dst.height() / this.src.height();
      paramCanvas.translate(this.dst.left - this.src.left * f1, this.dst.top - this.src.top * f2);
      paramCanvas.scale(f1, f2);
      paramCanvas.clipRect(this.src);
      this.drawable.draw(paramCanvas);
      invalidate();
    }
    paramCanvas.restore();
  }
  
  private void startAnimation()
  {
    this.startTime = System.currentTimeMillis();
    this.isInAnimation = true;
    this.drawableRect = this.drawable.copyBounds();
    this.tempBounds = new Rect(0, 0, this.drawable.getIntrinsicWidth(), this.drawable.getIntrinsicHeight());
    this.drawable.setBounds(this.tempBounds);
  }
  
  public void onDestroy()
  {
    setAnimationListener(null);
    this.isInAnimation = false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.freeMode)
    {
      onDrawFreeMode(paramCanvas);
      return;
    }
    if (this.isEnterAnimationing)
    {
      createEnterAnimation(paramCanvas);
      return;
    }
    if (this.isBackAnimationing)
    {
      createBackAnimation(paramCanvas);
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  public void setAnimationListener(AnimationLister paramAnimationLister)
  {
    this.animationListener = paramAnimationLister;
  }
  
  public void startBackAnimation(Drawable paramDrawable, Rect paramRect1, Rect paramRect2, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    this.backState = 1;
    this.isBackAnimationing = true;
    this.drawable = paramDrawable;
    this.drawableRect = paramDrawable.copyBounds();
    this.startDstRect = paramRect1;
    this.endDstRect = paramRect2;
    this.cutValue = paramInt1;
    this.startX = paramInt2;
    this.startY = paramInt3;
    this.mAnimationDuringTime = paramLong;
    paramDrawable = this.animationListener;
    if (paramDrawable != null) {
      paramDrawable.onExitAnimationStart();
    }
    invalidate();
  }
  
  public void startBackAnimationFreeMode(Drawable paramDrawable, Rect paramRect1, Rect paramRect2, Rect paramRect3, Rect paramRect4, long paramLong)
  {
    this.freeMode = true;
    this.isEnter = false;
    int[] arrayOfInt = new int[2];
    getLocationInWindow(arrayOfInt);
    paramRect3 = new Rect(paramRect3);
    paramRect3.offset(arrayOfInt[0], -arrayOfInt[1]);
    this.startSrcRect = paramRect2;
    this.endSrcRect = paramRect1;
    this.startDstRect = paramRect4;
    this.endDstRect = paramRect3;
    this.drawable = paramDrawable;
    this.mAnimationDuringTime = paramLong;
    startAnimation();
    paramDrawable = this.animationListener;
    if (paramDrawable != null) {
      paramDrawable.onExitAnimationStart();
    }
  }
  
  public void startEnterAnimation(Drawable paramDrawable, Rect paramRect1, Rect paramRect2, int paramInt, long paramLong)
  {
    this.startState = 1;
    this.isEnterAnimationing = true;
    this.drawable = paramDrawable;
    this.drawableRect = paramDrawable.copyBounds();
    this.startDstRect = paramRect1;
    this.endDstRect = paramRect2;
    this.cutValue = paramInt;
    this.mAnimationDuringTime = paramLong;
    paramDrawable = this.animationListener;
    if (paramDrawable != null) {
      paramDrawable.onEnterAnimationStart();
    }
    invalidate();
  }
  
  public void startEnterAnimationFreeMode(Drawable paramDrawable, Rect paramRect1, Rect paramRect2, Rect paramRect3, Rect paramRect4, long paramLong)
  {
    this.freeMode = true;
    this.isEnter = true;
    int[] arrayOfInt = new int[2];
    getLocationInWindow(arrayOfInt);
    paramRect3 = new Rect(paramRect3);
    paramRect3.offset(arrayOfInt[0], -arrayOfInt[1]);
    this.startSrcRect = paramRect1;
    this.endSrcRect = paramRect2;
    this.startDstRect = paramRect3;
    this.endDstRect = paramRect4;
    this.drawable = paramDrawable;
    this.mAnimationDuringTime = paramLong;
    startAnimation();
    paramDrawable = this.animationListener;
    if (paramDrawable != null) {
      paramDrawable.onEnterAnimationStart();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.richmediabrowser.animation.AnimationView
 * JD-Core Version:    0.7.0.1
 */