package com.tencent.mobileqq.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class SlideDetectListView
  extends XListView
  implements MotionViewSetter
{
  public static final float HORIZONTAL_SLIDE_RATIO = 1.73F;
  float fy = 0.0F;
  protected boolean mCanSlide = true;
  protected int mDeleteAreaHeight = -1;
  protected int mDeleteAreaWidth;
  int mDownY = 0;
  protected GestureDetector mGestureDetector;
  protected GestureDetector.SimpleOnGestureListener mGestureListener = new SlideDetectListView.1(this);
  protected boolean mHasDeleteDown;
  boolean mHasSlide = false;
  boolean mHasSlideBanner = false;
  private ArrayList<Integer> mHeaderFooterHashList = new ArrayList();
  View mMotionView;
  int mMotionViewPosition;
  protected boolean mNotCheckStateWhenSlide;
  private AbsListView.OnScrollListener mScrollGFListener;
  int mScrollState = 0;
  private AbsListView.OnScrollListener mScrollToTopListener;
  private SlideDetectListView.OnSlideListener mSlideListener;
  int mSlideSlop;
  
  public SlideDetectListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setOnScrollListener(new SlideDetectListView.2(this));
    this.mSlideSlop = (ViewConfiguration.getTouchSlop() + 2);
  }
  
  public void addFooterView(View paramView, Object paramObject, boolean paramBoolean)
  {
    this.mHeaderFooterHashList.add(Integer.valueOf(paramView.hashCode()));
    super.addFooterView(paramView, paramObject, paramBoolean);
  }
  
  public void addHeaderView(View paramView, Object paramObject, boolean paramBoolean)
  {
    this.mHeaderFooterHashList.add(Integer.valueOf(paramView.hashCode()));
    super.addHeaderView(paramView, paramObject, paramBoolean);
  }
  
  public void cancelSlide()
  {
    if (this.mHasSlide == true)
    {
      if (this.mMotionView != null)
      {
        this.mMotionView.setPressed(false);
        if (this.mSlideListener != null) {
          this.mSlideListener.onSlideCancelled(this, this.mMotionView, this.mMotionViewPosition - getHeaderViewsCount());
        }
      }
      this.mHasSlide = false;
      this.mMotionView = null;
    }
  }
  
  public void cancelSlideNoShowAni()
  {
    if (this.mMotionView != null)
    {
      View localView = this.mMotionView.findViewById(2131377244);
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
    cancelSlide();
  }
  
  protected View findMotionView(int paramInt)
  {
    if (paramInt != -1) {
      try
      {
        View localView = getChildAt(paramInt - getFirstVisiblePosition());
        return localView;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return null;
  }
  
  protected int findMotionViewPosition(int paramInt)
  {
    int k = -1;
    int m = getChildCount();
    int i = k;
    View localView;
    if (m > 0)
    {
      if (!isStackFromBottom()) {
        j = 0;
      }
    }
    else {
      for (;;)
      {
        i = k;
        if (j < m)
        {
          localView = getChildAt(j);
          if (paramInt > localView.getBottom()) {
            break label94;
          }
          if (!this.mHeaderFooterHashList.contains(Integer.valueOf(localView.hashCode()))) {
            break label74;
          }
          i = k;
        }
        label74:
        do
        {
          return i;
          paramInt = getFirstVisiblePosition() + j;
          i = paramInt;
        } while (!isOverscrollHeadVisiable());
        return paramInt - 1;
        label94:
        j += 1;
      }
    }
    int j = m - 1;
    for (;;)
    {
      i = k;
      if (j < 0) {
        break;
      }
      localView = getChildAt(j);
      if (paramInt >= localView.getTop())
      {
        i = k;
        if (this.mHeaderFooterHashList.contains(Integer.valueOf(localView.hashCode()))) {
          break;
        }
        paramInt = getFirstVisiblePosition() + j;
        i = paramInt;
        if (!isOverscrollHeadVisiable()) {
          break;
        }
        return paramInt - 1;
      }
      j -= 1;
    }
  }
  
  public int getScrollState()
  {
    return this.mScrollState;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mGestureDetector == null)
    {
      this.mGestureDetector = new GestureDetector(getContext(), this.mGestureListener, new Handler(Looper.getMainLooper()));
      this.mGestureDetector.setIsLongpressEnabled(false);
    }
    this.mGestureDetector.onTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
    case 0: 
      for (;;)
      {
        if (this.mHasDeleteDown == true)
        {
          label96:
          return false;
          this.mDownY = ((int)paramMotionEvent.getY());
          this.mHasDeleteDown = false;
          i = findMotionViewPosition(this.mDownY);
          if ((this.mMotionView != null) && (findMotionView(i) == this.mMotionView))
          {
            if (paramMotionEvent.getX() < this.mMotionView.getWidth() - this.mDeleteAreaWidth) {
              continue;
            }
            if ((this.mDeleteAreaHeight <= 0) || (this.mMotionView.getHeight() <= 0)) {
              break label353;
            }
            i = this.mMotionView.getTop() + this.mMotionView.getHeight() / 2;
            int j = this.mDeleteAreaHeight / 2;
            int k = this.mDeleteAreaHeight / 2;
            if ((this.mDownY <= j + i) && (this.mDownY >= i - k)) {
              break label353;
            }
            if (QLog.isColorLevel()) {
              QLog.d("SlideDetectListView", 2, "accurate in delete:ycenter:" + i + ",motionheight:" + this.mMotionView.getHeight() + "deleareaHeight:" + this.mDeleteAreaHeight);
            }
          }
        }
      }
    }
    label353:
    for (int i = 0; i != 0; i = 1)
    {
      this.mHasDeleteDown = true;
      return false;
      if (this.mHasSlide != true) {
        break;
      }
      return true;
      this.mHasSlideBanner = false;
      break;
      if ((this.mDownY == 0) || (this.mHasSlide == true)) {
        return true;
      }
      if (this.mHasSlideBanner) {
        break label96;
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    while ((this.mDownY == 0) || (this.mHasSlide == true))
    {
      setPressed(false);
      if (this.mMotionView != null) {
        this.mMotionView.setPressed(false);
      }
      return true;
      this.fy = paramMotionEvent.getY();
      if (this.mHasSlide == true)
      {
        if (this.mMotionView != null)
        {
          this.mMotionView.setPressed(false);
          if (this.mSlideListener != null) {
            this.mSlideListener.onSlideCancelled(this, this.mMotionView, this.mMotionViewPosition - getHeaderViewsCount());
          }
        }
        this.mHasSlide = false;
        this.mMotionView = null;
        return false;
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean removeFooterView(View paramView)
  {
    this.mHeaderFooterHashList.remove(Integer.valueOf(paramView.hashCode()));
    return super.removeFooterView(paramView);
  }
  
  public boolean removeHeaderView(View paramView)
  {
    this.mHeaderFooterHashList.remove(Integer.valueOf(paramView.hashCode()));
    return super.removeHeaderView(paramView);
  }
  
  public void resetSlideStatus()
  {
    this.mDownY = 0;
    this.mHasSlide = false;
    this.mMotionView = null;
    this.mHasDeleteDown = false;
  }
  
  public void setCanSlide(boolean paramBoolean)
  {
    this.mCanSlide = paramBoolean;
  }
  
  public void setCheckStateWhenSlide(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.mNotCheckStateWhenSlide = paramBoolean;
      return;
    }
  }
  
  public void setDeleteAreaDim(int paramInt1, int paramInt2)
  {
    this.mDeleteAreaWidth = paramInt1;
    this.mDeleteAreaHeight = paramInt2;
  }
  
  public void setDeleteAreaWidth(int paramInt)
  {
    this.mDeleteAreaWidth = paramInt;
  }
  
  public void setMotionView(View paramView, int paramInt)
  {
    this.mMotionView = paramView;
    this.mMotionViewPosition = (getHeaderViewsCount() + paramInt);
    if (this.mMotionView != null) {
      this.mHasSlide = true;
    }
  }
  
  public void setOnScrollGroupFloatingListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.mScrollGFListener = paramOnScrollListener;
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener) {}
  
  public void setOnScrollToTopListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.mScrollToTopListener = paramOnScrollListener;
  }
  
  public void setOnSlideListener(SlideDetectListView.OnSlideListener paramOnSlideListener)
  {
    this.mSlideListener = paramOnSlideListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SlideDetectListView
 * JD-Core Version:    0.7.0.1
 */