package com.tencent.mobileqq.kandian.base.view.widget;

import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class ReadInJoyDynamicGridView$6
  implements AbsListView.OnScrollListener
{
  private int b = -1;
  private int c = -1;
  private int d;
  private int e;
  private int f;
  
  ReadInJoyDynamicGridView$6(ReadInJoyDynamicGridView paramReadInJoyDynamicGridView) {}
  
  private void c()
  {
    if ((this.e > 0) && (this.f == 0))
    {
      if ((ReadInJoyDynamicGridView.h(this.a)) && (ReadInJoyDynamicGridView.i(this.a)))
      {
        ReadInJoyDynamicGridView.j(this.a);
        return;
      }
      if (ReadInJoyDynamicGridView.k(this.a)) {
        ReadInJoyDynamicGridView.l(this.a);
      }
    }
  }
  
  public void a()
  {
    if ((this.d != this.b) && (ReadInJoyDynamicGridView.h(this.a)) && (ReadInJoyDynamicGridView.f(this.a) != -1L))
    {
      ReadInJoyDynamicGridView localReadInJoyDynamicGridView = this.a;
      ReadInJoyDynamicGridView.a(localReadInJoyDynamicGridView, ReadInJoyDynamicGridView.f(localReadInJoyDynamicGridView));
      ReadInJoyDynamicGridView.m(this.a);
    }
  }
  
  public void b()
  {
    if ((this.d + this.e != this.b + this.c) && (ReadInJoyDynamicGridView.h(this.a)) && (ReadInJoyDynamicGridView.f(this.a) != -1L))
    {
      ReadInJoyDynamicGridView localReadInJoyDynamicGridView = this.a;
      ReadInJoyDynamicGridView.a(localReadInJoyDynamicGridView, ReadInJoyDynamicGridView.f(localReadInJoyDynamicGridView));
      ReadInJoyDynamicGridView.m(this.a);
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
    if (ReadInJoyDynamicGridView.g(this.a) != null) {
      ReadInJoyDynamicGridView.g(this.a).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.f = paramInt;
    ReadInJoyDynamicGridView.c(this.a, paramInt);
    c();
    if (ReadInJoyDynamicGridView.g(this.a) != null) {
      ReadInJoyDynamicGridView.g(this.a).onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyDynamicGridView.6
 * JD-Core Version:    0.7.0.1
 */