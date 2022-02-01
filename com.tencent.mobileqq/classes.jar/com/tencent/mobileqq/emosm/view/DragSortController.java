package com.tencent.mobileqq.emosm.view;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;

public class DragSortController
  extends SimpleFloatViewManager
  implements GestureDetector.OnGestureListener, View.OnTouchListener
{
  private int A;
  private GestureDetector.OnGestureListener B = new DragSortController.1(this);
  int a;
  boolean b = false;
  boolean c = false;
  GestureDetector d;
  GestureDetector e;
  int f;
  int g;
  boolean h = false;
  DragSortListView i;
  float j = ViewConfiguration.getTouchSlop() + 2;
  int k;
  private int l = 0;
  private boolean m = true;
  private int n;
  private int o;
  private int p = -1;
  private int q = -1;
  private int r = -1;
  private int[] s = new int[2];
  private int t;
  private int u;
  private float v = 500.0F;
  private int w;
  private int x;
  private int y;
  private boolean z;
  
  public DragSortController(DragSortListView paramDragSortListView)
  {
    this(paramDragSortListView, 0, 0, 1);
  }
  
  public DragSortController(DragSortListView paramDragSortListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramDragSortListView, paramInt1, paramInt2, paramInt3, 0);
  }
  
  public DragSortController(DragSortListView paramDragSortListView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this(paramDragSortListView, paramInt1, paramInt2, paramInt3, paramInt4, 0);
  }
  
  public DragSortController(DragSortListView paramDragSortListView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super(paramDragSortListView);
    this.i = paramDragSortListView;
    this.d = new GestureDetector(paramDragSortListView.getContext(), this);
    this.e = new GestureDetector(paramDragSortListView.getContext(), this.B);
    this.e.setIsLongpressEnabled(false);
    this.o = ViewConfiguration.get(paramDragSortListView.getContext()).getScaledTouchSlop();
    this.w = paramInt1;
    this.x = paramInt4;
    this.y = paramInt5;
    b(paramInt3);
    a(paramInt2);
    this.a = 3;
  }
  
  public int a(MotionEvent paramMotionEvent)
  {
    return c(paramMotionEvent);
  }
  
  public int a(MotionEvent paramMotionEvent, int paramInt)
  {
    int i1 = (int)paramMotionEvent.getX();
    int i2 = (int)paramMotionEvent.getY();
    i1 = this.i.pointToPosition(i1, i2);
    i2 = this.i.getHeaderViewsCount();
    int i3 = this.i.getFooterViewsCount();
    int i4 = this.i.getCount();
    if ((i1 != -1) && (i1 >= i2) && (i1 < i4 - i3))
    {
      Object localObject = this.i;
      localObject = ((DragSortListView)localObject).getChildAt(i1 - ((DragSortListView)localObject).getFirstVisiblePosition());
      i2 = (int)paramMotionEvent.getRawX();
      i3 = (int)paramMotionEvent.getRawY();
      if (paramInt == 0) {
        paramMotionEvent = (MotionEvent)localObject;
      } else {
        paramMotionEvent = ((View)localObject).findViewById(paramInt);
      }
      if (paramMotionEvent != null)
      {
        paramMotionEvent.getLocationOnScreen(this.s);
        int[] arrayOfInt = this.s;
        if ((i2 > arrayOfInt[0]) && (i3 > arrayOfInt[1]) && (i2 < arrayOfInt[0] + paramMotionEvent.getWidth()) && (i3 < this.s[1] + paramMotionEvent.getHeight()))
        {
          this.t = ((View)localObject).getLeft();
          this.u = ((View)localObject).getTop();
          return i1;
        }
      }
    }
    return -1;
  }
  
  public void a(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void a(View paramView, Point paramPoint1, Point paramPoint2)
  {
    if ((this.b) && (this.c)) {
      this.A = paramPoint1.x;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1;
    if ((this.m) && (!this.c)) {
      i1 = 12;
    } else {
      i1 = 0;
    }
    int i2 = i1;
    if (this.b)
    {
      i2 = i1;
      if (this.c) {
        i2 = i1 | 0x1 | 0x2;
      }
    }
    DragSortListView localDragSortListView = this.i;
    this.h = localDragSortListView.a(paramInt1 - localDragSortListView.getHeaderViewsCount(), i2, paramInt2, paramInt3);
    return this.h;
  }
  
  public int b(MotionEvent paramMotionEvent)
  {
    if (this.n == 1) {
      return d(paramMotionEvent);
    }
    return -1;
  }
  
  public void b(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public int c(MotionEvent paramMotionEvent)
  {
    return a(paramMotionEvent, this.w);
  }
  
  public void c(int paramInt)
  {
    this.a = paramInt;
  }
  
  public int d(MotionEvent paramMotionEvent)
  {
    return a(paramMotionEvent, this.y);
  }
  
  public void d(int paramInt)
  {
    this.w = paramInt;
  }
  
  public void e(int paramInt)
  {
    this.x = paramInt;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    if ((this.b) && (this.n == 0)) {
      this.r = a(paramMotionEvent, this.x);
    }
    int i1 = (int)paramMotionEvent.getX();
    int i2 = (int)paramMotionEvent.getY();
    this.k = this.i.pointToPosition(i1, i2);
    this.p = a(paramMotionEvent);
    i1 = this.p;
    if ((i1 != -1) && (this.l == 0)) {
      a(i1, (int)paramMotionEvent.getX() - this.t, (int)paramMotionEvent.getY() - this.u);
    }
    this.c = false;
    this.z = true;
    this.A = 0;
    this.q = b(paramMotionEvent);
    return true;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if ((this.p != -1) && (this.l == 2))
    {
      this.i.performHapticFeedback(0);
      a(this.p, this.f - this.t, this.g - this.u);
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (paramMotionEvent1 != null)
    {
      if (paramMotionEvent2 == null) {
        return false;
      }
      int i1 = (int)paramMotionEvent1.getX();
      int i2 = (int)paramMotionEvent1.getY();
      int i3 = (int)paramMotionEvent2.getX();
      int i4 = (int)paramMotionEvent2.getY();
      int i5 = i3 - this.t;
      int i6 = i4 - this.u;
      if ((this.z) && (!this.h) && ((this.p != -1) || (this.q != -1))) {
        if (this.p != -1)
        {
          if ((this.l == 1) && (Math.abs(i4 - i2) > this.o) && (this.m))
          {
            a(this.p, i5, i6);
            return false;
          }
          if ((this.l != 0) && (Math.abs(i3 - i1) > this.o) && (this.b))
          {
            this.c = true;
            a(this.q, i5, i6);
            return false;
          }
        }
        else if (this.q != -1)
        {
          if ((Math.abs(i3 - i1) > this.o) && (this.b))
          {
            this.c = true;
            a(this.q, i5, i6);
            return false;
          }
          if (Math.abs(i4 - i2) > this.o) {
            this.z = false;
          }
        }
      }
    }
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if ((this.b) && (this.n == 0))
    {
      int i1 = this.r;
      if (i1 != -1)
      {
        paramMotionEvent = this.i;
        paramMotionEvent.b(i1 - paramMotionEvent.getHeaderViewsCount());
      }
    }
    return true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i1;
    if ((this.i.d()) && (!this.i.b()))
    {
      this.d.onTouchEvent(paramMotionEvent);
      i1 = paramMotionEvent.getAction() & 0xFF;
      if (i1 != 0)
      {
        if (i1 != 1)
        {
          if (i1 != 3) {
            return false;
          }
        }
        else if ((this.b) && (this.c))
        {
          i1 = this.A;
          if (i1 < 0) {
            i1 = -i1;
          }
          if (i1 > this.i.getWidth() / 2) {
            this.i.a(false, 0.0F);
          }
        }
        this.c = false;
        this.h = false;
        return false;
      }
      this.f = ((int)paramMotionEvent.getX());
      this.g = ((int)paramMotionEvent.getY());
      return false;
    }
    if (!this.i.d())
    {
      if (paramMotionEvent.getAction() == 0)
      {
        i1 = (int)paramMotionEvent.getX();
        int i2 = (int)paramMotionEvent.getY();
        this.k = this.i.pointToPosition(i1, i2);
      }
      return this.e.onTouchEvent(paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortController
 * JD-Core Version:    0.7.0.1
 */