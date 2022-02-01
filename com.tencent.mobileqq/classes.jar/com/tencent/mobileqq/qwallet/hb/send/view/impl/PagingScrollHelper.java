package com.tencent.mobileqq.qwallet.hb.send.view.impl;

import android.animation.ValueAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;

public class PagingScrollHelper
{
  PagingScrollHelper.onPageChangeListener a;
  private ValueAnimator b = null;
  private RecyclerView c = null;
  private PagingScrollHelper.MyOnScrollListener d = new PagingScrollHelper.MyOnScrollListener(this);
  private PagingScrollHelper.MyOnFlingListener e = new PagingScrollHelper.MyOnFlingListener(this);
  private int f = 0;
  private int g = 0;
  private int h = 0;
  private int i = 0;
  private PagingScrollHelper.ORIENTATION j = PagingScrollHelper.ORIENTATION.HORIZONTAL;
  private PagingScrollHelper.MyOnTouchListener k = new PagingScrollHelper.MyOnTouchListener(this);
  private boolean l = true;
  
  private int b()
  {
    if ((this.c.getHeight() != 0) && (this.c.getWidth() != 0))
    {
      if (this.j == PagingScrollHelper.ORIENTATION.VERTICAL) {
        return this.f / this.c.getHeight();
      }
      return this.g / this.c.getWidth();
    }
    return 0;
  }
  
  private int c()
  {
    if ((this.c.getHeight() != 0) && (this.c.getWidth() != 0))
    {
      if (this.j == PagingScrollHelper.ORIENTATION.VERTICAL) {
        return this.h / this.c.getHeight();
      }
      return this.i / this.c.getWidth();
    }
    return 0;
  }
  
  public void a()
  {
    Object localObject = this.c.getLayoutManager();
    if (localObject != null)
    {
      if (((RecyclerView.LayoutManager)localObject).canScrollVertically()) {
        this.j = PagingScrollHelper.ORIENTATION.VERTICAL;
      } else if (((RecyclerView.LayoutManager)localObject).canScrollHorizontally()) {
        this.j = PagingScrollHelper.ORIENTATION.HORIZONTAL;
      } else {
        this.j = PagingScrollHelper.ORIENTATION.NULL;
      }
      localObject = this.b;
      if (localObject != null) {
        ((ValueAnimator)localObject).cancel();
      }
      this.i = 0;
      this.h = 0;
      this.g = 0;
      this.f = 0;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.b == null) {
      this.e.onFling(0, 0);
    }
    if (this.b != null)
    {
      int m;
      if (this.j == PagingScrollHelper.ORIENTATION.VERTICAL) {
        m = this.f;
      } else {
        m = this.g;
      }
      int n;
      if (this.j == PagingScrollHelper.ORIENTATION.VERTICAL) {
        n = this.c.getHeight();
      } else {
        n = this.c.getWidth();
      }
      paramInt = n * paramInt;
      if (m != paramInt)
      {
        this.b.setIntValues(new int[] { m, paramInt });
        this.b.start();
      }
    }
  }
  
  public void a(RecyclerView paramRecyclerView)
  {
    if (paramRecyclerView != null)
    {
      this.c = paramRecyclerView;
      paramRecyclerView.setOnFlingListener(this.e);
      paramRecyclerView.setOnScrollListener(this.d);
      paramRecyclerView.setOnTouchListener(this.k);
      a();
      return;
    }
    throw new IllegalArgumentException("recycleView must be not null");
  }
  
  public void a(PagingScrollHelper.onPageChangeListener paramonPageChangeListener)
  {
    this.a = paramonPageChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.view.impl.PagingScrollHelper
 * JD-Core Version:    0.7.0.1
 */