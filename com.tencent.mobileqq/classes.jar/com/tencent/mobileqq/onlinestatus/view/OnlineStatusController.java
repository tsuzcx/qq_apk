package com.tencent.mobileqq.onlinestatus.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Scroller;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public class OnlineStatusController
  extends LinearLayout
{
  boolean a = false;
  private float b = -3.402824E+038F;
  private boolean c = false;
  private boolean d = true;
  private Scroller e;
  private boolean f = false;
  private int g = 1;
  private int h = 0;
  private boolean i = false;
  private OnlineStatusController.PanelTouchListener j;
  
  public OnlineStatusController(Context paramContext)
  {
    super(paramContext);
  }
  
  public OnlineStatusController(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public OnlineStatusController(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.e = new Scroller(getContext());
  }
  
  public static boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView == null) {
      return false;
    }
    int k = (int)paramMotionEvent.getRawY();
    int m = (int)paramMotionEvent.getRawX();
    paramMotionEvent = new int[2];
    paramView.getLocationOnScreen(paramMotionEvent);
    int n = paramMotionEvent[0];
    int i1 = paramMotionEvent[1];
    int i2 = paramView.getMeasuredWidth();
    int i3 = paramView.getMeasuredHeight();
    return (k >= i1) && (k <= i3 + i1) && (m >= n) && (m <= i2 + n);
  }
  
  private boolean b(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.c) {
      return true;
    }
    if ((this.d) && (!a(paramView, paramMotionEvent))) {
      return false;
    }
    this.c = true;
    return true;
  }
  
  private int getMaxScrollDistance()
  {
    int k = 0;
    int n;
    for (int m = 0; k < getChildCount(); m = n)
    {
      View localView = getChildAt(k);
      n = m;
      if (localView.getVisibility() == 0) {
        n = m + localView.getHeight();
      }
      k += 1;
    }
    this.h = m;
    return m / 3;
  }
  
  public float a(float paramFloat)
  {
    float f1;
    if (this.a) {
      f1 = 0.0F;
    } else {
      f1 = 20.0F;
    }
    int k = ViewUtils.dpToPx(f1);
    int m = (int)(getScrollY() + paramFloat);
    if (m < k) {
      return paramFloat;
    }
    if (m >= k)
    {
      OnlineStatusController.PanelTouchListener localPanelTouchListener = this.j;
      if (localPanelTouchListener != null) {
        localPanelTouchListener.d();
      }
      return k - getScrollY();
    }
    return 0.0F;
  }
  
  public void a(int paramInt)
  {
    Scroller localScroller = this.e;
    if (localScroller != null)
    {
      localScroller.startScroll(0, getScrollY(), 0, paramInt - getScrollY());
      invalidate();
      return;
    }
    scrollTo(0, paramInt);
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    Object localObject = this.e;
    if ((localObject != null) && (((Scroller)localObject).computeScrollOffset()))
    {
      scrollTo(this.e.getCurrX(), this.e.getCurrY());
      invalidate();
      return;
    }
    if (this.f)
    {
      this.f = false;
      localObject = this.j;
      if (localObject != null) {
        ((OnlineStatusController.PanelTouchListener)localObject).a(this.g);
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    if (!b(getChildAt(0), paramMotionEvent)) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    float f1 = paramMotionEvent.getY();
    int k = paramMotionEvent.getAction();
    if (k != 0)
    {
      if (k != 1) {
        if (k != 2)
        {
          if (k != 3) {
            return false;
          }
        }
        else
        {
          float f2 = this.b;
          if (f2 == -3.402824E+038F)
          {
            this.b = f1;
            return super.dispatchTouchEvent(paramMotionEvent);
          }
          f2 = -(f1 - f2);
          float f3 = a(f2);
          if (QLog.isColorLevel())
          {
            paramMotionEvent = new StringBuilder();
            paramMotionEvent.append("NKSS=");
            paramMotionEvent.append(f3);
            paramMotionEvent.append(" differ=");
            paramMotionEvent.append(f2);
            QLog.d("UUUU", 2, paramMotionEvent.toString());
          }
          if ((this.c) && (f3 != 0.0F)) {
            scrollBy(0, (int)f3);
          } else if (f3 > 0.0F) {
            scrollBy(0, (int)f3);
          }
          if (Math.abs(f2) > 5.0F) {
            this.i = true;
          }
          paramMotionEvent = this.j;
          if (paramMotionEvent != null)
          {
            if (getScrollY() > 0) {
              bool = true;
            }
            paramMotionEvent.a(bool);
          }
          this.b = f1;
          return true;
        }
      }
      this.c = false;
      this.b = -3.402824E+038F;
      if (!this.i) {
        return super.dispatchTouchEvent(paramMotionEvent);
      }
      paramMotionEvent.setAction(3);
      super.dispatchTouchEvent(paramMotionEvent);
      if (-getScrollY() < getMaxScrollDistance()) {
        k = 1;
      } else {
        k = 0;
      }
      if (k == 1)
      {
        a(0);
        return false;
      }
      if (this.j != null)
      {
        this.f = true;
        a(-this.h);
      }
      return false;
    }
    this.i = false;
    this.b = paramMotionEvent.getY();
    super.dispatchTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setAtPanelTouchListener(OnlineStatusController.PanelTouchListener paramPanelTouchListener)
  {
    this.j = paramPanelTouchListener;
  }
  
  public void setDisableMinScrollY(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void setMode(int paramInt)
  {
    this.g = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.OnlineStatusController
 * JD-Core Version:    0.7.0.1
 */