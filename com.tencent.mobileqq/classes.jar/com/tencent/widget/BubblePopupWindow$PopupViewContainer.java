package com.tencent.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

class BubblePopupWindow$PopupViewContainer
  extends FrameLayout
{
  private static final String TAG = "PopupWindow.PopupViewContainer";
  View pressedView = null;
  
  public BubblePopupWindow$PopupViewContainer(BubblePopupWindow paramBubblePopupWindow, Context paramContext)
  {
    super(paramContext);
  }
  
  private View findPressedView(View paramView)
  {
    if (paramView.isPressed()) {
      return paramView;
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = 0;
      while (i < paramView.getChildCount())
      {
        View localView = findPressedView(paramView.getChildAt(i));
        if (localView != null) {
          return localView;
        }
        i += 1;
      }
    }
    return null;
  }
  
  private void getRectOnParent(View paramView1, View paramView2, Rect paramRect)
  {
    if (paramView1 == paramView2) {
      return;
    }
    paramRect.top += paramView1.getTop();
    paramRect.bottom += paramView1.getTop();
    paramRect.left += paramView1.getLeft();
    paramRect.right += paramView1.getLeft();
    getRectOnParent((View)paramView1.getParent(), paramView2, paramRect);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getKeyCode() == 4)
    {
      if (getKeyDispatcherState() == null) {
        return super.dispatchKeyEvent(paramKeyEvent);
      }
      KeyEvent.DispatcherState localDispatcherState;
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
      {
        localDispatcherState = getKeyDispatcherState();
        if (localDispatcherState != null) {
          localDispatcherState.startTracking(paramKeyEvent, this);
        }
        return true;
      }
      if (paramKeyEvent.getAction() == 1)
      {
        localDispatcherState = getKeyDispatcherState();
        if ((localDispatcherState != null) && (localDispatcherState.isTracking(paramKeyEvent)) && (!paramKeyEvent.isCanceled()))
        {
          if (BubblePopupWindow.access$700(this.this$0) != null) {
            BubblePopupWindow.access$700(this.this$0).onKeyBack();
          }
          this.this$0.dismiss();
          return true;
        }
      }
      return super.dispatchKeyEvent(paramKeyEvent);
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((BubblePopupWindow.access$800(this.this$0) != null) && (BubblePopupWindow.access$800(this.this$0).onTouch(this, paramMotionEvent))) {
      return true;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    if (BubblePopupWindow.access$100(this.this$0) == null) {
      return bool;
    }
    View localView = findPressedView(BubblePopupWindow.access$900(this.this$0));
    int i;
    if ((this.pressedView == null) && (localView == null))
    {
      i = 0;
    }
    else
    {
      this.pressedView = localView;
      localView = this.pressedView;
      if (localView != null)
      {
        localView.scrollTo(0, 0);
        this.pressedView.getDrawingRect(BubblePopupWindow.access$1000(this.this$0));
        getRectOnParent(this.pressedView, BubblePopupWindow.access$900(this.this$0), BubblePopupWindow.access$1000(this.this$0));
        int j;
        if (BubblePopupWindow.access$1000(this.this$0).left == 0) {
          j = 1;
        } else {
          j = 0;
        }
        int k;
        if (BubblePopupWindow.access$1000(this.this$0).right == BubblePopupWindow.access$900(this.this$0).getWidth())
        {
          i = BubblePopupWindow.access$100(this.this$0).getWidth();
          k = 1;
        }
        else
        {
          k = 0;
          i = 0;
        }
        int m;
        if ((j != 0) && (k != 0))
        {
          m = 0;
        }
        else
        {
          this.pressedView.getDrawingRect(BubblePopupWindow.access$1000(this.this$0));
          getRectOnParent(this.pressedView, BubblePopupWindow.access$1100(this.this$0), BubblePopupWindow.access$1000(this.this$0));
          if (j == 0) {
            j = BubblePopupWindow.access$1000(this.this$0).left;
          } else {
            j = 0;
          }
          m = j;
          if (k == 0)
          {
            i = BubblePopupWindow.access$1000(this.this$0).right;
            m = j;
          }
        }
        BubblePopupWindow.access$1200(this.this$0).setClipRange(m, i);
        BubblePopupWindow.access$1400(this.this$0).setClipRange(m - BubblePopupWindow.access$1300(this.this$0).getLeft(), i - BubblePopupWindow.access$1300(this.this$0).getLeft());
        BubblePopupWindow.access$1600(this.this$0).setClipRange(m - BubblePopupWindow.access$1500(this.this$0).getLeft(), i - BubblePopupWindow.access$1500(this.this$0).getLeft());
        i = 0;
      }
      else
      {
        BubblePopupWindow.access$1200(this.this$0).setClipRange(0, 0);
        BubblePopupWindow.access$1400(this.this$0).setClipRange(0, 0);
        BubblePopupWindow.access$1600(this.this$0).setClipRange(0, 0);
        i = 1;
      }
      BubblePopupWindow.access$1100(this.this$0).invalidate();
    }
    if ((i == 0) && ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)))
    {
      BubblePopupWindow.access$1200(this.this$0).setClipRange(0, 0);
      BubblePopupWindow.access$1400(this.this$0).setClipRange(0, 0);
      BubblePopupWindow.access$1600(this.this$0).setClipRange(0, 0);
      BubblePopupWindow.access$1100(this.this$0).invalidate();
    }
    return bool;
  }
  
  @TargetApi(8)
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.this$0.dismiss();
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    if (BubblePopupWindow.access$500(this.this$0))
    {
      int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
      View.mergeDrawableStates(arrayOfInt, BubblePopupWindow.access$600());
      return arrayOfInt;
    }
    return super.onCreateDrawableState(paramInt);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    if ((paramMotionEvent.getAction() == 0) && ((i < 0) || (i >= getWidth()) || (j < 0) || (j >= getHeight())))
    {
      this.this$0.dismiss();
      return true;
    }
    if (paramMotionEvent.getAction() == 4)
    {
      this.this$0.dismiss();
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void sendAccessibilityEvent(int paramInt)
  {
    if (BubblePopupWindow.access$900(this.this$0) != null)
    {
      BubblePopupWindow.access$900(this.this$0).sendAccessibilityEvent(paramInt);
      return;
    }
    super.sendAccessibilityEvent(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.BubblePopupWindow.PopupViewContainer
 * JD-Core Version:    0.7.0.1
 */