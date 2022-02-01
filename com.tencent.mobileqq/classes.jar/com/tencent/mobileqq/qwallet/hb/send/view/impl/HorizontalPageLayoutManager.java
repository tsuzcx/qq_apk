package com.tencent.mobileqq.qwallet.hb.send.view.impl;

import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.Recycler;
import androidx.recyclerview.widget.RecyclerView.State;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public class HorizontalPageLayoutManager
  extends RecyclerView.LayoutManager
{
  private int a = 0;
  private int b = 0;
  private int c;
  private int d;
  private int e = 0;
  private int f = 0;
  private int g;
  private int h;
  private int i = 0;
  private int j;
  private int k;
  private int l;
  private SparseArray<Rect> m = new SparseArray();
  
  public HorizontalPageLayoutManager(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 <= 0) {
      paramInt1 = ViewUtils.dip2px(330.0F);
    }
    this.c = paramInt1;
    if (paramInt2 <= 0) {
      paramInt2 = ViewUtils.dip2px(140.0F);
    }
    this.d = paramInt2;
    if (paramInt3 > 0) {
      paramInt1 = paramInt3;
    } else {
      paramInt1 = 2;
    }
    this.g = paramInt1;
    if (paramInt4 > 0) {
      paramInt1 = paramInt4;
    } else {
      paramInt1 = 3;
    }
    this.h = paramInt1;
    this.j = (paramInt3 * paramInt4);
  }
  
  private void a(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (paramState.isPreLayout()) {
      return;
    }
    paramState = new Rect(getPaddingLeft() + this.b, getPaddingTop(), getWidth() - getPaddingLeft() - getPaddingRight() + this.b, getHeight() - getPaddingTop() - getPaddingBottom());
    Object localObject1 = new Rect();
    int i2 = 0;
    int n = 0;
    int i1;
    Object localObject2;
    for (;;)
    {
      i1 = i2;
      if (n >= getChildCount()) {
        break;
      }
      localObject2 = getChildAt(n);
      ((Rect)localObject1).left = getDecoratedLeft((View)localObject2);
      ((Rect)localObject1).top = getDecoratedTop((View)localObject2);
      ((Rect)localObject1).right = getDecoratedRight((View)localObject2);
      ((Rect)localObject1).bottom = getDecoratedBottom((View)localObject2);
      if (!Rect.intersects(paramState, (Rect)localObject1)) {
        removeAndRecycleView((View)localObject2, paramRecycler);
      }
      n += 1;
    }
    while (i1 < getItemCount())
    {
      if (Rect.intersects(paramState, (Rect)this.m.get(i1)))
      {
        localObject1 = paramRecycler.getViewForPosition(i1);
        addView((View)localObject1);
        measureChildWithMargins((View)localObject1, this.k, this.l);
        localObject2 = (Rect)this.m.get(i1);
        layoutDecorated((View)localObject1, ((Rect)localObject2).left - this.b, ((Rect)localObject2).top, ((Rect)localObject2).right - this.b, ((Rect)localObject2).bottom);
      }
      i1 += 1;
    }
  }
  
  private void a(RecyclerView.State paramState)
  {
    int i1 = paramState.getItemCount() / this.j;
    int n;
    if (paramState.getItemCount() % this.j == 0) {
      n = 0;
    } else {
      n = 1;
    }
    this.i = (i1 + n);
  }
  
  public boolean canScrollHorizontally()
  {
    return true;
  }
  
  public int computeHorizontalScrollExtent(RecyclerView.State paramState)
  {
    return getWidth();
  }
  
  public int computeHorizontalScrollOffset(RecyclerView.State paramState)
  {
    return this.b;
  }
  
  public int computeHorizontalScrollRange(RecyclerView.State paramState)
  {
    a(paramState);
    return (this.i - 1) * getWidth();
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    return new RecyclerView.LayoutParams(-1, -2);
  }
  
  public void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.Recycler paramRecycler)
  {
    super.onDetachedFromWindow(paramRecyclerView, paramRecycler);
    this.b = 0;
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (getItemCount() == 0)
    {
      removeAndRecycleAllViews(paramRecycler);
      return;
    }
    if (paramState.isPreLayout()) {
      return;
    }
    int i1 = this.c;
    int n = this.h;
    this.e = (i1 / n);
    i1 = this.d;
    int i2 = this.g;
    this.f = (i1 / i2);
    this.k = ((n - 1) * this.e);
    this.l = ((i2 - 1) * this.f);
    a(paramState);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("itemCount:");
      ((StringBuilder)localObject).append(getItemCount());
      ((StringBuilder)localObject).append(",itemWidth: ");
      ((StringBuilder)localObject).append(this.e);
      ((StringBuilder)localObject).append(",itemHeight: ");
      ((StringBuilder)localObject).append(this.f);
      ((StringBuilder)localObject).append(",pageSize=");
      ((StringBuilder)localObject).append(this.i);
      QLog.i("HorizontalPageLayoutManager", 2, ((StringBuilder)localObject).toString());
    }
    this.a = ((this.i - 1) * getWidth());
    detachAndScrapAttachedViews(paramRecycler);
    int i5 = getItemCount();
    for (n = 0; n < this.i; n = i1 + 1)
    {
      i2 = 0;
      i1 = n;
      n = i2;
      while (n < this.g)
      {
        i2 = 0;
        int i3;
        int i4;
        for (;;)
        {
          int i6 = this.h;
          i3 = n;
          i4 = i1;
          if (i2 >= i6) {
            break;
          }
          i3 = this.j * i1 + i6 * n + i2;
          if (i3 == i5)
          {
            i3 = this.g;
            i4 = this.i;
            break;
          }
          localObject = paramRecycler.getViewForPosition(i3);
          addView((View)localObject);
          measureChildWithMargins((View)localObject, this.k, this.l);
          i4 = getDecoratedMeasuredWidth((View)localObject);
          i6 = getDecoratedMeasuredHeight((View)localObject);
          Rect localRect = (Rect)this.m.get(i3);
          localObject = localRect;
          if (localRect == null) {
            localObject = new Rect();
          }
          int i7 = this.c * i1 + this.e * i2;
          int i8 = this.f * n;
          ((Rect)localObject).set(i7, i8, i4 + i7, i6 + i8);
          this.m.put(i3, localObject);
          i2 += 1;
        }
        n = i3 + 1;
        i1 = i4;
      }
      removeAndRecycleAllViews(paramRecycler);
    }
    a(paramRecycler, paramState);
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    detachAndScrapAttachedViews(paramRecycler);
    int n = this.b;
    int i1 = n + paramInt;
    int i2 = this.a;
    if (i1 > i2) {
      paramInt = i2 - n;
    } else if (i1 < 0) {
      paramInt = 0 - n;
    }
    this.b += paramInt;
    offsetChildrenHorizontal(-paramInt);
    a(paramRecycler, paramState);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.view.impl.HorizontalPageLayoutManager
 * JD-Core Version:    0.7.0.1
 */