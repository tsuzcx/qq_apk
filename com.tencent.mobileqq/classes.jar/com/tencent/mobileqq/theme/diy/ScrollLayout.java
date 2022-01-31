package com.tencent.mobileqq.theme.diy;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Scroller;
import com.tencent.qphone.base.util.QLog;
import java.io.PrintStream;

public class ScrollLayout
  extends ViewGroup
{
  static final float ALPHA_H = 1.0F;
  static final float ALPHA_L = 0.4F;
  static final float ALPHA_STEP = 0.6F;
  static final float SCALE_H = 1.0F;
  static final float SCALE_L = 0.8F;
  static final float SCALE_STEP = 0.2F;
  static final int SNAP_VELOCITY = 600;
  static final String TAG = "ScrollLayout";
  static final int TOUCH_STATE_REST = 0;
  static final int TOUCH_STATE_SCROLLING = 1;
  int frameWidth = 0;
  int mCurScreen;
  int mDefaultScreen = 0;
  Handler mHandler = null;
  float mLastMotionX;
  Scroller mScroller;
  int mTouchSlop;
  int mTouchState = 0;
  VelocityTracker mVelocityTracker;
  ScrollLayout.OnScreenChangeListener onScreenChangeListener;
  ScrollLayout.OnScreenChangeListenerDataLoad onScreenChangeListenerDataLoad;
  
  public ScrollLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ScrollLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mScroller = new Scroller(paramContext);
    this.mCurScreen = this.mDefaultScreen;
    this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.mHandler = new ScrollLayout.1(this);
  }
  
  public boolean changeAlpha(View paramView, boolean paramBoolean, int paramInt)
  {
    if ((paramView == null) || (!(paramView.getTag() instanceof ThemeDIYActivity.ViewHolder))) {
      return false;
    }
    ThemeDIYActivity.ViewHolder localViewHolder = (ThemeDIYActivity.ViewHolder)paramView.getTag();
    label100:
    label115:
    Object localObject;
    if (((paramBoolean) && (localViewHolder.scale == 0.8F)) || ((!paramBoolean) && (localViewHolder.scale == 1.0F)))
    {
      if (((paramBoolean) && (localViewHolder.alpha == 0.4F)) || ((!paramBoolean) && (localViewHolder.alpha == 1.0F))) {
        return true;
      }
    }
    else
    {
      float f3 = localViewHolder.scale;
      if (paramBoolean)
      {
        f1 = 0.8F;
        float f4 = localViewHolder.scale;
        if (!paramBoolean) {
          break label185;
        }
        f2 = 0.8F;
        localObject = new ScaleAnimation(f3, f1, f4, f2, 1, 0.5F, 1, 0.5F);
        ((ScaleAnimation)localObject).setDuration(paramInt);
        ((ScaleAnimation)localObject).setFillAfter(true);
        localViewHolder.scaleView.startAnimation((Animation)localObject);
        if (!paramBoolean) {
          break label191;
        }
      }
      label185:
      label191:
      for (f1 = 0.8F;; f1 = 1.0F)
      {
        localViewHolder.scale = f1;
        break;
        f1 = 1.0F;
        break label100;
        f2 = 1.0F;
        break label115;
      }
    }
    float f2 = localViewHolder.alpha;
    if (paramBoolean)
    {
      f1 = 0.4F;
      label212:
      localObject = new AlphaAnimation(f2, f1);
      ((AlphaAnimation)localObject).setFillAfter(true);
      ((AlphaAnimation)localObject).setDuration(paramInt);
      paramView.startAnimation((Animation)localObject);
      if (!paramBoolean) {
        break label268;
      }
    }
    label268:
    for (float f1 = 0.4F;; f1 = 1.0F)
    {
      localViewHolder.alpha = f1;
      break;
      f1 = 1.0F;
      break label212;
    }
  }
  
  void changeAlphaImmediately(int paramInt)
  {
    View localView = super.getChildAt(paramInt);
    if (localView == null) {
      return;
    }
    changeAlphaImmediately(localView, 1.0F - Math.abs((getScrollX() - localView.getLeft() * 1.0F) / getFrameWith()) * 0.6F, 0);
  }
  
  boolean changeAlphaImmediately(View paramView, float paramFloat, int paramInt)
  {
    boolean bool = true;
    if ((paramView == null) || (!(paramView.getTag() instanceof ThemeDIYActivity.ViewHolder))) {
      bool = false;
    }
    ThemeDIYActivity.ViewHolder localViewHolder;
    do
    {
      return bool;
      localViewHolder = (ThemeDIYActivity.ViewHolder)paramView.getTag();
    } while (localViewHolder.alpha == paramFloat);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(localViewHolder.alpha, paramFloat);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setDuration(paramInt);
    paramView.startAnimation(localAlphaAnimation);
    localViewHolder.alpha = paramFloat;
    paramFloat = 0.8F + (paramFloat - 0.4F) / 0.6F * 0.2F;
    paramView = new ScaleAnimation(localViewHolder.scale, paramFloat, localViewHolder.scale, paramFloat, 1, 0.5F, 1, 0.5F);
    paramView.setFillAfter(true);
    paramView.setDuration(paramInt);
    localViewHolder.scaleView.startAnimation(paramView);
    localViewHolder.scale = paramFloat;
    return true;
  }
  
  public void computeScroll()
  {
    if (this.mScroller.computeScrollOffset())
    {
      super.scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
      postInvalidate();
    }
  }
  
  public int getCurScreen()
  {
    return this.mCurScreen;
  }
  
  int getFrameWith()
  {
    if (this.frameWidth == 0) {
      this.frameWidth = ((int)(getWidth() * 0.6D));
    }
    return this.frameWidth;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i == 2) && (this.mTouchState != 0)) {}
    for (;;)
    {
      return true;
      float f = paramMotionEvent.getX();
      paramMotionEvent.getY();
      switch (i)
      {
      }
      while (this.mTouchState == 0)
      {
        return false;
        if ((int)Math.abs(this.mLastMotionX - f) > this.mTouchSlop)
        {
          this.mTouchState = 1;
          continue;
          this.mLastMotionX = f;
          if (this.mScroller.isFinished()) {}
          for (i = 0;; i = 1)
          {
            this.mTouchState = i;
            break;
          }
          this.mTouchState = 0;
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt4 = super.getChildCount();
    System.out.println("childCount=" + paramInt4);
    paramInt1 = 0;
    for (paramInt2 = 0; paramInt1 < paramInt4; paramInt2 = paramInt3)
    {
      View localView = super.getChildAt(paramInt1);
      paramInt3 = paramInt2;
      if (localView.getVisibility() != 8)
      {
        paramInt3 = getFrameWith();
        localView.layout(paramInt2, 0, getWidth() + paramInt2, localView.getMeasuredHeight());
        paramInt3 = paramInt2 + paramInt3;
      }
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int j = getFrameWith();
    if (View.MeasureSpec.getMode(paramInt1) != 1073741824) {
      throw new IllegalStateException("ScrollLayout only canmCurScreen run at EXACTLY mode!");
    }
    if (View.MeasureSpec.getMode(paramInt2) != 1073741824) {
      throw new IllegalStateException("ScrollLayout only can run at EXACTLY mode!");
    }
    int k = super.getChildCount();
    int i = 0;
    for (;;)
    {
      if (i < k) {
        try
        {
          super.getChildAt(i).measure(paramInt1, paramInt2);
          i += 1;
        }
        catch (IllegalStateException localIllegalStateException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("ScrollLayout", 2, "onMeasure IllegalStateException:" + localIllegalStateException.getMessage());
            }
          }
        }
      }
    }
    System.out.println("moving to screen " + this.mCurScreen);
    super.scrollTo(this.mCurScreen * j, 0);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    int i = paramMotionEvent.getAction();
    float f = paramMotionEvent.getX();
    paramMotionEvent.getY();
    switch (i)
    {
    }
    for (;;)
    {
      return true;
      if (!this.mScroller.isFinished()) {
        this.mScroller.abortAnimation();
      }
      this.mLastMotionX = f;
      continue;
      i = (int)(this.mLastMotionX - f);
      this.mLastMotionX = f;
      scrollBy(i, 0);
      i = (getScrollX() + getFrameWith() / 2) / getFrameWith();
      changeAlphaImmediately(i);
      if (i > 0) {
        changeAlphaImmediately(i - 1);
      }
      if (i < super.getChildCount() - 1)
      {
        changeAlphaImmediately(i + 1);
        continue;
        paramMotionEvent = this.mVelocityTracker;
        paramMotionEvent.computeCurrentVelocity(1000);
        i = (int)paramMotionEvent.getXVelocity();
        if ((i > 600) && (this.mCurScreen > 0))
        {
          this.onScreenChangeListener.onScreenChange(this.mCurScreen - 1);
          System.out.println("mCurScreen=" + (this.mCurScreen - 1));
          snapToScreen(this.mCurScreen - 1);
        }
        for (;;)
        {
          if (this.mVelocityTracker != null)
          {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
          }
          this.mTouchState = 0;
          break;
          if ((i < -600) && (this.mCurScreen < super.getChildCount() - 1))
          {
            this.onScreenChangeListener.onScreenChange(this.mCurScreen + 1);
            this.onScreenChangeListenerDataLoad.onScreenChange(this.mCurScreen + 1);
            snapToScreen(this.mCurScreen + 1);
          }
          else
          {
            snapToDestination();
          }
        }
        this.mTouchState = 0;
      }
    }
  }
  
  public void setOnScreenChangeListener(ScrollLayout.OnScreenChangeListener paramOnScreenChangeListener)
  {
    this.onScreenChangeListener = paramOnScreenChangeListener;
  }
  
  public void setOnScreenChangeListenerDataLoad(ScrollLayout.OnScreenChangeListenerDataLoad paramOnScreenChangeListenerDataLoad)
  {
    this.onScreenChangeListenerDataLoad = paramOnScreenChangeListenerDataLoad;
  }
  
  public void setToScreen(int paramInt1, int paramInt2)
  {
    View localView = super.getChildAt(paramInt1);
    if ((localView == null) || (!(localView.getTag() instanceof ThemeDIYActivity.ViewHolder))) {}
    do
    {
      return;
      ThemeDIYActivity.ViewHolder localViewHolder = (ThemeDIYActivity.ViewHolder)localView.getTag();
      localViewHolder.alpha -= 0.01F;
      changeAlpha(localView, false, paramInt2);
      if (paramInt1 > 0) {
        changeAlpha(super.getChildAt(paramInt1 - 1), true, paramInt2);
      }
    } while (paramInt1 >= super.getChildCount() - 1);
    changeAlpha(super.getChildAt(paramInt1 + 1), true, paramInt2);
  }
  
  public void snapToDestination()
  {
    int i = (getScrollX() + getFrameWith() / 2) / getFrameWith();
    snapToScreen(i);
    this.onScreenChangeListener.onScreenChange(i);
  }
  
  public void snapToScreen(int paramInt)
  {
    int i = 300;
    int j = Math.max(0, Math.min(paramInt, super.getChildCount() - 1));
    int k;
    if (getScrollX() != getFrameWith() * j)
    {
      k = getFrameWith() * j - getScrollX();
      paramInt = Math.abs(k) * 2;
      if (paramInt >= 300) {
        break label111;
      }
      paramInt = i;
    }
    label111:
    for (;;)
    {
      this.mScroller.startScroll(getScrollX(), 0, k, 0, paramInt);
      this.mCurScreen = j;
      invalidate();
      this.mHandler.sendMessageDelayed(Message.obtain(this.mHandler, j, Integer.valueOf(paramInt)), 10L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ScrollLayout
 * JD-Core Version:    0.7.0.1
 */