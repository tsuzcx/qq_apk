package com.tencent.widget;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DynamicGridView$6
  implements AbsListView.OnScrollListener
{
  private int b = -1;
  private int c = -1;
  private int d;
  private int e;
  private int f;
  
  DynamicGridView$6(DynamicGridView paramDynamicGridView) {}
  
  private void c()
  {
    if ((this.e > 0) && (this.f == 0))
    {
      if ((DynamicGridView.h(this.a)) && (DynamicGridView.i(this.a)))
      {
        DynamicGridView.j(this.a);
        return;
      }
      if (DynamicGridView.k(this.a)) {
        DynamicGridView.l(this.a);
      }
    }
  }
  
  public void a()
  {
    if ((this.d != this.b) && (DynamicGridView.h(this.a)) && (DynamicGridView.f(this.a) != -1L))
    {
      DynamicGridView localDynamicGridView = this.a;
      DynamicGridView.a(localDynamicGridView, DynamicGridView.f(localDynamicGridView));
      DynamicGridView.m(this.a);
    }
  }
  
  public void b()
  {
    if ((this.d + this.e != this.b + this.c) && (DynamicGridView.h(this.a)) && (DynamicGridView.f(this.a) != -1L))
    {
      DynamicGridView localDynamicGridView = this.a;
      DynamicGridView.a(localDynamicGridView, DynamicGridView.f(localDynamicGridView));
      DynamicGridView.m(this.a);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.d = paramInt1;
    this.e = paramInt2;
    int j = this.b;
    int i = j;
    if (j == -1) {
      i = this.d;
    }
    this.b = i;
    j = this.c;
    i = j;
    if (j == -1) {
      i = this.e;
    }
    this.c = i;
    a();
    b();
    this.b = this.d;
    this.c = this.e;
    if (DynamicGridView.g(this.a) != null) {
      DynamicGridView.g(this.a).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    EventCollector.getInstance().onListScrollStateChanged(paramAbsListView, paramInt);
    this.f = paramInt;
    DynamicGridView.c(this.a, paramInt);
    c();
    if (DynamicGridView.g(this.a) != null) {
      DynamicGridView.g(this.a).onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.DynamicGridView.6
 * JD-Core Version:    0.7.0.1
 */