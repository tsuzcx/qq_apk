package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Scroller;
import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DrawerFrame
  extends FrameLayout
  implements Handler.Callback
{
  private Set<DrawerFrame.TouchEventConsumer> A = new HashSet();
  public boolean a = true;
  private boolean b = true;
  private boolean c = false;
  private boolean d = false;
  private boolean e = false;
  private int f = 0;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private WeakReferenceHandler m;
  private Scroller n;
  private View o;
  private ViewGroup p;
  private View q;
  private View r;
  private VelocityTracker s;
  private DrawerFrame.IDrawerCallbacks t;
  private int u;
  private int v;
  private int w = -1;
  private Rect x;
  private boolean y = true;
  private boolean z = true;
  
  public DrawerFrame(Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext);
    if (paramContext != null)
    {
      this.m = new WeakReferenceHandler(Looper.getMainLooper(), this);
      this.n = new Scroller(paramContext, new DrawerFrame.SmoothInterpolator());
      a(paramViewGroup);
      return;
    }
    throw new NullPointerException("context is null");
  }
  
  public DrawerFrame(@NonNull Context paramContext, @NonNull ViewGroup paramViewGroup, @NonNull boolean paramBoolean)
  {
    super(paramContext);
    this.m = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.n = new Scroller(paramContext, new DrawerFrame.SmoothInterpolator());
    this.o = paramViewGroup;
    if (paramBoolean) {
      this.p = this;
    }
  }
  
  private void a(int paramInt)
  {
    int i1;
    int i2;
    if (this.w == 0)
    {
      i1 = this.f;
      i2 = this.g;
      if (i1 + paramInt > i2)
      {
        if (i1 == i2) {
          return;
        }
        this.c = true;
        this.o.offsetLeftAndRight(i2 - i1);
        this.f = this.g;
        a(this.w, this.f);
        invalidate();
        return;
      }
    }
    View localView;
    if (this.w == 0)
    {
      i1 = this.f;
      if (i1 + paramInt < 0)
      {
        if (i1 == 0) {
          return;
        }
        this.c = false;
        localView = this.o;
        localView.offsetLeftAndRight(0 - localView.getLeft());
        this.f = 0;
        a(this.w, this.f);
        invalidate();
        return;
      }
    }
    if (this.w == 1)
    {
      i1 = this.f;
      i2 = this.h;
      if (i1 + paramInt < -i2)
      {
        if (i1 == -i2) {
          return;
        }
        this.c = true;
        this.o.offsetLeftAndRight(-i2 - i1);
        this.f = (-this.h);
        a(this.w, this.f);
        invalidate();
        return;
      }
    }
    if (this.w == 1)
    {
      i1 = this.f;
      if (i1 + paramInt > 0)
      {
        if (i1 == 0) {
          return;
        }
        this.c = false;
        localView = this.o;
        localView.offsetLeftAndRight(0 - localView.getLeft());
        this.f = 0;
        a(this.w, this.f);
        invalidate();
        return;
      }
    }
    this.o.offsetLeftAndRight(paramInt);
    this.f += paramInt;
    a(this.w, this.f);
    invalidate();
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.o = paramView;
    paramView = this.o.getParent();
    if ((paramView instanceof ViewGroup))
    {
      this.p = ((ViewGroup)paramView);
      this.p.removeView(this.o);
      paramView = new FrameLayout.LayoutParams(-1, -1);
      addView(this.o, paramView);
      this.p.addView(this);
      this.p.setOnClickListener(new DrawerFrame.1(this));
      return;
    }
    this.p = null;
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    if (this.A.size() > 0)
    {
      Iterator localIterator = this.A.iterator();
      while (localIterator.hasNext()) {
        if (((DrawerFrame.TouchEventConsumer)localIterator.next()).a(paramMotionEvent)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private void b(int paramInt)
  {
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    this.e = false;
    this.d = false;
    this.s.computeCurrentVelocity(1000);
    if (Math.abs(this.s.getXVelocity()) > localViewConfiguration.getScaledMinimumFlingVelocity())
    {
      if (this.w == 0)
      {
        if (this.s.getXVelocity() > 0.0F)
        {
          this.c = false;
          b();
          return;
        }
        this.c = true;
        e();
        return;
      }
      if (this.s.getXVelocity() < 0.0F)
      {
        this.c = false;
        c();
        return;
      }
      this.c = true;
      e();
      return;
    }
    if (this.w == 0)
    {
      int i1 = this.f;
      d1 = i1;
      int i2 = this.u;
      d2 = i2;
      Double.isNaN(d2);
      if (d1 <= d2 / 3.0D * 2.0D)
      {
        d1 = i1;
        d2 = i2;
        Double.isNaN(d2);
        if ((d1 <= d2 / 3.0D) || (paramInt > 0))
        {
          this.c = true;
          e();
          return;
        }
      }
      this.c = false;
      b();
      return;
    }
    double d1 = this.f;
    double d2 = this.h;
    Double.isNaN(d2);
    if (d1 < -(d2 / 3.0D * 1.0D))
    {
      this.c = false;
      c();
      return;
    }
    this.c = true;
    e();
  }
  
  private boolean b(int paramInt1, int paramInt2)
  {
    Rect localRect = this.x;
    return (localRect != null) && (localRect.contains(paramInt1, paramInt2));
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    int i2 = 0;
    int i1;
    if ((paramInt2 != 1) && (paramInt1 != 1)) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    View localView = this.q;
    if ((localView != null) && (localView.getVisibility() != i1)) {
      this.q.setVisibility(i1);
    }
    if (paramInt2 != 1)
    {
      paramInt2 = i2;
      if (paramInt1 != 0) {}
    }
    else
    {
      paramInt2 = 8;
    }
    localView = this.r;
    if ((localView != null) && (localView.getVisibility() != paramInt2)) {
      this.r.setVisibility(paramInt2);
    }
  }
  
  private boolean g()
  {
    if (!this.b) {
      return false;
    }
    return this.o != null;
  }
  
  private boolean h()
  {
    return (this.q != null) || (this.r != null);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DrawerFrame", 2, "removeDrawerView");
    }
    if ((this.q == null) && (this.r == null))
    {
      QLog.d("DrawerFrame", 1, "drawer view is empty!");
      return;
    }
    d();
    View localView = this.q;
    if (localView != null)
    {
      removeView(localView);
      this.q = null;
      if (QLog.isColorLevel()) {
        QLog.d("DrawerFrame", 2, "remove left drawer");
      }
    }
    localView = this.r;
    if (localView != null)
    {
      removeView(localView);
      this.r = null;
      if (QLog.isColorLevel()) {
        QLog.d("DrawerFrame", 2, "remove right drawer");
      }
    }
  }
  
  @TargetApi(11)
  protected void a(int paramInt1, int paramInt2)
  {
    c(paramInt1, 2);
    if (Build.VERSION.SDK_INT >= 11)
    {
      float f1;
      if (paramInt1 == 0)
      {
        f1 = paramInt2;
        paramInt2 = this.g;
      }
      else
      {
        f1 = -paramInt2;
        paramInt2 = this.h;
      }
      f1 /= paramInt2;
      if (paramInt1 == 0) {
        paramInt2 = this.u;
      } else {
        paramInt2 = -this.u;
      }
      float f2 = paramInt2;
      if (paramInt1 == 0) {
        localObject = this.q;
      } else {
        localObject = this.r;
      }
      if (localObject != null) {
        ((View)localObject).setTranslationX(f2 * (f1 - 1.0F));
      }
      Object localObject = this.t;
      if (localObject != null) {
        ((DrawerFrame.IDrawerCallbacks)localObject).a(this.w, f1);
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (g())
    {
      if (!h()) {
        return;
      }
      this.w = paramInt;
      if (this.d)
      {
        this.m.removeMessages(1);
        this.m.removeMessages(2);
        this.m.removeMessages(4);
        this.m.removeMessages(3);
      }
      else if (this.c)
      {
        return;
      }
      int i1 = this.w;
      if (i1 == 0) {
        this.q.setVisibility(0);
      } else if (i1 == 1) {
        this.r.setVisibility(0);
      }
      this.d = true;
      Object localObject = this.t;
      if (localObject != null) {
        ((DrawerFrame.IDrawerCallbacks)localObject).b(this.w);
      }
      int i2;
      if (paramInt != 0)
      {
        if (paramInt == 1)
        {
          localObject = this.n;
          i1 = this.f;
          i2 = -this.h;
          if (paramBoolean) {
            paramInt = 300;
          } else {
            paramInt = 1;
          }
          ((Scroller)localObject).startScroll(i1, 0, i2 - i1, 0, paramInt);
        }
      }
      else
      {
        localObject = this.n;
        i1 = this.f;
        i2 = this.g;
        if (paramBoolean) {
          paramInt = 300;
        } else {
          paramInt = 1;
        }
        ((Scroller)localObject).startScroll(i1, 0, i2 - i1, 0, paramInt);
      }
      localObject = this.t;
      if (localObject != null) {
        ((DrawerFrame.IDrawerCallbacks)localObject).i();
      }
      this.m.sendEmptyMessage(1);
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    if ((paramView != null) && (this.q == null) && (this.r == null))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addDrawerView, side: ");
        localStringBuilder.append(paramInt);
        QLog.d("DrawerFrame", 2, localStringBuilder.toString());
      }
      if (paramInt == 0)
      {
        this.q = paramView;
        this.q.setVisibility(8);
        paramView = new FrameLayout.LayoutParams(-1, -1, 19);
        addView(this.q, paramView);
        this.w = 0;
        this.y = false;
        this.z = false;
        return;
      }
      if (paramInt == 1)
      {
        this.r = paramView;
        this.r.setVisibility(8);
        paramView = new FrameLayout.LayoutParams(-2, -1, 21);
        addView(this.r, paramView);
        this.w = 1;
        this.y = false;
        this.z = false;
      }
      return;
    }
    QLog.d("DrawerFrame", 1, "drawer view has exist");
  }
  
  public void a(DrawerFrame.TouchEventConsumer paramTouchEventConsumer)
  {
    if (paramTouchEventConsumer != null) {
      this.A.add(paramTouchEventConsumer);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (g())
    {
      if (!h()) {
        return;
      }
      if (this.d)
      {
        this.m.removeMessages(1);
        this.m.removeMessages(2);
        this.m.removeMessages(4);
        this.m.removeMessages(3);
      }
      else if (!this.c)
      {
        return;
      }
      this.d = true;
      Object localObject = this.t;
      if (localObject != null) {
        ((DrawerFrame.IDrawerCallbacks)localObject).b(this.w);
      }
      localObject = this.t;
      if (localObject != null) {
        ((DrawerFrame.IDrawerCallbacks)localObject).j();
      }
      localObject = this.n;
      int i2 = this.f;
      int i3 = -i2;
      int i1;
      if (paramBoolean) {
        i1 = 300;
      } else {
        i1 = 0;
      }
      ((Scroller)localObject).startScroll(i2, 0, i3, 0, i1);
      this.m.sendEmptyMessage(2);
    }
  }
  
  public void b()
  {
    a(0, true);
  }
  
  public void b(DrawerFrame.TouchEventConsumer paramTouchEventConsumer)
  {
    if (paramTouchEventConsumer != null) {
      this.A.remove(paramTouchEventConsumer);
    }
  }
  
  public void c()
  {
    a(1, true);
  }
  
  public void d()
  {
    this.m.removeMessages(1);
    this.m.removeMessages(2);
    this.m.removeMessages(4);
    this.m.removeMessages(3);
    this.d = false;
    this.f = 0;
    this.t = null;
    this.y = true;
    this.z = true;
    if (this.q != null) {
      this.w = 0;
    } else {
      this.w = 1;
    }
    View localView = this.o;
    if (localView != null) {
      localView.offsetLeftAndRight(0 - localView.getLeft());
    }
    a(this.w, this.f);
    postInvalidate();
    if (this.c)
    {
      this.c = false;
      this.m.sendEmptyMessage(4);
    }
    c(this.w, 1);
  }
  
  public void e()
  {
    a(true);
  }
  
  public boolean f()
  {
    return this.c;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i2 = paramMessage.what;
    int i1 = 0;
    boolean bool;
    if (i2 != 1)
    {
      if (i2 != 2)
      {
        if (i2 != 3)
        {
          if (i2 != 4)
          {
            if (i2 != 5) {
              return true;
            }
            if (f())
            {
              i2 = this.w;
              if (i2 == 0)
              {
                i2 = this.g;
                i1 = i2 - this.f;
                this.f = i2;
              }
              else if (i2 == 1)
              {
                i2 = this.h;
                i1 = -i2 - this.f;
                this.f = (-i2);
              }
              paramMessage = this.o;
              if ((paramMessage != null) && (i1 != 0))
              {
                paramMessage.offsetLeftAndRight(i1);
                a(this.w, this.f);
                postInvalidate();
                return true;
              }
            }
          }
          else
          {
            if (this.d) {
              return true;
            }
            paramMessage = this.t;
            if (paramMessage != null) {
              paramMessage.l();
            }
            if (this.q != null) {
              this.w = 0;
            } else {
              this.w = 1;
            }
            c(this.w, 1);
            return true;
          }
        }
        else
        {
          if (this.d) {
            return true;
          }
          c(this.w, 0);
          paramMessage = this.t;
          if (paramMessage != null)
          {
            paramMessage.k();
            return true;
          }
        }
      }
      else
      {
        bool = this.n.computeScrollOffset();
        i1 = this.n.getCurrX();
        i2 = this.f;
        this.f = this.n.getCurrX();
        paramMessage = this.o;
        if (paramMessage != null)
        {
          paramMessage.offsetLeftAndRight(i1 - i2);
          a(this.w, this.f);
        }
        postInvalidate();
        if (!bool)
        {
          this.d = false;
          this.c = false;
          paramMessage = this.q;
          if (paramMessage != null) {
            paramMessage.setVisibility(8);
          }
          paramMessage = this.r;
          if (paramMessage != null) {
            paramMessage.setVisibility(8);
          }
          this.m.sendEmptyMessage(4);
          return true;
        }
        this.m.sendEmptyMessage(2);
        return true;
      }
    }
    else
    {
      bool = this.n.computeScrollOffset();
      i1 = this.n.getCurrX();
      i2 = this.f;
      this.f = this.n.getCurrX();
      paramMessage = this.o;
      if (paramMessage != null)
      {
        paramMessage.offsetLeftAndRight(i1 - i2);
        a(this.w, this.f);
      }
      postInvalidate();
      if (!bool)
      {
        this.d = false;
        this.c = true;
        this.m.sendEmptyMessage(3);
        return true;
      }
      this.m.sendEmptyMessage(1);
    }
    return true;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = g();
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    if (a(paramMotionEvent)) {
      return false;
    }
    int i1 = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    int i2 = (int)(paramMotionEvent.getX() + 0.5F);
    int i3 = (int)(paramMotionEvent.getY() + 0.5F);
    int i4 = paramMotionEvent.getAction() & 0xFF;
    if (i4 != 0)
    {
      if (i4 != 1)
      {
        if (i4 != 2) {
          return false;
        }
        if (!this.e) {
          return false;
        }
        if ((!this.c) && ((i2 > this.j) || (i2 > this.i)))
        {
          this.e = false;
          return false;
        }
        this.j = i2;
        this.l = i3;
        i2 = Math.abs(this.j - this.i);
        i3 = Math.abs(this.l - this.k);
        if ((i2 > i1) && ((i3 + 0.0F) / i2 < 0.6F)) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        if (i1 != 0) {
          if (this.d)
          {
            this.m.removeMessages(1);
            this.m.removeMessages(2);
            this.m.removeMessages(4);
            this.m.removeMessages(3);
          }
          else if (!h())
          {
            paramMotionEvent = this.t;
            if (paramMotionEvent != null) {
              if ((this.j > this.i) && (this.z))
              {
                this.z = false;
                paramMotionEvent.a(0);
              }
              else if ((this.j < this.i) && (this.y))
              {
                this.y = false;
                this.t.a(1);
              }
            }
          }
        }
        bool1 = bool2;
        if (i1 != 0)
        {
          bool1 = bool2;
          if (h()) {
            bool1 = true;
          }
        }
        return bool1;
      }
      this.e = false;
      this.j = -1;
      this.i = -1;
      this.l = -1;
      this.k = -1;
      return false;
    }
    this.j = i2;
    this.i = i2;
    this.l = i3;
    this.k = i3;
    if (b(i2, i3)) {
      this.e = true;
    }
    if ((this.d) && (((this.w == 0) && (this.i > this.f)) || ((this.w == 1) && (this.i < this.u + this.f))))
    {
      this.e = true;
      return true;
    }
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = this.u;
    this.u = (paramInt3 - paramInt1);
    this.v = (paramInt4 - paramInt2);
    int i2 = this.u;
    this.g = i2;
    this.h = i2;
    if ((this.x == null) && (i2 > 0))
    {
      int i3 = this.v;
      if (i3 > 0) {
        setTouchableBound(0, 0, i2, i3);
      }
    }
    Object localObject = this.q;
    if ((localObject != null) && (((View)localObject).getVisibility() != 8))
    {
      localObject = (FrameLayout.LayoutParams)this.q.getLayoutParams();
      this.q.layout(((FrameLayout.LayoutParams)localObject).leftMargin + paramInt1, ((FrameLayout.LayoutParams)localObject).topMargin + paramInt2, paramInt3 - ((FrameLayout.LayoutParams)localObject).rightMargin, paramInt4 - ((FrameLayout.LayoutParams)localObject).bottomMargin);
    }
    localObject = this.r;
    if ((localObject != null) && (((View)localObject).getVisibility() != 8))
    {
      localObject = (FrameLayout.LayoutParams)this.r.getLayoutParams();
      this.r.layout(((FrameLayout.LayoutParams)localObject).leftMargin + paramInt1, ((FrameLayout.LayoutParams)localObject).topMargin + paramInt2, paramInt3 - ((FrameLayout.LayoutParams)localObject).rightMargin, paramInt4 - ((FrameLayout.LayoutParams)localObject).bottomMargin);
    }
    localObject = this.o;
    if ((localObject != null) && (((View)localObject).getVisibility() != 8))
    {
      localObject = this.o;
      ((View)localObject).layout(((View)localObject).getLeft(), this.o.getTop(), this.o.getLeft() + paramInt3, this.o.getTop() + paramInt4);
    }
    if ((i1 != this.u) && (i1 != 0))
    {
      this.m.removeMessages(5);
      this.m.sendEmptyMessage(5);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!g()) {
      return false;
    }
    int i2 = (int)(paramMotionEvent.getX() + 0.5F);
    int i3 = (int)(paramMotionEvent.getY() + 0.5F);
    int i1 = i2 - this.j;
    int i4 = this.l;
    if (this.s == null) {
      this.s = VelocityTracker.obtain();
    }
    this.s.addMovement(paramMotionEvent);
    this.j = i2;
    this.l = i3;
    i2 = paramMotionEvent.getAction() & 0xFF;
    if (i2 != 0)
    {
      if (i2 != 1)
      {
        if (i2 != 2) {
          return false;
        }
      }
      else
      {
        b(i1);
        return true;
      }
    }
    else if (this.d)
    {
      this.m.removeMessages(1);
      this.m.removeMessages(2);
      this.m.removeMessages(4);
      this.m.removeMessages(3);
    }
    boolean bool = this.d;
    this.d = true;
    if (!bool)
    {
      paramMotionEvent = this.t;
      if (paramMotionEvent != null) {
        paramMotionEvent.b(this.w);
      }
    }
    a(i1);
    return true;
  }
  
  public void setDrawerCallbacks(DrawerFrame.IDrawerCallbacks paramIDrawerCallbacks)
  {
    this.t = paramIDrawerCallbacks;
  }
  
  public void setDrawerEnabled(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void setTouchableBound(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.x == null) {
      this.x = new Rect();
    }
    Rect localRect = this.x;
    localRect.left = paramInt1;
    localRect.top = paramInt2;
    localRect.right = paramInt3;
    localRect.bottom = paramInt4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.DrawerFrame
 * JD-Core Version:    0.7.0.1
 */