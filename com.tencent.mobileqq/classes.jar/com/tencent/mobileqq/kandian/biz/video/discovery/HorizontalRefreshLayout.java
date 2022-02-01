package com.tencent.mobileqq.kandian.biz.video.discovery;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.util.DisplayUtil;

public class HorizontalRefreshLayout
  extends FrameLayout
{
  private HorizontalRefreshLayout.RefreshHeader a;
  private View b;
  private View c;
  private HorizontalRefreshLayout.OnDraggingListener d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private float j = 0.0F;
  private float k;
  private int l = DisplayUtil.a(getContext(), 25.0F);
  
  public HorizontalRefreshLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public HorizontalRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HorizontalRefreshLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void b()
  {
    if (this.b == null)
    {
      int m = 0;
      while (m < getChildCount())
      {
        View localView = getChildAt(m);
        if (!localView.equals(this.c))
        {
          this.b = localView;
          return;
        }
        m += 1;
      }
    }
  }
  
  private void c()
  {
    View localView = this.b;
    if ((localView != null) && (this.c != null))
    {
      localView.animate().translationX(0.0F).setDuration(500L).setListener(new HorizontalRefreshLayout.1(this)).start();
      this.c.animate().translationX(this.e).setDuration(500L).start();
    }
  }
  
  private void setRightHeadView(View paramView)
  {
    if (paramView != null)
    {
      this.c = paramView;
      ((FrameLayout.LayoutParams)this.c.getLayoutParams()).gravity = 8388613;
      addView(this.c, 0);
    }
  }
  
  public boolean a()
  {
    return ViewCompat.canScrollHorizontally(this.b, 1);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int m = (int)paramMotionEvent.getX();
    int n = (int)paramMotionEvent.getY();
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if (i1 != 2)
      {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
      else
      {
        i1 = m - this.g;
        int i2 = this.h;
        this.g = m;
        this.i = m;
        if (Math.abs(i1) >= Math.abs(n - i2))
        {
          if ((this.c != null) && (i1 < 0) && (!a()))
          {
            getParent().requestDisallowInterceptTouchEvent(true);
            return true;
          }
          getParent().requestDisallowInterceptTouchEvent(true);
        }
        else
        {
          getParent().requestDisallowInterceptTouchEvent(false);
        }
      }
    }
    else
    {
      this.g = m;
      this.i = m;
      this.h = n;
      if (m > this.l) {
        getParent().requestDisallowInterceptTouchEvent(true);
      } else {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getChildCount() == 0) {
      return;
    }
    if (this.b == null)
    {
      b();
      if (this.b == null) {
        return;
      }
    }
    View localView = this.c;
    if (localView != null) {
      localView.setTranslationX(this.e);
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    View localView = this.c;
    if (localView != null)
    {
      this.e = localView.getMeasuredWidth();
      this.f = this.e;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int m = (int)paramMotionEvent.getX();
    int n = paramMotionEvent.getAction();
    if (n != 0)
    {
      if (n != 1) {
        if (n != 2)
        {
          if (n != 3) {
            break label259;
          }
        }
        else
        {
          n = this.i;
          this.i = m;
          float f1 = m - n;
          float f2 = Math.abs(this.j / this.f);
          this.j += f1 * (1.0F - f2);
          f1 = this.j;
          if (f1 >= 0.0F)
          {
            this.j = 0.0F;
            this.b.setTranslationX(0.0F);
            return false;
          }
          m = this.f;
          if (f1 <= -m)
          {
            this.j = (-m);
            this.b.setTranslationX(this.j);
            this.c.setTranslationX(this.e + this.j);
            return false;
          }
          this.b.setTranslationX(f1);
          this.c.setTranslationX(this.e + this.j);
          this.k = Math.abs(this.j / this.e);
          return false;
        }
      }
      this.g = 0;
      this.i = 0;
      HorizontalRefreshLayout.OnDraggingListener localOnDraggingListener = this.d;
      if (localOnDraggingListener != null) {
        localOnDraggingListener.a(this.k, this.c, this);
      }
      c();
    }
    else
    {
      this.i = m;
    }
    label259:
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setOnDraggingListener(HorizontalRefreshLayout.OnDraggingListener paramOnDraggingListener)
  {
    this.d = paramOnDraggingListener;
  }
  
  public void setRefreshHeader(HorizontalRefreshLayout.RefreshHeader paramRefreshHeader)
  {
    this.a = paramRefreshHeader;
    setRightHeadView(this.a.a(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.discovery.HorizontalRefreshLayout
 * JD-Core Version:    0.7.0.1
 */