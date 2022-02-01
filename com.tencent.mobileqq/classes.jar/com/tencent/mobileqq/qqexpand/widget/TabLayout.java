package com.tencent.mobileqq.qqexpand.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class TabLayout
  extends HorizontalScrollView
{
  protected float a;
  protected float b;
  protected float c;
  protected float d;
  private LinearLayout e;
  private TabLayout.TabAdapter f;
  
  public TabLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    setOverScrollMode(2);
    setHorizontalScrollBarEnabled(false);
    this.e = new LinearLayout(getContext());
    this.e.setOrientation(0);
    addView(this.e, new ViewGroup.LayoutParams(-1, -1));
  }
  
  public void a(TabLayout.TabAdapter paramTabAdapter)
  {
    if (paramTabAdapter != null)
    {
      int m = paramTabAdapter.a();
      if (m <= 0) {
        return;
      }
      this.f = paramTabAdapter;
      this.e.removeAllViews();
      int i = paramTabAdapter.b();
      int j = 1;
      int k = 0;
      if (m <= i)
      {
        setFillViewport(true);
        i = 0;
      }
      else
      {
        i = paramTabAdapter.c();
        setFillViewport(false);
        j = 0;
      }
      while (k < m)
      {
        View localView = paramTabAdapter.a(k);
        if (localView != null)
        {
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, -1, j);
          Rect localRect = paramTabAdapter.b(k);
          localLayoutParams.leftMargin = localRect.left;
          localLayoutParams.topMargin = localRect.top;
          localLayoutParams.rightMargin = localRect.right;
          localLayoutParams.bottomMargin = localRect.bottom;
          this.e.addView(localView, localLayoutParams);
        }
        k += 1;
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    boolean bool = true;
    if (i != 0)
    {
      if ((i != 1) && (i == 2))
      {
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        this.a += Math.abs(f1 - this.c);
        this.b += Math.abs(f2 - this.d);
        this.c = f1;
        this.d = f2;
        ViewParent localViewParent = getParent();
        if (this.a <= this.b) {
          bool = false;
        }
        localViewParent.requestDisallowInterceptTouchEvent(bool);
      }
    }
    else
    {
      this.b = 0.0F;
      this.a = 0.0F;
      this.c = paramMotionEvent.getX();
      this.d = paramMotionEvent.getY();
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public ViewGroup getContentView()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.TabLayout
 * JD-Core Version:    0.7.0.1
 */