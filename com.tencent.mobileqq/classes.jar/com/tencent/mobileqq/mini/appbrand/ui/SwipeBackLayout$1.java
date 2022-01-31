package com.tencent.mobileqq.mini.appbrand.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import aobv;
import aobx;
import aocf;
import aofy;
import azqs;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.swipeback.PostTable;
import mqq.os.MqqHandler;

class SwipeBackLayout$1
  extends ViewDragHelper.Callback
{
  SwipeBackLayout$1(SwipeBackLayout paramSwipeBackLayout) {}
  
  public int clampViewPositionHorizontal(View paramView, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      return 0;
    }
    return Math.min(paramInt1, SwipeBackLayout.access$400(this.this$0));
  }
  
  public int clampViewPositionVertical(View paramView, int paramInt1, int paramInt2)
  {
    if ((SwipeBackLayout.access$700(this.this$0).getScrollDirction() != 2) || (paramInt1 < 0)) {
      return 0;
    }
    return Math.min(paramInt1, SwipeBackLayout.access$1700(this.this$0));
  }
  
  public int getViewHorizontalDragRange(View paramView)
  {
    return SwipeBackLayout.access$400(this.this$0);
  }
  
  public int getViewVerticalDragRange(View paramView)
  {
    return SwipeBackLayout.access$1700(this.this$0);
  }
  
  public void onViewPositionChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    SwipeBackLayout.access$002(this.this$0, Math.abs(paramInt1 / (this.this$0.mChildView.getWidth() + SwipeBackLayout.access$100(this.this$0).getIntrinsicWidth())));
    SwipeBackLayout.access$202(this.this$0, paramInt1);
    if ((SwipeBackLayout.access$300(this.this$0)) && (SwipeBackLayout.access$200(this.this$0) == SwipeBackLayout.access$400(this.this$0)) && (SwipeBackLayout.access$500(this.this$0) != null)) {
      SwipeBackLayout.access$500(this.this$0).onSwipeFinish();
    }
  }
  
  public void onViewReleased(View paramView, float paramFloat1, float paramFloat2, MotionEvent paramMotionEvent)
  {
    SwipeBackLayout.access$602(this.this$0, paramView);
    if (SwipeBackLayout.access$700(this.this$0).getScrollDirction() == 1)
    {
      if (SwipeBackLayout.access$200(this.this$0) < SwipeBackLayout.access$400(this.this$0) / 10) {
        break label85;
      }
      SwipeBackLayout.access$302(this.this$0, true);
      SwipeBackLayout.access$700(this.this$0).settleCapturedViewAt(SwipeBackLayout.access$400(this.this$0), paramView.getTop());
    }
    while (this.this$0.isInternalApp)
    {
      return;
      label85:
      SwipeBackLayout.access$700(this.this$0).settleCapturedViewAt(0, paramView.getTop());
    }
    paramView = SwipeBackLayout.access$800(this.this$0);
    boolean bool;
    int j;
    int i;
    if (paramView != null)
    {
      bool = SwipeBackLayout.access$900(this.this$0).a(paramView.getServiceType(), paramView.getSubType());
      j = 0;
      SwipeBackLayout.access$1002(this.this$0, true);
      i = j;
      if (!SwipeBackLayout.access$1100(this.this$0).a(paramMotionEvent, this.this$0.getContext())) {
        break label376;
      }
      i = j;
      if (bool) {
        break label376;
      }
      i = j;
      if (paramView == null) {
        break label376;
      }
      if (!SwipeBackLayout.access$900(this.this$0).a()) {
        break label338;
      }
      paramView = paramView.parseBundle();
      paramView.putInt("color_note_curd_from_type", 1);
      SwipeBackLayout.access$900(this.this$0).a(paramView);
      azqs.b(null, "dc00898", "", "", "0X800A742", "0X800A742", aobv.a(SwipeBackLayout.access$1200(this.this$0).getColorNote().mServiceType), 0, "", "", "", "");
      i = 0;
      j = 1;
      label274:
      if (SwipeBackLayout.access$1300(this.this$0) != null)
      {
        SwipeBackLayout.access$1300(this.this$0).setVisibility(4);
        SwipeBackLayout.access$1402(this.this$0, false);
      }
      if (j == 0) {
        break label382;
      }
      ThreadManager.getUIHandler().post(new SwipeBackLayout.1.1(this));
    }
    for (;;)
    {
      this.this$0.invalidate();
      return;
      bool = false;
      break;
      label338:
      i = 1;
      SwipeBackLayout.access$1300(this.this$0).a(0.0D);
      azqs.b(null, "dc00898", "", "", "0X800A6CF", "0X800A6CF", 1, 0, "", "", "", "");
      label376:
      j = 0;
      break label274;
      label382:
      if (i != 0)
      {
        SwipeBackLayout.access$700(this.this$0).settleCapturedViewAt(0, 0);
        SwipeBackLayout.access$1500(this.this$0);
      }
      else if (SwipeBackLayout.access$700(this.this$0).getScrollDirction() == 2)
      {
        if (paramMotionEvent.getRawX() > SwipeBackLayout.access$400(this.this$0) / 2)
        {
          SwipeBackLayout.access$1600(this.this$0);
          SwipeBackLayout.access$302(this.this$0, true);
        }
        else
        {
          SwipeBackLayout.access$700(this.this$0).settleCapturedViewAt(0, 0);
        }
      }
    }
  }
  
  public boolean tryCaptureView(View paramView, int paramInt)
  {
    return paramView == this.this$0.mChildView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.SwipeBackLayout.1
 * JD-Core Version:    0.7.0.1
 */