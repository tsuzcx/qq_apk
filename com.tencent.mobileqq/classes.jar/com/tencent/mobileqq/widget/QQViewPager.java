package com.tencent.mobileqq.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
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
      if (QLog.isColorLevel()) {
        QLog.d("QQViewPager", 2, "doInterceptTouchEvent : " + paramBoolean);
      }
      localViewGroup.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  private void handleEvent(MotionEvent paramMotionEvent)
  {
    int i;
    int j;
    if (this.disable)
    {
      i = (int)paramMotionEvent.getRawX();
      j = (int)paramMotionEvent.getRawY();
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        return;
        this.downX = i;
        this.downY = j;
        return;
        if (this.mSlideDir == 0) {
          judgeScrollDirection(Math.abs(i - this.downX), Math.abs(j - this.downY));
        }
      } while (this.mSlideDir != 1);
      doInterceptTouchEvent(true);
      return;
    }
    this.mSlideDir = 0;
    doInterceptTouchEvent(false);
  }
  
  private void judgeScrollDirection(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 > this.scaledTouchSlop) || (paramFloat2 > this.scaledTouchSlop)) {
      if ((paramFloat1 <= this.scaledTouchSlop) || (paramFloat2 / paramFloat1 >= 0.6F)) {
        break label79;
      }
    }
    label79:
    for (this.mSlideDir = 1;; this.mSlideDir = 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQViewPager", 2, "judgeScrollDirection : mSlideDir -> " + this.mSlideDir);
      }
      return;
    }
  }
  
  public void disableGesture(boolean paramBoolean)
  {
    this.disable = paramBoolean;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.disable) {
      handleEvent(paramMotionEvent);
    }
    for (;;)
    {
      try
      {
        boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
        return bool;
      }
      catch (Exception paramMotionEvent)
      {
        int i;
        paramMotionEvent.printStackTrace();
      }
      if (this.requestParentDisallowInterceptTouchEvent)
      {
        i = paramMotionEvent.getAction();
        if (i == 0) {
          doInterceptTouchEvent(true);
        } else if ((i == 1) || (i == 3)) {
          doInterceptTouchEvent(false);
        }
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQViewPager
 * JD-Core Version:    0.7.0.1
 */