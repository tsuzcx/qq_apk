package com.tencent.mobileqq.emosm.view;

import acif;
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
  public float a;
  public int a;
  private GestureDetector.OnGestureListener jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener = new acif(this);
  GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  public DragSortListView a;
  boolean jdField_a_of_type_Boolean = false;
  private int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private float jdField_b_of_type_Float = 500.0F;
  int jdField_b_of_type_Int;
  GestureDetector jdField_b_of_type_AndroidViewGestureDetector;
  boolean jdField_b_of_type_Boolean = false;
  int c;
  public boolean c;
  public int d;
  private boolean d;
  private int jdField_e_of_type_Int = 0;
  private boolean jdField_e_of_type_Boolean;
  private int f;
  private int g;
  private int h = -1;
  private int i = -1;
  private int j = -1;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  
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
    this.jdField_d_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Float = (ViewConfiguration.getTouchSlop() + 2);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView = paramDragSortListView;
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramDragSortListView.getContext(), this);
    this.jdField_b_of_type_AndroidViewGestureDetector = new GestureDetector(paramDragSortListView.getContext(), this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener);
    this.jdField_b_of_type_AndroidViewGestureDetector.setIsLongpressEnabled(false);
    this.g = ViewConfiguration.get(paramDragSortListView.getContext()).getScaledTouchSlop();
    this.m = paramInt1;
    this.n = paramInt4;
    this.o = paramInt5;
    b(paramInt3);
    a(paramInt2);
    this.jdField_a_of_type_Int = 3;
  }
  
  public int a(MotionEvent paramMotionEvent)
  {
    return c(paramMotionEvent);
  }
  
  public int a(MotionEvent paramMotionEvent, int paramInt)
  {
    int i1 = (int)paramMotionEvent.getX();
    int i2 = (int)paramMotionEvent.getY();
    i1 = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.pointToPosition(i1, i2);
    i2 = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getHeaderViewsCount();
    int i3 = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getFooterViewsCount();
    int i4 = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getCount();
    if ((i1 != -1) && (i1 >= i2) && (i1 < i4 - i3))
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getChildAt(i1 - this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getFirstVisiblePosition());
      i3 = (int)paramMotionEvent.getRawX();
      i2 = (int)paramMotionEvent.getRawY();
      if (paramInt == 0) {}
      for (paramMotionEvent = localView; paramMotionEvent != null; paramMotionEvent = localView.findViewById(paramInt))
      {
        paramMotionEvent.getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
        if ((i3 <= this.jdField_a_of_type_ArrayOfInt[0]) || (i2 <= this.jdField_a_of_type_ArrayOfInt[1]) || (i3 >= this.jdField_a_of_type_ArrayOfInt[0] + paramMotionEvent.getWidth())) {
          break;
        }
        paramInt = this.jdField_a_of_type_ArrayOfInt[1];
        if (i2 >= paramMotionEvent.getHeight() + paramInt) {
          break;
        }
        this.k = localView.getLeft();
        this.l = localView.getTop();
        return i1;
      }
    }
    return -1;
  }
  
  public void a(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void a(View paramView, Point paramPoint1, Point paramPoint2)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean)) {
      this.p = paramPoint1.x;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i2 = 0;
    int i1 = i2;
    if (this.jdField_d_of_type_Boolean)
    {
      i1 = i2;
      if (!this.jdField_b_of_type_Boolean) {
        i1 = 12;
      }
    }
    i2 = i1;
    if (this.jdField_a_of_type_Boolean)
    {
      i2 = i1;
      if (this.jdField_b_of_type_Boolean) {
        i2 = i1 | 0x1 | 0x2;
      }
    }
    this.jdField_c_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.a(paramInt1 - this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getHeaderViewsCount(), i2, paramInt2, paramInt3);
    return this.jdField_c_of_type_Boolean;
  }
  
  public int b(MotionEvent paramMotionEvent)
  {
    if (this.f == 1) {
      return d(paramMotionEvent);
    }
    return -1;
  }
  
  public void b(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int c(MotionEvent paramMotionEvent)
  {
    return a(paramMotionEvent, this.m);
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int d(MotionEvent paramMotionEvent)
  {
    return a(paramMotionEvent, this.o);
  }
  
  public void d(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void e(int paramInt)
  {
    this.n = paramInt;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.f == 0)) {
      this.j = a(paramMotionEvent, this.n);
    }
    int i1 = (int)paramMotionEvent.getX();
    int i2 = (int)paramMotionEvent.getY();
    this.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.pointToPosition(i1, i2);
    this.h = a(paramMotionEvent);
    if ((this.h != -1) && (this.jdField_e_of_type_Int == 0)) {
      a(this.h, (int)paramMotionEvent.getX() - this.k, (int)paramMotionEvent.getY() - this.l);
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = true;
    this.p = 0;
    this.i = b(paramMotionEvent);
    return true;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if ((this.h != -1) && (this.jdField_e_of_type_Int == 2))
    {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.performHapticFeedback(0);
      a(this.h, this.jdField_b_of_type_Int - this.k, this.jdField_c_of_type_Int - this.l);
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {}
    int i2;
    int i4;
    do
    {
      int i1;
      int i3;
      int i5;
      int i6;
      do
      {
        do
        {
          do
          {
            return false;
            i1 = (int)paramMotionEvent1.getX();
            i2 = (int)paramMotionEvent1.getY();
            i3 = (int)paramMotionEvent2.getX();
            i4 = (int)paramMotionEvent2.getY();
            i5 = i3 - this.k;
            i6 = i4 - this.l;
          } while ((!this.jdField_e_of_type_Boolean) || (this.jdField_c_of_type_Boolean) || ((this.h == -1) && (this.i == -1)));
          if (this.h == -1) {
            break;
          }
          if ((this.jdField_e_of_type_Int == 1) && (Math.abs(i4 - i2) > this.g) && (this.jdField_d_of_type_Boolean))
          {
            a(this.h, i5, i6);
            return false;
          }
        } while ((this.jdField_e_of_type_Int == 0) || (Math.abs(i3 - i1) <= this.g) || (!this.jdField_a_of_type_Boolean));
        this.jdField_b_of_type_Boolean = true;
        a(this.i, i5, i6);
        return false;
      } while (this.i == -1);
      if ((Math.abs(i3 - i1) > this.g) && (this.jdField_a_of_type_Boolean))
      {
        this.jdField_b_of_type_Boolean = true;
        a(this.i, i5, i6);
        return false;
      }
    } while (Math.abs(i4 - i2) <= this.g);
    this.jdField_e_of_type_Boolean = false;
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.f == 0) && (this.j != -1)) {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.a(this.j - this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getHeaderViewsCount());
    }
    return true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.b()) || (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.a()))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.b())
      {
        if (paramMotionEvent.getAction() == 0)
        {
          i1 = (int)paramMotionEvent.getX();
          int i2 = (int)paramMotionEvent.getY();
          this.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.pointToPosition(i1, i2);
        }
        return this.jdField_b_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
      }
      return false;
    }
    this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    case 2: 
    default: 
    case 0: 
      for (;;)
      {
        return false;
        this.jdField_b_of_type_Int = ((int)paramMotionEvent.getX());
        this.jdField_c_of_type_Int = ((int)paramMotionEvent.getY());
      }
    case 1: 
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean)) {
        if (this.p < 0) {
          break label209;
        }
      }
      break;
    }
    label209:
    for (int i1 = this.p;; i1 = -this.p)
    {
      if (i1 > this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getWidth() / 2) {
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.a(false, 0.0F);
      }
      this.jdField_b_of_type_Boolean = false;
      this.jdField_c_of_type_Boolean = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortController
 * JD-Core Version:    0.7.0.1
 */