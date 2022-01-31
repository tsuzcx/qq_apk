package com.tencent.widget;

class ListView$FocusSelector
  implements Runnable
{
  private int a;
  private int b;
  
  private ListView$FocusSelector(ListView paramListView) {}
  
  public FocusSelector a(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    return this;
  }
  
  public void run()
  {
    this.this$0.setSelectionFromTop(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.widget.ListView.FocusSelector
 * JD-Core Version:    0.7.0.1
 */