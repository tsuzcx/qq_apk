package com.tencent.mobileqq.kandian.base.view.widget;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class ReadInJoyNinePicDeliverDynamicGridView$6
  implements AbsListView.OnScrollListener
{
  private int b = -1;
  private int c = -1;
  private int d;
  private int e;
  private int f;
  
  ReadInJoyNinePicDeliverDynamicGridView$6(ReadInJoyNinePicDeliverDynamicGridView paramReadInJoyNinePicDeliverDynamicGridView) {}
  
  private void c()
  {
    if ((this.e > 0) && (this.f == 0))
    {
      if ((ReadInJoyNinePicDeliverDynamicGridView.h(this.a)) && (ReadInJoyNinePicDeliverDynamicGridView.i(this.a)))
      {
        ReadInJoyNinePicDeliverDynamicGridView.j(this.a);
        return;
      }
      if (ReadInJoyNinePicDeliverDynamicGridView.k(this.a)) {
        ReadInJoyNinePicDeliverDynamicGridView.l(this.a);
      }
    }
  }
  
  public void a()
  {
    if ((this.d != this.b) && (ReadInJoyNinePicDeliverDynamicGridView.h(this.a)) && (ReadInJoyNinePicDeliverDynamicGridView.f(this.a) != -1L))
    {
      ReadInJoyNinePicDeliverDynamicGridView localReadInJoyNinePicDeliverDynamicGridView = this.a;
      ReadInJoyNinePicDeliverDynamicGridView.a(localReadInJoyNinePicDeliverDynamicGridView, ReadInJoyNinePicDeliverDynamicGridView.f(localReadInJoyNinePicDeliverDynamicGridView));
      ReadInJoyNinePicDeliverDynamicGridView.m(this.a);
    }
  }
  
  public void b()
  {
    if ((this.d + this.e != this.b + this.c) && (ReadInJoyNinePicDeliverDynamicGridView.h(this.a)) && (ReadInJoyNinePicDeliverDynamicGridView.f(this.a) != -1L))
    {
      ReadInJoyNinePicDeliverDynamicGridView localReadInJoyNinePicDeliverDynamicGridView = this.a;
      ReadInJoyNinePicDeliverDynamicGridView.a(localReadInJoyNinePicDeliverDynamicGridView, ReadInJoyNinePicDeliverDynamicGridView.f(localReadInJoyNinePicDeliverDynamicGridView));
      ReadInJoyNinePicDeliverDynamicGridView.m(this.a);
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
    if (ReadInJoyNinePicDeliverDynamicGridView.g(this.a) != null) {
      ReadInJoyNinePicDeliverDynamicGridView.g(this.a).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.f = paramInt;
    ReadInJoyNinePicDeliverDynamicGridView.c(this.a, paramInt);
    c();
    if (ReadInJoyNinePicDeliverDynamicGridView.g(this.a) != null) {
      ReadInJoyNinePicDeliverDynamicGridView.g(this.a).onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyNinePicDeliverDynamicGridView.6
 * JD-Core Version:    0.7.0.1
 */