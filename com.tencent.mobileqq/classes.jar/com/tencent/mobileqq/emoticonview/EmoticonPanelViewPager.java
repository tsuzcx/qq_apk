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
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      this.mOnFingerTouch = true;
      this.mDistanceX = 0;
      continue;
      this.mDistanceX = 0;
      this.mOnFingerTouch = false;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.mFromLeftToRightScrollDisEnable) || (this.mFromRightToLeftScrollDisEnable))
    {
      switch (paramMotionEvent.getAction())
      {
      }
      do
      {
        for (;;)
        {
          return super.onInterceptTouchEvent(paramMotionEvent);
          this.mStartX = paramMotionEvent.getX();
        }
        this.mMoveX = (paramMotionEvent.getX() - this.mStartX);
        this.mStartX = paramMotionEvent.getX();
      } while (((!this.mFromLeftToRightScrollDisEnable) || (this.mMoveX <= 0.0F)) && ((!this.mFromRightToLeftScrollDisEnable) || (this.mMoveX >= 0.0F)));
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    if ((!this.mOnFingerTouch) || ((this.mLeftNoScrollSize == 0) && (this.mRightNoScrollItem == 0)))
    {
      super.scrollTo(paramInt1, paramInt2);
      return;
    }
    int i = paramInt1;
    int j;
    if (getCurrentItem() == this.mLeftNoScrollSize)
    {
      i = paramInt1;
      if (this.mLeftNoScrollSize != 0)
      {
        i = paramInt1;
        if (this.mFromLeftToRightScrollDisEnable)
        {
          j = getScrollX();
          this.mDistanceX = (paramInt1 - j + this.mDistanceX);
          i = paramInt1;
          if (this.mDistanceX < 0) {
            i = j;
          }
        }
      }
    }
    paramInt1 = i;
    if (getCurrentItem() == this.mRightNoScrollItem)
    {
      paramInt1 = i;
      if (this.mRightNoScrollItem != 0)
      {
        paramInt1 = i;
        if (this.mFromRightToLeftScrollDisEnable)
        {
          j = getScrollX();
          this.mDistanceX = (i - j + this.mDistanceX);
          paramInt1 = i;
          if (this.mDistanceX > 0) {
            paramInt1 = j;
          }
        }
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelViewPager
 * JD-Core Version:    0.7.0.1
 */