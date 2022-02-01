package com.tencent.widget;

class ListView$FocusSelector
  implements Runnable
{
  private int mPosition;
  private int mPositionTop;
  
  private ListView$FocusSelector(ListView paramListView) {}
  
  public void run()
  {
    this.this$0.setSelectionFromTop(this.mPosition, this.mPositionTop);
  }
  
  public FocusSelector setup(int paramInt1, int paramInt2)
  {
    this.mPosition = paramInt1;
    this.mPositionTop = paramInt2;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.ListView.FocusSelector
 * JD-Core Version:    0.7.0.1
 */