package com.tencent.mobileqq.emosm.view;

import android.os.SystemClock;

class DragSortListView$SmoothAnimator
  implements Runnable
{
  protected long a;
  private float b;
  private float c;
  private float d;
  private float e;
  private float f;
  private float g;
  private boolean h;
  
  public DragSortListView$SmoothAnimator(DragSortListView paramDragSortListView, float paramFloat, int paramInt)
  {
    this.c = paramFloat;
    this.b = paramInt;
    paramFloat = this.c;
    float f1 = 1.0F / (paramFloat * 2.0F * (1.0F - paramFloat));
    this.g = f1;
    this.d = f1;
    this.e = (paramFloat / ((paramFloat - 1.0F) * 2.0F));
    this.f = (1.0F / (1.0F - paramFloat));
  }
  
  public float a(float paramFloat)
  {
    float f1 = this.c;
    if (paramFloat < f1) {
      return this.d * paramFloat * paramFloat;
    }
    if (paramFloat < 1.0F - f1) {
      return this.e + this.f * paramFloat;
    }
    f1 = this.g;
    paramFloat -= 1.0F;
    return 1.0F - f1 * paramFloat * paramFloat;
  }
  
  public void a() {}
  
  public void a(float paramFloat1, float paramFloat2) {}
  
  public void b() {}
  
  public void c()
  {
    this.a = SystemClock.uptimeMillis();
    this.h = false;
    a();
    this.this$0.post(this);
  }
  
  public void d()
  {
    this.h = true;
  }
  
  public void run()
  {
    if (this.h) {
      return;
    }
    float f1 = (float)(SystemClock.uptimeMillis() - this.a) / this.b;
    if (f1 >= 1.0F)
    {
      a(1.0F, 1.0F);
      b();
      return;
    }
    a(f1, a(f1));
    this.this$0.post(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortListView.SmoothAnimator
 * JD-Core Version:    0.7.0.1
 */