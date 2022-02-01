package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.mobileqq.widget.QQViewPager;

public class EmoticonPanelViewPager
  extends QQViewPager
{
  private int mDistanceX;
  private boolean mFromLeftToRightScrollDisEnable;
  private boolean mFromRightToLeftScrollDisEnable;
  private int mLeftNoScrollSize;
  private float mMoveX;
  private boolean mOnFingerTouch;
  private int mRightNoScrollItem;
  private float mStartX;
  
  public EmoticonPanelViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public EmoticonPanelViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i == 1) || (i == 3))
      {
        this.mDistanceX = 0;
        this.mOnFingerTouch = false;
      }
    }
    else
    {
      this.mOnFingerTouch = true;
      this.mDistanceX = 0;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!this.mFromLeftToRightScrollDisEnable) && (!this.mFromRightToLeftScrollDisEnable)) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i == 2)
      {
        this.mMoveX = (paramMotionEvent.getX() - this.mStartX);
        this.mStartX = paramMotionEvent.getX();
        if (((this.mFromLeftToRightScrollDisEnable) && (this.mMoveX > 0.0F)) || ((this.mFromRightToLeftScrollDisEnable) && (this.mMoveX < 0.0F))) {
          return false;
        }
      }
    }
    else {
      this.mStartX = paramMotionEvent.getX();
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    if ((this.mOnFingerTouch) && ((this.mLeftNoScrollSize != 0) || (this.mRightNoScrollItem != 0)))
    {
      int j = getCurrentItem();
      int k = this.mLeftNoScrollSize;
      int i = paramInt1;
      if (j == k)
      {
        i = paramInt1;
        if (k != 0)
        {
          i = paramInt1;
          if (this.mFromLeftToRightScrollDisEnable)
          {
            j = getScrollX();
            this.mDistanceX += paramInt1 - j;
            i = paramInt1;
            if (this.mDistanceX < 0) {
              i = j;
            }
          }
        }
      }
      j = getCurrentItem();
      k = this.mRightNoScrollItem;
      paramInt1 = i;
      if (j == k)
      {
        paramInt1 = i;
        if (k != 0)
        {
          paramInt1 = i;
          if (this.mFromRightToLeftScrollDisEnable)
          {
            j = getScrollX();
            this.mDistanceX += i - j;
            paramInt1 = i;
            if (this.mDistanceX > 0) {
              paramInt1 = j;
            }
          }
        }
      }
      super.scrollTo(paramInt1, paramInt2);
      return;
    }
    super.scrollTo(paramInt1, paramInt2);
  }
  
  public void setLeftScrollDisEnable(boolean paramBoolean)
  {
    this.mFromRightToLeftScrollDisEnable = paramBoolean;
  }
  
  public void setNoScrollItem(int paramInt1, int paramInt2)
  {
    this.mLeftNoScrollSize = paramInt1;
    this.mRightNoScrollItem = paramInt2;
  }
  
  public void setRightScrollDisEnable(boolean paramBoolean)
  {
    this.mFromLeftToRightScrollDisEnable = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelViewPager
 * JD-Core Version:    0.7.0.1
 */