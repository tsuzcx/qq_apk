package com.tencent.mobileqq.emosm.view;

class DragSortListView$LiftAnimator
  extends DragSortListView.SmoothAnimator
{
  private float a;
  private float b;
  
  public void a()
  {
    this.a = this.this$0.f;
    this.b = this.this$0.j;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (this.this$0.g != 4)
    {
      d();
      return;
    }
    this.this$0.f = ((int)(this.b * paramFloat2 + (1.0F - paramFloat2) * this.a));
    this.this$0.a.y = (this.this$0.k - this.this$0.f);
    this.this$0.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortListView.LiftAnimator
 * JD-Core Version:    0.7.0.1
 */