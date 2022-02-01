package com.tencent.mobileqq.kandian.base.view.widget;

class ReadInJoyDynamicGridView$PreHoneycombCellAnimator
  implements ReadInJoyDynamicGridView.SwitchCellAnimator
{
  private int b;
  private int c;
  
  public ReadInJoyDynamicGridView$PreHoneycombCellAnimator(ReadInJoyDynamicGridView paramReadInJoyDynamicGridView, int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.b = paramInt2;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ReadInJoyDynamicGridView localReadInJoyDynamicGridView = this.a;
    ReadInJoyDynamicGridView.a(localReadInJoyDynamicGridView, ReadInJoyDynamicGridView.c(localReadInJoyDynamicGridView) + this.b);
    localReadInJoyDynamicGridView = this.a;
    ReadInJoyDynamicGridView.b(localReadInJoyDynamicGridView, ReadInJoyDynamicGridView.d(localReadInJoyDynamicGridView) + this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyDynamicGridView.PreHoneycombCellAnimator
 * JD-Core Version:    0.7.0.1
 */