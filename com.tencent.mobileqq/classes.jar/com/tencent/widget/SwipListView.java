package com.tencent.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListAdapter;
import android.widget.Scroller;
import benm;
import benn;
import beno;

public class SwipListView
  extends XListView
  implements Handler.Callback
{
  private byte jdField_a_of_type_Byte;
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private View jdField_a_of_type_AndroidViewView;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private benm jdField_a_of_type_Benm;
  private beno jdField_a_of_type_Beno;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private int d;
  private int e;
  private int f;
  private final int g;
  
  public SwipListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwipListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public SwipListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext, new benn());
    paramContext = ViewConfiguration.get(getContext());
    this.g = paramContext.getScaledTouchSlop();
    this.e = (paramContext.getScaledMinimumFlingVelocity() * 4);
    this.jdField_a_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.d = -1;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  private int a()
  {
    this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
    return (int)this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity();
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int i = 300;
    if (paramInt1 > 0) {
      i = (int)(Math.abs(paramInt2) / paramInt1 * 300.0F) + 50;
    }
    return i;
  }
  
  private void a()
  {
    int i = a();
    int j = this.jdField_b_of_type_AndroidViewView.getScrollX();
    if (i > this.e)
    {
      c(this.jdField_b_of_type_AndroidViewView);
      return;
    }
    if (i < -this.e)
    {
      d(this.jdField_b_of_type_AndroidViewView);
      return;
    }
    if ((i > 0) && (j < this.f * 0.7F))
    {
      c(this.jdField_b_of_type_AndroidViewView);
      return;
    }
    if ((i < 0) && (j > this.f * 0.3F))
    {
      d(this.jdField_b_of_type_AndroidViewView);
      return;
    }
    if ((this.jdField_b_of_type_Boolean) && (j < this.f * 0.7F))
    {
      c(this.jdField_b_of_type_AndroidViewView);
      return;
    }
    if (j > this.f * 0.3F)
    {
      d(this.jdField_b_of_type_AndroidViewView);
      return;
    }
    c(this.jdField_b_of_type_AndroidViewView);
  }
  
  private void a(int paramInt1, int paramInt2, View paramView, int paramInt3)
  {
    paramInt2 = this.jdField_c_of_type_Int;
    paramInt1 = paramView.getScrollX() - (paramInt1 - paramInt2);
    if (paramInt1 > paramInt3) {}
    for (;;)
    {
      paramView.scrollTo(paramInt3, 0);
      return;
      if (paramInt1 < 0) {
        paramInt3 = 0;
      } else {
        paramInt3 = paramInt1;
      }
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
  }
  
  private boolean a(float paramFloat)
  {
    return paramFloat < getWidth() - this.f;
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 > this.g) || (paramFloat2 > this.g))
    {
      if ((paramFloat1 > this.g) && (paramFloat2 / paramFloat1 < 0.6F))
      {
        this.jdField_a_of_type_Byte = 1;
        return true;
      }
      this.jdField_a_of_type_Byte = 2;
      return true;
    }
    return false;
  }
  
  private boolean a(View paramView)
  {
    return (paramView != null) && (paramView.getScrollX() >= this.g);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    this.jdField_c_of_type_AndroidViewView = null;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  private void c(View paramView)
  {
    if (paramView != null) {}
    for (int i = paramView.getScrollX();; i = 0)
    {
      if (this.jdField_a_of_type_Beno != null) {
        this.jdField_a_of_type_Beno.a_(null);
      }
      if (i != 0) {
        if (!(paramView.getTag(-3) instanceof Integer)) {
          break label139;
        }
      }
      label139:
      for (int j = ((Integer)paramView.getTag(-3)).intValue();; j = 0)
      {
        if ((this.jdField_c_of_type_AndroidViewView != paramView) && (this.jdField_c_of_type_AndroidViewView != null)) {
          this.jdField_c_of_type_AndroidViewView.scrollTo(0, 0);
        }
        b();
        this.jdField_c_of_type_AndroidViewView = paramView;
        int k = -i;
        this.jdField_a_of_type_AndroidWidgetScroller.startScroll(i, 0, k, 0, a(j, k));
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
        do
        {
          return;
        } while (this.jdField_a_of_type_Benm == null);
        this.jdField_a_of_type_Benm.b(paramView);
        return;
      }
    }
  }
  
  private void d(View paramView)
  {
    int j;
    if (paramView != null)
    {
      j = paramView.getScrollX();
      i = j;
      if (this.jdField_a_of_type_Beno != null) {
        this.jdField_a_of_type_Beno.a_(paramView);
      }
    }
    for (int i = j;; i = 0)
    {
      j = this.f;
      if ((j == 0) && (paramView != null) && ((paramView.getTag(-3) instanceof Integer))) {
        j = ((Integer)paramView.getTag(-3)).intValue();
      }
      for (;;)
      {
        if (i != j)
        {
          if ((this.jdField_c_of_type_AndroidViewView != paramView) && (this.jdField_c_of_type_AndroidViewView != null)) {
            this.jdField_c_of_type_AndroidViewView.scrollTo(0, 0);
          }
          b();
          this.jdField_c_of_type_AndroidViewView = paramView;
          k = j - i;
          this.jdField_a_of_type_AndroidWidgetScroller.startScroll(i, 0, k, 0, a(j, k));
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
        }
        while (this.jdField_a_of_type_Benm == null)
        {
          int k;
          return;
        }
        this.jdField_a_of_type_Benm.a(paramView);
        return;
      }
    }
  }
  
  public void a(View paramView)
  {
    t();
    d(paramView);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = true;
    switch (paramMessage.what)
    {
    default: 
      bool = false;
    }
    do
    {
      return bool;
      bool = this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset();
      float f1 = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
      if ((this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView.getScrollX() < (int)f1))
      {
        this.jdField_c_of_type_AndroidViewView.scrollTo((int)f1, 0);
        invalidate();
      }
      if (bool)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
        return true;
      }
      if (this.jdField_a_of_type_Benm != null) {
        this.jdField_a_of_type_Benm.a(this.jdField_c_of_type_AndroidViewView);
      }
      this.jdField_c_of_type_AndroidViewView = null;
      return true;
      bool = this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset();
      f1 = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
      if ((this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView.getScrollX() > (int)f1))
      {
        this.jdField_c_of_type_AndroidViewView.scrollTo((int)f1, 0);
        invalidate();
      }
      if (bool)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
        return true;
      }
      if (this.jdField_a_of_type_Benm != null) {
        this.jdField_a_of_type_Benm.b(this.jdField_c_of_type_AndroidViewView);
      }
      this.jdField_c_of_type_AndroidViewView = null;
      return true;
    } while (this.jdField_a_of_type_Beno == null);
    this.jdField_a_of_type_Beno.e();
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2;
    if (!this.jdField_a_of_type_Boolean)
    {
      bool2 = super.onInterceptTouchEvent(paramMotionEvent);
      return bool2;
    }
    int j = (int)(paramMotionEvent.getX() + 0.5F);
    int i = (int)(paramMotionEvent.getY() + 0.5F);
    int k = paramMotionEvent.getAction();
    label72:
    boolean bool1;
    switch (k)
    {
    default: 
      bool1 = false;
      label75:
      if ((k == 0) && (this.jdField_b_of_type_Boolean))
      {
        if (this.jdField_a_of_type_Beno != null) {
          this.jdField_a_of_type_Beno.e(true);
        }
        b();
      }
      break;
    }
    for (;;)
    {
      bool2 = bool1;
      if (bool1) {
        break;
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
      this.jdField_a_of_type_Byte = 0;
      if (this.jdField_a_of_type_Beno != null) {
        this.jdField_a_of_type_Beno.a_(null);
      }
      this.jdField_a_of_type_Int = j;
      this.jdField_c_of_type_Int = j;
      this.jdField_b_of_type_Int = i;
      this.d = i;
      this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView;
      this.jdField_b_of_type_Boolean = a(this.jdField_a_of_type_AndroidViewView);
      int m;
      int n;
      if (!this.jdField_b_of_type_Boolean)
      {
        m = getFirstVisiblePosition();
        n = getHeaderViewsCount();
        i = getLastVisiblePosition();
      }
      for (;;)
      {
        if (i >= m - n)
        {
          View localView = getChildAt(i);
          this.jdField_b_of_type_Boolean = a(localView);
          if (this.jdField_b_of_type_Boolean) {
            this.jdField_a_of_type_AndroidViewView = localView;
          }
        }
        else
        {
          this.f = 0;
          this.jdField_b_of_type_AndroidViewView = null;
          i = this.jdField_b_of_type_Int;
          if (isOverscrollHeadVisiable()) {
            i = this.jdField_b_of_type_Int + getScrollY();
          }
          i = pointToPosition(this.jdField_a_of_type_Int, i);
          if (i >= 0)
          {
            this.jdField_b_of_type_AndroidViewView = getChildAt(i - getFirstVisiblePosition());
            if ((this.jdField_b_of_type_AndroidViewView != null) && ((this.jdField_b_of_type_AndroidViewView.getTag(-3) instanceof Integer))) {
              this.f = ((Integer)this.jdField_b_of_type_AndroidViewView.getTag(-3)).intValue();
            }
          }
          if ((!this.jdField_b_of_type_Boolean) || ((this.jdField_b_of_type_AndroidViewView == this.jdField_a_of_type_AndroidViewView) && (!a(j)))) {
            break label389;
          }
          bool1 = true;
          break;
        }
        i -= 1;
      }
      label389:
      bool1 = false;
      break label75;
      if (this.f <= 0) {
        break label72;
      }
      if (this.jdField_a_of_type_Byte == 0) {
        a(Math.abs(j - this.jdField_a_of_type_Int), Math.abs(i - this.jdField_b_of_type_Int));
      }
      if (this.jdField_a_of_type_Byte != 1) {
        break label72;
      }
      if (j < this.jdField_a_of_type_Int) {}
      for (bool2 = true;; bool2 = false)
      {
        bool1 = bool2;
        if (!bool2) {
          break;
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        bool1 = bool2;
        break;
      }
      if (this.jdField_b_of_type_Boolean) {
        c(this.jdField_a_of_type_AndroidViewView);
      }
      this.jdField_a_of_type_Int = -1;
      this.jdField_c_of_type_Int = -1;
      this.jdField_b_of_type_Int = -1;
      this.d = -1;
      break label72;
      if (((k == 1) || (k == 3)) && (this.jdField_a_of_type_Beno != null)) {
        this.jdField_a_of_type_Beno.e(false);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2;
    if (!this.jdField_a_of_type_Boolean)
    {
      bool2 = super.onTouchEvent(paramMotionEvent);
      return bool2;
    }
    a(paramMotionEvent);
    int i = (int)(paramMotionEvent.getX() + 0.5F);
    int j = (int)(paramMotionEvent.getY() + 0.5F);
    int k = paramMotionEvent.getAction();
    boolean bool1;
    switch (k)
    {
    default: 
      bool1 = false;
    case 0: 
    case 2: 
      for (;;)
      {
        if ((k == 0) && (this.jdField_b_of_type_Boolean))
        {
          if (this.jdField_a_of_type_Beno != null) {
            this.jdField_a_of_type_Beno.e(true);
          }
          label112:
          bool2 = bool1;
          if (bool1) {
            break;
          }
          return super.onTouchEvent(paramMotionEvent);
          if ((this.jdField_b_of_type_Boolean) && ((this.jdField_b_of_type_AndroidViewView != this.jdField_a_of_type_AndroidViewView) || (a(i)))) {}
          for (bool2 = true;; bool2 = false)
          {
            bool1 = bool2;
            if (!this.jdField_b_of_type_Boolean) {
              break;
            }
            bool1 = bool2;
            if (this.jdField_a_of_type_AndroidViewView == this.jdField_b_of_type_AndroidViewView) {
              break;
            }
            c(this.jdField_a_of_type_AndroidViewView);
            bool1 = bool2;
            break;
          }
          if (this.jdField_b_of_type_Boolean) {
            if ((this.jdField_b_of_type_AndroidViewView != this.jdField_a_of_type_AndroidViewView) || (a(i)))
            {
              bool2 = true;
              label234:
              bool1 = bool2;
              if (this.jdField_b_of_type_AndroidViewView == this.jdField_a_of_type_AndroidViewView)
              {
                if (this.jdField_a_of_type_Byte == 0)
                {
                  bool1 = bool2;
                  if (!a(Math.abs(i - this.jdField_a_of_type_Int), Math.abs(j - this.jdField_b_of_type_Int))) {
                    continue;
                  }
                }
                bool1 = bool2;
                if (this.jdField_a_of_type_Byte == 1)
                {
                  a(i, j, this.jdField_b_of_type_AndroidViewView, this.f);
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_Int = i;
      this.d = j;
      break;
      bool2 = false;
      break label234;
      if (this.f == 0)
      {
        bool1 = false;
      }
      else
      {
        if ((this.jdField_a_of_type_Byte == 0) && (!a(Math.abs(i - this.jdField_a_of_type_Int), Math.abs(j - this.jdField_b_of_type_Int))))
        {
          bool1 = false;
          break;
        }
        if (this.jdField_a_of_type_Byte == 1)
        {
          a(i, j, this.jdField_b_of_type_AndroidViewView, this.f);
          bool1 = true;
          continue;
          if (this.jdField_b_of_type_Boolean) {
            if ((this.jdField_b_of_type_AndroidViewView != this.jdField_a_of_type_AndroidViewView) || (a(i)))
            {
              bool2 = true;
              label446:
              bool1 = bool2;
              if (this.jdField_b_of_type_AndroidViewView == this.jdField_a_of_type_AndroidViewView)
              {
                if (this.jdField_a_of_type_Byte != 1) {
                  break label509;
                }
                a();
                bool1 = true;
              }
            }
          }
          for (;;)
          {
            c();
            this.jdField_a_of_type_Int = -1;
            this.jdField_c_of_type_Int = -1;
            this.jdField_b_of_type_Int = -1;
            this.d = -1;
            break;
            bool2 = false;
            break label446;
            label509:
            c(this.jdField_b_of_type_AndroidViewView);
            bool1 = bool2;
            continue;
            if (this.f == 0)
            {
              bool1 = false;
            }
            else
            {
              if (this.jdField_a_of_type_Byte == 1)
              {
                a();
                bool1 = true;
                continue;
                if (((k != 1) && (k != 3)) || (this.jdField_a_of_type_Beno == null)) {
                  break label112;
                }
                this.jdField_a_of_type_Beno.e(false);
                break label112;
              }
              bool1 = false;
            }
          }
        }
        else
        {
          bool1 = false;
        }
      }
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    super.setAdapter(paramListAdapter);
    if ((paramListAdapter instanceof beno)) {
      this.jdField_a_of_type_Beno = ((beno)paramListAdapter);
    }
  }
  
  public void setDragEnable(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (!this.jdField_a_of_type_Boolean) {
      t();
    }
  }
  
  public void setRightIconMenuListener(benm parambenm)
  {
    this.jdField_a_of_type_Benm = parambenm;
  }
  
  public void setSwipListListener(beno parambeno)
  {
    this.jdField_a_of_type_Beno = parambeno;
  }
  
  public void t()
  {
    int i;
    int j;
    if (!a(this.jdField_b_of_type_AndroidViewView))
    {
      i = getFirstVisiblePosition() - getHeaderViewsCount();
      j = getLastVisiblePosition();
    }
    for (;;)
    {
      if (i <= j)
      {
        View localView = getChildAt(i);
        if (a(localView)) {
          this.jdField_b_of_type_AndroidViewView = localView;
        }
      }
      else
      {
        c(this.jdField_b_of_type_AndroidViewView);
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.widget.SwipListView
 * JD-Core Version:    0.7.0.1
 */