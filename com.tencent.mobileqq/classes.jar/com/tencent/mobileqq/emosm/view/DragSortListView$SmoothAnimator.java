package com.tencent.mobileqq.emosm.view;

import android.os.SystemClock;

class DragSortListView$SmoothAnimator
  implements Runnable
{
  private float jdField_a_of_type_Float;
  protected long a;
  private boolean jdField_a_of_type_Boolean;
  private float b;
  private float c;
  private float d;
  private float e;
  private float f;
  
  public DragSortListView$SmoothAnimator(DragSortListView paramDragSortListView, float paramFloat, int paramInt)
  {
    this.b = paramFloat;
    this.jdField_a_of_type_Float = paramInt;
    paramFloat = 1.0F / (this.b * 2.0F * (1.0F - this.b));
    this.f = paramFloat;
    this.c = paramFloat;
    this.d = (this.b / ((this.b - 1.0F) * 2.0F));
    this.e = (1.0F / (1.0F - this.b));
  }
  
  public float a(float paramFloat)
  {
    if (paramFloat < this.b) {
      return this.c * paramFloat * paramFloat;
    }
    if (paramFloat < 1.0F - this.b) {
      return this.d + this.e * paramFloat;
    }
    return 1.0F - this.f * (paramFloat - 1.0F) * (paramFloat - 1.0F);
  }
  
  public void a() {}
  
  public void a(float paramFloat1, float paramFloat2) {}
  
  public void b() {}
  
  public void c()
  {
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Boolean = false;
    a();
    this.this$0.post(this);
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    float f1 = (float)(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) / this.jdField_a_of_type_Float;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortListView.SmoothAnimator
 * JD-Core Version:    0.7.0.1
 */