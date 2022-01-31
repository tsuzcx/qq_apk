package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.tencent.common.config.AppSetting;
import com.tencent.widget.ListView;

public class TroopSidesSlippingMaker
  implements Handler.Callback
{
  private byte jdField_a_of_type_Byte;
  private final int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private View jdField_a_of_type_AndroidViewView;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private TroopSidesSlippingMaker.SlidingListener jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SlidingListener;
  private TroopSidesSlippingMaker.SuperTouchListener jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SuperTouchListener;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public TroopSidesSlippingMaker(Context paramContext, ListView paramListView, TroopSidesSlippingMaker.SuperTouchListener paramSuperTouchListener)
  {
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SuperTouchListener = paramSuperTouchListener;
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext, new TroopSidesSlippingMaker.SmoothInterpolator());
    paramContext = ViewConfiguration.get(paramContext);
    this.jdField_a_of_type_Int = paramContext.getScaledTouchSlop();
    this.jdField_b_of_type_Int = (paramContext.getScaledMinimumFlingVelocity() * 4);
    this.d = -1;
    this.f = -1;
    this.e = -1;
    this.g = -1;
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
  
  private void a(int paramInt1, int paramInt2, View paramView, int paramInt3)
  {
    paramInt2 = this.f;
    paramInt1 = paramView.getScrollX() - (paramInt1 - paramInt2);
    if (paramInt1 > paramInt3) {}
    for (;;)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SlidingListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SlidingListener.a(true);
        }
        this.jdField_a_of_type_Boolean = true;
      }
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
  
  private void a(View paramView)
  {
    if (paramView != null) {}
    for (int i = paramView.getScrollX();; i = 0)
    {
      if (i != 0) {
        if (!(paramView.getTag(-3) instanceof Integer)) {
          break label104;
        }
      }
      label104:
      for (int j = ((Integer)paramView.getTag(-3)).intValue();; j = 0)
      {
        if ((this.jdField_c_of_type_AndroidViewView != paramView) && (this.jdField_c_of_type_AndroidViewView != null)) {
          this.jdField_c_of_type_AndroidViewView.scrollTo(0, 0);
        }
        c();
        this.jdField_c_of_type_AndroidViewView = paramView;
        int k = -i;
        this.jdField_a_of_type_AndroidWidgetScroller.startScroll(i, 0, k, 0, a(j, k));
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
        return;
      }
    }
  }
  
  private boolean a(float paramFloat)
  {
    return paramFloat < this.jdField_a_of_type_ComTencentWidgetListView.getWidth() - this.jdField_c_of_type_Int;
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 > this.jdField_a_of_type_Int) || (paramFloat2 > this.jdField_a_of_type_Int))
    {
      if ((paramFloat1 > this.jdField_a_of_type_Int) && (paramFloat2 / paramFloat1 < 0.6F))
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
    return (paramView != null) && (paramView.getScrollX() >= this.jdField_a_of_type_Int);
  }
  
  private void b()
  {
    int i = a();
    int j = this.jdField_b_of_type_AndroidViewView.getScrollX();
    if (i > this.jdField_b_of_type_Int)
    {
      a(this.jdField_b_of_type_AndroidViewView);
      return;
    }
    if (i < -this.jdField_b_of_type_Int)
    {
      b(this.jdField_b_of_type_AndroidViewView);
      return;
    }
    if ((i > 0) && (j < this.jdField_c_of_type_Int * 0.7F))
    {
      a(this.jdField_b_of_type_AndroidViewView);
      return;
    }
    if ((i < 0) && (j > this.jdField_c_of_type_Int * 0.3F))
    {
      b(this.jdField_b_of_type_AndroidViewView);
      return;
    }
    if ((this.jdField_c_of_type_Boolean) && (j < this.jdField_c_of_type_Int * 0.7F))
    {
      a(this.jdField_b_of_type_AndroidViewView);
      return;
    }
    if (j > this.jdField_c_of_type_Int * 0.3F)
    {
      b(this.jdField_b_of_type_AndroidViewView);
      return;
    }
    a(this.jdField_b_of_type_AndroidViewView);
  }
  
  private void b(View paramView)
  {
    if (paramView == null) {
      return;
    }
    int j = paramView.getScrollX();
    int i = this.jdField_c_of_type_Int;
    if ((i == 0) && ((paramView.getTag(-3) instanceof Integer))) {
      i = ((Integer)paramView.getTag(-3)).intValue();
    }
    for (;;)
    {
      if (j != i)
      {
        if ((this.jdField_c_of_type_AndroidViewView != paramView) && (this.jdField_c_of_type_AndroidViewView != null)) {
          this.jdField_c_of_type_AndroidViewView.scrollTo(0, 0);
        }
        c();
        this.jdField_c_of_type_AndroidViewView = paramView;
        int k = i - j;
        this.jdField_a_of_type_AndroidWidgetScroller.startScroll(j, 0, k, 0, a(i, k));
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SlidingListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SlidingListener.a(paramView);
      }
      if ((!AppSetting.jdField_b_of_type_Boolean) || (!(paramView instanceof LinearLayout))) {
        break;
      }
      paramView = (LinearLayout)paramView;
      paramView = paramView.getChildAt(paramView.getChildCount() - 1);
      if (paramView == null) {
        break;
      }
      paramView.sendAccessibilityEvent(8);
      return;
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    this.jdField_c_of_type_AndroidViewView = null;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentWidgetListView = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SlidingListener = null;
  }
  
  public void a(TroopSidesSlippingMaker.SlidingListener paramSlidingListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SlidingListener = paramSlidingListener;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool2;
    if (!this.jdField_b_of_type_Boolean)
    {
      bool2 = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SuperTouchListener.a(paramMotionEvent);
      return bool2;
    }
    int j = (int)(paramMotionEvent.getX() + 0.5F);
    int i = (int)(paramMotionEvent.getY() + 0.5F);
    int k = paramMotionEvent.getAction();
    label80:
    boolean bool1;
    switch (k)
    {
    default: 
      bool1 = false;
      label83:
      if ((k == 0) && (this.jdField_c_of_type_Boolean))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SlidingListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SlidingListener.a(true);
        }
        c();
      }
      break;
    }
    for (;;)
    {
      bool2 = bool1;
      if (bool1) {
        break;
      }
      return this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SuperTouchListener.a(paramMotionEvent);
      this.jdField_a_of_type_Byte = 0;
      this.d = j;
      this.f = j;
      this.e = i;
      this.g = i;
      this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView;
      this.jdField_c_of_type_Boolean = a(this.jdField_a_of_type_AndroidViewView);
      int m;
      int n;
      if (!this.jdField_c_of_type_Boolean)
      {
        m = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
        n = this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount();
        i = this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition();
      }
      for (;;)
      {
        if (i >= m - n)
        {
          View localView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i);
          this.jdField_c_of_type_Boolean = a(localView);
          if (this.jdField_c_of_type_Boolean) {
            this.jdField_a_of_type_AndroidViewView = localView;
          }
        }
        else
        {
          this.jdField_c_of_type_Int = 0;
          this.jdField_b_of_type_AndroidViewView = null;
          i = this.e;
          if (this.jdField_a_of_type_ComTencentWidgetListView.isOverscrollHeadVisiable()) {
            i = this.e + this.jdField_a_of_type_ComTencentWidgetListView.getScrollY();
          }
          i = this.jdField_a_of_type_ComTencentWidgetListView.pointToPosition(this.d, i);
          if (i >= 0)
          {
            this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i - this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition());
            if ((this.jdField_b_of_type_AndroidViewView != null) && ((this.jdField_b_of_type_AndroidViewView.getTag(-3) instanceof Integer))) {
              this.jdField_c_of_type_Int = ((Integer)this.jdField_b_of_type_AndroidViewView.getTag(-3)).intValue();
            }
          }
          if ((!this.jdField_c_of_type_Boolean) || ((this.jdField_b_of_type_AndroidViewView == this.jdField_a_of_type_AndroidViewView) && (!a(j)))) {
            break label412;
          }
          bool1 = true;
          break;
        }
        i -= 1;
      }
      label412:
      bool1 = false;
      break label83;
      if ((this.jdField_c_of_type_Int > 0) && (this.jdField_a_of_type_Byte == 0)) {
        a(Math.abs(j - this.d), Math.abs(i - this.e));
      }
      if (this.jdField_a_of_type_Byte != 1) {
        break label80;
      }
      if (j < this.d)
      {
        bool1 = true;
        break label83;
      }
      bool1 = false;
      break label83;
      if (this.jdField_c_of_type_Boolean) {
        a(this.jdField_a_of_type_AndroidViewView);
      }
      this.d = -1;
      this.f = -1;
      this.e = -1;
      this.g = -1;
      break label80;
      if (((k == 1) || (k == 3)) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SlidingListener != null)) {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SlidingListener.a(false);
      }
    }
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    boolean bool2;
    if (!this.jdField_b_of_type_Boolean)
    {
      bool2 = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SuperTouchListener.b(paramMotionEvent);
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
        if ((k == 0) && (this.jdField_c_of_type_Boolean))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SlidingListener != null) {
            this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SlidingListener.a(true);
          }
          label116:
          bool2 = bool1;
          if (bool1) {
            break;
          }
          return this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SuperTouchListener.b(paramMotionEvent);
          if ((this.jdField_c_of_type_Boolean) && ((this.jdField_b_of_type_AndroidViewView != this.jdField_a_of_type_AndroidViewView) || (a(i)))) {}
          for (bool2 = true;; bool2 = false)
          {
            bool1 = bool2;
            if (!this.jdField_c_of_type_Boolean) {
              break;
            }
            bool1 = bool2;
            if (this.jdField_a_of_type_AndroidViewView == this.jdField_b_of_type_AndroidViewView) {
              break;
            }
            a(this.jdField_a_of_type_AndroidViewView);
            bool1 = bool2;
            break;
          }
          if (this.jdField_c_of_type_Boolean) {
            if ((this.jdField_b_of_type_AndroidViewView != this.jdField_a_of_type_AndroidViewView) || (a(i)))
            {
              bool2 = true;
              label243:
              bool1 = bool2;
              if (this.jdField_b_of_type_AndroidViewView == this.jdField_a_of_type_AndroidViewView)
              {
                if (this.jdField_a_of_type_Byte == 0)
                {
                  bool1 = bool2;
                  if (!a(Math.abs(i - this.d), Math.abs(j - this.e))) {
                    continue;
                  }
                }
                bool1 = bool2;
                if (this.jdField_a_of_type_Byte == 1)
                {
                  a(i, j, this.jdField_b_of_type_AndroidViewView, this.jdField_c_of_type_Int);
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
      this.f = i;
      this.g = j;
      break;
      bool2 = false;
      break label243;
      if (this.jdField_c_of_type_Int == 0)
      {
        bool1 = false;
      }
      else
      {
        if ((this.jdField_a_of_type_Byte == 0) && (!a(Math.abs(i - this.d), Math.abs(j - this.e))))
        {
          bool1 = false;
          break;
        }
        if (this.jdField_a_of_type_Byte == 1)
        {
          a(i, j, this.jdField_b_of_type_AndroidViewView, this.jdField_c_of_type_Int);
          bool1 = true;
          continue;
          if (this.jdField_c_of_type_Boolean) {
            if ((this.jdField_b_of_type_AndroidViewView != this.jdField_a_of_type_AndroidViewView) || (a(i)))
            {
              bool2 = true;
              label455:
              bool1 = bool2;
              if (this.jdField_b_of_type_AndroidViewView == this.jdField_a_of_type_AndroidViewView)
              {
                if (this.jdField_a_of_type_Byte != 1) {
                  break label518;
                }
                b();
                bool1 = true;
              }
            }
          }
          for (;;)
          {
            d();
            this.d = -1;
            this.f = -1;
            this.e = -1;
            this.g = -1;
            break;
            bool2 = false;
            break label455;
            label518:
            a(this.jdField_b_of_type_AndroidViewView);
            bool1 = bool2;
            continue;
            if (this.jdField_c_of_type_Int == 0)
            {
              bool1 = false;
            }
            else
            {
              if (this.jdField_a_of_type_Byte == 1)
              {
                b();
                bool1 = true;
                continue;
                if (((k != 1) && (k != 3)) || (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SlidingListener == null)) {
                  break label116;
                }
                this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SlidingListener.a(false);
                this.jdField_a_of_type_Boolean = false;
                break label116;
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
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = true;
    switch (paramMessage.what)
    {
    default: 
      bool = false;
    case 2: 
      return bool;
    case 0: 
      bool = this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset();
      f1 = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
      if (this.jdField_c_of_type_AndroidViewView != null)
      {
        this.jdField_c_of_type_AndroidViewView.scrollTo((int)f1, 0);
        this.jdField_a_of_type_ComTencentWidgetListView.invalidate();
      }
      if (bool)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
        return true;
      }
      this.jdField_c_of_type_AndroidViewView = null;
      return true;
    }
    bool = this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset();
    float f1 = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
    if (this.jdField_c_of_type_AndroidViewView != null)
    {
      this.jdField_c_of_type_AndroidViewView.scrollTo((int)f1, 0);
      this.jdField_a_of_type_ComTencentWidgetListView.invalidate();
    }
    if (bool)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return true;
    }
    this.jdField_c_of_type_AndroidViewView = null;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopSidesSlippingMaker
 * JD-Core Version:    0.7.0.1
 */