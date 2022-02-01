package com.tencent.mobileqq.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Adapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ListAdapter;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.util.BitmapUtil;
import com.tencent.widget.ListView;

public class DraggableGridView
  extends FrameLayout
{
  private static int a;
  private int b = 2;
  private ListView c;
  private DraggableGridView.GridListViewAdapter d;
  private BaseDraggableGridViewAdapter e;
  private DraggableGridView.OnGridItemClickListener f;
  private DraggableGridView.OnGridItemLongClickListener g;
  private ImageView h;
  private Point i = new Point();
  private boolean j = false;
  private boolean k = false;
  private float l = 0.0F;
  private float m = 0.0F;
  private float n = 0.0F;
  private float o = 0.0F;
  private int p = -1;
  private int q = -1;
  private Point r = new Point();
  private boolean s = false;
  private boolean t = false;
  private DraggableGridView.ScrollThread u;
  private int v = 0;
  private Handler w = new DraggableGridView.3(this, Looper.getMainLooper());
  
  public DraggableGridView(Context paramContext)
  {
    super(paramContext);
    d();
  }
  
  public DraggableGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d();
  }
  
  private Point a(Point paramPoint)
  {
    if ((paramPoint.x == 0) && (paramPoint.y == 0)) {
      return null;
    }
    if (paramPoint.x == 0) {
      return new Point(this.e.b(paramPoint.y - 1) - 1, paramPoint.y - 1);
    }
    return new Point(paramPoint.x - 1, paramPoint.y);
  }
  
  private MeasureGridView a(int paramInt)
  {
    int i1 = 0;
    while (i1 < this.c.getChildCount())
    {
      View localView = this.c.getChildAt(i1);
      if ((localView.getTag() != null) && ((localView.getTag() instanceof Integer)) && (((Integer)localView.getTag()).intValue() == paramInt) && ((localView instanceof GridView))) {
        return (MeasureGridView)localView;
      }
      i1 += 1;
    }
    return null;
  }
  
  private void a(Point paramPoint, boolean paramBoolean)
  {
    MeasureGridView localMeasureGridView = a(paramPoint.y);
    if (localMeasureGridView != null)
    {
      if (localMeasureGridView.getChildAt(paramPoint.x) == null) {
        return;
      }
      if (this.s) {
        return;
      }
      DraggableGridView.MovoAnimationListener localMovoAnimationListener = new DraggableGridView.MovoAnimationListener(this, this.r, paramPoint, paramBoolean);
      View localView;
      Point localPoint;
      if (paramPoint.y == this.r.y)
      {
        if (paramPoint.x > this.r.x)
        {
          i1 = this.r.x;
          for (;;)
          {
            i1 += 1;
            if (i1 > paramPoint.x) {
              break;
            }
            localView = localMeasureGridView.getChildAt(i1);
            localPoint = new Point(i1, paramPoint.y);
            a(localView, localPoint, a(localPoint), localMovoAnimationListener);
          }
        }
        i1 = this.r.x - 1;
        while (i1 >= paramPoint.x)
        {
          localView = localMeasureGridView.getChildAt(i1);
          localPoint = new Point(i1, paramPoint.y);
          a(localView, localPoint, b(localPoint), localMovoAnimationListener);
          i1 -= 1;
        }
      }
      int i3;
      int i2;
      if (paramPoint.y > this.r.y)
      {
        localMeasureGridView = a(this.r.y);
        if (localMeasureGridView == null) {
          return;
        }
        i1 = this.r.x;
        for (;;)
        {
          i1 += 1;
          if (i1 >= this.e.b(this.r.y)) {
            break;
          }
          localView = localMeasureGridView.getChildAt(i1);
          localPoint = new Point(i1, this.r.y);
          a(localView, localPoint, a(localPoint), localMovoAnimationListener);
        }
        for (i1 = this.r.y;; i1 = i3)
        {
          i3 = i1 + 1;
          if (i3 > paramPoint.y) {
            break;
          }
          localMeasureGridView = a(i3);
          if (localMeasureGridView != null)
          {
            if (i3 == paramPoint.y) {
              i1 = paramPoint.x + 1;
            } else {
              i1 = localMeasureGridView.getAdapter().getCount();
            }
            i2 = 0;
            while (i2 < i1)
            {
              localView = localMeasureGridView.getChildAt(i2);
              localPoint = new Point(i2, i3);
              a(localView, localPoint, a(localPoint), localMovoAnimationListener);
              i2 += 1;
            }
          }
        }
      }
      localMeasureGridView = a(this.r.y);
      if (localMeasureGridView == null) {
        return;
      }
      int i1 = this.r.x - 1;
      while (i1 >= 0)
      {
        localView = localMeasureGridView.getChildAt(i1);
        localPoint = new Point(i1, this.r.y);
        a(localView, localPoint, b(localPoint), localMovoAnimationListener);
        i1 -= 1;
      }
      i1 = this.r.y - 1;
      while (i1 >= paramPoint.y)
      {
        localMeasureGridView = a(i1);
        if (localMeasureGridView != null)
        {
          if (i1 == paramPoint.y) {
            i2 = paramPoint.x;
          } else {
            i2 = 0;
          }
          i3 = localMeasureGridView.getAdapter().getCount() - 1;
          while (i3 >= i2)
          {
            localView = localMeasureGridView.getChildAt(i3);
            localPoint = new Point(i3, paramPoint.y);
            a(localView, localPoint, b(localPoint), localMovoAnimationListener);
            i3 -= 1;
          }
        }
        i1 -= 1;
      }
      this.r.set(paramPoint.x, paramPoint.y);
    }
  }
  
  private void a(View paramView, Point paramPoint1, Point paramPoint2, DraggableGridView.MovoAnimationListener paramMovoAnimationListener)
  {
    if (paramPoint2 == null) {
      return;
    }
    paramPoint1 = b(paramPoint1.y, paramPoint1.x);
    paramPoint2 = b(paramPoint2.y, paramPoint2.x);
    if (paramPoint1 != null)
    {
      if (paramPoint2 == null) {
        return;
      }
      int i1 = paramPoint2.getLeft();
      int i2 = paramPoint1.getLeft();
      int i3 = ((View)paramPoint2.getParent()).getLeft();
      int i4 = ((View)paramPoint1.getParent()).getLeft();
      int i5 = paramPoint2.getTop();
      int i6 = paramPoint1.getTop();
      int i7 = ((View)paramPoint2.getParent()).getTop();
      int i8 = ((View)paramPoint1.getParent()).getTop();
      paramPoint1 = new TranslateAnimation(0, 0.0F, 0, i1 - i2 + i3 - i4, 0, 0.0F, 0, i5 - i6 + i7 - i8);
      paramPoint1.setDuration(300L);
      paramPoint1.setAnimationListener(paramMovoAnimationListener);
      DraggableGridView.MovoAnimationListener.a(paramMovoAnimationListener);
      paramView.startAnimation(paramPoint1);
    }
  }
  
  private Point b(Point paramPoint)
  {
    if ((paramPoint.x == this.e.b(paramPoint.y) - 1) && (paramPoint.y == this.e.d() - 1)) {
      return null;
    }
    if (paramPoint.x == this.e.b(paramPoint.y) - 1) {
      return new Point(0, paramPoint.y + 1);
    }
    return new Point(paramPoint.x + 1, paramPoint.y);
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    Object localObject = a(this.c.pointToPosition(paramInt1, paramInt2) / 2);
    if ((localObject instanceof MeasureGridView))
    {
      localObject = (GridView)localObject;
      int i2 = ((GridView)localObject).getLeft();
      int i1 = ((GridView)localObject).getTop();
      paramInt1 = (paramInt1 - i2) / (((GridView)localObject).getWidth() / this.b);
      i2 = ((GridView)localObject).getHeight();
      double d1 = ((GridView)localObject).getCount();
      double d2 = this.b;
      Double.isNaN(d1);
      Double.isNaN(d2);
      localObject = new Point((paramInt2 - i1) / (i2 / (int)Math.ceil(d1 / d2)) * this.b + paramInt1, ((Integer)((GridView)localObject).getTag()).intValue());
      if (!this.r.equals(localObject)) {
        a((Point)localObject, false);
      }
    }
  }
  
  private void d()
  {
    this.c = new DraggableGridView.2(this, getContext());
    this.c.setDivider(null);
    this.c.setVerticalFadingEdgeEnabled(false);
    this.c.setScrollbarFadingEnabled(false);
    addView(this.c, new FrameLayout.LayoutParams(-1, -1));
    this.u = new DraggableGridView.ScrollThread(this);
  }
  
  void a(int paramInt1, int paramInt2)
  {
    this.r.set(paramInt2, paramInt1);
    int i2 = this.c.getLastVisiblePosition() / 2;
    int i1 = i2;
    if (this.d.getItemViewType(this.c.getLastVisiblePosition()) > 0) {
      if (i2 > 0) {
        i1 = i2 - 1;
      } else {
        i1 = 0;
      }
    }
    Point localPoint = new Point(this.e.b(i1) - 1, i1);
    View localView = b(paramInt1, paramInt2);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(300L);
    localView.startAnimation(localAlphaAnimation);
    if (localPoint.equals(this.r))
    {
      localAlphaAnimation.setAnimationListener(new DraggableGridView.1(this, paramInt1, paramInt2));
      return;
    }
    a(localPoint, true);
  }
  
  @SuppressLint({"RtlHardcoded"})
  public void a(View paramView1, View paramView2)
  {
    int i1 = paramView1.getLeft();
    int i2 = paramView2.getLeft();
    int i3 = paramView1.getTop();
    int i4 = paramView2.getTop();
    int i5 = this.c.getScrollY();
    paramView1 = BitmapUtil.a(paramView2);
    if (paramView1 != null)
    {
      int i6 = DisplayUtil.a(getContext(), 15.0F);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramView1.getWidth() + i6, paramView1.getHeight() + i6);
      i6 /= 2;
      i3 = i3 + i4 - i5 - i6;
      localLayoutParams.topMargin = i3;
      i1 = i1 + i2 - i6;
      localLayoutParams.leftMargin = i1;
      localLayoutParams.gravity = 51;
      if (this.h == null)
      {
        this.h = new ImageView(paramView2.getContext());
        addView(this.h, localLayoutParams);
      }
      this.i.set(i1, i3);
      this.h.setLayoutParams(localLayoutParams);
      this.h.setImageBitmap(paramView1);
      this.h.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
  }
  
  public boolean a()
  {
    return this.k;
  }
  
  public View b(int paramInt1, int paramInt2)
  {
    MeasureGridView localMeasureGridView = a(paramInt1);
    if (localMeasureGridView != null) {
      return localMeasureGridView.getChildAt(paramInt2);
    }
    return null;
  }
  
  public void b()
  {
    ImageView localImageView = this.h;
    if (localImageView != null)
    {
      removeView(localImageView);
      this.h = null;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    if (i1 == 255) {
      return false;
    }
    this.n = paramMotionEvent.getX();
    this.o = paramMotionEvent.getY();
    if (i1 == 2)
    {
      if (this.j)
      {
        if (!this.k)
        {
          this.k = true;
          this.t = true;
          this.l = this.n;
          this.m = this.o;
          this.v = 0;
        }
        paramMotionEvent = (FrameLayout.LayoutParams)this.h.getLayoutParams();
        paramMotionEvent.leftMargin = ((int)(this.n - this.l + this.i.x));
        paramMotionEvent.topMargin = ((int)(this.o - this.m + this.i.y));
        if (paramMotionEvent.leftMargin + this.h.getWidth() < 1) {
          paramMotionEvent.leftMargin = (1 - this.h.getWidth());
        } else if (paramMotionEvent.leftMargin > getWidth() - 1) {
          paramMotionEvent.leftMargin = (getWidth() - 1);
        }
        if (paramMotionEvent.topMargin + this.h.getHeight() < 1) {
          paramMotionEvent.topMargin = (1 - this.h.getHeight());
        } else if (paramMotionEvent.topMargin > getHeight() - 1) {
          paramMotionEvent.topMargin = (getHeight() - 1);
        }
        this.h.setLayoutParams(paramMotionEvent);
        c((int)this.n, (int)this.o);
        i1 = this.c.getHeight();
        if (this.o > i1 - DisplayUtil.a(getContext(), 30.0F))
        {
          this.u.a(1);
          return true;
        }
        if (this.o < DisplayUtil.a(getContext(), 30.0F))
        {
          this.u.a(2);
          return true;
        }
        paramMotionEvent = this.u;
        if (paramMotionEvent != null) {
          paramMotionEvent.a = true;
        }
        return true;
      }
    }
    else if ((i1 == 1) || (i1 == 3))
    {
      if ((this.h != null) && (this.k))
      {
        localObject = b(this.r.y, this.r.x);
        if (localObject != null)
        {
          View localView = (View)((View)localObject).getParent();
          i1 = localView.getLeft();
          int i2 = ((View)localObject).getLeft();
          int i3 = localView.getTop();
          int i4 = ((View)localObject).getTop();
          int i5 = this.c.getScrollY();
          localObject = (FrameLayout.LayoutParams)this.h.getLayoutParams();
          localObject = new TranslateAnimation(0, 0.0F, 0, i1 + i2 - ((FrameLayout.LayoutParams)localObject).leftMargin, 0, 0.0F, 0, i3 + i4 - i5 - ((FrameLayout.LayoutParams)localObject).topMargin);
          ((TranslateAnimation)localObject).setDuration(300L);
          ((TranslateAnimation)localObject).setAnimationListener(new DraggableGridView.DragEndAnimationListener(this, null));
          this.h.startAnimation((Animation)localObject);
        }
      }
      this.j = false;
      this.t = false;
      Object localObject = this.u;
      if (localObject != null) {
        ((DraggableGridView.ScrollThread)localObject).a = true;
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public BaseDraggableGridViewAdapter getAdapter()
  {
    return this.e;
  }
  
  Adapter getInnerAdapter()
  {
    return this.d;
  }
  
  public void setAdapter(BaseDraggableGridViewAdapter paramBaseDraggableGridViewAdapter)
  {
    this.e = paramBaseDraggableGridViewAdapter;
    this.e.b = this;
    this.d = new DraggableGridView.GridListViewAdapter(this);
    this.c.setAdapter(this.d);
  }
  
  public void setDraggable(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public void setOnGridItemClickListener(DraggableGridView.OnGridItemClickListener paramOnGridItemClickListener)
  {
    this.f = paramOnGridItemClickListener;
  }
  
  public void setOnGridItemLongClickListener(DraggableGridView.OnGridItemLongClickListener paramOnGridItemLongClickListener)
  {
    this.g = paramOnGridItemLongClickListener;
  }
  
  public void setVerticalScrollBarEnabled(boolean paramBoolean)
  {
    this.c.setVerticalScrollBarEnabled(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.DraggableGridView
 * JD-Core Version:    0.7.0.1
 */