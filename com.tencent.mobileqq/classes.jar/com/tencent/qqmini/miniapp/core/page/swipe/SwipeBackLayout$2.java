package com.tencent.qqmini.miniapp.core.page.swipe;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy;

class SwipeBackLayout$2
  extends ViewDragHelper.Callback
{
  SwipeBackLayout$2(SwipeBackLayout paramSwipeBackLayout) {}
  
  public int clampViewPositionHorizontal(View paramView, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      return 0;
    }
    return Math.min(paramInt1, SwipeBackLayout.access$500(this.this$0));
  }
  
  public int clampViewPositionVertical(View paramView, int paramInt1, int paramInt2)
  {
    int i = SwipeBackLayout.access$800(this.this$0).getScrollDirction();
    paramInt2 = 0;
    if (i == 2)
    {
      if (paramInt1 < 0) {
        return 0;
      }
      paramInt2 = Math.min(paramInt1, SwipeBackLayout.access$1000(this.this$0));
    }
    return paramInt2;
  }
  
  public int getViewHorizontalDragRange(View paramView)
  {
    return SwipeBackLayout.access$500(this.this$0);
  }
  
  public int getViewVerticalDragRange(View paramView)
  {
    return SwipeBackLayout.access$1000(this.this$0);
  }
  
  public void onViewPositionChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView = this.this$0;
    SwipeBackLayout.access$102(paramView, Math.abs(paramInt1 / (SwipeBackLayout.access$000(paramView).getWidth() + SwipeBackLayout.access$200(this.this$0).getIntrinsicWidth())));
    SwipeBackLayout.access$302(this.this$0, paramInt1);
    if ((SwipeBackLayout.access$400(this.this$0)) && (SwipeBackLayout.access$300(this.this$0) == SwipeBackLayout.access$500(this.this$0)) && (SwipeBackLayout.access$600(this.this$0) != null)) {
      SwipeBackLayout.access$600(this.this$0).onSwipeFinish();
    }
  }
  
  public void onViewReleased(View paramView, float paramFloat1, float paramFloat2, MotionEvent paramMotionEvent)
  {
    SwipeBackLayout.access$702(this.this$0, paramView);
    if (SwipeBackLayout.access$800(this.this$0).getScrollDirction() == 1) {
      if (SwipeBackLayout.access$300(this.this$0) >= SwipeBackLayout.access$500(this.this$0) / 10)
      {
        SwipeBackLayout.access$402(this.this$0, true);
        SwipeBackLayout.access$800(this.this$0).settleCapturedViewAt(SwipeBackLayout.access$500(this.this$0), paramView.getTop());
      }
      else
      {
        SwipeBackLayout.access$800(this.this$0).settleCapturedViewAt(0, paramView.getTop());
      }
    }
    if (this.this$0.mPageGuestProxy != null)
    {
      if (this.this$0.mPageGuestProxy.onViewReleasedAndNeedScrollOriginPosition(paramMotionEvent)) {
        SwipeBackLayout.access$800(this.this$0).settleCapturedViewAt(0, 0);
      } else if (SwipeBackLayout.access$800(this.this$0).getScrollDirction() == 2) {
        SwipeBackLayout.access$900(this.this$0, paramMotionEvent);
      }
    }
    else if (SwipeBackLayout.access$800(this.this$0).getScrollDirction() == 2) {
      SwipeBackLayout.access$900(this.this$0, paramMotionEvent);
    }
    this.this$0.invalidate();
  }
  
  public boolean tryCaptureView(View paramView, int paramInt)
  {
    return paramView == SwipeBackLayout.access$000(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.swipe.SwipeBackLayout.2
 * JD-Core Version:    0.7.0.1
 */