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
  private boolean jdField_a_of_type_Boolean = false;
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
    if (paramInt1 > 0) {
      return (int)(Math.abs(paramInt2) / paramInt1 * 300.0F) + 50;
    }
    return 300;
  }
  
  private void a(int paramInt1, int paramInt2, View paramView, int paramInt3)
  {
    paramInt2 = this.f;
    paramInt2 = paramView.getScrollX() - (paramInt1 - paramInt2);
    if (paramInt2 > paramInt3)
    {
      paramInt1 = paramInt3;
    }
    else
    {
      paramInt1 = paramInt2;
      if (paramInt2 < 0) {
        paramInt1 = 0;
      }
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      TroopSidesSlippingMaker.SlidingListener localSlidingListener = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SlidingListener;
      if (localSlidingListener != null) {
        localSlidingListener.a(true);
      }
      this.jdField_a_of_type_Boolean = true;
    }
    paramView.scrollTo(paramInt1, 0);
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
    int i;
    if (paramView != null) {
      i = paramView.getScrollX();
    } else {
      i = 0;
    }
    if (i != 0)
    {
      int j;
      if ((paramView.getTag(-3) instanceof Integer)) {
        j = ((Integer)paramView.getTag(-3)).intValue();
      } else {
        j = 0;
      }
      View localView = this.jdField_c_of_type_AndroidViewView;
      if ((localView != paramView) && (localView != null)) {
        localView.scrollTo(0, 0);
      }
      d();
      this.jdField_c_of_type_AndroidViewView = paramView;
      int k = -i;
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(i, 0, k, 0, a(j, k));
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
  }
  
  private boolean a(float paramFloat)
  {
    return paramFloat < this.jdField_a_of_type_ComTencentWidgetListView.getWidth() - this.jdField_c_of_type_Int;
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    int i = this.jdField_a_of_type_Int;
    if ((paramFloat1 <= i) && (paramFloat2 <= i)) {
      return false;
    }
    if ((paramFloat1 > this.jdField_a_of_type_Int) && (paramFloat2 / paramFloat1 < 0.6F))
    {
      this.jdField_a_of_type_Byte = 1;
      return true;
    }
    this.jdField_a_of_type_Byte = 2;
    return true;
  }
  
  private boolean a(View paramView)
  {
    return (paramView != null) && (paramView.getScrollX() >= this.jdField_a_of_type_Int);
  }
  
  private void b(View paramView)
  {
    if (paramView == null) {
      return;
    }
    int k = paramView.getScrollX();
    int j = this.jdField_c_of_type_Int;
    int i = j;
    if (j == 0)
    {
      i = j;
      if ((paramView.getTag(-3) instanceof Integer)) {
        i = ((Integer)paramView.getTag(-3)).intValue();
      }
    }
    if (k != i)
    {
      localObject = this.jdField_c_of_type_AndroidViewView;
      if ((localObject != paramView) && (localObject != null)) {
        ((View)localObject).scrollTo(0, 0);
      }
      d();
      this.jdField_c_of_type_AndroidViewView = paramView;
      j = i - k;
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(k, 0, j, 0, a(i, j));
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SlidingListener;
    if (localObject != null) {
      ((TroopSidesSlippingMaker.SlidingListener)localObject).a(paramView);
    }
    if ((AppSetting.d) && ((paramView instanceof LinearLayout)))
    {
      paramView = (LinearLayout)paramView;
      paramView = paramView.getChildAt(paramView.getChildCount() - 1);
      if (paramView != null) {
        paramView.sendAccessibilityEvent(8);
      }
    }
  }
  
  private void c()
  {
    int i = a();
    int j = this.jdField_b_of_type_AndroidViewView.getScrollX();
    int k = this.jdField_b_of_type_Int;
    if (i > k)
    {
      a(this.jdField_b_of_type_AndroidViewView);
      return;
    }
    if (i < -k)
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
  
  private void d()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    this.jdField_c_of_type_AndroidViewView = null;
  }
  
  private void e()
  {
    VelocityTracker localVelocityTracker = this.jdField_a_of_type_AndroidViewVelocityTracker;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  public void a()
  {
    if (!a(this.jdField_b_of_type_AndroidViewView))
    {
      int i = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition() - this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount();
      int j = this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition();
      while (i <= j)
      {
        View localView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i);
        if (a(localView))
        {
          this.jdField_b_of_type_AndroidViewView = localView;
          break;
        }
        i += 1;
      }
    }
    a(this.jdField_b_of_type_AndroidViewView);
  }
  
  public void a(TroopSidesSlippingMaker.SlidingListener paramSlidingListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SlidingListener = paramSlidingListener;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_b_of_type_Boolean) {
      return this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SuperTouchListener.a(paramMotionEvent);
    }
    int j = (int)(paramMotionEvent.getX() + 0.5F);
    int i = (int)(paramMotionEvent.getY() + 0.5F);
    int k = paramMotionEvent.getAction();
    if (k != 0) {
      if (k != 1) {
        if (k != 2)
        {
          if (k != 3) {
            break label164;
          }
        }
        else
        {
          if ((this.jdField_c_of_type_Int > 0) && (this.jdField_a_of_type_Byte == 0)) {
            a(Math.abs(j - this.d), Math.abs(i - this.e));
          }
          if ((this.jdField_a_of_type_Byte != 1) || (j >= this.d)) {
            break label164;
          }
        }
      }
    }
    boolean bool1;
    label164:
    Object localObject;
    for (;;)
    {
      bool1 = true;
      break;
      if (this.jdField_c_of_type_Boolean) {
        a(this.jdField_a_of_type_AndroidViewView);
      }
      this.d = -1;
      this.f = -1;
      this.e = -1;
      this.g = -1;
      do
      {
        do
        {
          bool1 = false;
          break;
          this.jdField_a_of_type_Byte = 0;
          this.d = j;
          this.f = j;
          this.e = i;
          this.g = i;
          this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView;
          this.jdField_c_of_type_Boolean = a(this.jdField_a_of_type_AndroidViewView);
          if (!this.jdField_c_of_type_Boolean)
          {
            int m = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
            int n = this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount();
            i = this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition();
            while (i >= m - n)
            {
              localObject = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i);
              this.jdField_c_of_type_Boolean = a((View)localObject);
              if (this.jdField_c_of_type_Boolean)
              {
                this.jdField_a_of_type_AndroidViewView = ((View)localObject);
                break;
              }
              i -= 1;
            }
          }
          this.jdField_c_of_type_Int = 0;
          this.jdField_b_of_type_AndroidViewView = null;
          i = this.e;
          if (this.jdField_a_of_type_ComTencentWidgetListView.isOverscrollHeadVisiable()) {
            i = this.e + this.jdField_a_of_type_ComTencentWidgetListView.getScrollY();
          }
          i = this.jdField_a_of_type_ComTencentWidgetListView.pointToPosition(this.d, i);
          if (i >= 0)
          {
            localObject = this.jdField_a_of_type_ComTencentWidgetListView;
            this.jdField_b_of_type_AndroidViewView = ((ListView)localObject).getChildAt(i - ((ListView)localObject).getFirstVisiblePosition());
            localObject = this.jdField_b_of_type_AndroidViewView;
            if ((localObject != null) && ((((View)localObject).getTag(-3) instanceof Integer))) {
              this.jdField_c_of_type_Int = ((Integer)this.jdField_b_of_type_AndroidViewView.getTag(-3)).intValue();
            }
          }
        } while (!this.jdField_c_of_type_Boolean);
        if (this.jdField_b_of_type_AndroidViewView != this.jdField_a_of_type_AndroidViewView) {
          break;
        }
      } while (!a(j));
    }
    if ((k == 0) && (this.jdField_c_of_type_Boolean))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SlidingListener;
      if (localObject != null) {
        ((TroopSidesSlippingMaker.SlidingListener)localObject).a(true);
      }
      d();
    }
    else if ((k == 1) || (k == 3))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SlidingListener;
      if (localObject != null) {
        ((TroopSidesSlippingMaker.SlidingListener)localObject).a(false);
      }
    }
    boolean bool2 = bool1;
    if (!bool1) {
      bool2 = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SuperTouchListener.a(paramMotionEvent);
    }
    return bool2;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentWidgetListView = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SlidingListener = null;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_b_of_type_Boolean) {
      return this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SuperTouchListener.b(paramMotionEvent);
    }
    a(paramMotionEvent);
    int i = (int)(paramMotionEvent.getX() + 0.5F);
    int j = (int)(paramMotionEvent.getY() + 0.5F);
    int k = paramMotionEvent.getAction();
    boolean bool1;
    label268:
    label271:
    label285:
    label288:
    Object localObject;
    if (k != 0)
    {
      if (k != 1)
      {
        if (k != 2)
        {
          if (k == 3) {
            break label288;
          }
        }
        else
        {
          if (this.jdField_c_of_type_Boolean)
          {
            if ((this.jdField_b_of_type_AndroidViewView == this.jdField_a_of_type_AndroidViewView) && (!a(i))) {
              bool1 = false;
            } else {
              bool1 = true;
            }
            bool2 = bool1;
            if (this.jdField_b_of_type_AndroidViewView != this.jdField_a_of_type_AndroidViewView) {
              break label271;
            }
            if ((this.jdField_a_of_type_Byte == 0) && (!a(Math.abs(i - this.d), Math.abs(j - this.e)))) {
              break label285;
            }
            bool2 = bool1;
            if (this.jdField_a_of_type_Byte != 1) {
              break label271;
            }
            a(i, j, this.jdField_b_of_type_AndroidViewView, this.jdField_c_of_type_Int);
            break label268;
          }
          if (this.jdField_c_of_type_Int != 0) {}
        }
        do
        {
          bool2 = false;
          break;
          if ((this.jdField_a_of_type_Byte == 0) && (!a(Math.abs(i - this.d), Math.abs(j - this.e))))
          {
            bool1 = false;
            break label508;
          }
        } while (this.jdField_a_of_type_Byte != 1);
        a(i, j, this.jdField_b_of_type_AndroidViewView, this.jdField_c_of_type_Int);
        bool2 = true;
        this.f = i;
        this.g = j;
        bool1 = bool2;
        break label508;
      }
      if (this.jdField_c_of_type_Boolean)
      {
        if ((this.jdField_b_of_type_AndroidViewView == this.jdField_a_of_type_AndroidViewView) && (!a(i))) {
          bool2 = false;
        } else {
          bool2 = true;
        }
        localObject = this.jdField_b_of_type_AndroidViewView;
        bool1 = bool2;
        if (localObject != this.jdField_a_of_type_AndroidViewView) {
          break label405;
        }
        if (this.jdField_a_of_type_Byte == 1)
        {
          c();
        }
        else
        {
          a((View)localObject);
          bool1 = bool2;
          break label405;
        }
      }
      else
      {
        if ((this.jdField_c_of_type_Int == 0) || (this.jdField_a_of_type_Byte != 1)) {
          break label402;
        }
        c();
      }
      bool1 = true;
      break label405;
      label402:
      bool1 = false;
      label405:
      e();
      this.d = -1;
      this.f = -1;
      this.e = -1;
      this.g = -1;
    }
    else
    {
      if ((this.jdField_c_of_type_Boolean) && ((this.jdField_b_of_type_AndroidViewView != this.jdField_a_of_type_AndroidViewView) || (a(i)))) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      bool1 = bool2;
      if (this.jdField_c_of_type_Boolean)
      {
        localObject = this.jdField_a_of_type_AndroidViewView;
        bool1 = bool2;
        if (localObject != this.jdField_b_of_type_AndroidViewView)
        {
          a((View)localObject);
          bool1 = bool2;
        }
      }
    }
    label508:
    if ((k == 0) && (this.jdField_c_of_type_Boolean))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SlidingListener;
      if (localObject != null) {
        ((TroopSidesSlippingMaker.SlidingListener)localObject).a(true);
      }
    }
    else if ((k == 1) || (k == 3))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SlidingListener;
      if (localObject != null)
      {
        ((TroopSidesSlippingMaker.SlidingListener)localObject).a(false);
        this.jdField_a_of_type_Boolean = false;
      }
    }
    boolean bool2 = bool1;
    if (!bool1) {
      bool2 = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSidesSlippingMaker$SuperTouchListener.b(paramMotionEvent);
    }
    return bool2;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    boolean bool;
    float f1;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return false;
        }
      }
      else
      {
        bool = this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset();
        f1 = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
        paramMessage = this.jdField_c_of_type_AndroidViewView;
        if (paramMessage != null)
        {
          paramMessage.scrollTo((int)f1, 0);
          paramMessage = this.jdField_a_of_type_ComTencentWidgetListView;
          if (paramMessage != null) {
            paramMessage.invalidate();
          }
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
    else
    {
      bool = this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset();
      f1 = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
      paramMessage = this.jdField_c_of_type_AndroidViewView;
      if (paramMessage != null)
      {
        paramMessage.scrollTo((int)f1, 0);
        paramMessage = this.jdField_a_of_type_ComTencentWidgetListView;
        if (paramMessage != null) {
          paramMessage.invalidate();
        }
      }
      if (bool)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
        return true;
      }
      this.jdField_c_of_type_AndroidViewView = null;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopSidesSlippingMaker
 * JD-Core Version:    0.7.0.1
 */