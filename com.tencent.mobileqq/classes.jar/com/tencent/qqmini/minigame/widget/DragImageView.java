package com.tencent.qqmini.minigame.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

public class DragImageView
  extends ImageView
{
  public static final int MOVE_DELTA = 10;
  public static final int MOVE_FLOATAD = 0;
  public static final int MOVE_PENDANTAD = 1;
  public static final String TAG = "DragImageView";
  private float mDownPosX;
  private float mDownPosY;
  private int mDraggableMode = 0;
  private boolean mHasMove;
  private boolean mHasScale;
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
  
  public DragImageView(Context paramContext, int paramInt)
  {
    this(paramContext, null);
    this.mDraggableMode = paramInt;
  }
  
  public DragImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public DragImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    getScreenConfig();
  }
  
  private float getLimitX(float paramFloat)
  {
    float f1;
    int i;
    float f2;
    int j;
    if (this.mOnTouch)
    {
      f1 = this.mScaleWidth;
      float f3 = this.mOriginViewWidth;
      i = this.mMarginRight;
      f2 = i;
      f3 = (f1 - f3) / 2.0F;
      j = this.mScreenWidth;
      if (paramFloat + f1 + f2 - f3 > j) {
        return j - f1 - i + f3;
      }
      i = this.mMarginLeft;
      f1 = paramFloat;
      if (paramFloat < i) {
        return i - f3;
      }
    }
    else
    {
      i = this.mOriginViewWidth;
      f1 = i;
      j = this.mMarginRight;
      f2 = j;
      int k = this.mScreenWidth;
      if (f1 + paramFloat + f2 > k) {
        return k - i - j;
      }
      i = this.mMarginLeft;
      f1 = paramFloat;
      if (paramFloat < i) {
        f1 = i;
      }
    }
    return f1;
  }
  
  private float getLimitY(float paramFloat)
  {
    float f1;
    int i;
    float f2;
    int j;
    if (this.mOnTouch)
    {
      f1 = this.mScaleHeight;
      float f3 = this.mOriginViewHeight;
      i = this.mMarginBottom;
      f2 = i;
      f3 = (f1 - f3) / 2.0F;
      j = this.mScreenHeight;
      if (f2 + paramFloat + f1 - f3 > j) {
        return j - i - f1 + f3;
      }
      i = this.mMarginTop;
      f1 = paramFloat;
      if (paramFloat < i) {
        return i - f3;
      }
    }
    else
    {
      i = this.mMarginBottom;
      f1 = i;
      j = this.mOriginViewHeight;
      f2 = j;
      int k = this.mScreenHeight;
      if (f1 + paramFloat + f2 > k) {
        return k - i - j;
      }
      i = this.mMarginTop;
      f1 = paramFloat;
      if (paramFloat < i) {
        f1 = i;
      }
    }
    return f1;
  }
  
  private void getOriginSize()
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)getLayoutParams();
    this.mOriginViewHeight = localMarginLayoutParams.height;
    this.mOriginViewWidth = localMarginLayoutParams.width;
  }
  
  private void getScreenConfig()
  {
    Object localObject = (WindowManager)getContext().getSystemService("window");
    if (localObject != null)
    {
      localObject = ((WindowManager)localObject).getDefaultDisplay();
      Point localPoint = new Point();
      if (Build.VERSION.SDK_INT >= 17) {
        ((Display)localObject).getRealSize(localPoint);
      } else {
        ((Display)localObject).getSize(localPoint);
      }
      this.mScreenWidth = localPoint.x;
      this.mScreenHeight = localPoint.y;
    }
    else
    {
      this.mScreenWidth = getContext().getResources().getDisplayMetrics().widthPixels;
      this.mScreenHeight = getContext().getResources().getDisplayMetrics().heightPixels;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getScreenConfig mScreenWidth: ");
    ((StringBuilder)localObject).append(this.mScreenWidth);
    ((StringBuilder)localObject).append(", mScreenHeight: ");
    ((StringBuilder)localObject).append(this.mScreenHeight);
    QMLog.i("DragImageView", ((StringBuilder)localObject).toString());
  }
  
  private boolean handleActionDown(MotionEvent paramMotionEvent)
  {
    getOriginSize();
    setColorFilter();
    this.mDownPosX = paramMotionEvent.getRawX();
    this.mDownPosY = paramMotionEvent.getRawY();
    this.mLastPosX = this.mDownPosX;
    this.mLastPosY = this.mDownPosY;
    return true;
  }
  
  private boolean handleActionMove(MotionEvent paramMotionEvent)
  {
    int i = this.mDraggableMode;
    if (i == 1)
    {
      moveX(paramMotionEvent);
    }
    else if (i == 0)
    {
      moveX(paramMotionEvent);
      moveY(paramMotionEvent);
    }
    this.mHasMove = isMovingOrNot(this.mDownPosX, this.mDownPosY, paramMotionEvent.getRawX(), paramMotionEvent.getRawY());
    if (this.mHasMove)
    {
      resetColorFilter();
      if (this.mDraggableMode == 0) {
        scaleView();
      }
    }
    bringToFront();
    return true;
  }
  
  private boolean handleActionUp()
  {
    resetColorFilter();
    if (this.mDraggableMode == 0) {
      restoreScale();
    }
    if (this.mLastAction == 0)
    {
      performClick();
    }
    else
    {
      if (!this.mHasMove) {
        performClick();
      }
      if (this.mDraggableMode == 0) {
        landSide();
      }
    }
    this.mHasMove = false;
    return false;
  }
  
  private boolean isMovingOrNot(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (Math.abs(paramFloat1 - paramFloat3) > 10.0F) || (Math.abs(paramFloat2 - paramFloat4) > 10.0F);
  }
  
  private void landSide()
  {
    float f = getX();
    int i = this.mScreenWidth;
    if (f <= i / 2.0F) {
      i = 0;
    }
    animate().setInterpolator(new DecelerateInterpolator()).x(getLimitX(i)).setDuration(300L).start();
  }
  
  private void moveX(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getRawX();
    float f2 = getLimitX(getX() + f1 - this.mLastPosX);
    this.mLastPosX = f1;
    setX(f2);
  }
  
  private void moveY(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getRawY();
    float f2 = getLimitY(getY() + f1 - this.mLastPosY);
    this.mLastPosY = f1;
    setY(f2);
  }
  
  private void resetColorFilter()
  {
    clearColorFilter();
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
    if (!this.mHasScale) {
      return;
    }
    this.mHasScale = false;
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
    if (this.mHasScale) {
      return;
    }
    this.mHasScale = true;
    float f1 = this.mScaleHeight;
    if (f1 > 0.0F)
    {
      float f2 = this.mScaleWidth;
      if (f2 > 0.0F)
      {
        float f3 = this.mOriginViewWidth;
        float f4 = this.mOriginViewHeight;
        setX(getX() + (f2 - f3) / 2.0F);
        setY(getY() + (f1 - f4) / 2.0F);
        this.mScaleX = (this.mScaleWidth / this.mViewWidth);
        this.mScaleY = (this.mScaleHeight / this.mViewHeight);
        this.mOnTouch = true;
        requestLayout();
      }
    }
  }
  
  private void setColorFilter()
  {
    setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
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
    } else {
      super.onMeasure(paramInt1, paramInt2);
    }
    resetViewSize();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    boolean bool;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return false;
        }
        bool = handleActionMove(paramMotionEvent);
      }
      else
      {
        bool = handleActionUp();
      }
    }
    else {
      bool = handleActionDown(paramMotionEvent);
    }
    this.mLastAction = i;
    return bool;
  }
  
  public void setScaleSize(float paramFloat1, float paramFloat2)
  {
    this.mScaleWidth = paramFloat1;
    this.mScaleHeight = paramFloat2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.widget.DragImageView
 * JD-Core Version:    0.7.0.1
 */