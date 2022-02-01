package com.tencent.widget;

class DynamicGridView$PreHoneycombCellAnimator
  implements DynamicGridView.SwitchCellAnimator
{
  private int b;
  private int c;
  
  public DynamicGridView$PreHoneycombCellAnimator(DynamicGridView paramDynamicGridView, int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.b = paramInt2;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    DynamicGridView localDynamicGridView = this.a;
    DynamicGridView.a(localDynamicGridView, DynamicGridView.c(localDynamicGridView) + this.b);
    localDynamicGridView = this.a;
    DynamicGridView.b(localDynamicGridView, DynamicGridView.d(localDynamicGridView) + this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.DynamicGridView.PreHoneycombCellAnimator
 * JD-Core Version:    0.7.0.1
 */