package com.tencent.mtt.hippy.views.scroll;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.ViewParent;
import android.widget.ScrollView;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.mtt.hippy.utils.PixelUtil;

public class HippyVerticalScrollView
  extends ScrollView
  implements HippyViewBase, HippyScrollView
{
  private boolean mDoneFlinging;
  private boolean mDragging;
  private boolean mFlingEnabled = true;
  private NativeGestureDispatcher mGestureDispatcher;
  private HippyOnScrollHelper mHippyOnScrollHelper = new HippyOnScrollHelper();
  private long mLastScrollEventTimeStamp = -1L;
  private int mLastY = 0;
  private boolean mMomentumScrollBeginEventEnable = false;
  private boolean mMomentumScrollEndEventEnable = false;
  private boolean mPagingEnabled = false;
  private boolean mScrollAnimationEndEventEnable = false;
  private boolean mScrollBeginDragEventEnable = false;
  private boolean mScrollEnabled = true;
  private boolean mScrollEndDragEventEnable = false;
  private boolean mScrollEventEnable = true;
  protected int mScrollEventThrottle = 400;
  protected int mScrollMinOffset = 0;
  
  public HippyVerticalScrollView(Context paramContext)
  {
    super(paramContext);
    setVerticalScrollBarEnabled(false);
  }
  
  private void setParentScrollableIfNeed(boolean paramBoolean)
  {
    if ((canScrollVertically(-1)) || (canScrollVertically(1))) {
      getParent().requestDisallowInterceptTouchEvent(paramBoolean ^ true);
    }
  }
  
  private void smoothScrollToPage(int paramInt)
  {
    int k = getHeight();
    int m = getScrollY();
    int i;
    if (k != 0) {
      i = m / k;
    } else {
      i = 0;
    }
    int j = i;
    if (paramInt + m > i * k + k / 2) {
      j = i + 1;
    }
    smoothScrollTo(getScrollX(), j * k);
  }
  
  public void callSmoothScrollTo(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 > 0)
    {
      ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { getScrollY(), paramInt2 });
      localValueAnimator.setDuration(paramInt3);
      localValueAnimator.addUpdateListener(new HippyVerticalScrollView.1(this, paramInt1));
      localValueAnimator.start();
      return;
    }
    smoothScrollTo(paramInt1, paramInt2);
  }
  
  public void computeScroll()
  {
    super.computeScroll();
  }
  
  public void fling(int paramInt)
  {
    if (!this.mFlingEnabled) {
      return;
    }
    if (this.mPagingEnabled) {
      smoothScrollToPage(paramInt);
    } else {
      super.fling(paramInt);
    }
    if (this.mMomentumScrollBeginEventEnable) {
      HippyScrollViewEventHelper.emitScrollMomentumBeginEvent(this);
    }
    HippyVerticalScrollView.2 local2 = new HippyVerticalScrollView.2(this);
    if (Build.VERSION.SDK_INT >= 16)
    {
      postOnAnimationDelayed(local2, 20L);
      return;
    }
    getHandler().postDelayed(local2, 20L);
  }
  
  public NativeGestureDispatcher getGestureDispatcher()
  {
    return this.mGestureDispatcher;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.mScrollEnabled) {
      return false;
    }
    if (super.onInterceptTouchEvent(paramMotionEvent))
    {
      if (this.mScrollBeginDragEventEnable) {
        HippyScrollViewEventHelper.emitScrollBeginDragEvent(this);
      }
      this.mDragging = true;
      return true;
    }
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    scrollTo(getScrollX(), getScrollY());
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mHippyOnScrollHelper.onScrollChanged(paramInt1, paramInt2))
    {
      if (this.mScrollEventEnable)
      {
        long l = System.currentTimeMillis();
        paramInt1 = Math.abs(paramInt2 - this.mLastY);
        paramInt3 = this.mScrollMinOffset;
        if ((paramInt3 > 0) && (paramInt1 >= paramInt3))
        {
          this.mLastY = paramInt2;
        }
        else
        {
          if ((this.mScrollMinOffset != 0) || (l - this.mLastScrollEventTimeStamp < this.mScrollEventThrottle)) {
            break label101;
          }
          this.mLastScrollEventTimeStamp = l;
        }
        HippyScrollViewEventHelper.emitScrollEvent(this);
        break label102;
        label101:
        return;
      }
      label102:
      this.mDoneFlinging = false;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    boolean bool1 = false;
    if ((i == 0) && (!this.mDragging))
    {
      this.mDragging = true;
      if (this.mScrollBeginDragEventEnable) {
        HippyScrollViewEventHelper.emitScrollBeginDragEvent(this);
      }
      setParentScrollableIfNeed(false);
    }
    else if ((i == 1) && (this.mDragging))
    {
      if (this.mScrollEndDragEventEnable) {
        HippyScrollViewEventHelper.emitScrollEndDragEvent(this);
      }
      setParentScrollableIfNeed(true);
      this.mDragging = false;
    }
    if (this.mScrollEnabled) {
      bool1 = super.onTouchEvent(paramMotionEvent);
    }
    NativeGestureDispatcher localNativeGestureDispatcher = this.mGestureDispatcher;
    boolean bool2 = bool1;
    if (localNativeGestureDispatcher != null) {
      bool2 = bool1 | localNativeGestureDispatcher.handleTouchEvent(paramMotionEvent);
    }
    return bool2;
  }
  
  public void setContentOffset4Reuse(HippyMap paramHippyMap)
  {
    scrollTo(0, (int)PixelUtil.dp2px(paramHippyMap.getDouble("y")));
  }
  
  public void setFlingEnabled(boolean paramBoolean)
  {
    this.mFlingEnabled = paramBoolean;
  }
  
  public void setGestureDispatcher(NativeGestureDispatcher paramNativeGestureDispatcher)
  {
    this.mGestureDispatcher = paramNativeGestureDispatcher;
  }
  
  public void setMomentumScrollBeginEventEnable(boolean paramBoolean)
  {
    this.mMomentumScrollBeginEventEnable = paramBoolean;
  }
  
  public void setMomentumScrollEndEventEnable(boolean paramBoolean)
  {
    this.mMomentumScrollEndEventEnable = paramBoolean;
  }
  
  public void setPagingEnabled(boolean paramBoolean)
  {
    this.mPagingEnabled = paramBoolean;
  }
  
  public void setScrollAnimationEndEventEnable(boolean paramBoolean)
  {
    this.mScrollAnimationEndEventEnable = paramBoolean;
  }
  
  public void setScrollBeginDragEventEnable(boolean paramBoolean)
  {
    this.mScrollBeginDragEventEnable = paramBoolean;
  }
  
  public void setScrollEnabled(boolean paramBoolean)
  {
    this.mScrollEnabled = paramBoolean;
  }
  
  public void setScrollEndDragEventEnable(boolean paramBoolean)
  {
    this.mScrollEndDragEventEnable = paramBoolean;
  }
  
  public void setScrollEventEnable(boolean paramBoolean)
  {
    this.mScrollEventEnable = paramBoolean;
  }
  
  public void setScrollEventThrottle(int paramInt)
  {
    this.mScrollEventThrottle = paramInt;
  }
  
  public void setScrollMinOffset(int paramInt)
  {
    this.mScrollMinOffset = ((int)PixelUtil.dp2px(Math.max(5, paramInt)));
  }
  
  public void showScrollIndicator(boolean paramBoolean)
  {
    setVerticalScrollBarEnabled(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.scroll.HippyVerticalScrollView
 * JD-Core Version:    0.7.0.1
 */