package com.tencent.mobileqq.emosm.view;

class DragSortListView$LiftAnimator
  extends DragSortListView.SmoothAnimator
{
  private float b;
  private float c;
  
  public void a()
  {
    this.b = this.this$0.g;
    this.c = this.this$0.k;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (this.this$0.h != 4)
    {
      d();
      return;
    }
    DragSortListView localDragSortListView = this.this$0;
    localDragSortListView.g = ((int)(this.c * paramFloat2 + (1.0F - paramFloat2) * this.b));
    localDragSortListView.a.y = (this.this$0.r - this.this$0.g);
    this.this$0.b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortListView.LiftAnimator
 * JD-Core Version:    0.7.0.1
 */