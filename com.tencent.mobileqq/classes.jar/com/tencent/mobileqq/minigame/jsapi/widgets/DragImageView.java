package com.tencent.mobileqq.minigame.jsapi.widgets;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import com.tencent.mobileqq.minigame.utils.GameLog;

public class DragImageView
  extends ImageView
{
  public static final int MOVE_DELTA = 20;
  public static final String TAG = "DragImageView";
  private float mDownPosX;
  private float mDownPosY;
  private boolean mHasMove;
  private int mLastAction;
  private float mLastPosX;
  private float mLastPosY;
  private int mMarginBottom;
  private int mMarginLeft;
  private int mMarginRight;
  private int mMarginTop;
  private boolean mOnTouch;
  private int mOriginViewHeight;
  private int mOriginViewWidth;
  private float mScaleHeight;
  private float mScaleWidth;
  private float mScaleX;
  private float mScaleY;
  private int mScreenHeight;
  private int mScreenWidth;
  private int mViewHeight;
  private int mViewWidth;
  
  public DragImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DragImageView(Context paramContext, @android.support.annotation.Nullable @androidx.annotation.Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public DragImageView(Context paramContext, @android.support.annotation.Nullable @androidx.annotation.Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    getScreenConfig();
  }
  
  private float getLimitX(float paramFloat)
  {
    float f2;
    float f1;
    if (this.mOnTouch)
    {
      f2 = this.mScaleWidth - this.mOriginViewWidth;
      if (this.mScaleWidth + paramFloat + this.mMarginRight - f2 / 2.0F > this.mScreenWidth) {
        f1 = this.mScreenWidth - this.mScaleWidth - this.mMarginRight + f2 / 2.0F;
      }
    }
    do
    {
      do
      {
        return f1;
        f1 = paramFloat;
      } while (paramFloat >= this.mMarginLeft);
      return this.mMarginLeft - f2 / 2.0F;
      if (this.mOriginViewWidth + paramFloat + this.mMarginRight > this.mScreenWidth) {
        return this.mScreenWidth - this.mOriginViewWidth - this.mMarginRight;
      }
      f1 = paramFloat;
    } while (paramFloat >= this.mMarginLeft);
    return this.mMarginLeft;
  }
  
  private float getLimitY(float paramFloat)
  {
    float f2;
    float f1;
    if (this.mOnTouch)
    {
      f2 = this.mScaleHeight - this.mOriginViewHeight;
      if (this.mMarginBottom + paramFloat + this.mScaleHeight - f2 / 2.0F > this.mScreenHeight) {
        f1 = this.mScreenHeight - this.mMarginBottom - this.mScaleHeight + f2 / 2.0F;
      }
    }
    do
    {
      do
      {
        return f1;
        f1 = paramFloat;
      } while (paramFloat >= this.mMarginTop);
      return this.mMarginTop - f2 / 2.0F;
      if (this.mMarginBottom + paramFloat + this.mOriginViewHeight > this.mScreenHeight) {
        return this.mScreenHeight - this.mMarginBottom - this.mOriginViewHeight;
      }
      f1 = paramFloat;
    } while (paramFloat >= this.mMarginTop);
    return this.mMarginTop;
  }
  
  private void getScreenConfig()
  {
    Object localObject = (WindowManager)getContext().getSystemService("window");
    Point localPoint;
    if (localObject != null)
    {
      localObject = ((WindowManager)localObject).getDefaultDisplay();
      localPoint = new Point();
      if (Build.VERSION.SDK_INT >= 17)
      {
        ((Display)localObject).getRealSize(localPoint);
        this.mScreenWidth = localPoint.x;
      }
    }
    for (this.mScreenHeight = localPoint.y;; this.mScreenHeight = getContext().getResources().getDisplayMetrics().heightPixels)
    {
      GameLog.getInstance().i("DragImageView", "getScreenConfig mScreenWidth: " + this.mScreenWidth + ", mScreenHeight: " + this.mScreenHeight);
      return;
      ((Display)localObject).getSize(localPoint);
      break;
      this.mScreenWidth = getContext().getResources().getDisplayMetrics().widthPixels;
    }
  }
  
  private boolean handleActionDown(MotionEvent paramMotionEvent)
  {
    scaleView();
    this.mDownPosX = paramMotionEvent.getRawX();
    this.mDownPosY = paramMotionEvent.getRawY();
    this.mLastPosX = this.mDownPosX;
    this.mLastPosY = this.mDownPosY;
    return true;
  }
  
  private boolean handleActionMove(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    float f3 = getLimitY(getY() + f2 - this.mLastPosY);
    this.mLastPosY = f2;
    float f4 = getLimitX(getX() + f1 - this.mLastPosX);
    this.mLastPosX = f1;
    setX(f4);
    setY(f3);
    this.mHasMove = isMovingOrNot(this.mDownPosX, this.mDownPosY, f1, f2);
    bringToFront();
    return true;
  }
  
  private boolean handleActionUp()
  {
    restoreScale();
    if (this.mLastAction == 0) {
      performClick();
    }
    for (;;)
    {
      this.mHasMove = false;
      return false;
      if (!this.mHasMove) {
        performClick();
      }
      landSide();
    }
  }
  
  private boolean isMovingOrNot(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (Math.abs(paramFloat1 - paramFloat3) > 20.0F) || (Math.abs(paramFloat2 - paramFloat4) > 20.0F);
  }
  
  private void landSide()
  {
    if (getX() > this.mScreenWidth / 2.0F) {}
    for (int i = this.mScreenWidth;; i = 0)
    {
      animate().setInterpolator(new DecelerateInterpolator()).x(getLimitX(i)).setDuration(300L).start();
      return;
    }
  }
  
  private void resetMargin()
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)getLayoutParams();
    this.mMarginLeft = localMarginLayoutParams.leftMargin;
    this.mMarginRight = localMarginLayoutParams.rightMargin;
    this.mMarginTop = localMarginLayoutParams.topMargin;
    this.mMarginBottom = localMarginLayoutParams.bottomMargin;
  }
  
  private void resetViewSize()
  {
    this.mViewWidth = getMeasuredWidth();
    this.mViewHeight = getMeasuredHeight();
  }
  
  private void restoreScale()
  {
    float f1 = this.mScaleWidth;
    float f2 = this.mOriginViewWidth;
    float f3 = this.mScaleHeight;
    float f4 = this.mOriginViewHeight;
    setX(getX() - (f1 - f2) / 2.0F);
    setY(getY() - (f3 - f4) / 2.0F);
    this.mOnTouch = false;
    requestLayout();
  }
  
  private void scaleView()
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)getLayoutParams();
    this.mOriginViewHeight = localMarginLayoutParams.height;
    this.mOriginViewWidth = localMarginLayoutParams.width;
    if ((this.mScaleHeight > 0.0F) && (this.mScaleWidth > 0.0F))
    {
      float f1 = this.mScaleWidth;
      float f2 = this.mOriginViewWidth;
      float f3 = this.mScaleHeight;
      float f4 = this.mOriginViewHeight;
      float f5 = getX();
      setX((f1 - f2) / 2.0F + f5);
      setY(getY() + (f3 - f4) / 2.0F);
      this.mScaleX = (this.mScaleWidth / this.mViewWidth);
      this.mScaleY = (this.mScaleHeight / this.mViewHeight);
      this.mOnTouch = true;
      requestLayout();
    }
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    getScreenConfig();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    resetMargin();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.mOnTouch) {
      setMeasuredDimension((int)this.mScaleWidth, (int)this.mScaleHeight);
    }
    for (;;)
    {
      resetViewSize();
      return;
      super.onMeasure(paramInt1, paramInt2);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    boolean bool;
    switch (i)
    {
    default: 
      return false;
    case 0: 
      bool = handleActionDown(paramMotionEvent);
    }
    for (;;)
    {
      this.mLastAction = i;
      return bool;
      bool = handleActionMove(paramMotionEvent);
      continue;
      bool = handleActionUp();
    }
  }
  
  public void setScaleSize(float paramFloat1, float paramFloat2)
  {
    this.mScaleWidth = paramFloat1;
    this.mScaleHeight = paramFloat2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.widgets.DragImageView
 * JD-Core Version:    0.7.0.1
 */