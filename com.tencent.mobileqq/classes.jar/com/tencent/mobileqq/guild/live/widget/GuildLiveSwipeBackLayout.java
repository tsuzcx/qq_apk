package com.tencent.mobileqq.guild.live.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Scroller;
import androidx.viewpager.widget.ViewPager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GuildLiveSwipeBackLayout
  extends FrameLayout
{
  protected View a = this;
  protected Scroller b;
  protected int c;
  protected boolean d = false;
  protected int e;
  protected int f;
  protected int g;
  protected int h;
  protected int i;
  protected boolean j;
  protected Context k;
  protected int l;
  protected volatile boolean m;
  protected boolean n = true;
  public int o;
  protected GestureDetector p;
  protected GuildLiveSwipeBackLayout.OnPageSwipeListener q;
  protected final GuildLiveSwipeBackLayout.SwipeLayoutHandler r = new GuildLiveSwipeBackLayout.SwipeLayoutHandler(this);
  private final List<ViewPager> s = new LinkedList();
  private boolean t = true;
  private boolean u;
  private boolean v = false;
  private boolean w = false;
  private GuildLiveSwipeBackLayout.OnSwipeListener x;
  
  public GuildLiveSwipeBackLayout(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public GuildLiveSwipeBackLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GuildLiveSwipeBackLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.k = paramContext;
    this.e = (ViewConfiguration.get(paramContext).getScaledTouchSlop() * 4);
    this.f = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.b = new Scroller(paramContext);
    this.l = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth();
    this.o = this.l;
    this.p = new GestureDetector(paramContext, new GuildLiveSwipeBackLayout.DefaultLayoutGestureDetector(this));
  }
  
  private void a(List<ViewPager> paramList, ViewGroup paramViewGroup)
  {
    int i2 = paramViewGroup.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = paramViewGroup.getChildAt(i1);
      if ((localView instanceof ViewPager)) {
        paramList.add((ViewPager)localView);
      } else if ((localView instanceof ViewGroup)) {
        a(paramList, (ViewGroup)localView);
      }
      i1 += 1;
    }
  }
  
  protected ViewPager a(List<ViewPager> paramList, MotionEvent paramMotionEvent)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return null;
      }
      Rect localRect = new Rect();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ViewPager localViewPager = (ViewPager)paramList.next();
        localViewPager.getHitRect(localRect);
        if (localRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
          return localViewPager;
        }
      }
    }
    return null;
  }
  
  protected void a()
  {
    if (this.w) {
      return;
    }
    this.w = true;
    int i1 = this.c + this.a.getScrollX();
    double d1 = i1;
    Double.isNaN(d1);
    double d2 = this.c;
    Double.isNaN(d2);
    int i2 = (int)(d1 * 1.0D / d2 * 700.0D);
    try
    {
      this.b.startScroll(this.a.getScrollX(), 0, -i1 + 1, 0, Math.abs(i2));
      label85:
      this.r.sendEmptyMessageDelayed(1, 200L);
      return;
    }
    catch (Exception localException)
    {
      break label85;
    }
  }
  
  public void b()
  {
    this.n = false;
  }
  
  public void c()
  {
    this.n = true;
  }
  
  public void computeScroll()
  {
    if (this.b.computeScrollOffset())
    {
      this.a.scrollTo(this.b.getCurrX(), this.b.getCurrY());
      postInvalidate();
      if ((this.b.isFinished()) && (this.u)) {
        a();
      }
    }
  }
  
  protected void d()
  {
    try
    {
      int i1 = this.a.getScrollX();
      this.b.startScroll(this.a.getScrollX(), 0, -i1, 0, Math.abs(i1));
      postInvalidate();
      if (this.q != null) {
        this.q.h();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject = a(this.s, paramMotionEvent);
    if ((localObject != null) && (((ViewPager)localObject).getCurrentItem() != 0)) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if ((i1 == 2) && (this.d) && (this.n) && ((int)paramMotionEvent.getRawX() - this.g > this.e) && (Math.abs((int)paramMotionEvent.getRawY() - this.h) < this.f)) {
        return true;
      }
    }
    else
    {
      this.d = false;
      i1 = (int)paramMotionEvent.getRawX();
      this.i = i1;
      this.g = i1;
      this.h = ((int)paramMotionEvent.getRawY());
      if (this.g < this.o) {
        this.d = true;
      }
    }
    if (this.n)
    {
      localObject = this.p;
      if (localObject != null) {
        return ((GestureDetector)localObject).onTouchEvent(paramMotionEvent);
      }
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      this.c = getWidth();
      a(this.s, this);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      Object localObject;
      if (i1 != 1)
      {
        if ((i1 == 2) && (this.d) && (this.n))
        {
          i1 = (int)paramMotionEvent.getRawX();
          int i2 = this.i - i1;
          if (i1 - this.g > this.e)
          {
            if ((!this.j) && (this.x != null))
            {
              QLog.i("GuildLiveSwipeBackLayout", 2, "waterTest: onSwipe");
              boolean bool = this.x.c(true);
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("waterTest: onSwipe result[");
              ((StringBuilder)localObject).append(bool);
              ((StringBuilder)localObject).append("");
              QLog.i("GuildLiveSwipeBackLayout", 2, ((StringBuilder)localObject).toString());
              if (!bool)
              {
                this.d = false;
                break label539;
              }
            }
            this.j = true;
          }
          else if (this.t)
          {
            this.i = i1;
            if ((i1 - this.g > 0) && (this.j))
            {
              if (QLog.isColorLevel())
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("moveX:");
                ((StringBuilder)localObject).append(i1);
                ((StringBuilder)localObject).append("downX:");
                ((StringBuilder)localObject).append(this.g);
                ((StringBuilder)localObject).append("deltaX:");
                ((StringBuilder)localObject).append(i2);
                QLog.i("GuildLiveSwipeBackLayout", 2, ((StringBuilder)localObject).toString());
              }
              i1 = i2;
              if (this.a.getScrollX() + i2 > 0) {
                i1 = -this.a.getScrollX();
              }
              this.a.scrollBy(i1, 0);
            }
          }
        }
      }
      else if ((this.d) && (this.n) && (this.t))
      {
        this.j = false;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("event.getRawX():");
          ((StringBuilder)localObject).append(paramMotionEvent.getRawX());
          ((StringBuilder)localObject).append("screenWidth:");
          ((StringBuilder)localObject).append(this.l);
          ((StringBuilder)localObject).append("mViewWidth:");
          ((StringBuilder)localObject).append(this.c);
          QLog.i("GuildLiveSwipeBackLayout", 2, ((StringBuilder)localObject).toString());
        }
        double d1 = paramMotionEvent.getRawX() - this.g;
        double d2 = this.l;
        Double.isNaN(d2);
        if (d1 >= d2 / 2.0D)
        {
          this.u = true;
          if (this.a.getScrollX() != 0) {
            a();
          }
          localObject = this.x;
          if (localObject != null) {
            ((GuildLiveSwipeBackLayout.OnSwipeListener)localObject).c(false);
          }
        }
        else
        {
          postDelayed(new GuildLiveSwipeBackLayout.1(this), 50L);
          this.u = false;
        }
      }
      label539:
      if (this.n)
      {
        localObject = this.p;
        if (localObject != null) {
          return ((GestureDetector)localObject).onTouchEvent(paramMotionEvent);
        }
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    return true;
  }
  
  public void setOnPageSwipeListener(GuildLiveSwipeBackLayout.OnPageSwipeListener paramOnPageSwipeListener)
  {
    this.q = paramOnPageSwipeListener;
  }
  
  public void setOnSwipeListener(GuildLiveSwipeBackLayout.OnSwipeListener paramOnSwipeListener)
  {
    this.x = paramOnSwipeListener;
  }
  
  public void setReadyToSlide(boolean paramBoolean)
  {
    this.t = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.widget.GuildLiveSwipeBackLayout
 * JD-Core Version:    0.7.0.1
 */