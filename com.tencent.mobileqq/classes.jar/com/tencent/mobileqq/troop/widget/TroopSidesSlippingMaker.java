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
  private final int a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private boolean h = false;
  private boolean i = true;
  private boolean j;
  private byte k;
  private TroopSidesSlippingMaker.SlidingListener l;
  private VelocityTracker m;
  private Scroller n;
  private Handler o;
  private View p;
  private View q;
  private View r;
  private ListView s;
  private TroopSidesSlippingMaker.SuperTouchListener t;
  
  public TroopSidesSlippingMaker(Context paramContext, ListView paramListView, TroopSidesSlippingMaker.SuperTouchListener paramSuperTouchListener)
  {
    this.s = paramListView;
    this.t = paramSuperTouchListener;
    this.n = new Scroller(paramContext, new TroopSidesSlippingMaker.SmoothInterpolator());
    paramContext = ViewConfiguration.get(paramContext);
    this.a = paramContext.getScaledTouchSlop();
    this.b = (paramContext.getScaledMinimumFlingVelocity() * 4);
    this.d = -1;
    this.f = -1;
    this.e = -1;
    this.g = -1;
    this.o = new Handler(Looper.getMainLooper(), this);
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
    if (!this.h)
    {
      TroopSidesSlippingMaker.SlidingListener localSlidingListener = this.l;
      if (localSlidingListener != null) {
        localSlidingListener.a(true);
      }
      this.h = true;
    }
    paramView.scrollTo(paramInt1, 0);
  }
  
  private boolean a(float paramFloat)
  {
    return paramFloat < this.s.getWidth() - this.c;
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    int i1 = this.a;
    if ((paramFloat1 <= i1) && (paramFloat2 <= i1)) {
      return false;
    }
    if ((paramFloat1 > this.a) && (paramFloat2 / paramFloat1 < 0.6F))
    {
      this.k = 1;
      return true;
    }
    this.k = 2;
    return true;
  }
  
  private boolean a(View paramView)
  {
    return (paramView != null) && (paramView.getScrollX() >= this.a);
  }
  
  private void b(View paramView)
  {
    int i1;
    if (paramView != null) {
      i1 = paramView.getScrollX();
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      int i2;
      if ((paramView.getTag(-3) instanceof Integer)) {
        i2 = ((Integer)paramView.getTag(-3)).intValue();
      } else {
        i2 = 0;
      }
      View localView = this.r;
      if ((localView != paramView) && (localView != null)) {
        localView.scrollTo(0, 0);
      }
      d();
      this.r = paramView;
      int i3 = -i1;
      this.n.startScroll(i1, 0, i3, 0, a(i2, i3));
      this.o.sendEmptyMessage(1);
    }
  }
  
  private void c()
  {
    int i1 = f();
    int i2 = this.q.getScrollX();
    int i3 = this.b;
    if (i1 > i3)
    {
      b(this.q);
      return;
    }
    if (i1 < -i3)
    {
      c(this.q);
      return;
    }
    if ((i1 > 0) && (i2 < this.c * 0.7F))
    {
      b(this.q);
      return;
    }
    if ((i1 < 0) && (i2 > this.c * 0.3F))
    {
      c(this.q);
      return;
    }
    if ((this.j) && (i2 < this.c * 0.7F))
    {
      b(this.q);
      return;
    }
    if (i2 > this.c * 0.3F)
    {
      c(this.q);
      return;
    }
    b(this.q);
  }
  
  private void c(MotionEvent paramMotionEvent)
  {
    if (this.m == null) {
      this.m = VelocityTracker.obtain();
    }
    this.m.addMovement(paramMotionEvent);
  }
  
  private void c(View paramView)
  {
    if (paramView == null) {
      return;
    }
    int i3 = paramView.getScrollX();
    int i2 = this.c;
    int i1 = i2;
    if (i2 == 0)
    {
      i1 = i2;
      if ((paramView.getTag(-3) instanceof Integer)) {
        i1 = ((Integer)paramView.getTag(-3)).intValue();
      }
    }
    if (i3 != i1)
    {
      localObject = this.r;
      if ((localObject != paramView) && (localObject != null)) {
        ((View)localObject).scrollTo(0, 0);
      }
      d();
      this.r = paramView;
      i2 = i1 - i3;
      this.n.startScroll(i3, 0, i2, 0, a(i1, i2));
      this.o.sendEmptyMessage(0);
    }
    Object localObject = this.l;
    if (localObject != null) {
      ((TroopSidesSlippingMaker.SlidingListener)localObject).a(paramView);
    }
    if ((AppSetting.e) && ((paramView instanceof LinearLayout)))
    {
      paramView = (LinearLayout)paramView;
      paramView = paramView.getChildAt(paramView.getChildCount() - 1);
      if (paramView != null) {
        paramView.sendAccessibilityEvent(8);
      }
    }
  }
  
  private void d()
  {
    this.o.removeMessages(1);
    this.o.removeMessages(0);
    this.r = null;
  }
  
  private void e()
  {
    VelocityTracker localVelocityTracker = this.m;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      this.m = null;
    }
  }
  
  private int f()
  {
    this.m.computeCurrentVelocity(1000);
    return (int)this.m.getXVelocity();
  }
  
  public void a()
  {
    if (!a(this.q))
    {
      int i1 = this.s.getFirstVisiblePosition() - this.s.getHeaderViewsCount();
      int i2 = this.s.getLastVisiblePosition();
      while (i1 <= i2)
      {
        View localView = this.s.getChildAt(i1);
        if (a(localView))
        {
          this.q = localView;
          break;
        }
        i1 += 1;
      }
    }
    b(this.q);
  }
  
  public void a(TroopSidesSlippingMaker.SlidingListener paramSlidingListener)
  {
    this.l = paramSlidingListener;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (!this.i) {
      return this.t.a(paramMotionEvent);
    }
    int i2 = (int)(paramMotionEvent.getX() + 0.5F);
    int i1 = (int)(paramMotionEvent.getY() + 0.5F);
    int i3 = paramMotionEvent.getAction();
    if (i3 != 0) {
      if (i3 != 1) {
        if (i3 != 2)
        {
          if (i3 != 3) {
            break label164;
          }
        }
        else
        {
          if ((this.c > 0) && (this.k == 0)) {
            a(Math.abs(i2 - this.d), Math.abs(i1 - this.e));
          }
          if ((this.k != 1) || (i2 >= this.d)) {
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
      if (this.j) {
        b(this.p);
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
          this.k = 0;
          this.d = i2;
          this.f = i2;
          this.e = i1;
          this.g = i1;
          this.p = this.q;
          this.j = a(this.p);
          if (!this.j)
          {
            int i4 = this.s.getFirstVisiblePosition();
            int i5 = this.s.getHeaderViewsCount();
            i1 = this.s.getLastVisiblePosition();
            while (i1 >= i4 - i5)
            {
              localObject = this.s.getChildAt(i1);
              this.j = a((View)localObject);
              if (this.j)
              {
                this.p = ((View)localObject);
                break;
              }
              i1 -= 1;
            }
          }
          this.c = 0;
          this.q = null;
          i1 = this.e;
          if (this.s.isOverscrollHeadVisiable()) {
            i1 = this.e + this.s.getScrollY();
          }
          i1 = this.s.pointToPosition(this.d, i1);
          if (i1 >= 0)
          {
            localObject = this.s;
            this.q = ((ListView)localObject).getChildAt(i1 - ((ListView)localObject).getFirstVisiblePosition());
            localObject = this.q;
            if ((localObject != null) && ((((View)localObject).getTag(-3) instanceof Integer))) {
              this.c = ((Integer)this.q.getTag(-3)).intValue();
            }
          }
        } while (!this.j);
        if (this.q != this.p) {
          break;
        }
      } while (!a(i2));
    }
    if ((i3 == 0) && (this.j))
    {
      localObject = this.l;
      if (localObject != null) {
        ((TroopSidesSlippingMaker.SlidingListener)localObject).a(true);
      }
      d();
    }
    else if ((i3 == 1) || (i3 == 3))
    {
      localObject = this.l;
      if (localObject != null) {
        ((TroopSidesSlippingMaker.SlidingListener)localObject).a(false);
      }
    }
    boolean bool2 = bool1;
    if (!bool1) {
      bool2 = this.t.a(paramMotionEvent);
    }
    return bool2;
  }
  
  public void b()
  {
    this.s = null;
    this.l = null;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    if (!this.i) {
      return this.t.b(paramMotionEvent);
    }
    c(paramMotionEvent);
    int i1 = (int)(paramMotionEvent.getX() + 0.5F);
    int i2 = (int)(paramMotionEvent.getY() + 0.5F);
    int i3 = paramMotionEvent.getAction();
    boolean bool1;
    label268:
    label271:
    label285:
    label288:
    Object localObject;
    if (i3 != 0)
    {
      if (i3 != 1)
      {
        if (i3 != 2)
        {
          if (i3 == 3) {
            break label288;
          }
        }
        else
        {
          if (this.j)
          {
            if ((this.q == this.p) && (!a(i1))) {
              bool1 = false;
            } else {
              bool1 = true;
            }
            bool2 = bool1;
            if (this.q != this.p) {
              break label271;
            }
            if ((this.k == 0) && (!a(Math.abs(i1 - this.d), Math.abs(i2 - this.e)))) {
              break label285;
            }
            bool2 = bool1;
            if (this.k != 1) {
              break label271;
            }
            a(i1, i2, this.q, this.c);
            break label268;
          }
          if (this.c != 0) {}
        }
        do
        {
          bool2 = false;
          break;
          if ((this.k == 0) && (!a(Math.abs(i1 - this.d), Math.abs(i2 - this.e))))
          {
            bool1 = false;
            break label508;
          }
        } while (this.k != 1);
        a(i1, i2, this.q, this.c);
        bool2 = true;
        this.f = i1;
        this.g = i2;
        bool1 = bool2;
        break label508;
      }
      if (this.j)
      {
        if ((this.q == this.p) && (!a(i1))) {
          bool2 = false;
        } else {
          bool2 = true;
        }
        localObject = this.q;
        bool1 = bool2;
        if (localObject != this.p) {
          break label405;
        }
        if (this.k == 1)
        {
          c();
        }
        else
        {
          b((View)localObject);
          bool1 = bool2;
          break label405;
        }
      }
      else
      {
        if ((this.c == 0) || (this.k != 1)) {
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
      if ((this.j) && ((this.q != this.p) || (a(i1)))) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      bool1 = bool2;
      if (this.j)
      {
        localObject = this.p;
        bool1 = bool2;
        if (localObject != this.q)
        {
          b((View)localObject);
          bool1 = bool2;
        }
      }
    }
    label508:
    if ((i3 == 0) && (this.j))
    {
      localObject = this.l;
      if (localObject != null) {
        ((TroopSidesSlippingMaker.SlidingListener)localObject).a(true);
      }
    }
    else if ((i3 == 1) || (i3 == 3))
    {
      localObject = this.l;
      if (localObject != null)
      {
        ((TroopSidesSlippingMaker.SlidingListener)localObject).a(false);
        this.h = false;
      }
    }
    boolean bool2 = bool1;
    if (!bool1) {
      bool2 = this.t.b(paramMotionEvent);
    }
    return bool2;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    boolean bool;
    float f1;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2) {
          return false;
        }
      }
      else
      {
        bool = this.n.computeScrollOffset();
        f1 = this.n.getCurrX();
        paramMessage = this.r;
        if (paramMessage != null)
        {
          paramMessage.scrollTo((int)f1, 0);
          paramMessage = this.s;
          if (paramMessage != null) {
            paramMessage.invalidate();
          }
        }
        if (bool)
        {
          this.o.sendEmptyMessage(1);
          return true;
        }
        this.r = null;
        return true;
      }
    }
    else
    {
      bool = this.n.computeScrollOffset();
      f1 = this.n.getCurrX();
      paramMessage = this.r;
      if (paramMessage != null)
      {
        paramMessage.scrollTo((int)f1, 0);
        paramMessage = this.s;
        if (paramMessage != null) {
          paramMessage.invalidate();
        }
      }
      if (bool)
      {
        this.o.sendEmptyMessage(0);
        return true;
      }
      this.r = null;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopSidesSlippingMaker
 * JD-Core Version:    0.7.0.1
 */