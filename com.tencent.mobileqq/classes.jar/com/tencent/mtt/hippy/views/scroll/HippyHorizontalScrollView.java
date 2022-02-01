package com.tencent.mtt.hippy.views.scroll;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.supportui.views.ScrollChecker.IScrollCheck;

public class HippyHorizontalScrollView
  extends HorizontalScrollView
  implements HippyViewBase, HippyScrollView, ScrollChecker.IScrollCheck
{
  private boolean mDoneFlinging;
  private boolean mDragging;
  private boolean mFlingEnabled = true;
  private NativeGestureDispatcher mGestureDispatcher;
  private HippyOnScrollHelper mHippyOnScrollHelper = new HippyOnScrollHelper();
  private long mLastScrollEventTimeStamp = -1L;
  private int mLastX = 0;
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
  
  public HippyHorizontalScrollView(Context paramContext)
  {
    super(paramContext);
    setHorizontalScrollBarEnabled(false);
  }
  
  private void setParentScrollableIfNeed(boolean paramBoolean)
  {
    boolean bool = true;
    ViewParent localViewParent;
    if ((canScrollHorizontally(-1)) || (canScrollHorizontally(1)))
    {
      localViewParent = getParent();
      if (paramBoolean) {
        break label37;
      }
    }
    label37:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
      return;
    }
  }
  
  private void smoothScrollToPage(int paramInt)
  {
    int k = getWidth();
    int m = getScrollX();
    int i = 0;
    if (k != 0) {
      i = m / k;
    }
    int j = i;
    if (m + paramInt > i * k + k / 2) {
      j = i + 1;
    }
    smoothScrollTo(j * k, getScrollY());
  }
  
  public void callSmoothScrollTo(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 > 0)
    {
      ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { getScrollX(), paramInt1 });
      localValueAnimator.setDuration(paramInt3);
      localValueAnimator.addUpdateListener(new HippyHorizontalScrollView.1(this, paramInt2));
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
    }
    HippyHorizontalScrollView.2 local2;
    for (;;)
    {
      if (this.mMomentumScrollBeginEventEnable) {
        HippyScrollViewEventHelper.emitScrollMomentumBeginEvent(this);
      }
      local2 = new HippyHorizontalScrollView.2(this);
      if (Build.VERSION.SDK_INT < 16) {
        break;
      }
      postOnAnimationDelayed(local2, 20L);
      return;
      super.fling(paramInt);
    }
    getHandler().postDelayed(local2, 36L);
  }
  
  public NativeGestureDispatcher getGestureDispatcher()
  {
    return this.mGestureDispatcher;
  }
  
  public boolean horizontalCanScroll(int paramInt)
  {
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.mScrollEnabled) {}
    while (!super.onInterceptTouchEvent(paramMotionEvent)) {
      return false;
    }
    if (this.mScrollBeginDragEventEnable)
    {
      LogUtils.d("HippyHorizontalScrollView", "emitScrollBeginDragEvent");
      HippyScrollViewEventHelper.emitScrollBeginDragEvent(this);
    }
    this.mDragging = true;
    return true;
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
    long l;
    if (this.mHippyOnScrollHelper.onScrollChanged(paramInt1, paramInt2)) {
      if (this.mScrollEventEnable)
      {
        l = System.currentTimeMillis();
        paramInt2 = Math.abs(paramInt1 - this.mLastX);
        if ((this.mScrollMinOffset <= 0) || (paramInt2 < this.mScrollMinOffset)) {
          break label73;
        }
        this.mLastX = paramInt1;
      }
    }
    for (;;)
    {
      HippyScrollViewEventHelper.emitScrollEvent(this);
      this.mDoneFlinging = false;
      label73:
      do
      {
        return;
      } while ((this.mScrollMinOffset != 0) || (l - this.mLastScrollEventTimeStamp < this.mScrollEventThrottle));
      this.mLastScrollEventTimeStamp = l;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = false;
    int i = paramMotionEvent.getAction() & 0xFF;
    if ((i == 0) && (!this.mDragging))
    {
      this.mDragging = true;
      if (this.mScrollBeginDragEventEnable)
      {
        LogUtils.d("HippyHorizontalScrollView", "emitScrollBeginDragEvent");
        HippyScrollViewEventHelper.emitScrollBeginDragEvent(this);
      }
      setParentScrollableIfNeed(false);
    }
    for (;;)
    {
      if (this.mScrollEnabled) {
        bool1 = super.onTouchEvent(paramMotionEvent);
      }
      boolean bool2 = bool1;
      if (this.mGestureDispatcher != null) {
        bool2 = bool1 | this.mGestureDispatcher.handleTouchEvent(paramMotionEvent);
      }
      return bool2;
      if ((i == 1) && (this.mDragging))
      {
        if (this.mScrollEndDragEventEnable)
        {
          LogUtils.d("HippyHorizontalScrollView", "emitScrollEndDragEvent");
          HippyScrollViewEventHelper.emitScrollEndDragEvent(this);
        }
        this.mDragging = false;
        setParentScrollableIfNeed(true);
      }
    }
  }
  
  public void setContentOffset4Reuse(HippyMap paramHippyMap)
  {
    scrollTo((int)PixelUtil.dp2px(paramHippyMap.getDouble("x")), 0);
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
    setHorizontalScrollBarEnabled(paramBoolean);
  }
  
  public boolean verticalCanScroll(int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.scroll.HippyHorizontalScrollView
 * JD-Core Version:    0.7.0.1
 */