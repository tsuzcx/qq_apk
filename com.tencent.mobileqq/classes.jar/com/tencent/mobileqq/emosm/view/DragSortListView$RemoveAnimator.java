package com.tencent.mobileqq.emosm.view;

import android.graphics.Point;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

class DragSortListView$RemoveAnimator
  extends DragSortListView.SmoothAnimator
{
  private float b;
  private float c;
  private float d;
  private int e = -1;
  private int f = -1;
  private int g;
  private int h;
  private int i;
  
  public DragSortListView$RemoveAnimator(DragSortListView paramDragSortListView, float paramFloat, int paramInt)
  {
    super(paramDragSortListView, paramFloat, paramInt);
  }
  
  public void a()
  {
    int j = -1;
    this.e = -1;
    this.f = -1;
    this.g = this.this$0.d;
    this.h = this.this$0.e;
    this.i = this.this$0.f;
    DragSortListView localDragSortListView = this.this$0;
    localDragSortListView.h = 1;
    this.b = localDragSortListView.a.x;
    if (this.this$0.t)
    {
      float f1 = this.this$0.getWidth() * 2.0F;
      if (this.this$0.u == 0.0F)
      {
        localDragSortListView = this.this$0;
        if (this.b >= 0.0F) {
          j = 1;
        }
        localDragSortListView.u = (j * f1);
        return;
      }
      f1 *= 2.0F;
      if (this.this$0.u < 0.0F)
      {
        float f2 = this.this$0.u;
        float f3 = -f1;
        if (f2 > f3)
        {
          this.this$0.u = f3;
          return;
        }
      }
      if ((this.this$0.u > 0.0F) && (this.this$0.u < f1)) {
        this.this$0.u = f1;
      }
    }
    else
    {
      this.this$0.c();
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    paramFloat1 = 1.0F - paramFloat2;
    int k = this.this$0.getFirstVisiblePosition();
    View localView = this.this$0.getChildAt(this.g - k);
    Object localObject;
    if (this.this$0.t)
    {
      float f1 = (float)(SystemClock.uptimeMillis() - this.a) / 1000.0F;
      if (f1 == 0.0F) {
        return;
      }
      float f2 = this.this$0.u;
      int m = this.this$0.getWidth();
      localObject = this.this$0;
      float f3 = ((DragSortListView)localObject).u;
      if (this.this$0.u > 0.0F) {
        j = 1;
      } else {
        j = -1;
      }
      float f4 = j;
      paramFloat2 = m;
      ((DragSortListView)localObject).u = (f3 + f4 * f1 * paramFloat2);
      this.b += f2 * f1;
      localObject = this.this$0.a;
      f1 = this.b;
      ((Point)localObject).x = ((int)f1);
      if ((f1 < paramFloat2) && (f1 > -m))
      {
        this.a = SystemClock.uptimeMillis();
        this.this$0.b(true);
        return;
      }
    }
    if (localView != null)
    {
      if (this.e == -1)
      {
        this.e = DragSortListView.b(this.this$0, this.g, localView, false);
        this.c = (localView.getHeight() - this.e);
      }
      j = Math.max((int)(this.c * paramFloat1), 1);
      localObject = localView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = (this.e + j);
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    int j = this.h;
    if (j != this.g)
    {
      localView = this.this$0.getChildAt(j - k);
      if (localView != null)
      {
        if (this.f == -1)
        {
          this.f = DragSortListView.b(this.this$0, this.h, localView, false);
          this.d = (localView.getHeight() - this.f);
        }
        j = Math.max((int)(paramFloat1 * this.d), 1);
        localObject = localView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = (this.f + j);
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  public void b()
  {
    DragSortListView.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortListView.RemoveAnimator
 * JD-Core Version:    0.7.0.1
 */