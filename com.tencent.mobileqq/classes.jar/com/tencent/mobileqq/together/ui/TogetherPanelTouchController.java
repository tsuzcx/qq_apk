package com.tencent.mobileqq.together.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.troop.quickat.ui.AtPanelTouchController.AtPanelTouchListener;
import com.tencent.qphone.base.util.QLog;

public class TogetherPanelTouchController
  extends LinearLayout
{
  boolean a = false;
  private float b = -3.402824E+038F;
  private boolean c = false;
  private boolean d = true;
  private boolean e = false;
  private int f = 1;
  private Scroller g;
  private AtPanelTouchController.AtPanelTouchListener h;
  private int i = 0;
  private boolean j = false;
  private View k = null;
  
  public TogetherPanelTouchController(@NonNull Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public TogetherPanelTouchController(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public TogetherPanelTouchController(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.g = new Scroller(getContext());
  }
  
  public static boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView == null) {
      return false;
    }
    int m = (int)paramMotionEvent.getRawY();
    int n = (int)paramMotionEvent.getRawX();
    paramMotionEvent = new int[2];
    paramView.getLocationOnScreen(paramMotionEvent);
    int i1 = paramMotionEvent[0];
    int i2 = paramMotionEvent[1];
    int i3 = paramView.getMeasuredWidth();
    int i4 = paramView.getMeasuredHeight();
    return (m >= i2) && (m <= i4 + i2) && (n >= i1) && (n <= i3 + i1);
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
    int m = 0;
    int i1;
    for (int n = 0; m < getChildCount(); n = i1)
    {
      View localView = getChildAt(m);
      i1 = n;
      if (localView.getVisibility() == 0) {
        i1 = n + localView.getHeight();
      }
      m += 1;
    }
    this.i = n;
    return n / 3;
  }
  
  public float a(float paramFloat)
  {
    float f1;
    if (this.a) {
      f1 = 0.0F;
    } else {
      f1 = 20.0F;
    }
    int m = AIOUtils.b(f1, getContext().getResources());
    int n = (int)(getScrollY() + paramFloat);
    if (n < m) {
      return paramFloat;
    }
    if (n >= m)
    {
      AtPanelTouchController.AtPanelTouchListener localAtPanelTouchListener = this.h;
      if (localAtPanelTouchListener != null) {
        localAtPanelTouchListener.d();
      }
      return m - getScrollY();
    }
    return 0.0F;
  }
  
  public void a(int paramInt)
  {
    Scroller localScroller = this.g;
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
    Object localObject = this.g;
    if ((localObject != null) && (((Scroller)localObject).computeScrollOffset()))
    {
      scrollTo(this.g.getCurrX(), this.g.getCurrY());
      invalidate();
      return;
    }
    if (this.j)
    {
      this.j = false;
      localObject = this.h;
      if (localObject != null) {
        ((AtPanelTouchController.AtPanelTouchListener)localObject).a(this.f);
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    View localView2 = this.k;
    boolean bool = false;
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = getChildAt(0);
    }
    if (!b(localView1, paramMotionEvent)) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    float f1 = paramMotionEvent.getY();
    int m = paramMotionEvent.getAction();
    if (m != 0)
    {
      if (m != 1) {
        if (m != 2)
        {
          if (m != 3) {
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
            this.e = true;
          }
          paramMotionEvent = this.h;
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
      if (!this.e) {
        return super.dispatchTouchEvent(paramMotionEvent);
      }
      paramMotionEvent.setAction(3);
      super.dispatchTouchEvent(paramMotionEvent);
      if (-getScrollY() < getMaxScrollDistance()) {
        m = 1;
      } else {
        m = 0;
      }
      if (m == 1)
      {
        a(0);
        return false;
      }
      if (this.h != null)
      {
        this.j = true;
        a(-this.i);
      }
      return false;
    }
    this.e = false;
    this.b = paramMotionEvent.getY();
    super.dispatchTouchEvent(paramMotionEvent);
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setAtPanelTouchListener(AtPanelTouchController.AtPanelTouchListener paramAtPanelTouchListener)
  {
    this.h = paramAtPanelTouchListener;
  }
  
  public void setControlLitTongue(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setDisableMinScrollY(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void setHeadView(View paramView)
  {
    this.k = paramView;
  }
  
  public void setMode(int paramInt)
  {
    this.f = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.together.ui.TogetherPanelTouchController
 * JD-Core Version:    0.7.0.1
 */