package com.tencent.mobileqq.emosm.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qqui.R.styleable;
import com.tencent.mobileqq.widget.ProgressCircle;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.util.VersionUtils;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;

public class DragSortListView
  extends XListView
{
  private DataSetObserver A;
  private float B = 1.0F;
  private float C = 1.0F;
  private boolean D = false;
  private int E;
  private int F;
  private int G;
  private DragSortListView.DragListener H;
  private DragSortListView.DropListener I;
  private DragSortListView.RemoveListener J;
  private DragSortListView.LeftEventListener K;
  private boolean L = true;
  private boolean M = false;
  private int N = 0;
  private View[] O = new View[1];
  private DragSortListView.DragScroller P;
  private float Q = 0.3333333F;
  private float R = 0.3333333F;
  private int S;
  private int T;
  private int U;
  private int V;
  private int W;
  private int Z = 0;
  Point a = new Point();
  private boolean aa = false;
  private boolean ab = false;
  private DragSortListView.FloatViewManager ac = null;
  private MotionEvent ad;
  private int ae = 0;
  private float af = 0.25F;
  private float ag = 0.0F;
  private DragSortListView.AdapterWrapper ah;
  private boolean ai = false;
  private DragSortListView.DragSortTracker aj;
  private boolean ak = false;
  private boolean al = false;
  private DragSortListView.HeightCache am = new DragSortListView.HeightCache(this, 3);
  private DragSortListView.RemoveAnimator an;
  private DragSortListView.LiftAnimator ao;
  private DragSortListView.DropAnimator ap;
  private boolean aq;
  private long ar = 0L;
  private boolean as = false;
  private boolean at;
  private boolean au;
  private boolean av = true;
  private boolean aw;
  private boolean ax = false;
  private boolean ay;
  private Rect az = null;
  int b;
  int c;
  int d;
  int e;
  int f;
  int g;
  int h = 0;
  int i = 1;
  int j;
  int k;
  float l;
  float m;
  float n;
  float o;
  float p = 0.5F;
  DragSortListView.DragScrollProfile q = new DragSortListView.1(this);
  int r;
  int s;
  boolean t;
  float u = 0.0F;
  int v = -1;
  int w;
  private View x;
  private Point y = new Point();
  private boolean z = false;
  
  public DragSortListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i1 = 150;
    int i2;
    if (paramAttributeSet != null)
    {
      paramContext = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.Y, 0, 0);
      this.i = Math.max(1, paramContext.getDimensionPixelSize(R.styleable.aa, 1));
      this.ai = paramContext.getBoolean(R.styleable.aq, false);
      if (this.ai) {
        this.aj = new DragSortListView.DragSortTracker(this);
      }
      this.B = paramContext.getFloat(R.styleable.ah, this.B);
      this.C = this.B;
      this.L = paramContext.getBoolean(R.styleable.ab, this.L);
      this.M = paramContext.getBoolean(R.styleable.aj, this.M);
      this.af = Math.max(0.0F, Math.min(1.0F, 1.0F - paramContext.getFloat(R.styleable.ao, 0.75F)));
      boolean bool1;
      if (this.af > 0.0F) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.D = bool1;
      setDragScrollStart(paramContext.getFloat(R.styleable.ad, this.Q));
      this.p = paramContext.getFloat(R.styleable.ak, this.p);
      i1 = paramContext.getInt(R.styleable.al, 150);
      i2 = paramContext.getInt(R.styleable.af, 150);
      if (paramContext.getBoolean(R.styleable.ar, true))
      {
        bool1 = paramContext.getBoolean(R.styleable.am, false);
        int i3 = paramContext.getInt(R.styleable.an, 1);
        boolean bool2 = paramContext.getBoolean(R.styleable.ap, true);
        int i4 = paramContext.getInt(R.styleable.ae, 0);
        int i5 = paramContext.getResourceId(R.styleable.ac, 0);
        int i6 = paramContext.getResourceId(R.styleable.ag, 0);
        int i7 = paramContext.getResourceId(R.styleable.Z, 0);
        int i8 = paramContext.getColor(R.styleable.ai, -16777216);
        paramAttributeSet = new DragSortController(this, i5, i4, i3, i7, i6);
        paramAttributeSet.b(bool1);
        paramAttributeSet.a(bool2);
        paramAttributeSet.g(i8);
        this.ac = paramAttributeSet;
        super.setOnTouchListener(paramAttributeSet);
      }
      paramContext.recycle();
    }
    else
    {
      i2 = 150;
    }
    this.P = new DragSortListView.DragScroller(this);
    this.aq = true;
    if (i1 > 0) {
      this.an = new DragSortListView.RemoveAnimator(this, 0.5F, i1);
    }
    if (i2 > 0) {
      this.ap = new DragSortListView.DropAnimator(this, 0.5F, i2);
    }
    this.ad = MotionEvent.obtain(0L, 0L, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0, 0.0F, 0.0F, 0, 0);
    this.A = new DragSortListView.2(this);
  }
  
  private int a(int paramInt1, View paramView, int paramInt2, int paramInt3)
  {
    int i2 = c(paramInt1);
    int i4 = paramView.getHeight();
    int i5 = d(paramInt1, i2);
    int i1;
    if (paramInt1 != this.f)
    {
      i1 = i4 - i2;
      i2 = i5 - i2;
    }
    else
    {
      i1 = i4;
      i2 = i5;
    }
    int i6 = this.j;
    int i7 = this.f;
    int i3 = i6;
    if (i7 != this.d)
    {
      i3 = i6;
      if (i7 != this.e) {
        i3 = i6 - this.i;
      }
    }
    i6 = 0;
    if (paramInt1 <= paramInt2)
    {
      paramInt2 = i6;
      if (paramInt1 > this.d) {
        return 0 + (i3 - i2);
      }
    }
    else
    {
      if (paramInt1 == paramInt3)
      {
        if (paramInt1 <= this.d) {
          i1 -= i3;
        }
        while (paramInt1 != this.e) {
          return 0 + i1;
        }
        return 0 + (i4 - i5);
      }
      if (paramInt1 <= this.d) {
        return 0 - i3;
      }
      paramInt2 = i6;
      if (paramInt1 == this.e) {
        paramInt2 = 0 - i2;
      }
    }
    return paramInt2;
  }
  
  private void a(int paramInt, Canvas paramCanvas)
  {
    Drawable localDrawable = super.getDivider();
    int i4 = super.getDividerHeight();
    if ((localDrawable != null) && (i4 != 0))
    {
      ViewGroup localViewGroup = (ViewGroup)super.getChildAt(paramInt - getFirstVisiblePosition());
      if (localViewGroup != null)
      {
        int i2 = super.getPaddingLeft();
        int i3 = super.getWidth() - super.getPaddingRight();
        int i1 = localViewGroup.getChildAt(0).getHeight();
        if (paramInt > this.f)
        {
          i1 = localViewGroup.getTop() + i1;
          paramInt = i4 + i1;
        }
        else
        {
          i1 = localViewGroup.getBottom() - i1;
          paramInt = i1;
          i1 -= i4;
        }
        paramCanvas.save();
        paramCanvas.clipRect(i2, i1, i3, paramInt);
        localDrawable.setBounds(i2, i1, i3, paramInt);
        localDrawable.draw(paramCanvas);
        paramCanvas.restore();
      }
    }
  }
  
  private void a(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    Object localObject = localLayoutParams;
    if (localLayoutParams == null)
    {
      localObject = new AbsListView.LayoutParams(-1, -2);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    int i2 = ViewGroup.getChildMeasureSpec(this.N, getListPaddingLeft() + getListPaddingRight(), ((ViewGroup.LayoutParams)localObject).width);
    int i1;
    if (((ViewGroup.LayoutParams)localObject).height > 0) {
      i1 = View.MeasureSpec.makeMeasureSpec(((ViewGroup.LayoutParams)localObject).height, 1073741824);
    } else {
      i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
    }
    paramView.measure(i2, i1);
  }
  
  private boolean a(View paramView, int paramInt1, int paramInt2)
  {
    if (this.az == null) {
      this.az = new Rect();
    }
    paramView.getDrawingRect(this.az);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    paramView = this.az;
    paramView.left = arrayOfInt[0];
    paramView.top = arrayOfInt[1];
    paramView.right += arrayOfInt[0];
    paramView = this.az;
    paramView.bottom += arrayOfInt[1];
    return this.az.contains(paramInt1, paramInt2);
  }
  
  private void b(int paramInt, View paramView, boolean paramBoolean)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if ((paramInt != this.f) && (paramInt != this.d) && (paramInt != this.e)) {
      i1 = -2;
    } else {
      i1 = d(paramInt, paramView, paramBoolean);
    }
    if (i1 != localLayoutParams.height)
    {
      localLayoutParams.height = i1;
      paramView.setLayoutParams(localLayoutParams);
    }
    if ((paramInt == this.d) || (paramInt == this.e))
    {
      i1 = this.f;
      if (paramInt < i1) {
        ((DragSortItemView)paramView).setGravity(80);
      } else if (paramInt > i1) {
        ((DragSortItemView)paramView).setGravity(48);
      }
    }
    int i3 = paramView.getVisibility();
    int i2 = 0;
    int i1 = i2;
    if (paramInt == this.f)
    {
      i1 = i2;
      if (this.x != null) {
        i1 = 4;
      }
    }
    if (i1 != i3) {
      paramView.setVisibility(i1);
    }
  }
  
  private boolean b(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      if (this.ay)
      {
        if (this.at)
        {
          if (this.aq)
          {
            h();
            b(this.f);
            this.at = false;
          }
          else
          {
            paramMotionEvent = this.J;
            if (paramMotionEvent != null) {
              paramMotionEvent.a(this.f);
            }
            this.at = false;
            return false;
          }
        }
        else {
          g();
        }
        this.ay = false;
        return false;
      }
      Button localButton = (Button)b(this.w, 2131449134);
      if ((this.au) && (localButton != null))
      {
        this.au = false;
        this.av = true;
        return false;
      }
      if (!this.av)
      {
        this.av = true;
        return true;
      }
    }
    try
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (ArrayIndexOutOfBoundsException paramMotionEvent)
    {
      paramMotionEvent.printStackTrace();
    }
    return false;
  }
  
  private int c(int paramInt, View paramView, boolean paramBoolean)
  {
    if (paramInt == this.f) {
      return 0;
    }
    View localView = paramView;
    if (paramInt >= getHeaderViewsCount()) {
      if (paramInt >= getCount() - getFooterViewsCount()) {
        localView = paramView;
      } else {
        localView = ((ViewGroup)paramView).getChildAt(0);
      }
    }
    paramView = localView.getLayoutParams();
    if ((paramView != null) && (paramView.height > 0)) {
      return paramView.height;
    }
    paramInt = localView.getHeight();
    if ((paramInt == 0) || (paramBoolean))
    {
      a(localView);
      paramInt = localView.getMeasuredHeight();
    }
    return paramInt;
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    Point localPoint = this.a;
    localPoint.x = (paramInt1 - this.E);
    localPoint.y = (paramInt2 - this.g);
    b(true);
    paramInt1 = Math.min(paramInt2, this.b + this.k);
    paramInt2 = Math.max(paramInt2, this.b - this.k);
    int i1 = this.P.b();
    if ((paramInt1 > this.s) && (paramInt1 > this.T) && (i1 != 1))
    {
      if (i1 != -1) {
        this.P.a(true);
      }
      this.P.a(1);
      return;
    }
    if ((paramInt2 < this.s) && (paramInt2 < this.S) && (i1 != 0))
    {
      if (i1 != -1) {
        this.P.a(true);
      }
      this.P.a(0);
      return;
    }
    if ((paramInt2 >= this.S) && (paramInt1 <= this.T) && (this.P.a())) {
      this.P.a(true);
    }
  }
  
  private boolean c(MotionEvent paramMotionEvent)
  {
    boolean bool1 = this.aa;
    boolean bool2 = false;
    this.aa = false;
    if (!bool1) {
      d(paramMotionEvent);
    }
    int i1 = this.h;
    if (i1 == 4)
    {
      a(paramMotionEvent);
      return true;
    }
    bool1 = bool2;
    if (i1 == 0)
    {
      bool1 = bool2;
      if (super.onTouchEvent(paramMotionEvent)) {
        bool1 = true;
      }
    }
    i1 = paramMotionEvent.getAction() & 0xFF;
    if ((i1 != 1) && (i1 != 3))
    {
      if (bool1)
      {
        this.ae = 1;
        return bool1;
      }
    }
    else {
      o();
    }
    return bool1;
  }
  
  private int d(int paramInt1, int paramInt2)
  {
    getDividerHeight();
    if ((this.D) && (this.d != this.e)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i4 = this.j;
    int i5 = this.i;
    int i2 = i4 - i5;
    int i3 = (int)(this.ag * i2);
    int i6 = this.f;
    if (paramInt1 == i6)
    {
      if (i6 == this.d)
      {
        if (i1 != 0) {
          return i3 + i5;
        }
        return i4;
      }
      if (i6 == this.e) {
        return i4 - i3;
      }
      if (this.h == 0) {
        return paramInt2;
      }
      return i5;
    }
    if (paramInt1 == this.d)
    {
      if (i1 != 0) {
        return paramInt2 + i3;
      }
      return paramInt2 + i2;
    }
    int i1 = paramInt2;
    if (paramInt1 == this.e) {
      i1 = paramInt2 + i2 - i3;
    }
    return i1;
  }
  
  private int d(int paramInt, View paramView, boolean paramBoolean)
  {
    return d(paramInt, c(paramInt, paramView, paramBoolean));
  }
  
  private void d(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if (i1 != 0)
    {
      this.V = this.U;
      this.s = this.r;
    }
    this.U = ((int)paramMotionEvent.getX());
    this.r = ((int)paramMotionEvent.getY());
    if (i1 == 0)
    {
      this.V = this.U;
      this.s = this.r;
    }
    this.F = ((int)paramMotionEvent.getRawX() - this.U);
    this.G = ((int)paramMotionEvent.getRawY() - this.r);
  }
  
  private void e(int paramInt)
  {
    this.h = 1;
    DragSortListView.RemoveListener localRemoveListener = this.J;
    if (localRemoveListener != null) {
      localRemoveListener.a(paramInt);
    }
    c();
    n();
    k();
    if (this.ab)
    {
      this.h = 3;
      return;
    }
    this.h = 0;
  }
  
  private ImageView f(int paramInt)
  {
    paramInt -= getFirstVisiblePosition();
    if ((paramInt >= 0) && (paramInt <= getChildCount()))
    {
      View localView = super.getChildAt(paramInt);
      if (localView != null) {
        return (ImageView)localView.findViewById(2131432455);
      }
    }
    return null;
  }
  
  private boolean j()
  {
    int i1 = super.getFirstVisiblePosition();
    int i3 = this.d;
    View localView = super.getChildAt(i3 - i1);
    Object localObject = localView;
    if (localView == null)
    {
      i3 = getChildCount() / 2 + i1;
      localObject = super.getChildAt(i3 - i1);
    }
    i1 = ((View)localObject).getTop();
    int i6 = ((View)localObject).getHeight();
    int i2 = a(i3, i1);
    int i7 = super.getDividerHeight();
    int i5;
    int i4;
    if (this.b < i2)
    {
      for (;;)
      {
        i5 = i3;
        i4 = i2;
        if (i3 < 0) {
          break;
        }
        i3 -= 1;
        i4 = a(i3);
        if (i3 == 0)
        {
          i1 = i1 - i7 - i4;
          break label279;
        }
        i4 = i1 - (i4 + i7);
        i1 = a(i3, i4);
        if (this.b >= i1) {
          break label279;
        }
        i2 = i1;
        i1 = i4;
      }
      i1 = i4;
      i3 = i5;
      i2 = i4;
    }
    else
    {
      i8 = getCount();
      for (;;)
      {
        i5 = i3;
        i4 = i2;
        if (i3 >= i8) {
          break;
        }
        if (i3 == i8 - 1)
        {
          i1 = i1 + i7 + i6;
          break label279;
        }
        i4 = i1 + (i6 + i7);
        i5 = i3 + 1;
        i6 = a(i5);
        i1 = a(i5, i4);
        if (this.b < i1) {
          break label279;
        }
        i3 = i5;
        i2 = i1;
        i1 = i4;
      }
    }
    label279:
    i6 = super.getHeaderViewsCount();
    int i9 = super.getFooterViewsCount();
    boolean bool = false;
    i7 = this.d;
    int i8 = this.e;
    float f1 = this.ag;
    if (this.D)
    {
      int i10 = Math.abs(i1 - i2);
      i5 = i1;
      i4 = i2;
      if (this.b < i1)
      {
        i4 = i1;
        i5 = i2;
      }
      i1 = (int)(this.af * 0.5F * i10);
      float f2 = i1;
      i2 = i5 + i1;
      i5 = this.b;
      if (i5 < i2)
      {
        this.d = (i3 - 1);
        this.e = i3;
        this.ag = ((i2 - i5) * 0.5F / f2);
      }
      else if (i5 < i4 - i1)
      {
        this.d = i3;
        this.e = i3;
      }
      else
      {
        this.d = i3;
        this.e = (i3 + 1);
        this.ag = (((i4 - i5) / f2 + 1.0F) * 0.5F);
      }
    }
    else
    {
      this.d = i3;
      this.e = i3;
    }
    if (this.d < i6)
    {
      this.d = i6;
      this.e = i6;
      i3 = i6;
    }
    else if (this.e >= getCount() - i9)
    {
      i3 = super.getCount() - i9 - 1;
      this.d = i3;
      this.e = i3;
    }
    if ((this.d != i7) || (this.e != i8) || (this.ag != f1)) {
      bool = true;
    }
    i1 = this.c;
    if (i3 != i1)
    {
      localObject = this.H;
      if (localObject != null) {
        ((DragSortListView.DragListener)localObject).a(i1 - i6, i3 - i6);
      }
      this.c = i3;
      return true;
    }
    return bool;
  }
  
  private void k()
  {
    this.f = -1;
    this.d = -1;
    this.e = -1;
    this.c = -1;
  }
  
  private void l()
  {
    this.h = 2;
    if (this.I != null)
    {
      int i1 = this.c;
      if ((i1 >= 0) && (i1 < getCount()))
      {
        i1 = getHeaderViewsCount();
        this.I.a_(this.f - i1, this.c - i1);
      }
    }
    c();
    n();
    k();
    q();
    if (this.ab)
    {
      this.h = 3;
      return;
    }
    this.h = 0;
  }
  
  private void m()
  {
    e(this.f - getHeaderViewsCount());
  }
  
  private void n()
  {
    int i2 = super.getFirstVisiblePosition();
    if (this.f < i2)
    {
      int i1 = 0;
      View localView = super.getChildAt(0);
      if (localView != null) {
        i1 = localView.getTop();
      }
      super.setSelectionFromTop(i2 - 1, i1 - getPaddingTop());
    }
  }
  
  private void o()
  {
    this.ae = 0;
    this.ab = false;
    if (this.h == 3) {
      this.h = 0;
    }
    this.C = this.B;
    this.as = false;
    this.am.a();
  }
  
  private void p()
  {
    int i1 = getPaddingTop();
    int i2 = getHeight() - i1 - getPaddingBottom();
    float f2 = i2;
    float f1 = i1;
    this.m = (this.Q * f2 + f1);
    this.l = ((1.0F - this.R) * f2 + f1);
    f2 = this.m;
    this.S = ((int)f2);
    float f3 = this.l;
    this.T = ((int)f3);
    this.n = (f2 - f1);
    this.o = (i1 + i2 - f3);
  }
  
  private void q()
  {
    int i2 = getFirstVisiblePosition();
    int i3 = getLastVisiblePosition();
    int i1 = Math.max(0, getHeaderViewsCount() - i2);
    i3 = Math.min(i3 - i2, getCount() - 1 - getFooterViewsCount() - i2);
    while (i1 <= i3)
    {
      View localView = getChildAt(i1);
      if (localView != null) {
        b(i2 + i1, localView, false);
      }
      i1 += 1;
    }
  }
  
  private void r()
  {
    View localView = this.x;
    if (localView != null)
    {
      a(localView);
      this.j = this.x.getMeasuredHeight();
      this.k = (this.j / 2);
    }
  }
  
  private void s()
  {
    if (this.ac != null)
    {
      this.y.set(this.U, this.r);
      this.ac.a(this.x, this.a, this.y);
    }
    int i1 = this.a.x;
    int i4 = this.a.y;
    int i2 = getPaddingLeft();
    if (((this.Z & 0x1) == 0) && (i1 > i2)) {
      this.a.x = i2;
    } else if (((this.Z & 0x2) == 0) && (i1 < i2)) {
      this.a.x = i2;
    }
    i2 = getHeaderViewsCount();
    int i3 = getFooterViewsCount();
    int i5 = getFirstVisiblePosition();
    int i6 = getLastVisiblePosition();
    i1 = getPaddingTop();
    if (i5 < i2) {
      i1 = getChildAt(i2 - i5 - 1).getBottom();
    }
    i2 = i1;
    int i7;
    if ((this.Z & 0x8) == 0)
    {
      i7 = this.f;
      i2 = i1;
      if (i5 <= i7) {
        i2 = Math.max(getChildAt(i7 - i5).getTop(), i1);
      }
    }
    i1 = getHeight() - getPaddingBottom();
    if (i6 >= getCount() - i3 - 1) {
      i1 = getChildAt(getCount() - i3 - 1 - i5).getBottom();
    }
    i3 = i1;
    if ((this.Z & 0x4) == 0)
    {
      i7 = this.f;
      i3 = i1;
      if (i6 >= i7) {
        i3 = Math.min(getChildAt(i7 - i5).getBottom(), i1);
      }
    }
    if (i4 < i2)
    {
      this.a.y = i2;
    }
    else
    {
      i1 = this.j;
      if (i4 + i1 > i3) {
        this.a.y = (i3 - i1);
      }
    }
    this.b = (this.a.y + this.k);
  }
  
  int a(int paramInt)
  {
    View localView = super.getChildAt(paramInt - getFirstVisiblePosition());
    if (localView != null) {
      return localView.getHeight();
    }
    return d(paramInt, c(paramInt));
  }
  
  int a(int paramInt1, int paramInt2)
  {
    int i2 = super.getHeaderViewsCount();
    int i3 = super.getFooterViewsCount();
    int i1 = paramInt2;
    if (paramInt1 > i2)
    {
      if (paramInt1 >= getCount() - i3) {
        return paramInt2;
      }
      i3 = super.getDividerHeight();
      i2 = this.j - this.i;
      int i4 = c(paramInt1);
      int i5 = a(paramInt1);
      i1 = this.e;
      int i6 = this.f;
      if (i1 <= i6)
      {
        if ((paramInt1 == i1) && (this.d != i1))
        {
          if (paramInt1 == i6)
          {
            paramInt2 += i5;
            i1 = this.j;
          }
          else
          {
            paramInt2 += i5 - i4;
            i1 = i2;
          }
        }
        else
        {
          i1 = paramInt2;
          if (paramInt1 <= this.e) {
            break label212;
          }
          i1 = paramInt2;
          if (paramInt1 > this.f) {
            break label212;
          }
          i1 = i2;
        }
        i1 = paramInt2 - i1;
      }
      else if ((paramInt1 > i6) && (paramInt1 <= this.d))
      {
        i1 = paramInt2 + i2;
      }
      else
      {
        i2 = this.e;
        i1 = paramInt2;
        if (paramInt1 == i2)
        {
          i1 = paramInt2;
          if (this.d != i2) {
            i1 = paramInt2 + (i5 - i4);
          }
        }
      }
      label212:
      if (paramInt1 <= this.f) {
        return i1 + (this.j - i3 - c(paramInt1 - 1)) / 2;
      }
      i1 += (i4 - i3 - this.j) / 2;
    }
    return i1;
  }
  
  public void a()
  {
    if (this.h == 4)
    {
      this.P.a(true);
      c();
      k();
      q();
      if (this.ab)
      {
        this.h = 3;
        return;
      }
      this.h = 0;
    }
  }
  
  public void a(int paramInt, float paramFloat)
  {
    int i1 = this.h;
    if ((i1 == 0) || (i1 == 4))
    {
      if (this.h == 0)
      {
        this.f = (getHeaderViewsCount() + paramInt);
        i1 = this.f;
        this.d = i1;
        this.e = i1;
        this.c = i1;
        localObject = super.getChildAt(i1 - getFirstVisiblePosition());
        if (localObject != null) {
          ((View)localObject).setVisibility(4);
        }
      }
      this.h = 1;
      this.u = paramFloat;
      if (this.ab)
      {
        i1 = this.ae;
        if (i1 != 1)
        {
          if (i1 == 2) {
            super.onInterceptTouchEvent(this.ad);
          }
        }
        else {
          super.onTouchEvent(this.ad);
        }
      }
      Object localObject = this.an;
      if (localObject != null)
      {
        ((DragSortListView.RemoveAnimator)localObject).c();
        return;
      }
      e(paramInt);
    }
  }
  
  void a(int paramInt, View paramView, boolean paramBoolean)
  {
    this.ak = true;
    s();
    int i1 = this.d;
    int i2 = this.e;
    boolean bool = j();
    if (bool)
    {
      q();
      i1 = a(paramInt, paramView, i1, i2);
      setSelectionFromTop(paramInt, paramView.getTop() + i1 - getPaddingTop());
      layoutChildren();
    }
    if ((bool) || (paramBoolean)) {
      invalidate();
    }
    this.ak = false;
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.ab)
    {
      Object localObject = this.ac;
      if (localObject == null) {
        return false;
      }
      localObject = ((DragSortListView.FloatViewManager)localObject).f(paramInt1);
      if (localObject == null) {
        return false;
      }
      return a(paramInt1, (View)localObject, paramInt2, paramInt3, paramInt4);
    }
    return false;
  }
  
  public boolean a(int paramInt1, View paramView, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.h == 0) && (this.ab) && (this.x == null) && (paramView != null))
    {
      if (!this.L) {
        return false;
      }
      if (getParent() != null) {
        getParent().requestDisallowInterceptTouchEvent(true);
      }
      paramInt1 += getHeaderViewsCount();
      this.d = paramInt1;
      this.e = paramInt1;
      this.f = paramInt1;
      this.c = paramInt1;
      this.h = 4;
      this.Z = 0;
      this.Z = (paramInt2 | this.Z);
      this.x = paramView;
      r();
      this.E = paramInt3;
      this.g = paramInt4;
      paramInt1 = this.r;
      this.W = paramInt1;
      paramView = this.a;
      paramView.x = (this.U - this.E);
      paramView.y = (paramInt1 - this.g);
      paramView = getChildAt(this.f - getFirstVisiblePosition());
      if (paramView != null) {
        paramView.setVisibility(4);
      }
      if (this.ai) {
        this.aj.a();
      }
      paramInt1 = this.ae;
      if (paramInt1 != 1)
      {
        if (paramInt1 == 2) {
          super.onInterceptTouchEvent(this.ad);
        }
      }
      else {
        super.onTouchEvent(this.ad);
      }
      requestLayout();
      paramView = this.ao;
      if (paramView != null) {
        paramView.c();
      }
      return true;
    }
    return false;
  }
  
  protected boolean a(MotionEvent paramMotionEvent)
  {
    paramMotionEvent.getAction();
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3) {
          return true;
        }
        if (this.h == 4) {
          a();
        }
        o();
        return true;
      }
      c((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      return true;
    }
    if (this.h == 4) {
      a(false);
    }
    o();
    return true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.t = false;
    return b(paramBoolean, 0.0F);
  }
  
  public boolean a(boolean paramBoolean, float paramFloat)
  {
    this.t = true;
    return b(paramBoolean, paramFloat);
  }
  
  public View b(int paramInt1, int paramInt2)
  {
    paramInt1 -= super.getFirstVisiblePosition();
    if ((paramInt1 >= 0) && (paramInt1 <= getChildCount()))
    {
      View localView = super.getChildAt(paramInt1);
      if (localView != null) {
        return localView.findViewById(paramInt2);
      }
    }
    return null;
  }
  
  public void b(int paramInt)
  {
    this.t = false;
    a(paramInt, 0.0F);
  }
  
  void b(boolean paramBoolean)
  {
    int i1 = getFirstVisiblePosition();
    int i2 = getChildCount() / 2;
    View localView = getChildAt(getChildCount() / 2);
    if (localView == null) {
      return;
    }
    a(i1 + i2, localView, paramBoolean);
  }
  
  public boolean b()
  {
    return this.as;
  }
  
  public boolean b(boolean paramBoolean, float paramFloat)
  {
    if (this.x != null)
    {
      this.P.a(true);
      if (paramBoolean)
      {
        a(this.f - getHeaderViewsCount(), paramFloat);
      }
      else
      {
        DragSortListView.DropAnimator localDropAnimator = this.ap;
        if (localDropAnimator != null) {
          localDropAnimator.c();
        } else {
          l();
        }
      }
      if (this.ai) {
        this.aj.d();
      }
      return true;
    }
    return false;
  }
  
  int c(int paramInt)
  {
    if (paramInt == this.f) {
      return 0;
    }
    Object localObject = getChildAt(paramInt - getFirstVisiblePosition());
    if (localObject != null) {
      return c(paramInt, (View)localObject, false);
    }
    int i1 = this.am.a(paramInt);
    if (i1 != -1) {
      return i1;
    }
    localObject = getAdapter();
    i1 = ((ListAdapter)localObject).getItemViewType(paramInt);
    int i2 = ((ListAdapter)localObject).getViewTypeCount();
    if (i2 != this.O.length) {
      this.O = new View[i2];
    }
    if (i1 >= 0)
    {
      View[] arrayOfView = this.O;
      if (arrayOfView[i1] == null)
      {
        localObject = ((ListAdapter)localObject).getView(paramInt, null, this);
        this.O[i1] = localObject;
      }
      else
      {
        localObject = ((ListAdapter)localObject).getView(paramInt, arrayOfView[i1], this);
      }
    }
    else
    {
      localObject = ((ListAdapter)localObject).getView(paramInt, null, this);
    }
    i1 = c(paramInt, (View)localObject, true);
    this.am.a(paramInt, i1);
    return i1;
  }
  
  void c()
  {
    Object localObject = this.x;
    if (localObject != null)
    {
      ((View)localObject).setVisibility(8);
      localObject = this.ac;
      if (localObject != null) {
        ((DragSortListView.FloatViewManager)localObject).a(this.x);
      }
      this.x = null;
      invalidate();
    }
  }
  
  public ShaderAnimLayout d(int paramInt)
  {
    paramInt -= super.getFirstVisiblePosition();
    if ((paramInt >= 0) && (paramInt <= super.getChildCount()))
    {
      View localView = super.getChildAt(paramInt);
      if (localView != null) {
        return (ShaderAnimLayout)localView.findViewById(2131445741);
      }
    }
    return null;
  }
  
  public boolean d()
  {
    return this.L;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    int i1;
    if (this.h != 0)
    {
      i1 = this.d;
      if (i1 != this.f) {
        a(i1, paramCanvas);
      }
      i1 = this.e;
      if ((i1 != this.d) && (i1 != this.f)) {
        a(i1, paramCanvas);
      }
    }
    View localView = this.x;
    if (localView != null)
    {
      int i3 = localView.getWidth();
      int i4 = this.x.getHeight();
      int i2 = this.a.x;
      int i5 = getWidth();
      i1 = i2;
      if (i2 < 0) {
        i1 = -i2;
      }
      float f1;
      if (i1 < i5)
      {
        f1 = (i5 - i1) / i5;
        f1 *= f1;
      }
      else
      {
        f1 = 0.0F;
      }
      i1 = (int)(this.C * 255.0F * f1);
      paramCanvas.save();
      paramCanvas.translate(this.a.x, this.a.y);
      paramCanvas.clipRect(0, 0, i3, i4);
      paramCanvas.saveLayerAlpha(0.0F, 0.0F, i3, i4, i1, 31);
      this.x.draw(paramCanvas);
      paramCanvas.restore();
      paramCanvas.restore();
    }
  }
  
  public boolean e()
  {
    return this.P.a();
  }
  
  public void f()
  {
    if (this.ay) {
      return;
    }
    Object localObject = d(this.f);
    if (localObject != null)
    {
      ((ShaderAnimLayout)localObject).a();
      this.ay = true;
      localObject = (RelativeLayout)b(this.f, 2131449135);
      if (localObject == null) {
        return;
      }
      ProgressCircle localProgressCircle = (ProgressCircle)((RelativeLayout)localObject).findViewById(2131449136);
      if ((((RelativeLayout)localObject).getVisibility() == 0) && (localProgressCircle.getVisibility() == 0))
      {
        ((RelativeLayout)localObject).setVisibility(8);
        this.v = this.f;
      }
    }
  }
  
  public void g()
  {
    Object localObject = d(this.f);
    if (localObject != null)
    {
      ((ShaderAnimLayout)localObject).e();
      this.ay = false;
      int i1 = this.v;
      if (i1 >= 0)
      {
        localObject = (RelativeLayout)b(i1, 2131449135);
        if ((localObject != null) && (((ProgressCircle)((RelativeLayout)localObject).findViewById(2131449136)).getVisibility() == 0)) {
          ((RelativeLayout)localObject).setVisibility(0);
        }
      }
    }
  }
  
  public float getFloatAlpha()
  {
    return this.C;
  }
  
  public ListAdapter getInputAdapter()
  {
    DragSortListView.AdapterWrapper localAdapterWrapper = this.ah;
    if (localAdapterWrapper == null) {
      return null;
    }
    return localAdapterWrapper.a();
  }
  
  public void h()
  {
    Object localObject = d(this.f);
    if (localObject != null)
    {
      ((ShaderAnimLayout)localObject).g();
      this.ay = false;
      int i1 = this.v;
      if (i1 >= 0)
      {
        localObject = (RelativeLayout)b(i1, 2131449135);
        if (localObject == null) {
          return;
        }
        if (((ProgressCircle)((RelativeLayout)localObject).findViewById(2131449136)).getVisibility() == 0) {
          ((RelativeLayout)localObject).setVisibility(0);
        }
      }
    }
  }
  
  public void i()
  {
    if ((this.ay) && (VersionUtils.m()) && (AppSetting.e))
    {
      if (this.aq)
      {
        h();
        b(this.f);
        this.at = false;
      }
      else
      {
        DragSortListView.RemoveListener localRemoveListener = this.J;
        if (localRemoveListener != null) {
          localRemoveListener.a(this.f);
        }
        this.at = false;
      }
      this.ay = false;
    }
  }
  
  protected void layoutChildren()
  {
    super.layoutChildren();
    View localView = this.x;
    if (localView != null)
    {
      if ((localView.isLayoutRequested()) && (!this.z)) {
        r();
      }
      localView = this.x;
      localView.layout(0, 0, localView.getMeasuredWidth(), this.x.getMeasuredHeight());
      this.z = false;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.ai) {
      this.aj.b();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i2;
    if (!this.L)
    {
      i1 = (int)paramMotionEvent.getRawX();
      i2 = (int)paramMotionEvent.getRawY();
      if (this.ay)
      {
        paramMotionEvent = d(this.f);
        if (paramMotionEvent == null) {
          return false;
        }
        if (a(paramMotionEvent, i1, i2))
        {
          this.at = true;
          return true;
        }
        g();
        this.av = false;
        return true;
      }
      paramMotionEvent = (Button)b(this.w, 2131449134);
      if (paramMotionEvent == null) {
        return false;
      }
      if (a(paramMotionEvent, i1, i2))
      {
        this.au = true;
        return false;
      }
      return true;
    }
    int i1 = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    ImageView localImageView = f(i1);
    if ((localImageView != null) && (a(localImageView, (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())))
    {
      if ((this.ay) && (this.f != i1))
      {
        this.aw = false;
        return true;
      }
      this.f = i1;
      this.aw = true;
      return true;
    }
    if (this.ay)
    {
      i1 = (int)paramMotionEvent.getRawX();
      i2 = (int)paramMotionEvent.getRawY();
      paramMotionEvent = d(this.f);
      if (paramMotionEvent == null) {
        return false;
      }
      if (a(paramMotionEvent, i1, i2)) {
        this.at = true;
      }
      return true;
    }
    d(paramMotionEvent);
    this.aa = true;
    i1 = paramMotionEvent.getAction() & 0xFF;
    if (i1 == 0)
    {
      if (this.h != 0)
      {
        this.al = true;
        return true;
      }
      this.ab = true;
    }
    boolean bool;
    if (this.x != null)
    {
      bool = true;
    }
    else
    {
      if (super.onInterceptTouchEvent(paramMotionEvent))
      {
        this.as = true;
        bool = true;
      }
      else
      {
        bool = false;
      }
      if ((i1 != 1) && (i1 != 3))
      {
        if (bool) {
          this.ae = 1;
        } else {
          this.ae = 2;
        }
      }
      else {
        o();
      }
    }
    if ((i1 == 1) || (i1 == 3)) {
      this.ab = false;
    }
    return bool;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    View localView = this.x;
    if (localView != null)
    {
      if (localView.isLayoutRequested()) {
        r();
      }
      this.z = true;
    }
    this.N = paramInt1;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    p();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.al)
    {
      this.al = false;
      return false;
    }
    if (!this.L) {
      return b(paramMotionEvent);
    }
    if (paramMotionEvent.getAction() == 0)
    {
      if (this.aw)
      {
        boolean bool = this.ay;
        int i2 = 1;
        if (bool)
        {
          paramMotionEvent = this.K;
          if (paramMotionEvent != null) {
            paramMotionEvent.a(this.f);
          }
          int i1 = i2;
          if (AppSetting.e)
          {
            i1 = i2;
            if (System.currentTimeMillis() - this.ar < 300L) {
              i1 = 0;
            }
          }
          if (i1 != 0)
          {
            paramMotionEvent = d(this.f);
            if (paramMotionEvent != null)
            {
              this.ay = false;
              paramMotionEvent.e();
            }
          }
        }
        else
        {
          paramMotionEvent = this.K;
          if (paramMotionEvent != null) {
            paramMotionEvent.b(this.f);
          }
          paramMotionEvent = d(this.f);
          if (paramMotionEvent != null)
          {
            this.ay = true;
            paramMotionEvent.a();
            this.ar = System.currentTimeMillis();
          }
        }
        this.aw = false;
        return false;
      }
      if (this.ay)
      {
        if (this.at)
        {
          if (!this.M)
          {
            h();
            b(this.f);
            this.at = false;
          }
          else
          {
            paramMotionEvent = this.J;
            if (paramMotionEvent != null) {
              paramMotionEvent.a(this.f);
            }
            this.at = false;
            return false;
          }
        }
        else {
          g();
        }
        this.ay = false;
        return false;
      }
    }
    return c(paramMotionEvent);
  }
  
  public void requestLayout()
  {
    if (!this.ak) {
      super.requestLayout();
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if (paramListAdapter != null)
    {
      this.ah = new DragSortListView.AdapterWrapper(this, paramListAdapter);
      paramListAdapter.registerDataSetObserver(this.A);
      if ((paramListAdapter instanceof DragSortListView.DropListener)) {
        setDropListener((DragSortListView.DropListener)paramListAdapter);
      }
      if ((paramListAdapter instanceof DragSortListView.DragListener)) {
        setDragListener((DragSortListView.DragListener)paramListAdapter);
      }
      if ((paramListAdapter instanceof DragSortListView.RemoveListener)) {
        setRemoveListener((DragSortListView.RemoveListener)paramListAdapter);
      }
    }
    else
    {
      this.ah = null;
    }
    super.setAdapter(this.ah);
  }
  
  public void setDelImmediately(boolean paramBoolean)
  {
    this.aq = paramBoolean;
  }
  
  public void setDragEnabled(boolean paramBoolean)
  {
    this.L = paramBoolean;
    this.ay = false;
    this.at = false;
    this.aw = false;
  }
  
  public void setDragListener(DragSortListView.DragListener paramDragListener)
  {
    this.H = paramDragListener;
  }
  
  public void setDragScrollProfile(DragSortListView.DragScrollProfile paramDragScrollProfile)
  {
    if (paramDragScrollProfile != null) {
      this.q = paramDragScrollProfile;
    }
  }
  
  public void setDragScrollStart(float paramFloat)
  {
    setDragScrollStarts(paramFloat, paramFloat);
  }
  
  public void setDragScrollStarts(float paramFloat1, float paramFloat2)
  {
    if (paramFloat2 > 0.5F) {
      this.R = 0.5F;
    } else {
      this.R = paramFloat2;
    }
    if (paramFloat1 > 0.5F) {
      this.Q = 0.5F;
    } else {
      this.Q = paramFloat1;
    }
    if (getHeight() != 0) {
      p();
    }
  }
  
  public void setDragSortListener(DragSortListView.DragSortListener paramDragSortListener)
  {
    setDropListener(paramDragSortListener);
    setDragListener(paramDragSortListener);
    setRemoveListener(paramDragSortListener);
  }
  
  public void setDropListener(DragSortListView.DropListener paramDropListener)
  {
    this.I = paramDropListener;
  }
  
  public void setFloatAlpha(float paramFloat)
  {
    this.C = paramFloat;
  }
  
  public void setFloatViewManager(DragSortListView.FloatViewManager paramFloatViewManager)
  {
    this.ac = paramFloatViewManager;
  }
  
  public void setLeftEventListener(DragSortListView.LeftEventListener paramLeftEventListener)
  {
    this.K = paramLeftEventListener;
  }
  
  public void setMaxScrollSpeed(float paramFloat)
  {
    this.p = paramFloat;
  }
  
  public void setRemoveListener(DragSortListView.RemoveListener paramRemoveListener)
  {
    this.J = paramRemoveListener;
  }
  
  public void setSrcPos(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setTapPos(int paramInt)
  {
    this.w = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortListView
 * JD-Core Version:    0.7.0.1
 */