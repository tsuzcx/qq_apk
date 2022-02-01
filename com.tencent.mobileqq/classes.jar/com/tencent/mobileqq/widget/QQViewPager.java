package com.tencent.mobileqq.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.tencent.qphone.base.util.QLog;

public class QQViewPager
  extends ViewPager
{
  private static final byte SLIDE_DIR_DEFAULT = 0;
  private static final byte SLIDE_DIR_HORIZONTAL = 1;
  private static final byte SLIDE_DIR_VERTICAL = 2;
  private static final String TAG = "QQViewPager";
  private boolean disable = false;
  private int downX;
  private int downY;
  private byte mSlideDir = 0;
  private boolean requestParentDisallowInterceptTouchEvent = false;
  private final int scaledTouchSlop;
  
  public QQViewPager(Context paramContext)
  {
    super(paramContext);
    this.scaledTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  public QQViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.scaledTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  private void doInterceptTouchEvent(boolean paramBoolean)
  {
    ViewGroup localViewGroup = (ViewGroup)getParent();
    if (localViewGroup != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doInterceptTouchEvent : ");
        localStringBuilder.append(paramBoolean);
        QLog.d("QQViewPager", 2, localStringBuilder.toString());
      }
      localViewGroup.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  private void handleEvent(MotionEvent paramMotionEvent)
  {
    if (this.disable)
    {
      int i = (int)paramMotionEvent.getRawX();
      int j = (int)paramMotionEvent.getRawY();
      int k = paramMotionEvent.getAction();
      if (k != 0)
      {
        if (k != 1) {
          if (k != 2)
          {
            if (k == 3) {}
          }
          else
          {
            if (this.mSlideDir == 0) {
              judgeScrollDirection(Math.abs(i - this.downX), Math.abs(j - this.downY));
            }
            if (this.mSlideDir != 1) {
              return;
            }
            doInterceptTouchEvent(true);
            return;
          }
        }
        this.mSlideDir = 0;
        doInterceptTouchEvent(false);
      }
      else
      {
        this.downX = i;
        this.downY = j;
      }
    }
  }
  
  private void judgeScrollDirection(float paramFloat1, float paramFloat2)
  {
    int i = this.scaledTouchSlop;
    if ((paramFloat1 > i) || (paramFloat2 > i)) {
      if ((paramFloat1 > this.scaledTouchSlop) && (paramFloat2 / paramFloat1 < 0.6F)) {
        this.mSlideDir = 1;
      } else {
        this.mSlideDir = 2;
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("judgeScrollDirection : mSlideDir -> ");
      localStringBuilder.append(this.mSlideDir);
      QLog.d("QQViewPager", 2, localStringBuilder.toString());
    }
  }
  
  public void disableGesture(boolean paramBoolean)
  {
    this.disable = paramBoolean;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.disable)
    {
      handleEvent(paramMotionEvent);
    }
    else if (this.requestParentDisallowInterceptTouchEvent)
    {
      int i = paramMotionEvent.getAction();
      if (i == 0) {
        doInterceptTouchEvent(true);
      } else if ((i == 1) || (i == 3)) {
        doInterceptTouchEvent(false);
      }
    }
    try
    {
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent)
    {
      paramMotionEvent.printStackTrace();
    }
    return false;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    handleEvent(paramMotionEvent);
    try
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent)
    {
      paramMotionEvent.printStackTrace();
    }
    return false;
  }
  
  public void requestParentDisallowInterecptTouchEvent(boolean paramBoolean)
  {
    this.requestParentDisallowInterceptTouchEvent = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQViewPager
 * JD-Core Version:    0.7.0.1
 */