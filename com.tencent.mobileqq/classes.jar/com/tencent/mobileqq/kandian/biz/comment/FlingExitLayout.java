package com.tencent.mobileqq.kandian.biz.comment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.Scroller;
import com.tencent.mobileqq.kandian.biz.comment.helper.RIJPerformanceReporter;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.view.ReadInJoyCommentListView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView.OnListScrollListener;

public class FlingExitLayout
  extends ViewGroup
{
  private final int a;
  private final int b;
  private final int c;
  private final int d;
  private float e;
  private float f;
  private float g;
  private int h;
  private int i;
  private int j;
  private int k = -1;
  private boolean l = true;
  private VelocityTracker m;
  private FlingExitLayout.OnGestureExitListener n;
  private final Scroller o;
  private ReadInJoyCommentListView p;
  private RecyclerView q;
  private final RecyclerView.OnListScrollListener r = new FlingExitLayout.1(this);
  
  public FlingExitLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FlingExitLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FlingExitLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.o = new Scroller(paramContext, new AccelerateInterpolator());
    paramContext = ViewConfiguration.get(paramContext);
    this.b = paramContext.getScaledMinimumFlingVelocity();
    this.c = paramContext.getScaledMaximumFlingVelocity();
    this.d = paramContext.getScaledTouchSlop();
    this.a = ViewUtils.dip2px(50.0F);
  }
  
  private boolean a()
  {
    ReadInJoyCommentListView localReadInJoyCommentListView = this.p;
    if (localReadInJoyCommentListView == null) {
      return true;
    }
    if (localReadInJoyCommentListView.getChildCount() == 0) {
      return true;
    }
    return (this.p.getFirstVisiblePosition() == 0) && (this.p.getChildAt(0).getTop() == 0);
  }
  
  private boolean b()
  {
    RecyclerView localRecyclerView = this.q;
    if (localRecyclerView == null) {
      return true;
    }
    if (this.k == 1) {
      return false;
    }
    if (localRecyclerView.getChildCount() == 0) {
      return true;
    }
    return (this.q.getFirstVisibleItemPos() == 0) && (this.q.getChildAt(0).getTop() == 0);
  }
  
  private void c()
  {
    VelocityTracker localVelocityTracker = this.m;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      this.m = null;
    }
  }
  
  private void d()
  {
    if (getScrollY() != 0) {
      scrollTo(0, 0);
    }
  }
  
  private void e()
  {
    RIJPerformanceReporter.a().a(0, this.i, -1);
  }
  
  public void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void computeScroll()
  {
    if (this.o.computeScrollOffset())
    {
      int i1 = this.o.getCurrY();
      if (Math.abs(i1) >= this.h - 1)
      {
        if ((this.n != null) && (this.j >= this.d))
        {
          e();
          this.n.a(true);
        }
      }
      else
      {
        if (i1 >= 0) {
          e();
        }
        scrollTo(this.o.getCurrX(), i1);
        invalidate();
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool3 = this.l;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3) {
      if (this.p == null)
      {
        bool1 = bool2;
        if (this.q == null) {}
      }
      else
      {
        if (paramMotionEvent == null) {
          return false;
        }
        int i1 = paramMotionEvent.getAction();
        if (i1 == 3)
        {
          c();
          return false;
        }
        if (i1 != 0)
        {
          if (i1 == 2)
          {
            float f2 = paramMotionEvent.getRawX() - this.e;
            float f3 = paramMotionEvent.getRawY() - this.f;
            if (f2 == 0.0F) {
              f1 = 1.0F;
            } else {
              f1 = f2;
            }
            float f1 = Math.abs(f3 / f1);
            if ((f2 > this.a) && (f1 < 0.5F)) {
              i1 = 1;
            } else {
              i1 = 0;
            }
            if ((f3 > this.d) && (f1 > 2.0F))
            {
              i3 = 1;
              i2 = i1;
              i1 = i3;
              break label234;
            }
            int i3 = 0;
            i2 = i1;
            i1 = i3;
            break label234;
          }
        }
        else
        {
          if (!this.o.isFinished()) {
            this.o.abortAnimation();
          }
          this.e = paramMotionEvent.getRawX();
          this.f = paramMotionEvent.getRawY();
          this.g = this.f;
        }
        i1 = 0;
        int i2 = 0;
        label234:
        if ((i1 != 0) && (a()) && (b())) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        if (i2 == 0)
        {
          bool1 = bool2;
          if (i1 == 0) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    d();
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      getChildAt(i1).layout(paramInt1, paramInt2, paramInt3, paramInt4);
      i1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    if (i1 != 1073741824) {
      paramInt1 = getPaddingLeft() + getPaddingRight();
    }
    i1 = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (i1 != 1073741824) {
      paramInt2 = getPaddingTop() + getPaddingBottom();
    }
    int i2 = getChildCount();
    i1 = 0;
    while (i1 < i2)
    {
      getChildAt(i1).measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
      i1 += 1;
    }
    this.h = paramInt2;
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.l)
    {
      if (paramMotionEvent == null) {
        return false;
      }
      if (this.m == null) {
        this.m = VelocityTracker.obtain();
      }
      this.m.addMovement(paramMotionEvent);
      float f3 = paramMotionEvent.getRawY();
      int i1 = paramMotionEvent.getAction();
      if (i1 != 1) {
        if (i1 != 2)
        {
          if (i1 != 3) {
            return true;
          }
        }
        else
        {
          RIJPerformanceReporter.a().b();
          f2 = getScrollY() + this.g - f3;
          f1 = f2;
          if (Float.compare(f2, 0.0F) > 0.0F) {
            f1 = 0.0F;
          }
          scrollTo(getScrollX(), (int)f1);
          this.g = f3;
          return true;
        }
      }
      float f2 = paramMotionEvent.getRawX() - this.e;
      f3 = paramMotionEvent.getRawY() - this.f;
      if (f2 == 0.0F) {
        f1 = 1.0F;
      } else {
        f1 = f2;
      }
      float f1 = Math.abs(f3 / f1);
      i1 = paramMotionEvent.getPointerId(0);
      this.m.computeCurrentVelocity(1000, this.c);
      float f4 = this.m.getXVelocity(i1);
      if ((f2 > this.a) && (f1 < 0.5F) && (Math.abs(f4) > this.b))
      {
        paramMotionEvent = this.n;
        if (paramMotionEvent != null) {
          paramMotionEvent.a(false);
        }
      }
      int i3 = getScrollY();
      if (i3 > 0) {}
      while (Math.abs(i3) <= 200)
      {
        i1 = -i3;
        i2 = 120;
        break;
      }
      i1 = -(this.h - Math.abs(i3));
      int i2 = 200;
      this.j = ((int)f3);
      this.o.startScroll(0, i3, 0, i1, i2);
      invalidate();
      c();
      return true;
    }
    return false;
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (paramInt == 0) {
      d();
    }
  }
  
  public void setCommentLevel(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void setListView(ReadInJoyCommentListView paramReadInJoyCommentListView)
  {
    this.p = paramReadInJoyCommentListView;
  }
  
  public void setOnGestureExitListener(FlingExitLayout.OnGestureExitListener paramOnGestureExitListener)
  {
    this.n = paramOnGestureExitListener;
  }
  
  public void setRecyclerView(RecyclerView paramRecyclerView)
  {
    setRecyclerView(paramRecyclerView, -1);
  }
  
  public void setRecyclerView(RecyclerView paramRecyclerView, int paramInt)
  {
    this.k = paramInt;
    this.q = paramRecyclerView;
    paramRecyclerView = this.q;
    if (paramRecyclerView != null)
    {
      paramRecyclerView.removeOnListScrollListener(this.r);
      this.q.addOnListScrollListener(this.r);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.FlingExitLayout
 * JD-Core Version:    0.7.0.1
 */