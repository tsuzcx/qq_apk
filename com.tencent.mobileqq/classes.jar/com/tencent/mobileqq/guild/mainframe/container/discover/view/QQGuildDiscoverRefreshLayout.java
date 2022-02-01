package com.tencent.mobileqq.guild.mainframe.container.discover.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.AbsListView;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.tencent.mobileqq.guild.impl.R.styleable;
import com.tencent.widget.ListView;

public class QQGuildDiscoverRefreshLayout
  extends ViewGroup
  implements QQGuildDiscoverAutoScroller.ScrollerCallback
{
  private QQGuildDiscoverRefreshLayout.OnRefreshListener A;
  private boolean B;
  private QQGuildDiscoverRefreshLayout.MiniAppScrollListener C;
  private int D;
  ListView a;
  QQGuildDiscoverRefreshLayout.RefreshCallback b = new QQGuildDiscoverRefreshLayout.2(this);
  private int c = 200;
  private int d = 200;
  private int e = 300;
  private int f = 500;
  private int g = 500;
  private QQGuildDiscoverAutoScroller h;
  private int i;
  private float j = 0.5F;
  private ViewGroup k;
  private View l;
  private int m;
  private float n;
  private float o;
  private int p;
  private int q;
  private boolean r;
  private float s;
  private float t;
  private float u;
  private float v;
  private int w;
  private int x = 0;
  private boolean y;
  private boolean z = true;
  
  public QQGuildDiscoverRefreshLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QQGuildDiscoverRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QQGuildDiscoverRefreshLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.bN, paramInt, 0);
    try
    {
      int i1 = paramAttributeSet.getIndexCount();
      paramInt = 0;
      while (paramInt < i1)
      {
        int i2 = paramAttributeSet.getIndex(paramInt);
        if (i2 == R.styleable.bS) {
          setRefreshEnabled(paramAttributeSet.getBoolean(i2, true));
        } else if (i2 == R.styleable.bP) {
          this.j = paramAttributeSet.getFloat(i2, 0.5F);
        } else if (i2 == R.styleable.bT) {
          this.o = paramAttributeSet.getDimensionPixelOffset(i2, 0);
        } else if (i2 == R.styleable.bU) {
          this.n = paramAttributeSet.getDimensionPixelOffset(i2, 0);
        } else if (i2 == R.styleable.bW) {
          this.c = paramAttributeSet.getInt(i2, 200);
        } else if (i2 == R.styleable.bV) {
          this.d = paramAttributeSet.getInt(i2, 200);
        } else if (i2 == R.styleable.bQ) {
          setRefreshCompleteDelayDuration(paramAttributeSet.getInt(i2, 300));
        } else if (i2 == R.styleable.bR) {
          this.f = paramAttributeSet.getInt(i2, 500);
        } else if (i2 == R.styleable.bO) {
          this.g = paramAttributeSet.getInt(i2, 500);
        }
        paramInt += 1;
      }
      paramAttributeSet.recycle();
      this.w = ViewConfiguration.get(paramContext).getScaledTouchSlop();
      this.h = new QQGuildDiscoverAutoScroller(this);
      this.h.a(this);
      this.D = getResources().getDimensionPixelOffset(2131299643);
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
    for (;;)
    {
      throw paramContext;
    }
  }
  
  private float a(MotionEvent paramMotionEvent, int paramInt)
  {
    paramInt = MotionEventCompat.findPointerIndex(paramMotionEvent, paramInt);
    if (paramInt < 0) {
      return -1.0F;
    }
    return MotionEventCompat.getY(paramMotionEvent, paramInt);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int i1 = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (MotionEventCompat.getPointerId(paramMotionEvent, i1) == this.i)
    {
      if (i1 == 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      this.i = MotionEventCompat.getPointerId(paramMotionEvent, i1);
    }
  }
  
  private boolean a(View paramView)
  {
    boolean bool2 = paramView instanceof HeaderScrollView;
    boolean bool1 = true;
    if (bool2) {
      return ((HeaderScrollView)paramView).b() ^ true;
    }
    if ((paramView instanceof ViewGroup))
    {
      View localView = ((ViewGroup)paramView).getChildAt(1);
      if ((localView != null) && ((localView instanceof HeaderScrollView))) {
        return ((HeaderScrollView)localView).b() ^ true;
      }
    }
    else if ((paramView instanceof AbsListView))
    {
      paramView = (AbsListView)paramView;
      if (paramView.getChildCount() > 0)
      {
        if (paramView.getFirstVisiblePosition() > 0) {
          break label107;
        }
        if (paramView.getChildAt(0).getTop() < paramView.getPaddingTop()) {
          return true;
        }
      }
      bool1 = false;
      label107:
      return bool1;
    }
    return ViewCompat.canScrollVertically(paramView, -1);
  }
  
  private float b(MotionEvent paramMotionEvent, int paramInt)
  {
    paramInt = MotionEventCompat.findPointerIndex(paramMotionEvent, paramInt);
    if (paramInt < 0) {
      return -1.0F;
    }
    return MotionEventCompat.getX(paramMotionEvent, paramInt);
  }
  
  private void b(float paramFloat)
  {
    if ((QQGuildDiscoverRefreshLayout.STATUS.a(this.x)) && (this.C != null) && (paramFloat > 0.0F))
    {
      setStatus(3);
      if (this.k.getVisibility() != 0) {
        this.k.setVisibility(0);
      }
    }
    if (QQGuildDiscoverRefreshLayout.STATUS.g(this.x))
    {
      if (paramFloat < 0.0F)
      {
        setStatus(2);
      }
      else
      {
        int i1 = this.q;
        float f1 = i1;
        float f2 = this.n;
        if (f1 >= f2) {
          setStatus(4);
        } else if (i1 >= (f2 - this.D) / 2.0F) {
          setStatus(5);
        } else {
          setStatus(3);
        }
      }
      c(paramFloat);
    }
    if ((QQGuildDiscoverRefreshLayout.STATUS.h(this.x)) || (QQGuildDiscoverRefreshLayout.STATUS.i(this.x)))
    {
      if (paramFloat < 0.0F) {
        setStatus(2);
      } else {
        setStatus(1);
      }
      c(paramFloat);
    }
    if (((QQGuildDiscoverRefreshLayout.STATUS.a(this.x)) || (QQGuildDiscoverRefreshLayout.STATUS.h(this.x))) && (paramFloat > 0.0F) && (n()))
    {
      this.b.c();
      setStatus(-1);
    }
    if (QQGuildDiscoverRefreshLayout.STATUS.c(this.x))
    {
      if ((!QQGuildDiscoverRefreshLayout.STATUS.d(this.x)) && (!QQGuildDiscoverRefreshLayout.STATUS.e(this.x)))
      {
        if ((paramFloat < 0.0F) && (this.C != null)) {
          setStatus(2);
        }
      }
      else if (this.q >= this.n) {
        setStatus(-2);
      } else {
        setStatus(-1);
      }
      c(paramFloat);
    }
  }
  
  private void c(float paramFloat)
  {
    float f1 = paramFloat * this.j;
    int i1 = this.q;
    float f2 = i1 + f1;
    if ((i1 <= 0) || (f2 >= 0.0F))
    {
      paramFloat = f1;
      if (this.q < 0)
      {
        paramFloat = f1;
        if (f2 <= 0.0F) {}
      }
    }
    else
    {
      paramFloat = -this.q;
    }
    float f3 = this.o;
    f1 = paramFloat;
    if (f3 > this.n)
    {
      f1 = paramFloat;
      if (f2 > f3) {
        f1 = f3 - this.q;
      }
    }
    if (QQGuildDiscoverRefreshLayout.STATUS.c(this.x))
    {
      i1 = this.q;
      if (f()) {
        i1 = this.q - ((int)this.n - this.D);
      }
      this.b.a(i1, false, false);
    }
    d(f1);
  }
  
  private void d(float paramFloat)
  {
    if (paramFloat == 0.0F) {
      return;
    }
    this.q = ((int)(this.q + paramFloat));
    if ((QQGuildDiscoverRefreshLayout.STATUS.c(this.x)) || (QQGuildDiscoverRefreshLayout.STATUS.f(this.x))) {
      this.p = this.q;
    }
    h();
    requestLayout();
    invalidate();
  }
  
  private void g()
  {
    int i2 = getPaddingLeft();
    int i1 = getPaddingTop();
    if (this.l == null) {
      return;
    }
    Object localObject = this.k;
    ViewGroup.MarginLayoutParams localMarginLayoutParams;
    int i3;
    if (localObject != null)
    {
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
      i3 = localMarginLayoutParams.leftMargin + i2;
      int i4 = localMarginLayoutParams.topMargin + i1 - this.m + this.p;
      ((View)localObject).layout(i3, i4, ((View)localObject).getMeasuredWidth() + i3, ((View)localObject).getMeasuredHeight() + i4);
    }
    localObject = this.l;
    if (localObject != null)
    {
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
      i3 = i2 + localMarginLayoutParams.leftMargin;
      i2 = i1 + localMarginLayoutParams.topMargin + this.q;
      i1 = i2;
      if (i2 < 0) {
        i1 = 0;
      }
      ((View)localObject).layout(i3, i1, ((View)localObject).getMeasuredWidth() + i3, ((View)localObject).getMeasuredHeight() + i1);
    }
  }
  
  private void h()
  {
    int i1 = getPaddingTop();
    if (this.l == null) {
      return;
    }
    Object localObject = this.k;
    if (localObject != null) {
      ((View)localObject).setTop(((ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams()).topMargin + i1 - this.m + this.p);
    }
    localObject = this.l;
    if (localObject != null)
    {
      int i2 = i1 + ((ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams()).topMargin + this.q;
      i1 = i2;
      if (i2 < 0) {
        i1 = 0;
      }
      ((View)localObject).setTop(i1);
    }
  }
  
  private void i()
  {
    if (QQGuildDiscoverRefreshLayout.STATUS.b(this.x))
    {
      this.q = ((int)(this.n + 0.5F));
      this.p = this.q;
      h();
      requestLayout();
      invalidate();
      return;
    }
    if (QQGuildDiscoverRefreshLayout.STATUS.a(this.x))
    {
      this.q = 0;
      this.p = 0;
      h();
      requestLayout();
      invalidate();
      return;
    }
    if (QQGuildDiscoverRefreshLayout.STATUS.h(this.x))
    {
      this.q = ((int)(this.n + 0.5F) - this.D);
      this.p = this.q;
      h();
      requestLayout();
      invalidate();
    }
  }
  
  private void j()
  {
    if (QQGuildDiscoverRefreshLayout.STATUS.d(this.x))
    {
      if (f())
      {
        d();
        return;
      }
      l();
      return;
    }
    if (QQGuildDiscoverRefreshLayout.STATUS.e(this.x))
    {
      this.b.d();
      m();
      return;
    }
    if (QQGuildDiscoverRefreshLayout.STATUS.b(this.x))
    {
      c();
      return;
    }
    if ((!QQGuildDiscoverRefreshLayout.STATUS.j(this.x)) && (!QQGuildDiscoverRefreshLayout.STATUS.k(this.x)))
    {
      if ((QQGuildDiscoverRefreshLayout.STATUS.l(this.x)) || (QQGuildDiscoverRefreshLayout.STATUS.i(this.x))) {
        e();
      }
    }
    else {
      d();
    }
  }
  
  private void k()
  {
    if (this.h.b()) {
      this.h.a((int)(this.n + 0.5F), this.g);
    }
  }
  
  private void l()
  {
    if (this.h.b()) {
      this.h.a(-this.p, this.c);
    }
  }
  
  private void m()
  {
    if (this.h.b()) {
      this.h.a(this.m - this.p, this.d);
    }
  }
  
  private boolean n()
  {
    return (this.z) && (!a(this.l)) && (this.r) && (this.n > 0.0F);
  }
  
  private void setStatus(int paramInt)
  {
    this.x = paramInt;
  }
  
  public void a()
  {
    if (QQGuildDiscoverRefreshLayout.STATUS.e(this.x))
    {
      setStatus(-3);
      i();
      this.b.b();
      return;
    }
    if (QQGuildDiscoverRefreshLayout.STATUS.b(this.x))
    {
      if (f()) {
        setStatus(1);
      } else {
        setStatus(0);
      }
      i();
      this.b.e();
      return;
    }
    if (QQGuildDiscoverRefreshLayout.STATUS.d(this.x))
    {
      if (this.y)
      {
        this.y = false;
        setStatus(-3);
        i();
        this.b.b();
        return;
      }
      if (f()) {
        setStatus(1);
      } else {
        setStatus(0);
      }
      i();
      this.b.e();
      return;
    }
    if ((!QQGuildDiscoverRefreshLayout.STATUS.j(this.x)) && (!QQGuildDiscoverRefreshLayout.STATUS.k(this.x)))
    {
      if ((QQGuildDiscoverRefreshLayout.STATUS.l(this.x)) || (QQGuildDiscoverRefreshLayout.STATUS.i(this.x)))
      {
        setStatus(0);
        i();
      }
    }
    else
    {
      setStatus(1);
      i();
    }
  }
  
  public void a(float paramFloat)
  {
    if (QQGuildDiscoverRefreshLayout.STATUS.d(this.x)) {
      this.b.a(this.q, false, true);
    } else if (QQGuildDiscoverRefreshLayout.STATUS.e(this.x)) {
      this.b.a(this.q, false, true);
    } else if (QQGuildDiscoverRefreshLayout.STATUS.b(this.x)) {
      this.b.a(this.q, true, true);
    }
    d(paramFloat);
  }
  
  public boolean b()
  {
    return this.z;
  }
  
  public void c()
  {
    if (this.h.b()) {
      this.h.a(-this.D, this.f);
    }
  }
  
  public void d()
  {
    if (this.h.b()) {
      this.h.a((int)(this.n + 0.5F) - this.D - this.q, this.f);
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    QQGuildDiscoverRefreshLayout.MiniAppScrollListener localMiniAppScrollListener = this.C;
    if (localMiniAppScrollListener != null) {
      localMiniAppScrollListener.a(this.x, -this.q);
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    QQGuildDiscoverRefreshLayout.MiniAppScrollListener localMiniAppScrollListener = this.C;
    if (localMiniAppScrollListener != null) {
      localMiniAppScrollListener.a(this, -this.q, paramMotionEvent);
    }
    int i1 = paramMotionEvent.getAction();
    if ((i1 == 1) || (i1 == 3)) {
      j();
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void e()
  {
    if (this.h.b()) {
      this.h.a(-this.q, this.f);
    }
  }
  
  public boolean f()
  {
    return this.B;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new QQGuildDiscoverRefreshLayout.LayoutParams(-1, -1);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new QQGuildDiscoverRefreshLayout.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new QQGuildDiscoverRefreshLayout.LayoutParams(paramLayoutParams);
  }
  
  public int getHeaderViewHeight()
  {
    return this.m;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    int i1 = getChildCount();
    if (i1 == 0) {
      return;
    }
    if ((i1 > 0) && (i1 < 4))
    {
      this.k = ((ViewGroup)findViewById(2131434732));
      this.l = findViewById(2131434733);
      if (this.l == null) {
        return;
      }
      ViewGroup localViewGroup = this.k;
      if ((localViewGroup != null) && ((localViewGroup instanceof QQGuildDiscoverRefreshLayout.SwipeTrigger))) {
        localViewGroup.setVisibility(8);
      }
      return;
    }
    throw new IllegalStateException("Children num must equal or less than 3");
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i2 = MotionEventCompat.getActionMasked(paramMotionEvent);
    ListView localListView = this.a;
    int i4 = 0;
    int i1;
    if (localListView != null) {
      i1 = localListView.getListViewScrollY();
    } else {
      i1 = 0;
    }
    float f1;
    if (i2 != 0)
    {
      if (i2 != 1) {
        if (i2 != 2)
        {
          if (i2 != 3) {
            break label327;
          }
        }
        else
        {
          i2 = this.i;
          if (i2 == -1) {
            return false;
          }
          f1 = b(paramMotionEvent, i2);
          float f2 = a(paramMotionEvent, this.i);
          float f3 = this.s;
          float f4 = f2 - this.t;
          this.u = f1;
          this.v = f2;
          if ((Math.abs(f1 - f3) < Math.abs(f4)) && (Math.abs(f4) > this.w)) {
            i2 = 1;
          } else {
            i2 = 0;
          }
          int i3 = i4;
          if (f4 > 0.0F)
          {
            i3 = i4;
            if (n()) {
              i3 = 1;
            }
          }
          if ((i1 != 0) || (i2 == 0) || ((i3 == 0) && (!QQGuildDiscoverRefreshLayout.STATUS.b(this.x)) && (!QQGuildDiscoverRefreshLayout.STATUS.f(this.x)))) {
            break label327;
          }
          return true;
        }
      }
      this.i = -1;
    }
    else
    {
      this.i = MotionEventCompat.getPointerId(paramMotionEvent, 0);
      f1 = b(paramMotionEvent, this.i);
      this.s = f1;
      this.u = f1;
      f1 = a(paramMotionEvent, this.i);
      this.t = f1;
      this.v = f1;
      if ((QQGuildDiscoverRefreshLayout.STATUS.d(this.x)) || (QQGuildDiscoverRefreshLayout.STATUS.e(this.x))) {
        this.h.a();
      }
      if (((QQGuildDiscoverRefreshLayout.STATUS.d(this.x)) || (QQGuildDiscoverRefreshLayout.STATUS.e(this.x))) && (i1 == 0)) {
        return true;
      }
    }
    label327:
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    g();
    if (this.k != null) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    this.r = paramBoolean;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    Object localObject = this.k;
    if (localObject != null)
    {
      measureChildWithMargins((View)localObject, paramInt1, 0, paramInt2, 0);
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
      this.m = (((View)localObject).getMeasuredHeight() + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin);
      float f1 = this.n;
      int i1 = this.m;
      if (f1 < i1) {
        this.n = i1;
      }
    }
    localObject = this.l;
    if (localObject != null) {
      measureChildWithMargins((View)localObject, paramInt1, 0, paramInt2, 0);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = MotionEventCompat.getActionMasked(paramMotionEvent);
    if (i1 != 0)
    {
      if (i1 != 1) {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 != 5)
            {
              if (i1 != 6) {
                break label229;
              }
              a(paramMotionEvent);
              this.u = b(paramMotionEvent, this.i);
              this.v = a(paramMotionEvent, this.i);
              break label229;
            }
            i1 = MotionEventCompat.getPointerId(paramMotionEvent, MotionEventCompat.getActionIndex(paramMotionEvent));
            if (i1 != -1) {
              this.i = i1;
            }
            this.u = b(paramMotionEvent, this.i);
            this.v = a(paramMotionEvent, this.i);
            break label229;
          }
        }
        else
        {
          float f1 = b(paramMotionEvent, this.i);
          float f2 = a(paramMotionEvent, this.i);
          float f3 = f1 - this.u;
          float f4 = f2 - this.v;
          this.u = f1;
          this.v = f2;
          if ((Math.abs(f3) >= Math.abs(f4)) && (Math.abs(f3) > this.w)) {
            return false;
          }
          b(f4);
          return true;
        }
      }
      if (this.i == -1) {
        return false;
      }
      this.i = -1;
      label229:
      return super.onTouchEvent(paramMotionEvent);
    }
    this.i = MotionEventCompat.getPointerId(paramMotionEvent, 0);
    return true;
  }
  
  public void setMiniAppScrollListener(QQGuildDiscoverRefreshLayout.MiniAppScrollListener paramMiniAppScrollListener)
  {
    this.C = paramMiniAppScrollListener;
  }
  
  public void setOnRefreshListener(QQGuildDiscoverRefreshLayout.OnRefreshListener paramOnRefreshListener)
  {
    this.A = paramOnRefreshListener;
  }
  
  public void setRefreshCompleteDelayDuration(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setRefreshEnabled(boolean paramBoolean)
  {
    this.z = paramBoolean;
  }
  
  public void setRefreshing(boolean paramBoolean)
  {
    if (b())
    {
      if (this.k == null) {
        return;
      }
      this.y = paramBoolean;
      if (paramBoolean)
      {
        if (QQGuildDiscoverRefreshLayout.STATUS.a(this.x))
        {
          setStatus(-1);
          k();
        }
      }
      else if (QQGuildDiscoverRefreshLayout.STATUS.b(this.x))
      {
        this.b.e();
        postDelayed(new QQGuildDiscoverRefreshLayout.1(this), this.e);
      }
    }
  }
  
  public void setShowMiniAppPanel(boolean paramBoolean)
  {
    this.B = paramBoolean;
  }
  
  public void setTargetListView(ListView paramListView)
  {
    this.a = paramListView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.discover.view.QQGuildDiscoverRefreshLayout
 * JD-Core Version:    0.7.0.1
 */